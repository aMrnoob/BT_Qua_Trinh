package com.example.listgridrecycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listgridrecycleviewdemo.adapter.SubjectAdapter;
import com.example.listgridrecycleviewdemo.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class ListViewSubject extends AppCompatActivity {

    private int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
        setContentView(R.layout.list_view);

        ListView lvSubject = findViewById(R.id.lvSubjects);
        EditText edtSubject = findViewById(R.id.edtSubjectName);
        Button btnAdd = findViewById(R.id.btnAddSubject);
        Button btnUpdate = findViewById(R.id.btnUpdateSubject);
        Button btnGridView = findViewById(R.id.btnGridView);
        Button btnRecyclerView = findViewById(R.id.btnRecyclerView);

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("C#", "Môn học C#", R.drawable.csharp_icon));
        subjects.add(new Subject("Java", "Môn học Java", R.drawable.java_icon));
        subjects.add(new Subject("PHP", "Môn học PHP", R.drawable.php_icon));
        subjects.add(new Subject("React", "Môn học React", R.drawable.react_icon));
        subjects.add(new Subject("C++", "Môn học C++", R.drawable.cplusplus_icon));
        subjects.add(new Subject("Python", "Môn học Python", R.drawable.python_icon));
        subjects.add(new Subject("Kotlin", "Môn học Kotlin", R.drawable.kotlin_icon));

        SubjectAdapter adapter = new SubjectAdapter(this, subjects, R.layout.list_grid_view);
        lvSubject.setAdapter(adapter);

        lvSubject.setOnItemClickListener((parent, view, position, id) -> {
            Subject selectedSubject = subjects.get(position);
            edtSubject.setText(selectedSubject.getName());
            index = position;
            Toast.makeText(this, "Chọn môn học: " + selectedSubject.getName(), Toast.LENGTH_SHORT).show();
        });

        lvSubject.setOnItemLongClickListener((parent, view, position, id) -> {
            Subject subjectRemove = subjects.get(position);
            subjects.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã xoá môn học: " + subjectRemove.getName(), Toast.LENGTH_SHORT).show();
            if (index == position) {
                edtSubject.setText("");
                index = -1;
            }

            return true;
        });

        btnAdd.setOnClickListener(v -> {
            String subjectName = edtSubject.getText().toString().trim();
            if (!subjectName.isEmpty()) {
                subjects.add(new Subject(subjectName, "Môn học mới", R.drawable.image_icon));
                adapter.notifyDataSetChanged();
                edtSubject.setText("");
                Toast.makeText(this, "Đã thêm: " + subjectName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng nhập tên môn học", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(v -> {
            String subjectName = edtSubject.getText().toString().trim();
            if (!subjectName.isEmpty() && index != -1) {
                subjects.get(index).setName(subjectName);
                adapter.notifyDataSetChanged();
                edtSubject.setText(subjectName);
                index = -1;
                Toast.makeText(this, "Đã cập nhật môn học thành: " + subjectName, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Vui lòng chọn môn học và nhập tên mới", Toast.LENGTH_SHORT).show();
            }
        });

        btnGridView.setOnClickListener(v -> {
            Intent intent = new Intent(ListViewSubject.this, GridViewSubject.class);
            startActivity(intent);
        });

        btnRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(ListViewSubject.this, RecyclerViewSubject.class);
            startActivity(intent);
        });
    }
}