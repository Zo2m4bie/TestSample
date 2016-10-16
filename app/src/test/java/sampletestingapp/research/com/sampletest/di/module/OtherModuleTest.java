package sampletestingapp.research.com.sampletest.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sampletestingapp.research.com.sampletest.other.Constants;
import sampletestingapp.research.com.sampletest.other.Storage;

import static org.mockito.Mockito.mock;

/**
 * Created by dima on 10/16/16.
 */
@Module
public class OtherModuleTest {

    @Provides
    @Singleton
    public Storage provideStorage(){
        return mock(Storage.class);
    }

    @Provides
    @Singleton
    @Named(Constants.IO_THREAD)
    public Scheduler provideSchedulerIO(){
        return Schedulers.immediate();
    }

    @Provides
    @Singleton
    @Named(Constants.UI_THREAD)
    public Scheduler provideSchedulerUI(){
        return Schedulers.immediate();
    }
}
