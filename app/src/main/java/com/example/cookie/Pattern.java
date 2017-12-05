package com.example.cookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pattern extends AppCompatActivity {

    static final int WriteCode = 1;

    private String pat년월일;
    private String pat결제종류;
    private String pat사용내역;
    private String pat수입액;

    public void setdate(String date) {
        pat년월일 = date;
    }

    public void setpay(String 결제종류) {
        pat결제종류 = 결제종류;
    }

    public void setPat사용내역(String 사용내역) {
        pat사용내역 = 사용내역;
    }

    public void setPat수입액(String 수입액) {
        pat수입액 = 수입액;
    }

    public String getPat년월일() {
        return this.pat년월일;
    }

    public String getPat결제종류() {
        return this.pat결제종류;
    }

    public String getPat사용내역() {
        return this.pat사용내역;
    }

    public String getPat수입액() {
        return this.pat수입액;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_pattern);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 사용내역 = findViewById(R.id.pat_content_output);
        사용내역.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 결제방식 = findViewById(R.id.pat_method_output);
        결제방식.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 이용날짜 = findViewById(R.id.pat_date_output);
        이용날짜.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 수입금액 = findViewById(R.id.pat_sum1_output);
        수입금액.setSelected(true);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent writeData) {
        super.onActivityResult(requestCode, resultCode, writeData);

        if (requestCode == WriteCode) {
            if (resultCode == RESULT_OK) {

                //Write에서 입력한 날짜
                TextView useDate = (TextView) findViewById(R.id.pat_date_output);
                String date = writeData.getStringExtra("date1");
                if (date != null)
                    useDate.setText(date);

                //Write에서 입력한 현금,카드 등등
                TextView useWallet = (TextView) findViewById(R.id.pat_method_output);
                String Wallet = writeData.getStringExtra("수입분류");
                if (Wallet != null)
                    useWallet.setText(Wallet);

                //Write에서 입력한 사용내용
                TextView useUsing = (TextView) findViewById(R.id.pat_content_output);
                String using = writeData.getStringExtra("수입내용");
                if (using != null)
                    useUsing.setText(using);

                //Write에서 입력한 사용금액
                TextView useMoney = (TextView) findViewById(R.id.pat_sum1_output);
                int money = writeData.getIntExtra("수입금액", 0);
                useMoney.setText(Integer.toString(money));

            }

        }

    }

}
