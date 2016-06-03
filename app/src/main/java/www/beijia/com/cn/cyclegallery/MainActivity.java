package www.beijia.com.cn.cyclegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 画廊，循环滑动
 */
public class MainActivity extends AppCompatActivity {

    private Gallery gallery;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        gallery = (Gallery) findViewById(R.id.mygallery);
        adapter = new ImageAdapter(this);

        gallery.setAdapter(adapter);
        //起点设置，默认开始时，可以左滑动
        gallery.setSelection(adapter.getCount() / 2);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 设置点击事件监听
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "img " + (position + 1) + " selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
