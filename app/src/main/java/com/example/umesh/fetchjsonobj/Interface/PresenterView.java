package com.example.umesh.fetchjsonobj.Interface;

import com.example.umesh.fetchjsonobj.Model.Post;

/**
 * Created by umesh on 5/1/2017.
 */

public interface PresenterView {
    void addItem(Post post);
    void requestData();
    void onSuccess();
}
