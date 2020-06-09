package com.example.ontapcustomlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtGia;
    Button btnThem, btnSua, btnXoa, btnMua;
    ListView lvMenu;

    ArrayList<MonAn> arrayList;//chứa thông tin
    ArrayList<MonAn> arrayListMua;
    AdapterMonAn adapterMonAn;//tạo adapter

    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapterMonAn = new AdapterMonAn(this,R.layout.dong_mon_an,arrayList);
        lvMenu.setAdapter(adapterMonAn);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonAn monAn = new MonAn("trang mieng", 10, R.drawable.tran_mieng, false);
                arrayList.add(monAn);
                adapterMonAn.notifyDataSetChanged();
            }
        });

        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonAn monAn = arrayList.get(position);
                edtTen.setText(monAn.getTen());
                edtGia.setText(String.valueOf(monAn.getGia()));
                vitri = position;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonAn monAn = new MonAn(edtTen.getText().toString(),Integer.valueOf(edtGia.getText().toString()));
                arrayList.set(vitri,monAn);
                adapterMonAn.notifyDataSetChanged();
            }
        });
        lvMenu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(vitri);
                adapterMonAn.notifyDataSetChanged();
                return false;
            }
        });
        btnMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<arrayList.size();i++){
                    if(arrayList.get(i).isCheck()==true){
                        arrayListMua.add(arrayList.get(i));
                    }
                }
                Intent intent= new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("dulieu",arrayListMua);
                startActivity(intent);
            }
        });
    }
    //menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemXoa:
                del();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void del() {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Hộp thoại xóa");
        dialog.setContentView(R.layout.dialog);

        //ánh xạ
        final EditText edtViTri = dialog.findViewById(R.id.editTextSo);
        Button btnDongY = dialog.findViewById(R.id.buttonDY);
        Button btnHuy = dialog.findViewById(R.id.buttonHuy);

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(Integer.parseInt(edtViTri.getText().toString().trim()));
                adapterMonAn.notifyDataSetChanged();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void AnhXa(){
        edtTen = findViewById(R.id.editTextTen);
        edtGia = findViewById(R.id.editTextGia);
        btnThem = findViewById(R.id.buttonThem);
        btnSua = findViewById(R.id.buttonSua);
        btnXoa = findViewById(R.id.buttonXoa);
        btnMua = findViewById(R.id.buttonMua);
        lvMenu = findViewById(R.id.listViewMenu);

        arrayList = new ArrayList<>();//khởi tạo mảng
        arrayListMua = new ArrayList<>();

        arrayList.add(new MonAn("com", 10, R.drawable.com, false));
        arrayList.add(new MonAn("ca", 10, R.drawable.ca, false));
        arrayList.add(new MonAn("cua", 10, R.drawable.cua, false));
        arrayList.add(new MonAn("banh", 10, R.drawable.banh, false));
        arrayList.add(new MonAn("dua hau", 10, R.drawable.dua_hau, false));
    }
}
