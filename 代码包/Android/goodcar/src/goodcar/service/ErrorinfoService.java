package goodcar.service;

import java.util.ArrayList;

import goodcar.model.Errorinfo;
import goodcar.utils.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ErrorinfoService {

	private Database dbHelper;
	public ErrorinfoService(Context context){
		dbHelper=new Database(context);
	}
	
	public boolean insert(Errorinfo error){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into errorinfo(code,content) values(?,?)";
		Object obj[]={error.getCode(),error.getContent()};
		sdb.execSQL(sql, obj);	
		return true;
	}
	
	public Errorinfo getcontent(String code){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		Errorinfo error = new Errorinfo();
		Cursor cursor = sdb.rawQuery("select * from errorinfo where code=?",new String[]{code}); 
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			int contentIndex = cursor.getColumnIndex("content");
			String content = cursor.getString(contentIndex);
			int typeIndex = cursor.getColumnIndex("type");
			String type = cursor.getString(typeIndex);
			error.setContent(content);
			error.setType(type);
			cursor.moveToNext();
		}
		cursor.close();
		return error;
	}
}
