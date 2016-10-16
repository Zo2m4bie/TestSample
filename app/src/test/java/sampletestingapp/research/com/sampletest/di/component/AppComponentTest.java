package sampletestingapp.research.com.sampletest.di.component;

import javax.inject.Singleton;

import dagger.Component;
import sampletestingapp.research.com.sampletest.di.module.ModelsModuleTest;
import sampletestingapp.research.com.sampletest.di.module.OtherModuleTest;
import sampletestingapp.research.com.sampletest.mvp.presenter.MainScreenPresenterTest;

/**
 * Created by dima on 10/16/16.
 */
@Singleton
@Component(modules = {OtherModuleTest.class, ModelsModuleTest.class})
public interface AppComponentTest extends AppComponent {

    void inject(MainScreenPresenterTest test);

}
