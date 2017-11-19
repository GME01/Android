package myapps.su_android1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Guillaume on 03/11/2017.
 */

public class DetailsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        Button CANCEL_Button = findViewById(R.id.cancel);
        if (CANCEL_Button != null) {
            CANCEL_Button.setOnClickListener(cancelLayout);
        }
        Button OK_Button = findViewById(R.id.ok);
        if (OK_Button != null) {
            OK_Button.setOnClickListener(okLayout);
        }

    }

    private View.OnClickListener cancelLayout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener okLayout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };



}

