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

import com.squareup.picasso.Picasso;

import org.pursuit.fragmentinterfacereviewexercise.R;
import org.pursuit.fragmentinterfacereviewexercise.model.Baddie;

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
    private String baddiesPicURL;



    public EndFragment() {
    }

    public static EndFragment newInstance(Baddie model){
        EndFragment endFragment = new EndFragment();
        Bundle args = new Bundle();
        args.putString(BADDIE_NAME, model.getName());
        args.putString(BADDIE_INSTA, model.getInstagram());
        args.putString(BADDIE_PIC,model.getImage());
        endFragment.setArguments(args);
        return endFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baddiesNameString = getArguments().getString(BADDIE_NAME);
        baddiesInstaString = getArguments().getString(BADDIE_INSTA);
        baddiesPicURL = getArguments().getString(BADDIE_PIC);
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
        baddiesInsta.setText("Find this baddie on Instagram " + baddiesInstaString);
        Picasso.get().load(baddiesPicURL).into(baddiesPic);
    }

}
