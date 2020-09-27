package com.example.businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView companyText;
    private TextView postalText;
    private TextView addressText;
    private TextView telText;
    private TextView faxText;
    private TextView emailText;
    private TextView urlText;
    private TextView positionText;
    private TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 各TextViewのインスタンス取得
        companyText = findViewById(R.id.companyText);
        postalText = findViewById(R.id.postalText);
        addressText = findViewById(R.id.addressText);
        telText = findViewById(R.id.telText);
        faxText = findViewById(R.id.faxText);
        emailText = findViewById(R.id.emailText);
        urlText = findViewById(R.id.urlText);
        positionText = findViewById(R.id.positionText);
        nameText = findViewById(R.id.nameText);
    }

    @Override
    protected void onResume(){
        super.onResume();
        // 共有プリファレンスにアクセスするために、SharedPreferencesのオブジェクトを取得
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
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

        // 取得出来た値を各TextViewへセットする
        companyText.setText(company);
        postalText.setText(postal);
        addressText.setText(address);
        telText.setText(tel);
        faxText.setText(fax);
        emailText.setText(email);
        urlText.setText(url);
        positionText.setText(position);
        nameText.setText(name);
    }

    // 三点メニューをActivity上に表示する
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 三点メニューの項目が選択された時の処理
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        // 選択された項目のidで処理分岐
        // 「編集」選択時
        if (menuItem.getItemId() == R.id.edit) {
            // Intentクラスのインスタンス用意
            Intent intent = new Intent();
            // Intentのインスタンスに、遷移先のクラス(今回の場合はEditActivity)をセット
            intent.setClass(this, EditActivity.class);
            // IntentのインスタンスにセットされたActivityをスタートする
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}