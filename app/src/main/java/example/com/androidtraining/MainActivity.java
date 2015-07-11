package example.com.androidtraining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.main_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton();
            }
        });
    }

    private void onClickButton() {

        Log.e(MainActivity.class.getCanonicalName(),"Test");
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
        /*
        getResources().getString(R.string.main_button_text)
         */
    }
}
