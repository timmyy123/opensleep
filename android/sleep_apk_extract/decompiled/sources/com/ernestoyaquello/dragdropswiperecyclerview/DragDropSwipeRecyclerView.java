package com.ernestoyaquello.dragdropswiperecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener;
import com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeItemDecoration;
import com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u008e\u00012\u00020\u0001:\u0004\u008e\u0001\u008f\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR.\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8@@BX\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010 8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010+\u001a\u0004\u0018\u00010 8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R$\u0010/\u001a\u0004\u0018\u00010.8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010.8@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R.\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR.\u0010D\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR.\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010?\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010?\u001a\u0004\bY\u0010A\"\u0004\bZ\u0010CR$\u0010[\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010?\u001a\u0004\b\\\u0010A\"\u0004\b]\u0010CR.\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010?\u001a\u0004\b_\u0010A\"\u0004\b`\u0010CR.\u0010a\u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010?\u001a\u0004\bb\u0010A\"\u0004\bc\u0010CR\"\u0010d\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010S\u001a\u0004\be\u0010U\"\u0004\bf\u0010WR\"\u0010g\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010S\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR\"\u0010j\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u00109\u001a\u0004\bk\u0010;\"\u0004\bl\u0010=R\"\u0010m\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u00109\u001a\u0004\bn\u0010;\"\u0004\bo\u0010=R6\u0010q\u001a\b\u0012\u0002\b\u0003\u0018\u00010p2\f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010p8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR>\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010w2\u0010\u0010!\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010w8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010x\u001a\u0004\by\u0010z\"\u0004\b\r\u0010{R1\u0010}\u001a\u0004\u0018\u00010|2\b\u0010!\u001a\u0004\u0018\u00010|8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R'\u0010\u0083\u0001\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\b\u0083\u0001\u00109\"\u0005\b\u0084\u0001\u0010=R'\u0010\u0085\u0001\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\b\u0085\u0001\u00109\"\u0005\b\u0086\u0001\u0010=R?\u0010\u0088\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0087\u00012\r\u0010!\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0087\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0090\u0001"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/ScrollAwareRecyclerView;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation$DirectionFlag;", "swipeDirectionToDisable", "disableSwipeDirection", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation$DirectionFlag;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", ServerProtocol.DIALOG_PARAM_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeItemDecoration;", "itemDecoration", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeItemDecoration;", "Landroid/graphics/drawable/Drawable;", SDKConstants.PARAM_VALUE, "dividerDrawable", "Landroid/graphics/drawable/Drawable;", "getDividerDrawable$drag_drop_swipe_recyclerview_release", "()Landroid/graphics/drawable/Drawable;", "setDividerDrawable", "(Landroid/graphics/drawable/Drawable;)V", "behindSwipedItemIconDrawable", "getBehindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release", "setBehindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release", "behindSwipedItemIconSecondaryDrawable", "getBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release", "setBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release", "Landroid/view/View;", "behindSwipedItemSecondaryLayout", "Landroid/view/View;", "getBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release", "()Landroid/view/View;", "setBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release", "(Landroid/view/View;)V", "behindSwipedItemLayout", "getBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release", "setBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release", "itemLayoutId", "I", "getItemLayoutId", "()I", "setItemLayoutId", "(I)V", "dividerDrawableId", "Ljava/lang/Integer;", "getDividerDrawableId", "()Ljava/lang/Integer;", "setDividerDrawableId", "(Ljava/lang/Integer;)V", "behindSwipedItemIconDrawableId", "getBehindSwipedItemIconDrawableId", "setBehindSwipedItemIconDrawableId", "behindSwipedItemIconSecondaryDrawableId", "getBehindSwipedItemIconSecondaryDrawableId", "setBehindSwipedItemIconSecondaryDrawableId", "", "behindSwipedItemIconMargin", "F", "getBehindSwipedItemIconMargin", "()F", "setBehindSwipedItemIconMargin", "(F)V", "", "behindSwipedItemCenterIcon", "Z", "getBehindSwipedItemCenterIcon", "()Z", "setBehindSwipedItemCenterIcon", "(Z)V", "behindSwipedItemBackgroundColor", "getBehindSwipedItemBackgroundColor", "setBehindSwipedItemBackgroundColor", "behindSwipedItemBackgroundSecondaryColor", "getBehindSwipedItemBackgroundSecondaryColor", "setBehindSwipedItemBackgroundSecondaryColor", "behindSwipedItemLayoutId", "getBehindSwipedItemLayoutId", "setBehindSwipedItemLayoutId", "behindSwipedItemSecondaryLayoutId", "getBehindSwipedItemSecondaryLayoutId", "setBehindSwipedItemSecondaryLayoutId", "reduceItemAlphaOnSwiping", "getReduceItemAlphaOnSwiping", "setReduceItemAlphaOnSwiping", "longPressToStartDragging", "getLongPressToStartDragging", "setLongPressToStartDragging", "numOfColumnsPerRowInGridList", "getNumOfColumnsPerRowInGridList", "setNumOfColumnsPerRowInGridList", "numOfRowsPerColumnInGridList", "getNumOfRowsPerColumnInGridList", "setNumOfRowsPerColumnInGridList", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "dragListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "getDragListener", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "setDragListener", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;", "getAdapter", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "orientation", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "getOrientation", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "setOrientation", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;)V", "disabledDragFlagsValue", "setDisabledDragFlagsValue", "disabledSwipeFlagsValue", "setDisabledSwipeFlagsValue", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;", "swipeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;", "getSwipeListener", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;", "setSwipeListener", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;)V", "Companion", "ListOrientation", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public class DragDropSwipeRecyclerView extends ScrollAwareRecyclerView {
    private DragDropSwipeAdapter<?, ?> adapter;
    private Integer behindSwipedItemBackgroundColor;
    private Integer behindSwipedItemBackgroundSecondaryColor;
    private boolean behindSwipedItemCenterIcon;
    private Drawable behindSwipedItemIconDrawable;
    private Integer behindSwipedItemIconDrawableId;
    private float behindSwipedItemIconMargin;
    private Drawable behindSwipedItemIconSecondaryDrawable;
    private Integer behindSwipedItemIconSecondaryDrawableId;
    private View behindSwipedItemLayout;
    private Integer behindSwipedItemLayoutId;
    private View behindSwipedItemSecondaryLayout;
    private Integer behindSwipedItemSecondaryLayoutId;
    private int disabledDragFlagsValue;
    private int disabledSwipeFlagsValue;
    private Drawable dividerDrawable;
    private Integer dividerDrawableId;
    private OnItemDragListener<?> dragListener;
    private DragDropSwipeItemDecoration itemDecoration;
    private int itemLayoutId;
    private boolean longPressToStartDragging;
    private int numOfColumnsPerRowInGridList;
    private int numOfRowsPerColumnInGridList;
    private ListOrientation orientation;
    private boolean reduceItemAlphaOnSwiping;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'VERTICAL_LIST_WITH_VERTICAL_DRAGGING' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "", "", "dragFlagsValue", "swipeFlagsValue", "<init>", "(Ljava/lang/String;III)V", "I", "getDragFlagsValue$drag_drop_swipe_recyclerview_release", "()I", "setDragFlagsValue$drag_drop_swipe_recyclerview_release", "(I)V", "getSwipeFlagsValue$drag_drop_swipe_recyclerview_release", "setSwipeFlagsValue$drag_drop_swipe_recyclerview_release", "", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation$DirectionFlag;", "getSwipeDirectionFlags", "()Ljava/util/List;", "swipeDirectionFlags", "DirectionFlag", "VERTICAL_LIST_WITH_VERTICAL_DRAGGING", "VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING", "HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING", "HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING", "GRID_LIST_WITH_HORIZONTAL_SWIPING", "GRID_LIST_WITH_VERTICAL_SWIPING", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
    public static final class ListOrientation {
        private static final /* synthetic */ ListOrientation[] $VALUES;
        public static final ListOrientation GRID_LIST_WITH_HORIZONTAL_SWIPING;
        public static final ListOrientation GRID_LIST_WITH_VERTICAL_SWIPING;
        public static final ListOrientation HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING;
        public static final ListOrientation HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING;
        public static final ListOrientation VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING;
        public static final ListOrientation VERTICAL_LIST_WITH_VERTICAL_DRAGGING;
        private int dragFlagsValue;
        private int swipeFlagsValue;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation$DirectionFlag;", "", SDKConstants.PARAM_VALUE, "", "(Ljava/lang/String;II)V", "getValue$drag_drop_swipe_recyclerview_release", "()I", "UP", "DOWN", "LEFT", "RIGHT", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
        public enum DirectionFlag {
            UP(1),
            DOWN(2),
            LEFT(4),
            RIGHT(8);

            private final int value;

            DirectionFlag(int i) {
                this.value = i;
            }

            /* JADX INFO: renamed from: getValue$drag_drop_swipe_recyclerview_release, reason: from getter */
            public final int getValue() {
                return this.value;
            }
        }

        static {
            DirectionFlag directionFlag = DirectionFlag.UP;
            int value = directionFlag.getValue();
            DirectionFlag directionFlag2 = DirectionFlag.DOWN;
            int value2 = value | directionFlag2.getValue();
            DirectionFlag directionFlag3 = DirectionFlag.LEFT;
            int value3 = directionFlag3.getValue();
            DirectionFlag directionFlag4 = DirectionFlag.RIGHT;
            ListOrientation listOrientation = new ListOrientation("VERTICAL_LIST_WITH_VERTICAL_DRAGGING", 0, value2, value3 | directionFlag4.getValue());
            VERTICAL_LIST_WITH_VERTICAL_DRAGGING = listOrientation;
            ListOrientation listOrientation2 = new ListOrientation("VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING", 1, directionFlag3.getValue() | directionFlag4.getValue() | directionFlag.getValue() | directionFlag2.getValue(), directionFlag3.getValue() | directionFlag4.getValue());
            VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING = listOrientation2;
            ListOrientation listOrientation3 = new ListOrientation("HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING", 2, directionFlag3.getValue() | directionFlag4.getValue(), directionFlag.getValue() | directionFlag2.getValue());
            HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING = listOrientation3;
            ListOrientation listOrientation4 = new ListOrientation("HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING", 3, directionFlag3.getValue() | directionFlag4.getValue() | directionFlag.getValue() | directionFlag2.getValue(), directionFlag.getValue() | directionFlag2.getValue());
            HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING = listOrientation4;
            ListOrientation listOrientation5 = new ListOrientation("GRID_LIST_WITH_HORIZONTAL_SWIPING", 4, directionFlag.getValue() | directionFlag3.getValue() | directionFlag4.getValue() | directionFlag2.getValue(), directionFlag4.getValue() | directionFlag3.getValue());
            GRID_LIST_WITH_HORIZONTAL_SWIPING = listOrientation5;
            ListOrientation listOrientation6 = new ListOrientation("GRID_LIST_WITH_VERTICAL_SWIPING", 5, 15, 3);
            GRID_LIST_WITH_VERTICAL_SWIPING = listOrientation6;
            $VALUES = new ListOrientation[]{listOrientation, listOrientation2, listOrientation3, listOrientation4, listOrientation5, listOrientation6};
        }

        private ListOrientation(String str, int i, int i2, int i3) {
            this.dragFlagsValue = i2;
            this.swipeFlagsValue = i3;
        }

        public static ListOrientation valueOf(String str) {
            return (ListOrientation) Enum.valueOf(ListOrientation.class, str);
        }

        public static ListOrientation[] values() {
            return (ListOrientation[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: getDragFlagsValue$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final int getDragFlagsValue() {
            return this.dragFlagsValue;
        }

        public final List<DirectionFlag> getSwipeDirectionFlags() {
            ArrayList arrayList = new ArrayList();
            int i = this.swipeFlagsValue;
            DirectionFlag directionFlag = DirectionFlag.UP;
            if ((i & directionFlag.getValue()) == directionFlag.getValue()) {
                arrayList.add(directionFlag);
            }
            int i2 = this.swipeFlagsValue;
            DirectionFlag directionFlag2 = DirectionFlag.DOWN;
            if ((i2 & directionFlag2.getValue()) == directionFlag2.getValue()) {
                arrayList.add(directionFlag2);
            }
            int i3 = this.swipeFlagsValue;
            DirectionFlag directionFlag3 = DirectionFlag.LEFT;
            if ((i3 & directionFlag3.getValue()) == directionFlag3.getValue()) {
                arrayList.add(directionFlag3);
            }
            int i4 = this.swipeFlagsValue;
            DirectionFlag directionFlag4 = DirectionFlag.RIGHT;
            if ((i4 & directionFlag4.getValue()) == directionFlag4.getValue()) {
                arrayList.add(directionFlag4);
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: getSwipeFlagsValue$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final int getSwipeFlagsValue() {
            return this.swipeFlagsValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragDropSwipeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.numOfColumnsPerRowInGridList = 1;
        this.numOfRowsPerColumnInGridList = 1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.DragDropSwipeRecyclerView, i, 0);
            try {
                this.itemLayoutId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_item_layout, 0);
                setDividerDrawableId(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_divider, 0)));
                setBehindSwipedItemIconDrawableId(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_icon, 0)));
                setBehindSwipedItemIconSecondaryDrawableId(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_icon_secondary, 0)));
                this.behindSwipedItemIconMargin = typedArrayObtainStyledAttributes.getDimension(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_icon_margin, 0.0f);
                this.behindSwipedItemCenterIcon = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_icon_centered, false);
                this.behindSwipedItemBackgroundColor = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_bg_color, 0));
                this.behindSwipedItemBackgroundSecondaryColor = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_bg_color_secondary, 0));
                setBehindSwipedItemLayoutId(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_custom_layout, 0)));
                setBehindSwipedItemSecondaryLayoutId(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R$styleable.DragDropSwipeRecyclerView_behind_swiped_item_custom_layout_secondary, 0)));
                this.reduceItemAlphaOnSwiping = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DragDropSwipeRecyclerView_swiped_item_opacity_fades_on_swiping, false);
                this.longPressToStartDragging = typedArrayObtainStyledAttributes.getBoolean(R$styleable.DragDropSwipeRecyclerView_long_press_to_start_dragging, false);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    private final void setDisabledDragFlagsValue(int i) {
        DragDropSwipeTouchHelper swipeAndDragHelper;
        if (i != this.disabledDragFlagsValue) {
            this.disabledDragFlagsValue = i;
            DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter = this.adapter;
            if (dragDropSwipeAdapter == null || (swipeAndDragHelper = dragDropSwipeAdapter.getSwipeAndDragHelper()) == null) {
                return;
            }
            swipeAndDragHelper.setDisabledDragFlagsValue$drag_drop_swipe_recyclerview_release(i);
        }
    }

    private final void setDisabledSwipeFlagsValue(int i) {
        DragDropSwipeTouchHelper swipeAndDragHelper;
        if (i != this.disabledSwipeFlagsValue) {
            this.disabledSwipeFlagsValue = i;
            DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter = this.adapter;
            if (dragDropSwipeAdapter == null || (swipeAndDragHelper = dragDropSwipeAdapter.getSwipeAndDragHelper()) == null) {
                return;
            }
            swipeAndDragHelper.setDisabledSwipeFlagsValue$drag_drop_swipe_recyclerview_release(i);
        }
    }

    private final void setDividerDrawable(Drawable drawable) {
        if (Intrinsics.areEqual(drawable, this.dividerDrawable)) {
            return;
        }
        this.dividerDrawable = drawable;
        DragDropSwipeItemDecoration dragDropSwipeItemDecoration = this.itemDecoration;
        if (dragDropSwipeItemDecoration == null) {
            if (drawable != null) {
                DragDropSwipeItemDecoration dragDropSwipeItemDecoration2 = new DragDropSwipeItemDecoration(drawable);
                this.itemDecoration = dragDropSwipeItemDecoration2;
                addItemDecoration(dragDropSwipeItemDecoration2, 0);
                return;
            }
            return;
        }
        if (drawable != null) {
            if (dragDropSwipeItemDecoration != null) {
                dragDropSwipeItemDecoration.setDivider(drawable);
            }
        } else {
            if (dragDropSwipeItemDecoration != null) {
                removeItemDecoration(dragDropSwipeItemDecoration);
            }
            this.itemDecoration = null;
        }
    }

    public final void disableSwipeDirection(ListOrientation.DirectionFlag swipeDirectionToDisable) {
        List<ListOrientation.DirectionFlag> swipeDirectionFlags;
        swipeDirectionToDisable.getClass();
        int value = swipeDirectionToDisable.getValue();
        ListOrientation listOrientation = this.orientation;
        if (listOrientation == null || (swipeDirectionFlags = listOrientation.getSwipeDirectionFlags()) == null) {
            return;
        }
        List<ListOrientation.DirectionFlag> list = swipeDirectionFlags;
        if ((list instanceof Collection) && list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if ((((ListOrientation.DirectionFlag) it.next()).getValue() & value) == value) {
                setDisabledSwipeFlagsValue(value | this.disabledSwipeFlagsValue);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final DragDropSwipeAdapter<?, ?> getAdapter() {
        return this.adapter;
    }

    public final Integer getBehindSwipedItemBackgroundColor() {
        return this.behindSwipedItemBackgroundColor;
    }

    public final Integer getBehindSwipedItemBackgroundSecondaryColor() {
        return this.behindSwipedItemBackgroundSecondaryColor;
    }

    public final boolean getBehindSwipedItemCenterIcon() {
        return this.behindSwipedItemCenterIcon;
    }

    public final Drawable getBehindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release() {
        Integer num = this.behindSwipedItemIconDrawableId;
        if (this.behindSwipedItemIconDrawable == null && num != null && num.intValue() != 0) {
            this.behindSwipedItemIconDrawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        } else if (num == null || num.intValue() == 0) {
            this.behindSwipedItemIconDrawable = null;
        }
        return this.behindSwipedItemIconDrawable;
    }

    public final Integer getBehindSwipedItemIconDrawableId() {
        return this.behindSwipedItemIconDrawableId;
    }

    public final float getBehindSwipedItemIconMargin() {
        return this.behindSwipedItemIconMargin;
    }

    public final Drawable getBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release() {
        Integer num = this.behindSwipedItemIconSecondaryDrawableId;
        if (this.behindSwipedItemIconSecondaryDrawable == null && num != null && num.intValue() != 0) {
            this.behindSwipedItemIconSecondaryDrawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        } else if (num == null || num.intValue() == 0) {
            this.behindSwipedItemIconSecondaryDrawable = null;
        }
        return this.behindSwipedItemIconSecondaryDrawable;
    }

    public final Integer getBehindSwipedItemIconSecondaryDrawableId() {
        return this.behindSwipedItemIconSecondaryDrawableId;
    }

    public final View getBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release() {
        Integer num = this.behindSwipedItemLayoutId;
        if (this.behindSwipedItemLayout == null && num != null && num.intValue() != 0) {
            this.behindSwipedItemLayout = LayoutInflater.from(getContext()).inflate(num.intValue(), (ViewGroup) null, false);
        } else if (num == null || num.intValue() == 0) {
            this.behindSwipedItemLayout = null;
        }
        return this.behindSwipedItemLayout;
    }

    public final Integer getBehindSwipedItemLayoutId() {
        return this.behindSwipedItemLayoutId;
    }

    public final View getBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release() {
        Integer num = this.behindSwipedItemSecondaryLayoutId;
        if (this.behindSwipedItemSecondaryLayout == null && num != null && num.intValue() != 0) {
            this.behindSwipedItemSecondaryLayout = LayoutInflater.from(getContext()).inflate(num.intValue(), (ViewGroup) null, false);
        } else if (num == null || num.intValue() == 0) {
            this.behindSwipedItemSecondaryLayout = null;
        }
        return this.behindSwipedItemSecondaryLayout;
    }

    public final Integer getBehindSwipedItemSecondaryLayoutId() {
        return this.behindSwipedItemSecondaryLayoutId;
    }

    public final Drawable getDividerDrawable$drag_drop_swipe_recyclerview_release() {
        DragDropSwipeItemDecoration dragDropSwipeItemDecoration;
        Integer num = this.dividerDrawableId;
        if (this.dividerDrawable == null && num != null && num.intValue() != 0) {
            this.dividerDrawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        } else if (num == null || num.intValue() == 0) {
            this.dividerDrawable = null;
        }
        Drawable drawable = this.dividerDrawable;
        if (drawable != null && (dragDropSwipeItemDecoration = this.itemDecoration) != null) {
            dragDropSwipeItemDecoration.setDivider(drawable);
        }
        return this.dividerDrawable;
    }

    public final Integer getDividerDrawableId() {
        return this.dividerDrawableId;
    }

    public final OnItemDragListener<?> getDragListener() {
        return this.dragListener;
    }

    public final int getItemLayoutId() {
        return this.itemLayoutId;
    }

    public final boolean getLongPressToStartDragging() {
        return this.longPressToStartDragging;
    }

    public final int getNumOfColumnsPerRowInGridList() {
        return this.numOfColumnsPerRowInGridList;
    }

    public final int getNumOfRowsPerColumnInGridList() {
        return this.numOfRowsPerColumnInGridList;
    }

    public final ListOrientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReduceItemAlphaOnSwiping() {
        return this.reduceItemAlphaOnSwiping;
    }

    public final OnItemSwipeListener<?> getSwipeListener() {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (isSaveEnabled() && (state instanceof Bundle)) {
            Bundle bundle = (Bundle) state;
            Parcelable parcelable = bundle.getParcelable("super_state");
            this.itemLayoutId = bundle.getInt("item_layout_id", 0);
            setDividerDrawableId(Integer.valueOf(bundle.getInt("divider_drawable_id", 0)));
            setBehindSwipedItemIconDrawableId(Integer.valueOf(bundle.getInt("behind_swiped_item_icon_drawable_id", 0)));
            setBehindSwipedItemIconSecondaryDrawableId(Integer.valueOf(bundle.getInt("behind_swiped_item_icon_secondary_drawable_id", 0)));
            this.behindSwipedItemIconMargin = bundle.getFloat("behind_swiped_item_icon_margin", 0.0f);
            this.behindSwipedItemCenterIcon = bundle.getBoolean("behind_swiped_item_center_icon", false);
            this.behindSwipedItemBackgroundColor = Integer.valueOf(bundle.getInt("behind_swiped_item_background_color", 0));
            this.behindSwipedItemBackgroundSecondaryColor = Integer.valueOf(bundle.getInt("behind_swiped_item_background_secondary_color", 0));
            setBehindSwipedItemLayoutId(Integer.valueOf(bundle.getInt("behind_swiped_item_layout_id", 0)));
            setBehindSwipedItemSecondaryLayoutId(Integer.valueOf(bundle.getInt("behind_swiped_item_secondary_layout_id", 0)));
            this.reduceItemAlphaOnSwiping = bundle.getBoolean("reduce_item_alpha_on_swiping", false);
            this.longPressToStartDragging = bundle.getBoolean("long_press_to_start_dragging", false);
            this.numOfColumnsPerRowInGridList = bundle.getInt("num_of_columns_per_row_in_grid_list", 1);
            this.numOfRowsPerColumnInGridList = bundle.getInt("num_of_rows_per_column_in_grid_list", 1);
            String string = bundle.getString("orientation_name", null);
            if (string != null && string.length() > 0) {
                setOrientation(ListOrientation.valueOf(string));
            }
            setDisabledDragFlagsValue(bundle.getInt("disabled_drag_flags_value", 0));
            setDisabledSwipeFlagsValue(bundle.getInt("disabled_swipe_flags_value", 0));
            state = parcelable;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return parcelableOnSaveInstanceState;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super_state", parcelableOnSaveInstanceState);
        bundle.putInt("item_layout_id", this.itemLayoutId);
        Integer num = this.dividerDrawableId;
        bundle.putInt("divider_drawable_id", num != null ? num.intValue() : 0);
        Integer num2 = this.behindSwipedItemIconDrawableId;
        bundle.putInt("behind_swiped_item_icon_drawable_id", num2 != null ? num2.intValue() : 0);
        Integer num3 = this.behindSwipedItemIconSecondaryDrawableId;
        bundle.putInt("behind_swiped_item_icon_secondary_drawable_id", num3 != null ? num3.intValue() : 0);
        bundle.putFloat("behind_swiped_item_icon_margin", this.behindSwipedItemIconMargin);
        bundle.putBoolean("behind_swiped_item_center_icon", this.behindSwipedItemCenterIcon);
        Integer num4 = this.behindSwipedItemBackgroundColor;
        bundle.putInt("behind_swiped_item_background_color", num4 != null ? num4.intValue() : 0);
        Integer num5 = this.behindSwipedItemBackgroundSecondaryColor;
        bundle.putInt("behind_swiped_item_background_secondary_color", num5 != null ? num5.intValue() : 0);
        Integer num6 = this.behindSwipedItemLayoutId;
        bundle.putInt("behind_swiped_item_layout_id", num6 != null ? num6.intValue() : 0);
        Integer num7 = this.behindSwipedItemSecondaryLayoutId;
        bundle.putInt("behind_swiped_item_secondary_layout_id", num7 != null ? num7.intValue() : 0);
        bundle.putBoolean("reduce_item_alpha_on_swiping", this.reduceItemAlphaOnSwiping);
        bundle.putBoolean("long_press_to_start_dragging", this.longPressToStartDragging);
        bundle.putInt("num_of_columns_per_row_in_grid_list", this.numOfColumnsPerRowInGridList);
        bundle.putInt("num_of_rows_per_column_in_grid_list", this.numOfRowsPerColumnInGridList);
        ListOrientation listOrientation = this.orientation;
        bundle.putString("orientation_name", listOrientation != null ? listOrientation.name() : null);
        bundle.putInt("disabled_drag_flags_value", this.disabledDragFlagsValue);
        bundle.putInt("disabled_swipe_flags_value", this.disabledSwipeFlagsValue);
        return bundle;
    }

    public final void setAdapter(DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter) {
        if (dragDropSwipeAdapter == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("A null adapter cannot be set.");
            return;
        }
        if (Intrinsics.areEqual(dragDropSwipeAdapter, this.adapter)) {
            return;
        }
        this.adapter = dragDropSwipeAdapter;
        dragDropSwipeAdapter.setInternalDragListener$drag_drop_swipe_recyclerview_release(this.dragListener);
        dragDropSwipeAdapter.setInternalSwipeListener$drag_drop_swipe_recyclerview_release(null);
        dragDropSwipeAdapter.getSwipeAndDragHelper().setOrientation$drag_drop_swipe_recyclerview_release(this.orientation);
        dragDropSwipeAdapter.getSwipeAndDragHelper().setDisabledDragFlagsValue$drag_drop_swipe_recyclerview_release(this.disabledDragFlagsValue);
        dragDropSwipeAdapter.getSwipeAndDragHelper().setDisabledSwipeFlagsValue$drag_drop_swipe_recyclerview_release(this.disabledSwipeFlagsValue);
        super.setAdapter((RecyclerView.Adapter) dragDropSwipeAdapter);
    }

    public final void setBehindSwipedItemBackgroundColor(Integer num) {
        this.behindSwipedItemBackgroundColor = num;
    }

    public final void setBehindSwipedItemBackgroundSecondaryColor(Integer num) {
        this.behindSwipedItemBackgroundSecondaryColor = num;
    }

    public final void setBehindSwipedItemCenterIcon(boolean z) {
        this.behindSwipedItemCenterIcon = z;
    }

    public final void setBehindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release(Drawable drawable) {
        this.behindSwipedItemIconDrawable = drawable;
    }

    public final void setBehindSwipedItemIconDrawableId(Integer num) {
        if (Intrinsics.areEqual(num, this.behindSwipedItemIconDrawableId)) {
            return;
        }
        this.behindSwipedItemIconDrawableId = num;
        if (num == null || num.intValue() == 0) {
            this.behindSwipedItemIconDrawable = null;
            return;
        }
        Drawable drawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        if (drawable != null) {
            this.behindSwipedItemIconDrawable = drawable;
        }
    }

    public final void setBehindSwipedItemIconMargin(float f) {
        this.behindSwipedItemIconMargin = f;
    }

    public final void setBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release(Drawable drawable) {
        this.behindSwipedItemIconSecondaryDrawable = drawable;
    }

    public final void setBehindSwipedItemIconSecondaryDrawableId(Integer num) {
        if (Intrinsics.areEqual(num, this.behindSwipedItemIconSecondaryDrawableId)) {
            return;
        }
        this.behindSwipedItemIconSecondaryDrawableId = num;
        if (num == null || num.intValue() == 0) {
            this.behindSwipedItemIconSecondaryDrawable = null;
            return;
        }
        Drawable drawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        if (drawable != null) {
            this.behindSwipedItemIconSecondaryDrawable = drawable;
        }
    }

    public final void setBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release(View view) {
        this.behindSwipedItemLayout = view;
    }

    public final void setBehindSwipedItemLayoutId(Integer num) {
        if (Intrinsics.areEqual(num, this.behindSwipedItemLayoutId)) {
            return;
        }
        this.behindSwipedItemLayoutId = num;
        if (num == null || num.intValue() == 0) {
            this.behindSwipedItemLayout = null;
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(num.intValue(), (ViewGroup) null, false);
        if (viewInflate != null) {
            this.behindSwipedItemLayout = viewInflate;
        }
    }

    public final void setBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release(View view) {
        this.behindSwipedItemSecondaryLayout = view;
    }

    public final void setBehindSwipedItemSecondaryLayoutId(Integer num) {
        if (Intrinsics.areEqual(num, this.behindSwipedItemSecondaryLayoutId)) {
            return;
        }
        this.behindSwipedItemSecondaryLayoutId = num;
        if (num == null || num.intValue() == 0) {
            this.behindSwipedItemSecondaryLayout = null;
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(num.intValue(), (ViewGroup) null, false);
        if (viewInflate != null) {
            this.behindSwipedItemSecondaryLayout = viewInflate;
        }
    }

    public final void setDividerDrawableId(Integer num) {
        if (Intrinsics.areEqual(num, this.dividerDrawableId)) {
            return;
        }
        this.dividerDrawableId = num;
        if (num == null || num.intValue() == 0) {
            setDividerDrawable(null);
            return;
        }
        Drawable drawable = AppCompatResources.getDrawable(getContext(), num.intValue());
        if (drawable != null) {
            setDividerDrawable(drawable);
        }
    }

    public final void setDragListener(OnItemDragListener<?> onItemDragListener) {
        if (Intrinsics.areEqual(onItemDragListener, this.dragListener)) {
            return;
        }
        this.dragListener = onItemDragListener;
        DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter = this.adapter;
        if (dragDropSwipeAdapter != null) {
            dragDropSwipeAdapter.setInternalDragListener$drag_drop_swipe_recyclerview_release(onItemDragListener);
        }
    }

    public final void setItemLayoutId(int i) {
        this.itemLayoutId = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (this.orientation == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
                setOrientation(orientation != 0 ? orientation != 1 ? this.orientation : ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING : ListOrientation.HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING);
            } else if (layoutManager instanceof GridLayoutManager) {
                int orientation2 = ((GridLayoutManager) layoutManager).getOrientation();
                setOrientation(orientation2 != 0 ? orientation2 != 1 ? this.orientation : ListOrientation.GRID_LIST_WITH_HORIZONTAL_SWIPING : ListOrientation.GRID_LIST_WITH_VERTICAL_SWIPING);
            }
        }
    }

    public final void setLongPressToStartDragging(boolean z) {
        this.longPressToStartDragging = z;
    }

    public final void setNumOfColumnsPerRowInGridList(int i) {
        this.numOfColumnsPerRowInGridList = i;
    }

    public final void setNumOfRowsPerColumnInGridList(int i) {
        this.numOfRowsPerColumnInGridList = i;
    }

    public final void setOrientation(ListOrientation listOrientation) {
        DragDropSwipeTouchHelper swipeAndDragHelper;
        if (listOrientation != this.orientation) {
            this.orientation = listOrientation;
            setDisabledDragFlagsValue(0);
            setDisabledSwipeFlagsValue(0);
            DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter = this.adapter;
            if (dragDropSwipeAdapter == null || (swipeAndDragHelper = dragDropSwipeAdapter.getSwipeAndDragHelper()) == null) {
                return;
            }
            swipeAndDragHelper.setOrientation$drag_drop_swipe_recyclerview_release(listOrientation);
        }
    }

    public final void setReduceItemAlphaOnSwiping(boolean z) {
        this.reduceItemAlphaOnSwiping = z;
    }

    public final void setSwipeListener(OnItemSwipeListener<?> onItemSwipeListener) {
        DragDropSwipeAdapter<?, ?> dragDropSwipeAdapter;
        if (Intrinsics.areEqual(onItemSwipeListener, (Object) null) || (dragDropSwipeAdapter = this.adapter) == null) {
            return;
        }
        dragDropSwipeAdapter.setInternalSwipeListener$drag_drop_swipe_recyclerview_release(onItemSwipeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> adapter) {
        if (adapter != null ? adapter instanceof DragDropSwipeAdapter : true) {
            setAdapter((DragDropSwipeAdapter<?, ?>) adapter);
            return;
        }
        throw new TypeCastException("The adapter must be an extension of DragDropSwipeAdapter.");
    }

    public /* synthetic */ DragDropSwipeRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public DragDropSwipeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }
}
