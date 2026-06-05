package kotlin.text;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0010\u000e\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u000e\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0014\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u001a\u001a#\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u0019\u001a#\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001a\u001a#\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0019\u001a#\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001a\u001a#\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u001a#\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001a\u001a)\u0010!\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"\u001a\u0019\u0010$\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%\u001a\u0019\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010%\u001a!\u0010(\u001a\u00020\u0000*\u00020\u00002\u0006\u0010#\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)\u001a\u0019\u0010(\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b(\u0010%\u001a;\u0010.\u001a\u00020\u000f*\u00020\u00062\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u000fH\u0000¢\u0006\u0004\b.\u0010/\u001a#\u00101\u001a\u00020\u000f*\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b1\u00102\u001a#\u00103\u001a\u00020\u000f*\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b3\u00102\u001a#\u00101\u001a\u00020\u000f*\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b1\u00104\u001a#\u00103\u001a\u00020\u000f*\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b3\u00104\u001a-\u00105\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b5\u00106\u001a-\u00107\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b7\u00106\u001a=\u0010;\u001a\u00020\t*\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u000fH\u0002¢\u0006\u0004\b9\u0010:\u001aG\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0000\u0018\u00010>*\u00020\u00062\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00000<2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000fH\u0002¢\u0006\u0004\b?\u0010@\u001a-\u0010;\u001a\u00020\t*\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b;\u0010B\u001a-\u0010;\u001a\u00020\t*\u00020\u00062\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\b;\u0010D\u001a-\u0010E\u001a\u00020\t*\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\bE\u0010B\u001a-\u0010E\u001a\u00020\t*\u00020\u00062\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f¢\u0006\u0004\bE\u0010D\u001a&\u0010F\u001a\u00020\u000f*\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\bF\u00104\u001a&\u0010F\u001a\u00020\u000f*\u00020\u00062\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\bF\u00102\u001a?\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120I*\u00020\u00062\u0006\u0010G\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bJ\u0010K\u001aG\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120I*\u00020\u00062\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000M2\b\b\u0002\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bJ\u0010N\u001a\u0017\u0010P\u001a\u00020O2\u0006\u0010H\u001a\u00020\tH\u0000¢\u0006\u0004\bP\u0010Q\u001a?\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00062\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000M\"\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\t¢\u0006\u0004\bS\u0010T\u001a7\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00062\n\u0010G\u001a\u00020\u0001\"\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\t¢\u0006\u0004\bS\u0010U\u001a1\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\bV\u0010W\u001a\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00000I*\u00020\u0006¢\u0006\u0004\bX\u0010Y\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u0006¢\u0006\u0004\bZ\u0010[\u001a\u001f\u0010\\\u001a\u00020\u000f*\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\\\u0010]\u001a\u0013\u0010^\u001a\u00020\u000f*\u00020\u0000H\u0007¢\u0006\u0004\b^\u0010_\u001a\u0015\u0010`\u001a\u0004\u0018\u00010\u000f*\u00020\u0000H\u0007¢\u0006\u0004\b`\u0010a\"\u0015\u0010d\u001a\u00020\u0012*\u00020\u00068F¢\u0006\u0006\u001a\u0004\bb\u0010c\"\u0015\u0010g\u001a\u00020\t*\u00020\u00068F¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"}, d2 = {"", "", "", "chars", "trimEnd", "(Ljava/lang/String;[C)Ljava/lang/String;", "", "trim", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "length", "padChar", "padStart", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "(Ljava/lang/String;IC)Ljava/lang/String;", "", "isBlank", "(Ljava/lang/CharSequence;)Z", "Lkotlin/ranges/IntRange;", "range", "substring", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "substringBefore", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfter", "substringBeforeLast", "substringAfterLast", "startIndex", "endIndex", "replacement", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "prefix", "removePrefix", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "removeSuffix", "removeSurrounding", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "thisOffset", "other", "otherOffset", "ignoreCase", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "startsWith", "(Ljava/lang/CharSequence;CZ)Z", "endsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "lastIndexOfAny", "last", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "indexOf", "", "strings", "Lkotlin/Pair;", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;CIZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "lastIndexOf", "contains", "delimiters", SpotifyService.LIMIT, "Lkotlin/sequences/Sequence;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "rangesDelimitedBy", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "", "requireNonNegativeLimit", "(I)V", "", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "contentEqualsImpl", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "toBooleanStrict", "(Ljava/lang/String;)Z", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public abstract class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return charSequence2 instanceof String ? indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0 : indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt__StringsJVMKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        CharSequence charSequence2;
        Object next;
        boolean z3;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int iIndexOf$default = !z2 ? indexOf$default(charSequence, str, i, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(iIndexOf$default), str);
        }
        CharSequence charSequence3 = charSequence;
        IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence3.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i, getLastIndex(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                int i2 = first;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z3 = z;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z3 = z;
                        if (StringsKt__StringsJVMKt.regionMatches(str2, 0, (String) charSequence3, i2, str2.length(), z3)) {
                            break;
                        }
                        z = z3;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i2 == last) {
                            break;
                        }
                        i2 += step;
                        z = z3;
                    } else {
                        return TuplesKt.to(Integer.valueOf(i2), str3);
                    }
                }
            }
        } else {
            boolean z4 = z;
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                int i3 = first2;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z5 = z4;
                        charSequence2 = charSequence3;
                        z4 = z5;
                        if (regionMatchesImpl(str4, 0, charSequence2, i3, str4.length(), z5)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i3 == last2) {
                            break;
                        }
                        i3 += step2;
                        charSequence3 = charSequence2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(i3), str5);
                    }
                }
            }
        }
        return null;
    }

    public static IntRange getIndices(CharSequence charSequence) {
        charSequence.getClass();
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        charSequence.getClass();
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length())) : RangesKt.downTo(RangesKt.coerceAtMost(i, getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            int i3 = first;
            while (true) {
                String str = (String) charSequence2;
                boolean z3 = z;
                if (StringsKt__StringsJVMKt.regionMatches(str, 0, (String) charSequence, i3, str.length(), z3)) {
                    return i3;
                }
                if (i3 == last) {
                    return -1;
                }
                i3 += step;
                z = z3;
            }
        } else {
            boolean z4 = z;
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
                return -1;
            }
            int i4 = first2;
            while (true) {
                boolean z5 = z4;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z4 = z5;
                if (regionMatchesImpl(charSequence4, 0, charSequence3, i4, charSequence2.length(), z5)) {
                    return i4;
                }
                if (i4 == last2) {
                    return -1;
                }
                i4 += step2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(cArr), i);
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int lastIndex = getLastIndex(charSequence);
        if (iCoerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iCoerceAtLeast);
            for (char c : cArr) {
                if (CharsKt__CharKt.equals(c, cCharAt, z)) {
                    return iCoerceAtLeast;
                }
            }
            if (iCoerceAtLeast == lastIndex) {
                return -1;
            }
            iCoerceAtLeast++;
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    public static boolean isBlank(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        charSequence.getClass();
        str.getClass();
        return (z || !(charSequence instanceof String)) ? indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        charSequence.getClass();
        cArr.getClass();
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(cArr), i);
        }
        for (int iCoerceAtMost = RangesKt.coerceAtMost(i, getLastIndex(charSequence)); -1 < iCoerceAtMost; iCoerceAtMost--) {
            char cCharAt = charSequence.charAt(iCoerceAtMost);
            for (char c : cArr) {
                if (CharsKt__CharKt.equals(c, cCharAt, z)) {
                    return iCoerceAtMost;
                }
            }
        }
        return -1;
    }

    public static final Sequence<String> lineSequence(final CharSequence charSequence) {
        charSequence.getClass();
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<String> iterator() {
                return new LinesIterator(charSequence);
            }
        };
    }

    public static List<String> lines(CharSequence charSequence) {
        charSequence.getClass();
        return SequencesKt.toList(lineSequence(charSequence));
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        charSequence.getClass();
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, "Desired length ", " is less than zero."));
            return null;
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$$ExternalSyntheticLambda1(1, ArraysKt.asList(strArr), z));
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair rangesDelimitedBy$lambda$0$StringsKt__StringsKt(char[] cArr, boolean z, CharSequence charSequence, int i) {
        charSequence.getClass();
        int iIndexOfAny = indexOfAny(charSequence, cArr, i, z);
        if (iIndexOfAny < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(iIndexOfAny), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair rangesDelimitedBy$lambda$1$StringsKt__StringsKt(List list, boolean z, CharSequence charSequence, int i) {
        charSequence.getClass();
        Pair<Integer, String> pairFindAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, list, i, z, false);
        if (pairFindAnyOf$StringsKt__StringsKt != null) {
            return TuplesKt.to(pairFindAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(pairFindAnyOf$StringsKt__StringsKt.getSecond().length()));
        }
        return null;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) ? str.substring(charSequence.length()) : str;
    }

    public static String removeSuffix(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        str.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        return (str.length() >= charSequence2.length() + charSequence.length() && startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) && endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) ? str.substring(charSequence.length(), str.length() - charSequence2.length()) : str;
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i2 < i) {
            Regex$$ExternalSyntheticBUOutline0.m("End index (", i2, ") is less than start index (", i);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence, 0, i);
        sb.append(charSequence2);
        sb.append(charSequence, i2, charSequence.length());
        return sb;
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(i, "Limit must be non-negative, but was "));
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        charSequence.getClass();
        strArr.getClass();
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        requireNonNegativeLimit(i);
        int length = 0;
        int iIndexOf = indexOf(charSequence, str, 0, z);
        if (iIndexOf == -1 || i == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iIndexOf).toString());
            length = str.length() + iIndexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iIndexOf = indexOf(charSequence, str, length, z);
        } while (iIndexOf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        charSequence.getClass();
        charSequence2.getClass();
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null) : regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        charSequence.getClass();
        intRange.getClass();
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static String substringAfter(String str, String str2, String str3) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : str.substring(str2.length() + iIndexOf$default, str.length());
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : str.substring(str2.length() + iLastIndexOf$default, str.length());
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iIndexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str2 : str.substring(0, iIndexOf$default);
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    public static String substringBeforeLast(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str2 : str.substring(0, iLastIndexOf$default);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    public static boolean toBooleanStrict(String str) {
        str.getClass();
        if (Intrinsics.areEqual(str, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return false;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("The string doesn't represent a boolean value: ", str));
        return false;
    }

    public static Boolean toBooleanStrictOrNull(String str) {
        str.getClass();
        if (Intrinsics.areEqual(str, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static CharSequence trim(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zIsWhitespace) {
                    break;
                }
                length--;
            } else if (zIsWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static String trimEnd(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        cArr.getClass();
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(cArr, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$$ExternalSyntheticLambda1(0, cArr, z));
    }

    public static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    public static String substringBefore(String str, String str2, String str3) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        int iIndexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str3 : str.substring(0, iIndexOf$default);
    }

    public static String substringBeforeLast(String str, String str2, String str3) {
        Fragment$$ExternalSyntheticOutline1.m(str, str2, str3);
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str3 : str.substring(0, iLastIndexOf$default);
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static String substringAfter(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iIndexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iIndexOf$default == -1 ? str2 : str.substring(iIndexOf$default + 1, str.length());
    }

    public static String substringAfterLast(String str, char c, String str2) {
        str.getClass();
        str2.getClass();
        int iLastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return iLastIndexOf$default == -1 ? str2 : str.substring(iLastIndexOf$default + 1, str.length());
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        charSequence.getClass();
        return (z || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c, z);
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        charSequence.getClass();
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c, z);
    }

    public static String removeSurrounding(String str, CharSequence charSequence) {
        str.getClass();
        charSequence.getClass();
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static String padStart(String str, int i, char c) {
        str.getClass();
        return padStart((CharSequence) str, i, c).toString();
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        charSequence.getClass();
        cArr.getClass();
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableAsIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableAsIterable, 10));
        Iterator it = iterableAsIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }
}
