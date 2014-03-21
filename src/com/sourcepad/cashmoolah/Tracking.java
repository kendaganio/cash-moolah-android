package com.sourcepad.cashmoolah;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sourcepad.cashmoolah.models.Expense;

public class Tracking extends Activity {

	EditText amountField;
	EditText tagField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tracking);

		this.amountField = (EditText) findViewById(R.id.amount);
		this.tagField = (EditText) findViewById(R.id.group);

		setBehavior();
	}

	public void saveExpense(View view){
		float amount = Float.parseFloat(amountField.getText().toString());
		String tag = tagField.getText().toString();
		
		Expense e = new Expense(getApplicationContext(), tag, "test", amount, System.currentTimeMillis());
		e.save();
		
		finish();
	}
	
	public void setBehavior() {
		Button b = (Button) findViewById(R.id.first_beer_button);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				amountField.setText("140");
				tagField.setText("Beer");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tracking, menu);
		return true;
	}

}
