package com.example.projectx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private LinearLayout mMainLayout;

    private ListFragment listFragment;
    private  ProductFragment productFragment;
    private MoreFragment moreFragment;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mMainLayout = (LinearLayout)findViewById(R.id.main_layout);
        mMainNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        listFragment = new ListFragment();
        productFragment = new ProductFragment();
        moreFragment = new MoreFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new ListFragment()).commit();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_list:
                        setFragment(listFragment);
                        return true;
                    case R.id.nav_product:
                        setFragment(productFragment);
                        return true;
                    case R.id.nav_more:
                        setFragment(moreFragment);
                        return true;
                    default: return false;
                }

            }
        });

    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_layout, fragment);
        fragmentTransaction.commit();


    }
}
