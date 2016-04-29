package com.countriesinfo.app.network;

import com.countriesinfo.app.model.Country;
import com.countriesinfo.app.model.ResponseModel;
import com.orhanobut.wasp.Callback;
import com.orhanobut.wasp.WaspRequest;
import com.orhanobut.wasp.http.GET;
import io.realm.RealmList;
import io.realm.RealmResults;

import java.util.List;

public interface NetworkService {

    @GET("/all")
    WaspRequest countryRequest(final Callback<List<Country>> callback);
}
