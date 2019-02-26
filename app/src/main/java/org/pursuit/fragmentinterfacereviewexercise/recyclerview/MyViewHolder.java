package org.pursuit.fragmentinterfacereviewexercise.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.fragments.FragmentInterface;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    FragmentInterface fragmentInterface;
    TextView baddiesTitle;
    int[] images;
    String[] baddiesNames;
    String[] baddieInstagrams;


    public MyViewHolder(@NonNull View itemView, int[] images, String[] baddiesNames, String[] baddieInstagrams) {
        super(itemView);
        this.images = images;
        this.baddiesNames = baddiesNames;
        this.baddieInstagrams = baddieInstagrams;

        baddiesTitle = itemView.findViewById(R.id.name_textview);
        itemView.findViewById(R.id.recyclerView_tiles).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fragmentInterface.toEndFrag(images[getAdapterPosition()], baddiesNames[getAdapterPosition()], baddieInstagrams[getAdapterPosition()]);
    }
}
