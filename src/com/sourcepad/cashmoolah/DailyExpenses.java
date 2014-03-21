package com.sourcepad.cashmoolah;

import java.util.List;

import org.w3c.dom.Attr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sourcepad.cashmoolah.models.Expense;

public class DailyExpenses extends Activity {

	private void updateExpenseList() {
		List<Expense> expenses = Expense.listAll(Expense.class);

		float totalExpenses = 0f;
		LinearLayout list = (LinearLayout) findViewById(R.id.expense_list);
		list.removeAllViews();

		for (Expense e : expenses) {
			TextView t = new TextView(this);
			t.setText("PHP " + e.getAmount() + " \b(" + e.getGroup() + ")");
			t.setTextColor(getApplicationContext().getResources().getColor(
					R.color.white_text));
			t.setTextSize((float) 22.0);

			totalExpenses += e.getAmount();

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			params.weight = 1.0f;

			t.setLayoutParams(params);
			list.addView(t);
		}

		TextView total = (TextView) findViewById(R.id.total_expenses);
		total.setText("PHP " + totalExpenses);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		Expense.executeQuery("DELETE FROM Expense");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_expenses);

	}

	@Override
	protected void onResume(){
		super.onResume();
		updateExpenseList();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.daily_expenses, menu);

		return true;
	}

	public void newExpense(View view) {
		Intent intent = new Intent(this, Tracking.class);
		startActivity(intent);
	}

}
