package com.example.tranquangthien.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tranquangthien.R;

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

        edUsername = (EditText)findViewById(R.id.ed_formDangNhap_Username);
        edPass = (EditText)findViewById(R.id.ed_formDangNhap_PassWord);
        btnDangNhap = (Button)findViewById(R.id.btn_formDangNhap_DangNhap);

    }

    public void openDangNhap(View view) {
        String sTenDangNhap = edUsername.getText().toString();
        String sMatKhau = edPass.getText().toString();
        if(sTenDangNhap.equals("")||sMatKhau.equals(""))
            Toast.makeText(this, "nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
        else {
           if(sTenDangNhap.equals("quangthien")&& sMatKhau.equals("123456"))
           {
                Intent intent = new Intent(this, activity_Chon_Mon.class);
                startActivity(intent);
            }
           else
               {
                Toast.makeText(this, "tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
               }
        }
    }

    public void openDangNhapFB(View view) {

        Toast.makeText(this,"Đăng nhập FaceBook thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, activity_Chon_Mon.class);
        startActivity(intent);

    }

    public void openDangNhapGG(View view) {

        Toast.makeText(this,"Đăng nhập GooGle thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, activity_Chon_Mon.class);
        startActivity(intent);

    }
}
