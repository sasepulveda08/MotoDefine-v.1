package com.example.santiago.project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , FragmentSport.OnFragmentInteractionListener,
            FragmentNaker.OnFragmentInteractionListener,FragmentTuring.OnFragmentInteractionListener,
        FragmentChoppers.OnFragmentInteractionListener,FragmentScooters.OnFragmentInteractionListener,
        creditsFragment.OnFragmentInteractionListener, FragmentConten.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SelectMoto();
    }
    Integer codigo;
    Integer getmoto;
    SQLiteDatabase db;

    private void SelectMoto() {

        boolean frangmentsTransation = false;
        Fragment fragment = null;

        DataBase bdsistem = new DataBase(this, "DataBase", null,1);
         db = bdsistem.getWritableDatabase();

        String[] arg = new String[]{"1"};
        Cursor c = db.rawQuery("SELECT VALOR FROM PARAMETROS WHERE ID=?", arg);

        String[] arg2 = new String[]{"2"};
        Cursor c2 = db.rawQuery("SELECT VALOR FROM PARAMETROS WHERE ID=?", arg2);

        if(c.moveToFirst()){

            do {
                codigo = c.getInt(0);
                //  Toast toast = Toast.makeText(this, "Back"+codigo, Toast.LENGTH_SHORT);
                //  toast.show();
            }while (c.moveToNext());
        }

        if(c2.moveToFirst()){
            do {
                getmoto = c2.getInt(0);
                //  Toast toast = Toast.makeText(this, "Back"+codigo, Toast.LENGTH_SHORT);
                //  toast.show();
            }while (c2.moveToNext());
        }

        if (codigo == 1){
            if (getmoto == 1){
                db.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =1");
                frangmentsTransation = true;
                fragment = new FragmentSport();

            }else if(getmoto == 2){
                db.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =1");
                frangmentsTransation = true;
                fragment = new FragmentNaker();

            }else if(getmoto == 3){
                db.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =1");
                frangmentsTransation = true;
                fragment = new FragmentTuring();

            }else if(getmoto == 4){
                db.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =1");
                frangmentsTransation = true;
                fragment = new FragmentChoppers();

            }else if(getmoto == 5){
                db.execSQL("UPDATE PARAMETROS SET VALOR = 2 WHERE  ID =1");
                frangmentsTransation = true;
                fragment = new FragmentScooters();
            }
            else{
                frangmentsTransation = true;
                fragment = new FragmentConten();
            }

        }

        if (codigo==2){
            frangmentsTransation = true;
            fragment = new FragmentConten();
        }

        if (frangmentsTransation){
            int commit = getSupportFragmentManager().beginTransaction().replace(R.id.content_menu, fragment).commit();

            getSupportActionBar().setTitle("Nuestra Sugerencia");

        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        boolean frangmentsTransation = false;
        Fragment fragment = null;


        if (id == R.id.nav_camera) {

            frangmentsTransation = true;
            fragment = new FragmentSport();

        } else if (id == R.id.nav_gallery) {

            frangmentsTransation = true;
            fragment = new FragmentNaker();

        } else if (id == R.id.nav_slideshow) {

            frangmentsTransation = true;
            fragment = new FragmentTuring();

        } else if (id == R.id.nav_manage) {

            frangmentsTransation = true;
            fragment = new FragmentChoppers();

        } else if (id == R.id.scooters) {

            frangmentsTransation = true;
            fragment = new FragmentScooters();

        } else if (id == R.id.nav_share) {
            frangmentsTransation = true;
            fragment = new creditsFragment();

        }

        if (frangmentsTransation){
            int commit = getSupportFragmentManager().beginTransaction().replace(R.id.content_menu, fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
