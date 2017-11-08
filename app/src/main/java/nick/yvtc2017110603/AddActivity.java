package nick.yvtc2017110603;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    Button btnCancel,btnAdd;
    EditText edUserName,edTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btnCancel = (Button)findViewById(R.id.btn_cancel);
    }
    public void btnCancel(View view) {
        finish();
    }
    public void btnAdd(View view) {

        SQLiteDatabase db = SQLiteDatabase.openDatabase(DBInfo.DB_FILE, null, SQLiteDatabase.OPEN_READWRITE);
        edUserName = (EditText)findViewById(R.id.editText_account);
        edTel = (EditText)findViewById(R.id.editText_password);
        btnAdd = (Button)findViewById(R.id.btn_checked);
        String username = edUserName.getText().toString();
        String tel = edTel.getText().toString();
        String str = "Insert Into phone (username,tel) values('"+username+"','"+tel+"')";//直接寫資料庫語法
        db.execSQL(str);    //db資料庫去執行 str 字串
        finish();
    }
}
