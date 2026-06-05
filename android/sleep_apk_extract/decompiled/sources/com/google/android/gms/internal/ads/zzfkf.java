package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.getpebble.android.kit.Constants;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfkf {
    public final zzcdk zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final int zzQ;
    public final int zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final String zzU;
    public final zzflb zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final int zzY;
    public final String zzZ;
    public final List zza;
    public final List zzaA;
    public final boolean zzaB;
    public final List zzaC;
    public final boolean zzaD;
    public final int zzaE;
    public final Bundle zzaF;
    public final boolean zzaG;
    public final JSONArray zzaH;
    public final int zzaI;
    public final int zzaa;
    public final String zzab;
    public final boolean zzac;
    public final zzbzh zzad;
    public final com.google.android.gms.ads.internal.client.zzt zzae;
    public final String zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final String zzal;
    public final boolean zzam;
    public final String zzan;
    public final String zzao;
    public final String zzap;
    public final boolean zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final boolean zzav;
    public final Map zzaw;
    public final com.google.android.gms.ads.internal.util.client.zzv zzax;
    public final com.google.android.gms.ads.internal.util.client.zzw zzay;
    public final double zzaz;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final int zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final String zzj;
    public final String zzk;
    public final zzccb zzl;
    public final List zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final int zzq;
    public final List zzr;
    public final zzfkk zzs;
    public final List zzt;
    public final List zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:303:0x091f A[ADDED_TO_REGION, PHI: r90 r92
      0x091f: PHI (r90v94 java.util.List) = 
      (r90v4 java.util.List)
      (r90v5 java.util.List)
      (r90v6 java.util.List)
      (r90v7 java.util.List)
      (r90v8 java.util.List)
      (r90v9 java.util.List)
      (r90v10 java.util.List)
      (r90v11 java.util.List)
      (r90v12 java.util.List)
      (r90v13 java.util.List)
      (r90v14 java.util.List)
      (r90v15 java.util.List)
      (r90v16 java.util.List)
      (r90v17 java.util.List)
      (r90v18 java.util.List)
      (r90v19 java.util.List)
      (r90v20 java.util.List)
      (r90v21 java.util.List)
      (r90v22 java.util.List)
      (r90v23 java.util.List)
      (r90v24 java.util.List)
      (r90v25 java.util.List)
      (r90v26 java.util.List)
      (r90v27 java.util.List)
      (r90v28 java.util.List)
      (r90v29 java.util.List)
      (r90v30 java.util.List)
      (r90v31 java.util.List)
      (r90v32 java.util.List)
      (r90v33 java.util.List)
      (r90v34 java.util.List)
      (r90v35 java.util.List)
      (r90v36 java.util.List)
      (r90v37 java.util.List)
      (r90v38 java.util.List)
      (r90v39 java.util.List)
      (r90v40 java.util.List)
      (r90v41 java.util.List)
      (r90v42 java.util.List)
      (r90v43 java.util.List)
      (r90v44 java.util.List)
      (r90v45 java.util.List)
      (r90v46 java.util.List)
      (r90v47 java.util.List)
      (r90v48 java.util.List)
      (r90v49 java.util.List)
      (r90v50 java.util.List)
      (r90v51 java.util.List)
      (r90v52 java.util.List)
      (r90v53 java.util.List)
      (r90v54 java.util.List)
      (r90v55 java.util.List)
      (r90v56 java.util.List)
      (r90v57 java.util.List)
      (r90v58 java.util.List)
      (r90v59 java.util.List)
      (r90v60 java.util.List)
      (r90v61 java.util.List)
      (r90v62 java.util.List)
      (r90v63 java.util.List)
      (r90v64 java.util.List)
      (r90v65 java.util.List)
      (r90v66 java.util.List)
      (r90v67 java.util.List)
      (r90v68 java.util.List)
      (r90v69 java.util.List)
      (r90v70 java.util.List)
      (r90v71 java.util.List)
      (r90v72 java.util.List)
      (r90v73 java.util.List)
      (r90v74 java.util.List)
      (r90v75 java.util.List)
      (r90v76 java.util.List)
      (r90v77 java.util.List)
      (r90v78 java.util.List)
      (r90v79 java.util.List)
      (r90v80 java.util.List)
      (r90v81 java.util.List)
      (r90v82 java.util.List)
      (r90v83 java.util.List)
      (r90v84 java.util.List)
      (r90v85 java.util.List)
      (r90v86 java.util.List)
      (r90v87 java.util.List)
      (r90v88 java.util.List)
      (r90v89 java.util.List)
      (r90v90 java.util.List)
      (r90v91 java.util.List)
      (r90v92 java.util.List)
      (r90v95 java.util.List)
     binds: [B:301:0x0917, B:298:0x0901, B:295:0x08eb, B:289:0x08be, B:286:0x08aa, B:283:0x0894, B:280:0x087e, B:274:0x0851, B:271:0x0837, B:268:0x0823, B:265:0x080f, B:262:0x07f9, B:259:0x07df, B:256:0x07cb, B:250:0x079f, B:247:0x0785, B:244:0x076f, B:241:0x0759, B:238:0x0743, B:235:0x072d, B:232:0x0717, B:229:0x0701, B:226:0x06eb, B:223:0x06d5, B:220:0x06bb, B:217:0x06a5, B:214:0x0690, B:211:0x0677, B:208:0x0661, B:205:0x064d, B:202:0x0639, B:199:0x0625, B:196:0x060d, B:193:0x05f9, B:190:0x05e5, B:187:0x05d1, B:181:0x05a8, B:178:0x0592, B:175:0x0578, B:172:0x0564, B:169:0x054e, B:166:0x0538, B:163:0x0522, B:160:0x050c, B:157:0x04f9, B:154:0x04e3, B:151:0x04cf, B:148:0x04b9, B:145:0x04a3, B:142:0x048d, B:140:0x047d, B:135:0x045c, B:132:0x0446, B:129:0x0432, B:126:0x041c, B:123:0x0408, B:120:0x03f4, B:117:0x03de, B:114:0x03c8, B:111:0x03b2, B:108:0x039c, B:105:0x0388, B:96:0x0354, B:93:0x033e, B:90:0x0325, B:84:0x02fc, B:81:0x02e8, B:78:0x02cf, B:75:0x02bb, B:72:0x02a8, B:69:0x0292, B:66:0x027c, B:63:0x0266, B:60:0x0252, B:54:0x0229, B:51:0x0213, B:48:0x01ff, B:45:0x01eb, B:42:0x01d7, B:39:0x01c3, B:36:0x01ad, B:33:0x019a, B:30:0x0185, B:27:0x0170, B:24:0x015d, B:21:0x0148, B:18:0x0133, B:13:0x011a, B:11:0x0108, B:399:0x091f] A[DONT_GENERATE, DONT_INLINE]
      0x091f: PHI (r92v92 java.util.List) = 
      (r92v1 java.util.List)
      (r92v2 java.util.List)
      (r92v3 java.util.List)
      (r92v4 java.util.List)
      (r92v5 java.util.List)
      (r92v6 java.util.List)
      (r92v7 java.util.List)
      (r92v8 java.util.List)
      (r92v9 java.util.List)
      (r92v10 java.util.List)
      (r92v11 java.util.List)
      (r92v12 java.util.List)
      (r92v13 java.util.List)
      (r92v14 java.util.List)
      (r92v15 java.util.List)
      (r92v16 java.util.List)
      (r92v17 java.util.List)
      (r92v18 java.util.List)
      (r92v19 java.util.List)
      (r92v20 java.util.List)
      (r92v21 java.util.List)
      (r92v22 java.util.List)
      (r92v23 java.util.List)
      (r92v24 java.util.List)
      (r92v25 java.util.List)
      (r92v26 java.util.List)
      (r92v27 java.util.List)
      (r92v28 java.util.List)
      (r92v29 java.util.List)
      (r92v30 java.util.List)
      (r92v31 java.util.List)
      (r92v32 java.util.List)
      (r92v33 java.util.List)
      (r92v34 java.util.List)
      (r92v35 java.util.List)
      (r92v36 java.util.List)
      (r92v37 java.util.List)
      (r92v38 java.util.List)
      (r92v39 java.util.List)
      (r92v40 java.util.List)
      (r92v41 java.util.List)
      (r92v42 java.util.List)
      (r92v43 java.util.List)
      (r92v44 java.util.List)
      (r92v45 java.util.List)
      (r92v46 java.util.List)
      (r92v47 java.util.List)
      (r92v48 java.util.List)
      (r92v49 java.util.List)
      (r92v50 java.util.List)
      (r92v51 java.util.List)
      (r92v52 java.util.List)
      (r92v53 java.util.List)
      (r92v54 java.util.List)
      (r92v55 java.util.List)
      (r92v56 java.util.List)
      (r92v57 java.util.List)
      (r92v58 java.util.List)
      (r92v59 java.util.List)
      (r92v60 java.util.List)
      (r92v61 java.util.List)
      (r92v62 java.util.List)
      (r92v63 java.util.List)
      (r92v64 java.util.List)
      (r92v65 java.util.List)
      (r92v66 java.util.List)
      (r92v67 java.util.List)
      (r92v68 java.util.List)
      (r92v69 java.util.List)
      (r92v70 java.util.List)
      (r92v71 java.util.List)
      (r92v72 java.util.List)
      (r92v73 java.util.List)
      (r92v74 java.util.List)
      (r92v75 java.util.List)
      (r92v76 java.util.List)
      (r92v77 java.util.List)
      (r92v78 java.util.List)
      (r92v79 java.util.List)
      (r92v80 java.util.List)
      (r92v81 java.util.List)
      (r92v82 java.util.List)
      (r92v83 java.util.List)
      (r92v84 java.util.List)
      (r92v85 java.util.List)
      (r92v86 java.util.List)
      (r92v87 java.util.List)
      (r92v88 java.util.List)
      (r92v89 java.util.List)
      (r92v93 java.util.List)
     binds: [B:301:0x0917, B:298:0x0901, B:295:0x08eb, B:289:0x08be, B:286:0x08aa, B:283:0x0894, B:280:0x087e, B:274:0x0851, B:271:0x0837, B:268:0x0823, B:265:0x080f, B:262:0x07f9, B:259:0x07df, B:256:0x07cb, B:250:0x079f, B:247:0x0785, B:244:0x076f, B:241:0x0759, B:238:0x0743, B:235:0x072d, B:232:0x0717, B:229:0x0701, B:226:0x06eb, B:223:0x06d5, B:220:0x06bb, B:217:0x06a5, B:214:0x0690, B:211:0x0677, B:208:0x0661, B:205:0x064d, B:202:0x0639, B:199:0x0625, B:196:0x060d, B:193:0x05f9, B:190:0x05e5, B:187:0x05d1, B:181:0x05a8, B:178:0x0592, B:175:0x0578, B:172:0x0564, B:169:0x054e, B:166:0x0538, B:163:0x0522, B:160:0x050c, B:157:0x04f9, B:154:0x04e3, B:151:0x04cf, B:148:0x04b9, B:145:0x04a3, B:142:0x048d, B:140:0x047d, B:135:0x045c, B:132:0x0446, B:129:0x0432, B:126:0x041c, B:123:0x0408, B:120:0x03f4, B:117:0x03de, B:114:0x03c8, B:111:0x03b2, B:108:0x039c, B:105:0x0388, B:96:0x0354, B:93:0x033e, B:90:0x0325, B:84:0x02fc, B:81:0x02e8, B:78:0x02cf, B:75:0x02bb, B:72:0x02a8, B:69:0x0292, B:66:0x027c, B:63:0x0266, B:60:0x0252, B:54:0x0229, B:51:0x0213, B:48:0x01ff, B:45:0x01eb, B:42:0x01d7, B:39:0x01c3, B:36:0x01ad, B:33:0x019a, B:30:0x0185, B:27:0x0170, B:24:0x015d, B:21:0x0148, B:18:0x0133, B:13:0x011a, B:11:0x0108, B:399:0x091f] A[DONT_GENERATE, DONT_INLINE], REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x091f A[PHI: r90 r92
      0x091f: PHI (r90v94 java.util.List) = 
      (r90v4 java.util.List)
      (r90v5 java.util.List)
      (r90v6 java.util.List)
      (r90v7 java.util.List)
      (r90v8 java.util.List)
      (r90v9 java.util.List)
      (r90v10 java.util.List)
      (r90v11 java.util.List)
      (r90v12 java.util.List)
      (r90v13 java.util.List)
      (r90v14 java.util.List)
      (r90v15 java.util.List)
      (r90v16 java.util.List)
      (r90v17 java.util.List)
      (r90v18 java.util.List)
      (r90v19 java.util.List)
      (r90v20 java.util.List)
      (r90v21 java.util.List)
      (r90v22 java.util.List)
      (r90v23 java.util.List)
      (r90v24 java.util.List)
      (r90v25 java.util.List)
      (r90v26 java.util.List)
      (r90v27 java.util.List)
      (r90v28 java.util.List)
      (r90v29 java.util.List)
      (r90v30 java.util.List)
      (r90v31 java.util.List)
      (r90v32 java.util.List)
      (r90v33 java.util.List)
      (r90v34 java.util.List)
      (r90v35 java.util.List)
      (r90v36 java.util.List)
      (r90v37 java.util.List)
      (r90v38 java.util.List)
      (r90v39 java.util.List)
      (r90v40 java.util.List)
      (r90v41 java.util.List)
      (r90v42 java.util.List)
      (r90v43 java.util.List)
      (r90v44 java.util.List)
      (r90v45 java.util.List)
      (r90v46 java.util.List)
      (r90v47 java.util.List)
      (r90v48 java.util.List)
      (r90v49 java.util.List)
      (r90v50 java.util.List)
      (r90v51 java.util.List)
      (r90v52 java.util.List)
      (r90v53 java.util.List)
      (r90v54 java.util.List)
      (r90v55 java.util.List)
      (r90v56 java.util.List)
      (r90v57 java.util.List)
      (r90v58 java.util.List)
      (r90v59 java.util.List)
      (r90v60 java.util.List)
      (r90v61 java.util.List)
      (r90v62 java.util.List)
      (r90v63 java.util.List)
      (r90v64 java.util.List)
      (r90v65 java.util.List)
      (r90v66 java.util.List)
      (r90v67 java.util.List)
      (r90v68 java.util.List)
      (r90v69 java.util.List)
      (r90v70 java.util.List)
      (r90v71 java.util.List)
      (r90v72 java.util.List)
      (r90v73 java.util.List)
      (r90v74 java.util.List)
      (r90v75 java.util.List)
      (r90v76 java.util.List)
      (r90v77 java.util.List)
      (r90v78 java.util.List)
      (r90v79 java.util.List)
      (r90v80 java.util.List)
      (r90v81 java.util.List)
      (r90v82 java.util.List)
      (r90v83 java.util.List)
      (r90v84 java.util.List)
      (r90v85 java.util.List)
      (r90v86 java.util.List)
      (r90v87 java.util.List)
      (r90v88 java.util.List)
      (r90v89 java.util.List)
      (r90v90 java.util.List)
      (r90v91 java.util.List)
      (r90v92 java.util.List)
      (r90v95 java.util.List)
     binds: [B:301:0x0917, B:298:0x0901, B:295:0x08eb, B:289:0x08be, B:286:0x08aa, B:283:0x0894, B:280:0x087e, B:274:0x0851, B:271:0x0837, B:268:0x0823, B:265:0x080f, B:262:0x07f9, B:259:0x07df, B:256:0x07cb, B:250:0x079f, B:247:0x0785, B:244:0x076f, B:241:0x0759, B:238:0x0743, B:235:0x072d, B:232:0x0717, B:229:0x0701, B:226:0x06eb, B:223:0x06d5, B:220:0x06bb, B:217:0x06a5, B:214:0x0690, B:211:0x0677, B:208:0x0661, B:205:0x064d, B:202:0x0639, B:199:0x0625, B:196:0x060d, B:193:0x05f9, B:190:0x05e5, B:187:0x05d1, B:181:0x05a8, B:178:0x0592, B:175:0x0578, B:172:0x0564, B:169:0x054e, B:166:0x0538, B:163:0x0522, B:160:0x050c, B:157:0x04f9, B:154:0x04e3, B:151:0x04cf, B:148:0x04b9, B:145:0x04a3, B:142:0x048d, B:140:0x047d, B:135:0x045c, B:132:0x0446, B:129:0x0432, B:126:0x041c, B:123:0x0408, B:120:0x03f4, B:117:0x03de, B:114:0x03c8, B:111:0x03b2, B:108:0x039c, B:105:0x0388, B:96:0x0354, B:93:0x033e, B:90:0x0325, B:84:0x02fc, B:81:0x02e8, B:78:0x02cf, B:75:0x02bb, B:72:0x02a8, B:69:0x0292, B:66:0x027c, B:63:0x0266, B:60:0x0252, B:54:0x0229, B:51:0x0213, B:48:0x01ff, B:45:0x01eb, B:42:0x01d7, B:39:0x01c3, B:36:0x01ad, B:33:0x019a, B:30:0x0185, B:27:0x0170, B:24:0x015d, B:21:0x0148, B:18:0x0133, B:13:0x011a, B:11:0x0108, B:399:0x091f] A[DONT_GENERATE, DONT_INLINE]
      0x091f: PHI (r92v92 java.util.List) = 
      (r92v1 java.util.List)
      (r92v2 java.util.List)
      (r92v3 java.util.List)
      (r92v4 java.util.List)
      (r92v5 java.util.List)
      (r92v6 java.util.List)
      (r92v7 java.util.List)
      (r92v8 java.util.List)
      (r92v9 java.util.List)
      (r92v10 java.util.List)
      (r92v11 java.util.List)
      (r92v12 java.util.List)
      (r92v13 java.util.List)
      (r92v14 java.util.List)
      (r92v15 java.util.List)
      (r92v16 java.util.List)
      (r92v17 java.util.List)
      (r92v18 java.util.List)
      (r92v19 java.util.List)
      (r92v20 java.util.List)
      (r92v21 java.util.List)
      (r92v22 java.util.List)
      (r92v23 java.util.List)
      (r92v24 java.util.List)
      (r92v25 java.util.List)
      (r92v26 java.util.List)
      (r92v27 java.util.List)
      (r92v28 java.util.List)
      (r92v29 java.util.List)
      (r92v30 java.util.List)
      (r92v31 java.util.List)
      (r92v32 java.util.List)
      (r92v33 java.util.List)
      (r92v34 java.util.List)
      (r92v35 java.util.List)
      (r92v36 java.util.List)
      (r92v37 java.util.List)
      (r92v38 java.util.List)
      (r92v39 java.util.List)
      (r92v40 java.util.List)
      (r92v41 java.util.List)
      (r92v42 java.util.List)
      (r92v43 java.util.List)
      (r92v44 java.util.List)
      (r92v45 java.util.List)
      (r92v46 java.util.List)
      (r92v47 java.util.List)
      (r92v48 java.util.List)
      (r92v49 java.util.List)
      (r92v50 java.util.List)
      (r92v51 java.util.List)
      (r92v52 java.util.List)
      (r92v53 java.util.List)
      (r92v54 java.util.List)
      (r92v55 java.util.List)
      (r92v56 java.util.List)
      (r92v57 java.util.List)
      (r92v58 java.util.List)
      (r92v59 java.util.List)
      (r92v60 java.util.List)
      (r92v61 java.util.List)
      (r92v62 java.util.List)
      (r92v63 java.util.List)
      (r92v64 java.util.List)
      (r92v65 java.util.List)
      (r92v66 java.util.List)
      (r92v67 java.util.List)
      (r92v68 java.util.List)
      (r92v69 java.util.List)
      (r92v70 java.util.List)
      (r92v71 java.util.List)
      (r92v72 java.util.List)
      (r92v73 java.util.List)
      (r92v74 java.util.List)
      (r92v75 java.util.List)
      (r92v76 java.util.List)
      (r92v77 java.util.List)
      (r92v78 java.util.List)
      (r92v79 java.util.List)
      (r92v80 java.util.List)
      (r92v81 java.util.List)
      (r92v82 java.util.List)
      (r92v83 java.util.List)
      (r92v84 java.util.List)
      (r92v85 java.util.List)
      (r92v86 java.util.List)
      (r92v87 java.util.List)
      (r92v88 java.util.List)
      (r92v89 java.util.List)
      (r92v93 java.util.List)
     binds: [B:301:0x0917, B:298:0x0901, B:295:0x08eb, B:289:0x08be, B:286:0x08aa, B:283:0x0894, B:280:0x087e, B:274:0x0851, B:271:0x0837, B:268:0x0823, B:265:0x080f, B:262:0x07f9, B:259:0x07df, B:256:0x07cb, B:250:0x079f, B:247:0x0785, B:244:0x076f, B:241:0x0759, B:238:0x0743, B:235:0x072d, B:232:0x0717, B:229:0x0701, B:226:0x06eb, B:223:0x06d5, B:220:0x06bb, B:217:0x06a5, B:214:0x0690, B:211:0x0677, B:208:0x0661, B:205:0x064d, B:202:0x0639, B:199:0x0625, B:196:0x060d, B:193:0x05f9, B:190:0x05e5, B:187:0x05d1, B:181:0x05a8, B:178:0x0592, B:175:0x0578, B:172:0x0564, B:169:0x054e, B:166:0x0538, B:163:0x0522, B:160:0x050c, B:157:0x04f9, B:154:0x04e3, B:151:0x04cf, B:148:0x04b9, B:145:0x04a3, B:142:0x048d, B:140:0x047d, B:135:0x045c, B:132:0x0446, B:129:0x0432, B:126:0x041c, B:123:0x0408, B:120:0x03f4, B:117:0x03de, B:114:0x03c8, B:111:0x03b2, B:108:0x039c, B:105:0x0388, B:96:0x0354, B:93:0x033e, B:90:0x0325, B:84:0x02fc, B:81:0x02e8, B:78:0x02cf, B:75:0x02bb, B:72:0x02a8, B:69:0x0292, B:66:0x027c, B:63:0x0266, B:60:0x0252, B:54:0x0229, B:51:0x0213, B:48:0x01ff, B:45:0x01eb, B:42:0x01d7, B:39:0x01c3, B:36:0x01ad, B:33:0x019a, B:30:0x0185, B:27:0x0170, B:24:0x015d, B:21:0x0148, B:18:0x0133, B:13:0x011a, B:11:0x0108, B:399:0x091f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzfkf(JsonReader jsonReader) throws IOException {
        List list;
        List list2;
        List listZzb = Collections.EMPTY_LIST;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        zzgwm.zzi();
        zzgwm zzgwmVarZzi = zzgwm.zzi();
        HashMap map = new HashMap();
        zzgwm zzgwmVarZzi2 = zzgwm.zzi();
        zzgwm zzgwmVarZzi3 = zzgwm.zzi();
        Bundle bundle = new Bundle();
        jsonReader.beginObject();
        List listZza = listZzb;
        List listZzb2 = listZza;
        JSONObject jSONObjectZzd = jSONObject2;
        JSONObject jSONObjectZzd2 = jSONObject3;
        JSONObject jSONObjectZzd3 = jSONObject4;
        JSONObject jSONObjectZzd4 = jSONObject5;
        JSONObject jSONObjectZzd5 = jSONObject6;
        List listZzb3 = zzgwmVarZzi;
        Map mapZzc = map;
        List listZzb4 = zzgwmVarZzi2;
        zzgwm zzgwmVarZza = zzgwmVarZzi3;
        Bundle bundle2 = bundle;
        zzcdk zzcdkVarZza = null;
        zzbzh zzbzhVarZza = null;
        com.google.android.gms.ads.internal.client.zzt zztVarZza = null;
        String strNextString = null;
        com.google.android.gms.ads.internal.util.client.zzv zzvVarZzb = null;
        com.google.android.gms.ads.internal.util.client.zzw zzwVarZzd = null;
        JSONArray jSONArrayZze = null;
        boolean zNextBoolean = true;
        int iZze = -1;
        int iNextInt = -1;
        int iNextInt2 = -1;
        int iZzd = 0;
        boolean zNextBoolean2 = false;
        boolean zNextBoolean3 = false;
        boolean zNextBoolean4 = false;
        boolean zNextBoolean5 = false;
        boolean zNextBoolean6 = false;
        boolean zNextBoolean7 = false;
        boolean zNextBoolean8 = false;
        int iNextInt3 = 0;
        boolean zNextBoolean9 = false;
        boolean zNextBoolean10 = false;
        boolean zNextBoolean11 = false;
        int iNextInt4 = 0;
        boolean zNextBoolean12 = false;
        boolean zNextBoolean13 = false;
        boolean zNextBoolean14 = false;
        boolean zNextBoolean15 = false;
        boolean zNextBoolean16 = false;
        boolean zNextBoolean17 = false;
        boolean zNextBoolean18 = false;
        boolean zNextBoolean19 = false;
        int iNextInt5 = 0;
        boolean zNextBoolean20 = false;
        boolean zNextBoolean21 = false;
        boolean zNextBoolean22 = false;
        int iNextInt6 = 0;
        int iZza = 2;
        double dNextDouble = 0.0d;
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        String strNextString6 = strNextString5;
        String string = strNextString6;
        String strNextString7 = string;
        String strNextString8 = strNextString7;
        String strNextString9 = strNextString8;
        String strNextString10 = strNextString9;
        String strNextString11 = strNextString10;
        String strNextString12 = strNextString11;
        String strNextString13 = strNextString12;
        String strNextString14 = strNextString13;
        String strNextString15 = strNextString14;
        String strNextString16 = strNextString15;
        String strNextString17 = strNextString16;
        String strNextString18 = strNextString17;
        String strNextString19 = strNextString18;
        String strNextString20 = strNextString19;
        List listZzb5 = listZzb2;
        List listZzb6 = listZzb5;
        List listZzb7 = listZzb6;
        List listZzb8 = listZzb7;
        List listZzb9 = listZzb8;
        List listZzb10 = listZzb9;
        List listZzb11 = listZzb10;
        List listZzb12 = listZzb11;
        List listZza2 = listZzb12;
        List listZzb13 = listZza2;
        JSONObject jSONObjectZzd6 = jSONObject;
        zzccb zzccbVarZza = null;
        zzfkk zzfkkVar = null;
        int iZzc = 0;
        List listZzb14 = listZzb13;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String str = strNextName == null ? "" : strNextName;
            switch (str.hashCode()) {
                case -2138196627:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_source_instance_name")) {
                        strNextString15 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1980587809:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("debug_signals")) {
                        jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1965512151:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("omid_settings")) {
                        jSONObjectZzd3 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1964744830:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("offline_ad_config") && ((Boolean) zzbiq.zzjR.zzg()).booleanValue()) {
                        zzwVarZzd = com.google.android.gms.ads.internal.util.client.zzw.zzd(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1871425831:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("recursive_server_response_data")) {
                        strNextString18 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1843156475:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_consent")) {
                        zNextBoolean19 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1840512279:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("presentation_urls")) {
                        listZzb4 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1828733410:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("network_ping_config") && ((Boolean) zzbiq.zzjP.zzg()).booleanValue()) {
                        zzvVarZzb = com.google.android.gms.ads.internal.util.client.zzv.zzb(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1812055556:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("play_prewarm_options")) {
                        zzbzhVarZza = zzbzh.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1785028569:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("parallel_key")) {
                        strNextString20 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1776946669:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_source_name")) {
                        strNextString13 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1662989631:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_interscroller")) {
                        zNextBoolean13 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1620552059:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("preload_sort_type")) {
                        iZza = zzftl.zza(jsonReader.nextInt());
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1620470467:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("backend_query_id")) {
                        strNextString10 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1550155393:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (!str.equals("nofill_urls")) {
                        listZzb12 = list2;
                        listZzb11 = list;
                    } else {
                        listZzb11 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                        listZzb12 = list2;
                    }
                    break;
                case -1440104884:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_custom_close_blocked")) {
                        zNextBoolean7 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1439500848:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("orientation")) {
                        iZze = zze(jsonReader.nextString());
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1428969291:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("enable_omid")) {
                        zNextBoolean9 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1406227629:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("buffer_click_url_as_ready_to_ping")) {
                        zNextBoolean17 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1403779768:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("showable_impression_type")) {
                        iNextInt4 = jsonReader.nextInt();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1375413093:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_cover")) {
                        jSONObjectZzd4 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1360811658:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_sizes")) {
                        listZza2 = zzfkg.zza(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1306015996:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("adapters")) {
                        listZzb13 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1303332046:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("test_mode_enabled")) {
                        zNextBoolean6 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1289032093:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("extras")) {
                        jSONObjectZzd2 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1240082064:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_event_value")) {
                        zztVarZza = com.google.android.gms.ads.internal.client.zzt.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1234181075:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("allow_pub_rendered_attribution")) {
                        zNextBoolean2 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1168140544:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("presentation_error_urls")) {
                        listZzb12 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                        listZzb11 = list;
                    }
                    jsonReader.skipValue();
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1152230954:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
                        iZzc = zzc(jsonReader.nextString());
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1146534047:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_scroll_aware")) {
                        zNextBoolean11 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1115838944:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("fill_urls")) {
                        listZzb10 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1081936678:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("allocation_id")) {
                        strNextString4 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1078050970:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("video_complete_urls")) {
                        listZzb9 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -1051269058:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("active_view")) {
                        string = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader).toString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -982608540:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("valid_from_timestamp")) {
                        strNextString2 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -972056451:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_source_instance_id")) {
                        strNextString16 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -776859333:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("click_urls")) {
                        listZzb14 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -652881372:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("on_device_storage_configs") && ((Boolean) zzbiq.zziK.zzg()).booleanValue()) {
                        zzgwmVarZza = zzeap.zza(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -570101180:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("late_load_urls")) {
                        listZzb3 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -544216775:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("safe_browsing")) {
                        zzcdkVarZza = zzcdk.zza(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -437057161:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("imp_urls")) {
                        listZzb5 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -404433734:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("rtb_native_required_assets")) {
                        jSONObjectZzd5 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -404326515:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("render_timeout_ms")) {
                        iNextInt3 = jsonReader.nextInt();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -397704715:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_close_time_ms")) {
                        iNextInt = jsonReader.nextInt();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -388807511:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals(ShareConstants.STORY_DEEP_LINK_URL)) {
                        strNextString = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -369773488:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_close_button_enabled")) {
                        jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -213449460:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("force_disable_hardware_acceleration")) {
                        zNextBoolean16 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -213424028:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("watermark")) {
                        strNextString9 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -180214626:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("native_required_asset_viewability")) {
                        zNextBoolean15 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -154616268:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_offline_ad")) {
                        zNextBoolean14 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case -29338502:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("allow_custom_click_gesture")) {
                        zNextBoolean4 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 3107:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (!str.equals("ad")) {
                        listZzb12 = list2;
                        listZzb11 = list;
                    } else {
                        zzfkkVar = new zzfkk(jsonReader);
                        listZzb12 = list2;
                        listZzb11 = list;
                    }
                    break;
                case 3355:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("id")) {
                        strNextString5 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 3076010:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("data")) {
                        jSONObjectZzd6 = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 37109963:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals(SDKAnalyticsEvents.PARAMETER_REQUEST_ID)) {
                        strNextString17 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 63195984:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("render_test_label")) {
                        zNextBoolean5 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 107433883:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("qdata")) {
                        strNextString6 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 230323073:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_load_urls")) {
                        listZzb6 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 281223176:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_secondary_analytics_logging_enabled")) {
                        zNextBoolean = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 418392395:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_closable_area_disabled")) {
                        zNextBoolean8 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 542250332:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("consent_form_action_identifier")) {
                        iNextInt5 = jsonReader.nextInt();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 549176928:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("presentation_error_timeout_ms")) {
                        iNextInt6 = jsonReader.nextInt();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 597473788:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("debug_dialog_string")) {
                        strNextString7 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 639133141:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("response_info_extras_override") && ((Boolean) zzbiq.zzhL.zzg()).booleanValue()) {
                        try {
                            Bundle bundleZzl = com.google.android.gms.ads.internal.util.zzbp.zzl(com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader));
                            if (bundleZzl != null) {
                                bundle2 = bundleZzl;
                            }
                        } catch (IllegalStateException unused) {
                            jsonReader.skipValue();
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 754887508:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("container_sizes")) {
                        listZza = zzfkg.zza(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 791122864:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("impression_type")) {
                        iZzd = zzd(jsonReader.nextInt());
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 805095541:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("analytics_event_name_to_parameters_map") && ((Boolean) zzbiq.zzaO.zzg()).booleanValue()) {
                        mapZzc = com.google.android.gms.ads.internal.util.zzbp.zzc(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1010584092:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals(Constants.TRANSACTION_ID)) {
                        strNextString3 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1100650276:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("rewards")) {
                        zzccbVarZza = zzccb.zza(com.google.android.gms.ads.internal.util.zzbp.zze(jsonReader));
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1141602460:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("adapter_response_info_key")) {
                        strNextString19 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1186014765:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("cache_hit_urls")) {
                        com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1303622534:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("preload_sort_value")) {
                        dNextDouble = jsonReader.nextDouble();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1321720943:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("allow_pub_owned_ad_view")) {
                        zNextBoolean3 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1422388341:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_collapsible")) {
                        zNextBoolean18 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1437255331:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_source_id")) {
                        strNextString14 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1556932485:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("post_click_lifecycle_monitoring_duration_ms") && ((Boolean) zzbiq.zzop.zzg()).booleanValue()) {
                        iNextInt2 = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1565514205:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("adapter_only_third_party_impression")) {
                        zNextBoolean22 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1637553475:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("bid_response")) {
                        strNextString8 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1638957285:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("video_start_urls")) {
                        listZzb7 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1686319423:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("ad_network_class_name")) {
                        strNextString12 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1688341040:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("video_reward_urls")) {
                        listZzb8 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1799285870:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("use_third_party_container_height")) {
                        zNextBoolean12 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1839650832:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("renderers")) {
                        listZzb = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 1875425491:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("is_analytics_logging_enabled")) {
                        zNextBoolean10 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 2004337096:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("recursive_signal_collection")) {
                        jSONArrayZze = com.google.android.gms.ads.internal.util.zzbp.zze(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 2068142375:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("rule_line_external_id")) {
                        strNextString11 = jsonReader.nextString();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 2072888499:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("manual_tracking_urls")) {
                        listZzb2 = com.google.android.gms.ads.internal.util.zzbp.zzb(jsonReader);
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 2075506442:
                    list = listZzb11;
                    list2 = listZzb12;
                    if (str.equals("render_serially")) {
                        zNextBoolean20 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                case 2117205836:
                    list2 = listZzb12;
                    list = listZzb11;
                    if (str.equals("flow_control")) {
                        zNextBoolean21 = jsonReader.nextBoolean();
                    }
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
                default:
                    list = listZzb11;
                    list2 = listZzb12;
                    jsonReader.skipValue();
                    listZzb12 = list2;
                    listZzb11 = list;
                    break;
            }
        }
        jsonReader.endObject();
        this.zza = listZzb;
        this.zzb = iZzc;
        this.zzc = listZzb14;
        this.zzd = listZzb5;
        this.zzf = listZzb6;
        this.zze = iZzd;
        this.zzg = listZzb7;
        this.zzh = listZzb8;
        this.zzi = listZzb9;
        this.zzj = strNextString3;
        this.zzk = strNextString2;
        this.zzl = zzccbVarZza;
        this.zzm = listZzb10;
        this.zzn = listZzb11;
        this.zzo = listZzb12;
        this.zzp = listZzb2;
        this.zzq = iNextInt6;
        this.zzr = listZza;
        this.zzs = zzfkkVar;
        this.zzt = listZzb13;
        this.zzu = listZza2;
        this.zzw = strNextString4;
        this.zzv = jSONObjectZzd6;
        this.zzx = strNextString5;
        this.zzy = strNextString6;
        this.zzz = string;
        this.zzA = zzcdkVarZza;
        this.zzB = strNextString7;
        this.zzC = jSONObjectZzd;
        this.zzD = jSONObjectZzd2;
        this.zzJ = zNextBoolean2;
        this.zzK = zNextBoolean3;
        this.zzL = zNextBoolean4;
        this.zzM = zNextBoolean5;
        this.zzN = zNextBoolean6;
        this.zzO = zNextBoolean7;
        this.zzP = zNextBoolean8;
        this.zzQ = iZze;
        this.zzR = iNextInt3;
        this.zzT = zNextBoolean9;
        this.zzU = strNextString8;
        this.zzV = new zzflb(jSONObjectZzd3);
        this.zzW = zNextBoolean10;
        this.zzX = zNextBoolean11;
        this.zzY = iNextInt4;
        this.zzZ = strNextString9;
        this.zzaa = iNextInt;
        this.zzab = strNextString10;
        this.zzac = zNextBoolean12;
        this.zzad = zzbzhVarZza;
        this.zzae = zztVarZza;
        this.zzaf = strNextString11;
        this.zzag = zNextBoolean13;
        this.zzah = jSONObjectZzd4;
        this.zzE = strNextString12;
        this.zzF = strNextString13;
        this.zzG = strNextString14;
        this.zzH = strNextString15;
        this.zzI = strNextString16;
        this.zzai = zNextBoolean14;
        this.zzaj = jSONObjectZzd5;
        this.zzak = zNextBoolean15;
        this.zzal = strNextString;
        this.zzam = zNextBoolean16;
        this.zzS = zNextBoolean17;
        this.zzan = strNextString17;
        this.zzao = strNextString18;
        this.zzap = strNextString19;
        this.zzaq = zNextBoolean18;
        this.zzar = zNextBoolean19;
        this.zzas = iNextInt5;
        this.zzau = listZzb3;
        this.zzat = strNextString20;
        this.zzav = zNextBoolean20;
        this.zzaw = mapZzc;
        this.zzax = zzvVarZzb;
        this.zzay = zzwVarZzd;
        this.zzaz = dNextDouble;
        this.zzaI = iZza;
        this.zzaA = listZzb4;
        this.zzaB = zNextBoolean21;
        this.zzaC = zzgwmVarZza;
        this.zzaD = zNextBoolean22;
        this.zzaE = iNextInt2;
        this.zzaF = bundle2;
        this.zzaG = zNextBoolean;
        this.zzaH = jSONArrayZze;
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzc(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzd(int i) {
        if (i == 0 || i == 1 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    private static int zze(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }

    public final boolean zzb() {
        return this.zzai || this.zzay != null;
    }
}
