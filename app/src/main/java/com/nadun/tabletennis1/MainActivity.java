package com.nadun.tabletennis1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.Intent;;


public class MainActivity extends ActionBarActivity {

    Button okay,ok1;
    private EditText player1,player2;
    RadioButton p1t,p2t,set3,set5;
    public static boolean set,whoPlays;
    public static String[] names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.player1 =(EditText)findViewById(R.id.player1);
        this.player2 =(EditText)findViewById(R.id.player2);
        okay = (Button) findViewById(R.id.okBtn) ;
        ok1 = (Button) findViewById(R.id.ok1) ;

        p1t = (RadioButton)findViewById(R.id.tossP1);
        p2t = (RadioButton)findViewById(R.id.tossP2);

        set3 = (RadioButton)findViewById(R.id.set3);
        set5 = (RadioButton)findViewById(R.id.set5);

        okay.setEnabled(false);



        // listener for ok1 button
        ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pl1 = player1.getText().toString();
                String pl2 = player2.getText().toString();

                p1t.setText(pl1);
                p2t.setText(pl2);

                names = new String[]{pl1, pl2};
                okay.setEnabled(true);


            }
        });

        // listener for okay! button
        okay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // taking value set3 or set 5
                // set3 = 0 \\\\\\\\ set5 = 1
                if(set3.isChecked()){
                    set = false;
                }
                else if (set5.isChecked()){
                    set = true;
                }

                // player 1 = 0   player 2 = 1
                if(p1t.isChecked()){
                    whoPlays = false;
                }
                else if (p2t.isChecked()){
                    whoPlays = true;
                }
                startActivity(new Intent(MainActivity.this , ScoreActivity.class));


            }
        });

        
    }

    // hope these thing won't need in future
    public String[] getNames(){ return names; }

    public boolean getSETval(){ return set; }

    public boolean getTossWinner(){ return whoPlays; }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
