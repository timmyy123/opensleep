package com.ernestoyaquello.dragdropswiperecyclerview.util;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b#\b\u0000\u0018\u00002\u00020\u0001:\u0004YZ[\\B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJK\u0010\u001b\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b!\u0010\u001eJ\u0017\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0018H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b)\u0010*J'\u0010,\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b,\u0010-J'\u0010/\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b/\u0010-J\u001f\u00101\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0016H\u0016¢\u0006\u0004\b1\u00102JG\u00104\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b4\u00105JG\u00106\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b6\u00105J!\u00107\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b7\u00102J\u001f\u00108\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bG\u0010B\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u0016\u0010J\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010BR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010NR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010OR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010PR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010QR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010>¨\u0006]"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemDragListener;", "itemDragListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemSwipeListener;", "itemSwipeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener;", "itemStateChangeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener;", "itemLayoutPositionChangeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "recyclerView", "<init>", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemDragListener;Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemSwipeListener;Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener;Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;)V", "Landroid/graphics/Canvas;", "canvasUnder", "canvasOver", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "dX", "dY", "", "actionState", "", "isCurrentlyActive", "", "onChildDrawImpl", "(Landroid/graphics/Canvas;Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "onStartedDragging", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onStartedSwiping", "onFinishedDraggingOrSwiping", "onFinishedDragging", "onFinishedSwiping", "isLongPressDragEnabled", "()Z", "isItemViewSwipeEnabled", "getSwipeThreshold", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)F", "Landroidx/recyclerview/widget/RecyclerView;", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "target", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "current", "canDropOver", "direction", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "c", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "onChildDrawOver", "onSelectedChanged", "clearView", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "orientation", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "getOrientation$drag_drop_swipe_recyclerview_release", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "setOrientation$drag_drop_swipe_recyclerview_release", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;)V", "disabledDragFlagsValue", "I", "getDisabledDragFlagsValue$drag_drop_swipe_recyclerview_release", "()I", "setDisabledDragFlagsValue$drag_drop_swipe_recyclerview_release", "(I)V", "disabledSwipeFlagsValue", "getDisabledSwipeFlagsValue$drag_drop_swipe_recyclerview_release", "setDisabledSwipeFlagsValue$drag_drop_swipe_recyclerview_release", "isDragging", "Z", "isSwiping", "initialItemPositionForOngoingDraggingEvent", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemDragListener;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemSwipeListener;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "getRecyclerView$drag_drop_swipe_recyclerview_release", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "setRecyclerView$drag_drop_swipe_recyclerview_release", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;)V", "getMOrientation", "mOrientation", "OnItemDragListener", "OnItemLayoutPositionChangeListener", "OnItemStateChangeListener", "OnItemSwipeListener", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public final class DragDropSwipeTouchHelper extends ItemTouchHelper.Callback {
    private int disabledDragFlagsValue;
    private int disabledSwipeFlagsValue;
    private int initialItemPositionForOngoingDraggingEvent;
    private boolean isDragging;
    private boolean isSwiping;
    private final OnItemDragListener itemDragListener;
    private final OnItemLayoutPositionChangeListener itemLayoutPositionChangeListener;
    private final OnItemStateChangeListener itemStateChangeListener;
    private final OnItemSwipeListener itemSwipeListener;
    private DragDropSwipeRecyclerView.ListOrientation orientation;
    private DragDropSwipeRecyclerView recyclerView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemDragListener;", "", "onItemDragged", "", "previousPosition", "", "newPosition", "onItemDropped", "initialPosition", "finalPosition", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public interface OnItemDragListener {
        void onItemDragged(int previousPosition, int newPosition);

        void onItemDropped(int initialPosition, int finalPosition);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010JD\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener;", "", "onPositionChanged", "", "action", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener$Action;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "offsetX", "", "offsetY", "canvasUnder", "Landroid/graphics/Canvas;", "canvasOver", "isUserControlled", "", "Action", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public interface OnItemLayoutPositionChangeListener {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener$Action;", "", "(Ljava/lang/String;I)V", "DRAGGING", "SWIPING", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
        public enum Action {
            DRAGGING,
            SWIPING
        }

        void onPositionChanged(Action action, RecyclerView.ViewHolder viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener;", "", "onStateChanged", "", "newState", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener$StateChangeType;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "StateChangeType", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public interface OnItemStateChangeListener {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemStateChangeListener$StateChangeType;", "", "(Ljava/lang/String;I)V", "DRAG_STARTED", "DRAG_FINISHED", "SWIPE_STARTED", "SWIPE_FINISHED", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
        public enum StateChangeType {
            DRAG_STARTED,
            DRAG_FINISHED,
            SWIPE_STARTED,
            SWIPE_FINISHED
        }

        void onStateChanged(StateChangeType newState, RecyclerView.ViewHolder viewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper$OnItemSwipeListener;", "", "onItemSwiped", "", "position", "", "direction", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener$SwipeDirection;", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public interface OnItemSwipeListener {
        void onItemSwiped(int position, OnItemSwipeListener.SwipeDirection direction);
    }

    public DragDropSwipeTouchHelper(OnItemDragListener onItemDragListener, OnItemSwipeListener onItemSwipeListener, OnItemStateChangeListener onItemStateChangeListener, OnItemLayoutPositionChangeListener onItemLayoutPositionChangeListener, DragDropSwipeRecyclerView dragDropSwipeRecyclerView) {
        onItemDragListener.getClass();
        onItemSwipeListener.getClass();
        onItemStateChangeListener.getClass();
        onItemLayoutPositionChangeListener.getClass();
        this.itemDragListener = onItemDragListener;
        this.itemSwipeListener = onItemSwipeListener;
        this.itemStateChangeListener = onItemStateChangeListener;
        this.itemLayoutPositionChangeListener = onItemLayoutPositionChangeListener;
        this.recyclerView = dragDropSwipeRecyclerView;
        this.initialItemPositionForOngoingDraggingEvent = -1;
    }

    private final DragDropSwipeRecyclerView.ListOrientation getMOrientation() {
        DragDropSwipeRecyclerView.ListOrientation listOrientation = this.orientation;
        if (listOrientation != null) {
            return listOrientation;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("The orientation of the DragDropSwipeRecyclerView is not defined.");
        return null;
    }

    private final void onChildDrawImpl(Canvas canvasUnder, Canvas canvasOver, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        OnItemLayoutPositionChangeListener.Action action = actionState != 1 ? actionState != 2 ? null : OnItemLayoutPositionChangeListener.Action.DRAGGING : OnItemLayoutPositionChangeListener.Action.SWIPING;
        if (action != null) {
            this.itemLayoutPositionChangeListener.onPositionChanged(action, viewHolder, (int) dX, (int) dY, canvasUnder, canvasOver, isCurrentlyActive);
        }
    }

    private final void onFinishedDragging(RecyclerView.ViewHolder viewHolder) {
        int i = this.initialItemPositionForOngoingDraggingEvent;
        int adapterPosition = viewHolder.getAdapterPosition();
        this.isDragging = false;
        this.initialItemPositionForOngoingDraggingEvent = -1;
        this.itemDragListener.onItemDropped(i, adapterPosition);
        this.itemStateChangeListener.onStateChanged(OnItemStateChangeListener.StateChangeType.DRAG_FINISHED, viewHolder);
    }

    private final void onFinishedDraggingOrSwiping(RecyclerView.ViewHolder viewHolder) {
        if (this.isDragging) {
            onFinishedDragging(viewHolder);
        }
        if (this.isSwiping) {
            onFinishedSwiping(viewHolder);
        }
    }

    private final void onFinishedSwiping(RecyclerView.ViewHolder viewHolder) {
        this.isSwiping = false;
        this.itemStateChangeListener.onStateChanged(OnItemStateChangeListener.StateChangeType.SWIPE_FINISHED, viewHolder);
    }

    private final void onStartedDragging(RecyclerView.ViewHolder viewHolder) {
        this.isDragging = true;
        this.initialItemPositionForOngoingDraggingEvent = viewHolder.getAdapterPosition();
        this.itemStateChangeListener.onStateChanged(OnItemStateChangeListener.StateChangeType.DRAG_STARTED, viewHolder);
    }

    private final void onStartedSwiping(RecyclerView.ViewHolder viewHolder) {
        this.isSwiping = true;
        this.itemStateChangeListener.onStateChanged(OnItemStateChangeListener.StateChangeType.SWIPE_STARTED, viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
        Function0<Boolean> canBeDroppedOver$drag_drop_swipe_recyclerview_release;
        recyclerView.getClass();
        current.getClass();
        target.getClass();
        if (!(target instanceof DragDropSwipeAdapter.ViewHolder)) {
            target = null;
        }
        DragDropSwipeAdapter.ViewHolder viewHolder = (DragDropSwipeAdapter.ViewHolder) target;
        return (viewHolder == null || (canBeDroppedOver$drag_drop_swipe_recyclerview_release = viewHolder.getCanBeDroppedOver$drag_drop_swipe_recyclerview_release()) == null || !canBeDroppedOver$drag_drop_swipe_recyclerview_release.invoke().booleanValue()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        recyclerView.getClass();
        viewHolder.getClass();
        super.clearView(recyclerView, viewHolder);
        onFinishedDraggingOrSwiping(viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        recyclerView.getClass();
        viewHolder.getClass();
        int swipeFlagsValue$drag_drop_swipe_recyclerview_release = 0;
        if (!(viewHolder instanceof DragDropSwipeAdapter.ViewHolder)) {
            return 0;
        }
        DragDropSwipeAdapter.ViewHolder viewHolder2 = (DragDropSwipeAdapter.ViewHolder) viewHolder;
        Function0<Boolean> canBeDragged$drag_drop_swipe_recyclerview_release = viewHolder2.getCanBeDragged$drag_drop_swipe_recyclerview_release();
        int dragFlagsValue$drag_drop_swipe_recyclerview_release = (canBeDragged$drag_drop_swipe_recyclerview_release == null || !canBeDragged$drag_drop_swipe_recyclerview_release.invoke().booleanValue()) ? 0 : getMOrientation().getDragFlagsValue() ^ this.disabledDragFlagsValue;
        Function0<Boolean> canBeSwiped$drag_drop_swipe_recyclerview_release = viewHolder2.getCanBeSwiped$drag_drop_swipe_recyclerview_release();
        if (canBeSwiped$drag_drop_swipe_recyclerview_release != null && canBeSwiped$drag_drop_swipe_recyclerview_release.invoke().booleanValue()) {
            swipeFlagsValue$drag_drop_swipe_recyclerview_release = getMOrientation().getSwipeFlagsValue() ^ this.disabledSwipeFlagsValue;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlagsValue$drag_drop_swipe_recyclerview_release, swipeFlagsValue$drag_drop_swipe_recyclerview_release);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        float f;
        int iIntValue;
        viewHolder.getClass();
        float swipeThreshold = super.getSwipeThreshold(viewHolder);
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        Integer numValueOf = dragDropSwipeRecyclerView != null ? Integer.valueOf(dragDropSwipeRecyclerView.getMeasuredWidth()) : null;
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView2 = this.recyclerView;
        Integer numValueOf2 = dragDropSwipeRecyclerView2 != null ? Integer.valueOf(dragDropSwipeRecyclerView2.getMeasuredHeight()) : null;
        View view = viewHolder.itemView;
        view.getClass();
        int measuredWidth = view.getMeasuredWidth();
        View view2 = viewHolder.itemView;
        view2.getClass();
        int measuredHeight = view2.getMeasuredHeight();
        if (numValueOf == null || numValueOf2 == null) {
            return swipeThreshold;
        }
        int swipeFlagsValue$drag_drop_swipe_recyclerview_release = getMOrientation().getSwipeFlagsValue();
        DragDropSwipeRecyclerView.ListOrientation.DirectionFlag directionFlag = DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.RIGHT;
        if ((swipeFlagsValue$drag_drop_swipe_recyclerview_release & directionFlag.getValue()) != directionFlag.getValue()) {
            int swipeFlagsValue$drag_drop_swipe_recyclerview_release2 = getMOrientation().getSwipeFlagsValue();
            DragDropSwipeRecyclerView.ListOrientation.DirectionFlag directionFlag2 = DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.LEFT;
            if ((swipeFlagsValue$drag_drop_swipe_recyclerview_release2 & directionFlag2.getValue()) == directionFlag2.getValue()) {
                f = measuredWidth;
                iIntValue = numValueOf.intValue();
            } else {
                f = measuredHeight;
                iIntValue = numValueOf2.intValue();
            }
        }
        return swipeThreshold * (f / iIntValue);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        c.getClass();
        recyclerView.getClass();
        viewHolder.getClass();
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        onChildDrawImpl(c, null, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        c.getClass();
        recyclerView.getClass();
        viewHolder.getClass();
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        onChildDrawImpl(null, c, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        recyclerView.getClass();
        viewHolder.getClass();
        target.getClass();
        this.itemDragListener.onItemDragged(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (viewHolder != null) {
            if (actionState == 1) {
                onStartedSwiping(viewHolder);
            } else {
                if (actionState != 2) {
                    return;
                }
                onStartedDragging(viewHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        viewHolder.getClass();
        this.itemSwipeListener.onItemSwiped(viewHolder.getAdapterPosition(), direction != 1 ? direction != 4 ? direction != 8 ? OnItemSwipeListener.SwipeDirection.UP_TO_DOWN : OnItemSwipeListener.SwipeDirection.LEFT_TO_RIGHT : OnItemSwipeListener.SwipeDirection.RIGHT_TO_LEFT : OnItemSwipeListener.SwipeDirection.DOWN_TO_UP);
    }

    public final void setDisabledDragFlagsValue$drag_drop_swipe_recyclerview_release(int i) {
        this.disabledDragFlagsValue = i;
    }

    public final void setDisabledSwipeFlagsValue$drag_drop_swipe_recyclerview_release(int i) {
        this.disabledSwipeFlagsValue = i;
    }

    public final void setOrientation$drag_drop_swipe_recyclerview_release(DragDropSwipeRecyclerView.ListOrientation listOrientation) {
        this.orientation = listOrientation;
    }

    public final void setRecyclerView$drag_drop_swipe_recyclerview_release(DragDropSwipeRecyclerView dragDropSwipeRecyclerView) {
        this.recyclerView = dragDropSwipeRecyclerView;
    }
}
