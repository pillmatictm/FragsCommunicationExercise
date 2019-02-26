package org.pursuit.fragmentinterfacereviewexercise.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.fragmentinterfacereviewexercise.R;
public class EndFragment extends Fragment {
    public static final String KEY = "display";
    public static final String BADDIE_NAME = "name";
    public static final String BADDIE_INSTA = "instagram_handle";
    public static final String BADDIE_PIC = "image";
    private TextView baddiesName;
    private TextView baddiesInsta;
    private ImageView baddiesPic;
    private String baddiesNameString;
    private String baddiesInstaString;
    private int baddiesPicInt;



    public EndFragment() {
    }

    public static EndFragment newInstance(String baddiesNamesString, String baddiesInstaString, int badiesPicInt){
        EndFragment endFragment = new EndFragment();
        Bundle args = new Bundle();
        args.putString(BADDIE_NAME, baddiesNamesString);
        args.putString(BADDIE_INSTA, baddiesInstaString);
        args.putInt(BADDIE_PIC, badiesPicInt);
        endFragment.setArguments(args);
        return endFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baddiesNameString = getArguments().getString(BADDIE_NAME);
        baddiesInstaString = getArguments().getString(BADDIE_INSTA);
        baddiesPicInt = getArguments().getInt(BADDIE_PIC);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_end, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baddiesName = view.findViewById(R.id.baddies_name);
        baddiesInsta = view.findViewById(R.id.baddies_instagram);
        baddiesPic = view.findViewById(R.id.baddies_pic);

        baddiesName.setText(baddiesNameString);
        baddiesInsta.setText("Find this baddie on Instagram @" + baddiesInstaString);
        baddiesPic.setImageResource(baddiesPicInt);
    }

}
