package au.sirius.landmarkreco.presentation

import android.graphics.Bitmap
import java.lang.IllegalArgumentException

fun Bitmap.centerCrop(desiredWidth:Int,desiredHeight:Int) : Bitmap{
    val xStart = (width - desiredWidth) / 2
    val yStart = (height - desiredHeight) / 2

    if(xStart < 0 || yStart < 0 || desiredWidth > width || desiredHeight > height){
        throw IllegalArgumentException("Invalid arguement for center dropping.")
    }

    return Bitmap.createBitmap(this,xStart,yStart,desiredWidth,desiredHeight)
}