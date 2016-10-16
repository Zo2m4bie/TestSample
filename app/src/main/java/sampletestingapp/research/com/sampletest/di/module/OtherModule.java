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

/**
 * Created by dima on 10/16/16.
 */
@Module
public class OtherModule {

    @Provides
    @Singleton
    public Storage provideStorage(){
        return new Storage();
    }

    @Provides
    @Singleton
    @Named(Constants.IO_THREAD)
    public Scheduler provideSchedulerIO(){
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @Named(Constants.UI_THREAD)
    public Scheduler provideSchedulerUI(){
        return AndroidSchedulers.mainThread();
    }

}
