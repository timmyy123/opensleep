package com.ernestoyaquello.dragdropswiperecyclerview.listener;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener;", "T", "", "SwipeDirection", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 4, 0})
public interface OnItemSwipeListener<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ernestoyaquello/dragdropswiperecyclerview/listener/OnItemSwipeListener$SwipeDirection;", "", "(Ljava/lang/String;I)V", "RIGHT_TO_LEFT", "LEFT_TO_RIGHT", "DOWN_TO_UP", "UP_TO_DOWN", "drag-drop-swipe-recyclerview_release"}, k = 1, mv = {1, 1, 16})
    public enum SwipeDirection {
        RIGHT_TO_LEFT,
        LEFT_TO_RIGHT,
        DOWN_TO_UP,
        UP_TO_DOWN
    }
}
