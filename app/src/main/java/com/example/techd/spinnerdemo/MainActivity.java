package com.example.techd.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerStatic, spinnerDynamic;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addSpinner2Items();
        addButtonListener();
        addOnItemSelectListener();
    }

    /*
     * Demonstrates doing an action when an item is selected using the static spinner (the first one)
     * We have to create a custom listener to handle this (see CustomOnItemSelectedListener.java)
     */
    private void addOnItemSelectListener() {
        spinnerStatic = (Spinner) findViewById(R.id.static_spinner);
        spinnerStatic.setOnItemSelectedListener(new CustomOnItemSelectedListener()); //Sets the on item selected listener to the one we created (called CustomOnItemSelectedListener.java)
    }

    /*
     * Demonstrates dynamically adding items to a spinner during runtime using an ArrayList
     * We need an arraylist and a basic dataAdapter to tell Android to put the list into the spinner
     */
    private void addSpinner2Items() {
        spinnerDynamic = (Spinner) findViewById(R.id.dynamic_spinner);
        List<String> items = new ArrayList<String>(); //The list we use to populate the second spinner
        items.add("dynamic1");
        items.add("dynamic2");
        items.add("dynamic3");
        items.add("dynamic4");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);//This is one of Android's built in display adapters, it can take in an arraylist, and apply the items in the list as options to a spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDynamic.setAdapter(dataAdapter);
        //we can still add items to the spinner even after setting the adapter
        items.add("dynamic5");
        items.add("dynamic6");
    }

    /*
     * demonstrates getting the currently selected item from a spinner during runtime. This is when the button is pressed, not when an item is selected
     */
    private void addButtonListener() {
        spinnerDynamic = (Spinner) findViewById(R.id.dynamic_spinner);
        spinnerStatic = (Spinner) findViewById(R.id.static_spinner);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {  //With android, we can create custom OnClickListeners within the method. This is similar to me making another .java file

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "onClickListener: " +
                        "\nSpinner Static: " + String.valueOf(spinnerStatic.getSelectedItem()) +
                        "\nSpinner Dynamic: " + String.valueOf(spinnerDynamic.getSelectedItem()), Toast.LENGTH_LONG).show(); //to get the currently selected option from a spinner, we use String.valueOf(Spinner.getSelectedItem()
            }
        });
    }
}
