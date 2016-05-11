package com.countriesinfo.app.network.services;

import android.support.annotation.NonNull;
import com.countriesinfo.app.model.Country;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.GET;

import java.util.List;

public interface NetworkService {

    @GET("/all")
    WaspRequest countryRequest(@NonNull final Callback<List<Country>> callback);
}
