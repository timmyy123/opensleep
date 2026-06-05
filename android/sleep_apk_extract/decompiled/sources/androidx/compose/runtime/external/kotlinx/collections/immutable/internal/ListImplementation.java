package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.text.Regex$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\tJ'\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "<init>", "()V", "", "index", "size", "", "checkElementIndex$runtime", "(II)V", "checkElementIndex", "checkPositionIndex$runtime", "checkPositionIndex", "fromIndex", "toIndex", "checkRangeIndexes$runtime", "(III)V", "checkRangeIndexes", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListImplementation {
    public static final ListImplementation INSTANCE = new ListImplementation();

    private ListImplementation() {
    }

    public static final void checkElementIndex$runtime(int index, int size) {
        if (index < 0 || index >= size) {
            Events$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(index, size, "index: ", ", size: "));
        }
    }

    public static final void checkPositionIndex$runtime(int index, int size) {
        if (index < 0 || index > size) {
            Events$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(index, size, "index: ", ", size: "));
        }
    }

    public static final void checkRangeIndexes$runtime(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0 || toIndex > size) {
            Regex$$ExternalSyntheticBUOutline0.m(Fragment$$ExternalSyntheticOutline1.m(fromIndex, toIndex, "fromIndex: ", ", toIndex: ", ", size: "), size);
        } else {
            if (fromIndex <= toIndex) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(fromIndex, toIndex, "fromIndex: ", " > toIndex: "));
        }
    }
}
