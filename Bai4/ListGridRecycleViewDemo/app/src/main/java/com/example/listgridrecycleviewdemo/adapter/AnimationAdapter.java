package com.example.listgridrecycleviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.listgridrecycleviewdemo.R;

import java.util.List;

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.ViewHolder> {

    private List<String> mData;

    public AnimationAdapter(List<String> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_animation, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mData.get(position);
        holder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItem(String item) {
        mData.add(item);
        notifyItemInserted(mData.size() - 1);
    }

    public void addItem(int position, String item) {
        mData.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public void removeItem(String item) {
        int index = mData.indexOf(item);
        if(index < 0) {
            return;
        }
        mData.remove(index);
        notifyItemRemoved(index);
    }

    public void replaceItem(int position, String item) {
        mData.remove(position);
        mData.add(position, item);
        notifyItemChanged(position);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView tvItem;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvItem = (TextView) itemView.findViewById(R.id.tv_item);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    removeItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Removed Animation", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    replaceItem(getAdapterPosition(), "item changed");
                    Toast.makeText(itemView.getContext(), "Changed Animation", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
