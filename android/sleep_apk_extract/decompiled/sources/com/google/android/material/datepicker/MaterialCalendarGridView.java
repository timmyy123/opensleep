package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$id;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.internal.ViewUtils;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;
    private MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R$id.cancel_button);
            setNextFocusRightId(R$id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendarGridView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
    }

    private void gainFocus(int i, Rect rect) {
        int iFindLastValidDayPosition = (i == 33 || i == 1) ? getAdapter().findLastValidDayPosition() : (i == 130 || i == 2) ? getAdapter().findFirstValidDayPosition() : -1;
        if (iFindLastValidDayPosition != -1) {
            setSelection(iFindLastValidDayPosition);
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private View getChildAtPosition(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    private boolean handleHorizontalNavigation(int i, boolean z) {
        MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;
        MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener2;
        int iFindNextValidDayPosition = z ? getAdapter().findNextValidDayPosition(i) : getAdapter().findPreviousValidDayPosition(i);
        if (iFindNextValidDayPosition != -1) {
            setSelection(iFindNextValidDayPosition);
            return true;
        }
        if (!z && (onMonthNavigationListener2 = this.onMonthNavigationListener) != null) {
            return onMonthNavigationListener2.onMonthNavigationPrevious();
        }
        if (!z || (onMonthNavigationListener = this.onMonthNavigationListener) == null) {
            return true;
        }
        return onMonthNavigationListener.onMonthNavigationNext();
    }

    private boolean handleTabNavigation(int i, KeyEvent keyEvent) {
        int iFindPreviousValidDayPosition = keyEvent.isShiftPressed() ? getAdapter().findPreviousValidDayPosition(i) : getAdapter().findNextValidDayPosition(i);
        if (iFindPreviousValidDayPosition == -1) {
            return false;
        }
        setSelection(iFindPreviousValidDayPosition);
        return true;
    }

    private static int horizontalMidPoint(View view) {
        return (view.getWidth() / 2) + view.getLeft();
    }

    private static boolean skipMonth(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    private boolean trySelectNearestValidDayPosition(int i) {
        int iFindNearestValidDayPositionInRow = getAdapter().findNearestValidDayPositionInRow(i);
        if (iFindNearestValidDayPositionInRow == -1) {
            return false;
        }
        setSelection(iFindNearestValidDayPositionInRow);
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    public boolean handleVerticalNavigationOnDisabledDay(int i, int i2) {
        MonthAdapter adapter = getAdapter();
        if (trySelectNearestValidDayPosition(i2)) {
            return true;
        }
        if (19 == i) {
            int numColumns = getNumColumns();
            while (true) {
                i2 -= numColumns;
                if (i2 < adapter.firstPositionInMonth()) {
                    return false;
                }
                if (trySelectNearestValidDayPosition(i2)) {
                    return true;
                }
                numColumns = getNumColumns();
            }
        } else {
            if (i != 20) {
                return false;
            }
            int numColumns2 = getNumColumns();
            while (true) {
                numColumns2 += i2;
                if (numColumns2 > adapter.lastPositionInMonth()) {
                    return false;
                }
                if (trySelectNearestValidDayPosition(numColumns2)) {
                    return true;
                }
                i2 = getNumColumns();
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int iDayToPosition;
        int iHorizontalMidPoint;
        int iDayToPosition2;
        int iHorizontalMidPoint2;
        int width;
        int i;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int iMax = Math.max(adapter.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int iMin = Math.min(adapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(iMax);
        Long item2 = adapter.getItem(iMin);
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            Long l = pair.first;
            if (l == null) {
                materialCalendarGridView = this;
            } else if (pair.second != null) {
                Long l2 = l;
                long jLongValue = l2.longValue();
                Long l3 = pair.second;
                long jLongValue2 = l3.longValue();
                if (!skipMonth(item, item2, l2, l3)) {
                    boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    if (jLongValue < item.longValue()) {
                        iHorizontalMidPoint = adapter.isFirstInRow(iMax) ? 0 : !zIsLayoutRtl ? materialCalendarGridView.getChildAtPosition(iMax - 1).getRight() : materialCalendarGridView.getChildAtPosition(iMax - 1).getLeft();
                        iDayToPosition = iMax;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(jLongValue);
                        iDayToPosition = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        iHorizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(iDayToPosition));
                    }
                    if (jLongValue2 > item2.longValue()) {
                        iHorizontalMidPoint2 = adapter.isLastInRow(iMin) ? materialCalendarGridView.getWidth() : !zIsLayoutRtl ? materialCalendarGridView.getChildAtPosition(iMin).getRight() : materialCalendarGridView.getChildAtPosition(iMin).getLeft();
                        iDayToPosition2 = iMin;
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(jLongValue2);
                        iDayToPosition2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        iHorizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(iDayToPosition2));
                    }
                    int itemId = (int) adapter.getItemId(iDayToPosition);
                    int i2 = iMax;
                    int i3 = iMin;
                    int itemId2 = (int) adapter.getItemId(iDayToPosition2);
                    while (itemId <= itemId2) {
                        int numColumns = materialCalendarGridView.getNumColumns() * itemId;
                        int numColumns2 = (materialCalendarGridView.getNumColumns() + numColumns) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        MonthAdapter monthAdapter = adapter;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (zIsLayoutRtl) {
                            int i4 = iDayToPosition2 > numColumns2 ? 0 : iHorizontalMidPoint2;
                            width = numColumns > iDayToPosition ? getWidth() : iHorizontalMidPoint;
                            i = i4;
                        } else {
                            i = numColumns > iDayToPosition ? 0 : iHorizontalMidPoint;
                            width = iDayToPosition2 > numColumns2 ? getWidth() : iHorizontalMidPoint2;
                        }
                        canvas.drawRect(i, top, width, bottom, calendarStyle.rangeFill);
                        itemId++;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                    }
                    materialCalendarGridView = this;
                    iMax = i2;
                    iMin = i3;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i == 21) {
            return handleHorizontalNavigation(selectedItemPosition, zIsLayoutRtl);
        }
        if (i == 22) {
            return handleHorizontalNavigation(selectedItemPosition, !zIsLayoutRtl);
        }
        if (i == 61) {
            return handleTabNavigation(selectedItemPosition, keyEvent);
        }
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        MonthAdapter adapter = getAdapter();
        int selectedItemPosition2 = getSelectedItemPosition();
        if (selectedItemPosition2 == -1 || adapter.isDayPositionValid(selectedItemPosition2)) {
            return true;
        }
        return handleVerticalNavigationOnDisabledDay(i, selectedItemPosition2);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.nestedScrollable) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
        } else {
            Home$$ExternalSyntheticBUOutline0.m("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()});
        }
    }

    public void setOnMonthNavigationListener(MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener) {
        this.onMonthNavigationListener = onMonthNavigationListener;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(Math.max(i, getAdapter().findFirstValidDayPosition()));
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
