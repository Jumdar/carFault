package goodcar.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {  
	
    static String name="user.db";  
    static int dbVersion=1;  
    public Database(Context context) {  
        super(context, name, null, dbVersion);  
    }    
    public void onCreate(SQLiteDatabase db) {  
    	
        String usersql="create table user(" +
        		"id integer primary key autoincrement," +
        		"phone varchar(20)," +
        		"password varchar(20),"+
        		"bluetooth varchar(20))";  
        
        String carsql="create table cars("+
        		"carid integer primary key autoincrement,"+
        		"carname varchar(20),"+
        		"userid varchar(20),"+
        		"oil integer,"+
        		"pressure varchar(10),"+
        		"temperature varchar(10),"+
        		"enginespeed varchar(10))";
        
        String diagnosissql="create table diagnosis("+
        		"carid integer primary key,"+
        		"userid integer,"+
        		"diaresult varchar(30))";
        
        String errorsql="create table errorinfo("+
        		"code varchar(10),"+
        		"content varchar(50),"+
        		"type varchar(10))";
        
        db.execSQL(usersql);  
        db.execSQL(carsql);
        db.execSQL(diagnosissql); 
        db.execSQL(errorsql);  
    }  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
    	
    }    
}
