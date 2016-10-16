package sampletestingapp.research.com.sampletest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sampletestingapp.research.com.sampletest.di.component.DaggerSecondaryPresenterComponent;
import sampletestingapp.research.com.sampletest.di.component.SecondaryPresenterComponent;
import sampletestingapp.research.com.sampletest.di.module.SecondaryScreenPresenterModule;
import sampletestingapp.research.com.sampletest.mvp.presenter.ISecondaryScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.presenter.SecondaryScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.view.ISecondaryScreenView;
import sampletestingapp.research.com.sampletest.other.Constants;
import sampletestingapp.research.com.sampletest.other.Item;

/**
 * Created by dima on 10/16/16.
 */
public class SecondaryActivity extends AppCompatActivity implements ISecondaryScreenView {

    @Inject
    protected ISecondaryScreenPresenter mPresenter;

    @InjectView(R.id.item_id)
    protected TextView mId;

    @InjectView(R.id.text)
    protected TextView mText;
    private SecondaryPresenterComponent mSecondaryPresenterComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.inject(this);
        inject();
        mPresenter.onCreate(getIntent().getExtras(), savedInstanceState);
    }

    private void inject() {
        if(mSecondaryPresenterComponent == null){
            mSecondaryPresenterComponent = DaggerSecondaryPresenterComponent.builder().secondaryScreenPresenterModule(new SecondaryScreenPresenterModule(this)).build();
        }
        mSecondaryPresenterComponent.inject(this);
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

    public static Intent getInstance(Context context, Item item) {
        Intent intent = new Intent(context, SecondaryActivity.class);
        intent.putExtra(Constants.ITEM_ID, item.getId());
        return intent;
    }

    @Override
    public void updateUI(Item item) {
        if(item == null){
            mText.setText("Error");
            return;
        }
        mId.setText(String.valueOf(item.getId()));
        mText.setText(item.getTitle());
    }
}
