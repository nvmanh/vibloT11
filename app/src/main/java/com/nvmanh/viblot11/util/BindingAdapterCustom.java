package com.nvmanh.viblot11.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import com.nvmanh.viblot11.R;
import com.nvmanh.viblot11.model.User;
import com.nvmanh.viblot11.view.UserAdapter;
import com.nvmanh.viblot11.viewmodel.UserViewModel;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 21/11/2016.
 */

public final class BindingAdapterCustom {
    @BindingAdapter("app:bindAdapter")
    public static void bindAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("app:binding")
    public static void bindEditText(EditText view, final ObservableField<String> observableField) {
        if (view.getTag(R.id.binded) == null) {
            view.setTag(R.id.binded, true);
            view.addTextChangedListener(new SimpleTextWatcher() {
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    observableField.set(charSequence.toString());
                }
            });
        }
        String newValue = observableField.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

    @BindingConversion
    public static String convertBindableToString(BindableEditText bindableEditText) {
        return bindableEditText.get();
    }

    @BindingAdapter({ "app:binding" })
    public static void bindEditText(EditText view, final BindableEditText bindableString) {
        Pair<BindableEditText, SimpleTextWatcher> pair = (Pair) view.getTag(R.id.binded);
        if (pair == null || pair.first != bindableString) {
            if (pair != null) {
                view.removeTextChangedListener(pair.second);
            }
            SimpleTextWatcher watcher = new SimpleTextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindableString.set(s.toString());
                }
            };
            view.setTag(R.id.binded, new Pair<>(bindableString, watcher));
            view.addTextChangedListener(watcher);
        }
        String newValue = bindableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

    @BindingAdapter(value = { "items" }, requireAll = false)
    public static <T> void setAdapter(RecyclerView recyclerView,
            ObservableList<UserViewModel> items) {
        UserAdapter mAdapter = (UserAdapter) recyclerView.getAdapter();
        if (mAdapter == null) {
            mAdapter = new UserAdapter();
            recyclerView.setAdapter(mAdapter);
        } else {
        }
        mAdapter.setUsers(items);
        mAdapter.notifyDataSetChanged();
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }
}
