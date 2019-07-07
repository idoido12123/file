package com.example.file;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    String st1,FILENAME;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.editText);
        tv1=(TextView) findViewById(R.id.textView);
    }

    public void write(View view) {
        if (et1.getText() != null) {
            st1 = et1.getText().toString();
        }
        FILENAME = et1.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(st1);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void read(View view) {
        try {
            InputStream is = openFileInput(FILENAME);
            InputStreamReader tmp = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(tmp);
            StringBuffer buffer = new StringBuffer();
            while ((st1= reader.readLine())!= null){
                buffer.append(st1+ "/n");
                tv1.setText(st1);
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}