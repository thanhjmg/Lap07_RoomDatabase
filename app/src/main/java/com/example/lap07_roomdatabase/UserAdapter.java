package com.example.lap07_roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserView> {

    private Context context;
    private ArrayList<User> userArrayList;
    public void setData(ArrayList<User> data){
        this.userArrayList=data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {
            User user = userArrayList.get(position);
        if(user==null) {
            return;
        }
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if (userArrayList!=null){
            return userArrayList.size();
        }
        return 0;
    }

    public class UserView extends RecyclerView.ViewHolder{
        private TextView tvName;
        public UserView(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvName);
        }
    }
}
