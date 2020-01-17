package com.example.tranquangthien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialog_ThanhToan extends AppCompatActivity {

    private Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_thanh_toan);
        close = (Button)findViewById(R.id.btn_close);
    }

    public void close(View view) {

        Dialog dialog = new Dialog(this);
        dialog.cancel();
    }
}
