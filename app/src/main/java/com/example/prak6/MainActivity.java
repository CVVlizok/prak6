package com.example.prak6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    public ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("КРЫСКИ");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, R.string.drawer_open,
                R.string.drawer_close);

        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigation = findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.br) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, new BrFragment())
                            .commit();
                    actionBar.setSubtitle("Black rat");
                }

                else if (item.getItemId() == R.id.wr) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, new WrFragment())
                            .commit();
                    actionBar.setSubtitle("White rat");
                }

                else if (item.getItemId() == R.id.gr) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, new GrFragment())
                            .commit();
                    actionBar.setSubtitle("Gray rat");
                }
                else if (item.getItemId() == R.id.next) {
                    Intent intent = new Intent
                            (MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }

                assert drawer != null;
                drawer.closeDrawers();
                return true;
            }
        });
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // Обработка нажатия на иконку меню в ActionBar для открытия и закрытия Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



