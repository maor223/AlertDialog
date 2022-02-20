package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlert = findViewById(R.id.btnAlert);
        btnAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnAlert){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("select on");
            builder.setMessage("this is a massage");
            builder.setPositiveButton("i agree to the rules", new AlertDialogOnClickListener());
            builder.setNegativeButton("no, i don't agree", new AlertDialogOnClickListener());
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
    public class AlertDialogOnClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i==-1)
                Toast.makeText(MainActivity.this, "you agree", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "you don't agree", Toast.LENGTH_SHORT).show();
        }
    }
}