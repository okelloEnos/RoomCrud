package com.okellosoftwarez.roomintro;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button addBtn, viewBtn, deleteBtn, updateBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addBtn = view.findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);

        viewBtn = view.findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(this);

        deleteBtn = view.findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(this);

        updateBtn = view.findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
//            replacing the home fragment with the appropriate fragment depending on which button was clicked
//            and utilize its fragment manager
            case R.id.addBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new addFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.viewBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new viewFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.deleteBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.updateBtn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
