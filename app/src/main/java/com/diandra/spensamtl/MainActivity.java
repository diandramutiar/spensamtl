package com.diandra.spensamtl;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.karan.churi.PermissionManager.PermissionManager;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            setSelectedNavigatonByUser(item.getItemId());
            return true;
        }
    };

    public void setSelectedNavigatonByUser(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.navigation_berita:
                fragment = new BeritaFragment();
                break;
            case R.id.navigation_pengumuman:
                fragment = new PengumumanFragment();
                break;
            case R.id.navigation_lainnya:
                fragment = new LainnyaFragment();
                break;
        }

        if (fragment!=null) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionManager permission = new PermissionManager() {};
        permission.checkAndRequestPermissions(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setSelectedNavigatonByUser(R.id.navigation_berita);
    }

}
