package com.example.finalexam;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int MAX_PAGE = 5;
    Fragment cur_fragment = new Fragment();
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));
        int today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 2;
        if (-1 < today || today < 5){
            viewPager.setCurrentItem(today);
        } else {
            Toast.makeText(this, "오늘은 학식이 존재하지 않습니다.", Toast.LENGTH_LONG).show();
            viewPager.setCurrentItem(0);
        }
        DataBaseManager manager = new DataBaseManager(this, "Menu.db", null, 2);
        database = manager.getWritableDatabase();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.suwon.ac.kr/community/listConvenienceMenu.do"));
                startActivity(intent);
            }
        });
    }

    private class adapter extends FragmentPagerAdapter {
        adapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            if (position < 0 || MAX_PAGE <= position)
                return null;
            switch (position) {
                case 0:
                    cur_fragment = new Week.Mon(database);
                    break;
                case 1:
                    cur_fragment = new Week.Tue(database);
                    break;
                case 2:
                    cur_fragment = new Week.Wed(database);
                    break;
                case 3:
                    cur_fragment = new Week.Thu(database);
                    break;
                case 4:
                    cur_fragment = new Week.Fri(database);
                    break;
            }
            return cur_fragment;
        }

        public int getCount() {
            return MAX_PAGE;
        }
    }
}
