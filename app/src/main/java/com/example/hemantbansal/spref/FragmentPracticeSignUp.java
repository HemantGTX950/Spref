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
import android.widget.EditText;

/**
 * Created by Hemant Bansal on 11/22/2016.
 */

public class FragmentPracticeSignUp extends Fragment {
    public FragmentPracticeSignUp() {
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button signup,login_,signup_;

        final EditText signid,signpass;
        View view=inflater.inflate(R.layout.sign_up_fragment,container,false);
        login_=(Button)view.findViewById(R.id.login_btn_);
        signup=(Button)view.findViewById(R.id.sign_up_btn);
        signup_=(Button)view.findViewById(R.id.sign_btn_);
        signid=(EditText)view.findViewById(R.id.sign_up_id);
        signpass=(EditText)view.findViewById(R.id.sign_up_password);
        signup_.setEnabled(false);
        login_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                getActivity().setTitle("Login");
                fragmentTransaction.replace(R.id.fragment_container,new FragmentPracticeLogin());
                fragmentTransaction.commit();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,pass;
                id=signid.getText().toString();
                pass=signpass.getText().toString();
                Bundle args=new Bundle();
                args.putString("State","signup");
                args.putString("Activity","Signed Up");
                args.putString("Id",id);
                args.putString("pass",pass);

                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentPracticeMain frag=new FragmentPracticeMain();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                frag.setArguments(args);
                fragmentTransaction.replace(R.id.fragment_container,frag);
                fragmentTransaction.commit();

            }
        });
        return view;
    }
}
