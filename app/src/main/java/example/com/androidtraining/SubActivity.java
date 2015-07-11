package example.com.androidtraining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Keita on 2015/07/11.
 */
public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        View view = findViewById(R.id.main_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton();
            }
        });

        View view2 = findViewById(R.id.main_button2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButton2();
            }
        });
    }

    private void onClickButton() {
        finish();
    }
    private void onClickButton2() {

        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setMessage("開発中！");
        d.create().show();

    }
}
