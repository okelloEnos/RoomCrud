package com.okellosoftwarez.roomintro;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class viewFragment extends Fragment {
    TextView list_susers;
    List<User> list;

    public viewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        list_susers = view.findViewById(R.id.list_users);

//       retrieve and Display the added users in db
        list = MainActivity.myAppDatabase.myDao().userList();

        String message = "Users From Your DataBase : \n\n";
//        list_susers.setText(list);
        for (User user : list) {
            message += user.getId() + "\n";
            message += user.getName() + "\n";
            message += user.getEmail() + "\n";
        }
        list_susers.setText(message);
        return view;
    }

}
