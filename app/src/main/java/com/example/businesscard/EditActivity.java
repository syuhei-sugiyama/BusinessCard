package com.example.businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText companyEdit;
    private EditText postalEdit;
    private EditText addressEdit;
    private EditText telEdit;
    private EditText faxEdit;
    private EditText emailEdit;
    private EditText urlEdit;
    private EditText positionEdit;
    private EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 共有プリファレンスにアクセスするために、SharedPreferencesのオブジェクトを取得
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // 共有プリファレンスに保存した値を取得する
        String company = sharedPreferences.getString("company", "");
        String postal = sharedPreferences.getString("postal", "");
        String address = sharedPreferences.getString("address", "");
        String tel = sharedPreferences.getString("tel", "");
        String fax = sharedPreferences.getString("fax", "");
        String email = sharedPreferences.getString("email", "");
        String url = sharedPreferences.getString("url", "");
        String position = sharedPreferences.getString("position", "");
        String name = sharedPreferences.getString("name", "");

        // 各部品のインスタンス取得
        companyEdit = findViewById(R.id.companyEdit);
        postalEdit = findViewById(R.id.postalEdit);
        addressEdit = findViewById(R.id.addressEdit);
        telEdit = findViewById(R.id.telEdit);
        faxEdit = findViewById(R.id.faxEdit);
        emailEdit = findViewById(R.id.emailEdit);
        urlEdit = findViewById(R.id.urlEdit);
        positionEdit = findViewById(R.id.positionEdit);
        nameEdit = findViewById(R.id.nameEdit);
        Button saveBtn = findViewById(R.id.saveBtn);
        Button cancelBtn = findViewById(R.id.cancelBtn);

        // 取得出来た値を各EditTextへセットする
        companyEdit.setText(company);
        postalEdit.setText(postal);
        addressEdit.setText(address);
        telEdit.setText(tel);
        faxEdit.setText(fax);
        emailEdit.setText(email);
        urlEdit.setText(url);
        positionEdit.setText(position);
        nameEdit.setText(name);

        // 保存ボタンのクリックリスナー登録
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 入力値を共有プリファレンスに保存するためのメソッド呼び出す
                saveData();
                // 画面終了
                finish();
            }
        });

        // キャンセルボタンのクリックリスナー登録
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画面終了
                finish();
            }
        });
    }

    private void saveData(){
        // 共有プリファレンスにアクセスするために、SharedPreferencesのオブジェクトを取得
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // SharedPreferences.Editorオブジェクトを取得
        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        // 各EditTextから入力値を取得して、key-valueで共有プリファレンスに保存
        spEditor.putString("company", companyEdit.getText().toString())
                .putString("postal", postalEdit.getText().toString())
                .putString("address", addressEdit.getText().toString())
                .putString("tel", telEdit.getText().toString())
                .putString("fax", faxEdit.getText().toString())
                .putString("email", emailEdit.getText().toString())
                .putString("url", urlEdit.getText().toString())
                .putString("position", positionEdit.getText().toString())
                .putString("name", nameEdit.getText().toString())
                .apply();
    }

}