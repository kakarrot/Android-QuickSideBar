package com.bigkoo.quicksidebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;


/**
 * Created by Sai on 16/3/26.
 */
public class QuickSideBarTipsView extends RelativeLayout {
    private TextView mTipsView;

    public QuickSideBarTipsView(Context context) {
        this(context, null);
    }

    public QuickSideBarTipsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public QuickSideBarTipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        int textColor = Color.parseColor("#EFE8FE");
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.QuickSideBarTipsView);
            textColor = a.getColor(R.styleable.QuickSideBarTipsView_sidebarTipsTextColor, Color.parseColor("#EFE8FE"));
            a.recycle();
        }
        mTipsView = new TextView(context);
        mTipsView.setBackgroundResource(R.drawable.ic_bg_letter_tips);
        mTipsView.setTextSize(18);
        mTipsView.setGravity(Gravity.CENTER_VERTICAL);
        mTipsView.setTextColor(textColor);
        mTipsView.setGravity(Gravity.CENTER);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(mTipsView, layoutParams);
        mTipsView.setVisibility(View.INVISIBLE);
    }

    public void setText(String text, int position, float y) {
        LayoutParams layoutParams = (LayoutParams) mTipsView.getLayoutParams();
        layoutParams.topMargin = (int) y - mTipsView.getHeight() / 2 - dp2px(6);
        mTipsView.setLayoutParams(layoutParams);
        mTipsView.post(() -> {
            mTipsView.setText(text);
            mTipsView.setVisibility(View.VISIBLE);
        });
    }

    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
