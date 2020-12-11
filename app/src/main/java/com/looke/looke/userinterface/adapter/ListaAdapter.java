package com.looke.looke.userinterface.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.looke.looke.R;
import com.looke.looke.model.TesteModel;
import com.looke.looke.model.TesteModelTopping;
import com.looke.looke.userinterface.cell.ItemCell;
import com.looke.looke.userinterface.cell.ItemToppingCell;
import com.looke.looke.userinterface.interfaces.IListaPaginacaoActivity;


public class ListaAdapter extends ArrayAdapter<Object> {

    private boolean terminouPaginacao = false;

    public void setTerminouPaginacao(boolean terminouPaginacao) {
        this.terminouPaginacao = terminouPaginacao;
    }

    public ListaAdapter(Context context) {
        super(context, 0);
        terminouPaginacao = false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Object objetoItem = this.getItem(position);

        return montarCelula(objetoItem);
    }

    public View montarCelula(Object pObjetoItem)
    {
        if(pObjetoItem instanceof TesteModel)
        {
            return new ItemCell(getContext(), (TesteModel)pObjetoItem).montarCelula();
        }
        else if(pObjetoItem instanceof TesteModelTopping)
        {
            return new ItemToppingCell(getContext(), (TesteModelTopping)pObjetoItem).montarCelula();
        }

        return new View(getContext());
    }

}
