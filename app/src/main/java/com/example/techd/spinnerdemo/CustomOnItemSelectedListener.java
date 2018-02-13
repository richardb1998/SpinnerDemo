package com.example.techd.spinnerdemo;


import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    /*
     * This is an overridden method so we can do stuff when an item is selected
     * parent and View are the where the item was selected. This way you can modify views from within the listener
     * position is the position in the spinner, and id is the id of the spinner
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(), "OnItemSelect: " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
        //we use parent.getItemAtPosition(position) to get the actual item selected, then we use toString() to actually put what was selected into human-readable words
    }

    //This method is not used, it just had to be overridden to be able to work
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
