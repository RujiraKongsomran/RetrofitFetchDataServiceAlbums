package com.rujira.retrofitfetchdataservicealbums;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.rujira.retrofitfetchdataservicealbums.Adapter.MyAdapter;
import com.rujira.retrofitfetchdataservicealbums.Model.Album;
import com.rujira.retrofitfetchdataservicealbums.Retrofit.IAlbumApi;
import com.rujira.retrofitfetchdataservicealbums.Retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    IAlbumApi albumApi;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        // Init API
        Retrofit retrofit = RetrofitClient.getInstance();
        albumApi = retrofit.create(IAlbumApi.class);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch data
        fetchData();
    }

    private void fetchData() {

        compositeDisposable.add(albumApi.getData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Album>>() {
            @Override
            public void accept(List<Album> albums) throws Exception {
                displayData(albums);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void displayData(List<Album> albums) {
        MyAdapter adapter = new MyAdapter(this, albums);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
