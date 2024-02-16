package ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lab1and.R;

import com.example.lab1and.databinding.ActivityMainBinding;

import data.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_main);
        @NonNull ActivityMainBinding bindingVar = ActivityMainBinding.inflate(getLayoutInflater());
        ActivityMainBinding variableBinding = null;
        setContentView(variableBinding.getRoot());
        // setContentView(R.layout.activity_main);


        EditText myedit = findViewById(R.id.myedittext);
        Button mybutton = findViewById(R.id.mybutton);
        //TextView mytext= findViewById (R.id.textview);
        TextView mytext = variableBinding.textView;
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = myedit.getText().toString();
                mytext.setText("Your Name Is: " + editTextContent);
            }
        });
        bindingVar.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Respond to the checked state change
                if (isChecked) {
                    // checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
                } else {
                    //Checkbox is unchecked
                    Toast.makeText(MainActivity.this, "Checkbox UnChecked", Toast.LENGTH_SHORT).show();
                }
            }

        });
        model = new ViewModelProvider(this).get(MainViewModel.class);
        // Observe the LiveData

        model.isSelected.observe(this, selected -> {
            bindingVar.chk1.setChecked(selected);
            bindingVar.rd1.setChecked(selected);
            bindingVar.swt1.setChecked(selected);
        });
        bindingVar.chk1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toast.makeText(MainActivity.this, "Meme---- "+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();
//Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Checkbox Unchecked", Toast.LENGTH_SHORT).show();
            }
        });
        bindingVar.rd1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toast.makeText(MainActivity.this, "Meme---- "+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();

            //Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Radio Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Radio Unchecked", Toast.LENGTH_SHORT).show();
            }

        });
        bindingVar.swt1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Toast.makeText(MainActivity.this, "Meme----"+model.getIsSelected().getValue(), Toast.LENGTH_SHORT).show();
            // Respond to the checked state change
            if (model.isSelected.getValue()) {
                // Checkbox is checked
                Toast.makeText(MainActivity.this, "Switch Checked", Toast.LENGTH_SHORT).show();
            } else {
                // Checkbox is unchecked
                Toast.makeText(MainActivity.this, "Switch Unchecked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}