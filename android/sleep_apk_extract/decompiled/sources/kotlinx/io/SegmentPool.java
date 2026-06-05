package kotlinx.io;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u0012R\u0014\u0010%\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(¨\u0006*"}, d2 = {"Lkotlinx/io/SegmentPool;", "", "<init>", "()V", "Lkotlinx/io/Segment;", "take", "()Lkotlinx/io/Segment;", "takeL2", "segment", "", "recycle", "(Lkotlinx/io/Segment;)V", "recycleL2", "Lkotlinx/io/SegmentCopyTracker;", "tracker", "()Lkotlinx/io/SegmentCopyTracker;", "", "l1BucketId", "()I", "l2BucketId", "", "mask", "bucketId", "(J)I", "MAX_SIZE", "I", "getMAX_SIZE", "LOCK", "Lkotlinx/io/Segment;", "HASH_BUCKET_COUNT", "getHASH_BUCKET_COUNT$kotlinx_io_core", "HASH_BUCKET_COUNT_L2", "", "DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE", "Ljava/lang/String;", "SECOND_LEVEL_POOL_TOTAL_SIZE", "getSECOND_LEVEL_POOL_TOTAL_SIZE$kotlinx_io_core", "SECOND_LEVEL_POOL_BUCKET_SIZE", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "hashBuckets", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "hashBucketsL2", "kotlinx-io-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SegmentPool {
    private static final String DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE;
    private static final int HASH_BUCKET_COUNT;
    private static final int HASH_BUCKET_COUNT_L2;
    private static final int SECOND_LEVEL_POOL_BUCKET_SIZE;
    private static final int SECOND_LEVEL_POOL_TOTAL_SIZE;
    private static final AtomicReferenceArray<Segment> hashBuckets;
    private static final AtomicReferenceArray<Segment> hashBucketsL2;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    private static final Segment LOCK = Segment.INSTANCE.new$kotlinx_io_core(new byte[0], 0, 0, null, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(iHighestOneBit / 2, 1);
        HASH_BUCKET_COUNT_L2 = iCoerceAtLeast;
        String str = Intrinsics.areEqual(System.getProperty("java.vm.name"), "Dalvik") ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "4194304";
        DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE = str;
        String property = System.getProperty("kotlinx.io.pool.size.bytes", str);
        property.getClass();
        Integer intOrNull = StringsKt.toIntOrNull(property);
        int iCoerceAtLeast2 = intOrNull != null ? RangesKt.coerceAtLeast(intOrNull.intValue(), 0) : 0;
        SECOND_LEVEL_POOL_TOTAL_SIZE = iCoerceAtLeast2;
        SECOND_LEVEL_POOL_BUCKET_SIZE = RangesKt.coerceAtLeast(iCoerceAtLeast2 / iCoerceAtLeast, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        hashBuckets = new AtomicReferenceArray<>(iHighestOneBit);
        hashBucketsL2 = new AtomicReferenceArray<>(iCoerceAtLeast);
    }

    private SegmentPool() {
    }

    private final int bucketId(long mask) {
        return (int) (Thread.currentThread().getId() & mask);
    }

    private final int l1BucketId() {
        return bucketId(((long) HASH_BUCKET_COUNT) - 1);
    }

    private final int l2BucketId() {
        return bucketId(((long) HASH_BUCKET_COUNT_L2) - 1);
    }

    public static final void recycle(Segment segment) {
        segment.getClass();
        if (segment.getNext() != null || segment.getPrev() != null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            return;
        }
        SegmentCopyTracker copyTracker = segment.getCopyTracker();
        if (copyTracker != null && copyTracker.removeCopy()) {
            return;
        }
        AtomicReferenceArray<Segment> atomicReferenceArray = hashBuckets;
        int iL1BucketId = INSTANCE.l1BucketId();
        segment.setPos(0);
        segment.owner = true;
        while (true) {
            Segment segment2 = atomicReferenceArray.get(iL1BucketId);
            if (segment2 != LOCK) {
                int limit = segment2 != null ? segment2.getLimit() : 0;
                if (limit >= MAX_SIZE) {
                    if (SECOND_LEVEL_POOL_TOTAL_SIZE > 0) {
                        recycleL2(segment);
                        return;
                    }
                    return;
                } else {
                    segment.setNext(segment2);
                    segment.setLimit(limit + Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    while (!atomicReferenceArray.compareAndSet(iL1BucketId, segment2, segment)) {
                        if (atomicReferenceArray.get(iL1BucketId) != segment2) {
                            break;
                        }
                    }
                    return;
                }
            }
        }
    }

    private static final void recycleL2(Segment segment) {
        segment.setPos(0);
        segment.owner = true;
        int iL2BucketId = INSTANCE.l2BucketId();
        AtomicReferenceArray<Segment> atomicReferenceArray = hashBucketsL2;
        int i = 0;
        while (true) {
            Segment segment2 = atomicReferenceArray.get(iL2BucketId);
            if (segment2 != LOCK) {
                int limit = (segment2 != null ? segment2.getLimit() : 0) + Utility.DEFAULT_STREAM_BUFFER_SIZE;
                if (limit <= SECOND_LEVEL_POOL_BUCKET_SIZE) {
                    segment.setNext(segment2);
                    segment.setLimit(limit);
                    while (!atomicReferenceArray.compareAndSet(iL2BucketId, segment2, segment)) {
                        if (atomicReferenceArray.get(iL2BucketId) != segment2) {
                            break;
                        }
                    }
                    return;
                }
                int i2 = HASH_BUCKET_COUNT_L2;
                if (i >= i2) {
                    return;
                }
                i++;
                iL2BucketId = (iL2BucketId + 1) & (i2 - 1);
            }
        }
    }

    public static final Segment take() {
        Segment segment;
        Segment andSet;
        AtomicReferenceArray<Segment> atomicReferenceArray = hashBuckets;
        int iL1BucketId = INSTANCE.l1BucketId();
        do {
            segment = LOCK;
            andSet = atomicReferenceArray.getAndSet(iL1BucketId, segment);
        } while (Intrinsics.areEqual(andSet, segment));
        if (andSet == null) {
            atomicReferenceArray.set(iL1BucketId, null);
            return SECOND_LEVEL_POOL_TOTAL_SIZE > 0 ? takeL2() : Segment.INSTANCE.new$kotlinx_io_core();
        }
        atomicReferenceArray.set(iL1BucketId, andSet.getNext());
        andSet.setNext(null);
        andSet.setLimit(0);
        return andSet;
    }

    private static final Segment takeL2() {
        AtomicReferenceArray<Segment> atomicReferenceArray = hashBucketsL2;
        int iL2BucketId = INSTANCE.l2BucketId();
        int i = 0;
        while (true) {
            Segment segment = LOCK;
            Segment andSet = atomicReferenceArray.getAndSet(iL2BucketId, segment);
            if (!Intrinsics.areEqual(andSet, segment)) {
                if (andSet != null) {
                    atomicReferenceArray.set(iL2BucketId, andSet.getNext());
                    andSet.setNext(null);
                    andSet.setLimit(0);
                    return andSet;
                }
                atomicReferenceArray.set(iL2BucketId, null);
                int i2 = HASH_BUCKET_COUNT_L2;
                if (i >= i2) {
                    return Segment.INSTANCE.new$kotlinx_io_core();
                }
                iL2BucketId = (iL2BucketId + 1) & (i2 - 1);
                i++;
            }
        }
    }

    public static final SegmentCopyTracker tracker() {
        return new RefCountingCopyTracker();
    }
}
