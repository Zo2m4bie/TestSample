package sampletestingapp.research.com.sampletest.mvp.presenter;

import android.os.Bundle;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;
import sampletestingapp.research.com.sampletest.App;
import sampletestingapp.research.com.sampletest.EspressoIdlingResource;
import sampletestingapp.research.com.sampletest.mvp.model.IMainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.view.IMainScreenView;
import sampletestingapp.research.com.sampletest.other.Constants;
import sampletestingapp.research.com.sampletest.other.Item;

/**
 * Created by dima on 10/16/16.
 */
public class MainScreenPresenter implements IMainScreenPresenter {

    protected IMainScreenView mView;

    @Inject
    @Named(Constants.UI_THREAD)
    protected Scheduler mUiThread;

    @Inject
    @Named(Constants.IO_THREAD)
    protected Scheduler mIoThread;

    @Inject
    protected IMainScreenModel mModel;

    private ArrayList<Item> mItems;

    private CompositeSubscription mCompositeSubscription;

    public MainScreenPresenter(IMainScreenView view) {
        mView = view;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        App.getmAppComponent().inject(this);
        mCompositeSubscription = new CompositeSubscription();
        if(saveInstanceState != null){
            parseSaveInstanceState(saveInstanceState);
        } else {
            loadData();
        }
    }

    private void parseSaveInstanceState(Bundle saveInstanceState) {
        ArrayList<Item> items = saveInstanceState.getParcelableArrayList(Constants.ITEMS);
        if(items != null && items.size() != 0){
            mView.updateUI(items);
        } else {
            loadData();
        }
    }

    private void loadData() {
        EspressoIdlingResource.increment();
        Subscription subscription = Observable.create(new Observable.OnSubscribe<ArrayList<Item>>() {
            @Override
            public void call(Subscriber<? super ArrayList<Item>> subscriber) {
                subscriber.onNext(mModel.loadData());
                subscriber.onCompleted();
            }
        })
                .subscribeOn(mIoThread)
                .observeOn(mUiThread)
                .subscribe(new Action1<ArrayList<Item>>() {
                    @Override
                    public void call(ArrayList<Item> items) {
                        mItems = items;
                        mView.updateUI(items);
                        EspressoIdlingResource.decrement();
                    }
                });
        addSubscription(subscription);
    }

    public void addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putParcelableArrayList(Constants.ITEMS, mItems);
    }

    @Override
    public void onDestroy() {
        if(mCompositeSubscription != null){
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
        }
    }
}
