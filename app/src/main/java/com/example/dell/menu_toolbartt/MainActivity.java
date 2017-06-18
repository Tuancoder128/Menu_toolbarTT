package com.example.dell.menu_toolbartt;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    Toolbar toolbar;
    ShareActionProvider actionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.menutoolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem timkiem = menu.findItem(R.id.itsearch);
        MenuItem provider = menu.findItem(R.id.itShare);


        SearchView searchView = (SearchView) timkiem.getActionView();
        searchView.setOnQueryTextListener(MainActivity.this);

        actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(provider);
        actionProvider.setOnShareTargetSelectedListener(new ShareActionProvider.OnShareTargetSelectedListener() {
            @Override
            public boolean onShareTargetSelected(ShareActionProvider source, Intent intent) {
                Intent intent =  new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"hello");
                actionProvider.setShareIntent(intent);

                return false;
            }
        });




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itThem :
                Toast.makeText(MainActivity.this,"ban dang click vao " + item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.itSua :
                Toast.makeText(MainActivity.this,"ban dang click vao " + item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.itXoa :
                Toast.makeText(MainActivity.this,"ban dang click vao " + item.getTitle(),Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(MainActivity.this,"ban dang click vao " + newText,Toast.LENGTH_SHORT).show();
        return false;
    }
}
