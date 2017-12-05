package com.example.cookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SavePattern extends AppCompatActivity {

    static final int WriteCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_pattern);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 수입사용내역 = findViewById(R.id.수입사용내역output);
        수입사용내역.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (지출)
        TextView 지출사용내역 = findViewById(R.id.지출사용내역output);
        지출사용내역.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 수입결제방식 = findViewById(R.id.수입결제방식output);
        수입결제방식.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (지출)
        TextView 지출결제방식 = findViewById(R.id.지출결제방식output);
        지출결제방식.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 수입이용날짜 = findViewById(R.id.수입이용날짜output);
        수입이용날짜.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (지출)
        TextView 지출이용날짜 = findViewById(R.id.지출이용날짜output);
        지출이용날짜.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (수입)
        TextView 수입금액 = findViewById(R.id.pat_sum1_output);
        수입금액.setSelected(true);

        // 문장이 길면 흐르게 처리하기 (지출)
        TextView 지출금액 = findViewById(R.id.pat_sum2_output);
        지출금액.setSelected(true);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent writeData) {
        super.onActivityResult(requestCode, resultCode, writeData);

        if (requestCode == WriteCode) {
            if (resultCode == RESULT_OK) {

                //Write에서 입력한 날짜 (수입)
                TextView useDate = (TextView) findViewById(R.id.수입이용날짜output);
                String date = writeData.getStringExtra("수입날짜");
                if (date != null)
                    useDate.setText(date);

                //Write에서 입력한 날짜 (지출)
                TextView useDate2 = (TextView) findViewById(R.id.지출이용날짜output);
                String date2 = writeData.getStringExtra("지출날짜");
                if (date2 != null)
                    useDate2.setText(date2);

                //Write에서 입력한 현금,카드 등등 (수입)
                TextView useWallet = (TextView) findViewById(R.id.수입결제방식output);
                String Wallet = writeData.getStringExtra("수입분류");
                if (Wallet != null)
                    useWallet.setText(Wallet);

                //Write에서 입력한 현금,카드 등등 (지출)
                TextView useWallet2 = (TextView) findViewById(R.id.지출결제방식output);
                String Wallet2 = writeData.getStringExtra("지출분류");
                if (Wallet2 != null)
                    useWallet2.setText(Wallet2);

                //Write에서 입력한 사용내용 (수입)
                TextView useUsing = (TextView) findViewById(R.id.수입사용내역output);
                String using = writeData.getStringExtra("수입내용");
                if (using != null)
                    useUsing.setText(using);

                //Write에서 입력한 사용내용 (지출)
                TextView useUsing2 = (TextView) findViewById(R.id.지출사용내역output);
                String using2 = writeData.getStringExtra("지출내용");
                if (using2 != null)
                    useUsing2.setText(using2);

                //Write에서 입력한 사용금액 (수입)
                TextView useMoney = (TextView) findViewById(R.id.pat_sum1_output);
                int money = writeData.getIntExtra("수입금액", 0);
                useMoney.setText(Integer.toString(money));

                //Write에서 입력한 사용금액 (지출)
                TextView useMoney2 = (TextView) findViewById(R.id.지출액output2);
                int money2 = writeData.getIntExtra("지출금액", 0);
                useMoney2.setText(Integer.toString(money2));

//                Toast.makeText(Main.class, "저장 됐습니다", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
