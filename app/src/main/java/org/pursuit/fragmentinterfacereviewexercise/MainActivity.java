package org.pursuit.fragmentinterfacereviewexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.fragmentinterfacereviewexercise.fragments.EndFragment;
import org.pursuit.fragmentinterfacereviewexercise.fragments.FragmentInterface;
import org.pursuit.fragmentinterfacereviewexercise.fragments.StartFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, StartFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void toEndFrag(int image, String name, String instagram) {
        EndFragment endFragment = EndFragment.newInstance(instagram,name,image);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,endFragment)
                .addToBackStack(EndFragment.KEY)
                .commit();

    }
}
