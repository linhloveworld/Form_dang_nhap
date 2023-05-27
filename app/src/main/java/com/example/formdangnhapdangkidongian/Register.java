package com.example.formdangnhapdangkidongian;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Register extends Activity implements OnClickListener{
    private EditText txtTk, txtMk, txtNhaplaiMk, txtHoten,txtNsinh;
    private Button btnDky, btnNhaplai, btnQuaylai;
    private RadioButton rdNam, rdNu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtHoten = (EditText) findViewById(R.id.txtHoten);
        txtMk = (EditText) findViewById(R.id.txtMk);
        txtNhaplaiMk = (EditText) findViewById(R.id.txtNhaplaiMk);
        txtNsinh = (EditText) findViewById(R.id.txtNsinh);
        txtTk = (EditText) findViewById(R.id.txtTk);
        btnDky = (Button) findViewById(R.id.btnDky);
        btnNhaplai = (Button) findViewById(R.id.btnNhaplai);
        btnQuaylai = (Button) findViewById(R.id.btnQuaylai);
        rdNam = (RadioButton) findViewById(R.id.rdNam);
        rdNu = (RadioButton) findViewById(R.id.rdNu);

        btnDky.setOnClickListener((OnClickListener) Register.this);
        btnNhaplai.setOnClickListener((OnClickListener) Register.this);
        btnQuaylai.setOnClickListener((OnClickListener) Register.this);
    }
    public boolean OnCreateOptionMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.register,menu);
        return true;
    }
    public void showAlert(String str)
    {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId() == btnDky.getId()) {
            if (txtTk.getText().toString().equals("")) {
                showAlert("Chua nhap ten tai khoan");
            } else {
                if (txtMk.getText().toString().equals("")) {
                    showAlert("Chua nhap mat khau");
                } else if (txtNhaplaiMk.toString().equals("")) {
                    showAlert("chua nhap mat khau");
                } else if (txtHoten.toString().equals("")) {
                    showAlert("Chua nhap ho ten");
                } else if (rdNam.getText() == null || rdNu.getText() == null) {
                    showAlert("Chua chon gioi tinh");
                } else {
                    if (!txtMk.getText().toString().equals(txtNhaplaiMk.getText().toString())) {
                        showAlert("Mat khau khong khop, hay nhap lai");
                    } else {
                        showAlert("Dang ki thanh cong");
                    }
                }
            }
        }
        if(v.getId() == btnNhaplai.getId())
        {
            txtHoten.setText("");
            txtMk.setText("");
            txtNhaplaiMk.setText("");
            txtNsinh.setText("");
            txtTk.setText("");
            rdNam.setChecked(false);
            rdNu.setChecked(false);
        }
        if(v.getId() == btnQuaylai.getId())
        {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    }
}