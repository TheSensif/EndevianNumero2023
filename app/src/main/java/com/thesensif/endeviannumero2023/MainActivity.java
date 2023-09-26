package com.thesensif.endeviannumero2023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumber = randomNumber();

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.textNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int uNumber = Integer.parseInt(editText.getText().toString());
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();
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
                    toastShow(context,text,duration);
                }else {
                    CharSequence text = "El numer " + uNumber + " es mas grande";
                    toastShow(context,text,duration);
                }

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