package com.looke.looke.userinterface.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.looke.looke.R;
import com.looke.looke.model.TesteModelTopping;

public class ItemToppingCell {

    private Context oContexto;

    private TesteModelTopping objetoItem;

    private View viewPrincipal;
    private TextView lblTitulo;

    //Passo 2 - Alterar nome do construtor
    public ItemToppingCell(Context pContexto, TesteModelTopping pObjeto)
    {
        this.oContexto = pContexto;
        this.objetoItem = pObjeto;
    }

    public View montarCelula()
    {
        LayoutInflater li = (LayoutInflater) oContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        viewPrincipal = (View) li.inflate(R.layout.cell_item_topping,null);

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
        lblTitulo.setText(this.objetoItem.getType());
    }

}
