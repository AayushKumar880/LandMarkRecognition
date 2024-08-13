package au.sirius.landmarkreco.domain

import android.graphics.Bitmap

interface LandmarkClassify {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}