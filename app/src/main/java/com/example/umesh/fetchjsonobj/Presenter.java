package com.example.umesh.fetchjsonobj;

import android.util.Log;

import com.example.umesh.fetchjsonobj.Interface.AdapterView;
import com.example.umesh.fetchjsonobj.Interface.InterecterView;
import com.example.umesh.fetchjsonobj.Interface.MainView;
import com.example.umesh.fetchjsonobj.Interface.PresenterView;
import com.example.umesh.fetchjsonobj.Model.Post;

/**
 * Created by umesh on 5/1/2017.
 */

public class Presenter implements PresenterView {

    private final InterecterView interacterView;
    private final AdapterView adapterView;
    private final MainView mainView;

    public Presenter(MainView mainView,AdapterView adapterView){
        this.mainView = mainView;
        this.adapterView = adapterView;
        this.interacterView = new Interecter(this);
    }

    @Override
    public void addItem(Post post) {
        Log.d("Presenter","addItem is called");
        adapterView.addItem(post);
    }

    @Override
    public void requestData() {
        if(mainView !=null){
            Log.d("Presenter","Request Data showProgress");
            mainView.showProgress();
        }
        interacterView.requestData();
    }

    @Override
    public void onSuccess() {
        if(mainView != null){
            Log.d("Presenter","Object successfully fetched, hideProgress");
            mainView.hideProgress();
        }
    }
}
