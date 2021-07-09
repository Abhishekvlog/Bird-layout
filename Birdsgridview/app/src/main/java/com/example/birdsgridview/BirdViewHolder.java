package com.example.birdsgridview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BirdViewHolder extends RecyclerView.ViewHolder {
    private TextView Name;
    private ImageView Image;
    private RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;
    public BirdViewHolder(@NonNull View itemView,ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        Name = itemView.findViewById(R.id.tvname);
        Image =itemView.findViewById(R.id.tvimage);
        relativeLayout = itemView.findViewById(R.id.cardview);

    }
    public void setData(Bird bird){
        Name.setText(bird.getName());
        Image.setImageResource(bird.getImage());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickedItem(getAdapterPosition(),bird);
            }
        });
    }
}
