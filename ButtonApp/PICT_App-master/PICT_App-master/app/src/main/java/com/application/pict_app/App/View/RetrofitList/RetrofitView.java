package com.application.pict_app.App.View.RetrofitList;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.application.pict_app.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitView extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_view);
        getSupportActionBar().setTitle("Retrofit");
        initialiazation();
        getSuperHeros();
    }

    private void getSuperHeros() {

        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(RetrofitView.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        Call<List<MovieResults>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<MovieResults>>() {
            @Override
            public void onResponse(Call<List<MovieResults>> call, Response<List<MovieResults>> response) {
                List<MovieResults> myheroList = response.body();
                String[] oneHeroes = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    oneHeroes[i] = myheroList.get(i).getSuperName();
                }
                if(myheroList!=null||!myheroList.isEmpty()){
                    listView.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, oneHeroes));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(getApplicationContext(),myheroList.get(i).getSuperName(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<MovieResults>> call, Throwable t) {
                Toast.makeText(RetrofitView.this,"Error while getting the response",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initialiazation() {
        listView = findViewById(R.id.listview);
    }
}