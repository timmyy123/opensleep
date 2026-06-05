package com.urbandroid.sleep.fragment.dashboard;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/RecyclerViewTouchListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "clickListener", "Lcom/urbandroid/sleep/fragment/dashboard/RecyclerViewClickListener;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/fragment/dashboard/RecyclerViewClickListener;)V", "gestureDetector", "Landroid/view/GestureDetector;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
    private final RecyclerViewClickListener clickListener;
    private final GestureDetector gestureDetector;

    public RecyclerViewTouchListener(Context context, RecyclerViewClickListener recyclerViewClickListener) {
        context.getClass();
        this.clickListener = recyclerViewClickListener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.urbandroid.sleep.fragment.dashboard.RecyclerViewTouchListener$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                e.getClass();
                return true;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        int childAdapterPosition;
        rv.getClass();
        e.getClass();
        View viewFindChildViewUnder = rv.findChildViewUnder(e.getX(), e.getY());
        if (viewFindChildViewUnder == null || this.clickListener == null || !this.gestureDetector.onTouchEvent(e) || (childAdapterPosition = rv.getChildAdapterPosition(viewFindChildViewUnder)) < 0) {
            return false;
        }
        this.clickListener.onClick(viewFindChildViewUnder, childAdapterPosition);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        rv.getClass();
        e.getClass();
    }
}
