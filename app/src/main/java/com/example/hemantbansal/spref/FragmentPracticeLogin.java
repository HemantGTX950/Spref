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

public class FragmentPracticeLogin extends Fragment{
    public FragmentPracticeLogin() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button logIn,login,signup;
        final EditText loginId,loginPass;

        View view=inflater.inflate(R.layout.login_fragment,container,false);
        logIn=(Button)view.findViewById(R.id.login_frag_btn_);
        loginId=(EditText)view.findViewById(R.id.login_id);
        login=(Button)view.findViewById(R.id.login_btn_);
        signup=(Button)view.findViewById(R.id.sign_btn_);
        loginPass=(EditText)view.findViewById(R.id.login_frag_password);
        login.setEnabled(false);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setTitle("Sign Up");
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new FragmentPracticeSignUp(),"signup");
                fragmentTransaction.commit();
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id,pass;
                id=loginId.getText().toString();
                pass=loginPass.getText().toString();
                Bundle args=new Bundle();
                args.putString("State","login");
                args.putString("Id",id);
                args.putString("pass",pass);
                args.putString("Activity","Logged In");
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
