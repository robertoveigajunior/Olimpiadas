package com.example.rm31544.olimpiadas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class Home extends AppCompatActivity {

    private Spinner typeSpinner;
    private TextView txtName;
    private TextView txtAge;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        typeSpinner = (Spinner) findViewById(R.id.spinnerType);
        txtName = (TextView) findViewById(R.id.txtName);
        txtAge = (TextView) findViewById(R.id.txtAge);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupTime);


        List<Type> list = TypeDAO.listAll();

        SpinnerAdapter adapter = new ArrayAdapter<Type>(this, android.R.layout.simple_spinner_dropdown_item, list);
        typeSpinner.setAdapter(adapter);
    }

    private CharSequence[] dataBuilder() {
        int idSelected = radioGroup.getCheckedRadioButtonId();

        RadioButton radType = (RadioButton) findViewById(idSelected);

        String timeSelected = radType.getText().toString();

        final CharSequence[] listData = {
                getString(R.string.type) + ": " + typeSpinner.getSelectedItem().toString(),
                getString(R.string.name) + ": " + txtName.getText().toString(),
                getString(R.string.age) + ": " + txtAge.getText().toString(),
                getString(R.string.time) + ": " + timeSelected
        };
        return listData;
    }

    private void dialogBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.confirmData);
        builder.setItems(this.dataBuilder(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(Home.this);
                alert.setTitle(R.string.success);
                alert.setMessage(R.string.successOrder);
                alert.setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        txtName.requestFocus();
                        txtName.setText("");
                        txtAge.setText("");
                        radioGroup.check(-1);
                        typeSpinner.setSelection(0);
                    }
                });
                alert.show();
            }
        });
        builder.show();
    }

    private boolean validate() {
        if (txtName.getText().toString().isEmpty() ||
                txtAge.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    public void doOrder(View view) {
        if (this.validate()) {
            this.dialogBuilder();
        } else {
            Toast.makeText(this,getString(R.string.allFields),Toast.LENGTH_SHORT).show();
        }
    }
}
