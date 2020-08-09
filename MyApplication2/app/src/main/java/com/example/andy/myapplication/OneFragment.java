package com.example.andy.myapplication;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_one, container, false);

        Button change_tab = v.findViewById(R.id.btn_changetab);
        change_tab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//               // TwoFragment twoFragment = new TwoFragment();
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.btn_changetab, twoFragment);
//                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

            }
        });

        return v;
    }

    public void onButtonClicked(View view)
    {
        //do your stuff here..
        final FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.btn_changetab, new TwoFragment(), "NewFragmentTag");
        ft.commit();

        ft.addToBackStack(null);
    }
}
