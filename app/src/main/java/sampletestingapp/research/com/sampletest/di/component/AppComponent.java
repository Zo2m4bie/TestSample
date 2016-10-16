package sampletestingapp.research.com.sampletest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import sampletestingapp.research.com.sampletest.di.module.MainScreenPresenterModule;
import sampletestingapp.research.com.sampletest.di.module.ModelsModule;
import sampletestingapp.research.com.sampletest.di.module.OtherModule;
import sampletestingapp.research.com.sampletest.mvp.model.MainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.SecondaryScreenModel;
import sampletestingapp.research.com.sampletest.mvp.presenter.MainScreenPresenter;
import sampletestingapp.research.com.sampletest.mvp.presenter.SecondaryScreenPresenter;

/**
 * Created by dima on 10/16/16.
 */
@Singleton
@Component(modules = {ModelsModule.class, OtherModule.class})
public interface AppComponent {

    void inject(MainScreenPresenter presenter);

    void inject(SecondaryScreenPresenter presenter);

    void inject(MainScreenModel module);
    void inject(SecondaryScreenModel module);
}
