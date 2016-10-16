package sampletestingapp.research.com.sampletest.di.module;

import dagger.Module;
import dagger.Provides;
import sampletestingapp.research.com.sampletest.App;
import sampletestingapp.research.com.sampletest.mvp.presenter.IMainScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.presenter.MainScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.view.IMainScreenView;

/**
 * Created by dima on 10/16/16.
 */
@Module
public class MainScreenPresenterModule {

    private IMainScreenView mView;

    public MainScreenPresenterModule(IMainScreenView view) {
        mView = view;
    }

    @Provides
    IMainScreenPresenter provideMainScreenPresenter(){
        return new MainScreenPresenter(mView);
    }

}
