package example.com.androidtraining;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private boolean bPushed = false;
    private Timer timer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView button = (TextView)findViewById(R.id.main_button);
        button.setText(getResources().getString(R.string.main_button_text));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton(v);
            }

        });
    }

    private void onClickButton(final View v) {
        Log.e(MainActivity.class.getCanonicalName(), "Button Pushed!");
        bPushed = !bPushed;
        if (bPushed) {
            ((TextView)v).setText(getResources().getString(R.string.main_button_text_running));
            timer = new Timer(true);
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            moveButton(v);
                        }
                    };
//                    Handler handler = new Handler(Looper.getMainLooper());
//                    handler.post(r);
                    v.post(r);
                }
            };
            timer.schedule(task, 0, 1000);
        } else {
            if (timer != null) {
                timer.cancel();
            }
            ((TextView)v).setText(getResources().getString(R.string.main_button_text));
        }
    }

    private void moveButton(View v) {
        View body = findViewById(R.id.body);
        int buttonWidth = v.getWidth();
        int buttonHeight = v.getHeight();

        int maxWidth = body.getWidth();
        int maxHeight = body.getHeight();
        float newPosX = (float)Math.random()* maxWidth;
        float newPosY = (float)Math.random()* maxHeight;

        if (maxWidth < newPosX+buttonWidth) {
            newPosX = maxWidth - buttonWidth;
        }
        if (maxHeight < newPosY+buttonHeight) {
            newPosY = maxHeight - buttonHeight;
        }

        ViewPropertyAnimator a = v.animate();
        float x = v.getTranslationX();
        float y = v.getTranslationY();
        a.x(newPosX);
        a.y(newPosY);
        Log.e("X", String.valueOf(newPosX));
        Log.e("Y", String.valueOf(newPosY));
        a.start();
    }

}
