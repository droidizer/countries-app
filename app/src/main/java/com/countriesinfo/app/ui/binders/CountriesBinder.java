package com.countriesinfo.app.ui.binders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.common.android.utils.ui.recyclerView.DataBinder;
import com.countriesinfo.app.R;
import com.countriesinfo.app.model.Country;
import org.jetbrains.annotations.NotNull;

import static android.view.View.OnClickListener;
import static com.common.android.utils.ContextHelper.getContext;
import static com.common.android.utils.extensions.ResourceExtensions.drawable;
import static com.countriesinfo.app.ui.helpers.FragmentProvider.showCountryDetailFragment;
import static com.countriesinfo.app.utils.LocalUtils.matchDrawable;

public class CountriesBinder extends DataBinder<Country, CountriesBinder.ViewHolder> {
    public CountriesBinder(@NotNull DataBindAdapter<Country> dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public void bindViewHolder(@NotNull ViewHolder viewHolder, int position) {

        final Country c = get(position);

        if (c == null)
            return;

        viewHolder.name.setText(c.name);
        viewHolder.icon.setImageDrawable(drawable(matchDrawable(getContext(), c.alpha2Code)));
        viewHolder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showCountryDetailFragment(c);
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.countries_item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        @Bind(R.id.country)
        TextView name;
        @NonNull
        @Bind(R.id.flag)
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
