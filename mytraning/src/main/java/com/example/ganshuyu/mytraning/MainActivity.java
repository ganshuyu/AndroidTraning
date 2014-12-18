package com.example.ganshuyu.mytraning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ganshuyu.mytraning.topbar.TopBarActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);
    }


    @Override
    //将菜单添加到action_bar中
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    //处理action_bar中的点击事件
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                Toast.makeText(this, "You click Settings.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "You click Search.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    //Handle items click.
    public void topBarClick (View v){
        Intent intent = new Intent(this, TopBarActivity.class);
        startActivity(intent);
    }
}
