package com.countriesinfo.app.network;

import com.orhanobut.wasp.utils.AuthToken;
import com.orhanobut.wasp.utils.RequestInterceptor;
import com.orhanobut.wasp.utils.WaspRetryPolicy;

import java.util.Map;

public class RemoteRequestInterceptor implements RequestInterceptor {
    @Override
    public void onHeadersAdded(Map<String, String> map) {
    }

    @Override
    public void onQueryParamsAdded(final Map<String, Object> map) {
    }

    @Override
    public WaspRetryPolicy getRetryPolicy() {
        // Params hardcoded to retry twice after 7200 seconds
        return new WaspRetryPolicy(7200, 2, 1.5f);
    }

    @Override
    public AuthToken getAuthToken() {
        return null;
    }
}
