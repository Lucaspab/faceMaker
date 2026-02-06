/**
 * @author Felipe Lucas Pablo
 * this class that calls the face class to have the face drawn and have the features be randomize when first loaded.
 */
package edu.up.facemaker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //These are the values for the Department Spinner
    String[] hairStyle = {
            "Bald",
            "Mohawk",
            "Long",
    };
    private Face myFace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face);
        myFace = findViewById(R.id.view);
        myFace.invalidate();
        //Initialize the Department Spinner
        Spinner deptSpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.hairStyle);
        deptSpinner.setAdapter(hairAdapter);
    }

}