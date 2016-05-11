package com.countriesinfo.app.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import com.common.android.utils.logging.Logger;
import com.countriesinfo.app.R;
import com.countriesinfo.app.model.Country;
import com.countriesinfo.app.ui.MainActivity;
import com.countriesinfo.app.ui.helpers.IBackPress;
import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;

import static com.bumptech.glide.Glide.with;
import static com.countriesinfo.app.utils.LocalUtils.*;

public class DetailFragment extends BaseFragment {
    @NonNull
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout toolBarLayout;
    @NonNull
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @NonNull
    @Bind(R.id.name)
    TextView name;
    @NonNull
    @Bind(R.id.region)
    TextView region;
    @NonNull
    @Bind(R.id.population)
    TextView population;
    @NonNull
    @Bind(R.id.currencies)
    TextView currencies;
    @NonNull
    @Bind(R.id.capital)
    TextView capital;
    @NonNull
    @Bind(R.id.flag)
    ImageView flagIcon;
    @Bind(R.id.callingCode)
    TextView callingCode;

    private Country country;
    private MainActivity activity;

    @Override
    public int getLayout() {
        return R.layout.fragment_detail;
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

        if (!TextUtils.isEmpty(country.name))
            activity.setTitle(country.name);
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle == null)
            return;

        country = Parcels.unwrap(bundle.getParcelable(Country.TAG));
        Logger.v(tag(), "model " + country);

        if (country == null)
            return;

        name.setText(country.name);
        capital.setText(country.capital);
        population.setText(country.population);
        region.setText(country.region);
        currencies.setText(stripBrackets(listToString(country.currencies)));
        callingCode.setText(stripBrackets(listToString(country.callingCodes)));
        with(flagIcon.getContext())
                .load(matchDrawable(getContext(), country.alpha2Code))
                .fitCenter()
                .into(flagIcon);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
