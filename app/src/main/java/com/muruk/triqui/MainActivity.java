package com.muruk.triqui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private GridView tablero_grid;
    private String[] grid_info ={"-","-","-","-","-","-","-","-","-"};
    private String TAG = "CLICK";
    private String TAG2 = "Ganador";
    private int[] numeros = new int[8];
    private Adptador adptador;
    private int contador =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        tablero_grid = findViewById(R.id.tablero_grid);

        adptador = new Adptador();

        adptador.setContexto(getApplicationContext());
        adptador.setGrid_info(grid_info);

        tablero_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                TextView vista = view.findViewById(R.id.recuadro_tablero);


                   if (vista.getText().equals("-")){
                       if (contador%2 == 0 ){
                           contador = contador+1;

                           vista.setText("x");
                           grid_info[position] = String.valueOf(position);
                           /*for (int i =0; i < numeros.length; i++){
                               Log.e(TAG2,""+numeros[i]);
                           }*/

                           check("x");

                       }
                       else{
                           contador = contador+1;

                           vista.setText("0");

                       }
                   }






                    }

            private void check(String jugador) {

                    if (grid_info[0].equals("0") && grid_info[1].equals("1") && grid_info[2].equals("2") ) {
                        Log.e(TAG2,"has ganado "+jugador);
                    }else if (grid_info[3].equals("3") && grid_info[4].equals("4") && grid_info[5].equals("5") ) {
                        Log.e(TAG2,"has ganado "+jugador);

                    }
                }




        });

        tablero_grid.setAdapter(adptador);

    }
}