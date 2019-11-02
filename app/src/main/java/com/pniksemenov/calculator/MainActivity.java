package com.pniksemenov.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    String str="0";
    int sh =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Методы кнопок чисел:

     public void clik1(View view){
        if(sh==0) str="1";
        else
        str+=1;
         sh++;
        OnClik();
    }
     public void clik2(View view){
         if(sh==0) str="2";
         else
        str+=2;
         sh++;
        OnClik();
     }
     public void clik3(View view){
         if(sh==0) str="3";
         else
        str+=3;
         sh++;
        OnClik();
     }
     public void clik4(View view){
         if(sh==0) str="4";
         else
        str+=4;
         sh++;
        OnClik();
     }
     public void clik5(View view){
         if(sh==0) str="5";
         else
        str+=5;
         sh++;
        OnClik();
     }
     public void clik6(View view){
         if(sh==0) str="6";
         else
        str+=6;
         sh++;
        OnClik();
     }
     public void clik7(View view){
         if(sh==0) str="7";
         else
        str+=7;
         sh++;
        OnClik();
     }
     public void clik8(View view){
         if(sh==0) str="8";
         else
        str+=8;
         sh++;
        OnClik();
     }
     public void clik9(View view){
         if(sh==0) str="9";
         else
        str+=9;
         sh++;
        OnClik();
     }
     public void clik0(View view){
         if(sh==0) str="0";
         else
        str+=0;
         sh++;
        OnClik();
     }

     //Методы кнопок математических знаков:

     public void clikPlus(View view){
         if(sh==0) str="+";
         else
        str+="+";
         sh++;
        OnClik();
     }
     public void clik1Minus(View view){
         if(sh==0) str="-";
         else
        str+="-";
         sh++;
        OnClik();
     }
     public void clik1Multiplication(View view){
         if(sh==0) str="*";
         else
        str+="*";
         sh++;
        OnClik();
     }
     public void clik1Division(View view){
         if(sh==0) str="/";
         else
        str+="/";
         sh++;
        OnClik();

     }

     //меод кнопки "." для дробных чисел

     public void clik1Point(View view){
         if(sh==0) str="";
         else
        str+=".";
         sh++;
        OnClik();

     }

     public void clik1C(View view){ //сброс
        str="0";
        sh=0;

        OnClik();
     }

    private void display(String number) { //Передача текста в текстовую панель
        TextView text = (TextView) findViewById(R.id.text);
        text.setText("" + number);
    }


    // Код кнопки "=", здесь выполняются все вычисления
    public void clikEqually(View view){

        sh=0;
        String str2 = str;
        String[] arr = str2.split("(\\*|-|\\+|/)");
        String[] mas = str2.split("(\\|r|0|1|2|3|4|5|6|7|8|9)");

        ArrayList list = new ArrayList();

        for (int i=0;i<mas.length;i++){
            if (!mas[i].equals("")&&!mas[i].equals(".")){
                list.add(mas[i]);
            }
        }

        double doubMas[] = new double[arr.length];

        for (int i=0;i<doubMas.length;i++){
            doubMas[i]=Double.parseDouble(arr[i]);
        }

        for (int i=0; i<doubMas.length;i++){
            if (i<list.size()){
                if (list.get(i).equals("*")){
                    doubMas[i+1] = doubMas[i]*doubMas[i+1];
                    doubMas[i]=0;
                }
            }
            if (i<list.size()){
                if (list.get(i).equals("/")){
                    doubMas[i+1] = doubMas[i]/doubMas[i+1];
                    doubMas[i]=0;
                }
            }
        }

        double sum=0;
        double diff=0;
        for (int i =0;i<doubMas.length;i++){
            if (i<list.size()){
                if (list.get(i).equals("-")){
                    if (doubMas[i+1]==0){
                        double k=doubMas[i];
                        for (int j=i+1;j<doubMas.length;j++){
                            if (doubMas[j]!=0){
                                if (list.get(j-1).equals("+")){
                                    doubMas[j]=k+doubMas[j];
                                    doubMas[i]=0;
                                }
                                else {
                                    doubMas[j]=k-doubMas[j];
                                    doubMas[i]=0;
                                }
                            }
                        }
                    }
                    diff-=doubMas[i+1];
                    doubMas[i+1]=0;
                }
            }
        }

        for (int i=0;i<doubMas.length;i++){
            sum+=doubMas[i];
        }

        double res = sum + diff;
        str = ""+res;

        display(str);

        OnClik();
    }

    // Метод, который вызывает метод, отправляющий текст в текстовую панель
    public void OnClik(){
        display(str);
    }
}
