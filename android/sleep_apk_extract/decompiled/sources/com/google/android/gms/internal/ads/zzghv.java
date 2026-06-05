package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import com.google.home.platform.traits.ValidationIssue;
import dalvik.system.DexClassLoader;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes3.dex */
final class zzghv implements zzght {
    ClassLoader zza;
    private final Context zzb;
    private final ExecutorService zzc;
    private final zzgha zzd;
    private final zzghs zze;
    private final zzgqh zzf;
    private final Set zzh;
    private final long zzj;
    private final File zzk;
    private boolean zzl;
    private byte[] zzm;
    private final String zzg = "1773362577665";
    private final Map zzi = new HashMap();

    public zzghv(Context context, ExecutorService executorService, zzgha zzghaVar, zzghs zzghsVar, File file, zzgqh zzgqhVar, long j, String str, String str2, String str3, Set set) {
        this.zzb = context;
        this.zzc = executorService;
        this.zzd = zzghaVar;
        this.zze = zzghsVar;
        this.zzf = zzgqhVar;
        this.zzh = set;
        this.zzk = new File(file, "rbp");
        this.zzj = j;
    }

    private final void zze(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (new File(file.toString().concat("/1773362577665.tmp")).exists()) {
            return;
        }
        File file2 = new File(file.toString().concat("/1773362577665.dex"));
        if (file2.exists()) {
            long length = file2.length();
            if (length > 0) {
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (zzghr e) {
                    e = e;
                } catch (IOException e2) {
                    e = e2;
                }
                try {
                    if (fileInputStream.read(bArr) > 0) {
                        zzayr zzayrVarZzg = zzays.zzg();
                        byte[] bytes = Build.VERSION.SDK.getBytes();
                        zzida zzidaVar = zzida.zza;
                        zzayrVarZzg.zzd(zzida.zzt(bytes, 0, bytes.length));
                        byte[] bytes2 = "1773362577665".getBytes();
                        zzayrVarZzg.zzc(zzida.zzt(bytes2, 0, bytes2.length));
                        throw new zzghr();
                    }
                    zzh(fileInputStream);
                } catch (zzghr e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    this.zzf.zzd(ValidationIssue.BLOCKED_ACTION_FIELD_NUMBER, e);
                    zzh(fileInputStream2);
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    this.zzf.zzd(ValidationIssue.BLOCKED_ACTION_FIELD_NUMBER, e);
                    zzh(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    zzh(fileInputStream2);
                    zzf(file2);
                    throw th;
                }
                zzf(file2);
            }
        }
    }

    private static void zzf(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    private static void zzg(String str) {
        zzf(new File(str));
    }

    private static void zzh(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0268: INVOKE (r0 I:com.google.android.gms.internal.ads.zzgqf) VIRTUAL call: com.google.android.gms.internal.ads.zzgqf.zzc():void A[Catch: all -> 0x0266, MD:():void (m), TRY_ENTER] (LINE:617), block:B:115:0x0268 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x019b -> B:128:0x01bb). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzght
    public final synchronized void zza() {
        zzgqf zzgqfVarZzc;
        byte[] bArrZzb;
        long length;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        try {
            zzgqf zzgqfVarZza = this.zzf.zza(ValidationIssue.INVALID_ENTITY_FIELD_NUMBER);
            try {
                zzgqfVarZza.zza();
                try {
                    try {
                        bArrZzb = zzgea.zzb("iYhu9lTnEtAJiBwgX4ku/kdhSswKTa2KWLA7fmPqgg8=", false);
                    } catch (IllegalArgumentException e) {
                        throw new zzghr(e);
                    }
                } catch (zzghr e2) {
                    throw new zzgeb(e2);
                }
            } catch (zzgeb e3) {
                zzgqfVarZza.zzb(e3);
            } catch (Throwable th) {
                zzgqfVarZza.zzb(th);
                throw th;
            }
            if (bArrZzb.length != 32) {
                throw new zzghr();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(bArrZzb, 4, 16).get(bArr);
            for (int i = 0; i < 16; i++) {
                bArr[i] = (byte) (bArr[i] ^ 68);
            }
            this.zzm = bArr;
            try {
                File file = this.zzk;
                file.mkdirs();
                String string = file.toString();
                StringBuilder sb = new StringBuilder(string.length() + 18);
                sb.append(string);
                sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                sb.append("1773362577665");
                sb.append(".jar");
                File file2 = new File(sb.toString());
                if (!file2.exists()) {
                    byte[] bArrZza = this.zze.zza(this.zzm, "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");
                    file2.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                    try {
                        if (Build.VERSION.SDK_INT >= 34) {
                            file2.setReadOnly();
                        }
                        fileOutputStream2.write(bArrZza, 0, bArrZza.length);
                        fileOutputStream2.close();
                    } finally {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                }
                File file3 = this.zzk;
                String string2 = file3.toString();
                StringBuilder sb2 = new StringBuilder(string2.length() + 19);
                sb2.append(string2);
                sb2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                sb2.append("1773362577665");
                sb2.append(".tmmp");
                File file4 = new File(sb2.toString());
                FileInputStream fileInputStream2 = null;
                if (file4.exists()) {
                    String string3 = file3.toString();
                    StringBuilder sb3 = new StringBuilder(string3.length() + 18);
                    sb3.append(string3);
                    sb3.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                    sb3.append("1773362577665");
                    sb3.append(".dex");
                    File file5 = new File(sb3.toString());
                    if (!file5.exists()) {
                        try {
                            length = file4.length();
                        } catch (zzghr | IOException | NullPointerException unused) {
                            fileInputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                        if (length <= 0) {
                            zzf(file4);
                        } else {
                            byte[] bArr2 = new byte[(int) length];
                            fileInputStream = new FileInputStream(file4);
                            try {
                                try {
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileOutputStream = null;
                                }
                            } catch (zzghr | IOException | NullPointerException unused2) {
                                fileOutputStream = null;
                            }
                            if (fileInputStream.read(bArr2) <= 0) {
                                zzf(file4);
                            } else {
                                zzays zzaysVarZze = zzays.zze(bArr2, zzido.zza());
                                if ("1773362577665".equals(new String(zzaysVarZze.zzc().zzA())) && Arrays.equals(zzaysVarZze.zzb().zzA(), this.zzd.zze(zzaysVarZze.zza().zzA())) && Arrays.equals(zzaysVarZze.zzd().zzA(), Build.VERSION.SDK.getBytes())) {
                                    byte[] bArrZza2 = this.zze.zza(this.zzm, new String(zzaysVarZze.zza().zzA()));
                                    file5.createNewFile();
                                    fileOutputStream = new FileOutputStream(file5);
                                    try {
                                        fileOutputStream.write(bArrZza2, 0, bArrZza2.length);
                                    } catch (zzghr | IOException | NullPointerException unused3) {
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileInputStream2 = fileInputStream;
                                        zzh(fileInputStream2);
                                        zzh(fileOutputStream);
                                        throw th;
                                    }
                                    zzh(fileInputStream);
                                    zzh(fileOutputStream);
                                }
                                zzf(file4);
                            }
                            zzh(fileInputStream);
                        }
                    }
                }
                try {
                    this.zza = new DexClassLoader(file2.getAbsolutePath(), this.zzk.getAbsolutePath(), null, this.zzb.getClassLoader());
                    for (final zzghx zzghxVar : this.zzh) {
                        Pair pairCreate = Pair.create(zzghxVar.zza, zzghxVar.zzb);
                        Map map = this.zzi;
                        if (!map.containsKey(pairCreate)) {
                            map.put(pairCreate, this.zzc.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzghu
                                @Override // java.util.concurrent.Callable
                                public final /* synthetic */ Object call() {
                                    return this.zza.zzd(zzghxVar);
                                }
                            }));
                        }
                    }
                    this.zzl = true;
                    zzgqfVarZza.zzc();
                } finally {
                    zzf(file2);
                    File file6 = this.zzk;
                    String str = this.zzg;
                    zze(file6, str);
                    zzg(String.format("%s/%s.dex", file6, str));
                }
            } catch (zzghr e4) {
                e = e4;
                throw new zzgeb(e);
            } catch (IOException e5) {
                e = e5;
                throw new zzgeb(e);
            } catch (NullPointerException e6) {
                e = e6;
                throw new zzgeb(e);
            }
        } catch (Throwable th6) {
            zzgqfVarZzc.zzc();
            throw th6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final synchronized boolean zzb() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final Method zzc(String str, String str2) {
        Future future = (Future) this.zzi.get(new Pair(str, str2));
        if (future == null) {
            this.zzf.zzb(302);
            return null;
        }
        try {
            return (Method) future.get(this.zzj, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            this.zzf.zzb(304);
            return null;
        } catch (TimeoutException unused2) {
            this.zzf.zzb(303);
            return null;
        }
    }

    public final /* synthetic */ Method zzd(zzghx zzghxVar) {
        ClassLoader classLoader = this.zza;
        zzghs zzghsVar = this.zze;
        byte[] bArr = this.zzm;
        String str = zzghxVar.zza;
        String str2 = zzghxVar.zzb;
        try {
            return classLoader.loadClass(zzghsVar.zzb(bArr, str)).getMethod(zzghsVar.zzb(bArr, str2), zzghxVar.zzc);
        } catch (zzghr | ClassNotFoundException | NoSuchMethodException | NullPointerException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }
}
