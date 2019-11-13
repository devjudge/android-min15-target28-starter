package org.codejudge.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtNumber1, txtNumber2;
    Button addButton;
    TextView textView;

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
