package at.theengine.android.home;

import java.io.IOException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageButton btnOn1;
	ImageButton btnOff1;
	ImageButton btnOn2;
	ImageButton btnOff2;
	ImageButton btnOn3;
	ImageButton btnOff3;
	ImageButton btnOn4;
	ImageButton btnOff4;
	ImageButton btnOn5;
	ImageButton btnOff5;
	
	private Context ctx;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ctx = this;
		
		getActionBar().hide();
		
		initButtons();
	}

	private void initButtons(){
		btnOn1 = (ImageButton) findViewById(R.id.btnOn1);
		btnOff1 = (ImageButton) findViewById(R.id.btnOff1);
		btnOn2 = (ImageButton) findViewById(R.id.btnOn2);
		btnOff2 = (ImageButton) findViewById(R.id.btnOff2);
		btnOn3 = (ImageButton) findViewById(R.id.btnOn3);
		btnOff3 = (ImageButton) findViewById(R.id.btnOff3);
		btnOn4 = (ImageButton) findViewById(R.id.btnOn4);
		btnOff4 = (ImageButton) findViewById(R.id.btnOff4);
		btnOn5 = (ImageButton) findViewById(R.id.btnOn5);
		btnOff5 = (ImageButton) findViewById(R.id.btnOff5);
		
		btnOn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("1");
			}
		});

		btnOff1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("2");
			}
		});
		
		btnOn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("3");
			}
		});

		btnOff2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("4");
			}
		});
		
		btnOn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("5");
			}
		});

		btnOff3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("6");
			}
		});
		
		btnOn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("7");
			}
		});

		btnOff4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("8");
			}
		});
		
		btnOn5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("9");
			}
		});

		btnOff5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendCommand("0");
			}
		});
	}
	
	private void sendCommand(String command){
		final String cmd = command;
		
		AsyncTask task = new AsyncTask() {
			
			private String resp;

			@Override
			protected Object doInBackground(Object... params) {
				try {
					resp = Sender.getStringResponseFromGetRequest("http://10.0.0.2:8888/" + cmd);
				} catch (IOException e) {
					resp = e.getMessage();
				}
				return null;
			}
			
			@Override
			protected void onPostExecute(Object result) {
				if(!resp.equals("OK")){
					Toast.makeText(ctx, resp, Toast.LENGTH_LONG).show();
				}
				super.onPostExecute(result);
			}
		};
		
		task.execute();
	}

}
