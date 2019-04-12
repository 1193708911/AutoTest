package supersports.com.newstablayout;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.robotium.solo.Solo;

import org.junit.Test;

/**
 * Created by rocky on 2019/4/9.
 */

public class MainTest extends ActivityInstrumentationTestCase2 {

    private Solo mSolo;

    public MainTest() {
        super(MainActivity.class);
    }

    @Test
    public void testMainActivity() {

        Button button = (Button) mSolo.getView(R.id.button);

        mSolo.clickOnView(button);

    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mSolo = new Solo(InstrumentationRegistry.getInstrumentation(), getActivity());
    }


    @Override
    protected void tearDown() throws Exception {
//        mSolo.finishOpenedActivities();
        super.tearDown();
    }
}
