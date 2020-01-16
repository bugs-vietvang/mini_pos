package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnDangNhap;
    private EditText edUsername, edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        edUsername.setText("quangthien");
        edPass.setText("123456");
    }

    private void AnhXa() {

        edUsername = (EditText)findViewById(R.id.edit_Username);
        edPass = (EditText)findViewById(R.id.edit_password);
        btnDangNhap = (Button)findViewById(R.id.btn_dangnhap);

    }

    public void openChonBan(View view) {
        String sTenDangNhap = edUsername.getText().toString();
        String sMatKhau = edPass.getText().toString();
        if(sTenDangNhap.equals("")||sMatKhau.equals(""))
            Toast.makeText(this, "nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
        else {
           if(sTenDangNhap.equals("quangthien")&& sMatKhau.equals("123456"))
           {
                Intent intent = new Intent(this, activity_Thanh_Toan_TaiKhoan.class);
                startActivity(intent);
            }
           else
               {
                Toast.makeText(this, "tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
               }
        }
    }
}
