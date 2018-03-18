package com.cakii.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomView = findViewById(R.id.bottom_view);
        bottomView.inflateMenu(R.menu.main_menu);
        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_one) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new DasboardFragment())
                            .commit();
                } else if (item.getItemId() == R.id.item_two) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new SettingFragment())
                            .commit();
                }
                return false;
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new DasboardFragment())
                .commit();
    }
}
