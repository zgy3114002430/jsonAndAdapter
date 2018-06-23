package com.example.adapterandjson;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.adapterandjson.customAdapter.Myadapter;
import com.example.adapterandjson.model.Bean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Bean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        listView=(ListView)findViewById(R.id.listView);
        data=new ArrayList<Bean>();
        listView.setAdapter(new Myadapter(this,JsonToList("json.txt"),R.layout.listview_item));
    }

    //读取json数据并转出成String
    private String ReadJson(String fileName){
        StringBuilder stringBuilder=new StringBuilder();
        AssetManager assetManager=MainActivity.this.getAssets();
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
                Log.e("Json数据",stringBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    //获取json集合
    private List<Bean> JsonToList(String fileName){
        Bean bean;
        String result=ReadJson(fileName);
        try {
            JSONArray jsonArray=new JSONArray(result);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                bean=new Bean(jsonObject.getString("name"),
                        jsonObject.getString("code"),
                        jsonObject.getString("num"),
                        String.valueOf(jsonObject.getInt("num")*jsonObject.getInt("price")),
                        jsonObject.getString("price"));
                data.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
