package com.looke.looke.model.constantes;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {

    private Context _contexto;

    public Config(Context pContexto)
    {
        _contexto = pContexto;
    }

    private void GravarValorGravadoAplicativo(String pChave, String pValor)
    {
        SharedPreferences settings = _contexto.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        editor.putString(pChave, pValor);
        editor.apply();
    }

    private String ObterValorGravadoAplicativo(String pChave)
    {
        if(_contexto != null)
        {
            SharedPreferences settings = _contexto.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);

            if(settings != null)
            {
                return settings.getString(pChave, "");
            }
        }

        return "";
    }

}
