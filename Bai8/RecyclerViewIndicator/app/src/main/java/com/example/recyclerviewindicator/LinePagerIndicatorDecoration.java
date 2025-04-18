package com.example.recyclerviewindicator;

import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final Paint paint = new Paint();
    private final int indicatorHeight = 16;
    private final float indicatorStrokeWidth = 8;
    private final int indicatorColor = 0xFFFFFFFF; // Màu trắng

    public LinePagerIndicatorDecoration() {
        paint.setStrokeWidth(indicatorStrokeWidth);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(indicatorColor);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        if (itemCount == 0) return;

        int totalWidth = parent.getWidth();
        int indicatorWidth = (int) (indicatorStrokeWidth * 3 * itemCount);
        int startX = (totalWidth - indicatorWidth) / 2;
        int posY = parent.getHeight() - indicatorHeight;

        for (int i = 0; i < itemCount; i++) {
            float x = startX + (i * indicatorStrokeWidth * 3);
            canvas.drawCircle(x, posY, indicatorStrokeWidth / 2, paint);
        }
    }
}
