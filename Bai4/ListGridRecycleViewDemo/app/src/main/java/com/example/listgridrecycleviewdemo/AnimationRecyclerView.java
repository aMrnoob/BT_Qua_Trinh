package com.example.listgridrecycleviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listgridrecycleviewdemo.adapter.AnimationAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimationRecyclerView extends AppCompatActivity {

    private Button btnAddItem;
    private RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
        setContentView(R.layout.animation_recycler_view);

        btnAddItem = (Button) findViewById(R.id.btn_add_item);
        rvItems = (RecyclerView) findViewById(R.id.rv_items);

        List<String> data = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            data.add("item" + i);
        }

        final AnimationAdapter adapter = new AnimationAdapter(data);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setItemAnimator(new DefaultItemAnimator());

        btnAddItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addItem("new item");
                rvItems.scrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }
}