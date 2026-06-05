package com.urbandroid.util;

import com.facebook.appevents.AppEventsConstants;
import java.util.BitSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"to10VectorString", "", "bitSet", "Ljava/util/BitSet;", "size", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CollectionUtilKt {
    public static final String to10VectorString(BitSet bitSet, int i) {
        bitSet.getClass();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(bitSet.get(i2) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        String string = stringBuffer.toString();
        string.getClass();
        return string;
    }

    public static /* synthetic */ String to10VectorString$default(BitSet bitSet, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = bitSet.length();
        }
        return to10VectorString(bitSet, i);
    }

    public static final String to10VectorString(BitSet bitSet) {
        bitSet.getClass();
        return to10VectorString$default(bitSet, 0, 2, null);
    }
}
