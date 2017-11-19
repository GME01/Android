package myapps.su_android1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button OK_boubou = findViewById(R.id.button);
        if (OK_boubou != null) {
            OK_boubou.setOnClickListener(changeLayout);
        }
    }

    private View.OnClickListener changeLayout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentDetail = new Intent (MainActivity.this, DetailsActivity.class);
            startActivity(intentDetail);
        }

    };

}
