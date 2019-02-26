package org.pursuit.fragmentinterfacereviewexercise.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentinterfacereviewexercise.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    int[] images;
    String[] names;
    String[] instagrams;

    public MyAdapter(int[] images, String[] names, String[] instagrams) {
        this.images = images;
        this.names = names;
        this.instagrams = instagrams;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_viewholder, viewGroup, false);
        return new MyViewHolder(childView, images, names, instagrams);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String baddie_name = names[i];
        myViewHolder.baddiesTitle.setText(baddie_name);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
