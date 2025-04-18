package com.example.sliderimage;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ViewSlipperActivity extends AppCompatActivity {

    ViewFlipper viewFlipperMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_slipper);
        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        actionViewFlipperMain();
    }

    private void actionViewFlipperMain() {
        List<String> arrayListFlipper = new ArrayList<>();
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/guangcao.png");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/coffee.jpg");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/companypizza.jpeg");
        arrayListFlipper.add("http://app.iotstar.vn/appfoods/flipper/themoingon.jpeg");

        for(int i = 0; i < arrayListFlipper.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext())
                    .load(arrayListFlipper.get(i))
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imageView);
        }

        viewFlipperMain.setFlipInterval(3600);
        viewFlipperMain.setAutoStart(true);

        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation(slide_out);
    }
}