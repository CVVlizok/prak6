package com.example.prak6;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Получаем ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Настройки ActionBar
            actionBar.setDisplayHomeAsUpEnabled(true); // Показать кнопку назад
            actionBar.setTitle("Главная"); // Установить заголовок
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    actionBar.setTitle("Главная");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView2, new HomeFragment())
                            .commit();
                }
                else if (item.getItemId() == R.id.notification) {
                    actionBar.setTitle("Уведомления");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView2, new NotificationsFragment())
                            .commit();
                }
                else if (item.getItemId() == R.id.settings){
                    actionBar.setTitle("Настройки");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView2, new SettingsFragment())
                            .commit();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Обработка нажатия на элемент ActionBar
        switch (item.getItemId()) {
            case android.R.id.home: // Проверяем идентификатор элемента ActionBar (кнопка "Назад")
                // Закрываем текущую Activity и возвращаемся к предыдущей
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


