
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    val EXPECTED_NAME="TAG"
    private lateinit var decorView: View

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
  
    @Before
    fun setUp() {
       activityScenarioRule.scenario.onActivity {
            decorView= it.window.decorView
        }
    }
    @Test
    fun test_showDialog_captureNameInput(){
    
        //Check whether the button is visible or not then perform click
        onView(withId(R.id.button_launch_dialog)).perform(click())
        // Test if, toast is displayed       
        onView(withText(MainActivity.buildToastMessage(EXPECTED_NAME)))
            .inRoot(withDecorView(Matchers.not(decorView)))// Here you use decorView
            .check(matches(isDisplayed()));
    }
}
