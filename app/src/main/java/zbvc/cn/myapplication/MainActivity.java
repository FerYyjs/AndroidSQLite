package zbvc.cn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import zbvc.cn.myapplication.bean.Person;
import zbvc.cn.myapplication.service.PersonService;
import zbvc.cn.myapplication.sql.DbOpenHelper;

public class MainActivity extends AppCompatActivity {
EditText etnumber,etname,etage,etphone;
    PersonService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DbOpenHelper helper=new DbOpenHelper(getApplicationContext());
//        helper.getReadableDatabase();
        etnumber= (EditText) findViewById(R.id.et_id);
        etname= (EditText) findViewById(R.id.et_name);
        etage= (EditText) findViewById(R.id.et_age);
        etphone= (EditText) findViewById(R.id.et_phone);
        service=new PersonService(getApplicationContext());
    }
    public void onclick(View v){
        String name = null,age = null,id = null,phone = null;
        Person person=new Person();
        switch (v.getId()){
            case R.id.btn_insert :
                name =etname.getText().toString();
                 age=etage.getText().toString();
                id=etnumber.getText().toString();
                phone=etphone.getText().toString();
               person=new Person(name,Integer.parseInt(age),phone);
                service.insert(person);
                break;
            case R.id.btn_del :
                id=etnumber.getText().toString();
                if (service.delete(Integer.parseInt(id)) > 0){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"Faild",Toast.LENGTH_SHORT);
                }
                break;
            case R.id.btn_update :
                person = new Person(Integer.parseInt(id), name, Integer.parseInt(age), phone);
                if (service.update(person) > 0){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT);
                }
                else{
                    Toast.makeText(this,"Faild",Toast.LENGTH_SHORT);
                }
                break;
            case R.id.btn_select :
                break;
            case R.id.btn_clear:
                etname.setText("");
                etage.setText("");
                etphone.setText("");
                break;
        }
    }
}
