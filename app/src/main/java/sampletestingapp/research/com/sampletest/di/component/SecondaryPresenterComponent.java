package sampletestingapp.research.com.sampletest.di.component;

import dagger.Component;
import sampletestingapp.research.com.sampletest.SecondaryActivity;
import sampletestingapp.research.com.sampletest.di.module.SecondaryScreenPresenterModule;

/**
 * Created by dima on 10/16/16.
 */
@Component(modules = SecondaryScreenPresenterModule.class)
public interface SecondaryPresenterComponent {

    void inject(SecondaryActivity activity);

}
