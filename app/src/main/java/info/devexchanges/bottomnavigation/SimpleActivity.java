package info.devexchanges.bottomnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class SimpleActivity extends AppCompatActivity {

    private BottomBar mBottomBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        // Customize the colors here
        mBottomBar = BottomBar.attach(this, savedInstanceState,
                Color.parseColor("#f2f2f2"), // Background Color
                ContextCompat.getColor(this, R.color.colorAccent), // Tab Item Color
                0.25f); // Tab Item Alpha
        mBottomBar.setItems(R.menu.bottom_bar_menu);


        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {

            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                showToast(menuItemId, false);
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                showToast(menuItemId, true);
            }
        });
    }

    private void showToast(int menuId, boolean isReselected) {
        if (menuId == R.id.like) {
            if (isReselected) {
                show("Tab Like Reselected!");
            } else {
                show("You like this!");
            }
        } else if (menuId == R.id.love) {
            if (isReselected) {
                show("Tab Love Reselected!");
            } else show("You love this!");
        } else if (menuId == R.id.sad) {
            if (isReselected) {
                show("Tab Sad Reselected");
            } else show("You felt sad when reading this content!");
        } else if (isReselected) {
            show("Tab Angry Reselected!");
        } else show("You felt angry when reading this!");
    }

    private void show(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }
}
