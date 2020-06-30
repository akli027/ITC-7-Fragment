package com.example.my_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        loadFragment(new HomeFragment());

        bottomNavigationView = findViewById(R.id.btn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        loadFragment(new HomeFragment());
                        break;
                    case R.id.menu_profile:
                        loadFragment(new ProfileFragment());
                        break;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment ){
        FragmentManager fragmentManager  = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame, fragment).show(fragment).commit();


    }
}
