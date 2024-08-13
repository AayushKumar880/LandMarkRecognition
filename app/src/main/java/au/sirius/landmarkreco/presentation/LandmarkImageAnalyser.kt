package au.sirius.landmarkreco.presentation

import android.graphics.Bitmap
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import au.sirius.landmarkreco.domain.Classification
import au.sirius.landmarkreco.domain.LandmarkClassify

class LandmarkImageAnalyser(
    private val classifier: LandmarkClassify,
    private val onResult: (List<Classification>) -> Unit
) : ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if (frameSkipCounter % 60 == 0) {
            val rotationDegree = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321, 321)

            val result = classifier.classify(bitmap, rotationDegree)
            onResult(result)
        }
        image.close()
        frameSkipCounter++
    }
}