package com.example.imooc_music.views;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.imooc_music.R;

/**
 * 自定义view方式2
 * 1. 声明自定义view类
 * 2. 创建布局属性values/attrs.xml
 * 3. 创建布局layout
 */
public class InputView extends FrameLayout {
    //自定义属性文件中获取值
    private int inputIconId;

    private String inputHintVal;

    private boolean isPwd;

    // 获取布局文件中的视图引用
    private ImageView inputIcon;

    private EditText input;
    private View inputView;

    public InputView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public InputView(@NonNull Context context, @NonNull AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public InputView(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(@NonNull Context context, @NonNull AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 初始化方法
     */
    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        // 获取自定义属性
        TypedArray _attrs = context.obtainStyledAttributes(attrs, R.styleable.inputView);
        // 获取图片资源
        inputIconId = _attrs.getResourceId(R.styleable.inputView_input_icon, R.mipmap.phone);
        // 获取字符串资源
        inputHintVal = _attrs.getString(R.styleable.inputView_input_hint);
        isPwd = _attrs.getBoolean(R.styleable.inputView_is_pwd, false);

        // 通过布局视图获取组件引用
        inputView = LayoutInflater.from(context).inflate(R.layout.input_view, this, false);
        inputIcon = inputView.findViewById(R.id.input_icon);
        input = inputView.findViewById(R.id.input);
        // 设置属性
        inputIcon.setImageResource(inputIconId);
        input.setHint(inputHintVal);
        input.setInputType(isPwd ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);

        addView(inputView);
        _attrs.recycle();

    }

    /**
     * 获取输入框的输入内容
     * @return
     */
    public String getInputHintVal() {
        return input.getText().toString().trim();
    }
}
