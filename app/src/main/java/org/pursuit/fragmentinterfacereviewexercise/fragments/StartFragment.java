package org.pursuit.fragmentinterfacereviewexercise.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.model.BaddieList;
import org.pursuit.fragmentinterfacereviewexercise.network.BaddieService;
import org.pursuit.fragmentinterfacereviewexercise.network.RetroFitSingleton;
import org.pursuit.fragmentinterfacereviewexercise.recyclerview.MyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StartFragment extends Fragment {
    public static final String TAG = "retrofit_call";
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
        if (context instanceof FragmentInterface) {
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

        recyclerView = view.findViewById(R.id.recyclerView);
        Retrofit retrofit = RetroFitSingleton.getSingleInstance();
        retrofit.create(BaddieService.class)
                .getBaddies().enqueue(new Callback<BaddieList>() {
            @Override
            public void onResponse(Call<BaddieList> call, Response<BaddieList> response) {
                Log.d(TAG, "onResponse: " + response.body().getBaddiesList());

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new MyAdapter(response.body().getBaddiesList(), fragmentInterface));
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<BaddieList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}
