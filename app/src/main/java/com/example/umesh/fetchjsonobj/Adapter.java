package com.example.umesh.fetchjsonobj;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.umesh.fetchjsonobj.Interface.AdapterView;
import com.example.umesh.fetchjsonobj.Interface.InterecterView;
import com.example.umesh.fetchjsonobj.Interface.MainView;
import com.example.umesh.fetchjsonobj.Interface.PresenterView;
import com.example.umesh.fetchjsonobj.Model.Post;

import java.util.ArrayList;

/**
 * Created by umesh on 5/1/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements AdapterView {

    private final MainView mainView;
    private final PresenterView presenterView;
    private final ArrayList<Post> allPosts;

    public Adapter(MainView mainView){
        this.mainView = mainView;
        this.presenterView = (PresenterView) new Presenter(mainView,this);
        this.allPosts = new ArrayList<>();
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Post post = allPosts.get(position);
        holder.mId.setText(post.getId());
        holder.mUserId.setText(post.getUserId());
        holder.mTitle.setText(post.getTitle());
        holder.mBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return allPosts.size();
    }

    @Override
    public void addItem(Post post) {
        Log.d("Adapter","Adapter add item is called");
        Log.d("data in adapter",post.getId());
        allPosts.add(post);
    }

    @Override
    public void requestData() {
        presenterView.requestData();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mUserId,mId,mTitle,mBody;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.text_title);
            mBody = (TextView) itemView.findViewById(R.id.text_body);
            mUserId = (TextView) itemView.findViewById(R.id.text_userid);
            mId = (TextView) itemView.findViewById(R.id.text_id);
        }
    }
}
