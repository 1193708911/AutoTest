package supersports.com.newstablayout;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private Solo mSolo;

    @Before
    public void setUP() {
        mSolo = new Solo(InstrumentationRegistry.getInstrumentation(), mActivityTestRule.getActivity());

    }


    @Test
    public void testMainActivity() {
        Button button = (Button) mSolo.getView(R.id.button);
        mSolo.clickOnView(button);
        mSolo.waitForActivity(SecondActivity.class.getSimpleName());
        EditText mEditText = (EditText) mSolo.getView(R.id.et_text);

        mSolo.enterText(mEditText, "我要搜索中国好声音");

        mSolo.sleep(2000);
    }

    @After
    public void teerDown() {//善后工作
//        mSolo.finishOpenedActivities();

    }


    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("supersports.com.newstablayout", appContext.getPackageName());


    }
}
