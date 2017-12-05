package com.example.cookie;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        final Button Save = (Button) findViewById(R.id.save);
        final Button Back = (Button) findViewById(R.id.back);

        //뒤로가기 버튼 누르면 Main액티비티로 돌아감
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        // 저장 버튼을 누르면 Pattern클래스로 입력한 값을 넘겨줌
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendResult = new Intent();

                // 언제 구매했는지 (수입)
                EditText write수입날짜 = (EditText) findViewById(R.id.input_date);
                sendResult.putExtra("date1", write수입날짜.getText().toString());

                //현금,카드,이체 등등 (수입)
                EditText write수입분류 = (EditText) findViewById(R.id.input_method);
                sendResult.putExtra("수입분류", write수입분류.getText().toString());


                //얼마 (수입)
                EditText write수입금액 = (EditText) findViewById(R.id.input_sum);
                String strNo1 = write수입금액.getText().toString();

                if (!strNo1.isEmpty() && strNo1.matches("^[0-9]*$")) {
                    sendResult.putExtra("수입금액", Integer.parseInt(strNo1));
                }


                //뭐샀음? (수입)
                EditText write수입내용 = (EditText) findViewById(R.id.input_content);
                sendResult.putExtra("수입내용", write수입내용.getText().toString());


                Toast.makeText(Write.this, "저장 됐습니다", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, sendResult);
                finish();

            }
        });

        //수입항목
        final ToggleButton 수입 = (ToggleButton) this.findViewById(R.id.수입);
        final ConstraintLayout 수입내용 = (ConstraintLayout) findViewById(R.id.Content);
        final TableLayout 수입입력 = (TableLayout) findViewById(R.id.input_Write);
        수입.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (수입.isChecked()) {

                    Toast.makeText(getApplicationContext(), "수입항목을 입력하세요", Toast.LENGTH_SHORT).show();

                    수입.setBackgroundColor(Color.YELLOW);
                    수입.setTextColor(Color.BLUE);
                    수입입력.setVisibility(View.VISIBLE);
                    수입내용.setVisibility(View.VISIBLE);

                } else {

                    수입.setBackgroundColor(Color.LTGRAY);
                    수입.setTextColor(Color.BLACK);
                    수입입력.setVisibility(View.INVISIBLE);
                    수입내용.setVisibility(View.INVISIBLE);
                }

            }

        });

    }

}
