package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeip implements zzfok {
    private static final Pattern zzd = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zza;
    private final zzfpw zzb;
    private final zzfqg zzc;

    public zzeip(String str, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        this.zza = str;
        this.zzc = zzfqgVar;
        this.zzb = zzfpwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws zzeed {
        zzeed zzeedVar;
        String strJoin;
        byte[] bArr;
        JSONObject jSONObjectZza;
        String strConcat;
        zzeio zzeioVar = (zzeio) obj;
        int iOptInt = zzeioVar.zza().optInt("http_timeout_millis", 60000);
        zzcbf zzcbfVarZzb = zzeioVar.zzb();
        if (zzcbfVarZzb.zza() != -2) {
            if (zzcbfVarZzb.zza() == 1) {
                if (zzcbfVarZzb.zzb() != null) {
                    strJoin = TextUtils.join(", ", zzcbfVarZzb.zzb());
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf(strJoin);
                } else {
                    strJoin = "";
                }
                zzeedVar = new zzeed(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzeedVar = new zzeed(1);
            }
            zzfqg zzfqgVar = this.zzc;
            zzfpw zzfpwVar = this.zzb;
            zzfpwVar.zzj(zzeedVar);
            zzfpwVar.zzd(false);
            zzfqgVar.zza(zzfpwVar);
            throw zzeedVar;
        }
        HashMap map = new HashMap();
        if (zzeioVar.zzb().zzg()) {
            String str = this.zza;
            if (!TextUtils.isEmpty(str)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbA)).booleanValue()) {
                    if (TextUtils.isEmpty(str)) {
                        strConcat = "";
                    } else {
                        Matcher matcher = zzd.matcher(str);
                        strConcat = "";
                        while (matcher.find()) {
                            String strGroup = matcher.group(1);
                            if (strGroup != null) {
                                Locale locale = Locale.ROOT;
                                if (strGroup.toLowerCase(locale).startsWith("id=") || strGroup.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(strConcat)) {
                                        strConcat = strConcat.concat("; ");
                                    }
                                    strConcat = strConcat.concat(strGroup);
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        map.put("Cookie", strConcat);
                    }
                } else {
                    map.put("Cookie", str);
                }
            }
        }
        if (zzeioVar.zzb().zzf() && (jSONObjectZza = zzeioVar.zza()) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObjectZza.optJSONObject("pii");
            if (jSONObjectOptJSONObject != null) {
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
                }
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
            }
        }
        byte[] byteArray = new byte[0];
        if (TextUtils.isEmpty(zzeioVar.zzb().zzd())) {
            bArr = byteArray;
        } else {
            byte[] bytes = zzeioVar.zzb().zzd().getBytes(StandardCharsets.UTF_8);
            if (zzeioVar.zzb().zzm()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                    } finally {
                    }
                } catch (IOException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("gzip compression failed, sending uncompressed.", e);
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PrepareRequestFunction.apply");
                    byteArray = null;
                }
                if (byteArray != null) {
                    map.put("Content-Encoding", "gzip");
                    bArr = byteArray;
                }
            }
            bArr = bytes;
        }
        String strZzl = !TextUtils.isEmpty(zzeioVar.zzb().zzl()) ? zzeioVar.zzb().zzl() : "";
        zzfqg zzfqgVar2 = this.zzc;
        zzfpw zzfpwVar2 = this.zzb;
        zzfpwVar2.zzd(true);
        zzfqgVar2.zza(zzfpwVar2);
        return new zzeik(zzeioVar.zzb().zze(), iOptInt, map, bArr, strZzl, zzeioVar.zzb().zzf());
    }
}
