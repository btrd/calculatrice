package jean.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "CalcFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        boolean multiplication = settings.getBoolean("multiplication", false);

        Switch switchMul = (Switch) findViewById(R.id.switch1);
        switchMul.setChecked(multiplication);

        if (multiplication) {
            ((TextView) findViewById(R.id.textView)).setText("*");
        } else {
            ((TextView) findViewById(R.id.textView)).setText("+");
        }

        ((Button) findViewById(R.id.button2)).setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                EditText input1 = (EditText) findViewById(R.id.editText);
                int int1 = Integer.parseInt(input1.getText().toString());

                EditText input2 = (EditText) findViewById(R.id.editText2);
                int int2 = Integer.parseInt(input2.getText().toString());

                Boolean isChecked = ((Switch) findViewById(R.id.switch1)).isChecked();
                int res;
                if (isChecked) {
                    res = int1 * int2;
                } else {
                    res = int1 + int2;
                }

                TextView text_view = (TextView) findViewById(R.id.textView5);
                text_view.setText("Resultat : " + res);
            }
        });

        ((Switch) findViewById(R.id.switch1)).setOnClickListener(new Switch.OnClickListener(){
            public void onClick(View v) {
                Boolean isChecked = ((Switch) findViewById(R.id.switch1)).isChecked();
                setOperation(isChecked);
            }
        });

    }

    private void setOperation(Boolean multiplication) {
        if (multiplication) {
            ((TextView) findViewById(R.id.textView)).setText("*");
        } else {
            ((TextView) findViewById(R.id.textView)).setText("+");
        }
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("multiplication", multiplication);

        // Commit the edits!
        editor.commit();
    }
}
