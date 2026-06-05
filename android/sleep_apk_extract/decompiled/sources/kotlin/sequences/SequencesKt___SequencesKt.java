package kotlin.sequences;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001f\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0007\u0010\u0003\u001a+\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a7\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0011\u0010\u0010\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0012*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0015\u0010\u0010\u001a?\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0018\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0016j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0017¢\u0006\u0004\b\u0019\u0010\u001a\u001a9\u0010\u001e\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u001c*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b!\u0010\"\u001a#\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b$\u0010\"\u001a#\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b&\u0010'\u001aE\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010)0\fH\u0007¢\u0006\u0004\b+\u0010\u0010\u001aC\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\f¢\u0006\u0004\b,\u0010\u0010\u001a=\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b-\u0010\u0010\u001aC\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.¢\u0006\u0004\b/\u00100\u001aC\u00101\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010(*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\f¢\u0006\u0004\b1\u0010\u0010\u001a#\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b2\u0010\u0014\u001a=\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u00103*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b5\u0010\u0010\u001a\u001d\u00106\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b6\u00107\u001a.\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00108\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b9\u0010:\u001a4\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0086\u0002¢\u0006\u0004\b9\u0010<\u001a4\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b9\u0010=\u001a\u007f\u0010H\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010@*\u00060>j\u0002`?*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010A\u001a\u00028\u00012\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020B2\b\b\u0002\u0010F\u001a\u00020\b2\b\b\u0002\u0010G\u001a\u00020B2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020B\u0018\u00010\fH\u0007¢\u0006\u0004\bH\u0010I\u001ag\u0010K\u001a\u00020J\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010D\u001a\u00020B2\b\b\u0002\u0010E\u001a\u00020B2\b\b\u0002\u0010F\u001a\u00020\b2\b\b\u0002\u0010G\u001a\u00020B2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020B\u0018\u00010\f¢\u0006\u0004\bK\u0010L\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000)\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bM\u0010N¨\u0006O"}, d2 = {"T", "Lkotlin/sequences/Sequence;", "first", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "firstOrNull", "last", "single", "singleOrNull", "", "n", "drop", "(Lkotlin/sequences/Sequence;I)Lkotlin/sequences/Sequence;", "Lkotlin/Function1;", "", "predicate", "filter", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "filterNot", "", "filterNotNull", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "takeWhile", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Lkotlin/sequences/Sequence;", "", "C", ShareConstants.DESTINATION, "toCollection", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", "", "toList", "(Lkotlin/sequences/Sequence;)Ljava/util/List;", "", "toMutableList", "", "toSet", "(Lkotlin/sequences/Sequence;)Ljava/util/Set;", "R", "", "transform", "flatMapIterable", "flatMap", "map", "Lkotlin/Function2;", "mapIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "mapNotNull", "distinct", "K", "selector", "distinctBy", "count", "(Lkotlin/sequences/Sequence;)I", "element", "plus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "(Lkotlin/sequences/Sequence;Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", "", "separator", "prefix", "postfix", SpotifyService.LIMIT, "truncated", "joinTo", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "", "joinToString", "(Lkotlin/sequences/Sequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "asIterable", "(Lkotlin/sequences/Sequence;)Ljava/lang/Iterable;", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
public abstract class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$flatMap$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<R> invoke(Iterable<? extends R> iterable) {
            iterable.getClass();
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$flatMap$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Iterator<R> invoke(Sequence<? extends R> sequence) {
            sequence.getClass();
            return sequence.iterator();
        }
    }

    public static <T> Iterable<T> asIterable(Sequence<? extends T> sequence) {
        sequence.getClass();
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(sequence);
    }

    public static <T> int count(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    public static <T> Sequence<T> distinct(Sequence<? extends T> sequence) {
        sequence.getClass();
        return distinctBy(sequence, new SequencesKt__SequencesKt$$ExternalSyntheticLambda2(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object distinct$lambda$0$SequencesKt___SequencesKt(Object obj) {
        return obj;
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> sequence, Function1<? super T, ? extends K> function1) {
        sequence.getClass();
        function1.getClass();
        return new DistinctSequence(sequence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> drop(Sequence<? extends T> sequence, int i) {
        sequence.getClass();
        if (i >= 0) {
            return i == 0 ? sequence : sequence instanceof DropTakeSequence ? ((DropTakeSequence) sequence).drop(i) : new DropSequence(sequence, i);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested element count ", " is less than zero."));
        return null;
    }

    public static <T> Sequence<T> filter(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        sequence.getClass();
        function1.getClass();
        return new FilteringSequence(sequence, true, function1);
    }

    public static <T> Sequence<T> filterNot(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        sequence.getClass();
        function1.getClass();
        return new FilteringSequence(sequence, false, function1);
    }

    public static <T> Sequence<T> filterNotNull(Sequence<? extends T> sequence) {
        sequence.getClass();
        Sequence<T> sequenceFilterNot = filterNot(sequence, new SequencesKt__SequencesKt$$ExternalSyntheticLambda2(2));
        sequenceFilterNot.getClass();
        return sequenceFilterNot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean filterNotNull$lambda$0$SequencesKt___SequencesKt(Object obj) {
        return obj == null;
    }

    public static <T> T first(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Sequence is empty.");
        return null;
    }

    public static <T> T firstOrNull(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T, R> Sequence<R> flatMap(Sequence<? extends T> sequence, Function1<? super T, ? extends Sequence<? extends R>> function1) {
        sequence.getClass();
        function1.getClass();
        return new FlatteningSequence(sequence, function1, AnonymousClass2.INSTANCE);
    }

    public static <T, R> Sequence<R> flatMapIterable(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        sequence.getClass();
        function1.getClass();
        return new FlatteningSequence(sequence, function1, AnonymousClass1.INSTANCE);
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> sequence, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        sequence.getClass();
        a.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        a.append(charSequence2);
        int i2 = 0;
        for (T t : sequence) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.appendElement(a, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String joinToString(Sequence<? extends T> sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        sequence.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) joinTo(sequence, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Sequence sequence, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return joinToString(sequence, charSequence, charSequence2, charSequence3, i, charSequence5, function12);
    }

    public static <T> T last(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            Events$$ExternalSyntheticBUOutline0.m$1("Sequence is empty.");
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T, R> Sequence<R> map(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        sequence.getClass();
        function1.getClass();
        return new TransformingSequence(sequence, function1);
    }

    public static <T, R> Sequence<R> mapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends R> function2) {
        sequence.getClass();
        function2.getClass();
        return new TransformingIndexedSequence(sequence, function2);
    }

    public static <T, R> Sequence<R> mapNotNull(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        sequence.getClass();
        function1.getClass();
        return filterNotNull(new TransformingSequence(sequence, function1));
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, Iterable<? extends T> iterable) {
        sequence.getClass();
        iterable.getClass();
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf((Object[]) new Sequence[]{sequence, CollectionsKt.asSequence(iterable)}));
    }

    public static <T> T single(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            Events$$ExternalSyntheticBUOutline0.m$1("Sequence is empty.");
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Sequence has more than one element.");
        return null;
    }

    public static <T> T singleOrNull(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> Sequence<T> sortedWith(final Sequence<? extends T> sequence, final Comparator<? super T> comparator) {
        sequence.getClass();
        comparator.getClass();
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt.sortedWith.1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                List mutableList = SequencesKt___SequencesKt.toMutableList(sequence);
                CollectionsKt.sortWith(mutableList, comparator);
                return mutableList.iterator();
            }
        };
    }

    public static <T> Sequence<T> takeWhile(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        sequence.getClass();
        function1.getClass();
        return new TakeWhileSequence(sequence, function1);
    }

    public static <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> sequence, C c) {
        sequence.getClass();
        c.getClass();
        Iterator<? extends T> it = sequence.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static <T> List<T> toList(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return CollectionsKt.emptyList();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <T> List<T> toMutableList(Sequence<? extends T> sequence) {
        sequence.getClass();
        return (List) toCollection(sequence, new ArrayList());
    }

    public static <T> Set<T> toSet(Sequence<? extends T> sequence) {
        sequence.getClass();
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return SetsKt.emptySet();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return SetsKt.setOf(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, T t) {
        sequence.getClass();
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf((Object[]) new Sequence[]{sequence, SequencesKt__SequencesKt.sequenceOf(t)}));
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> sequence, Sequence<? extends T> sequence2) {
        sequence.getClass();
        sequence2.getClass();
        return SequencesKt__SequencesKt.flatten(SequencesKt__SequencesKt.sequenceOf((Object[]) new Sequence[]{sequence, sequence2}));
    }
}
