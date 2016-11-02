package jean.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button2)).setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                EditText input1 = (EditText) findViewById(R.id.editText);
                int int1 = Integer.parseInt(input1.getText().toString());

                EditText input2 = (EditText) findViewById(R.id.editText2);
                int int2 = Integer.parseInt(input2.getText().toString());
                int res = int1 + int2;

                TextView text_view = (TextView) findViewById(R.id.textView5);
                text_view.setText("Result : " + res);
            }
        });
    }
}
