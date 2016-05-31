package com.sibela.examples.temperatureconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.temperature_input)
    EditText temperatureInput;

    @Bind(R.id.to_celsius)
    RadioButton toCelsius;

    @Bind(R.id.temperature_output)
    TextView temperatureOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnEditorAction(R.id.temperature_input)
    public boolean onTemperatureInputEditorAction(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            convertTemperature();
            return true;
        }

        return false;
    }

    @OnClick(R.id.convert_button)
    public void convertClicked() {
        convertTemperature();
    }

    private void convertTemperature() {
        if (temperatureInput.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
            return;
        }

        float inputValue = Float.parseFloat(temperatureInput.getText().toString());

        if (toCelsius.isChecked()) {
            temperatureOutput.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
        } else {
            temperatureOutput.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
        }
    }
}
