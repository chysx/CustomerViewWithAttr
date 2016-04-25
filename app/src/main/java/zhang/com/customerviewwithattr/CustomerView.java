package zhang.com.customerviewwithattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

/**
 * Created by beiyong14 on 2016/4/21.
 */
public class CustomerView extends TextView{

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init1(context, attrs);
    }

    /**
     * 通过封装类TypedArray来获取属性值
     * @param context
     * @param attrs
     */
    private void init1(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.customer_view);

        String testStr = ta.getString(R.styleable.customer_view_testStr);
        int testInteger = ta.getInteger(R.styleable.customer_view_testInteger,-1);
        float testDimension = ta.getDimension(R.styleable.customer_view_testDimension,-1f);
        int testColor = ta.getColor(R.styleable.customer_view_testColor,-1);
        int testReference = ta.getResourceId(R.styleable.customer_view_testReference,R.drawable.ic_border_color);


        Logger.d("testStr = " + testStr + " testInteger = " + testInteger+ " testDimension = " + testDimension
                + " testColor = " + testColor+ " testReference = " + testReference);

        ta.recycle();

        setText(testStr);
        setTextSize(testDimension);
        setTextColor(testColor);
        setBackgroundResource(testReference);
    }

    /**
     * 通过原始的AttributeSet来获取属性值
     * @param attrs
     */
    private void init2(AttributeSet attrs){

        int count = attrs.getAttributeCount();
        for(int i = 0;i < count;i++){
            String name = attrs.getAttributeName(i);
            String value = attrs.getAttributeValue(i);
            Logger.d("name = " + name + " value = " + value);
        }
    }
}

/**
 *
 * 自定义属性，需要以下步骤：
 *
 * 1.自定义一个CustomerView类
 * 2.编写values/attrs.xml,在其中编写styleable和item属性
 * 3.在布局文件中使用自定义属性（注意namespace）
 * 4.在CustomerView构造方法中通过TypedArray来获取属性值
 *
 *
 * 以上步骤是如何奏效的？
 * 1.styleable 的含义是什么？可以不写嘛？我自定义属性，我声明属性就好了，为什么一定要写个styleable呢？
 * 答：可以不写。写是方便在CustomerView代码中方便的取得属性的KEY值
 * 2.如果系统中已经有了语义比较明确的属性，我可以直接使用嘛？
 * 答：可以
 * 3.构造方法中的有个参数叫做AttributeSet（eg: MyTextView(Context context, AttributeSet attrs) ）
 * 这个参数看名字就知道包含的是参数的数组，那么我能不能通过它去获取我的自定义属性呢？
 * 答：可以
 * 4.TypedArray是什么鬼？从哪冒出来的，就要我去使用？
 * 答：TypedArray是一个对属性列表的一个封装类，便于开发者更简单的通过属性的key值获取属性值
 *
 */
