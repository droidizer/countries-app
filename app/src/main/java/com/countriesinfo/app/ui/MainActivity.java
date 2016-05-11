package com.countriesinfo.app.ui;

import android.os.Bundle;
import android.view.WindowManager;
import com.countriesinfo.app.R;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import static com.common.android.utils.ContextHelper.getContext;
import static com.countriesinfo.app.ui.helpers.FragmentProvider.showCountriesFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showCountriesFragment();

        // Keep the screen always on
        if (com.common.android.utils.BuildConfig.DEBUG)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onNoConnectionAvailable() {
        Crouton.makeText(getContext(), getContext().getString(R.string.connection_error), Style.ALERT).show();
    }
}