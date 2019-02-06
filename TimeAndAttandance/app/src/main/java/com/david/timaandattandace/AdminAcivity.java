package com.david.timaandattandace;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.david.timaandattandace.database.Database;
import com.david.timaandattandace.model.EmpBean;

public class AdminAcivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ImageButton imgbtn_back;
    private EditText textuser;
    private EditText textpassword;
    private Button buttonLogin;
    int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_acivity);
        Toolbar mTopToolbar = findViewById(R.id.my_tool1);
        setSupportActionBar(mTopToolbar);

        init();


    }

    public void init() {
        textuser=findViewById(R.id.etuser);
        textpassword=findViewById(R.id.etpassword);
        buttonLogin=findViewById(R.id.btnlogin);
        imgbtn_back=findViewById(R.id.imgbut_back);
        clickEvent();
    }

    public void clickEvent() {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnlogin:
                        String user = textuser.getText().toString().trim();
                        String pass = textpassword.getText().toString().trim();
                        if (TextUtils.isEmpty(user)) {
                            textuser.setError("Enter User Name");
                            textuser.requestFocus();
                            break;
                        }
                       else if (TextUtils.isEmpty(pass)) {
                            textpassword.setError("Enter Password");
                            textpassword.requestFocus();
                            break;
                        }
                        else if(user.equals("Admin") && pass.equals("Admin")) {
                            Toast.makeText(AdminAcivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AdminAcivity.this, EmployeeUpdateActivity.class));
                        }else{
                            Toast.makeText(AdminAcivity.this, "Invalid UserName/Password", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    case R.id.imgbut_back :
                        startActivity(new Intent(AdminAcivity.this,EmployeeListActivity.class));
                        finish();
                        break;
                }

            }
        };
        buttonLogin.setOnClickListener(clickListener);
        imgbtn_back.setOnClickListener(clickListener);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        s = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
