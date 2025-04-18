package com.example.listgridrecycleviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listgridrecycleviewdemo.R;
import com.example.listgridrecycleviewdemo.model.Subject;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {

    private Context context;
    private List<Subject> subjects;
    private int layout;

    public SubjectAdapter(Context context, List<Subject> subjects, int layout) {
        this.context = context;
        this.subjects = subjects;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return subjects.size();
    }

    @Override
    public Object getItem(int position) {
        return subjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        Subject subject = subjects.get(position);

        ImageView ivIcon = convertView.findViewById(R.id.ivSubjectImage);
        TextView tvName = convertView.findViewById(R.id.tvSubjectName);
        TextView tvDescription = convertView.findViewById(R.id.tvSubjectDescription);

        ivIcon.setImageResource(subject.getImageId());
        tvName.setText(subject.getName());
        tvDescription.setText(subject.getDescription());

        return convertView;
    }
}
