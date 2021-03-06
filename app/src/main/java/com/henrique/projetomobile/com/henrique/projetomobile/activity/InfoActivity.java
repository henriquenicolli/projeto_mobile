package com.henrique.projetomobile.com.henrique.projetomobile.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.henrique.projetomobile.R;

public class InfoActivity extends AppCompatActivity {

    private Switch swt_theme;
    public static int theme = R.style.AppTheme;
    public static final String KEY = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        swt_theme = findViewById(R.id.switch1);

        if(theme == R.style.AppTheme)
            swt_theme.setChecked(false);
        else
            swt_theme.setChecked(true);

        swt_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swt_theme.isChecked()){
                    theme = R.style.AppThemeDark;

                    SharedPreferences.Editor editor = getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
                    editor.putInt(KEY, theme);
                    editor.apply();

                    Intent it = new Intent(InfoActivity.this, MainActivity.class);
                    startActivity(it);
                }
                else {
                    theme = R.style.AppTheme;

                    SharedPreferences.Editor editor = getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
                    editor.putInt(KEY, theme);
                    editor.apply();

                    Intent it = new Intent(InfoActivity.this, MainActivity.class);
                    startActivity(it);
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
        }

        return true;
    }
}
