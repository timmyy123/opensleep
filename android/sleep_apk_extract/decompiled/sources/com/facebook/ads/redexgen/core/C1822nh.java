package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public class C1822nh<K, V> extends AbstractMap<K, V> implements Serializable {
    public static byte[] A09;
    public static String[] A0A = {"wSivjbfpZ5vyyNQvPGO2", "feAeK30V825ODXthr2nXiZ2IyDp7foTM", "DkUlp4YVWOkxqgis7dBpeo68CZmBo3n0", "aa93WRLI7l2jdXj6upMcNohuPuXZSHnj", "yd6MpWWB34WJL2xwsTp1Hrf9QPnPIJjU", "QxuCDFa1e2lEwJ6Nl0AGtIVp0Ykbd3", "6Mqvrbexx8eO9W", "SxE34IM9tKvZCcEi8I123n5xI40gl8"};
    public static final Object A0B;

    @CheckForNull
    public transient int[] A00;

    @CheckForNull
    public transient Object[] A01;

    @CheckForNull
    public transient Object[] A02;
    public transient int A03;
    public transient int A04;

    @CheckForNull
    public transient Object A05;

    @CheckForNull
    @LazyInit
    public transient Collection<V> A06;

    @CheckForNull
    @LazyInit
    public transient Set<Map.Entry<K, V>> A07;

    @CheckForNull
    @LazyInit
    public transient Set<K> A08;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public int A07(@CheckForNull Object key) {
        if (A0p()) {
            return -1;
        }
        int iA02 = AbstractC1858oI.A02(key);
        int iA00 = A00();
        int iA05 = AbstractC1825nk.A05(A0C(), iA02 & iA00);
        if (iA05 == 0) {
            return -1;
        }
        int iA022 = AbstractC1825nk.A02(iA02, iA00);
        do {
            int i = iA05 - 1;
            int iA01 = A01(i);
            if (AbstractC1825nk.A02(iA01, iA00) == iA022 && CB.A01(key, A0E(i))) {
                return i;
            }
            iA05 = AbstractC1825nk.A03(iA01, iA00);
        } while (iA05 != 0);
        return -1;
    }

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        A09 = new byte[]{-18, 31, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 38, 32, -51, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 25, 31, 18, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 38, -51, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 25, 25, 28, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 33, 18, 17, -119, -68, -76, -87, -89, -72, -87, -88, 100, -73, -83, -66, -87, 100, -79, -71, -73, -72, 100, -90, -87, 100, -126, -127, 100, 116, -108, -71, -63, -84, -73, -76, -81, 107, -66, -76, -59, -80, -123, 107};
        String[] strArr = A0A;
        if (strArr[0].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[7] = "IoFO5J0AFYg4y0jUjWJp7QnfwHFEsl";
        strArr2[5] = "MD8kR9gChUuO1ad3jnDINjX3f2IxRH";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final Iterator<Map.Entry<K, V>> A0d() {
        Map<K, V> mapA0h = A0h();
        return mapA0h != null ? mapA0h.entrySet().iterator() : new C0384Bl(this);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final Iterator<V> A0f() {
        Map<K, V> mapA0h = A0h();
        return mapA0h != null ? mapA0h.values().iterator() : new C0382Bj(this);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public void A0n(int dstIndex, int mask) {
        int i;
        int i2;
        Object objA0C = A0C();
        int[] iArrA0T = A0T();
        Object[] objArrA0V = A0V();
        Object[] objArrA0W = A0W();
        int size = size() - 1;
        if (dstIndex >= size) {
            objArrA0V[dstIndex] = null;
            objArrA0W[dstIndex] = null;
            iArrA0T[dstIndex] = 0;
            return;
        }
        Object obj = objArrA0V[size];
        objArrA0V[dstIndex] = obj;
        objArrA0W[dstIndex] = objArrA0W[size];
        objArrA0V[size] = null;
        objArrA0W[size] = null;
        iArrA0T[dstIndex] = iArrA0T[size];
        String[] strArr = A0A;
        if (strArr[0].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A0A[4] = "JpifJf2kbZdDbZEcWvjQntDjOJA2HcxY";
        iArrA0T[size] = 0;
        int iA02 = AbstractC1858oI.A02(obj) & mask;
        int iA05 = AbstractC1825nk.A05(objA0C, iA02);
        int i3 = size + 1;
        if (iA05 == i3) {
            AbstractC1825nk.A0B(objA0C, iA02, dstIndex + 1);
            return;
        }
        do {
            i = iA05 - 1;
            i2 = iArrA0T[i];
            iA05 = AbstractC1825nk.A03(i2, mask);
        } while (iA05 != i3);
        int iA04 = AbstractC1825nk.A04(i2, dstIndex + 1, mask);
        if (A0A[4].charAt(27) == 'c') {
            throw new RuntimeException();
        }
        A0A[2] = "ewyZpZbIi25h1LX0jZUdN0qrqZxWH2dV";
        iArrA0T[i] = iA04;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final V put(@ParametricNullness K k, @ParametricNullness V v) {
        int i;
        int i2;
        if (A0p()) {
            A0Z();
        }
        Map<K, V> mapA0h = A0h();
        if (mapA0h != null) {
            return mapA0h.put(k, v);
        }
        int[] iArrA0T = A0T();
        Object[] objArrA0V = A0V();
        Object[] objArrA0W = A0W();
        int i3 = this.A04;
        int i4 = i3 + 1;
        int iA02 = AbstractC1858oI.A02(k);
        int iA00 = A00();
        int i5 = iA02 & iA00;
        int iA05 = AbstractC1825nk.A05(A0C(), i5);
        if (iA05 != 0) {
            int iA022 = AbstractC1825nk.A02(iA02, iA00);
            int i6 = 0;
            do {
                i = iA05 - 1;
                i2 = iArrA0T[i];
                if (AbstractC1825nk.A02(i2, iA00) == iA022 && CB.A01(k, objArrA0V[i])) {
                    V v2 = (V) objArrA0W[i];
                    objArrA0W[i] = v;
                    A0k(i);
                    return v2;
                }
                iA05 = AbstractC1825nk.A03(i2, iA00);
                i6++;
            } while (iA05 != 0);
            if (i6 >= 9) {
                return A0g().put(k, v);
            }
            if (i4 > iA00) {
                iA00 = A02(iA00, AbstractC1825nk.A00(iA00), iA02, i3);
            } else {
                iArrA0T[i] = AbstractC1825nk.A04(i2, i3 + 1, iA00);
            }
        } else {
            if (i4 <= iA00) {
                AbstractC1825nk.A0B(A0C(), i5, i3 + 1);
                String[] strArr = A0A;
                if (strArr[0].length() != strArr[1].length()) {
                    A0A[2] = "2ZAiwLyczl80nzcVv99ytgXWx8HMLtqx";
                }
                throw new RuntimeException();
            }
            iA00 = A02(iA00, AbstractC1825nk.A00(iA00), iA02, i3);
        }
        A0N(i4);
        A0o(i3, k, v, iA02, iA00);
        this.A04 = i4;
        A0j();
        if (A0A[6].length() == 14) {
            String[] strArr2 = A0A;
            strArr2[0] = "efczO3YJEcN3CoMhojB5";
            strArr2[1] = "vhmQa5OnZZeWmVDY77t31AOxDsfMGclq";
            return null;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> mapA0h = A0h();
        return mapA0h != null ? mapA0h.size() : this.A04;
    }

    static {
        A0M();
        A0B = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public C1822nh() {
        A0l(3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public C1822nh(int expectedSize) {
        A0l(expectedSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int A00() {
        return (1 << (this.A03 & 31)) - 1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private int A01(int i) {
        return A0T()[i];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private int A02(int oldMask, int newCapacity, int targetHash, int targetEntryIndex) {
        Object objA07 = AbstractC1825nk.A07(newCapacity);
        int hash = newCapacity - 1;
        if (targetEntryIndex != 0) {
            AbstractC1825nk.A0B(objA07, targetHash & hash, targetEntryIndex + 1);
        }
        Object objA0C = A0C();
        int[] iArrA0T = A0T();
        for (int oldTableIndex = 0; oldTableIndex <= oldMask; oldTableIndex++) {
            int iA05 = AbstractC1825nk.A05(objA0C, oldTableIndex);
            while (iA05 != 0) {
                int i = iA05 - 1;
                int newMask = iArrA0T[i];
                int iA02 = AbstractC1825nk.A02(newMask, oldMask) | oldTableIndex;
                int i2 = iA02 & hash;
                int iA052 = AbstractC1825nk.A05(objA07, i2);
                AbstractC1825nk.A0B(objA07, i2, iA05);
                iArrA0T[i] = AbstractC1825nk.A04(iA02, iA052, hash);
                iA05 = AbstractC1825nk.A03(newMask, oldMask);
            }
        }
        this.A05 = objA07;
        A0O(hash);
        return hash;
    }

    public static /* synthetic */ int A04(C1822nh c1822nh) {
        int i = c1822nh.A04;
        c1822nh.A04 = i - 1;
        return i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private final Set<Map.Entry<K, V>> A08() {
        return new C1818nd(this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private final Set<K> A09() {
        return new C1820nf(this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private final Collection<V> A0A() {
        return new C1821ng(this);
    }

    public static <K, V> C1822nh<K, V> A0B(int expectedSize) {
        return new C1822nh<>(expectedSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Object A0C() {
        return Objects.requireNonNull(this.A05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public K A0E(int i) {
        return (K) A0V()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public V A0F(int i) {
        return (V) A0W()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Object A0K(@CheckForNull Object key) {
        if (A0p()) {
            return A0B;
        }
        int iA00 = A00();
        int iA06 = AbstractC1825nk.A06(key, null, iA00, A0C(), A0T(), A0V(), null);
        if (iA06 == -1) {
            Object obj = A0B;
            String[] strArr = A0A;
            String str = strArr[7];
            String str2 = strArr[5];
            int index = str.length();
            int mask = str2.length();
            if (index != mask) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[0] = "F8ZzCx46VEt3o6V5ZJCH";
            strArr2[1] = "RA5kHayy5QpfLDjl1dNEtk1yryeED7Tz";
            return obj;
        }
        V vA0F = A0F(iA06);
        A0n(iA06, iA00);
        int mask2 = this.A04;
        this.A04 = mask2 - 1;
        A0j();
        return vA0F;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private void A0N(int newSize) {
        int entriesSize;
        int length = A0T().length;
        if (newSize > length && (entriesSize = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            A0m(entriesSize);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private void A0O(int mask) {
        int hashTableBits = AbstractC1825nk.A04(this.A03, 32 - Integer.numberOfLeadingZeros(mask), 31);
        this.A03 = hashTableBits;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private void A0P(int i, int value) {
        A0T()[i] = value;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private void A0Q(int i, K key) {
        A0V()[i] = key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public void A0R(int i, V value) {
        A0W()[i] = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int[] A0T() {
        return (int[]) Objects.requireNonNull(this.A00);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Object[] A0V() {
        return (Object[]) Objects.requireNonNull(this.A01);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Object[] A0W() {
        return (Object[]) Objects.requireNonNull(this.A02);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int A0Z() {
        AbstractC1651ki.A0F(A0p(), A0L(0, 24, 121));
        int i = this.A03;
        int buckets = AbstractC1825nk.A01(i);
        this.A05 = AbstractC1825nk.A07(buckets);
        int expectedSize = buckets - 1;
        A0O(expectedSize);
        this.A00 = new int[i];
        this.A01 = new Object[i];
        this.A02 = new Object[i];
        return i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int A0a() {
        return isEmpty() ? -1 : 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int A0b(int entryIndex) {
        if (entryIndex + 1 < this.A04) {
            return entryIndex + 1;
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public int A0c(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public final Iterator<K> A0e() {
        Map<K, V> delegate = A0h();
        if (delegate != null) {
            Iterator<K> it = delegate.keySet().iterator();
            String[] strArr = A0A;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0A[3] = "GopoyTSNvP2uUGwCw8coQru7y5edTQ0w";
            return it;
        }
        return new C0385Bm(this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Map<K, V> A0g() {
        Map<K, V> mapA0i = A0i(A00() + 1);
        int iA0a = A0a();
        while (iA0a >= 0) {
            mapA0i.put(A0E(iA0a), A0F(iA0a));
            iA0a = A0b(iA0a);
        }
        this.A05 = mapA0i;
        this.A00 = null;
        this.A01 = null;
        this.A02 = null;
        A0j();
        return mapA0i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @CheckForNull
    public final Map<K, V> A0h() {
        if (this.A05 instanceof Map) {
            return (Map) this.A05;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public Map<K, V> A0i(int tableSize) {
        return new LinkedHashMap(tableSize, 1.0f);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public final void A0j() {
        this.A03 += 32;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public void A0k(int index) {
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public void A0l(int expectedSize) {
        AbstractC1651ki.A0E(expectedSize >= 0, A0L(24, 26, 16));
        this.A03 = AbstractC0365As.A01(expectedSize, 1, 1073741823);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public void A0m(int newCapacity) {
        this.A00 = Arrays.copyOf(A0T(), newCapacity);
        this.A01 = Arrays.copyOf(A0V(), newCapacity);
        this.A02 = Arrays.copyOf(A0W(), newCapacity);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public void A0o(@ParametricNullness int entryIndex, @ParametricNullness K key, V value, int hash, int mask) {
        A0P(entryIndex, AbstractC1825nk.A04(hash, 0, mask));
        A0Q(entryIndex, key);
        A0R(entryIndex, value);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    public final boolean A0p() {
        return this.A05 == null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (A0p()) {
            return;
        }
        A0j();
        Map<K, V> mapA0h = A0h();
        if (mapA0h == null) {
            Arrays.fill(A0V(), 0, this.A04, (Object) null);
            Arrays.fill(A0W(), 0, this.A04, (Object) null);
            AbstractC1825nk.A0A(A0C());
            if (A0A[4].charAt(27) == 'c') {
                throw new RuntimeException();
            }
            A0A[3] = "HEGfGjMW8cX3B6hZei5dHcacBQ1QHslD";
            Arrays.fill(A0T(), 0, this.A04, 0);
            this.A04 = 0;
            return;
        }
        this.A03 = AbstractC0365As.A01(size(), 3, 1073741823);
        mapA0h.clear();
        this.A05 = null;
        this.A04 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@CheckForNull Object key) {
        Map<K, V> delegate = A0h();
        return delegate != null ? delegate.containsKey(key) : A07(key) != -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@CheckForNull Object value) {
        Map<K, V> delegate = A0h();
        if (delegate != null) {
            return delegate.containsValue(value);
        }
        for (int i = 0; i < this.A04; i++) {
            if (CB.A01(value, A0F(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.A07 != null) {
            return this.A07;
        }
        Set<Map.Entry<K, V>> setA08 = A08();
        this.A07 = setA08;
        return setA08;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object key) {
        Map<K, V> delegate = A0h();
        if (delegate != null) {
            return delegate.get(key);
        }
        int index = A07(key);
        if (index == -1) {
            return null;
        }
        A0k(index);
        return A0F(index);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        if (this.A08 != null) {
            return this.A08;
        }
        Set<K> setA09 = A09();
        this.A08 = setA09;
        return setA09;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        int i = stream.readInt();
        if (i >= 0) {
            A0l(i);
            for (int i2 = 0; i2 < i; i2++) {
                put(stream.readObject(), stream.readObject());
            }
            return;
        }
        throw new InvalidObjectException(A0L(50, 14, 23) + i);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    @CheckForNull
    public final V remove(@CheckForNull Object obj) {
        Map<K, V> mapA0h = A0h();
        if (mapA0h != null) {
            return mapA0h.remove(obj);
        }
        V v = (V) A0K(obj);
        if (v == A0B) {
            return null;
        }
        return v;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        if (this.A06 != null) {
            return this.A06;
        }
        Collection<V> collectionA0A = A0A();
        this.A06 = collectionA0A;
        return collectionA0A;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nh != com.google.common.collect.CompactHashMap<K, V> */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator<Map.Entry<K, V>> itA0d = A0d();
        while (true) {
            boolean zHasNext = itA0d.hasNext();
            String[] strArr = A0A;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[0] = "lZkXti1hHETGLNP2mJng";
            strArr2[1] = "UqMxjQlbiD6IC1mODYXJWocLTdBCXsJ0";
            if (zHasNext) {
                Map.Entry<K, V> e = itA0d.next();
                stream.writeObject(e.getKey());
                stream.writeObject(e.getValue());
            } else {
                return;
            }
        }
    }
}
