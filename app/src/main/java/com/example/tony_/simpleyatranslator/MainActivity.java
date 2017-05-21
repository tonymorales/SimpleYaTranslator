package com.example.tony_.simpleyatranslator;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tony_.simpleyatranslator.UI.FragmentTranslation;
import com.example.tony_.simpleyatranslator.UI.FragmentTranslationHistory;
import com.example.tony_.simpleyatranslator.UI.TranslationFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.traslation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.history_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mViewPager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new FragmentTranslation()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new FragmentTranslation(), "Переводчик");
        adapter.addFragment(new TranslationFragment(), "Переводчик");
        adapter.addFragment(new FragmentTranslationHistory(), "История");
        viewPager.setAdapter(adapter);
    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitlesList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public  void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitlesList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitlesList.get(position);
        }
    }
}
