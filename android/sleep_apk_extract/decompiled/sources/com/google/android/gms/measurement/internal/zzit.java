package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzair;
import com.google.android.gms.internal.measurement.zzhv;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    public zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0363 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03a0 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03fc A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x045e A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0474 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x047f A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d3 A[Catch: all -> 0x007b, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0238 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025d A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0279 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a7 A[Catch: all -> 0x007b, LOOP:1: B:92:0x02a1->B:94:0x02a7, LOOP_END, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0343 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:9:0x0057, B:11:0x0062, B:16:0x007e, B:18:0x0084, B:19:0x0096, B:21:0x00ad, B:22:0x00b4, B:24:0x00be, B:25:0x00cb, B:27:0x00d5, B:28:0x00e2, B:30:0x00ed, B:31:0x00f5, B:33:0x010d, B:34:0x0110, B:36:0x012a, B:38:0x013a, B:40:0x0142, B:42:0x0148, B:43:0x014b, B:45:0x015a, B:47:0x0160, B:49:0x016a, B:52:0x0171, B:54:0x0183, B:56:0x0189, B:58:0x0193, B:59:0x01a4, B:61:0x01a8, B:63:0x01b3, B:53:0x017a, B:66:0x01d3, B:67:0x0204, B:69:0x020c, B:71:0x0212, B:75:0x022e, B:77:0x0238, B:78:0x0245, B:79:0x0257, B:81:0x025d, B:88:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:95:0x02db, B:97:0x0343, B:98:0x0357, B:100:0x0363, B:103:0x03b8, B:104:0x03f6, B:106:0x03fc, B:108:0x040d, B:109:0x0418, B:111:0x045e, B:112:0x046c, B:114:0x0474, B:115:0x0477, B:117:0x047f, B:120:0x0488, B:123:0x049d, B:124:0x04a0, B:119:0x0485, B:102:0x03a0, B:90:0x0279, B:130:0x0521), top: B:141:0x0057, inners: #1, #2 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() {
        byte[] bArr;
        zzpg zzpgVar;
        String strZzc;
        zzpg zzpgVar2;
        List listZzn;
        Iterator it;
        zzpn zzpnVar;
        int i;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        zzbd zzbdVarZzf;
        zzpg zzpgVar3;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzh zzhVar;
        String str;
        zzic zzicVar3;
        Bundle bundle;
        Object obj;
        long j;
        zzbd zzbdVarZza;
        com.google.android.gms.internal.measurement.zzic zzicVar4;
        com.google.android.gms.internal.measurement.zzhr zzhrVarZzp;
        zzbe zzbeVar;
        long jZzp;
        long jZzn;
        String strZzh;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzlpVarZzn = zzjdVar.zzL().zzn();
        zzlpVarZzn.zzg();
        zzic zzicVar5 = zzlpVarZzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbhVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzlpVarZzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar4 = zzlpVarZzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar4.zzj().zzb();
        try {
            zzh zzhVarZzu = zzpgVar4.zzj().zzu(str2);
            if (zzhVarZzu == null) {
                zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str2);
                bArr2 = new byte[0];
            } else {
                if (zzhVarZzu.zzD()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE.zza(1);
                    zzicVarZzaE.zzC("android");
                    if (!TextUtils.isEmpty(zzhVarZzu.zzc())) {
                        zzicVarZzaE.zzL(zzhVarZzu.zzc());
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzv())) {
                        zzicVarZzaE.zzJ((String) Preconditions.checkNotNull(zzhVarZzu.zzv()));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzu.zzr())) {
                        zzicVarZzaE.zzM((String) Preconditions.checkNotNull(zzhVarZzu.zzr()));
                    }
                    if (zzhVarZzu.zzt() != -2147483648L) {
                        zzicVarZzaE.zzaj((int) zzhVarZzu.zzt());
                    }
                    zzicVarZzaE.zzN(zzhVarZzu.zzx());
                    zzicVarZzaE.zzar(zzhVarZzu.zzB());
                    String strZzf = zzhVarZzu.zzf();
                    if (!TextUtils.isEmpty(strZzf)) {
                        zzicVarZzaE.zzad(strZzf);
                    }
                    zzicVarZzaE.zzay(zzhVarZzu.zzak());
                    zzjl zzjlVarZzB = zzlpVarZzn.zzg.zzB(str2);
                    zzicVarZzaE.zzY(zzhVarZzu.zzz());
                    if (zzicVar5.zzB() && zzlpVarZzn.zzu.zzc().zzC(zzicVarZzaE.zzK()) && zzjlVarZzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        zzicVarZzaE.zzam(null);
                    }
                    zzicVarZzaE.zzat(zzjlVarZzB.zzk());
                    zzjk zzjkVar = zzjk.AD_STORAGE;
                    if (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) {
                        Pair pairZzd = (zzjlVarZzB.zzo(zzjkVar) && zzhVarZzu.zzac()) ? zzpgVar4.zzq().zzd(zzhVarZzu.zzc()) : new Pair("", Boolean.FALSE);
                        if (zzhVarZzu.zzac() && !TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                            try {
                                zzicVarZzaE.zzQ(zzlp.zzc((String) pairZzd.first, Long.toString(zzbhVar.zzd)));
                                Object obj2 = pairZzd.second;
                                if (obj2 != null) {
                                    zzicVarZzaE.zzT(((Boolean) obj2).booleanValue());
                                }
                                zzic zzicVar6 = zzlpVarZzn.zzu;
                                zzicVar6.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar6.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar6.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar6.zzu().zzc());
                                if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE)) {
                                    zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                }
                                strZzc = zzhVarZzu.zzc();
                                zzpgVar2 = zzlpVarZzn.zzg;
                                listZzn = zzpgVar2.zzj().zzn(strZzc);
                                it = listZzn.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                    }
                                }
                                if (zzpnVar != null) {
                                    zzpn zzpnVar2 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                    listZzn.add(zzpnVar2);
                                    zzpgVar2.zzj().zzl(zzpnVar2);
                                }
                                com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                                while (i < listZzn.size()) {
                                }
                                zzicVarZzaE.zzq(Arrays.asList(zziuVarArr));
                                zzpg zzpgVar5 = zzlpVarZzn.zzg;
                                zzpgVar5.zzI(zzhVarZzu, zzicVarZzaE);
                                zzpgVar5.zzJ(zzhVarZzu, zzicVarZzaE);
                                zzgv zzgvVarZza = zzgv.zza(zzbhVar);
                                zzicVar = zzlpVarZzn.zzu;
                                zzpp zzppVarZzk = zzicVar.zzk();
                                Bundle bundle2 = zzgvVarZza.zze;
                                zzppVarZzk.zzK(bundle2, zzpgVar2.zzj().zzV(str2));
                                zzicVar.zzk().zzI(zzgvVarZza, zzicVar.zzc().zzd(str2));
                                zzicVar2 = zzicVarZzaE;
                                bundle2.putLong("_c", 1L);
                                zzicVar.zzaW().zzj().zza("Marking in-app purchase as real-time");
                                bundle2.putLong("_r", 1L);
                                String str4 = zzbhVar.zzc;
                                bundle2.putString("_o", str4);
                                if (zzicVar.zzk().zzad(zzicVar2.zzK(), zzhVarZzu.zzay())) {
                                }
                                zzaw zzawVarZzj = zzpgVar2.zzj();
                                String str5 = zzbhVar.zza;
                                zzbdVarZzf = zzawVarZzj.zzf(str2, str5);
                                if (zzbdVarZzf != null) {
                                }
                                zzbd zzbdVar = zzbdVarZza;
                                zzpgVar3.zzj().zzh(zzbdVar);
                                zzicVar4 = zzicVar2;
                                zzic zzicVar7 = zzlpVarZzn.zzu;
                                long j2 = zzbhVar.zzd;
                                com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                                zzh zzhVar2 = zzhVar;
                                zzbc zzbcVar = new zzbc(zzicVar7, str, str2, str5, j2, 0L, j, bundle);
                                zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                                zzhrVarZzp.zzo(zzbcVar.zzd);
                                zzhrVarZzp.zzl(zzbcVar.zzb);
                                zzhrVarZzp.zzq(zzbcVar.zzf);
                                zzbf zzbfVar = zzbcVar.zzg;
                                zzbeVar = new zzbe(zzbfVar);
                                while (zzbeVar.hasNext()) {
                                }
                                zzicVar4.zzg(zzhrVarZzp);
                                com.google.android.gms.internal.measurement.zzie zzieVarZza = com.google.android.gms.internal.measurement.zzig.zza();
                                com.google.android.gms.internal.measurement.zzht zzhtVarZza = com.google.android.gms.internal.measurement.zzhu.zza();
                                zzhtVarZza.zzb(zzbdVar.zzc);
                                zzhtVarZza.zza(str5);
                                zzieVarZza.zza(zzhtVarZza);
                                zzicVar4.zzap(zzieVarZza);
                                zzicVar4.zzaf(zzpgVar3.zzm().zzb(zzhVar2.zzc(), Collections.EMPTY_LIST, zzicVar4.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                                if (zzhrVarZzp.zzm()) {
                                }
                                jZzp = zzhVar2.zzp();
                                if (jZzp != 0) {
                                }
                                jZzn = zzhVar2.zzn();
                                if (jZzn == 0) {
                                }
                                strZzh = zzhVar2.zzh();
                                zzair.zza();
                                if (zzicVar3.zzc().zzp(str2, zzfy.zzaM)) {
                                    zzicVar4.zzau(strZzh);
                                }
                                zzhVar2.zzL();
                                zzicVar4.zzZ((int) zzhVar2.zzG());
                                zzicVar3.zzc().zzi();
                                zzicVar4.zzO(161000L);
                                zzicVar4.zzs(zzicVar3.zzba().currentTimeMillis());
                                zzicVar4.zzae(true);
                                zzpgVar5.zzS(zzicVar4.zzK(), zzicVar4);
                                zzhzVar2.zze(zzicVar4);
                                zzhVar2.zzo(zzicVar4.zzu());
                                zzhVar2.zzq(zzicVar4.zzw());
                                zzpgVar3.zzj().zzv(zzhVar2, false, false);
                                zzpgVar3.zzj().zzc();
                                zzpgVar3.zzj().zzd();
                                return zzpgVar3.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                            } catch (SecurityException e) {
                                zzlpVarZzn.zzu.zzaW().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                                bArr = new byte[0];
                                zzpgVar = zzlpVarZzn.zzg;
                            }
                        }
                    } else {
                        zzic zzicVar62 = zzlpVarZzn.zzu;
                        zzicVar62.zzu().zzw();
                        zzicVarZzaE.zzF(Build.MODEL);
                        zzicVar62.zzu().zzw();
                        zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                        zzicVarZzaE.zzI((int) zzicVar62.zzu().zzb());
                        zzicVarZzaE.zzH(zzicVar62.zzu().zzc());
                        try {
                            if (zzjlVarZzB.zzo(zzjk.ANALYTICS_STORAGE) && zzhVarZzu.zzd() != null) {
                                zzicVarZzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzhVarZzu.zzd()), Long.toString(zzbhVar.zzd)));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            strZzc = zzhVarZzu.zzc();
                            zzpgVar2 = zzlpVarZzn.zzg;
                            listZzn = zzpgVar2.zzj().zzn(strZzc);
                            it = listZzn.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    zzpnVar = null;
                                    break;
                                }
                                zzpnVar = (zzpn) it.next();
                                if ("_lte".equals(zzpnVar.zzc)) {
                                    break;
                                }
                            }
                            if (zzpnVar != null || zzpnVar.zze == null) {
                                zzpn zzpnVar22 = new zzpn(strZzc, "auto", "_lte", zzlpVarZzn.zzu.zzba().currentTimeMillis(), 0L);
                                listZzn.add(zzpnVar22);
                                zzpgVar2.zzj().zzl(zzpnVar22);
                            }
                            com.google.android.gms.internal.measurement.zziu[] zziuVarArr2 = new com.google.android.gms.internal.measurement.zziu[listZzn.size()];
                            for (i = 0; i < listZzn.size(); i++) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm.zzb(((zzpn) listZzn.get(i)).zzc);
                                zzitVarZzm.zza(((zzpn) listZzn.get(i)).zzd);
                                zzpgVar2.zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i)).zze);
                                zziuVarArr2[i] = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
                            }
                            zzicVarZzaE.zzq(Arrays.asList(zziuVarArr2));
                            zzpg zzpgVar52 = zzlpVarZzn.zzg;
                            zzpgVar52.zzI(zzhVarZzu, zzicVarZzaE);
                            zzpgVar52.zzJ(zzhVarZzu, zzicVarZzaE);
                            zzgv zzgvVarZza2 = zzgv.zza(zzbhVar);
                            zzicVar = zzlpVarZzn.zzu;
                            zzpp zzppVarZzk2 = zzicVar.zzk();
                            Bundle bundle22 = zzgvVarZza2.zze;
                            zzppVarZzk2.zzK(bundle22, zzpgVar2.zzj().zzV(str2));
                            zzicVar.zzk().zzI(zzgvVarZza2, zzicVar.zzc().zzd(str2));
                            zzicVar2 = zzicVarZzaE;
                            bundle22.putLong("_c", 1L);
                            zzicVar.zzaW().zzj().zza("Marking in-app purchase as real-time");
                            bundle22.putLong("_r", 1L);
                            String str42 = zzbhVar.zzc;
                            bundle22.putString("_o", str42);
                            if (zzicVar.zzk().zzad(zzicVar2.zzK(), zzhVarZzu.zzay())) {
                                zzicVar.zzk().zzO(bundle22, "_dbg", 1L);
                                zzicVar.zzk().zzO(bundle22, "_r", 1L);
                            }
                            zzaw zzawVarZzj2 = zzpgVar2.zzj();
                            String str52 = zzbhVar.zza;
                            zzbdVarZzf = zzawVarZzj2.zzf(str2, str52);
                            if (zzbdVarZzf != null) {
                                zzicVar3 = zzicVar;
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                bundle = bundle22;
                                zzpgVar3 = zzpgVar2;
                                str = str42;
                                obj = null;
                                zzbdVarZza = new zzbd(str2, str52, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                                zzicVar2 = zzicVar2;
                                j = 0;
                            } else {
                                zzpgVar3 = zzpgVar2;
                                zzhzVar = zzhzVarZzi;
                                zzhVar = zzhVarZzu;
                                str = str42;
                                zzicVar3 = zzicVar;
                                bundle = bundle22;
                                obj = null;
                                j = zzbdVarZzf.zzf;
                                zzbdVarZza = zzbdVarZzf.zza(zzbhVar.zzd);
                            }
                            zzbd zzbdVar2 = zzbdVarZza;
                            zzpgVar3.zzj().zzh(zzbdVar2);
                            zzicVar4 = zzicVar2;
                            zzic zzicVar72 = zzlpVarZzn.zzu;
                            long j22 = zzbhVar.zzd;
                            com.google.android.gms.internal.measurement.zzhz zzhzVar22 = zzhzVar;
                            zzh zzhVar22 = zzhVar;
                            zzbc zzbcVar2 = new zzbc(zzicVar72, str, str2, str52, j22, 0L, j, bundle);
                            zzhrVarZzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                            zzhrVarZzp.zzo(zzbcVar2.zzd);
                            zzhrVarZzp.zzl(zzbcVar2.zzb);
                            zzhrVarZzp.zzq(zzbcVar2.zzf);
                            zzbf zzbfVar2 = zzbcVar2.zzg;
                            zzbeVar = new zzbe(zzbfVar2);
                            while (zzbeVar.hasNext()) {
                                String next = zzbeVar.next();
                                zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb(next);
                                Object objZza = zzbfVar2.zza(next);
                                if (objZza != null) {
                                    zzpgVar3.zzp().zzd(zzhvVarZzn, objZza);
                                    zzhrVarZzp.zzg(zzhvVarZzn);
                                }
                            }
                            zzicVar4.zzg(zzhrVarZzp);
                            com.google.android.gms.internal.measurement.zzie zzieVarZza2 = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zzhtVarZza2 = com.google.android.gms.internal.measurement.zzhu.zza();
                            zzhtVarZza2.zzb(zzbdVar2.zzc);
                            zzhtVarZza2.zza(str52);
                            zzieVarZza2.zza(zzhtVarZza2);
                            zzicVar4.zzap(zzieVarZza2);
                            zzicVar4.zzaf(zzpgVar3.zzm().zzb(zzhVar22.zzc(), Collections.EMPTY_LIST, zzicVar4.zzk(), Long.valueOf(zzhrVarZzp.zzn()), Long.valueOf(zzhrVarZzp.zzn()), false));
                            if (zzhrVarZzp.zzm()) {
                                zzicVar4.zzv(zzhrVarZzp.zzn());
                                zzicVar4.zzx(zzhrVarZzp.zzn());
                            }
                            jZzp = zzhVar22.zzp();
                            if (jZzp != 0) {
                                zzicVar4.zzA(jZzp);
                            }
                            jZzn = zzhVar22.zzn();
                            if (jZzn == 0) {
                                zzicVar4.zzy(jZzn);
                            } else if (jZzp != 0) {
                                zzicVar4.zzy(jZzp);
                            }
                            strZzh = zzhVar22.zzh();
                            zzair.zza();
                            if (zzicVar3.zzc().zzp(str2, zzfy.zzaM) && strZzh != null) {
                                zzicVar4.zzau(strZzh);
                            }
                            zzhVar22.zzL();
                            zzicVar4.zzZ((int) zzhVar22.zzG());
                            zzicVar3.zzc().zzi();
                            zzicVar4.zzO(161000L);
                            zzicVar4.zzs(zzicVar3.zzba().currentTimeMillis());
                            zzicVar4.zzae(true);
                            zzpgVar52.zzS(zzicVar4.zzK(), zzicVar4);
                            zzhzVar22.zze(zzicVar4);
                            zzhVar22.zzo(zzicVar4.zzu());
                            zzhVar22.zzq(zzicVar4.zzw());
                            zzpgVar3.zzj().zzv(zzhVar22, false, false);
                            zzpgVar3.zzj().zzc();
                            zzpgVar3.zzj().zzd();
                            try {
                                return zzpgVar3.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar22.zzbd()).zzcd());
                            } catch (IOException e2) {
                                zzlpVarZzn.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                                return obj;
                            }
                        } catch (SecurityException e3) {
                            zzlpVarZzn.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                            bArr = new byte[0];
                            zzpgVar = zzlpVarZzn.zzg;
                        }
                    }
                    zzpgVar.zzj().zzd();
                    return bArr;
                }
                zzlpVarZzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpgVar4.zzj().zzd();
            return bArr2;
        } catch (Throwable th) {
            zzlpVarZzn.zzg.zzj().zzd();
            throw th;
        }
    }
}
