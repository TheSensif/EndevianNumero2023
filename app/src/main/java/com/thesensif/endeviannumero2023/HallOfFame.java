package com.thesensif.endeviannumero2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HallOfFame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);

        Intent secAct = new Intent(this, MainActivity.class);

        List<String> name = new ArrayList<String>();
        List<String> intents = new ArrayList<String>();
        List<String> time = new ArrayList<>();

        

        name.add("Sergi");
        intents.add("10");
        time.add("13:15");
        name.add("Sergi");
        intents.add("8");
        time.add("13:15");

        Button button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(secAct);
            }
        });

        /*
            Intent intent = getIntent();
        String mesage = intent.getStringExtra("contador");
         */
        TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams params2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout tbl = findViewById(R.id.tableLayout);
        for (int i = 0; i < intents.size(); i++) {
            TableRow row = new TableRow(this);
            TextView text1 = new TextView(this);
            TextView text2 = new TextView(this);
            TextView text3 = new TextView(this);
            text1.setText(name.get(i));
            text2.setText(intents.get(i));
            
            text3.setText(time.get(i));
            text1.setPadding(100,0,30,0);
            text2.setPadding(0,0,30,0);
            text3.setPadding(0,0,30,0);
            text1.setTextSize(26);
            text2.setTextSize(26);
            text3.setTextSize(26);

            text1.setLayoutParams(params1);
            text2.setLayoutParams(params1);
            text3.setLayoutParams(params1);

            row.addView(text1);
            row.addView(text2);
            row.addView(text3);
            row.setLayoutParams(params2);
            row.setPadding(0,30,0,0);
            tbl.addView(row);
        }



    }
}