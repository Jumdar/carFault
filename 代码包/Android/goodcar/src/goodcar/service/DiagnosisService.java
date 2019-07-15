package goodcar.service;

import goodcar.model.Diagnosis;
import goodcar.utils.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DiagnosisService {

	private Database dbHelper;
	public DiagnosisService(Context context){
		dbHelper=new Database(context);
	}
	
	public boolean insert(Diagnosis diag){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into diagnosis(carid,userid,diaresult) values(?,?,?)";
		Object obj[]={diag.getCarid(),diag.getUserid(),diag.getDiaresult()};
		sdb.execSQL(sql, obj);	
		return true;
	}
}
