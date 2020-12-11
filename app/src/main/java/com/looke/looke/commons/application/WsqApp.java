package com.looke.looke.commons.application;


import android.app.Activity;

import androidx.multidex.MultiDexApplication;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import com.looke.looke.R;
import com.looke.looke.model.constantes.Config;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class WsqApp extends MultiDexApplication {

	@Override
	public void onCreate() {

		super.onCreate();

		AndroidThreeTen
				.init(this);
	}

	  
}
