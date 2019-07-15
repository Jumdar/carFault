package goodcar.service;

import goodcar.model.Cars;
import goodcar.utils.Database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CarsService {
	private Database dbHelper;
	public CarsService(Context context){
		dbHelper=new Database(context);
	}
	
	public boolean insert(Cars car){
		SQLiteDatabase sdb=dbHelper.getReadableDatabase();
		String sql="insert into cars(carname,userid,oil,pressure,temperature,enginespeed) values(?,?,?,?,?,?)";
		Object obj[]={car.getCarname(),car.getUserid(),car.getOil(),car.getPressure(),car.getTemperature(),car.getEnginespeed()};
		sdb.execSQL(sql, obj);	
		return true;
	}
	
}
