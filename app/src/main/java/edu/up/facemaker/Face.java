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


public class Face extends SurfaceView{
    private Paint magenta = new Paint();

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        magenta.setColor(Color.MAGENTA);
    }

    int skinColor = 0;
    int eyeColor = 0;
    int hairColor = 0;
    int hairStyle = 0;


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
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(500.0f, 500.0f, 400.0f, magenta);
    }
}
