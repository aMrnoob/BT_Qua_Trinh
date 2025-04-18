package com.example.listgridrecycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listgridrecycleviewdemo.adapter.MultipleViewAdapter;
import com.example.listgridrecycleviewdemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class MultipleView extends AppCompatActivity {

    private static final String TAG = "MultipleView";
    private RecyclerView recyclerMultipleViewType;
    private List<Object> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
        setContentView(R.layout.multiple_view);

        recyclerMultipleViewType = (RecyclerView) findViewById(R.id.rv_multipe_view_type);
        mData = new ArrayList<>();
        mData.add(new User("Nguyen Van Nghia", "Quan 11"));
        mData.add(R.drawable.user_icon);
        mData.add("Text 0");
        mData.add("Text 1");
        mData.add(new User("Nguyen Hoang Minh", "Quan 3"));
        mData.add("Text 2");
        mData.add(R.drawable.user_icon);
        mData.add(R.drawable.user_icon);
        mData.add(new User("Pham Nguyen Tam Phu", "Quan 10"));
        mData.add("Text 3");
        mData.add("Text 4");
        mData.add(new User("Tran Van Phuc", "Quan 1"));
        mData.add(R.drawable.user_icon);

        MultipleViewAdapter adapter = new MultipleViewAdapter(this, mData);
        recyclerMultipleViewType.setAdapter(adapter);
        recyclerMultipleViewType.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageView = findViewById(R.id.ivAnimationRV);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(MultipleView.this, AnimationRecyclerView.class);
            startActivity(intent);
        });
    }
}