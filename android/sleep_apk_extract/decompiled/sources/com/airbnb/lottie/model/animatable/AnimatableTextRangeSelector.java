package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.model.content.TextRangeUnits;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableTextRangeSelector {
    public final AnimatableIntegerValue end;
    public final AnimatableIntegerValue offset;
    public final AnimatableIntegerValue start;
    public final TextRangeUnits units;

    public AnimatableTextRangeSelector(AnimatableIntegerValue animatableIntegerValue, AnimatableIntegerValue animatableIntegerValue2, AnimatableIntegerValue animatableIntegerValue3, TextRangeUnits textRangeUnits) {
        this.start = animatableIntegerValue;
        this.end = animatableIntegerValue2;
        this.offset = animatableIntegerValue3;
        this.units = textRangeUnits;
    }
}
