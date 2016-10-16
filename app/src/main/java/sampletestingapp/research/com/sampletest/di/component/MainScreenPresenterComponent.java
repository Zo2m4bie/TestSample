package sampletestingapp.research.com.sampletest.di.component;

import dagger.Component;
import sampletestingapp.research.com.sampletest.MainActivity;
import sampletestingapp.research.com.sampletest.di.module.MainScreenPresenterModule;

/**
 * Created by dima on 10/16/16.
 */
@Component(modules = MainScreenPresenterModule.class)
public interface MainScreenPresenterComponent {

    void inject(MainActivity activity);
}
