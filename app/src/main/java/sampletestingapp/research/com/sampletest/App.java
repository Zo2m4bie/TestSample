package sampletestingapp.research.com.sampletest;

import android.app.Application;

import sampletestingapp.research.com.sampletest.di.component.AppComponent;
import sampletestingapp.research.com.sampletest.di.component.DaggerAppComponent;

/**
 * Created by dima on 10/16/16.
 */
public class App extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder().build();
    }

    public static AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
