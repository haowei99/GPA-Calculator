package com.example.user.firstproject2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


// code begins
//    public EditText yourname =(EditText)findViewById(R.id.editText4);
    //public static String name = yourname.getText().toString();  FIX NAME
    public class MyAndroidAppActivity extends Activity {

        public Spinner spinner1;
        //String Uninames[] = {"University of Waterloo", "Wilfrid Laurier University", "Utopia"}; //useless


        @Override // ADD THE SPINNER onCreate when clicked
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);
            addListenerOnButton();
            addListenerOnSpinnerItemSelection();
        //    adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Uninames);
        //    spinner1.setAdapter(adapter);

        }


        public void addListenerOnSpinnerItemSelection() {
            spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        }

        // get the selected dropdown list value
        public void addListenerOnButton() {

            spinner1 = (Spinner) findViewById(R.id.spinner1);






        }






}

    public class CustomOnItemSelectedListener implements OnItemSelectedListener {


        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
            Toast.makeText(parent.getContext(),
                    "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                    Toast.LENGTH_SHORT).show();

        }


        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }// code ends


    @Override
    protected void onCreate(Bundle savedInstanceState) {
// The mailing icon.. display text

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("GPA Calculator");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "A Hao + Lu production", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    public void onButtonTap(View v) { // When clicked, goes into the new page with main screen java.. should try and seperate into laurier, waterloo, utopia based on the clicker
        EditText edit_name;
        Spinner Name = findViewById(R.id.spinner1);
        if (Name.getSelectedItem().toString().equals("University of Waterloo") ||
                Name.getSelectedItem().toString().equals("Wilfrid Laurier University")) {
            String uni = Name.getSelectedItem().toString();
            edit_name = (EditText)findViewById(R.id.names);
            String name =  edit_name.getText().toString();
            Intent firstact = new Intent(this, mainscreen.class);
            firstact.putExtra("key", uni);
            firstact.putExtra("key_name", name);
            startActivity(firstact);
        }
        if (Name.getSelectedItem().toString().equals("Utopia")) {
            Intent firstact = new Intent(this, Utopia.class);
            startActivity(firstact);
        }

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



