package com.app.master.petagramsocial;

import android.app.NotificationManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.master.petagramsocial.Presentador.NotificacionToken;
import com.app.master.petagramsocial.Vista.AdaptadorPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        establecerViewPager();
        NotificacionToken notificacionToken=new NotificacionToken();

    }
    public void establecerViewPager(){
        FragmentReciclerView fragment=new FragmentReciclerView();
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(fragment);
        viewPager.setAdapter(new AdaptadorPager(getSupportFragmentManager(),fragments));
    }
}
