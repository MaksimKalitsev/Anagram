package ua.com.foxminded.anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mConvertBtn;
    private EditText mSentenceEt;
    private EditText mIgnoredSymbolsEt;
    private TextView mResultTv;

    private View.OnClickListener mConvertBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mSentenceEt.getText().toString().trim().equals("")) {
                Toast.makeText(MainActivity.this, R.string.EmptyString, Toast.LENGTH_SHORT).show();
            } else {
               final String text = mSentenceEt.getText().toString();
               final String ignoreSymbols = mIgnoredSymbolsEt.getText().toString();
                mResultTv.setText(StringUtils.makeAnagram(text, ignoreSymbols));
            }
        }
    };
    private final String ANAGRAM_KEY = "ANAGRAM_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConvertBtn = findViewById(R.id.convert_btn);
        mSentenceEt = findViewById(R.id.sentence_et);
        mIgnoredSymbolsEt = findViewById(R.id.ignoredsymbols_et);
        mResultTv = findViewById(R.id.result_tv);
        mConvertBtn.setOnClickListener(mConvertBtnClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(ANAGRAM_KEY, mResultTv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mResultTv.setText(savedInstanceState.getString(ANAGRAM_KEY));
    }
}