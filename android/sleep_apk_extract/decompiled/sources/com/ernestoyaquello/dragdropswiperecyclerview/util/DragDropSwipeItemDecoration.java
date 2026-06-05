package com.ernestoyaquello.dragdropswiperecyclerview.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/drawable/Drawable;", "divider", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroid/view/View;", "child", "", "itemIsBeingMoved", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)Z", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView$State;", ServerProtocol.DIALOG_PARAM_STATE, "", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Rect;", "outRect", ViewHierarchyConstants.VIEW_KEY, "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/drawable/Drawable;", "getDivider", "()Landroid/graphics/drawable/Drawable;", "setDivider", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class DragDropSwipeItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable divider;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DragDropSwipeRecyclerView.ListOrientation.values().length];
            $EnumSwitchMapping$0 = iArr;
            DragDropSwipeRecyclerView.ListOrientation listOrientation = DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING;
            iArr[listOrientation.ordinal()] = 1;
            DragDropSwipeRecyclerView.ListOrientation listOrientation2 = DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING;
            iArr[listOrientation2.ordinal()] = 2;
            DragDropSwipeRecyclerView.ListOrientation listOrientation3 = DragDropSwipeRecyclerView.ListOrientation.HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING;
            iArr[listOrientation3.ordinal()] = 3;
            DragDropSwipeRecyclerView.ListOrientation listOrientation4 = DragDropSwipeRecyclerView.ListOrientation.HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING;
            iArr[listOrientation4.ordinal()] = 4;
            DragDropSwipeRecyclerView.ListOrientation listOrientation5 = DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_HORIZONTAL_SWIPING;
            iArr[listOrientation5.ordinal()] = 5;
            DragDropSwipeRecyclerView.ListOrientation listOrientation6 = DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_VERTICAL_SWIPING;
            iArr[listOrientation6.ordinal()] = 6;
            int[] iArr2 = new int[DragDropSwipeRecyclerView.ListOrientation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[listOrientation.ordinal()] = 1;
            iArr2[listOrientation2.ordinal()] = 2;
            iArr2[listOrientation3.ordinal()] = 3;
            iArr2[listOrientation4.ordinal()] = 4;
            iArr2[listOrientation5.ordinal()] = 5;
            iArr2[listOrientation6.ordinal()] = 6;
        }
    }

    public DragDropSwipeItemDecoration(Drawable drawable) {
        drawable.getClass();
        this.divider = drawable;
    }

    private final boolean itemIsBeingMoved(RecyclerView parent, View child) {
        RecyclerView.ViewHolder childViewHolder = parent.getChildViewHolder(child);
        if (childViewHolder == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter.ViewHolder");
        }
        DragDropSwipeAdapter.ViewHolder viewHolder = (DragDropSwipeAdapter.ViewHolder) childViewHolder;
        return viewHolder.getIsBeingDragged() || viewHolder.getIsBeingSwiped();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView;
        DragDropSwipeRecyclerView.ListOrientation orientation;
        outRect.getClass();
        view.getClass();
        parent.getClass();
        state.getClass();
        super.getItemOffsets(outRect, view, parent, state);
        if (!(parent instanceof DragDropSwipeRecyclerView)) {
            throw new TypeCastException("The recycler view must be an extension of DragDropSwipeRecyclerView.");
        }
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0 || (orientation = (dragDropSwipeRecyclerView = (DragDropSwipeRecyclerView) parent).getOrientation()) == null) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[orientation.ordinal()]) {
            case 1:
            case 2:
                outRect.top = this.divider.getIntrinsicHeight();
                return;
            case 3:
            case 4:
                outRect.left = this.divider.getIntrinsicWidth();
                return;
            case 5:
            case 6:
                if (childAdapterPosition >= dragDropSwipeRecyclerView.getNumOfColumnsPerRowInGridList()) {
                    outRect.top = this.divider.getIntrinsicHeight();
                }
                if (childAdapterPosition >= dragDropSwipeRecyclerView.getNumOfRowsPerColumnInGridList()) {
                    outRect.left = this.divider.getIntrinsicWidth();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        Canvas canvas;
        DragDropSwipeRecyclerView.ListOrientation orientation;
        c.getClass();
        parent.getClass();
        state.getClass();
        if (!(parent instanceof DragDropSwipeRecyclerView)) {
            throw new TypeCastException("The recycler view must be an extension of DragDropSwipeRecyclerView.");
        }
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = (DragDropSwipeRecyclerView) parent;
        int childCount = dragDropSwipeRecyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = parent.getChildAt(i);
            childAt.getClass();
            if (!itemIsBeingMoved(parent, childAt) && (orientation = dragDropSwipeRecyclerView.getOrientation()) != null) {
                switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
                    case 1:
                    case 2:
                        canvas = c;
                        DividerDrawingHelperKt.drawHorizontalDividers$default(childAt, canvas, this.divider, null, null, null, 56, null);
                        continue;
                        i++;
                        c = canvas;
                        break;
                    case 3:
                    case 4:
                        canvas = c;
                        DividerDrawingHelperKt.drawVerticalDividers$default(childAt, canvas, this.divider, null, null, null, 56, null);
                        continue;
                        i++;
                        c = canvas;
                        break;
                    case 5:
                    case 6:
                        canvas = c;
                        DividerDrawingHelperKt.drawHorizontalDividers$default(childAt, canvas, this.divider, null, null, null, 56, null);
                        DividerDrawingHelperKt.drawVerticalDividers$default(childAt, canvas, this.divider, null, null, null, 56, null);
                        continue;
                        i++;
                        c = canvas;
                        break;
                    default:
                        canvas = c;
                        break;
                }
            } else {
                canvas = c;
            }
            i++;
            c = canvas;
        }
    }

    public final void setDivider(Drawable drawable) {
        drawable.getClass();
        this.divider = drawable;
    }
}
