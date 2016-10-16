package sampletestingapp.research.com.sampletest;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsAnything.anything;
import static org.junit.Assert.*;

/**
 * Created by dima on 10/16/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp(){
        Espresso.registerIdlingResources(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void testSelectItem(){
        ViewInteraction list = onView(withId(R.id.list_view));
        list.check(new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if(!(view instanceof ListView)){
                    throw noViewFoundException;
                }
                ListView lv = (ListView)view;
                if(lv.getAdapter() == null ){
                    return;
                }
                assertThat(lv.getAdapter().getCount(), is(6));
            }
        });

        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).perform(click());
        onView(withId(R.id.item_id)).check(matches(withText("1")));
        onView(withId(R.id.text)).check(matches(withText("First")));
    }

    @After
    public void unregisterIdlingResource() {
        Espresso.unregisterIdlingResources(EspressoIdlingResource.getIdlingResource());
    }
}