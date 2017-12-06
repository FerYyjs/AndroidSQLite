package zbvc.cn.myapplication.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import zbvc.cn.myapplication.bean.Person;
import zbvc.cn.myapplication.sql.DbOpenHelper;

/**
 * Created by Lenovo on 2017/12/4.
 */

public class PersonService {
    DbOpenHelper helper;
    public PersonService(Context applicationContext){
        helper =new DbOpenHelper(applicationContext);
    }
    public void insert(Person person){
        SQLiteDatabase db=helper.getReadableDatabase();
//        db.execSQL("insert into person(name,age,phone) values(?,?,?)",new Object[]{person.getName(),person.getAge(),person.getPhone()});
        ContentValues values=new ContentValues();
        values.put("name",person.getName());
        values.put("age",person.getAge());
        values.put("phone",person.getPhone());
        db.insert("person",null,values);
    }

    public void delete(int i) {
        SQLiteDatabase db=helper.getReadableDatabase();
        db.delete("person","personid=?",new String[]{Integer.toString(i)});
    }
}
