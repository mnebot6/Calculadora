package es.upv.etsit.aatt.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String operador_2_str="";
    TextView operador_2_tv;
    String digito, operando_pres="+", operando_pass="+";
    double A=0, P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operador_2_tv = findViewById(R.id.operando_2);

    }
    public void botonPulsado(View v){
        int id=v.getId();

        switch (id){
            case R.id.b0:
            case R.id.b1:
            case R.id.b2:
            case R.id.b3:
            case R.id.b4:
            case R.id.b5:
            case R.id.b6:
            case R.id.b7:
            case R.id.b8:
            case R.id.b9:
            case R.id.b_punto:
            //case R.id.b_signo:

                digito= ((Button)v).getText().toString();
                Toast.makeText(this, digito, Toast.LENGTH_SHORT).show();
                operador_2_str += digito;
                operador_2_tv.setText(operador_2_str);
                P = Double.parseDouble(operador_2_str);
                //System.out.println(operando);
                //String A_str = String.valueOf(A);
                //operador_2_tv.setText(A_str);
             break;

            case R.id.b_mas:
            case R.id.b_menos:
            case R.id.b_por:
            case R.id.b_div:
            case R.id.b_igual:

                operando_pres= ((Button)v).getText().toString();
                switch (operando_pass){
                    case "+": A = A + P;
                        break;
                    case "-": A = A - P;
                        break;
                    case "*": A = A * P;
                        break;
                    case "/": A = A / P;
                        break;
                    case "=":
                        break;
                }
                switch (operando_pres){
                    case "+": P=0;
                        break;
                    case "-": P=0;
                        break;
                    case "*": P=1;
                        break;
                    case "/": P=1;
                        break;
                }
                operando_pass=operando_pres;
                String A_str = String.valueOf(A);
                operador_2_tv.setText(A_str);
                operador_2_str="";
             break;
        }


    }


}
