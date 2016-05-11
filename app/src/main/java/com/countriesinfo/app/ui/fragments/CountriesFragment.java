package com.countriesinfo.app.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.OnClick;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ICallback;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.countriesinfo.app.R;
import com.countriesinfo.app.model.Country;
import com.countriesinfo.app.ui.MainActivity;
import com.countriesinfo.app.ui.binders.CountriesBinder;
import com.countriesinfo.app.utils.ItemDivider;
import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import static com.countriesinfo.app.network.RequestProvider.countryRequest;
import static com.countriesinfo.app.utils.LocalUtils.matchDrawable;

public class CountriesFragment extends BaseFragment {

    @NonNull
    @Bind(R.id.recyclerView)
    RecyclerView countriesList;
    @NonNull
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    DataBindAdapter<Country> countryAdapter;
    MainActivity activity;

    @Override
    public int getLayout() {
        return R.layout.fragment_countries;
    }

    @NotNull
    @Override
    public String tag() {
        return getClass().getSimpleName();
    }

    @NonNull
    @Override
    public void setToolBarTitle() {
        activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        assert (activity.getSupportActionBar() != null);
        activity.getSupportActionBar().setTitle(R.string.app_name);
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        setupRecyclerView();
        setRetainInstance(true);

      //TODO Store countries
        if(savedInstanceState==null)
        downloadCountries();
    }

    private void downloadCountries() {
        countryRequest(new ICallback<List<Country>>() {
            @Override
            public void onSuccess(List<Country> responseModel) {
                if (responseModel == null)
                    return;

                for (Country c : responseModel) {
                    if (matchDrawable(ContextHelper.getContext(), c.alpha2Code) != 0) {
                        countryAdapter.add(c, CountriesBinder.class);
                    }
                }
            }
        });
    }

    private void setupRecyclerView() {
        countriesList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        countriesList.addItemDecoration(new ItemDivider(ContextHelper.getContext(), R.drawable.item_divider));
        countryAdapter = new DataBindAdapter<>();
        countriesList.setHasFixedSize(true);
        countriesList.setAdapter(countryAdapter);
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }
}
