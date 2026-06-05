package kotlinx.io;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0006\"\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "size", SpotifyService.OFFSET, "byteCount", "", "checkOffsetAndCount", "(JJJ)V", "startIndex", "endIndex", "checkBounds", "", "HEX_DIGIT_CHARS", "[C", "getHEX_DIGIT_CHARS", "()[C", "kotlinx-io-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class _UtilKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final void checkBounds(long j, long j2, long j3) {
        if (j2 >= 0 && j3 <= j) {
            if (j2 <= j3) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("startIndex (", ") > endIndex (", j2), j3, ')'));
        } else {
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("startIndex (", ") and endIndex (", j2);
            sbM.append(j3);
            sbM.append(") are not within the range [0..size(");
            sbM.append(j);
            sbM.append("))");
            throw new IndexOutOfBoundsException(sbM.toString());
        }
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if (j2 < 0 || j2 > j || j - j2 < j3 || j3 < 0) {
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("offset (", ") and byteCount (", j2);
            sbM.append(j3);
            sbM.append(") are not within the range [0..size(");
            sbM.append(j);
            sbM.append("))");
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }
}
