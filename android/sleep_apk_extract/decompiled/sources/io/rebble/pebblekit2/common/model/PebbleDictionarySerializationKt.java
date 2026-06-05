package io.rebble.pebblekit2.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\b\u001a\u00020\u0007*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004¨\u0006\t"}, d2 = {"mapFromBundle", "", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lio/rebble/pebblekit2/common/model/PebbleDictionary;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem$Companion;", "bundle", "Landroid/os/Bundle;", "toBundle", "common_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class PebbleDictionarySerializationKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Map<UInt, PebbleDictionaryItem> mapFromBundle(PebbleDictionaryItem.Companion companion, Bundle bundle) {
        companion.getClass();
        bundle.getClass();
        Set<String> setKeySet = bundle.keySet();
        setKeySet.getClass();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str = (String) obj;
            str.getClass();
            if (StringsKt__StringsJVMKt.endsWith$default(str, "_TYPE", false, 2, null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            str2.getClass();
            int uInt = UStringsKt.toUInt(StringsKt__StringsKt.substringBefore$default(str2, "_TYPE", (String) null, 2, (Object) null));
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(UInt.m2392toStringimpl(uInt), "_VALUE");
            String string = bundle.getString(str2);
            Pair pair = null;
            if (string != null) {
                switch (string.hashCode()) {
                    case -1808118735:
                        if (string.equals("String")) {
                            String string2 = bundle.getString(strM$1);
                            if (string2 != null) {
                                pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.Text(string2));
                            }
                        } else {
                            Logger loggerWithTag = Logger.INSTANCE.withTag("PebbleKit");
                            String tag = loggerWithTag.getTag();
                            Severity severity = Severity.Error;
                            if (loggerWithTag.getConfig().get_minSeverity().compareTo(severity) <= 0) {
                                if (string == null) {
                                    string = "null";
                                }
                                loggerWithTag.processLog(severity, tag, null, FileInsert$$ExternalSyntheticOutline0.m("Got unknown type ", string, " while decoding PebbleDictionary"));
                            }
                        }
                        break;
                    case -1790682369:
                        if (string.equals("UInt16")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.UInt16(UShort.m2433constructorimpl((short) bundle.getLong(strM$1)), null));
                            break;
                        }
                        break;
                    case -1790682311:
                        if (string.equals("UInt32")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.UInt32(UInt.m2389constructorimpl((int) bundle.getLong(strM$1)), null));
                            break;
                        }
                        break;
                    case -74930671:
                        if (string.equals("ByteArray")) {
                            byte[] byteArray = bundle.getByteArray(strM$1);
                            if (byteArray != null) {
                                pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.Bytes(byteArray));
                            }
                            break;
                        }
                        break;
                    case 2284105:
                        if (string.equals("Int8")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.Int8((byte) bundle.getLong(strM$1)));
                            break;
                        }
                        break;
                    case 70807092:
                        if (string.equals("Int16")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.Int16((short) bundle.getLong(strM$1)));
                            break;
                        }
                        break;
                    case 70807150:
                        if (string.equals("Int32")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.Int32((int) bundle.getLong(strM$1)));
                            break;
                        }
                        break;
                    case 80783390:
                        if (string.equals("UInt8")) {
                            pair = TuplesKt.to(UInt.m2388boximpl(uInt), new PebbleDictionaryItem.UInt8(UByte.m2367constructorimpl((byte) bundle.getLong(strM$1)), null));
                            break;
                        }
                        break;
                }
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return MapsKt.toMap(arrayList2);
    }

    public static final Bundle toBundle(Map<UInt, ? extends PebbleDictionaryItem> map) {
        map.getClass();
        Bundle bundle = new Bundle();
        for (Map.Entry<UInt, ? extends PebbleDictionaryItem> entry : map.entrySet()) {
            String string = Long.toString(((long) entry.getKey().getData()) & 4294967295L, 10);
            PebbleDictionaryItem value = entry.getValue();
            if (value instanceof PebbleDictionaryItem.Bytes) {
                bundle.putString(string + "_TYPE", "ByteArray");
                bundle.putByteArray(string + "_VALUE", ((PebbleDictionaryItem.Bytes) value).getValue());
            } else if (value instanceof PebbleDictionaryItem.Text) {
                bundle.putString(string + "_TYPE", "String");
                bundle.putString(string + "_VALUE", ((PebbleDictionaryItem.Text) value).getValue());
            } else if (value instanceof PebbleDictionaryItem.Int16) {
                bundle.putString(string + "_TYPE", "Int16");
                bundle.putLong(string + "_VALUE", ((PebbleDictionaryItem.Int16) value).getValue().shortValue());
            } else if (value instanceof PebbleDictionaryItem.Int32) {
                bundle.putString(string + "_TYPE", "Int32");
                bundle.putLong(string + "_VALUE", ((PebbleDictionaryItem.Int32) value).getValue().intValue());
            } else if (value instanceof PebbleDictionaryItem.Int8) {
                bundle.putString(string + "_TYPE", "Int8");
                bundle.putLong(string + "_VALUE", ((PebbleDictionaryItem.Int8) value).getValue().byteValue());
            } else if (value instanceof PebbleDictionaryItem.UInt16) {
                bundle.putString(string + "_TYPE", "UInt16");
                bundle.putLong(string + "_VALUE", ((long) ((PebbleDictionaryItem.UInt16) value).getValue()) & 65535);
            } else if (value instanceof PebbleDictionaryItem.UInt32) {
                bundle.putString(string + "_TYPE", "UInt32");
                bundle.putLong(string + "_VALUE", ((long) ((PebbleDictionaryItem.UInt32) value).getValue()) & 4294967295L);
            } else {
                if (!(value instanceof PebbleDictionaryItem.UInt8)) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                bundle.putString(string + "_TYPE", "UInt8");
                bundle.putLong(string + "_VALUE", ((long) ((PebbleDictionaryItem.UInt8) value).getValue()) & 255);
            }
        }
        return bundle;
    }
}
