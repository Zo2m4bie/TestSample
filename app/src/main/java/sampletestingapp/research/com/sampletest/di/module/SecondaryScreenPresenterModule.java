package sampletestingapp.research.com.sampletest.di.module;

import dagger.Module;
import dagger.Provides;
import sampletestingapp.research.com.sampletest.mvp.presenter.ISecondaryScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.presenter.SecondaryScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.view.ISecondaryScreenView;

/**
 * Created by dima on 10/16/16.
 */
@Module
public class SecondaryScreenPresenterModule {

    ISecondaryScreenView mView;

    public SecondaryScreenPresenterModule(ISecondaryScreenView view) {
        mView = view;
    }

    @Provides
    ISecondaryScreenPresenter mProvideSecondarytPresenter(){
        return new SecondaryScreenPresenter(mView);
    }
}
