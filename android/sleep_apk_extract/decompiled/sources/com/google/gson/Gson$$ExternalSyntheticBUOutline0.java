package com.google.gson;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzaeg;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.play_billing.zzhr;
import com.google.android.gms.internal.serialization.zzzu;
import com.google.android.gms.internal.serialization.zzzv;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Gson$$ExternalSyntheticBUOutline0 implements TextInputLayout.LengthCounter, LibraryVersionComponent.VersionExtractor, ObjectConstructor {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Gson$$ExternalSyntheticBUOutline0(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, int i2, String str) {
        throw new IllegalArgumentException(str + ((char) i) + ((Object) "' with value ") + i + ((Object) " at index ") + i2);
    }

    public static /* synthetic */ void m$1(String str, Object obj) {
        throw new JsonIOException(str + obj);
    }

    public static /* synthetic */ void m$2(String str) throws zzhr {
        throw new zzhr(str);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.$r8$classId) {
            case 21:
                return new TreeMap();
            case 22:
                return new ConcurrentHashMap();
            case 23:
                return new ConcurrentSkipListMap();
            case 24:
                return new ArrayList();
            case 25:
                return new LinkedHashSet();
            case 26:
                return new TreeSet();
            case 27:
                return new ArrayDeque();
            case 28:
                return ConstructorConstructor.lambda$newMapConstructor$3();
            default:
                return new LinkedHashMap();
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.$r8$classId) {
            case 15:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 16:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case 17:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    public static /* synthetic */ void m() throws zzzu {
        throw new zzzu("Protocol message tag had invalid wire type.");
    }

    public static /* synthetic */ void m$1(String str) throws zzaeh {
        throw new zzaeh(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append((Object) "Failed writing ");
        sb.append((char) i2);
        sb.append((Object) " at index ");
        sb.append(i3);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void m$1() throws zzaeg {
        throw new zzaeg("Protocol message tag had invalid wire type.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(int i, long j) {
        StringBuilder sb = new StringBuilder(46);
        sb.append((Object) "Failed writing ");
        sb.append((char) i);
        sb.append((Object) " at index ");
        sb.append(j);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void m(int i, Object obj, int i2, Object obj2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(obj);
        sb.append(i2);
        sb.append(obj2);
        sb.append(i3);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void m(Object obj, Object obj2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(String str) throws zzzv {
        throw new zzzv(str);
    }

    public static /* synthetic */ void m(String str, Object obj) {
        throw new IllegalArgumentException(str + obj);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }
}
