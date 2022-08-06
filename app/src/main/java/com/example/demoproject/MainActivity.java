package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recView ;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // method for initialize views
       init();

       //method for show api response data
       viewJsonData();
    }
    private  void init(){
        recView = findViewById(R.id.recView);
    }

    // method for setting up the recycler view
    private void setRecyclerView(List<ResponseModel> list) {

         //set the layout manager
         recView.setLayoutManager(new LinearLayoutManager(this));
        // for adding new values......
         list.add(new ResponseModel(111,111,"Sagar","yes"));
         MyAdapter adapter = new MyAdapter(list , this);
         adapter.notifyItemChanged(list.size()-1);
         recView.scrollToPosition(list.size()-1);
        recView.setAdapter(adapter);

    }

    private void viewJsonData() {
         Call<List<ResponseModel>> call = APIController.getInstance().getAPIset().getData();
         call.enqueue(new Callback<List<ResponseModel>>() {
             @Override
             public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                 Log.d("check","running");
                 List<ResponseModel> model = response.body();
                 setRecyclerView(model);
             }

             @Override
             public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                 Log.d("check",t.getLocalizedMessage());
                 showMessage(t.getLocalizedMessage());
             }
         });
       }
       private void showMessage(String message){
           Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
       }

       }
