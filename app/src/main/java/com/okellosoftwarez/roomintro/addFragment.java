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
public class addFragment extends Fragment {
    EditText key, name, email;
    Button submitBtn;


    public addFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        key = view.findViewById(R.id.etId);
        name = view.findViewById(R.id.etName);
        email = view.findViewById(R.id.etMail);
        submitBtn = view.findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// Initializing a new user from User class
                User user = new User();

//                Obtaining the id inserted and converting it to int within the number variable
                int number = Integer.parseInt(key.getText().toString().trim());
//                Receiving the name and email
                String s_name, s_email;
                s_name = name.getText().toString().trim();
                s_email = email.getText().toString().trim();

//                assigning user object to the received details
                user.setId(number);
                user.setName(s_name);
                user.setEmail(s_email);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Successfully Added...", Toast.LENGTH_SHORT).show();
                key.setText("");
                name.setText("");
                email.setText("");
            }
        });
        return view;
    }

}
