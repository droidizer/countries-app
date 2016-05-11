package com.countriesinfo.app.network.error;

import com.countriesinfo.app.R;
import com.orhanobut.wasp.WaspError;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import static com.common.android.utils.ContextHelper.getContext;

final public class ErrorHandler {

    private ErrorHandler() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void handleWaspError(WaspError waspError) {
        Crouton.makeText(getContext(), getContext().getString(R.string.connection_error) + " " + waspError, Style.ALERT).show();
    }
}
