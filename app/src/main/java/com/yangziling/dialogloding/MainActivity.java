package com.yangziling.dialogloding;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import static com.yangziling.dialogloding.R.id.glide_main;

public class MainActivity extends AppCompatActivity {

    private Dialog mDialog;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    DialogUtils.closeDialog(mDialog);
                    break;
                case 2:
                    DialogUtils.closeDialog(mDialog);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.other_main:
                mDialog = DialogUtils.ShowDialog(MainActivity.this);
                mHandler.sendEmptyMessageDelayed(1, 5000);
                break;
            case glide_main:
                mDialog = DialogUtils.GildeImage(MainActivity.this);
                mHandler.sendEmptyMessageDelayed(2, 5000);
                break;
        }
    }
}
