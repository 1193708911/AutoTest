package supersports.com.newstablayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {


    /**
     * buton
     */
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);


        initView();

        try {
            Object invokeObject = Proxy.newProxyInstance(this.getClassLoader(), new Class[]{View.OnClickListener.class}, new MVokeHandler());
            Method onClickMethod = View.class.getMethod("setOnClickListener", View.OnClickListener.class);
            onClickMethod.invoke(mButton, invokeObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Subscribe
    public void event(Object object) {


    }


    class MVokeHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            EventBus.getDefault().post(new Object());
            Toast.makeText(MainActivity.this, "当前点击事件", Toast.LENGTH_LONG).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }, 5000);
            return null;
        }
    }


    private void initView() {
        mButton = (Button) findViewById(R.id.button);
    }
}
