package com.example.listgridrecycleviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listgridrecycleviewdemo.adapter.SongAdapter;
import com.example.listgridrecycleviewdemo.model.Song;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSubject extends AppCompatActivity implements SongAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        setContentView(R.layout.recycler_view);

        RecyclerView rvSongs = findViewById(R.id.rvSongs);
        ImageView ivMultipleView = findViewById(R.id.ivMultipleView);
        Button btnListView = findViewById(R.id.btnListView);
        Button btnGridView = findViewById(R.id.btnGridView);

        List<Song> mSongs = new ArrayList<>();
        mSongs.add(new Song("68696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("68781", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Còn yêu thương", "Thiên Đông"));
        mSongs.add(new Song("68658", "NGỐC", "Có rất nhiều những câu chuyện Em giấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song("60618", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràn bao", "Duy Cương"));
        mSongs.add(new Song("60685", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60752", "NO", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song("60608", "TÌNH YÊU CHẤP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new Song("60603", "CHỜ NGÀY MƯA TAN", "Một ngày mưa và em khuất xa nơi anh bóng dáng cũ", "Trung Đức"));
        mSongs.add(new Song("60728", "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em một lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new Song("60856", "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));

        SongAdapter mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);

        mSongAdapter.setOnItemClickListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

        ivMultipleView.setOnClickListener(v -> {
            Intent intent = new Intent(RecyclerViewSubject.this, MultipleView.class);
            startActivity(intent);
        });

        btnListView.setOnClickListener(v -> {
            Intent intent = new Intent(RecyclerViewSubject.this, ListViewSubject.class);
            startActivity(intent);
        });

        btnGridView.setOnClickListener(v -> {
            Intent intent = new Intent(RecyclerViewSubject.this, GridViewSubject.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(Song song, int position) {
        Toast.makeText(this, "Tên bài hát: " + song.getmTitle(), Toast.LENGTH_SHORT).show();
    }
}