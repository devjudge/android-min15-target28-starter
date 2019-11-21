package org.codejudge.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.codejudge.android.helper.ConfigHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtNumber1, txtNumber2;
    Button addButton;
    TextView textView;
    String API_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        addButton = findViewById(R.id.btnAdd);
        textView = findViewById(R.id.txtResult);

        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//      Access api_url from config.properties
        API_URL = ConfigHelper.getConfigValue(this, "api_url");
        Log.i("onClick ", API_URL);
        String numberText1 = txtNumber1.getText().toString();
        String numberText2 = txtNumber2.getText().toString();
        if (numberText1 == null || numberText1.equalsIgnoreCase("")) {
            textView.setText("NaN");
        }
        else if (numberText2 == null || numberText2.equalsIgnoreCase("")) {
            textView.setText("NaN");
        }
        else {
            Double num1 = Double.parseDouble(numberText1);
            Double num2 = Double.parseDouble(numberText2);
            Double sum = num1 + num2;
            textView.setText(sum.toString());
        }
    }
}
