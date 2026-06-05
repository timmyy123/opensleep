package kotlin.streams.jdk8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ljava/util/stream/Stream;", "", "toList", "(Ljava/util/stream/Stream;)Ljava/util/List;", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class StreamsKt {
    public static final <T> List<T> toList(Stream<T> stream) {
        stream.getClass();
        Object objCollect = stream.collect(Collectors.toList());
        objCollect.getClass();
        return (List) objCollect;
    }
}
