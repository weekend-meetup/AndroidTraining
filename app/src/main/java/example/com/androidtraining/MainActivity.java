package example.com.androidtraining;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("tag", "onCreate");
        TextView button = (TextView)findViewById(R.id.main_button);
        final Activity self = this;
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("tag", "onClick");
                ImageView hoge = (ImageView)findViewById(R.id.droid);
                int visibility = hoge.getVisibility();
                if(visibility == View.VISIBLE){
                    hoge.setVisibility(View.INVISIBLE);
                }else if(visibility == View.INVISIBLE){
                    hoge.setVisibility(View.VISIBLE);
                }

            }
        };
        button.setOnClickListener(listener);


    }
}
