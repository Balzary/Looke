package com.looke.looke.userinterface.cell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.looke.looke.R;
import com.looke.looke.model.TesteModel;

public class ItemCell {

    private Context oContexto;

    private TesteModel objetoItem;

    private View viewPrincipal;
    private TextView lblTitulo;

    public ItemCell(Context pContexto, TesteModel pObjeto)
    {
        this.oContexto = pContexto;
        this.objetoItem = pObjeto;
    }

    public View montarCelula()
    {
        LayoutInflater li = (LayoutInflater) oContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        viewPrincipal = (View) li.inflate(R.layout.cell_item,null);

        obterControles();

        preencherControles();

        return viewPrincipal;
    }

    private void obterControles()
    {
        viewPrincipal = viewPrincipal.findViewById(R.id.viewPrincipal);
        lblTitulo = viewPrincipal.findViewById(R.id.lblTitulo);
    }

    private void preencherControles()
    {
        preencherLabels();
    }

    private void preencherLabels()
    {
        lblTitulo.setText(this.objetoItem.getName());
    }

}
