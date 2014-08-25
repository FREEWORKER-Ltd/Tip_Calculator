package com.github.Vladislav719.TipCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class CalcActivity extends Activity {

    TextView customTipText;

    EditText billEditText,
            tip10EditText, tip15EditText, tip20EditText, tipCustom,
            total10EditText, total15EditText, total20EditText, totalCustom;

    ViewGroup viewGroup;

    private class CustomTextWatcher implements TextWatcher {

        private View view;
        private CustomTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Double in = Double.parseDouble(s.toString());
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) instanceof EditText && !viewGroup.getChildAt(i).equals(this.view)) {
                    EditText tmp = (EditText) viewGroup.getChildAt(i);
                    tmp.setText("111");
                }
            }
        }

        double getRate(double value, int rate) {
            return value * rate / 100;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        customTipText = (TextView) findViewById(R.id.customTipTextView);

        billEditText = (EditText) findViewById(R.id.billEditText);
        tip10EditText = (EditText) findViewById(R.id.tip10EditText);
        tip15EditText = (EditText) findViewById(R.id.tip15EditText);
        tip20EditText = (EditText) findViewById(R.id.tip20EditText);
        tipCustom = (EditText) findViewById(R.id.tipCustomEditText);
        total10EditText = (EditText) findViewById(R.id.total10EditText);
        total15EditText = (EditText) findViewById(R.id.total15EditText);
        total20EditText = (EditText) findViewById(R.id.total20EditText);
        totalCustom = (EditText) findViewById(R.id.totalCustomEditText);

        viewGroup = (ViewGroup) billEditText.getParent();

        for (int i =0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof EditText) {
                ((EditText) viewGroup.getChildAt(i)).addTextChangedListener(new CustomTextWatcher(viewGroup.getChildAt(i)));
            }
        }

        ((SeekBar) findViewById(R.id.customSeekBar)).setOnSeekBarChangeListener(new SeekBar
                .OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                customTipText.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateValue(double value) {
        
    }

}
