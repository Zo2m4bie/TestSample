package sampletestingapp.research.com.sampletest.di.module;

import dagger.Module;
import dagger.Provides;
import sampletestingapp.research.com.sampletest.mvp.model.IMainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.ISecondaryScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.MainScreenModel;
import sampletestingapp.research.com.sampletest.mvp.model.SecondaryScreenModel;

/**
 * Created by dima on 10/16/16.
 */
@Module
public class ModelsModule {

    @Provides
    public IMainScreenModel provideMainScreenModule(){
        return new MainScreenModel();
    }
    @Provides
    public ISecondaryScreenModel provideSecondaryScreenModule(){
        return new SecondaryScreenModel();
    }

}
