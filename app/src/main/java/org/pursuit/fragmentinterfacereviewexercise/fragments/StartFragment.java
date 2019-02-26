package org.pursuit.fragmentinterfacereviewexercise.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.recyclerview.MyAdapter;

public class StartFragment extends Fragment {
    private FragmentInterface fragmentInterface;
    private RecyclerView recyclerView;


    public StartFragment() {
    }

    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface){
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInterface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int [] images = getResources().getIntArray(R.array.baddie_images);
        String[] names = getResources().getStringArray(R.array.baddie_names);
        String[] instagrams = getResources().getStringArray(R.array.baddie_instagrams);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new MyAdapter(images,names,instagrams));
        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}
