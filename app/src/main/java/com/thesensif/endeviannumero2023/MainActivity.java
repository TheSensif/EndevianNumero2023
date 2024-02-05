package com.thesensif.endeviannumero2023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    String history = "";
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent secAct = new Intent(this, HallOfFame.class);

        randomNumber = randomNumber();

        Button button = findViewById(R.id.button);
        Button changeActivity = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.textNumber);
        TextView counter = findViewById(R.id.contador);
        TextView textView = findViewById(R.id.textView);
        textView.setText(history);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador += 1;
                int uNumber = Integer.parseInt(editText.getText().toString());
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
                counter.setText(Integer.toString(contador));
                if (randomNumber == uNumber) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("¡Has ganado la partida!\n¿Quieres seguir jugando?")
                            .setPositiveButton(R.string.jugar, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    randomNumber = randomNumber();
                                    dialog.cancel();
                                }
                            }).setNegativeButton(R.string.cerrar, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    AlertDialog titulo = alert.create();
                    titulo.setTitle("Juego Ganado");
                    titulo.show();
                } else if (randomNumber > uNumber) {
                    CharSequence text = "El numer " + uNumber + " es mas pequeño";
                    history= history + uNumber + "\n";
                    textView.setText(history);
                    toastShow(context,text,duration);
                }else {
                    CharSequence text = "El numer " + uNumber + " es mas grande";
                    history= history + uNumber + "\n";
                    textView.setText(history);
                    toastShow(context,text,duration);
                }

            }
        });

        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secAct.putExtra("contador",Integer.toString(contador));
                startActivity(secAct);
            }
        });
    }

    private void toastShow(Context context, CharSequence text, int duration) {
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private int randomNumber() {
        return (int)(Math.random() * 100);
    }
}