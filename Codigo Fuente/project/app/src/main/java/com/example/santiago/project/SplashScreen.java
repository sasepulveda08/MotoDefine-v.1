package com.example.santiago.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class SplashScreen extends Activity {

    Integer codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        DataBase bdsistem = new DataBase(this, "DataBase", null,1);
        SQLiteDatabase db = bdsistem.getWritableDatabase();

        String[] arg = new String[]{"1"};
        Cursor c = db.rawQuery("SELECT VALOR FROM PARAMETROS WHERE ID=?", arg);
        if(c.moveToFirst()){

            do {
                 codigo = c.getInt(0);
              //  Toast toast = Toast.makeText(this, "Back"+codigo, Toast.LENGTH_SHORT);
              //  toast.show();
            }while (c.moveToNext());
        }

        if (codigo == 0){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            },4000);
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreen.this, MenuActivity.class);
                    startActivity(intent);
                }
            },4000);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
           return  false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
