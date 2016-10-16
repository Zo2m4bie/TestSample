package sampletestingapp.research.com.sampletest;

import android.support.test.espresso.IdlingResource;

/**
 * Created by dima on 10/13/16.
 */
public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleIdlingResource mCountingIdlingResource =
            new SimpleIdlingResource(RESOURCE);

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }
}