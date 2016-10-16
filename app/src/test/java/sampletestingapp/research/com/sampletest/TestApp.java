package sampletestingapp.research.com.sampletest;

import sampletestingapp.research.com.sampletest.di.component.AppComponent;
import sampletestingapp.research.com.sampletest.di.component.DaggerAppComponent;
import sampletestingapp.research.com.sampletest.di.component.DaggerAppComponentTest;

/**
 * Created by dima on 10/16/16.
 */
public class TestApp extends App {

    @Override
    protected AppComponent buildComponent() {
        return DaggerAppComponentTest.builder().build();
    }
}
