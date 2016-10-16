package sampletestingapp.research.com.sampletest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import sampletestingapp.research.com.sampletest.di.component.AppComponentTest;

/**
 * Created by dima on 10/16/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = TestApp.class,
        constants = BuildConfig.class,
        sdk = 21)
@Ignore
public class BaseTest {

    protected AppComponentTest mComponent;
    protected TestUtils mTestUtils;

    @Before
    public void setUp(){
        mComponent = (AppComponentTest)App.getmAppComponent();
        mTestUtils = new TestUtils();
    }
}
