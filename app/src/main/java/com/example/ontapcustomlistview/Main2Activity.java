package com.example.ontapcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView lvPay;
    TextView txtMoney;
    int sum=0;

    ArrayList<MonAn> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvPay = findViewById(R.id.listViewPay);
        txtMoney = findViewById(R.id.textViewMoney);

        Intent intent = getIntent();
        arrayList = (ArrayList<MonAn>) intent.getSerializableExtra("dulieu");

        for(int i=0;i<arrayList.size();i++){
            sum+=arrayList.get(i).getGia();
        }

        AdapterMonAn adapterMonAn = new AdapterMonAn(Main2Activity.this, R.layout.dong_mon_an, arrayList);
        lvPay.setAdapter(adapterMonAn);

        txtMoney.setText(String.valueOf(sum));
    }
}
