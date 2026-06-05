package com.ernestoyaquello.dragdropswiperecyclerview.listener;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\r"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemDragListener;", "T", "", "onItemDragged", "", "previousPosition", "", "newPosition", "item", "(IILjava/lang/Object;)V", "onItemDropped", "initialPosition", "finalPosition", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
public interface OnItemDragListener<T> {
    void onItemDragged(int previousPosition, int newPosition, T item);

    void onItemDropped(int initialPosition, int finalPosition, T item);
}
