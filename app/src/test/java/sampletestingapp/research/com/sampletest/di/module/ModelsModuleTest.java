package sampletestingapp.research.com.sampletest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sampletestingapp.research.com.sampletest.mvp.model.IMainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.ISecondaryScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.MainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.SecondaryScreenModel;

import static org.mockito.Mockito.mock;

/**
 * Created by dima on 10/16/16.
 */
@Module
public class ModelsModuleTest {
    @Singleton
    @Provides
    public IMainScreenModel provideMainScreenModule(){
        return mock(MainScreenModel.class);
    }
    @Singleton
    @Provides
    public ISecondaryScreenModel provideSecondaryScreenModule(){
        return mock(SecondaryScreenModel.class);
    }
}
