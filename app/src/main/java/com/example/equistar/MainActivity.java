package com.example.equistar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import  androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationview);
        toolbar=findViewById(R.id.atoolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        

         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 int id=item.getItemId();
                 if(id==R.id.stallions){
                     loadFragment(new AFragment());
                 }
                else if(id==R.id.broodmares){

                     Toast.makeText(MainActivity.this, "Broodmares", Toast.LENGTH_SHORT).show();
                 }
                 else if(id==R.id.dosage){

                     Toast.makeText(MainActivity.this, "Dosage", Toast.LENGTH_SHORT).show();
                 }
                 else if(id==R.id.farms){

                     Toast.makeText(MainActivity.this, "Frames", Toast.LENGTH_SHORT).show();
                 }
                 else if(id==R.id.pedigrees){

                     Toast.makeText(MainActivity.this, "Pedigrees", Toast.LENGTH_SHORT).show();
                 }
                 else if(id==R.id.news_and_events){

                     Toast.makeText(MainActivity.this, "News And Events", Toast.LENGTH_SHORT).show();
                 }
                 else{

                     Toast.makeText(MainActivity.this, "Races and Auctions", Toast.LENGTH_SHORT).show();
                 }
                 drawerLayout.closeDrawer(GravityCompat.START);



                 return true;
             }
         });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.add(R.id.container,fragment);
        ft.commit();
    }

}