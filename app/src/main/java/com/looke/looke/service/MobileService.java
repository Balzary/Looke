package com.looke.looke.service;

import com.looke.looke.model.TesteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//import com.looke.looke.model.AcaoUsuario;
//import com.looke.looke.model.AplicativoConfiguracao;
//import com.looke.looke.model.Assinatura;
//import com.looke.looke.model.FavoritoLista;
//import com.looke.looke.model.FiltroConteudo;
//import com.looke.looke.model.Medalha;
//import com.looke.looke.model.MensagemDireta;
//import com.looke.looke.model.NotificacaoTotal;
//import com.looke.looke.model.NotificacaoUsuario;
//import com.looke.looke.model.PostParametros;
//import com.looke.looke.model.Publicacao;
//import com.looke.looke.model.PublicacaoRegra;
//import com.looke.looke.model.Recompensa;
//import com.looke.looke.model.Resgate;
//import com.looke.looke.model.RetornoAcao;
//import com.looke.looke.model.RetornoLoginCadastro;
//import com.looke.looke.model.Usuario;
//import com.looke.looke.model.UsuarioPontuacao;


public interface MobileService
{
    @GET("teste.json")
    Call<List<TesteModel>> teste();
}
