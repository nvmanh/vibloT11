package com.nvmanh.viblot11.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import com.nvmanh.viblot11.util.BindableEditText;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 21/11/2016.
 */

public class MainViewModel implements BaseViewModel {
    public final BindableEditText bookTitle = new BindableEditText();
    public final ObservableList<UserViewModel> items = new ObservableArrayList<>();

    public MainViewModel() {
        for (int i = 0; i < 15; i++) {
            UserViewModel model = new UserViewModel();
            model.name.set("name " + (i + 1));
            model.dob.set((10 + i) + "-" + "02-" + (1890 + i));
            items.add(model);
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
