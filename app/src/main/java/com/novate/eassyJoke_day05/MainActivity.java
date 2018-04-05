package com.novate.eassyJoke_day05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hc.baselibrary.ioc.dialog.AlertDialog;
import com.hc.baselibrary.ioc.ioc.ViewById;
import com.hc.framelibrary.ioc.BaseSkinActivity;

/**
 * Email: 2185134304@qq.com
 * Created by JackChen 2018/4/5 18:05
 * Version 1.0
 * Params:
 * Description:  万能Dialog 的具体使用场景
*/
public class MainActivity extends BaseSkinActivity implements View.OnClickListener{


    @ViewById(R.id.btn_dialog)
    Button btn_dialog ;


    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {
        btn_dialog.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        showDialogFromBottom() ;
    }

    private void showDialogFromBottom() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setContentView(R.layout.detail_comment_dialog)
                .formBottom(true).fullWidth().show();

        // 获取EditText的输入框的内容
        final EditText commentEt = dialog.getView(R.id.comment_editor) ;
        dialog.setOnclickListener(R.id.submit_btn , new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "输入的内容为：" + commentEt.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });


        dialog.setOnclickListener(R.id.account_icon_weibo , new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "点击微博分享了" + commentEt.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });


        dialog.setOnclickListener(R.id.account_icon_tencent, new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this , "点击qq分享了" + commentEt.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
