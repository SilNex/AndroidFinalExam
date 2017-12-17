package com.example.finalexam;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

enum WeekDays{NNN, Mon, Tue, Wed, Thu, Fri}

@SuppressLint("ValidFragment")
public class Week extends android.support.v4.app.Fragment {
    static String Temp = null;

    public static void SortData(TextView[] textViews, WeekDays day, SQLiteDatabase database){
        DivideData divideData = new DivideData(database);
        String[] timeTalbe = new String[3];
        if(Temp == null){
            Temp = divideData.run();
        }

        String[] Table = Temp.split("========================================");
        String[] dayTable = {Table[day.ordinal()], Table[day.ordinal()+5]};
        int i = 0;
        for (String str:dayTable){
            dayTable[i] = str.replace("[[["+day.name()+"]]]\n\n","");
            i++;
        }

        timeTalbe[0] = dayTable[0].replace("[[중식]]\n", "");
        String tmp = dayTable[1].replace("[[중식]]\n", "");
        timeTalbe[1] = tmp.split("\\[\\[석식\\]\\]")[0];
        timeTalbe[2] = tmp.split("\\[\\[석식\\]\\]")[1];

        textViews[0].setText(timeTalbe[0]);
        textViews[1].setText(timeTalbe[1]);
        textViews[2].setText(day.name());
        textViews[3].setText(timeTalbe[2]);

    }

    public static class Mon extends android.support.v4.app.Fragment {
        SQLiteDatabase database;
        Mon(SQLiteDatabase database){
            this.database = database;
        }

        WeekDays day = WeekDays.Mon;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.page,container,false);
            RelativeLayout background=(RelativeLayout)linearLayout.findViewById(R.id.background);
            TextView[] textViews={
                    (TextView)linearLayout.findViewById(R.id.lunchTable1),
                    (TextView)linearLayout.findViewById(R.id.lunchTable2),
                    (TextView)linearLayout.findViewById(R.id.weekName),
                    (TextView)linearLayout.findViewById(R.id.dinnerTable)
            };

            SortData(textViews, day, database);

            background.setBackground(new ColorDrawable(0xff6dc6d2));
            return linearLayout;
        }
    }

    public static class Tue extends android.support.v4.app.Fragment {
        SQLiteDatabase database;
        Tue(SQLiteDatabase database){
            this.database = database;
        }
        WeekDays day = WeekDays.Tue;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.page,container,false);
            RelativeLayout background=(RelativeLayout)linearLayout.findViewById(R.id.background);
            TextView[] textViews={
                    (TextView)linearLayout.findViewById(R.id.lunchTable1),
                    (TextView)linearLayout.findViewById(R.id.lunchTable2),
                    (TextView)linearLayout.findViewById(R.id.weekName),
                    (TextView)linearLayout.findViewById(R.id.dinnerTable)
            };

            SortData(textViews, day, database);

            background.setBackground(new ColorDrawable(0xff26abb5));
            return linearLayout;
        }
    }

    public static class Wed extends android.support.v4.app.Fragment {
        SQLiteDatabase database;
        Wed(SQLiteDatabase database){
            this.database = database;
        }
        WeekDays day = WeekDays.Wed;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.page,container,false);
            RelativeLayout background=(RelativeLayout)linearLayout.findViewById(R.id.background);
            TextView[] textViews={
                    (TextView)linearLayout.findViewById(R.id.lunchTable1),
                    (TextView)linearLayout.findViewById(R.id.lunchTable2),
                    (TextView)linearLayout.findViewById(R.id.weekName),
                    (TextView)linearLayout.findViewById(R.id.dinnerTable)
            };

            SortData(textViews, day, database);

            background.setBackground(new ColorDrawable(0xff008c9e));
            return linearLayout;
        }
    }

    public static class Thu extends android.support.v4.app.Fragment {
        SQLiteDatabase database;
        Thu(SQLiteDatabase database){
            this.database = database;
        }
        WeekDays day = WeekDays.Thu;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.page,container,false);
            RelativeLayout background=(RelativeLayout)linearLayout.findViewById(R.id.background);
            TextView[] textViews={
                    (TextView)linearLayout.findViewById(R.id.lunchTable1),
                    (TextView)linearLayout.findViewById(R.id.lunchTable2),
                    (TextView)linearLayout.findViewById(R.id.weekName),
                    (TextView)linearLayout.findViewById(R.id.dinnerTable)
            };

            SortData(textViews, day, database);

            background.setBackground(new ColorDrawable(0xff26abb5));
            return linearLayout;
        }
    }

    public static class Fri extends android.support.v4.app.Fragment {
        SQLiteDatabase database;
        Fri(SQLiteDatabase database){
            this.database = database;
        }
        WeekDays day = WeekDays.Fri;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout linearLayout=(LinearLayout)inflater.inflate(R.layout.page,container,false);
            RelativeLayout background=(RelativeLayout)linearLayout.findViewById(R.id.background);
            TextView[] textViews={
                    (TextView)linearLayout.findViewById(R.id.lunchTable1),
                    (TextView)linearLayout.findViewById(R.id.lunchTable2),
                    (TextView)linearLayout.findViewById(R.id.weekName),
                    (TextView)linearLayout.findViewById(R.id.dinnerTable)
            };

            SortData(textViews, day, database);

            background.setBackground(new ColorDrawable(0xff6dc6d2));
            return linearLayout;
        }
    }


}
