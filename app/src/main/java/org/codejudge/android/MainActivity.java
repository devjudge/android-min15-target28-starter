package org.codejudge.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.codejudge.android.helper.ConfigHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText txtNumber1;
  private EditText txtNumber2;
  private TextView textView;

  public MainActivity() {
    throw new UnsupportedOperationException();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    txtNumber1 = findViewById(R.id.txtNumber1);
    txtNumber2 = findViewById(R.id.txtNumber2);
    Button addButton = findViewById(R.id.btnAdd);
    textView = findViewById(R.id.txtResult);

    addButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
//    Access api_url from config.properties
    String emptyText = "NaN";
    String apiUrl = ConfigHelper.getConfigValue(this, "api_url");
    Log.i("onClick ", apiUrl);
    String numberText1 = txtNumber1.getText().toString();
    String numberText2 = txtNumber2.getText().toString();
    if (StringUtils.isEmpty(numberText1) || StringUtils.isEmpty(numberText2)) {
      textView.setText(emptyText);
    } else {
      Double num1 = Double.parseDouble(numberText1);
      Double num2 = Double.parseDouble(numberText2);
      Double sum = num1 + num2;
      textView.setText(sum.toString());
    }
  }
}
