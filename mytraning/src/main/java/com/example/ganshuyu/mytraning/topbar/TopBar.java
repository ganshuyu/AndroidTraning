package com.example.ganshuyu.mytraning.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ganshuyu.mytraning.R;

/**
 * Created by ganshuyu on 2014/12/16.
 */
public class TopBar extends RelativeLayout{
    private int topBarColor;

    private String titleText;
    private int titleTextColor;
    private float titleTextSize;

    private String leftButtonText;
    private int leftButtonTextColor;
    private Drawable leftButtonBackground;

    private String rightButtonText;
    private int rightButtonTextColor;
    private Drawable rightButtonBackground;

    private TextView title;
    private Button leftButton;
    private Button rightButton;

    private LayoutParams titleParams;
    private LayoutParams leftParams;
    private LayoutParams rightParams;

    private TopBarOnClickListener mTopBarOnClickListener;

    public interface TopBarOnClickListener {
        void leftButtonOnClick(View v);
        void rightButtonOnClick(View v);
    }

    public void setTopBarOnClickListener (TopBarOnClickListener listener) {
        mTopBarOnClickListener = listener;
    }
    
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        //1.Get the attrs values from the xml file.
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        titleText = typedArray.getString(R.styleable.TopBar_titleText);
        titleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        titleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);

        leftButtonText = typedArray.getString(R.styleable.TopBar_leftButtonText);
        leftButtonTextColor = typedArray.getColor(R.styleable.TopBar_leftButtonTextColor, 0);
        leftButtonBackground = typedArray.getDrawable(R.styleable.TopBar_leftButtonBackground);

        rightButtonText = typedArray.getString(R.styleable.TopBar_rightButtonText);
        rightButtonTextColor = typedArray.getColor(R.styleable.TopBar_rightButtonTextColor, 0);
        rightButtonBackground = typedArray.getDrawable(R.styleable.TopBar_rightButtonBackground);

        topBarColor = typedArray.getColor(R.styleable.TopBar_topBarColor, 0);
        typedArray.recycle();//Don't forget to recycle.

        //2.Instantiate all widgets we need.
        title = new TextView(context);
        leftButton = new Button(context);
        rightButton = new Button(context);
        
        title.setText(titleText);
        title.setTextColor(titleTextColor);
        title.setTextSize(titleTextSize);
        title.setGravity(Gravity.CENTER);
        
        leftButton.setText(leftButtonText);
        leftButton.setTextColor(leftButtonTextColor);
        leftButton.setBackground(leftButtonBackground);

        rightButton.setText(rightButtonText);
        rightButton.setTextColor(rightButtonTextColor);
        rightButton.setBackground(rightButtonBackground);

        //3.Put the widgets in our view group.--Layout
        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(title, titleParams);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(leftButton, leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(rightButton, rightParams);

        //4.Set the button click listener.
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopBarOnClickListener.leftButtonOnClick(v);
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTopBarOnClickListener.rightButtonOnClick(v);
            }
        });

        //5.Set our background.
        setBackgroundColor(topBarColor);
    }
}
