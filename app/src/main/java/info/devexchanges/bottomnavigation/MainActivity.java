package info.devexchanges.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View button1, button2, button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        button3 = findViewById(R.id.btn_3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    private void goToActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view == button1) {
            goToActivity(SimpleActivity.class);
        } else if (view == button2) {
            goToActivity(ChangeBackgroundActivity.class);
        } else {
            goToActivity(BehaviorActivity.class);
        }
    }
}
