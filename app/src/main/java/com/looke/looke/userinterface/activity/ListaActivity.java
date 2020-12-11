package com.looke.looke.userinterface.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.looke.looke.R;
import com.looke.looke.model.TesteModel;
import com.looke.looke.model.constantes.ActivityResultCodes;
import com.looke.looke.service.MobileServiceBuilder;
import com.looke.looke.userinterface.adapter.ListaAdapter;
import com.looke.looke.userinterface.common.Helper;
import com.looke.looke.userinterface.common.WsqRefresh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private Activity oActivity;

    private List<Object> objetosItem;

    private int paginaAtual;
    private String dataPaginacao;
    private boolean paginando;

    private View viewLista;
    private WsqRefresh swpAtualizar;
    private ListView lstItens;
    private ProgressBar loadingItens;
    private View viewSemResultado;
    private TextView lblSemResultadoMensagem;
    private Button btnSemResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista);

        obterControles();

        preencherControles();

        atualizarLista();
    }

    private void obterControles() {

        oActivity = this;

        viewLista = (View)findViewById(R.id.viewLista);
        swpAtualizar = (WsqRefresh)findViewById(R.id.swpAtualizar);
        lstItens = (ListView)findViewById(R.id.lstItens);
        loadingItens = (ProgressBar)findViewById(R.id.loadingItens);
        viewSemResultado = (View)findViewById(R.id.viewSemResultado);
        objetosItem = new ArrayList<>();

        swpAtualizar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                atualizarLista();
            }
        });

    }

    private void preencherControles()
    {
        loadingItens.setVisibility(View.VISIBLE);
    }

    public void atualizarLista()
    {
        paginando = false;

        paginaAtual = 0;

        dataPaginacao = Helper.formatarDataPaginacao(new Date());

        viewSemResultado.setVisibility(View.INVISIBLE);

        carregarLista();
    }

    public void carregarLista()
    {
        if(!paginando)
        {
            paginando = true;

            paginaAtual += 1;

            Call<List<TesteModel>> requestPosicao = MobileServiceBuilder.montarServico(oActivity).teste();

            requestPosicao.enqueue(new Callback<List<TesteModel>>() {
                @Override
                public void onResponse(Call<List<TesteModel>> call, Response<List<TesteModel>> response) {

                    if (!response.isSuccessful() || response.body() == null)
                    {
                        String mensagem = getString(R.string.erroProcessamento);

                        Helper.showToast(oActivity, mensagem);

                        return;
                    }

                    List<TesteModel> retorno = response.body();

                    if(retorno.size() > 0)
                    {
                        for (TesteModel item: retorno) {

                            objetosItem.add(item);

                            if(item.getTopping() != null && item.getTopping().size() > 0)
                            {
                                objetosItem.addAll(item.getTopping());
                            }
                        }
                    }

                    montarLista();
                }

                @Override
                public void onFailure(Call<List<TesteModel>> call, Throwable t) {

                    Log.e("erro",t.toString());

                    exibirMensagemRetornoVazio();

                }
            });

        }
    }

    public void montarLista()
    {
        ListaAdapter oAdapter = null;

        if(paginaAtual == 1)
        {
            oAdapter = new ListaAdapter(oActivity);

            if(objetosItem != null && objetosItem.size() > 0)
            {
                oAdapter.addAll(objetosItem);
                lstItens.setAdapter(oAdapter);
            }
            else
            {
                exibirMensagemRetornoVazio();
            }
        }
        else
        {
            oAdapter = (ListaAdapter)lstItens.getAdapter();

            if(objetosItem != null && objetosItem.size() > 0)
            {
                for (int i = 0; i < objetosItem.size(); i++)
                {
                    oAdapter.add(objetosItem.get(i));
                }
            }
            else
            {
                oAdapter.setTerminouPaginacao(true);
                oAdapter.notifyDataSetChanged();
            }
        }

        loadingItens.setVisibility(View.INVISIBLE);
        paginando = false;
        swpAtualizar.setRefreshing(false);
    }

    public void exibirMensagemRetornoVazio()
    {
        if (paginaAtual <= 1)
        {
            lblSemResultadoMensagem.setText("Nenhuma ação");
            viewSemResultado.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ActivityResultCodes.ARC_FECHAR_TELA)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                Intent returnIntent = new Intent();
                oActivity.setResult(Activity.RESULT_OK, returnIntent);
                oActivity.finish();
            }
        }
    }
}
