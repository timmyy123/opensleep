package com.urbandroid.sleep.media;

import com.urbandroid.sleep.media.InternalRingtones;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¨\u0006\u0004"}, d2 = {"internalRingtones", "", "Lcom/urbandroid/sleep/media/InternalRingtones$InternalRingtone;", "kotlin.jvm.PlatformType", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class MedialistKt {
    public static final List<InternalRingtones.InternalRingtone> internalRingtones() {
        List<InternalRingtones.InternalRingtone> ringtoneList = InternalRingtones.getRingtoneList();
        ringtoneList.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : ringtoneList) {
            if (((InternalRingtones.InternalRingtone) obj).titleRes != InternalRingtones.DEVICE_DEFAULT_RINGTONE.titleRes) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
