package kotlin.collections;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.share.internal.ShareConstants;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kaaes.spotify.webapi.android.SpotifyService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0013\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001a*\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u000e\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0011\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a!\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0017\u0010\u0016\u001a)\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\f2\u0006\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u0002\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001f\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010 \u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010!\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\"\u001a\u001f\u0010#\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b#\u0010\u0016\u001a\u0011\u0010#\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b#\u0010$\u001a'\u0010%\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b%\u0010\u001d\u001a\u0019\u0010%\u001a\u00020\r*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b%\u0010\u001e\u001a\u0019\u0010%\u001a\u00020\r*\u00020\f2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b%\u0010 \u001a!\u0010&\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b&\u0010\u0016\u001a\u0013\u0010&\u001a\u0004\u0018\u00010(*\u00020'¢\u0006\u0004\b&\u0010)\u001a\u001f\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b*\u0010\u0016\u001a\u0011\u0010*\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b,\u0010\u0016\u001a\u001f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070.*\u00020\u00062\u0006\u0010-\u001a\u00020\r¢\u0006\u0004\b/\u00100\u001a+\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000.\"\b\b\u0000\u0010\u0000*\u000201*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001¢\u0006\u0004\b2\u00103\u001aA\u00107\u001a\u00028\u0000\"\u0010\b\u0000\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u000104\"\b\b\u0001\u0010\u0000*\u000201*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00010\u00012\u0006\u00106\u001a\u00028\u0000H\u0007¢\u0006\u0004\b7\u00108\u001a\u0019\u0010;\u001a\u00020\u0006*\u00020\u00062\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<\u001a\u0019\u0010;\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010=\u001a\u0019\u0010;\u001a\u00020>*\u00020>2\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010?\u001a\u001f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070.*\u00020\u00062\u0006\u0010-\u001a\u00020\r¢\u0006\u0004\b@\u00100\u001a\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020A0.*\u00020>¢\u0006\u0004\bB\u0010C\u001aC\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010F\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`E¢\u0006\u0004\bG\u0010H\u001aA\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000.\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010F\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000Dj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`E¢\u0006\u0004\bI\u0010J\u001a;\u0010K\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u00028\u000004*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u00106\u001a\u00028\u0001H\u0007¢\u0006\u0004\bK\u00108\u001a/\u0010N\u001a\u0012\u0012\u0004\u0012\u00028\u00000Lj\b\u0012\u0004\u0012\u00028\u0000`M\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bN\u0010O\u001a%\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000.\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bP\u00103\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070.*\u00020\u0006¢\u0006\u0004\bP\u0010Q\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0.*\u00020\t¢\u0006\u0004\bP\u0010R\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0.*\u00020\f¢\u0006\u0004\bP\u0010S\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00100.*\u00020\u000f¢\u0006\u0004\bP\u0010T\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020A0.*\u00020>¢\u0006\u0004\bP\u0010C\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020(0.*\u00020'¢\u0006\u0004\bP\u0010U\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030.*\u00020V¢\u0006\u0004\bP\u0010W\u001a\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00130.*\u00020\u0012¢\u0006\u0004\bP\u0010X\u001a%\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000Y\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\bZ\u00103\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070Y*\u00020\u0006¢\u0006\u0004\bZ\u0010Q\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\n0Y*\u00020\t¢\u0006\u0004\bZ\u0010R\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\r0Y*\u00020\f¢\u0006\u0004\bZ\u0010S\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00100Y*\u00020\u000f¢\u0006\u0004\bZ\u0010T\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020A0Y*\u00020>¢\u0006\u0004\bZ\u0010C\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020(0Y*\u00020'¢\u0006\u0004\bZ\u0010U\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00030Y*\u00020V¢\u0006\u0004\bZ\u0010W\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00130Y*\u00020\u0012¢\u0006\u0004\bZ\u0010X\u001a%\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\\\u0010]\u001a+\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000_0^\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b`\u0010a\u001aJ\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010d0.\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010b*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\be\u0010f\u001a\u0081\u0001\u0010s\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010i*\u00060gj\u0002`h*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010j\u001a\u00028\u00012\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020k\u0018\u00010qH\u0007¢\u0006\u0004\bs\u0010t\u001as\u0010s\u001a\u00028\u0000\"\f\b\u0000\u0010i*\u00060gj\u0002`h*\u00020\u00062\u0006\u0010j\u001a\u00028\u00002\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020k\u0018\u00010qH\u0007¢\u0006\u0004\bs\u0010u\u001as\u0010s\u001a\u00028\u0000\"\f\b\u0000\u0010i*\u00060gj\u0002`h*\u00020\u000f2\u0006\u0010j\u001a\u00028\u00002\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020k\u0018\u00010qH\u0007¢\u0006\u0004\bs\u0010v\u001as\u0010s\u001a\u00028\u0000\"\f\b\u0000\u0010i*\u00060gj\u0002`h*\u00020>2\u0006\u0010j\u001a\u00028\u00002\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020k\u0018\u00010qH\u0007¢\u0006\u0004\bs\u0010w\u001ai\u0010y\u001a\u00020x\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020k\u0018\u00010q¢\u0006\u0004\by\u0010z\u001a[\u0010y\u001a\u00020x*\u00020\u00062\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020k\u0018\u00010q¢\u0006\u0004\by\u0010{\u001a[\u0010y\u001a\u00020x*\u00020\u000f2\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020k\u0018\u00010q¢\u0006\u0004\by\u0010|\u001a[\u0010y\u001a\u00020x*\u00020>2\b\b\u0002\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020k2\b\b\u0002\u0010n\u001a\u00020k2\b\b\u0002\u0010o\u001a\u00020\r2\b\b\u0002\u0010p\u001a\u00020k2\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020k\u0018\u00010q¢\u0006\u0004\by\u0010}\u001a%\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000^\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b~\u0010a\u001a(\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u007f\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\"&\u0010\u0084\u0001\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00018F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0018\u0010\u0084\u0001\u001a\u00020\r*\u00020\u00068F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0085\u0001\"\u0018\u0010\u0084\u0001\u001a\u00020\r*\u00020\f8F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0086\u0001\"\u0018\u0010\u0084\u0001\u001a\u00020\r*\u00020\u000f8F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0087\u0001¨\u0006\u0088\u0001"}, d2 = {"T", "", "element", "", "contains", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "", "", "([BB)Z", "", "", "([SS)Z", "", "", "([II)Z", "", "", "([JJ)Z", "", "", "([CC)Z", "first", "([Ljava/lang/Object;)Ljava/lang/Object;", "firstOrNull", "index", "getOrNull", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([II)Ljava/lang/Integer;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "([BB)I", "([SS)I", "([II)I", "([JJ)I", "([CC)I", "last", "([B)B", "lastIndexOf", "lastOrNull", "", "", "([D)Ljava/lang/Double;", "single", "([C)C", "singleOrNull", "n", "", "drop", "([BI)Ljava/util/List;", "", "filterNotNull", "([Ljava/lang/Object;)Ljava/util/List;", "", "C", ShareConstants.DESTINATION, "filterNotNullTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "Lkotlin/ranges/IntRange;", "indices", "sliceArray", "([BLkotlin/ranges/IntRange;)[B", "([JLkotlin/ranges/IntRange;)[J", "", "([FLkotlin/ranges/IntRange;)[F", "takeLast", "", "reversed", "([F)Ljava/util/List;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "toCollection", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toHashSet", "([Ljava/lang/Object;)Ljava/util/HashSet;", "toList", "([B)Ljava/util/List;", "([S)Ljava/util/List;", "([I)Ljava/util/List;", "([J)Ljava/util/List;", "([D)Ljava/util/List;", "", "([Z)Ljava/util/List;", "([C)Ljava/util/List;", "", "toMutableList", "", "toSet", "([Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/collections/IndexedValue;", "withIndex", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "R", "other", "Lkotlin/Pair;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "buffer", "", "separator", "prefix", "postfix", SpotifyService.LIMIT, "truncated", "Lkotlin/Function1;", "transform", "joinTo", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([JLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([FLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "", "joinToString", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "([BLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "([JLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "([FLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "asIterable", "Lkotlin/sequences/Sequence;", "asSequence", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "getLastIndex", "([Ljava/lang/Object;)I", "lastIndex", "([B)I", "([I)I", "([J)I", "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
public abstract class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static <T> Iterable<T> asIterable(T[] tArr) {
        tArr.getClass();
        return tArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    public static <T> Sequence<T> asSequence(final T[] tArr) {
        tArr.getClass();
        return tArr.length == 0 ? SequencesKt.emptySequence() : new Sequence<T>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(tArr);
            }
        };
    }

    public static <T> boolean contains(T[] tArr, T t) {
        tArr.getClass();
        return indexOf(tArr, t) >= 0;
    }

    public static List<Byte> drop(byte[] bArr, int i) {
        bArr.getClass();
        if (i >= 0) {
            return takeLast(bArr, RangesKt.coerceAtLeast(bArr.length - i, 0));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested element count ", " is less than zero."));
        return null;
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        tArr.getClass();
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C c) {
        tArr.getClass();
        c.getClass();
        for (T t : tArr) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    public static <T> T first(T[] tArr) {
        tArr.getClass();
        if (tArr.length != 0) {
            return tArr[0];
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
        return null;
    }

    public static <T> T firstOrNull(T[] tArr) {
        tArr.getClass();
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static <T> int getLastIndex(T[] tArr) {
        tArr.getClass();
        return tArr.length - 1;
    }

    public static Integer getOrNull(int[] iArr, int i) {
        iArr.getClass();
        if (i < 0 || i >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static <T> int indexOf(T[] tArr, T t) {
        tArr.getClass();
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (Intrinsics.areEqual(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) throws IOException {
        bArr.getClass();
        a.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        a.append(charSequence2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append(function1.invoke(Byte.valueOf(b)));
            } else {
                a.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String joinToString(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        tArr.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) joinTo(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(objArr, charSequence, charSequence2, charSequence3, i, charSequence5, function12);
    }

    public static <T> T last(T[] tArr) {
        tArr.getClass();
        if (tArr.length != 0) {
            return tArr[getLastIndex(tArr)];
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
        return null;
    }

    public static <T> int lastIndexOf(T[] tArr, T t) {
        tArr.getClass();
        if (t == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (Intrinsics.areEqual(t, tArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    public static Double lastOrNull(double[] dArr) {
        dArr.getClass();
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    public static List<Float> reversed(float[] fArr) {
        fArr.getClass();
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static <T> T single(T[] tArr) {
        tArr.getClass();
        int length = tArr.length;
        if (length == 0) {
            Events$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
            return null;
        }
        if (length == 1) {
            return tArr[0];
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Array has more than one element.");
        return null;
    }

    public static <T> T singleOrNull(T[] tArr) {
        tArr.getClass();
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static byte[] sliceArray(byte[] bArr, IntRange intRange) {
        bArr.getClass();
        intRange.getClass();
        return intRange.isEmpty() ? new byte[0] : ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        tArr.getClass();
        comparator.getClass();
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        tArr.getClass();
        comparator.getClass();
        return ArraysKt___ArraysJvmKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static final List<Byte> takeLast(byte[] bArr, int i) {
        bArr.getClass();
        if (i < 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) Fragment$$ExternalSyntheticOutline1.m(i, "Requested element count ", " is less than zero."));
            return null;
        }
        if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = bArr.length;
        if (i >= length) {
            return toList(bArr);
        }
        if (i == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(Byte.valueOf(bArr[i2]));
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C c) {
        tArr.getClass();
        c.getClass();
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static <T> HashSet<T> toHashSet(T[] tArr) {
        tArr.getClass();
        return (HashSet) toCollection(tArr, new HashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length)));
    }

    public static <T> List<T> toList(T[] tArr) {
        tArr.getClass();
        int length = tArr.length;
        return length != 0 ? length != 1 ? ArraysKt___ArraysJvmKt.asList(Arrays.copyOf(tArr, tArr.length)) : CollectionsKt__CollectionsJVMKt.listOf(tArr[0]) : CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        bArr.getClass();
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static <T> Set<T> toSet(T[] tArr) {
        tArr.getClass();
        int length = tArr.length;
        return length != 0 ? length != 1 ? (Set) toCollection(tArr, new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(tArr.length))) : SetsKt__SetsJVMKt.setOf(tArr[0]) : SetsKt__SetsKt.emptySet();
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(T[] tArr) {
        tArr.getClass();
        return new IndexingIterable(new ArraysKt___ArraysKt$$ExternalSyntheticLambda0(tArr, 0));
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, R[] rArr) {
        tArr.getClass();
        rArr.getClass();
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(TuplesKt.to(tArr[i], rArr[i]));
        }
        return arrayList;
    }

    public static final int getLastIndex(byte[] bArr) {
        bArr.getClass();
        return bArr.length - 1;
    }

    public static int getLastIndex(int[] iArr) {
        iArr.getClass();
        return iArr.length - 1;
    }

    public static int getLastIndex(long[] jArr) {
        jArr.getClass();
        return jArr.length - 1;
    }

    public static boolean contains(byte[] bArr, byte b) {
        bArr.getClass();
        return indexOf(bArr, b) >= 0;
    }

    public static boolean contains(short[] sArr, short s) {
        sArr.getClass();
        return indexOf(sArr, s) >= 0;
    }

    public static boolean contains(int[] iArr, int i) {
        iArr.getClass();
        return indexOf(iArr, i) >= 0;
    }

    public static boolean contains(long[] jArr, long j) {
        jArr.getClass();
        return indexOf(jArr, j) >= 0;
    }

    public static boolean contains(char[] cArr, char c) {
        cArr.getClass();
        return indexOf(cArr, c) >= 0;
    }

    public static <T> T getOrNull(T[] tArr, int i) {
        tArr.getClass();
        if (i < 0 || i >= tArr.length) {
            return null;
        }
        return tArr[i];
    }

    public static <T> T lastOrNull(T[] tArr) {
        tArr.getClass();
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static byte last(byte[] bArr) {
        bArr.getClass();
        if (bArr.length != 0) {
            return bArr[getLastIndex(bArr)];
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
        return (byte) 0;
    }

    public static char single(char[] cArr) {
        cArr.getClass();
        int length = cArr.length;
        if (length == 0) {
            Events$$ExternalSyntheticBUOutline0.m$1("Array is empty.");
            return (char) 0;
        }
        if (length == 1) {
            return cArr[0];
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Array has more than one element.");
        return (char) 0;
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        tArr.getClass();
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection$default(tArr, false, 1, null));
    }

    public static final List<Short> toMutableList(short[] sArr) {
        sArr.getClass();
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    public static final List<Integer> toMutableList(int[] iArr) {
        iArr.getClass();
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static final List<Long> toMutableList(long[] jArr) {
        jArr.getClass();
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List<Byte> toList(byte[] bArr) {
        bArr.getClass();
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
    }

    public static final List<Float> toMutableList(float[] fArr) {
        fArr.getClass();
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static final int indexOf(byte[] bArr, byte b) {
        bArr.getClass();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final List<Double> toMutableList(double[] dArr) {
        dArr.getClass();
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final int indexOf(short[] sArr, short s) {
        sArr.getClass();
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static List<Short> toList(short[] sArr) {
        sArr.getClass();
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        zArr.getClass();
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final int indexOf(int[] iArr, int i) {
        iArr.getClass();
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final String joinToString(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Byte, ? extends CharSequence> function1) {
        bArr.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) joinTo(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static final String joinToString(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Long, ? extends CharSequence> function1) {
        jArr.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) joinTo(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static long[] sliceArray(long[] jArr, IntRange intRange) {
        jArr.getClass();
        intRange.getClass();
        return intRange.isEmpty() ? new long[0] : ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final List<Character> toMutableList(char[] cArr) {
        cArr.getClass();
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static final int indexOf(long[] jArr, long j) {
        jArr.getClass();
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final String joinToString(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Float, ? extends CharSequence> function1) {
        fArr.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return ((StringBuilder) joinTo(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
    }

    public static List<Integer> toList(int[] iArr) {
        iArr.getClass();
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
    }

    public static float[] sliceArray(float[] fArr, IntRange intRange) {
        fArr.getClass();
        intRange.getClass();
        return intRange.isEmpty() ? new float[0] : ArraysKt___ArraysJvmKt.copyOfRange(fArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    public static final int indexOf(char[] cArr, char c) {
        cArr.getClass();
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(byte[] bArr, byte b) {
        bArr.getClass();
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static List<Long> toList(long[] jArr) {
        jArr.getClass();
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
    }

    public static final int lastIndexOf(int[] iArr, int i) {
        iArr.getClass();
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(bArr, charSequence, charSequence2, charSequence3, i, charSequence5, (Function1<? super Byte, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(jArr, charSequence, charSequence2, charSequence3, i, charSequence5, (Function1<? super Long, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
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
        return joinToString(fArr, charSequence, charSequence2, charSequence3, i, charSequence5, (Function1<? super Float, ? extends CharSequence>) function12);
    }

    public static List<Float> toList(float[] fArr) {
        fArr.getClass();
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
    }

    public static List<Double> toList(double[] dArr) {
        dArr.getClass();
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
    }

    public static List<Boolean> toList(boolean[] zArr) {
        zArr.getClass();
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
    }

    public static List<Character> toList(char[] cArr) {
        cArr.getClass();
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        tArr.getClass();
        a.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        a.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
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

    public static final <A extends Appendable> A joinTo(long[] jArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Long, ? extends CharSequence> function1) throws IOException {
        jArr.getClass();
        a.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        a.append(charSequence2);
        int i2 = 0;
        for (long j : jArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append(function1.invoke(Long.valueOf(j)));
            } else {
                a.append(String.valueOf(j));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <A extends Appendable> A joinTo(float[] fArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Float, ? extends CharSequence> function1) throws IOException {
        fArr.getClass();
        a.getClass();
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        a.append(charSequence2);
        int i2 = 0;
        for (float f : fArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append(function1.invoke(Float.valueOf(f)));
            } else {
                a.append(String.valueOf(f));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }
}
