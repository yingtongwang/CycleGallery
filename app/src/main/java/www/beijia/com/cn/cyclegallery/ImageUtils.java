package www.beijia.com.cn.cyclegallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by Wangyingbao on 2016/6/3.
 */
public class ImageUtils {
    public static Bitmap imagePostScale(Bitmap originalImage, int Height) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        float scale = Height / (float) height;
        Matrix sMatrix = new Matrix();
        sMatrix.postScale(scale, scale);
        Bitmap miniBitmap = Bitmap.createBitmap(originalImage, 0, 0,
                originalImage.getWidth(), originalImage.getHeight(),
                sMatrix, true);
        originalImage.recycle();
        return miniBitmap;
    }
}
