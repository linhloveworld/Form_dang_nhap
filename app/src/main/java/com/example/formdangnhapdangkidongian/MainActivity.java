package com.example.formdangnhapdangkidongian;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText txtTK, txtMK;
    private Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTK = (EditText) findViewById(R.id.txtTK);
        txtMK = (EditText) findViewById(R.id.txtMK);
        CheckBox ckLuu = (CheckBox) findViewById(R.id.ckLuu);
        btnDangKy = (Button) findViewById(R.id.btnDky);
        Button btnDangNhap = (Button) findViewById(R.id.btnDangnhap);

        btnDangKy.setOnClickListener((OnClickListener) this);
        btnDangNhap.setOnClickListener((OnClickListener) this);
    }

    public boolean OnCreateOptionMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void OnClick(View v)
    {
        String str = "NguyenVanA";
        String str2 = "ABCXYZ";
        if(v.getId() == btnDangKy.getId())
        {
            Intent i = new Intent(getApplicationContext(), Register.class);
            startActivity(i);
        }else if(v.getId()==btnDangKy.getId())
        {
            if(txtMK.getText().toString()==""||txtTK.getText().toString()=="")
                showAlert("Xin moi dang nhap day du thong tin");
        }else if(txtMK.getText().toString() == str && (txtTK
                .getText().toString() == str2))
        {
            showAlert("Dang nhap thanh cong");
        }
    }
    public void showAlert(String str)
    {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}