package goodcar.BLL;

import goodcar.main.ShowActivity;
import android.R.integer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

public class DecisionThread implements Runnable {
	String jsondata;
	public DecisionThread(String jsondata) {
		this.jsondata = jsondata;
	}
	public void run(){
		DecisionClient decisionclient = new DecisionClient();
		String getData="";
		try {
			getData = decisionclient.client(jsondata);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//		Looper.prepare();
		int result = Integer.parseInt(getData);
		System.out.println(result);
//		Looper.prepare();  
//		  
//        Toast.makeText(, "子线程显示", Toast.LENGTH_SHORT).show();  
//        Looper.loop();   
	}
}
