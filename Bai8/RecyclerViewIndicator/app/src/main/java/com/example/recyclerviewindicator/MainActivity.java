package com.example.recyclerviewindicator;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private float DP;
    private RecyclerView rcIcon;
    private ArrayList<IconModel> arrayList1;
    private IconAdapter iconAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DP = getResources().getDisplayMetrics().density;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });

        rcIcon = findViewById(R.id.rcIcon);
        arrayList1 = new ArrayList<>();

        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 1"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 2"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 3"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 4"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 5"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 6"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 7"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 8"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 9"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 10"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 11"));
        arrayList1.add(new IconModel(R.drawable.ic_launcher_background, "item 12"));



        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(getApplicationContext(), arrayList1);
        rcIcon.setAdapter(iconAdapter);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }
        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(list);
        }
    }
}
