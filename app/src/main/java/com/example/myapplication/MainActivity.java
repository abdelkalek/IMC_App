package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
TextView resu ;
EditText taille,poids;
RadioButton R1 ,R2;
CheckBox chechB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resu = (TextView) findViewById(R.id.Txt_Resultat2) ;
        poids = (EditText) findViewById(R.id.Txt_Poid2);
        taille = (EditText) findViewById(R.id.Txt_Taille2);
        R1 = (RadioButton) findViewById(R.id.Radio1_metre);
        R2 = (RadioButton) findViewById(R.id.Radio2_Centmetre);
        chechB =(CheckBox)findViewById((R.id.CheckB_Mega));
        resu.setText("");
    }
    public void calcule(double Resultat)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        String compar="";
        if (Resultat<18.5) { compar=" Insuffisance pondérale (maigreur)"; }
        else if(Resultat>18.5&&Resultat<25) { compar="Corpulence normale "; }
        else if(Resultat>25&&Resultat<30){compar="Surpoids";}
        else if(Resultat>30&&Resultat<35){compar="Obésité modérée";}
        else if(Resultat>35&&Resultat<40){compar="Obésité sévère";}
        else if(Resultat>40){compar="Obésité morbide ou massive";}
       if(chechB.isChecked()==false){compar="";}
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Resultat de IMC");
        dialog.setMessage(String.valueOf(df.format(Resultat))+"\n"+compar);
        dialog.setCancelable(true);
        dialog.setNegativeButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.cancel();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.show();

     //   resu.setText(String.valueOf(df.format(Resultat))+"\n"+compar);
    //    resu.setTextColor(Color.parseColor("#03A9F4"));
        //    ((Button)v).setText("Ok");
    }

    public void onClickBnt(View v )
    {
if(poids.getText().length()!=0&&taille.getText().length()!=0){
        Double poid = Double.parseDouble(poids.getText().toString());
    Double tail = Double.parseDouble(taille.getText().toString());
    Double Resultat ;


        if (R1.isChecked()==true)
        {
            Resultat = poid/(tail*tail);
            Button button=(Button) v;
            calcule(Resultat);

        }else if(R2.isChecked()==true)
        {
            Resultat = poid/((tail/100)*(tail/100));
            calcule(Resultat);

        }
}
else
    {
        resu.setTextColor(Color.RED);
        resu.setTextSize(18);
        resu.setText("donner des valeur a la poids ou taille");
    }
    }
    public void RestAction(View v )
    {
        poids.setText("");
        taille.setText("");
        resu.setText("");


    }
    
}