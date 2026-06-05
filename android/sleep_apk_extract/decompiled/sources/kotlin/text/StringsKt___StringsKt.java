package kotlin.text;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0019\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\n\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a-\u0010\u0012\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00020\u00010\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a5\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aO\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u0004\b\u0000\u0010 *\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000!H\u0007¢\u0006\u0004\b\u001e\u0010#¨\u0006$"}, d2 = {"", "", "first", "(Ljava/lang/CharSequence;)C", "last", "single", "", "", "n", "drop", "(Ljava/lang/String;I)Ljava/lang/String;", "dropLast", "take", "reversed", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "C", ShareConstants.DESTINATION, "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "", "toSet", "(Ljava/lang/CharSequence;)Ljava/util/Set;", "size", "", "chunked", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "step", "", "partialWindows", "windowed", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "R", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function1;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public abstract class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static List<String> chunked(CharSequence charSequence, int i) {
        charSequence.getClass();
        return windowed(charSequence, i, i, true);
    }

    public static String drop(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(RangesKt.coerceAtMost(i, str.length()));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested character count ", " is less than zero."));
        return null;
    }

    public static String dropLast(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return take(str, RangesKt.coerceAtLeast(str.length() - i, 0));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested character count ", " is less than zero."));
        return null;
    }

    public static char first(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
        return (char) 0;
    }

    public static char last(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
        return (char) 0;
    }

    public static CharSequence reversed(CharSequence charSequence) {
        charSequence.getClass();
        return new StringBuilder(charSequence).reverse();
    }

    public static char single(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length();
        if (length == 0) {
            Events$$ExternalSyntheticBUOutline0.m$1("Char sequence is empty.");
            return (char) 0;
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Char sequence has more than one element.");
        return (char) 0;
    }

    public static String take(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(0, RangesKt.coerceAtMost(i, str.length()));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested character count ", " is less than zero."));
        return null;
    }

    public static final <C extends Collection<? super Character>> C toCollection(CharSequence charSequence, C c) {
        charSequence.getClass();
        c.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            c.add(Character.valueOf(charSequence.charAt(i)));
        }
        return c;
    }

    public static Set<Character> toSet(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length();
        return length != 0 ? length != 1 ? (Set) toCollection(charSequence, new LinkedHashSet(MapsKt.mapCapacity(RangesKt.coerceAtMost(charSequence.length(), 128)))) : SetsKt.setOf(Character.valueOf(charSequence.charAt(0))) : SetsKt.emptySet();
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z, Function1<? super CharSequence, ? extends R> function1) {
        charSequence.getClass();
        function1.getClass();
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && i3 < length) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(function1.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String windowed$lambda$0$StringsKt___StringsKt(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.toString();
    }

    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z) {
        charSequence.getClass();
        return windowed(charSequence, i, i2, z, new StringsKt__IndentKt$$ExternalSyntheticLambda0(1));
    }
}
