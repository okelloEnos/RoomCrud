package com.okellosoftwarez.roomintro;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class deleteFragment extends Fragment {
    EditText key_to_delete;
    Button fragDeleteBtn;

    public deleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        key_to_delete = view.findViewById(R.id.etDelete_key);
        fragDeleteBtn = view.findViewById(R.id.deletingBtn);

        fragDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                int keyNum = Integer.parseInt(key_to_delete.getText().toString().trim());
                user.setId(keyNum);
                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User Successfully Deleted...", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
