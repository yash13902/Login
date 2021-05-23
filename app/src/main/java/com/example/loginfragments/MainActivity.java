package com.example.loginfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.loginfragments.Fragments.CreateAccountFragment;
import com.example.loginfragments.Fragments.GettingStartedFragment;
import com.example.loginfragments.Fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    public Fragment fragmentLogin, fragmentNewAccount, fragmentGettingStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentLogin = new LoginFragment();
        fragmentNewAccount = new CreateAccountFragment();
        fragmentGettingStarted = new GettingStartedFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bodyFragment, fragmentLogin).commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else if(getFragmentManager().getBackStackEntryCount() == 1) {
            moveTaskToBack(false);
        }
        else {
            getFragmentManager().popBackStack();
        }
    }
}