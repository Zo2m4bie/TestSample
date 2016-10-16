package sampletestingapp.research.com.sampletest.mvp.presenter;

import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;
import sampletestingapp.research.com.sampletest.App;
import sampletestingapp.research.com.sampletest.mvp.model.ISecondaryScreenModel;
import sampletestingapp.research.com.sampletest.mvp.view.ISecondaryScreenView;
import sampletestingapp.research.com.sampletest.other.Constants;
import sampletestingapp.research.com.sampletest.other.Item;

/**
 * Created by dima on 10/16/16.
 */
public class SecondaryScreenPresenter implements ISecondaryScreenPresenter {

    private ISecondaryScreenView mView;

    @Inject
    public ISecondaryScreenModel mModel;

    @Inject
    @Named(Constants.UI_THREAD)
    protected Scheduler mUiThread;

    @Inject
    @Named(Constants.IO_THREAD)
    protected Scheduler mIoThread;

    private CompositeSubscription mCompositeSubscription;
    private Item mItem;

    public SecondaryScreenPresenter(ISecondaryScreenView view) {
        mView = view;
    }

    @Override
    public void onCreate(Bundle args, Bundle saveInstanceState) {
        App.getmAppComponent().inject(this);
        mCompositeSubscription = new CompositeSubscription();
        if (saveInstanceState != null) {
            loadDataFromSaveInstanceState(saveInstanceState);
        } else {
            loadItem(args.getInt(Constants.ITEM_ID));
        }
    }

    private void loadDataFromSaveInstanceState(Bundle saveInstanceState) {
        mItem = saveInstanceState.getParcelable(Constants.ITEM);
        mView.updateUI(mItem);
    }

    private void loadItem(int id) {
        Subscription subscription = Observable.just(id).map(new Func1<Integer, Item>() {
            @Override
            public Item call(Integer id) {
                return mModel.loadItem(id);
            }
        }).subscribeOn(mIoThread)
                .observeOn(mUiThread)
                .subscribe(new Action1<Item>() {
                    @Override
                    public void call(Item item) {
                        mItem = item;
                        mView.updateUI(item);
                    }
                });
        addSubscription(subscription);
    }

    private void addSubscription(Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putParcelable(Constants.ITEM, mItem);
    }

    @Override
    public void onDestroy() {
        if(mCompositeSubscription != null){
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
        }
    }
}
