package com.urbandroid.sleep.smartwatch.phaser.actdata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.util.ScienceUtil;
import com.urbandroid.util.StringBufferPersister;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"aggregate", "", "", "result", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "persist", "", "log", "Lcom/urbandroid/util/StringBufferPersister;", "data", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ActivityDataUtilKt {
    public static final List<Float> aggregate(ActigraphyResult actigraphyResult) {
        actigraphyResult.getClass();
        float[] fArr = actigraphyResult.values;
        int length = fArr.length;
        if (length != 100) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(length, "Unexpected raw data size: "));
            return null;
        }
        float fMax = ScienceUtil.max(fArr, 0, 50);
        float fMax2 = ScienceUtil.max(actigraphyResult.values, 50, length);
        if (fMax == 0.0f) {
            fMax = 512.0f;
        }
        if (fMax2 == 0.0f) {
            fMax2 = 512.0f;
        }
        List<Float> listAsList = Arrays.asList(Float.valueOf(fMax), Float.valueOf(fMax2));
        listAsList.getClass();
        return listAsList;
    }

    public static final void persist(StringBufferPersister stringBufferPersister, ActigraphyResult actigraphyResult) {
        actigraphyResult.getClass();
        if (stringBufferPersister != null) {
            float[] fArr = actigraphyResult.values;
            fArr.getClass();
            for (float f : fArr) {
                stringBufferPersister.update(f + "\n");
            }
        }
    }
}
