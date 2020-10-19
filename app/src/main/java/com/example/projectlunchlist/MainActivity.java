package com.example.projectlunchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Restaurant r = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
    }

    private View.OnClickListener onSave = new View.OnClickListener() {
        public void onClick(View v) {
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.addr);

            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());

            RadioGroup type = (RadioGroup)findViewById(R.id.type);
            switch (type.getCheckedRadioButtonId())
            {
                case R.id.take_out:
                    r.setType("Take Out");
                    Toast.makeText(MainActivity.this, name.getText().toString() + " " + address.getText().toString() + " " + "Take Out", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.sit_down:
                    r.setType("Sit Down");
                    Toast.makeText(MainActivity.this, name.getText().toString() + " " + address.getText().toString()+ " " + "Sit Down", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.delivery:
                    r.setType("Delivery");
                    Toast.makeText(MainActivity.this, name.getText().toString() + " " + address.getText().toString()+ " " + "Delivery", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    };
}