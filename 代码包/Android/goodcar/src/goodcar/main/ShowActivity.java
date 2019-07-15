package goodcar.main;

import goodcar.BLL.CarClient;
import goodcar.BLL.DecisionClient;
import goodcar.BLL.DecisionPackage;
import goodcar.BLL.DecisionThread;
import goodcar.BLL.ShowBar;
import goodcar.model.Errorinfo;
import goodcar.service.ErrorinfoService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONObject;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class ShowActivity extends Activity {
	
	private ArrayList<String> clientdata=null;
	private ImageButton start;
	private Handler handler;
	private Thread cthread;
	private Thread dthread;
	private ImageView info;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		start = (ImageButton) findViewById(R.id.start);
		Errorinfo error = new Errorinfo();
		final ErrorinfoService errsvc = new ErrorinfoService(ShowActivity.this);
		final ArrayList<String> content = null;
		final String jsondata = "1";
		
		final ProgressBar bar1 = (ProgressBar) findViewById(R.id.bar1);
		final ProgressBar bar2 = (ProgressBar) findViewById(R.id.bar2);
		final ProgressBar bar3 = (ProgressBar) findViewById(R.id.bar3);
		final ProgressBar bar4 = (ProgressBar) findViewById(R.id.bar4);
		final TextView show1 = (TextView) findViewById(R.id.show1);
		final TextView show2 = (TextView) findViewById(R.id.show2);
		final TextView show3 = (TextView) findViewById(R.id.show3);
		final TextView show4 = (TextView) findViewById(R.id.show4);
		
		
		info = (ImageView) findViewById(R.id.info);
		
		info.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(ShowActivity.this,InfoActivity.class);
				startActivityForResult(it,1);	
			}
		});
		
		handler = new Handler(){ 
			@Override 
			public void handleMessage(Message msg) { 
				super.handleMessage(msg); 
				switch (msg.what) { 
					case 1: 
						clientdata = (ArrayList<String>) msg.obj;
						ArrayList<Errorinfo> errlist = new ArrayList<Errorinfo>();
						for(int i=0;i<3;i++){
							errlist.add(errsvc.getcontent(clientdata.get(i)));
						}
						ShowBar showbar = new ShowBar();
						float percent1= showbar.getPersent(Integer.parseInt(clientdata.get(3)), 100);
						float percent2= showbar.getPersent(Integer.parseInt(clientdata.get(4)), 100);
						float percent3= showbar.getPersent(Integer.parseInt(clientdata.get(5)), 100);
						float percent4= showbar.getPersent(Integer.parseInt(clientdata.get(6)), 100);
						System.out.println(percent1);
						System.out.println(percent2);
						System.out.println(percent3);
						System.out.println(percent4);
						show1.setText((int)percent1+" km/h");
						show2.setText((int)percent2+"%");
						show3.setText((int)percent3+"%");
						show4.setText((int)percent4+"%");
						bar1.setProgress((int)percent1);
						bar2.setProgress((int)percent2);
						bar3.setProgress((int)percent3);
						bar4.setProgress((int)percent4);
						Toast.makeText(ShowActivity.this, "车辆存在故障",  Toast.LENGTH_SHORT).show();
						DecisionPackage dp = new DecisionPackage();
						System.out.println(dp.pack(errlist));
						JSONObject object = new JSONObject();
						object = dp.pack(errlist);
						String jsondata = String.valueOf(object);
						try {
							jsondata = new String(jsondata.getBytes(),"UTF-8");
						} catch (UnsupportedEncodingException e1) {
							e1.printStackTrace();
						}
						Thread dthread = new Thread(new DecisionThread(jsondata));
						dthread.start();
						dthread.interrupt();
						try {
							dthread.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					break; 
					
					case 2:
						String result = (String)msg.obj;
						System.out.println("111111111"+result);
						//Toast.makeText(ShowActivity.this, result, Toast.LENGTH_SHORT);
						break;
				} 
			} 
		}; 
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cthread = new Thread(new Runnable() { 
					@Override
					public void run() {
						CarClient carclient = new CarClient();
						ArrayList<String> getData = carclient.client();
						Message msg = Message.obtain();
						msg.obj = getData;
						msg.what = 1;
						handler.sendMessage(msg);
					}
				});
				cthread.start();
				cthread.interrupt();  
		        try {
					cthread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		});
		
	}
	
//	class DecisionThread implements Runnable{
//		String jsondata;
//		public DecisionThread(String jsondata) {
//			this.jsondata = jsondata;
//		}
//		public void run(){
//			DecisionClient decisionclient = new DecisionClient();
//			String getData="";
//			try {
//				getData = decisionclient.client(jsondata);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			Looper.prepare();
//			int result = Integer.parseInt(getData);
//			if(result == 0){
//				
//				Toast.makeText(ShowActivity.this, "车辆无故障，可放心使用", Toast.LENGTH_SHORT).show();  
//			}
//			else if(result == 1){
//				Toast.makeText(ShowActivity.this, "车辆存在故障", Toast.LENGTH_SHORT).show();  
//			} 
//			Looper.loop();
//		}
//	}
//	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.show, menu);
		return true;
	}
}

