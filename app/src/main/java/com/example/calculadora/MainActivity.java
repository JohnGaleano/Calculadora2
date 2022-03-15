package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.backup.RestoreObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView vista_result;
    public String Temp;
    public String operando1;
    public String symb;
    public int op1 = 0;
    public int op2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vista_result = findViewById(R.id.Result);
        Button Num1 = findViewById(R.id.Numero1);
        Num1.setOnClickListener(this);
        Button Num2 = findViewById(R.id.Numero2);
        Num2.setOnClickListener(this);
        Button Num3 = findViewById(R.id.Numero3);
        Num3.setOnClickListener(this);
        Button Num4 = findViewById(R.id.Numero4);
        Num4.setOnClickListener(this);
        Button Num5 = findViewById(R.id.Numero5);
        Num5.setOnClickListener(this);
        Button Num6 = findViewById(R.id.Numero6);
        Num6.setOnClickListener(this);
        Button Num7 = findViewById(R.id.Numero7);
        Num7.setOnClickListener(this);
        Button Num8 = findViewById(R.id.Numero8);
        Num8.setOnClickListener(this);
        Button Num9 = findViewById(R.id.Numero9);
        Num9.setOnClickListener(this);
        Button Num0 = findViewById(R.id.Numero0);
        Num9.setOnClickListener(this);
    }


    @Override
    public void onClick(View Num)
    {
        Temp=vista_result.getText().toString();

        switch(Num.getId())
        {
            case R.id.Numero1:
                concatenar("1");
                break;
            case R.id.Numero2:
                concatenar("2");
                break;
            case R.id.Numero3:
                concatenar("3");
                break;
            case R.id.Numero4:
                concatenar("4");
                break;
            case R.id.Numero5:
                concatenar("5");
                break;
            case R.id.Numero6:
                concatenar("6");
                break;
            case R.id.Numero7:
                concatenar("7");
                break;
            case R.id.Numero8:
                concatenar("8");
                break;
            case R.id.Numero9:
                concatenar("9");
                break;
            case R.id.Numero0:
                concatenar("0");
                break;
            case R.id.SimboloDec:
                concatenar(".");
                break;
            case R.id.simboloSum:
                operando1 = Temp;
                symb = "+";
                op1 = Integer.parseInt(operando1);
                clarear();
                break;
            case R.id.simboloRest:
                operando1 = Temp;
                symb = "-";
                op1 = Integer.parseInt(operando1);
                clarear();
                break;
            case R.id.SimboloMult:
                operando1 = Temp;
                symb = "*";
                op1 = Integer.parseInt(operando1);
                clarear();
                break;
            case R.id.SimboloDiv:
                operando1 = Temp;
                symb = "/";
                op1 = Integer.parseInt(operando1);
                clarear();
                break;
            case R.id.SimboloSQRT:
                operando1 = Temp;
                op1 = Integer.parseInt(operando1);
                clarear();
                escribir(Dividir(op1));
                break;
            case R.id.SimboloLN:
                operando1 = Temp;
                op1 = Integer.parseInt(operando1);
                clarear();
                escribir(LN(op1));
                break;
            case R.id.SimboloFact:
                operando1 = Temp;
                op1 = Integer.parseInt(operando1);
                clarear();
                escribir(Fact(op1));
                break;
            case R.id.SimboloEQL:
                op2 = Integer.parseInt(Temp);
                escribir(operar(op1,op2,symb));
                break;
            case R.id.Del:
                clarear();
                break;
            default:
                 vista_result.setText(Temp);
                break;
        }
    }

public void clarear()
{

    vista_result.setText("");
}

public void concatenar(String num)
{
    vista_result.setText(Temp+num);
}

public String operar(int Op1, int Op2, String Symb)
{
    int ResB = 0;
    switch (Symb)
    {
        case "+":
            ResB=Op1+Op2;
            break;
        case "-":
            ResB=Op1-Op2;
            break;
        case "*":
            ResB=Op1*Op2;
            break;
        case "/":
            ResB=Op1/Op2;
            break;
    }
    ;
    return Integer.toString(ResB);
}

public void escribir(String value)
{
    vista_result.setText(value);
}

public String Dividir(int op1)
{
    Double Res;
    Res = Math.sqrt(op1);
    return Res.toString();
}

public String LN(int op1)
{
    Double Res;
    Res = Math.log(op1);
    return Res.toString();
}

public String Fact(int op1)
{
    int Num=1;
    for (int x= 1;x<op1;x++)
    {
        Num=Num*(x+1);
    }
    return Integer.toString(Num);
}

}