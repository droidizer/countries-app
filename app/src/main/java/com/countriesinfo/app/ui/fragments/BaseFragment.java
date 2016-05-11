package com.countriesinfo.app.ui.fragments;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ILayout;
import com.common.android.utils.interfaces.ILogTag;
import com.countriesinfo.app.ui.helpers.IBackPress;
import com.countriesinfo.app.ui.helpers.IToolBarTitle;

public abstract class BaseFragment extends Fragment implements ILayout, ILogTag, IToolBarTitle, IBackPress {
    protected View rootView;

    public BaseFragment() {
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        onViewCreated(savedInstanceState);
        setToolBarTitle();
    }

    @CallSuper
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onBackPressed() {
        ContextHelper.getContext().onBackPressed();
    }

    protected abstract void onViewCreated(Bundle savedInstanceState);
}
