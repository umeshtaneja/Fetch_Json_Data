package com.example.umesh.fetchjsonobj;

import android.util.Log;

import com.example.umesh.fetchjsonobj.Interface.InterecterView;
import com.example.umesh.fetchjsonobj.Interface.MainView;
import com.example.umesh.fetchjsonobj.Interface.PresenterView;
import com.example.umesh.fetchjsonobj.Model.Post;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by umesh on 5/1/2017.
 */

public class Interecter implements InterecterView {

    private final PresenterView presenterView;

    public Interecter(PresenterView presenterView) {
        this.presenterView = presenterView;
    }

    public int startIndex = 1;
    public int MaxIndex = 10;

    @Override
    public void requestData() {
        for (int i = startIndex; i < MaxIndex; i++) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://jsonplaceholder.typicode.com/posts/"+i)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d("Interacter", "Failure with exception" + e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        //Log.d("Interecter", "onresponse is called");
                        String responseData = response.body().string();
                        JSONObject json = new JSONObject(responseData);
                        Log.d("Interecter", "onresponse is called...");
                        Post post = Post.jsonToPost(json);
                        presenterView.addItem(post);
                        //Should call after fetching all the data; wrong updation
                        presenterView.onSuccess();
                        Log.d("Interacter", "Object successfully fetched" + post.getId());
                    } catch (JSONException e) {
                        Log.e("Interacter", "JSON Exception " + e);

                    }
                }

            });
      }
    }
}
