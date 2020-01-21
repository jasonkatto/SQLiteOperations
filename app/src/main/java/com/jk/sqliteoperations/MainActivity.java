package com.jk.sqliteoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
 import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText name, pass, updateold, updatenw, delete;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editName);
        pass=findViewById(R.id.editPass);
        updateold=findViewById(R.id.editText3);
        updateold=findViewById(R.id.editText5);
        delete=findViewById(R.id.editText6);

        helper=new myDbAdapter(this);

    }
    public void addUser(View view) {
        String t1=name.getText().toString();
        String t2=pass.getText().toString();
        if (t1.isEmpty() || t2.isEmpty())
        {
            Message.message(getApplicationContext(), "Enter both Name and Password");
        }else {
            Long id=helper.insertData(t1,t2);
            if (id<=0){
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                name.setText( "");
                pass.setText("");
            }else {
                Message.message(getApplicationContext(), "Insertion successful");
                name.setText("");
                pass.setText("");
            }
        }
    }

    public void viewdata(View view) {
        String  data = helper.getData();
        Message.message(this, data);
    }



    public void update(View view) {
        String u1=updateold.getText().toString();
        String u2=updatenw.getText().toString();
        if (u1.isEmpty()|| u2.isEmpty()){
            Message.message(getApplicationContext(), "Enter Data");
        }
        else {
            int a = helper.updateName(u1,u2);
            if (a<=0){
                Message.message(getApplicationContext(), "Unsuccessful");
                updateold.setText("");
                updatenw.setText("");
            }else {
                Message.message(getApplicationContext(), "Updated");
                updateold.setText("");
                updatenw.setText(" ");
            }
        }
    }

    public void delete(View view) {
        String uname = delete.getText().toString();
        if(uname.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Data");
        }
        else{
            int a= helper.delete(uname);
            if(a<=0)
            {
                Message.message(getApplicationContext(),"Unsuccessful");
                delete.setText("");
            }
            else
            {
                Message.message(this, "DELETED");
                delete.setText("");
            }
        }

    }
}
