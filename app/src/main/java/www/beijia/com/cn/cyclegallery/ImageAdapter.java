package www.beijia.com.cn.cyclegallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {

    private ImageView[] mImageViewList;
    private Context mContext;
    public List<Map<String, Object>> list;
    final int Height = 200;

    public Integer[] imgs = {R.mipmap.image01, R.mipmap.image02,
            R.mipmap.image03, R.mipmap.image04, R.mipmap.image05};

    public ImageAdapter(Context c) {
        this.mContext = c;
        mImageViewList = new ImageView[imgs.length];

        WindowManager wm = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();

        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(mContext);
            /**
             * 图片处理，如果不处理 加载卡顿
             */
            Integer id = (Integer) imgs[i];
            Bitmap originalImage = BitmapFactory.decodeResource(
                    mContext.getResources(), id);
            imageView.setImageBitmap(ImageUtils.imagePostScale(originalImage, Height));
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(width / 2, 300));
            mImageViewList[i] = imageView;
        }
    }

    @Override
    public int getCount() {
        /**
         * 个数设为默认最大值
         */
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        if (position >= imgs.length) {
            position = position % imgs.length;
        }

        return position;
    }

    @Override
    public long getItemId(int position) {
        if (position >= imgs.length) {
            position = position % imgs.length;
        }
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * 按照position % imgs.length返回ImageView
         */
        return mImageViewList[position % imgs.length];

    }
}
