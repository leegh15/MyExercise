package com.lgh.tool.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lgh.tool.R;
import com.lgh.tool.utils.SMSUtil;

/**
 * Created by Administrator on 2016/2/29.
 */
public class SMSActivity extends Activity implements View.OnClickListener {
    private Button btn_send;
    private EditText et_code;
    private Button btn_submit;
    private EditText et_num;
    public static String APPKEY = "fe23daa997e4";
    public static String APPSECRET = "5d0324385a49429e6a55e6c99ec0e5cb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);
        et_num=(EditText)findViewById(R.id.et_num);
        et_code=(EditText)findViewById(R.id.et_code);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        SMSUtil.initSDK(this,APPKEY,APPSECRET);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                if (!TextUtils.isEmpty(et_num.getText().toString().trim())){
                    Toast.makeText(SMSActivity.this,"发送"+et_num.getText().toString().trim(),Toast.LENGTH_SHORT).show();
                    SMSUtil.getVerificationCode(SMSUtil.CHINA,et_num.getText().toString().trim());
                }
                break;
            case R.id.btn_submit:
                if (!TextUtils.isEmpty(et_code.getText().toString().trim())){
                    SMSUtil.submitVerificationCode(SMSUtil.CHINA,et_num.getText().toString().trim(), et_code.getText().toString().trim(), new SMSUtil.IValidateSMSCode() {
                        @Override
                        public void OnSucced() {
                            Toast.makeText(SMSActivity.this,"验证成功",Toast.LENGTH_SHORT).show();
                            SMSUtil.release();
                        }

                        @Override
                        public void OnFiled() {
                            Toast.makeText(SMSActivity.this,"验证失败",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;

        }
    }
}
