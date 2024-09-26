package com.example.news;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    List<News> newsList;
    boolean stopWorking = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsList = SourceG.generateContactList(3);

        RecyclerView recyclerView = findViewById(R.id.recycle);

        adapter = new Adapter(newsList);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HandlerThread handlerThread = new HandlerThread("HandlerThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper())
        {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Bundle bundle = msg.getData();
                News news = bundle.getParcelable("newNews");
                newsList.add(news);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        };
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!stopWorking)
                {
                    News news = new News("a","b","text","aa") ;
                    Message message = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("newNews",news);
                    message.setData(bundle);
                    handler.sendMessage(message);
                    handler.postDelayed(this,0);


                }
            }
        }, 3000);
    }
}
