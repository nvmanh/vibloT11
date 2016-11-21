package com.nvmanh.viblot11.viewmodel;

import android.databinding.ObservableField;
import com.nvmanh.viblot11.model.User;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 21/11/2016.
 */

public class UserViewModel implements BaseViewModel {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> dob = new ObservableField<>();

    public UserViewModel() {

    }

    public void update() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
