package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
TextView t,resu ;
EditText taille,poids;
RadioButton R1 ,R2;
CheckBox chechB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t =(TextView) findViewById(R.id.Txt1);
        resu = (TextView) findViewById(R.id.Resulat_Txt) ;
        poids = (EditText) findViewById(R.id.Poid_Txt);
        taille = (EditText) findViewById(R.id.taille_TXT);
        R1 = (RadioButton) findViewById(R.id.R1_Metre);
        R2 = (RadioButton) findViewById(R.id.R2_EnCentim);
        chechB =(CheckBox)findViewById((R.id.CheckB_Mega));
        resu.setText("");
    }
    public void onClickBnt(View v )
    {
if(poids.getText().length()!=0&&taille.getText().length()!=0){
        Double poid = Double.parseDouble(poids.getText().toString());
    Double tail = Double.parseDouble(taille.getText().toString());
    Double Resultat ;
    DecimalFormat df = new DecimalFormat("#.##");
    String compar="";



        if (R1.isChecked()==true)
        {
            Resultat = poid/(tail*tail);
            Button button=(Button) v;

            if (Resultat<18.5)
            {
                compar=" Insuffisance pondérale (maigreur)";
            }else if(Resultat>18.5&&Resultat<25)
            {
                compar="Corpulence normale ";
            }else if(Resultat>25&&Resultat<30){compar="Surpoids";}
            else if(Resultat>30&&Resultat<35){compar="Obésité modérée";}
            else if(Resultat>35&&Resultat<40){compar="Obésité sévère";}
            else if(Resultat>40){compar="Obésité morbide ou massive";}
            resu.setText(String.valueOf(df.format(Resultat))+"\n"+compar);

            ((Button)v).setText("Ok");
        }else if(R2.isChecked()==true)
        {
            Resultat = poid/((tail/100)*(tail/100));

            if (Resultat<18.5)
            {
                compar=" Insuffisance pondérale (maigreur)";
            }else if(Resultat>18.5&&Resultat<25)
            {
                compar="Corpulence normale ";
            }else if(Resultat>25&&Resultat<30){compar="Surpoids";}
            else if(Resultat>30&&Resultat<35){compar="Obésité modérée";}
            else if(Resultat>35&&Resultat<40){compar="Obésité sévère";}
            else if(Resultat>40){compar="Obésité morbide ou massive";}
            resu.setText(String.valueOf(df.format(Resultat))+"\n"+compar);
            Button button=(Button) v;
            ((Button)v).setText("Abdelkalek");
        }
}
else
    {
        resu.setTextColor(Color.RED);
        resu.setTextSize(12);
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