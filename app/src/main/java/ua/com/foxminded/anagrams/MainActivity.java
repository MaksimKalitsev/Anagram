package ua.com.foxminded.anagrams;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button convert_btn;
    EditText sentence_et;
    EditText ignoredSymbols_et;
    TextView result_tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert_btn = findViewById(R.id.convert);
        sentence_et = findViewById(R.id.sentence);
        ignoredSymbols_et = findViewById(R.id.ignoredSymbols);
        result_tv = findViewById(R.id.result);
        convert_btn.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                if (sentence_et.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, R.string.EmptyString, Toast.LENGTH_SHORT).show();
                } else {
                    String text = sentence_et.getText().toString();
                    String ignoreSymbols = ignoredSymbols_et.getText().toString();
                    result_tv.setText(StringUtils.makeAnagram(text, ignoreSymbols));
                }
            }
        });
    }
}