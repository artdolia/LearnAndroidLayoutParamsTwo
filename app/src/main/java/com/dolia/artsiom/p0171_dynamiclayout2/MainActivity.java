package com.dolia.artsiom.p0171_dynamiclayout2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){

        switch (v.getId()){

            case R.id.btnCreate:

                LinearLayout.LayoutParams lParams =
                        new LinearLayout.LayoutParams(wrapContent, wrapContent);

                int btnGravity = Gravity.LEFT;

                switch (rgGravity.getCheckedRadioButtonId()){

                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }

                lParams.gravity = btnGravity;

                Button btn = new Button(this);
                btn.setText(etName.getText().toString());
                llMain.addView(btn, lParams);
                break;
          
            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
