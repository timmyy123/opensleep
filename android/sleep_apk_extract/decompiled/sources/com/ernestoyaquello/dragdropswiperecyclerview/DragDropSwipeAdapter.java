package com.ernestoyaquello.dragdropswiperecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter.ViewHolder;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener;
import com.ernestoyaquello.dragdropswiperecyclerview.util.DividerDrawingHelperKt;
import com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005*\b\u0085\u0001\u0088\u0001\u008b\u0001\u008e\u0001\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0002\u0099\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH$¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH$¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0019\u0010\u0018J'\u0010\u001a\u001a\u00020\u00162\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001a\u0010\u0018J)\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0004\b \u0010\u001fJM\u0010'\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u0016H\u0014¢\u0006\u0004\b'\u0010(JM\u0010)\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u0016H\u0014¢\u0006\u0004\b)\u0010(J\u001f\u0010*\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0004\b*\u0010\u001fJ\u0017\u0010+\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0004\b+\u0010,J\u001d\u00101\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010-H\u0000¢\u0006\u0004\b/\u00100J\u001d\u00105\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u000102H\u0000¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u00020\u000fH\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010;\u001a\u00028\u00012\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u000fH\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010=\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010>J\u0017\u0010A\u001a\u00020\u00112\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00112\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bC\u0010BJ\u0015\u0010D\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001d\u0010H\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000f¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u000fH\u0002¢\u0006\u0004\bJ\u0010IJ\u0017\u0010K\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\bK\u0010EJ\u0017\u0010L\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\bL\u0010,J\u0017\u0010M\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\bM\u0010,J\u0017\u0010N\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\bN\u0010,J\u0017\u0010O\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\bO\u0010,J)\u0010P\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\bP\u0010\u0015J)\u0010Q\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\bQ\u0010\u0015JC\u0010R\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\bR\u0010SJC\u0010T\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u0016H\u0002¢\u0006\u0004\bT\u0010SJ;\u0010U\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u00012\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\bU\u0010VJ#\u0010W\u001a\u0004\u0018\u00010\u00112\b\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\bW\u0010XJW\u0010a\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020Y2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u0016H\u0002¢\u0006\u0004\ba\u0010bJo\u0010m\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020Y2\u0006\u0010%\u001a\u00020#2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020g2\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000fH\u0002¢\u0006\u0004\bm\u0010nJc\u0010p\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020Y2\u0006\u0010%\u001a\u00020#2\u0006\u0010\u000e\u001a\u00028\u00012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010gH\u0002¢\u0006\u0004\bp\u0010qJ'\u0010r\u001a\u00020\u00112\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010=\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\br\u0010\u0013J\u001f\u0010t\u001a\u00020\u00112\u0006\u0010s\u001a\u00020\t2\u0006\u0010=\u001a\u00028\u0001H\u0002¢\u0006\u0004\bt\u0010uJ\u001f\u0010v\u001a\u00020\u00112\u0006\u0010s\u001a\u00020\t2\u0006\u0010=\u001a\u00028\u0001H\u0002¢\u0006\u0004\bv\u0010uR\u0018\u0010@\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010wR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00028\u00000x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001e\u0010~\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR \u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u0086\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R$\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R$\u0010\u008c\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008b\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R$\u0010\u008f\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R4\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F@FX\u0086\u000e¢\u0006\u000f\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0005\b\u0094\u0001\u0010\bR\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;", "T", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;", "U", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "dataSet", "<init>", "(Ljava/util/List;)V", "Landroid/view/View;", "itemView", "getViewHolder", "(Landroid/view/View;)Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;", "item", "viewHolder", "", "position", "", "onBindViewHolder", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;I)V", "getViewToTouchToStartDraggingItem", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;I)Landroid/view/View;", "", "canBeDragged", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;I)Z", "canBeDroppedOver", "canBeSwiped", "getBehindSwipedItemLayoutId", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;I)Ljava/lang/Integer;", "getBehindSwipedItemSecondaryLayoutId", "onDragStarted", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;)V", "onSwipeStarted", "offsetX", "offsetY", "Landroid/graphics/Canvas;", "canvasUnder", "canvasOver", "isUserControlled", "onIsDragging", "(Ljava/lang/Object;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;IILandroid/graphics/Canvas;Landroid/graphics/Canvas;Z)V", "onIsSwiping", "onDragFinished", "onSwipeAnimationFinished", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;)V", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "listener", "setInternalDragListener$drag_drop_swipe_recyclerview_release", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;)V", "setInternalDragListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;", "setInternalSwipeListener$drag_drop_swipe_recyclerview_release", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;)V", "setInternalSwipeListener", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;", "holder", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "removeItem", "(I)V", "previousPosition", "newPosition", "moveItem", "(II)V", "onListItemDragged", "onListItemSwiped", "onDragStartedImpl", "onSwipeStartedImpl", "onDragFinishedImpl", "onSwipeFinishedImpl", "getBehindSwipedItemLayout", "getBehindSwipedItemSecondaryLayout", "onIsSwipingImpl", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;IILandroid/graphics/Canvas;Landroid/graphics/Canvas;Z)V", "onIsDraggingImpl", "drawOnSwiping", "(IILcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;Landroid/graphics/Canvas;Landroid/graphics/Canvas;)V", "drawOnDragging", "(Landroid/graphics/Canvas;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;)Lkotlin/Unit;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "list", ViewHierarchyConstants.DIMENSION_LEFT_KEY, ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "isSwipingHorizontally", "isSecondarySwipeDirection", "drawLayoutBehindOnSwiping", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;Landroid/graphics/Canvas;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;IIIIZZ)V", "currentLayoutAreaLeft", "currentLayoutAreaTop", "currentLayoutAreaRight", "currentLayoutAreaBottom", "", "newItemAlpha", "originalLayoutAreaLeft", "originalLayoutAreaTop", "originalLayoutAreaRight", "originalLayoutAreaBottom", "drawDividersOnSwiping", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;Landroid/graphics/Canvas;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;IIIIFIIII)V", "alpha", "drawDividers", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;Landroid/graphics/Canvas;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;)V", "setViewForDragging", "viewToDrag", "setItemDragAndDrop", "(Landroid/view/View;Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;)V", "setItemDragAndDropWithLongPress", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView;", "", "mutableDataSet", "Ljava/util/List;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "dragListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper;", "swipeAndDragHelper", "Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper;", "getSwipeAndDragHelper$drag_drop_swipe_recyclerview_release", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/util/DragDropSwipeTouchHelper;", "com/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemDragListener$1", "itemDragListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemDragListener$1;", "com/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemSwipeListener$1", "itemSwipeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemSwipeListener$1;", "com/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$stateChangeListener$1", "stateChangeListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$stateChangeListener$1;", "com/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemLayoutPositionListener$1", "itemLayoutPositionListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$itemLayoutPositionListener$1;", SDKConstants.PARAM_VALUE, "getDataSet", "()Ljava/util/List;", "setDataSet", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "getOrientation", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeRecyclerView$ListOrientation;", "orientation", "ViewHolder", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public abstract class DragDropSwipeAdapter<T, U extends ViewHolder> extends RecyclerView.Adapter<U> {
    private OnItemDragListener<T> dragListener;
    private final DragDropSwipeAdapter$itemDragListener$1 itemDragListener;
    private final DragDropSwipeAdapter$itemLayoutPositionListener$1 itemLayoutPositionListener;
    private final DragDropSwipeAdapter$itemSwipeListener$1 itemSwipeListener;
    private ItemTouchHelper itemTouchHelper;
    private List<T> mutableDataSet;
    private DragDropSwipeRecyclerView recyclerView;
    private final DragDropSwipeAdapter$stateChangeListener$1 stateChangeListener;
    private final DragDropSwipeTouchHelper swipeAndDragHelper;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006!"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "layout", "Landroid/view/View;", "(Landroid/view/View;)V", "behindSwipedItemLayout", "getBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release", "()Landroid/view/View;", "setBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release", "behindSwipedItemSecondaryLayout", "getBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release", "setBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release", "canBeDragged", "Lkotlin/Function0;", "", "getCanBeDragged$drag_drop_swipe_recyclerview_release", "()Lkotlin/jvm/functions/Function0;", "setCanBeDragged$drag_drop_swipe_recyclerview_release", "(Lkotlin/jvm/functions/Function0;)V", "canBeDroppedOver", "getCanBeDroppedOver$drag_drop_swipe_recyclerview_release", "setCanBeDroppedOver$drag_drop_swipe_recyclerview_release", "canBeSwiped", "getCanBeSwiped$drag_drop_swipe_recyclerview_release", "setCanBeSwiped$drag_drop_swipe_recyclerview_release", "isBeingDragged", "isBeingDragged$drag_drop_swipe_recyclerview_release", "()Z", "setBeingDragged$drag_drop_swipe_recyclerview_release", "(Z)V", "isBeingSwiped", "isBeingSwiped$drag_drop_swipe_recyclerview_release", "setBeingSwiped$drag_drop_swipe_recyclerview_release", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        private View behindSwipedItemLayout;
        private View behindSwipedItemSecondaryLayout;
        private Function0<Boolean> canBeDragged;
        private Function0<Boolean> canBeDroppedOver;
        private Function0<Boolean> canBeSwiped;
        private boolean isBeingDragged;
        private boolean isBeingSwiped;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
        }

        /* JADX INFO: renamed from: getBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final View getBehindSwipedItemLayout() {
            return this.behindSwipedItemLayout;
        }

        /* JADX INFO: renamed from: getBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final View getBehindSwipedItemSecondaryLayout() {
            return this.behindSwipedItemSecondaryLayout;
        }

        public final Function0<Boolean> getCanBeDragged$drag_drop_swipe_recyclerview_release() {
            return this.canBeDragged;
        }

        public final Function0<Boolean> getCanBeDroppedOver$drag_drop_swipe_recyclerview_release() {
            return this.canBeDroppedOver;
        }

        public final Function0<Boolean> getCanBeSwiped$drag_drop_swipe_recyclerview_release() {
            return this.canBeSwiped;
        }

        /* JADX INFO: renamed from: isBeingDragged$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final boolean getIsBeingDragged() {
            return this.isBeingDragged;
        }

        /* JADX INFO: renamed from: isBeingSwiped$drag_drop_swipe_recyclerview_release, reason: from getter */
        public final boolean getIsBeingSwiped() {
            return this.isBeingSwiped;
        }

        public final void setBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release(View view) {
            this.behindSwipedItemLayout = view;
        }

        public final void setBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release(View view) {
            this.behindSwipedItemSecondaryLayout = view;
        }

        public final void setBeingDragged$drag_drop_swipe_recyclerview_release(boolean z) {
            this.isBeingDragged = z;
        }

        public final void setBeingSwiped$drag_drop_swipe_recyclerview_release(boolean z) {
            this.isBeingSwiped = z;
        }

        public final void setCanBeDragged$drag_drop_swipe_recyclerview_release(Function0<Boolean> function0) {
            this.canBeDragged = function0;
        }

        public final void setCanBeDroppedOver$drag_drop_swipe_recyclerview_release(Function0<Boolean> function0) {
            this.canBeDroppedOver = function0;
        }

        public final void setCanBeSwiped$drag_drop_swipe_recyclerview_release(Function0<Boolean> function0) {
            this.canBeSwiped = function0;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType.DRAG_STARTED.ordinal()] = 1;
            iArr[DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType.DRAG_FINISHED.ordinal()] = 2;
            iArr[DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType.SWIPE_STARTED.ordinal()] = 3;
            iArr[DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType.SWIPE_FINISHED.ordinal()] = 4;
            int[] iArr2 = new int[DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener.Action.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener.Action.SWIPING.ordinal()] = 1;
            iArr2[DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener.Action.DRAGGING.ordinal()] = 2;
            int[] iArr3 = new int[DragDropSwipeRecyclerView.ListOrientation.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING.ordinal()] = 1;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_UNCONSTRAINED_DRAGGING.ordinal()] = 2;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.HORIZONTAL_LIST_WITH_UNCONSTRAINED_DRAGGING.ordinal()] = 3;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.HORIZONTAL_LIST_WITH_HORIZONTAL_DRAGGING.ordinal()] = 4;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_HORIZONTAL_SWIPING.ordinal()] = 5;
            iArr3[DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_VERTICAL_SWIPING.ordinal()] = 6;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemDragListener$1, com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper$OnItemDragListener] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemSwipeListener$1, com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper$OnItemSwipeListener] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$stateChangeListener$1, com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper$OnItemStateChangeListener] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemLayoutPositionListener$1, com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper$OnItemLayoutPositionChangeListener] */
    public DragDropSwipeAdapter(List<? extends T> list) {
        list.getClass();
        this.mutableDataSet = CollectionsKt.toMutableList((Collection) list);
        ?? r1 = new DragDropSwipeTouchHelper.OnItemDragListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemDragListener$1
            @Override // com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper.OnItemDragListener
            public void onItemDragged(int previousPosition, int newPosition) {
                Object obj = this.this$0.mutableDataSet.get(previousPosition);
                this.this$0.onListItemDragged(previousPosition, newPosition);
                OnItemDragListener onItemDragListener = this.this$0.dragListener;
                if (onItemDragListener != null) {
                    onItemDragListener.onItemDragged(previousPosition, newPosition, obj);
                }
            }

            @Override // com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper.OnItemDragListener
            public void onItemDropped(int initialPosition, int finalPosition) {
                if (finalPosition == -1) {
                    return;
                }
                Object obj = this.this$0.mutableDataSet.get(finalPosition);
                OnItemDragListener onItemDragListener = this.this$0.dragListener;
                if (onItemDragListener != null) {
                    onItemDragListener.onItemDropped(initialPosition, finalPosition, obj);
                }
            }
        };
        this.itemDragListener = r1;
        ?? r2 = new DragDropSwipeTouchHelper.OnItemSwipeListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemSwipeListener$1
            @Override // com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper.OnItemSwipeListener
            public void onItemSwiped(int position, OnItemSwipeListener.SwipeDirection direction) {
                direction.getClass();
                this.this$0.mutableDataSet.get(position);
                DragDropSwipeAdapter.access$getSwipeListener$p(this.this$0);
                this.this$0.onListItemSwiped(position);
            }
        };
        this.itemSwipeListener = r2;
        ?? r3 = new DragDropSwipeTouchHelper.OnItemStateChangeListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$stateChangeListener$1
            @Override // com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper.OnItemStateChangeListener
            public void onStateChanged(DragDropSwipeTouchHelper.OnItemStateChangeListener.StateChangeType newState, RecyclerView.ViewHolder viewHolder) {
                newState.getClass();
                viewHolder.getClass();
                DragDropSwipeAdapter.ViewHolder viewHolder2 = (DragDropSwipeAdapter.ViewHolder) viewHolder;
                int i = DragDropSwipeAdapter.WhenMappings.$EnumSwitchMapping$0[newState.ordinal()];
                if (i == 1) {
                    this.this$0.onDragStartedImpl(viewHolder2);
                    return;
                }
                if (i == 2) {
                    this.this$0.onDragFinishedImpl(viewHolder2);
                } else if (i == 3) {
                    this.this$0.onSwipeStartedImpl(viewHolder2);
                } else {
                    if (i != 4) {
                        return;
                    }
                    this.this$0.onSwipeFinishedImpl(viewHolder2);
                }
            }
        };
        this.stateChangeListener = r3;
        ?? r4 = new DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$itemLayoutPositionListener$1
            @Override // com.ernestoyaquello.dragdropswiperecyclerview.util.DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener
            public void onPositionChanged(DragDropSwipeTouchHelper.OnItemLayoutPositionChangeListener.Action action, RecyclerView.ViewHolder viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled) {
                action.getClass();
                viewHolder.getClass();
                DragDropSwipeAdapter.ViewHolder viewHolder2 = (DragDropSwipeAdapter.ViewHolder) viewHolder;
                int i = DragDropSwipeAdapter.WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
                if (i == 1) {
                    this.this$0.onIsSwipingImpl(viewHolder2, offsetX, offsetY, canvasUnder, canvasOver, isUserControlled);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.this$0.onIsDraggingImpl(viewHolder2, offsetX, offsetY, canvasUnder, canvasOver, isUserControlled);
                }
            }
        };
        this.itemLayoutPositionListener = r4;
        DragDropSwipeTouchHelper dragDropSwipeTouchHelper = new DragDropSwipeTouchHelper(r1, r2, r3, r4, this.recyclerView);
        this.swipeAndDragHelper = dragDropSwipeTouchHelper;
        this.itemTouchHelper = new ItemTouchHelper(dragDropSwipeTouchHelper);
    }

    public static final /* synthetic */ OnItemSwipeListener access$getSwipeListener$p(DragDropSwipeAdapter dragDropSwipeAdapter) {
        dragDropSwipeAdapter.getClass();
        return null;
    }

    private final void drawDividers(DragDropSwipeRecyclerView list, Canvas canvasOver, U viewHolder, Integer left, Integer top, Integer right, Integer bottom, Float alpha) {
        Drawable dividerDrawable$drag_drop_swipe_recyclerview_release = list.getDividerDrawable$drag_drop_swipe_recyclerview_release();
        if (dividerDrawable$drag_drop_swipe_recyclerview_release != null) {
            switch (WhenMappings.$EnumSwitchMapping$2[getOrientation().ordinal()]) {
                case 1:
                case 2:
                    View view = viewHolder.itemView;
                    view.getClass();
                    DividerDrawingHelperKt.drawHorizontalDividers(view, canvasOver, dividerDrawable$drag_drop_swipe_recyclerview_release, left, right, alpha);
                    break;
                case 3:
                case 4:
                    View view2 = viewHolder.itemView;
                    view2.getClass();
                    DividerDrawingHelperKt.drawVerticalDividers(view2, canvasOver, dividerDrawable$drag_drop_swipe_recyclerview_release, top, bottom, alpha);
                    break;
                case 5:
                case 6:
                    View view3 = viewHolder.itemView;
                    view3.getClass();
                    DividerDrawingHelperKt.drawHorizontalDividers(view3, canvasOver, dividerDrawable$drag_drop_swipe_recyclerview_release, left, right, alpha);
                    View view4 = viewHolder.itemView;
                    view4.getClass();
                    DividerDrawingHelperKt.drawVerticalDividers(view4, canvasOver, dividerDrawable$drag_drop_swipe_recyclerview_release, top, bottom, alpha);
                    break;
            }
        }
    }

    public static /* synthetic */ void drawDividers$default(DragDropSwipeAdapter dragDropSwipeAdapter, DragDropSwipeRecyclerView dragDropSwipeRecyclerView, Canvas canvas, ViewHolder viewHolder, Integer num, Integer num2, Integer num3, Integer num4, Float f, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: drawDividers");
            return;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        if ((i & 32) != 0) {
            num3 = null;
        }
        if ((i & 64) != 0) {
            num4 = null;
        }
        if ((i & 128) != 0) {
            f = null;
        }
        dragDropSwipeAdapter.drawDividers(dragDropSwipeRecyclerView, canvas, viewHolder, num, num2, num3, num4, f);
    }

    private final void drawDividersOnSwiping(DragDropSwipeRecyclerView list, Canvas canvasOver, U viewHolder, int currentLayoutAreaLeft, int currentLayoutAreaTop, int currentLayoutAreaRight, int currentLayoutAreaBottom, float newItemAlpha, int originalLayoutAreaLeft, int originalLayoutAreaTop, int originalLayoutAreaRight, int originalLayoutAreaBottom) {
        drawDividers(list, canvasOver, viewHolder, Integer.valueOf(currentLayoutAreaLeft), Integer.valueOf(currentLayoutAreaTop), Integer.valueOf(currentLayoutAreaRight), Integer.valueOf(currentLayoutAreaBottom), Float.valueOf(newItemAlpha));
        if (getOrientation() == DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_HORIZONTAL_SWIPING || getOrientation() == DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_VERTICAL_SWIPING) {
            return;
        }
        drawDividers$default(this, list, canvasOver, viewHolder, Integer.valueOf(originalLayoutAreaLeft), Integer.valueOf(originalLayoutAreaTop), Integer.valueOf(originalLayoutAreaRight), Integer.valueOf(originalLayoutAreaBottom), null, 128, null);
    }

    private final void drawLayoutBehindOnSwiping(DragDropSwipeRecyclerView list, Canvas canvasUnder, U viewHolder, int left, int top, int right, int bottom, boolean isSwipingHorizontally, boolean isSecondarySwipeDirection) {
        Integer behindSwipedItemBackgroundSecondaryColor;
        canvasUnder.save();
        canvasUnder.clipRect(left, top, right, bottom);
        View behindSwipedItemLayout = viewHolder.getBehindSwipedItemLayout();
        if (behindSwipedItemLayout == null) {
            behindSwipedItemLayout = list.getBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release();
        }
        View behindSwipedItemSecondaryLayout = viewHolder.getBehindSwipedItemSecondaryLayout();
        if (behindSwipedItemSecondaryLayout == null) {
            behindSwipedItemSecondaryLayout = list.getBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release();
        }
        if (isSecondarySwipeDirection && behindSwipedItemSecondaryLayout != null) {
            behindSwipedItemLayout = behindSwipedItemSecondaryLayout;
        }
        if (behindSwipedItemLayout != null) {
            int i = right - left;
            int i2 = bottom - top;
            if (behindSwipedItemLayout.getMeasuredWidth() != i || behindSwipedItemLayout.getMeasuredHeight() != i2) {
                behindSwipedItemLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
            }
            behindSwipedItemLayout.layout(left, top, right, bottom);
            canvasUnder.save();
            canvasUnder.translate(left, top);
            behindSwipedItemLayout.draw(canvasUnder);
        } else {
            Integer behindSwipedItemBackgroundColor = (!isSecondarySwipeDirection || list.getBehindSwipedItemBackgroundSecondaryColor() == null || ((behindSwipedItemBackgroundSecondaryColor = list.getBehindSwipedItemBackgroundSecondaryColor()) != null && behindSwipedItemBackgroundSecondaryColor.intValue() == 0)) ? list.getBehindSwipedItemBackgroundColor() : list.getBehindSwipedItemBackgroundSecondaryColor();
            if (behindSwipedItemBackgroundColor != null && behindSwipedItemBackgroundColor.intValue() != 0) {
                canvasUnder.drawColor(behindSwipedItemBackgroundColor.intValue());
            }
            Drawable behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release = (!isSecondarySwipeDirection || list.getBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release() == null) ? list.getBehindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release() : list.getBehindSwipedItemIconSecondaryDrawable$drag_drop_swipe_recyclerview_release();
            if (behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release != null) {
                int intrinsicWidth = behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release.getIntrinsicWidth();
                int intrinsicHeight = behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release.getIntrinsicHeight();
                int i3 = ((right - left) / 2) + left;
                int i4 = ((bottom - top) / 2) + top;
                int i5 = intrinsicWidth / 2;
                int i6 = intrinsicHeight / 2;
                if (!list.getBehindSwipedItemCenterIcon()) {
                    int behindSwipedItemIconMargin = (int) list.getBehindSwipedItemIconMargin();
                    if (isSwipingHorizontally && isSecondarySwipeDirection) {
                        i3 = left + behindSwipedItemIconMargin + i5;
                    } else if (isSwipingHorizontally && !isSecondarySwipeDirection) {
                        i3 = (right - behindSwipedItemIconMargin) - i5;
                    } else if (!isSwipingHorizontally && isSecondarySwipeDirection) {
                        i4 = (bottom - behindSwipedItemIconMargin) - i6;
                    } else if (!isSwipingHorizontally && !isSecondarySwipeDirection) {
                        i4 = top + behindSwipedItemIconMargin + i6;
                    }
                }
                int i7 = i3 - i5;
                int i8 = i4 - i6;
                behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release.setBounds(i7, i8, intrinsicWidth + i7, intrinsicHeight + i8);
                behindSwipedItemIconDrawable$drag_drop_swipe_recyclerview_release.draw(canvasUnder);
            }
        }
        canvasUnder.restore();
    }

    private final Unit drawOnDragging(Canvas canvasOver, U viewHolder) {
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        if (dragDropSwipeRecyclerView == null) {
            return null;
        }
        if (canvasOver != null) {
            drawDividers$default(this, dragDropSwipeRecyclerView, canvasOver, viewHolder, null, null, null, null, null, 248, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drawOnSwiping(int offsetX, int offsetY, U viewHolder, Canvas canvasUnder, Canvas canvasOver) {
        boolean z;
        int left;
        int top;
        int right;
        int bottom;
        float fAbs;
        int i;
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        if (dragDropSwipeRecyclerView != null) {
            int swipeFlagsValue$drag_drop_swipe_recyclerview_release = getOrientation().getSwipeFlagsValue();
            DragDropSwipeRecyclerView.ListOrientation.DirectionFlag directionFlag = DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.RIGHT;
            if ((swipeFlagsValue$drag_drop_swipe_recyclerview_release & directionFlag.getValue()) != directionFlag.getValue()) {
                int swipeFlagsValue$drag_drop_swipe_recyclerview_release2 = getOrientation().getSwipeFlagsValue();
                DragDropSwipeRecyclerView.ListOrientation.DirectionFlag directionFlag2 = DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.LEFT;
                z = (swipeFlagsValue$drag_drop_swipe_recyclerview_release2 & directionFlag2.getValue()) == directionFlag2.getValue();
            }
            boolean z2 = (z && offsetX > 0) || (!z && offsetY < 0);
            View view = viewHolder.itemView;
            view.getClass();
            int left2 = view.getLeft();
            View view2 = viewHolder.itemView;
            view2.getClass();
            int translationX = left2 + ((int) view2.getTranslationX());
            View view3 = viewHolder.itemView;
            view3.getClass();
            int top2 = view3.getTop();
            View view4 = viewHolder.itemView;
            view4.getClass();
            int translationY = top2 + ((int) view4.getTranslationY());
            View view5 = viewHolder.itemView;
            view5.getClass();
            int right2 = view5.getRight();
            View view6 = viewHolder.itemView;
            view6.getClass();
            int translationX2 = right2 + ((int) view6.getTranslationX());
            View view7 = viewHolder.itemView;
            view7.getClass();
            int bottom2 = view7.getBottom();
            View view8 = viewHolder.itemView;
            view8.getClass();
            int translationY2 = bottom2 + ((int) view8.getTranslationY());
            if (z) {
                View view9 = viewHolder.itemView;
                view9.getClass();
                left = view9.getLeft();
            } else {
                left = translationX;
            }
            if (z) {
                top = translationY;
            } else {
                View view10 = viewHolder.itemView;
                view10.getClass();
                top = view10.getTop();
            }
            if (z) {
                View view11 = viewHolder.itemView;
                view11.getClass();
                right = view11.getRight();
            } else {
                right = translationX2;
            }
            if (z) {
                bottom = translationY2;
            } else {
                View view12 = viewHolder.itemView;
                view12.getClass();
                bottom = view12.getBottom();
            }
            if (dragDropSwipeRecyclerView.getReduceItemAlphaOnSwiping()) {
                if (z) {
                    fAbs = Math.abs(offsetX);
                    i = right - left;
                } else {
                    fAbs = Math.abs(offsetY);
                    i = bottom - top;
                }
                float f = 1.1f - (fAbs / i);
                if (f < 0.1f) {
                    f = 0.1f;
                }
                f = f <= 1.0f ? f : 1.0f;
                View view13 = viewHolder.itemView;
                view13.getClass();
                view13.setAlpha(f);
            }
            if (canvasUnder != null) {
                drawLayoutBehindOnSwiping(dragDropSwipeRecyclerView, canvasUnder, viewHolder, left, top, right, bottom, z, z2);
            } else if (canvasOver != null) {
                drawDividersOnSwiping(dragDropSwipeRecyclerView, canvasOver, viewHolder, translationX, translationY, translationX2, translationY2, f, left, top, right, bottom);
            }
        }
    }

    private final View getBehindSwipedItemLayout(T item, U viewHolder, int position) {
        Context context;
        Integer behindSwipedItemLayoutId = getBehindSwipedItemLayoutId(item, viewHolder, position);
        if (behindSwipedItemLayoutId != null) {
            int iIntValue = behindSwipedItemLayoutId.intValue();
            View behindSwipedItemLayout = viewHolder.getBehindSwipedItemLayout();
            if (behindSwipedItemLayout != null && behindSwipedItemLayout.getId() == iIntValue) {
                return viewHolder.getBehindSwipedItemLayout();
            }
            DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
            if (dragDropSwipeRecyclerView != null && (context = dragDropSwipeRecyclerView.getContext()) != null) {
                return LayoutInflater.from(context).inflate(iIntValue, (ViewGroup) null, false);
            }
        }
        return null;
    }

    private final View getBehindSwipedItemSecondaryLayout(T item, U viewHolder, int position) {
        Context context;
        Integer behindSwipedItemSecondaryLayoutId = getBehindSwipedItemSecondaryLayoutId(item, viewHolder, position);
        if (behindSwipedItemSecondaryLayoutId != null) {
            int iIntValue = behindSwipedItemSecondaryLayoutId.intValue();
            View behindSwipedItemSecondaryLayout = viewHolder.getBehindSwipedItemSecondaryLayout();
            if (behindSwipedItemSecondaryLayout != null && behindSwipedItemSecondaryLayout.getId() == iIntValue) {
                return viewHolder.getBehindSwipedItemSecondaryLayout();
            }
            DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
            if (dragDropSwipeRecyclerView != null && (context = dragDropSwipeRecyclerView.getContext()) != null) {
                return LayoutInflater.from(context).inflate(iIntValue, (ViewGroup) null, false);
            }
        }
        return null;
    }

    private final DragDropSwipeRecyclerView.ListOrientation getOrientation() {
        DragDropSwipeRecyclerView.ListOrientation orientation;
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        if (dragDropSwipeRecyclerView != null && (orientation = dragDropSwipeRecyclerView.getOrientation()) != null) {
            return orientation;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("The orientation of the DragDropSwipeRecyclerView is not defined.");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDragFinishedImpl(U viewHolder) {
        viewHolder.setBeingDragged$drag_drop_swipe_recyclerview_release(false);
        if (viewHolder.getAdapterPosition() == -1) {
            return;
        }
        onDragFinished(getDataSet().get(viewHolder.getAdapterPosition()), viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDragStartedImpl(U viewHolder) {
        viewHolder.setBeingDragged$drag_drop_swipe_recyclerview_release(true);
        if (viewHolder.getAdapterPosition() == -1) {
            return;
        }
        onDragStarted(getDataSet().get(viewHolder.getAdapterPosition()), viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onIsDraggingImpl(U viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled) {
        int adapterPosition = viewHolder.getAdapterPosition();
        T t = adapterPosition != -1 ? getDataSet().get(adapterPosition) : null;
        drawOnDragging(canvasOver, viewHolder);
        onIsDragging(t, viewHolder, offsetX, offsetY, canvasUnder, canvasOver, isUserControlled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onIsSwipingImpl(U viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled) {
        int adapterPosition = viewHolder.getAdapterPosition();
        T t = adapterPosition != -1 ? getDataSet().get(adapterPosition) : null;
        drawOnSwiping(offsetX, offsetY, viewHolder, canvasUnder, canvasOver);
        onIsSwiping(t, viewHolder, offsetX, offsetY, canvasUnder, canvasOver, isUserControlled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onListItemDragged(int previousPosition, int newPosition) {
        moveItem(previousPosition, newPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onListItemSwiped(int position) {
        removeItem(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwipeFinishedImpl(U viewHolder) {
        viewHolder.setBeingSwiped$drag_drop_swipe_recyclerview_release(false);
        onSwipeAnimationFinished(viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSwipeStartedImpl(U viewHolder) {
        viewHolder.setBeingSwiped$drag_drop_swipe_recyclerview_release(true);
        if (viewHolder.getAdapterPosition() == -1) {
            return;
        }
        onSwipeStarted(getDataSet().get(viewHolder.getAdapterPosition()), viewHolder);
    }

    private final void setItemDragAndDrop(View viewToDrag, final U holder) {
        viewToDrag.setOnTouchListener(new View.OnTouchListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter.setItemDragAndDrop.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Function0<Boolean> canBeDragged$drag_drop_swipe_recyclerview_release = holder.getCanBeDragged$drag_drop_swipe_recyclerview_release();
                if (canBeDragged$drag_drop_swipe_recyclerview_release == null || !canBeDragged$drag_drop_swipe_recyclerview_release.invoke().booleanValue() || motionEvent == null || motionEvent.getActionMasked() != 0) {
                    return false;
                }
                DragDropSwipeAdapter.this.itemTouchHelper.startDrag(holder);
                return true;
            }
        });
    }

    private final void setItemDragAndDropWithLongPress(final View viewToDrag, final U holder) {
        View view = holder.itemView;
        view.getClass();
        final GestureDetector gestureDetector = new GestureDetector(view.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$setItemDragAndDropWithLongPress$longPressGestureListener$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent event) {
                event.getClass();
                return (holder.getIsBeingSwiped() || holder.getIsBeingDragged()) ? false : true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                e.getClass();
                this.this$0.itemTouchHelper.startDrag(holder);
            }
        });
        gestureDetector.setIsLongpressEnabled(true);
        viewToDrag.setOnTouchListener(new View.OnTouchListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter.setItemDragAndDropWithLongPress.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                viewToDrag.onTouchEvent(motionEvent);
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    private final void setViewForDragging(T item, U holder, int position) {
        View viewToTouchToStartDraggingItem = getViewToTouchToStartDraggingItem(item, holder, position);
        if (viewToTouchToStartDraggingItem == null) {
            viewToTouchToStartDraggingItem = holder.itemView;
            viewToTouchToStartDraggingItem.getClass();
        }
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        if (dragDropSwipeRecyclerView == null || !dragDropSwipeRecyclerView.getLongPressToStartDragging()) {
            setItemDragAndDrop(viewToTouchToStartDraggingItem, holder);
        } else {
            setItemDragAndDropWithLongPress(viewToTouchToStartDraggingItem, holder);
        }
    }

    public boolean canBeDragged(T item, U viewHolder, int position) {
        viewHolder.getClass();
        return true;
    }

    public boolean canBeDroppedOver(T item, U viewHolder, int position) {
        viewHolder.getClass();
        return true;
    }

    public boolean canBeSwiped(T item, U viewHolder, int position) {
        viewHolder.getClass();
        return true;
    }

    public Integer getBehindSwipedItemLayoutId(T item, U viewHolder, int position) {
        viewHolder.getClass();
        return null;
    }

    public Integer getBehindSwipedItemSecondaryLayoutId(T item, U viewHolder, int position) {
        viewHolder.getClass();
        return null;
    }

    public final List<T> getDataSet() {
        return this.mutableDataSet;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mutableDataSet.size();
    }

    /* JADX INFO: renamed from: getSwipeAndDragHelper$drag_drop_swipe_recyclerview_release, reason: from getter */
    public final DragDropSwipeTouchHelper getSwipeAndDragHelper() {
        return this.swipeAndDragHelper;
    }

    public abstract U getViewHolder(View itemView);

    public abstract View getViewToTouchToStartDraggingItem(T item, U viewHolder, int position);

    public final void moveItem(int previousPosition, int newPosition) {
        T t = this.mutableDataSet.get(previousPosition);
        this.mutableDataSet.remove(previousPosition);
        this.mutableDataSet.add(newPosition, t);
        notifyItemMoved(previousPosition, newPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        recyclerView.getClass();
        super.onAttachedToRecyclerView(recyclerView);
        if (!(recyclerView instanceof DragDropSwipeRecyclerView)) {
            throw new TypeCastException("The recycler view must be an extension of DragDropSwipeRecyclerView.");
        }
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = (DragDropSwipeRecyclerView) recyclerView;
        this.recyclerView = dragDropSwipeRecyclerView;
        this.itemTouchHelper.attachToRecyclerView(recyclerView);
        this.swipeAndDragHelper.setRecyclerView$drag_drop_swipe_recyclerview_release(dragDropSwipeRecyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final U holder, final int position) {
        holder.getClass();
        final T t = this.mutableDataSet.get(position);
        Function0<Boolean> canBeDragged$drag_drop_swipe_recyclerview_release = holder.getCanBeDragged$drag_drop_swipe_recyclerview_release();
        if (canBeDragged$drag_drop_swipe_recyclerview_release == null) {
            canBeDragged$drag_drop_swipe_recyclerview_release = new Function0<Boolean>() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$onBindViewHolder$$inlined$apply$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    return this.this$0.canBeDragged(this.this$0.mutableDataSet.get(adapterPosition), holder, adapterPosition);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }
            };
        }
        holder.setCanBeDragged$drag_drop_swipe_recyclerview_release(canBeDragged$drag_drop_swipe_recyclerview_release);
        Function0<Boolean> canBeDroppedOver$drag_drop_swipe_recyclerview_release = holder.getCanBeDroppedOver$drag_drop_swipe_recyclerview_release();
        if (canBeDroppedOver$drag_drop_swipe_recyclerview_release == null) {
            canBeDroppedOver$drag_drop_swipe_recyclerview_release = new Function0<Boolean>() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$onBindViewHolder$$inlined$apply$lambda$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    return this.this$0.canBeDroppedOver(this.this$0.mutableDataSet.get(adapterPosition), holder, adapterPosition);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }
            };
        }
        holder.setCanBeDroppedOver$drag_drop_swipe_recyclerview_release(canBeDroppedOver$drag_drop_swipe_recyclerview_release);
        Function0<Boolean> canBeSwiped$drag_drop_swipe_recyclerview_release = holder.getCanBeSwiped$drag_drop_swipe_recyclerview_release();
        if (canBeSwiped$drag_drop_swipe_recyclerview_release == null) {
            canBeSwiped$drag_drop_swipe_recyclerview_release = new Function0<Boolean>() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter$onBindViewHolder$$inlined$apply$lambda$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    int adapterPosition = holder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    return this.this$0.canBeSwiped(this.this$0.mutableDataSet.get(adapterPosition), holder, adapterPosition);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }
            };
        }
        holder.setCanBeSwiped$drag_drop_swipe_recyclerview_release(canBeSwiped$drag_drop_swipe_recyclerview_release);
        View view = holder.itemView;
        view.getClass();
        view.setAlpha(1.0f);
        holder.setBehindSwipedItemLayout$drag_drop_swipe_recyclerview_release(getBehindSwipedItemLayout(t, holder, position));
        holder.setBehindSwipedItemSecondaryLayout$drag_drop_swipe_recyclerview_release(getBehindSwipedItemSecondaryLayout(t, holder, position));
        setViewForDragging(t, holder, position);
        onBindViewHolder(t, holder, position);
    }

    public abstract void onBindViewHolder(T item, U viewHolder, int position);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public U onCreateViewHolder(ViewGroup parent, int viewType) throws NoSuchFieldException {
        parent.getClass();
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = this.recyclerView;
        int itemLayoutId = dragDropSwipeRecyclerView != null ? dragDropSwipeRecyclerView.getItemLayoutId() : 0;
        if (itemLayoutId == 0) {
            throw new NoSuchFieldException("Unless your adapter implements onCreateViewHolder(), the attribute item_layout must be provided for the DragDropSwipeRecyclerView.");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, parent, false);
        if (viewInflate != null) {
            return (U) getViewHolder(viewInflate);
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        recyclerView.getClass();
        super.onDetachedFromRecyclerView(recyclerView);
        if (!(recyclerView instanceof DragDropSwipeRecyclerView)) {
            throw new TypeCastException("The recycler view must be an extension of DragDropSwipeRecyclerView.");
        }
        this.recyclerView = null;
        this.swipeAndDragHelper.setRecyclerView$drag_drop_swipe_recyclerview_release(null);
    }

    public void onDragFinished(T item, U viewHolder) {
        viewHolder.getClass();
    }

    public void onDragStarted(T item, U viewHolder) {
        viewHolder.getClass();
    }

    public void onIsDragging(T item, U viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled) {
        viewHolder.getClass();
    }

    public void onIsSwiping(T item, U viewHolder, int offsetX, int offsetY, Canvas canvasUnder, Canvas canvasOver, boolean isUserControlled) {
        viewHolder.getClass();
    }

    public void onSwipeAnimationFinished(U viewHolder) {
        viewHolder.getClass();
    }

    public void onSwipeStarted(T item, U viewHolder) {
        viewHolder.getClass();
    }

    public final void removeItem(int position) {
        this.mutableDataSet.remove(position);
        notifyItemRemoved(position);
    }

    public final void setInternalDragListener$drag_drop_swipe_recyclerview_release(OnItemDragListener<?> listener) {
        if (listener == null) {
            listener = (OnItemDragListener<T>) null;
        }
        this.dragListener = (OnItemDragListener<T>) listener;
    }

    public final void setInternalSwipeListener$drag_drop_swipe_recyclerview_release(OnItemSwipeListener<?> listener) {
    }
}
