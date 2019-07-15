package goodcar.service;

import goodcar.model.User;
import goodcar.utils.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class UserService {
	
	private Database dbHelper;
	public UserService(Context context){
		dbHelper=new Database(context);
	}
	
	//µÇÂ¼ÓÃ
	public boolean uservertify(String phone,String password){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="select * from user where phone=? and password=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{phone,password});		
		if(cursor.moveToFirst()==true){
			cursor.close();
			return true;
		}
		return false; 
	}
	//×¢²áÓÃ
	public boolean insert(User user){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into user(phone,password,bluetooth) values(?,?,?)";
		Object obj[]={user.getPhone(),user.getPassword(),user.getBluetooth()};
		sdb.execSQL(sql, obj);	
		return true;
	}
	
	public User saveInfo(String phone1){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql = "select phone,bluetooth from user where phone=?";
		Cursor cursor=sdb.rawQuery(sql, new String[]{phone1});
		String phone;
		String bluetooth;
		User user = new User();
		if(cursor.moveToFirst()){
			phone = cursor.getString(cursor.getColumnIndex("phone"));
			bluetooth = cursor.getString(cursor.getColumnIndex("bluetooth"));
			user.setPhone(phone);
			user.setBluetooth(bluetooth);
		}
		cursor.close();
		return user;
	}
}
