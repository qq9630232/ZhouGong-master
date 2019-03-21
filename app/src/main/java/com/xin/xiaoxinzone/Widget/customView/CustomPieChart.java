package com.xin.xiaoxinzone.Widget.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.xin.xiaoxinzone.R;
import com.xin.xiaoxinzone.model.PieDataModel;

import java.util.List;

import static android.graphics.Paint.Style.STROKE;

/**
 * @author llq
 * @time 2018/6/14  16:30.
 * @faction 圆形百分比图
 * @description
 * @modify
 */
public class CustomPieChart extends View {
    private Paint paint;

    private int totalWidth, totalHeight;

    private List<PieDataModel> pieDataModelList;

    public CustomPieChart(Context context) {
        super(context);
        initPaint();
    }

    public CustomPieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomPieChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(STROKE);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        totalWidth = w - getPaddingLeft() - getPaddingRight();
        totalHeight = h - getPaddingTop() - getPaddingBottom();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPieChart(canvas);
    }

    private void drawPieChart(Canvas canvas) {
        canvas.translate(totalWidth / 2, totalHeight / 2);
        if (pieDataModelList != null && pieDataModelList.size() > 0) {
            for (int j = 0; j < pieDataModelList.size(); j++) {
                float startAngle = 0;
                float sweepAngle;
                RectF rectF = new RectF(-(j + 1) * 20 - 60, -(j + 1) * 20 - 60, (j + 1) * 20 + 60, (j + 1) * 20 + 60);

                sweepAngle = pieDataModelList.get(j).getData() * 360 / 100;
                paint.setColor(pieDataModelList.get(j).getColor());
                canvas.drawArc(rectF, startAngle, sweepAngle, false, paint);

                paint.setColor(getResources().getColor(R.color.color_a6c9f4));
                canvas.drawArc(rectF, sweepAngle, 360 - sweepAngle, false, paint);
            }
        }
    }

    /**
     * 对外接口
     *
     * @param list 圆形百分比图实体列表
     */
    public void setPieDataModelList(List<PieDataModel> list) {
        this.pieDataModelList = list;
        invalidate();
    }

}
