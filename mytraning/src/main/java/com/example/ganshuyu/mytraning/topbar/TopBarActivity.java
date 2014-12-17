package com.example.ganshuyu.mytraning.topbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ganshuyu.mytraning.R;


public class TopBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_top_bar);

        TopBar mTopbar = (TopBar)findViewById(R.id.myTopbar);
        mTopbar.setTopBarOnClickListener(new TopBar.TopBarOnClickListener() {
            @Override
            public void leftButtonOnClick(View v) {
                Toast.makeText(TopBarActivity.this, "LeftButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightButtonOnClick(View v) {
                Toast.makeText(TopBarActivity.this, "RightButton", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top_bar, menu);
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
}
