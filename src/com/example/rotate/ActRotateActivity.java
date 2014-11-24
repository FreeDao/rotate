package com.example.rotate;

  
import com.example.rotate.RotateAnimation.InterpolatedTimeListener;

import android.app.Activity;  
import android.graphics.drawable.Drawable;
import android.os.Bundle;  
import android.util.Log;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.ImageView;
import android.widget.TextView;  
  
/** 
 * @author Sodino E-mail:sodinoopen@hotmail.com 
 * @version Time：2012-6-27 上午07:32:00 
 */  
public class ActRotateActivity extends Activity implements OnClickListener, InterpolatedTimeListener {  
    private Button btnIncrease, btnDecrease;  
    private ImageView image;  
    /** TextNumber是否允许显示最新的数字。 */  
    private boolean enableRefresh;  
  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
  
        btnIncrease = (Button) findViewById(R.id.button1);  
        btnDecrease = (Button) findViewById(R.id.button2);  
        image = (ImageView) findViewById(R.id.text);  
  
        btnIncrease.setOnClickListener(this);  
        btnDecrease.setOnClickListener(this);  
 
    }  
  
    public void onClick(View v) {  
        enableRefresh = true;  
        RotateAnimation rotateAnim = null;  
        float cX = image.getWidth() / 2.0f;  
        float cY = image.getHeight() / 2.0f;  
        if (v == btnDecrease) {  
            rotateAnim = new RotateAnimation(cX, cY, RotateAnimation.ROTATE_DECREASE);  
        } else if (v == btnIncrease) {  
            rotateAnim = new RotateAnimation(cX, cY, RotateAnimation.ROTATE_INCREASE);  
        }  
        if (rotateAnim != null) {  
            rotateAnim.setInterpolatedTimeListener(this);  
            rotateAnim.setFillAfter(true);  
            image.startAnimation(rotateAnim);  
        }  
    }  
  
    @Override  
    public void interpolatedTime(float interpolatedTime) {  
        // 监听到翻转进度过半时，更新txtNumber显示内容。  
        if (enableRefresh && interpolatedTime > 0.5f) { 
        	image.setBackgroundResource(R.drawable.icon_internet_priority_normal); 
            enableRefresh = false;  
        }  
    }  
}  