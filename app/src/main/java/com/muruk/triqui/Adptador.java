package com.muruk.triqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adptador extends BaseAdapter {

    private Context contexto;
    private String[] grid_info;
    private LayoutInflater inflater;

    /*public Adptador(Context contexto, String[] grid_info) {
        this.contexto = contexto;
        this.grid_info = grid_info;
    }*/

    public Adptador() {
    }


    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }



    public void setGrid_info(String[] grid_info) {
        this.grid_info = grid_info;
    }

    @Override
    public int getCount() {
        return grid_info.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null){
            inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.recuadro,null);
        }
        TextView cuadro = convertView.findViewById(R.id.recuadro_tablero);
        cuadro.setText(grid_info[position]);



        return convertView;
    }
}
