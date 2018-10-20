package terry.com.buildingsclassification_ncst.MapContents;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MapView extends View {
    String TAG = "MapView";
    private ImageView return_btn;
    //画笔
    private Paint mPaint;
    //文本颜色
    private int mPaintColor;

    private int halfViewWidth;
    private int halfViewHeight;

    private int districtID= -1;

    private int nowCentralX;
    private int nowCentralY;
    private float touchX;
    private float touchY;
    private float touchAccuracy = 0.5f;

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //this.districtID = districtID;
        nowCentralX = 2332;
        nowCentralY = 4514;
        setDistrictID(3);
        init();
    }

    private void init(){
        //默认为黑色
        mPaintColor = Color.YELLOW;
        //初始化绘笔
        mPaint = new Paint();
        mPaint.setColor(mPaintColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(25f);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //mPaint.setColor(mPaintColor);
    }

    public void setDistrictID(int x){
        districtID=x;
        Point p = MapBitmapsConstant.getCentralPoint(districtID);
        nowCentralX = p.x;
        nowCentralY = p.y;
        ajustCentralXY();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //这个方法里往往需要重绘界面，使用这个方法可以自动调用onDraw（）方法。（主线程）
        //invalidate();
        //非UI线程用
        //postInvalidate();
        //获取手指在屏幕上的坐标
        //当手指离开的时候
        float x = event.getX();
        float y = event.getY();

        //获取手指的操作--》按下、移动、松开
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN://按下
                //Log.i(TAG, "ACTION_DOWN");
                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE://移动
                //Log.i(TAG, "ACTION_MOVE");
                nowCentralX += (int)((touchX-x)*touchAccuracy);
                nowCentralY += (int)((touchY-y)*touchAccuracy);
                //Log.e("motion","dx="+(int)((x-touchX)*touchAccuracy)+" dy="+(int)((y-touchY)*touchAccuracy));
                touchX = x;
                touchY = y;
                break;
            case MotionEvent.ACTION_UP://松开
                //Log.i(TAG, "ACTION_UP");
                //当手指离开的时候
                //Log.e("motion","dx="+(int)((x-touchX)*touchAccuracy)+" dy="+(int)((y-touchY)*touchAccuracy));
                nowCentralX += (int)((touchX-x)*touchAccuracy);
                nowCentralY += (int)((touchY-y)*touchAccuracy);
                break;
        }
        ajustCentralXY();
        //使系统响应事件，返回true
        //这个方法里往往需要重绘界面，使用这个方法可以自动调用onDraw（）方法。（主线程）
        invalidate();
        return true;
    }

    private void ajustCentralXY(){
        if(nowCentralX-halfViewWidth<0)nowCentralX=halfViewWidth;
        if(nowCentralY-halfViewHeight<0)nowCentralY=halfViewHeight;
        if(nowCentralX+halfViewWidth>MapBitmapsConstant.wholeMapWidth)nowCentralX = MapBitmapsConstant.wholeMapWidth-halfViewWidth;
        if(nowCentralY+halfViewHeight>MapBitmapsConstant.wholeMapHeight)nowCentralY = MapBitmapsConstant.wholeMapHeight-halfViewHeight;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);

        halfViewWidth = getWidth()/2;
        halfViewHeight = getHeight()/2;
        Log.e("MapView","viewWidth:"+halfViewWidth+" viewHeight:"+halfViewHeight);
        ajustCentralXY();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int leastX = (int)(Math.floor((nowCentralX-halfViewWidth)*1.0/ MapBitmapsConstant.mapWidth));
        int largestX = (int)(Math.ceil((nowCentralX+halfViewWidth)*1.0/ MapBitmapsConstant.mapWidth));
        int leastY = (int)(Math.floor((nowCentralY-halfViewHeight)*1.0/ MapBitmapsConstant.mapHeight));
        int largestY = (int)(Math.ceil((nowCentralY+halfViewHeight)*1.0/ MapBitmapsConstant.mapHeight));

        if(leastX<0)leastX=0;
        if(largestX>5)largestX=5;
        if(leastY<0)leastY=0;
        if(largestY>5)largestY=5;

        for(int i=leastX;i<=largestX;i++){
            for(int j=leastY;j<=largestY;j++){
                canvas.drawBitmap(MapBitmapsConstant.bitmaps.get(j*6+i),
                        i* MapBitmapsConstant.mapWidth-(nowCentralX-halfViewWidth),
                        j* MapBitmapsConstant.mapHeight-(nowCentralY-halfViewHeight),
                        mPaint);
            }
        }
        drawDistrictPolygons(canvas,districtID);
    }
    private void drawDistrictPolygons(Canvas canvas,int districtID){
        if(districtID==-1)return;
        Path path = MapBitmapsConstant.getPath(districtID,-(nowCentralX-halfViewWidth),-(nowCentralY-halfViewHeight));
//        Path path = new Path();
//        path.moveTo(0,0);
//        path.lineTo(100,0);
//        path.lineTo(100,100);
//        path.lineTo(0,100);
//        path.lineTo(0,0);
        if(path!=null)//path==null means polygon out of sight
            canvas.drawPath(path,mPaint);
    }
}
