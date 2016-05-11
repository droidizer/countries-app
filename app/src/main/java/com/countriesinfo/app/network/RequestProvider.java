package com.countriesinfo.app.network;

import android.support.annotation.NonNull;
import com.common.android.utils.interfaces.ICallback;
import com.countriesinfo.app.Environment;
import com.countriesinfo.app.model.Country;
import com.countriesinfo.app.network.services.NetworkService;
import com.orhanobut.wasp.*;
import com.orhanobut.wasp.utils.NetworkMode;

import java.net.CookiePolicy;
import java.util.List;

import static com.common.android.utils.ContextHelper.getContext;
import static com.countriesinfo.app.network.error.ErrorHandler.handleWaspError;

public class RequestProvider {

    private static final boolean MOCK_NETWORK = false;
    private static final String TAG = RequestProvider.class.getSimpleName();

    private static NetworkService service;

    @NonNull
    private static RemoteRequestInterceptor createRemoteRequestInterceptor() {
        return new RemoteRequestInterceptor();
    }

    private static NetworkService networkService() {
        if (service == null)
            service = createNetworkService(createRemoteRequestInterceptor());
        return service;
    }

    private static NetworkService createNetworkService(RemoteRequestInterceptor interceptor) {
        return new Wasp.Builder(getContext())
                .setEndpoint(Environment.active.baseUrl)
                .setNetworkMode(MOCK_NETWORK
                        ? NetworkMode.MOCK
                        : NetworkMode.LIVE)
                .enableCookies(CookiePolicy.ACCEPT_ALL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(NetworkService.class);
    }

    public static WaspRequest countryRequest(final ICallback<List<Country>> callback) {
        return networkService().countryRequest(new Callback<List<Country>>() {

            @Override
            public void onSuccess(Response response, List<Country> countries) {
                callback.onSuccess(countries);
            }

            @Override
            public void onError(WaspError waspError) {
                handleWaspError(waspError);
            }
        });
    }
}
