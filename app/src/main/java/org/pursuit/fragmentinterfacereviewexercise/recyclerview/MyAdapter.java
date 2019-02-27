package org.pursuit.fragmentinterfacereviewexercise.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.fragments.FragmentInterface;
import org.pursuit.fragmentinterfacereviewexercise.model.Baddie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
   List<Baddie> baddieList;
   FragmentInterface fragmentInterface;

    public MyAdapter(List<Baddie> baddieList, FragmentInterface fragmentInterface) {
        this.baddieList = baddieList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_viewholder, viewGroup, false);
        return new MyViewHolder(childView);
}

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.onBind(baddieList.get(i),fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return baddieList.size();
    }
}
