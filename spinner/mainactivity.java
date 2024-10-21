package com.example.spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private Spinner mySpinner;
    private TextView selectedItemTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySpinner = findViewById(R.id.my_spinner);
        selectedItemTextView = findViewById(R.id.selected_item);
// Create an ArrayAdapter using a string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,

                R.array.spinner_items, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        mySpinner.setAdapter(adapter);
// Set an item selected listener on the Spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                selectedItemTextView.setText("Selected: " + selectedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedItemTextView.setText("Nothing selected");
            }
        });
    }
}
