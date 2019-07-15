package goodcar.main;




import goodcar.model.User;
import goodcar.service.UserService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
		//定义控件
	    EditText edphone;
	    EditText edpassword;
	    EditText edbluetooth;
	    ImageButton register;
	    TextView login;
//	    // 定义变量
//	    private String phone = "";
//	    private String password = "";
//	    private String blue = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		// 找到变量，并且赋值
		login =(TextView) findViewById(R.id.login);
		register =(ImageButton) findViewById(R.id.register);
	    edphone =(EditText) findViewById(R.id.edphone);
		edpassword =(EditText) findViewById(R.id.edpassword);
		edbluetooth =(EditText) findViewById(R.id.edbluetooth);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(RegisterActivity.this,LoginActivity.class);
				startActivityForResult(it,1);				
			}
		});
		
		register.setOnClickListener(new ButtonClickListener());
	}

	private final class ButtonClickListener implements View.OnClickListener {
		public void onClick(View v) {
			
			String phone = edphone.getText().toString();
			String password = edpassword.getText().toString();
			String bluetooth = edbluetooth.getText().toString();
        
			
			UserService uService=new UserService(RegisterActivity.this);
			User user=new User();
			user.setPhone(phone);
			user.setPassword(password);
			user.setBluetooth(bluetooth);
				
			uService.insert(user);
			Toast.makeText(RegisterActivity.this,"注册成功!", Toast.LENGTH_LONG).show();
				Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(i);
				
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
