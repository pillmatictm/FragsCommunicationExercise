package org.pursuit.fragmentinterfacereviewexercise.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.fragments.FragmentInterface;
import org.pursuit.fragmentinterfacereviewexercise.model.Baddie;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView baddiesTitle;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        baddiesTitle = itemView.findViewById(R.id.name_textview);
    }

    public void onBind(final Baddie model, final FragmentInterface fragment) {
        baddiesTitle.setText(model.getName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.toEndFrag(model);

            }
        });
    }
}
