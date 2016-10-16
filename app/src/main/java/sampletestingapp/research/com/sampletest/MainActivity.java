package sampletestingapp.research.com.sampletest;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sampletestingapp.research.com.sampletest.adapter.MyArrayAdapter;
import sampletestingapp.research.com.sampletest.di.component.DaggerMainScreenPresenterComponent;
import sampletestingapp.research.com.sampletest.di.component.MainScreenPresenterComponent;
import sampletestingapp.research.com.sampletest.di.module.MainScreenPresenterModule;
import sampletestingapp.research.com.sampletest.mvp.presenter.IMainScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.presenter.MainScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.view.IMainScreenView;
import sampletestingapp.research.com.sampletest.other.Item;

public class MainActivity extends AppCompatActivity implements IMainScreenView{

    @InjectView(R.id.list_view)
    protected ListView mListView;

    @InjectView(R.id.error)
    protected TextView mError;

    private MyArrayAdapter mAdapter;

    @Inject
    protected IMainScreenPresenter mPresenter;
    private MainScreenPresenterComponent mMainScreenPresenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        inject();
        mAdapter = new MyArrayAdapter(this);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = mAdapter.getItem(position);
                startActivity(SecondaryActivity.getInstance(MainActivity.this, item));
            }
        });
        mPresenter.onCreate(savedInstanceState);
    }

    private void inject() {
        if(mMainScreenPresenterComponent == null) {
            mMainScreenPresenterComponent = DaggerMainScreenPresenterComponent.builder().mainScreenPresenterModule(new MainScreenPresenterModule(this)).build();
        }
        mMainScreenPresenterComponent.inject(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void updateUI(ArrayList<Item> items) {
        if(items == null || items.size() == 0){
            mError.setVisibility(View.VISIBLE);
        } else {
            mError.setVisibility(View.GONE);
            mAdapter.setItems(items);
            mAdapter.notifyDataSetChanged();
        }
    }
}
