package goodcar.main;

import goodcar.model.User;
import goodcar.service.UserService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends Activity {
	ImageView carinfo;
    ImageView logout;
    ImageView imphone;
    ImageView imblue;
    TextView tvphone;
    TextView tvblue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		carinfo = (ImageView) findViewById(R.id.carinfo);
		logout = (ImageView) findViewById(R.id.logout);
		imphone = (ImageView) findViewById(R.id.imphone);
		imblue = (ImageView) findViewById(R.id.imblue);
		tvphone = (TextView) findViewById(R.id.tvphone);
		tvblue = (TextView) findViewById(R.id.tvblue);
		
		SharedPreferences read = getSharedPreferences("user",MODE_PRIVATE);
		String p = read.getString("phone", "null");
		
		UserService userservice = new UserService(InfoActivity.this);
		User user = userservice.saveInfo(p);
		tvphone.setText(user.getPhone());
		tvblue.setText(user.getBluetooth());
		
		carinfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(InfoActivity.this,ShowActivity.class);
				startActivityForResult(it,1);				
			}
		});
		
		logout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(InfoActivity.this,LoginActivity.class);
				startActivityForResult(it,1);				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		return true;
	}

}
