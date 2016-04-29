package com.countriesinfo.app.utils;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.countriesinfo.app.R;
import com.countriesinfo.app.model.Country;
import com.countriesinfo.app.ui.BaseFragment;
import com.countriesinfo.app.ui.fragments.CountriesFragment;
import com.countriesinfo.app.ui.fragments.DetailFragment;
import org.parceler.Parcels;

import static com.common.android.utils.ContextHelper.getContext;
import static com.common.android.utils.extensions.FragmentExtensions.newInstance;

public class FragmentProvider {

    public static void showCountriesFragment() {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        final BaseFragment fragment = newInstance(CountriesFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }

    public static void showCountryDetailFragment(@NonNull final Country country) {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(Country.TAG, Parcels.wrap(country));
        final BaseFragment fragment = newInstance(DetailFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }
}
