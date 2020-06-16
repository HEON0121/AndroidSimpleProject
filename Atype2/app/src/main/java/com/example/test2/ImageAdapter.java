package com.example.test2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> habit = null;
    public ImageAdapter(Context c, ArrayList<Integer> habit) {
        context = c;
        //ArrayList 배열
        this.habit = habit;
    }

    @Override
    public int getCount() {
        return habit.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    Integer[]imgID = {
            R.drawable.drinking, R.drawable.ciga, R.drawable.running
    };
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(context);
        i.setImageResource(habit.get(position));
        i.setPadding(5,5,5,5);
        i.setLayoutParams(new Gallery.LayoutParams(300,300));
        i.setScaleType(ImageView.ScaleType.FIT_START);
        return i;
    }
}
