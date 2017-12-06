package zbvc.cn.myapplication.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public int delete(int i) {
        SQLiteDatabase db=helper.getReadableDatabase();
        int len = db.delete("person","personid=?",new String[]{Integer.toString(i)});
        return len;
    }

    public int update(Person p){
        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", p.getName());
        cv.put("age", p.getAge());
        cv.put("phone", p.getPhone());
        int len = db.update("person", cv, "personid=?", new String[]{p.getId().toString()});
        return len;
    }

    public Person find(String id){
        SQLiteDatabase db = helper.getReadableDatabase();
//        db.rawQuery("select * from person where personid=?", new String[]{id});
        Cursor c = db.query("person", null, "personid=?", new String[]{id},null, null, null);
        if (c.moveToFirst()){
            int personid = c.getInt(c.getColumnIndex("personid"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String phone = c.getString(c.getColumnIndex("phone"));
            return new Person(personid, name, age, phone);
        }
        c.close();
        return null;
    }
}































