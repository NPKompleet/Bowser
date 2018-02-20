package com.npkompleet.phenomenon.bowser.settings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.customview.CircularImageView;
import com.npkompleet.phenomenon.bowser.mvp.models.UserInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PHENOMENON on 2/19/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private Context context;
    private List<UserInfo> returnedUsers;
    private UserClickHandler clickHandler;

    public UserListAdapter(Context context, List<UserInfo> returnedUsers, UserClickHandler clickHandler) {
        this.context = context;
        this.returnedUsers = returnedUsers;
        this.clickHandler = clickHandler;
    }


    public void swapData(List<UserInfo> newUsers){
        returnedUsers.clear();
        returnedUsers.addAll(newUsers);
        this.notifyDataSetChanged();
    }

    public void addData(List<UserInfo> moreUsers){
        returnedUsers.addAll(moreUsers);
        this.notifyDataSetChanged();
    }


    @Override
    public UserListAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_userlist, parent, false);
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.UserViewHolder holder, int position) {

        UserInfo user= returnedUsers.get(position);
        holder.idView.setText(user.getUserId());
        holder.nameView.setText(user.getUserFirstName()+ " "+ user.getUserLastName());

        Picasso.with(context).load(user.getUserPicture())
                .placeholder(R.drawable.ic_person_outline)
                .error(R.drawable.ic_person_outline)
                .into(holder.imageView);

        if(user.getUserStatus().equals("Blocked")){
            holder.statusView.setImageResource(R.drawable.ic_block);
            holder.statusView.setBackgroundColor(context.getResources().getColor(R.color.blocked));
        }


    }

    @Override
    public int getItemCount() {
        return returnedUsers.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder implements ViewGroup.OnClickListener{
        @BindView(R.id.user_id)
        TextView idView;

        @BindView(R.id.user_name)
        TextView nameView;

        @BindView(R.id.user_image)
        CircularImageView imageView;

        @BindView(R.id.user_imageStatus)
        CircularImageView statusView;


        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position= getAdapterPosition();
            clickHandler.onClickUser(returnedUsers.get(position));
        }
    }

    public interface UserClickHandler{
        void onClickUser(UserInfo user);
    }


}
