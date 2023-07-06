package com.example.eva.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eva.R;
import com.example.eva.clases.Revista;

import java.util.ArrayList;

public class Adaptadorrevista extends ArrayAdapter<Revista> {

    public Adaptadorrevista (Context ctx, ArrayList<Revista> datos){
        super(ctx, R.layout.lytrevista, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lytrevista, null);

        TextView nombre = (TextView)item.findViewById(R.id.lblrevist);
        nombre.setText(getItem(position).getRevista());
        TextView abre = (TextView)item.findViewById(R.id.lblabre);
        abre.setText(getItem(position).getAver());
        TextView iden = (TextView)item.findViewById(R.id.lblid);
        iden.setText(getItem(position).getIden());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgres);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlima())
                .into(imageView);
        return(item);
    }
}
