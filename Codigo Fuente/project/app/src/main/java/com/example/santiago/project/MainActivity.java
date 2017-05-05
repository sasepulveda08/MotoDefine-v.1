package com.example.santiago.project;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private RadioGroup grupo;
    SQLiteDatabase bd;
    int id;
    int id2;
    int id3;
    int id4;
    RadioGroup radioGroup;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        openDialogo();

        DataBase admin = new DataBase(this, "DataBase", null,1);
        bd= admin.getWritableDatabase();

        Button entry = (Button) findViewById(R.id.button1);

        radioGroup = (RadioGroup) findViewById(R.id.radioGoupp1);
        radioGroup2 = (RadioGroup) findViewById(R.id.radioGoupp2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radioGoupp3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radioGoupp4);


        // boton de terminar el test
        entry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                id = radioGroup.getCheckedRadioButtonId();
                id2 = radioGroup2.getCheckedRadioButtonId();
                id3 = radioGroup3.getCheckedRadioButtonId();
                id4 = radioGroup4.getCheckedRadioButtonId();

                if (id2 == -1 || id == -1 || id3 == -1 || id4 == -1){

                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Falta Seleccionar Respuestas", Toast.LENGTH_SHORT);
                    toast1.show();

                }else{


                    if (id == R.id.radioButton) {
                        //MALO BIGIS O NAKER

//                        bd.execSQL("UPDATE PARAMETROS SET VALOR =  WHERE  ID = 1");
//                        Intent ListSong = new Intent(getApplicationContext(), Selection.class);
//                        startActivity(ListSong);
                            if (id4 == R.id.radioButton16) {
                                bd.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =2");

                            }else if(id4 == R.id.radioButton15) {
                                bd.execSQL("UPDATE PARAMETROS SET VALOR = 5 WHERE  ID =2");

                            }else if(id4 == R.id.radioButton14) {
                                bd.execSQL("UPDATE PARAMETROS SET VALOR = 4 WHERE  ID =2");

                            }else if(id4 == R.id.radioButton13) {
                                bd.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =2");
                            }else {
                                Toast toast1 =
                                        Toast.makeText(getApplicationContext(),
                                                "opcon no valida ", Toast.LENGTH_SHORT);
                                toast1.show();
                            }

                    }else if(id == R.id.radioButton2) {

                        if (id4 == R.id.radioButton16) {

                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =2");
                        }else if(id4 == R.id.radioButton15) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 5 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton14) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 1 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton13) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 4 WHERE  ID =2");

                        }else {
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "opcon no valida ", Toast.LENGTH_SHORT);
                            toast1.show();
                        }

                    }else if(id == R.id.radioButton3) {
                        if (id4 == R.id.radioButton16) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 4 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton15) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton14) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 3 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton13) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 1 WHERE  ID =2");
                        }else {
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "opcon no valida ", Toast.LENGTH_SHORT);
                            toast1.show();
                        }


                    }else if(id == R.id.radioButton4) {
                        if (id4 == R.id.radioButton16) {

                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 3 WHERE  ID =2");
                        }else if(id4 == R.id.radioButton15) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton14) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 5 WHERE  ID =2");

                        }else if(id4 == R.id.radioButton13) {
                            bd.execSQL("UPDATE PARAMETROS SET VALOR = 1 WHERE  ID =2");
                        }else {
                            Toast toast1 =
                                    Toast.makeText(getApplicationContext(),
                                            "opcon no valida ", Toast.LENGTH_SHORT);
                            toast1.show();
                        }

                    }else {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "opcon no valida ", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    bd.execSQL("UPDATE PARAMETROS SET VALOR = 1 WHERE  ID = 1");
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void openDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Moto Define");
        builder.setMessage("Bienvenido, Para continuar debes llenar el Test de inicio escoge la opción que más se acomode a tu gusto.");
        builder.setPositiveButton("text", null);


        Dialog dialog = builder.create();
        dialog.show();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            //Toast toast = Toast.makeText(this, "Back", Toast.LENGTH_SHORT);
            //toast.show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
