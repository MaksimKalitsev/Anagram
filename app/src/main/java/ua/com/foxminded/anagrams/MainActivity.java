package ua.com.foxminded.anagrams;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.convert);
        EditText editText = findViewById(R.id.Type_a_word);
        TextView textView = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                if(editText.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, R.string.EmptyString, Toast.LENGTH_SHORT).show();
                else {
                    Anagram anagram = new Anagram();
                    String text = editText.getText().toString();
                    textView.setText(anagram.makeAnagram(text));

                }

            }
        });

    }
}