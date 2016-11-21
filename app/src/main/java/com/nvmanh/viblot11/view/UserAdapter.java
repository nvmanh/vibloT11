package com.nvmanh.viblot11.view;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nvmanh.viblot11.R;
import com.nvmanh.viblot11.databinding.AdapterUserBinding;
import com.nvmanh.viblot11.model.User;
import com.nvmanh.viblot11.viewmodel.UserViewModel;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.viet.manh on 21/11/2016.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ObservableList<UserViewModel> mUsers;
    private LayoutInflater mInflater;

    public UserAdapter() {

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) mInflater = LayoutInflater.from(parent.getContext());
        AdapterUserBinding binding =
                DataBindingUtil.inflate(mInflater, R.layout.adapter_user, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.set(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(ObservableList<UserViewModel> users) {
        mUsers = users;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private AdapterUserBinding binding;

        public UserViewHolder(AdapterUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void set(UserViewModel userViewModel) {
            binding.setUser(userViewModel);
        }
    }
}
