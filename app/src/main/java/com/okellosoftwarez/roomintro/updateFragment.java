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
public class updateFragment extends Fragment {
    EditText updateKey, updateName, updateEmail;
    Button updatingButton;

    public updateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        updateKey = view.findViewById(R.id.et_update_key);
        updateName = view.findViewById(R.id.et_update_name);
        updateEmail = view.findViewById(R.id.et_update_email);

        updatingButton = view.findViewById(R.id.updatingBtn);
        updatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newKey = Integer.parseInt(updateKey.getText().toString().trim());
                String newName, newEmail;
                newName = updateName.getText().toString().trim();
                newEmail = updateEmail.getText().toString().trim();

                User user = new User();
                user.setId(newKey);
                user.setName(newName);
                user.setEmail(newEmail);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "Update was Successful...", Toast.LENGTH_SHORT).show();

                updateKey.setText("");
                updateName.setText("");
                updateEmail.setText("");
            }
        });
        return view;
    }

}
