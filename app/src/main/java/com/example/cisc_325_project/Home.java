package com.example.cisc_325_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {

    // held so that once updated by status selection screen, the change takes effect
    private static String mStatus = null;

    public static String getmStatus() {
        return mStatus;
    }

    public static void setmStatus(String status) {
        mStatus = status;
    }

    public static boolean hasStatus() {
        return mStatus != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // create the tab bar for the home screen
        TabLayout tabLayout = findViewById(R.id.home_screen_tab_bar);

        // give the home screen tabs labels
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_new_contact));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_friends_list));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_map));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager =findViewById(R.id.home_pager);
        final PageAdapter pageAdapter = new PageAdapter(
                getSupportFragmentManager(), tabLayout.getTabCount());



        // setup the parts to handle the detecting and changing of home tabs
        viewPager.setAdapter(pageAdapter);
        viewPager.setCurrentItem(1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Home.hasStatus()) {
            ((Button)findViewById(R.id.status_button)).setText(Home.getmStatus());
        }
    }

    public void loadStatusScreen(View view) {
        startActivity(new Intent(Home.this, statusSelectionActivity.class));
    }

    public void loadEventListScreen(View view) {
        startActivity(new Intent(Home.this, EventList.class));
    }

    public void loadProfileScreen(View view) {
        startActivity(new Intent(Home.this, Profile.class));
    }
}
