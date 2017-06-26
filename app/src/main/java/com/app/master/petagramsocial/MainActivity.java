package com.app.master.petagramsocial;

import android.app.NotificationManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.master.petagramsocial.Presentador.NotificacionToken;
import com.app.master.petagramsocial.Vista.AdaptadorPager;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        establecerViewPager();


    }
    public void establecerViewPager(){
        FragmentReciclerView fragment=new FragmentReciclerView();
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(fragment);
        viewPager.setAdapter(new AdaptadorPager(getSupportFragmentManager(),fragments));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.recibirNotificacion:
                String token = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(this,"token " + token, Toast.LENGTH_SHORT).show();
                return true;


        }
        return false;
    }
}
