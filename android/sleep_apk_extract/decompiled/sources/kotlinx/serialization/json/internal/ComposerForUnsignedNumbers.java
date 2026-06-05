package kotlinx.serialization.json.internal;

import com.facebook.appevents.AppEventsConstants;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter internalJsonWriter, boolean z) {
        super(internalJsonWriter);
        internalJsonWriter.getClass();
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        boolean z = this.forceQuoting;
        int i = 63;
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        long jM2411constructorimpl = ULong.m2411constructorimpl(v);
        if (z) {
            if (jM2411constructorimpl != 0) {
                if (jM2411constructorimpl > 0) {
                    str = Long.toString(jM2411constructorimpl, 10);
                } else {
                    char[] cArr = new char[64];
                    long j = (jM2411constructorimpl >>> 1) / 5;
                    cArr[63] = Character.forDigit((int) (jM2411constructorimpl - (j * 10)), 10);
                    while (j > 0) {
                        i--;
                        cArr[i] = Character.forDigit((int) (j % 10), 10);
                        j /= 10;
                    }
                    str = new String(cArr, i, 64 - i);
                }
            }
            printQuoted(str);
            return;
        }
        if (jM2411constructorimpl != 0) {
            if (jM2411constructorimpl > 0) {
                str = Long.toString(jM2411constructorimpl, 10);
            } else {
                char[] cArr2 = new char[64];
                long j2 = (jM2411constructorimpl >>> 1) / 5;
                cArr2[63] = Character.forDigit((int) (jM2411constructorimpl - (j2 * 10)), 10);
                while (j2 > 0) {
                    i--;
                    cArr2[i] = Character.forDigit((int) (j2 % 10), 10);
                    j2 /= 10;
                }
                str = new String(cArr2, i, 64 - i);
            }
        }
        print(str);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        boolean z = this.forceQuoting;
        int iM2389constructorimpl = UInt.m2389constructorimpl(v);
        if (z) {
            printQuoted(Long.toString(((long) iM2389constructorimpl) & 4294967295L, 10));
        } else {
            print(Long.toString(((long) iM2389constructorimpl) & 4294967295L, 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        boolean z = this.forceQuoting;
        String strM2370toStringimpl = UByte.m2370toStringimpl(UByte.m2367constructorimpl(v));
        if (z) {
            printQuoted(strM2370toStringimpl);
        } else {
            print(strM2370toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        boolean z = this.forceQuoting;
        String strM2436toStringimpl = UShort.m2436toStringimpl(UShort.m2433constructorimpl(v));
        if (z) {
            printQuoted(strM2436toStringimpl);
        } else {
            print(strM2436toStringimpl);
        }
    }
}
