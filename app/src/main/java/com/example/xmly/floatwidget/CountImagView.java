//package com.example.xmly.floatwidget;
//
//import android.animation.Animator;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.support.v7.widget.AppCompatImageView;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.animation.DecelerateInterpolator;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.example.xmly.floatwidget.permission.DisplayUtil;
//
///**
// * Created by Jackie on 2018/9/3.
// */
//public class CountImagView extends AppCompatImageView{
//    private Context context;
//    private int screenWidth;
//    private int screenHeight;
//    private int screenWidthHalf;
//    private int statusHeight;
//    private int virtualHeight;
//    private int lastX;
//    private int lastY;
//    private boolean isDrag;
//    private static final String TAG = "DragFloatActionButton";
//    private float mWidth;
//    private float mHeight;
//    private float mRadius;
//    private Paint mPaint;
//    private int mCount;
//    private DragBroadCastReceiver mReceiver;
//    public CountImagView(Context context) {
//        super(context);
//        init(context);
//    }
//
//    public CountImagView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(context);
//    }
//
//    public CountImagView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init(context);
//    }
//    private void init(Context context){
//        this.context = context;
//        screenWidth = DisplayUtil.getScreenWidth(context);
//        screenWidthHalf = screenWidth / 2;
//        screenHeight = DisplayUtil.getScreenHeight(context);
//        statusHeight = DisplayUtil.getStatusHeight(context);
//        virtualHeight=DisplayUtil.getVirtualBarHeigh(context);
//        mRadius = getResources().getDimension(R.dimen.x12);
//        mPaint = new Paint();
//        mPaint.setColor(Color.RED);
//        mPaint.setAntiAlias(true);
//        mTextPaint = new Paint();
//        mTextPaint.setAntiAlias(true);
//        mTextPaint.setColor(Color.WHITE);
//        mTextPaint.setStyle(Paint.Style.FILL);
//        mTextPaint.setTextSize(getResources().getDimension(R.dimen.x15));
//        mTextPaint.setStrokeWidth(5);
//        mRoundPaint = new Paint();
//        mRoundPaint.setAntiAlias(true);
//        mRoundPaint.setColor(Color.parseColor("#2f5dd9"));
//        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
//        intentFilter.addAction("floatbutton");
//        mReceiver = new DragBroadCastReceiver();
//        context.registerReceiver(mReceiver,intentFilter);
//        Log.i("jackie_test","注册广播");
//        mBitmapPaint = new Paint();
//        mBitmapPaint.setAntiAlias(true);
//        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.package_bai);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//        mWidth = getMeasuredWidth();
//        mHeight = getMeasuredHeight();
//        mRedX = mWidth/2 + getResources().getDimension(R.dimen.x35);
//        mRedY = getResources().getDimension(R.dimen.x15);
//
//        mTextX = mWidth/2 + getResources().getDimension(R.dimen.x31);
//        mTextY = getResources().getDimension(R.dimen.x19);
//
//    }
//
//    int rawX;
//    int rawY;
//
//
//    private float mRedX;
//    private float mRedY;
//    private float mTextX;
//    private float mTextY;
//    private Paint mTextPaint;
//    private Paint mRoundPaint;
//    private Bitmap bitmap;
//    private Paint mBitmapPaint;
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
////        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,mRoundPaint);
////        canvas.drawBitmap(bitmap,mWidth/3.5f,mHeight/4,mBitmapPaint);
//        canvas.drawCircle(mRedX ,mRedY,mRadius,mPaint);
//        if (CommonApplication.getmCount() > 9){
//            mTextX = mWidth/2 + getResources().getDimension(R.dimen.x27);
//        }
//        canvas.drawText(String.valueOf(CommonApplication.getmCount()),mTextX,mTextY,mTextPaint);
//    }
//
//    public class DragBroadCastReceiver extends BroadcastReceiver{
//        static public final String SYSTEM_DIALOG_REASON_KEY = "reason";
//        static public final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
//        static public final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
//        static public final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
//        static public final String SYSTEM_DIALOG_REASON_ASSIST = "assist";
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.i("jackie_test","接受广播------"+intent.getAction());
//            if(intent.getAction().equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)){
//                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
//                if (reason != null){
//                    if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)){
//                        FloatWindowManager.getInstance().dismissWindow();
////                        Toast.makeText(context,"短按Home键",Toast.LENGTH_SHORT).show();
//                    }else if (reason.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)){
//                        FloatWindowManager.getInstance().dismissWindow();
////                        Toast.makeText(context, "RECENT_APPS", Toast.LENGTH_SHORT).show();
//                    }else if (reason.equals(SYSTEM_DIALOG_REASON_ASSIST)){
//                        FloatWindowManager.getInstance().dismissWindow();
////                        Toast.makeText(context, "长按home键", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                return;
//
//            }
//
//            //隐藏
//            if (intent.getBooleanExtra("hide",false)){
//                FloatWindowManager.getInstance().dismissWindow();
////                Log.i(TAG, "onReceive: ------dismiss-------");
//                return;
//            }else{
////                Log.i(TAG, "onReceive: -------show--------");
//                FloatWindowManager.getInstance().applyOrShowFloatWindow(context);
//            }
//            postInvalidateDelayed(480);
////            invalidate();
//        }
//    }
//
//    @Override
//    protected void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
////        context.unregisterReceiver(mReceiver);
//    }
//}
