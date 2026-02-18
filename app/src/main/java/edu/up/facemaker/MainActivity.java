/**
 * @author Felipe Lucas Pablo
 * this class that calls the face class to have the face drawn and have the features be randomize when first loaded.
 */
package edu.up.facemaker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //These are the values for the Department Spinner
    String[] hairStyle = {
            "Bald",
            "Mohawk",
            "Long",
    };
    // have the face class be set here
    private Face myFace;
    // instance variables for RGB seekbars
    private SeekBar seekRed, seekGreen, seekBlue;
    // instance variable for radioButtons
    private RadioGroup group;
    //instance variable for spinner
    private Spinner spinner;
    // instance variable for button
    private Button randButton;
    // the type so like the eyes hair etc.
    private int typePicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face);
        myFace = findViewById(R.id.view);
        myFace.invalidate();

        //Initialize the seekbars of RGB
        seekRed = findViewById(R.id.redSeek);
        seekGreen = findViewById(R.id.greenSeek);
        seekBlue = findViewById(R.id.blueSeek);
        // Initialize radio buttons
        group = findViewById(R.id.radiogroup);
        // Initialize random Button
        randButton = findViewById(R.id.RandomFace);
        //have the face start up randomly
        myFace.randomize();
        //have the spinner initialize
        spinner = findViewById(R.id.spinner);
        // calling all the helper methods i wrote
        randButton();
        setSeekBars();
        radioButtons();
        helperSpinner();
        changeColorSB(myFace.getHairColor());

    }

    // helper for spinner
    public void helperSpinner(){
        //Initialize the Department Spinner
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.hairStyle);
        spinner.setAdapter(hairAdapter);
        spinner.setOnItemSelectedListener(this);

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed when no selection is made
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        myFace.setHairStyle(position);
    }

    //helper method for radio buttons
    public void radioButtons(){
        group.setOnCheckedChangeListener((group, Id)->{
            if(Id == R.id.Hair) {
                typePicked = 0;
                changeColorSB(myFace.getHairColor());
            }
            else if(Id == R.id.Eyes){
                typePicked = 1;
                changeColorSB(myFace.getEyeColor());
            }
            else if(Id == R.id.Skin){
                typePicked = 2;
                changeColorSB(myFace.getSkinColor());
            }

        });
    }
    //have a helper for teh random button face
    public void randButton() {
        // have the button when clicked randomly create a face, here have the spinner select a hairstyle
        // and have an if statement for the color on each seekbar
        randButton.setOnClickListener(v -> { myFace.randomize(); spinner.setSelection(myFace.getHairStyle());
        if(typePicked == 0) {
            changeColorSB(myFace.getHairColor());
        }
        else if(typePicked == 1) {
            changeColorSB(myFace.getEyeColor());
        }
        else {
            changeColorSB(myFace.getSkinColor());
            }
        });
    }

    public void setSeekBars(){
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb, int value, boolean fromUser) {
                myFace.colorUpdate(
                        seekRed.getProgress(),
                        seekGreen.getProgress(),
                        seekBlue.getProgress(),
                        typePicked
                );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekRed.setOnSeekBarChangeListener(listener);
        seekGreen.setOnSeekBarChangeListener(listener);
        seekBlue.setOnSeekBarChangeListener(listener);

    }
    public void changeColorSB(int color){
        seekRed.setProgress(Color.red(color));
        seekGreen.setProgress(Color.green(color));
        seekBlue.setProgress(Color.blue(color));
    }

}
