/**
 * @author Felipe Lucas Pablo
 * this class is to have the face drawn and have the features be randomize when first loaded.
 */

package edu.up.facemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import java.util.Random;
import android.graphics.RectF;


public class Face extends SurfaceView{

    // declare all of the paints that will be used
    private Paint skin = new Paint();
    private Paint eyes = new Paint();
    private Paint hair = new Paint();
    private Paint smile = new Paint();
    // used to create the smile for the face
    RectF mouth = new RectF(400f, 400f, 600f, 700f);


    // instance variables for the skin,eye,hair color and hair style
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        randomize();

    }
    @Override
    public void onDraw(Canvas canvas) {
        // make the background white
        super.onDraw(canvas);
        //setting the colors to each corresponding attribute
        skin.setColor(skinColor);
        eyes.setColor(eyeColor);
        hair.setColor(hairColor);

        // creating the head shape of the face
        canvas.drawCircle(500,500,400, skin);

        //creating the mouth of the face
        smile.setColor(Color.BLACK);
        canvas.drawArc(mouth, 0, 180, false, smile);

        // giving color to the eyes and creating them
        canvas.drawCircle(350,400,60, eyes);
        canvas.drawCircle(650,400,60, eyes);

        // creating a hairstyle and setting them from 0 to 2 for a total of 3
        if(hairStyle == 0){
            // nothing, since were making it bald
        }
        else if(hairStyle == 1){
            canvas.drawRect(400,50,600,300, hair);
        }
        else{
            canvas.drawRect(150,50,850,300,hair);
        }
    }

    // created a constructor where we have it randomize all the features of the face
    public void randomize(){
        //created a random variable using random
        Random rand = new Random();

        // have skinColor initially randomize to randomly selected, valid values.
        skinColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // same with the eyeColor randomly select, valid values.
        eyeColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // haircolor will be the same and be randomly selected, valid values.
        hairColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // hairstyle is different since we use a spinner and have 3 options well use random variable to randomize the options from 1-3
        hairStyle = rand.nextInt(3);
        invalidate();
    }
    // creating setters for each method so they

    // having this constructor set skin color
    public void setSkinColor(int colorSkin){
        skinColor = colorSkin;
        invalidate();
    }

    // have the color of the eyes be set
    public void setEyesColor(int color){
        eyeColor = color;
        invalidate();
    }
    // have the hair color be set
    public void setHairColor(int color){
        hairColor = color;
        invalidate();
    }

    public void setHairStyle(int style){
        hairStyle = style;
        invalidate();
    }
    // now getter methods for each method so it can be used in main activity
    // have a skin getter method
    public int getSkinColor(){
        return skinColor;
    }
    // make the eyeColor accescible
    public int getEyeColor(){
        return eyeColor;
    }
    // give hair color a getter method
    public int getHairColor(){
        return hairColor;
    }
    // same here giving a getter method to the hair style
    public int getHairStyle(){
        return hairStyle;
    }
    // helper method for the color changes depending on what was picked, the type so like eyes hair and skin
    public void colorUpdate(int red, int green , int blue, int type){
        int color = Color.rgb(red,green,blue);
        if(type == 0){
            hairColor = color;
        }
        else if(type == 1){
            eyeColor = color;
        }
        else{
            skinColor = color;
        }
        // very important so it can redraw
        invalidate();
    }
}
