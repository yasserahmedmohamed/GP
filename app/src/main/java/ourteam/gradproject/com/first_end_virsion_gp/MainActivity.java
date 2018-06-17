package ourteam.gradproject.com.first_end_virsion_gp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import ourteam.gradproject.com.first_end_virsion_gp.Fragments.MainFragement;
import ourteam.gradproject.com.first_end_virsion_gp.Fragments.NerbyATMS.MapsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,MainFragement.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();

       }


      private void initiate(){
          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);

       TextView   textView = (TextView) findViewById(R.id.fragme_name_page);
          textView.setText("الرئيسيه");
          Fragment fragment = new MainFragement();
          FragmentManager fragmentManager = getSupportFragmentManager();
          fragmentManager.beginTransaction().replace(R.id.my_fre, fragment)
                  .commit();
          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
          ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                  this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
          drawer.addDrawerListener(toggle);
          toggle.syncState();

          NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
          navigationView.setNavigationItemSelectedListener(this);


//          Fragment fragment = new MainFragement();
//          FragmentManager fragmentManager = getSupportFragmentManager();
//          fragmentManager.beginTransaction().replace(R.id.main_fragment, fragment)
//                  .commit();
////        //  StatusBarUtil.setTransparent(MainActivity.this);
//          Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//     //     setSupportActionBar(toolbar);
//
//          FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////          fab.setOnClickListener(new View.OnClickListener() {
////              @Override
////              public void onClick(View view) {
////                  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                          .setAction("Action", null).show();
////              }
////          });
//
//          DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//          ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                  this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//          drawer.addDrawerListener(toggle);
//          toggle.syncState();
//
//          NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//          navigationView.setNavigationItemSelectedListener(this);

      }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
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

        if (id == R.id.main) {

            Fragment fragment = new MainFragement();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.my_fre, fragment)
                    .commit();

        } else if (id == R.id.history) {

        } else if (id == R.id.nav_terms) {

        } else if (id == R.id.nav_paymenysplace) {
           Intent intent=new Intent(this, MapsActivity.class);
           startActivity(intent);

        } else if (id == R.id.nav_contact_us) {

        }
        else if (id==R.id.nav_share){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
