package com.tt.xin.test04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

import static com.tt.xin.test04.R.string.btn;

public class MainActivity extends AppCompatActivity {
    protected TextView MyOutcome;
    protected Spinner spinner;
    protected EditText ed_a, ed_hr, ed_m;
    protected Button btn;
    protected int volt, voltage;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        setListener();
    }
    public void setView() {
        MyOutcome = (TextView) this.findViewById(R.id.respond);
        ed_a = (EditText) this.findViewById(R.id.input_a);
        ed_hr = (EditText) this.findViewById(R.id.intput_hr);
        ed_m = (EditText) this.findViewById(R.id.input_m);
        btn = (Button) this.findViewById(R.id.submit);
        spinner = (Spinner) this.findViewById(R.id.input_v);
        ArrayAdapter<CharSequence> Adapter_v = ArrayAdapter.createFromResource(
                this, R.array.option_vs,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(Adapter_v);
    }
    public void setListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("0");
                double a = Double.parseDouble(ed_a.getText().toString());
                double hr = Double.parseDouble(ed_hr.getText().toString());
                double m = Double.parseDouble(ed_m.getText().toString());
                double total_money = ((voltage * a) / 1000) * (hr * 30) * m;
                MyOutcome.setText("$" + df.format(total_money));
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView parent, View arg1, int arg2,
                                       long arg3) {
                voltage = (parent.getSelectedItemPosition() + 1) * 110;
            }
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}