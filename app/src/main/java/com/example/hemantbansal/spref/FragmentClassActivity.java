package com.example.hemantbansal.spref;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hemant Bansal on 11/23/2016.
 */

public class FragmentClassActivity extends Fragment {
    public FragmentClassActivity() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button back;
        TextView id,pass,state;
        View view=inflater.inflate(R.layout.fragment_layout_activity_,container,false);
        state=(TextView)view.findViewById(R.id.fragment_main_state_);
        back=(Button)view.findViewById(R.id.fragment_main_btn);
        id=(TextView)view.findViewById(R.id.fragment_main_id);
        pass=(TextView)view.findViewById(R.id.fragment_main_pass);
        Bundle bundle=getArguments();
        getActivity().setTitle(bundle.getString("Activity"));
        id.setText(bundle.getString("Id").toString());
        pass.setText(bundle.getString("pass").toString());
        state.setText(bundle.getString("State").toString());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new FragmentPracticeLogin());
                fragmentTransaction.commit();
                getActivity().setTitle("Login");

            }
        });


        return view;




    }
}
