package com.ernestoyaquello.dragdropswiperecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnListScrollListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000f\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/ScrollAwareRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "listener", "", "addOnScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "com/ernestoyaquello/dragdropswiperecyclerview/ScrollAwareRecyclerView$internalListScrollListener$1", "internalListScrollListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/ScrollAwareRecyclerView$internalListScrollListener$1;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnListScrollListener;", "scrollListener", "Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnListScrollListener;", "getScrollListener", "()Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnListScrollListener;", "setScrollListener", "(Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnListScrollListener;)V", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public abstract class ScrollAwareRecyclerView extends RecyclerView {
    private final ScrollAwareRecyclerView$internalListScrollListener$1 internalListScrollListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.ernestoyaquello.dragdropswiperecyclerview.ScrollAwareRecyclerView$internalListScrollListener$1] */
    public ScrollAwareRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        ?? r1 = new RecyclerView.OnScrollListener() { // from class: com.ernestoyaquello.dragdropswiperecyclerview.ScrollAwareRecyclerView$internalListScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                recyclerView.getClass();
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    this.this$0.getScrollListener();
                } else if (newState == 1) {
                    this.this$0.getScrollListener();
                } else {
                    if (newState != 2) {
                        return;
                    }
                    this.this$0.getScrollListener();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                recyclerView.getClass();
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    this.this$0.getScrollListener();
                    return;
                }
                if (dy < 0) {
                    this.this$0.getScrollListener();
                } else if (dx > 0) {
                    this.this$0.getScrollListener();
                } else if (dx < 0) {
                    this.this$0.getScrollListener();
                }
            }
        };
        this.internalListScrollListener = r1;
        super.addOnScrollListener(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener listener) {
        listener.getClass();
        throw new UnsupportedOperationException("Only the property scrollListener can be used to add a scroll listener here.");
    }

    public final OnListScrollListener getScrollListener() {
        return null;
    }

    public final void setScrollListener(OnListScrollListener onListScrollListener) {
    }
}
