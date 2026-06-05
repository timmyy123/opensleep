package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class zzade extends zzvt implements zzadt {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private long zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private zznh zzF;
    private long zzG;
    private boolean zzH;
    private long zzI;
    private int zzJ;
    private long zzK;
    private zzbv zzL;
    private zzbv zzM;
    private int zzN;
    private int zzO;
    private zzadr zzP;
    private long zzQ;
    private long zzR;
    private boolean zzS;
    private int zzT;
    private final Context zze;
    private final boolean zzf;
    private final zzaeo zzg;
    private final boolean zzh;
    private final zzadu zzi;
    private final zzads zzj;
    private final zzacn zzk;
    private final long zzl;
    private final zzadv zzm;
    private final PriorityQueue zzn;
    private zzadd zzo;
    private boolean zzp;
    private boolean zzq;
    private zzaeu zzr;
    private boolean zzs;
    private int zzt;
    private List zzu;
    private Surface zzv;
    private zzadg zzw;
    private zzeu zzx;
    private boolean zzy;
    private int zzz;

    public zzade(zzadc zzadcVar) {
        super(zzadcVar.zze().getApplicationContext(), 2, zzadcVar.zzg(), zzadcVar.zzf(), false, 30.0f);
        Context applicationContext = zzadcVar.zze().getApplicationContext();
        this.zze = applicationContext;
        this.zzr = null;
        this.zzg = new zzaeo(zzadcVar.zzh(), zzadcVar.zzi());
        this.zzf = this.zzr == null;
        this.zzi = new zzadu(applicationContext, this, 0L);
        this.zzj = new zzads();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzx = zzeu.zza;
        this.zzz = 1;
        this.zzA = 0;
        this.zzL = zzbv.zza;
        this.zzO = 0;
        this.zzM = null;
        this.zzN = -1000;
        this.zzQ = -9223372036854775807L;
        this.zzR = -9223372036854775807L;
        this.zzk = new zzacn();
        this.zzn = new PriorityQueue();
        this.zzl = -15000L;
        this.zzm = new zzadv(1.0f);
        this.zzF = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r3.equals("video/x-vnd.on2.vp8") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
    
        if (r3.equals("video/mp4v-es") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
    
        if (r3.equals("video/av01") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c3, code lost:
    
        if (r3.equals("video/3gpp") != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzaw(zzvm zzvmVar, zzv zzvVar) {
        int i = zzvVar.zzw;
        int i2 = zzvVar.zzx;
        if (i != -1 && i2 != -1) {
            String str = zzvVar.zzp;
            str.getClass();
            if ("video/dolby-vision".equals(str)) {
                Pair pairZze = zzdq.zze(zzvVar);
                if (pairZze == null) {
                    str = "video/hevc";
                } else {
                    int iIntValue = ((Integer) pairZze.first).intValue();
                    if (iIntValue == 512 || iIntValue == 1 || iIntValue == 2) {
                        str = "video/avc";
                    } else if (iIntValue == 1024) {
                        str = "video/av01";
                    }
                }
            }
            int i3 = 4;
            switch (str.hashCode()) {
                case -1664118616:
                    break;
                case -1662735862:
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        return Math.max(2097152, ((i * i2) * 3) / 4);
                    }
                    break;
                case 1187890754:
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        String str2 = Build.MODEL;
                        if (!"BRAVIA 4K 2015".equals(str2) && (!"Amazon".equals(Build.MANUFACTURER) || (!"KFSOWI".equals(str2) && (!"AFTS".equals(str2) || !zzvmVar.zzf)))) {
                            String str3 = zzfl.zza;
                            return ((((i2 + 15) / 16) * ((i + 15) / 16)) * 768) / 4;
                        }
                    }
                    break;
                case 1599127256:
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        i3 = 8;
                        return ((i * i2) * 3) / i3;
                    }
                    break;
            }
        }
        return -1;
    }

    private final void zzbA() {
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            zzadgVar.release();
            this.zzw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzbB, reason: merged with bridge method [inline-methods] */
    public final void zzbo() {
        this.zzg.zzg(this.zzv);
        this.zzy = true;
    }

    private final void zzbC() {
        zzbv zzbvVar = this.zzM;
        if (zzbvVar != null) {
            this.zzg.zzf(zzbvVar);
        }
    }

    public static int zzbm(zzvm zzvmVar, zzv zzvVar) {
        int i = zzvVar.zzq;
        if (i == -1) {
            return zzaw(zzvmVar, zzvVar);
        }
        List list = zzvVar.zzs;
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return i + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0658 A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:509:0x0670, B:10:0x0013, B:12:0x001a, B:508:0x066c, B:43:0x0075, B:46:0x0080, B:78:0x00df, B:501:0x0658), top: B:514:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean zzbq(String str) {
        boolean z = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzade.class) {
            if (!zzc) {
                int i = Build.VERSION.SDK_INT;
                if (i <= 28) {
                    String str2 = Build.DEVICE;
                    switch (str2.hashCode()) {
                        case -1339091551:
                            if (!str2.equals("dangal")) {
                                if (i > 27 || !"HWEML".equals(Build.DEVICE)) {
                                    String str3 = Build.MODEL;
                                    switch (str3.hashCode()) {
                                        case -349662828:
                                            if (!str3.equals("AFTJMST12")) {
                                                if (i <= 26) {
                                                    String str4 = Build.DEVICE;
                                                    switch (str4.hashCode()) {
                                                        case -2144781245:
                                                            if (!str4.equals("GIONEE_SWW1609")) {
                                                                if (str3.hashCode() == -594534941 && str3.equals("JSN-L21")) {
                                                                }
                                                            }
                                                            break;
                                                        case -2144781185:
                                                            if (str4.equals("GIONEE_SWW1627")) {
                                                            }
                                                            break;
                                                        case -2144781160:
                                                            if (str4.equals("GIONEE_SWW1631")) {
                                                            }
                                                            break;
                                                        case -2097309513:
                                                            if (str4.equals("K50a40")) {
                                                            }
                                                            break;
                                                        case -2022874474:
                                                            if (str4.equals("CP8676_I02")) {
                                                            }
                                                            break;
                                                        case -1978993182:
                                                            if (str4.equals("NX541J")) {
                                                            }
                                                            break;
                                                        case -1978990237:
                                                            if (str4.equals("NX573J")) {
                                                            }
                                                            break;
                                                        case -1936688988:
                                                            if (str4.equals("PGN528")) {
                                                            }
                                                            break;
                                                        case -1936688066:
                                                            if (str4.equals("PGN610")) {
                                                            }
                                                            break;
                                                        case -1936688065:
                                                            if (str4.equals("PGN611")) {
                                                            }
                                                            break;
                                                        case -1931988508:
                                                            if (str4.equals("AquaPowerM")) {
                                                            }
                                                            break;
                                                        case -1885099851:
                                                            if (str4.equals("RAIJIN")) {
                                                            }
                                                            break;
                                                        case -1696512866:
                                                            if (str4.equals("XT1663")) {
                                                            }
                                                            break;
                                                        case -1680025915:
                                                            if (str4.equals("ComioS1")) {
                                                            }
                                                            break;
                                                        case -1615810839:
                                                            if (str4.equals("Phantom6")) {
                                                            }
                                                            break;
                                                        case -1600724499:
                                                            if (str4.equals("pacificrim")) {
                                                            }
                                                            break;
                                                        case -1554255044:
                                                            if (str4.equals("vernee_M5")) {
                                                            }
                                                            break;
                                                        case -1481772737:
                                                            if (str4.equals("panell_dl")) {
                                                            }
                                                            break;
                                                        case -1481772730:
                                                            if (str4.equals("panell_ds")) {
                                                            }
                                                            break;
                                                        case -1481772729:
                                                            if (str4.equals("panell_dt")) {
                                                            }
                                                            break;
                                                        case -1320080169:
                                                            if (str4.equals("GiONEE_GBL7319")) {
                                                            }
                                                            break;
                                                        case -1217592143:
                                                            if (str4.equals("BRAVIA_ATV2")) {
                                                            }
                                                            break;
                                                        case -1180384755:
                                                            if (str4.equals("iris60")) {
                                                            }
                                                            break;
                                                        case -1139198265:
                                                            if (str4.equals("Slate_Pro")) {
                                                            }
                                                            break;
                                                        case -1052835013:
                                                            if (str4.equals("namath")) {
                                                            }
                                                            break;
                                                        case -993250464:
                                                            if (str4.equals("A10-70F")) {
                                                            }
                                                            break;
                                                        case -993250458:
                                                            if (str4.equals("A10-70L")) {
                                                            }
                                                            break;
                                                        case -965403638:
                                                            if (str4.equals("s905x018")) {
                                                            }
                                                            break;
                                                        case -958336948:
                                                            if (str4.equals("ELUGA_Ray_X")) {
                                                            }
                                                            break;
                                                        case -879245230:
                                                            if (str4.equals("tcl_eu")) {
                                                            }
                                                            break;
                                                        case -842500323:
                                                            if (str4.equals("nicklaus_f")) {
                                                            }
                                                            break;
                                                        case -821392978:
                                                            if (str4.equals("A7000-a")) {
                                                            }
                                                            break;
                                                        case -797483286:
                                                            if (str4.equals("SVP-DTV15")) {
                                                            }
                                                            break;
                                                        case -794946968:
                                                            if (str4.equals("watson")) {
                                                            }
                                                            break;
                                                        case -788334647:
                                                            if (str4.equals("whyred")) {
                                                            }
                                                            break;
                                                        case -782144577:
                                                            if (str4.equals("OnePlus5T")) {
                                                            }
                                                            break;
                                                        case -575125681:
                                                            if (str4.equals("GiONEE_CBL7513")) {
                                                            }
                                                            break;
                                                        case -521118391:
                                                            if (str4.equals("GIONEE_GBL7360")) {
                                                            }
                                                            break;
                                                        case -430914369:
                                                            if (str4.equals("Pixi4-7_3G")) {
                                                            }
                                                            break;
                                                        case -290434366:
                                                            if (str4.equals("taido_row")) {
                                                            }
                                                            break;
                                                        case -282781963:
                                                            if (str4.equals("BLACK-1X")) {
                                                            }
                                                            break;
                                                        case -277133239:
                                                            if (str4.equals("Z12_PRO")) {
                                                            }
                                                            break;
                                                        case -173639913:
                                                            if (str4.equals("ELUGA_A3_Pro")) {
                                                            }
                                                            break;
                                                        case -56598463:
                                                            if (str4.equals("woods_fn")) {
                                                            }
                                                            break;
                                                        case 2126:
                                                            if (str4.equals("C1")) {
                                                            }
                                                            break;
                                                        case 2564:
                                                            if (str4.equals("Q5")) {
                                                            }
                                                            break;
                                                        case 2715:
                                                            if (str4.equals("V1")) {
                                                            }
                                                            break;
                                                        case 2719:
                                                            if (str4.equals("V5")) {
                                                            }
                                                            break;
                                                        case 3091:
                                                            if (str4.equals("b5")) {
                                                            }
                                                            break;
                                                        case 3483:
                                                            if (str4.equals("mh")) {
                                                            }
                                                            break;
                                                        case 73405:
                                                            if (str4.equals("JGZ")) {
                                                            }
                                                            break;
                                                        case 75537:
                                                            if (str4.equals("M04")) {
                                                            }
                                                            break;
                                                        case 75739:
                                                            if (str4.equals("M5c")) {
                                                            }
                                                            break;
                                                        case 76779:
                                                            if (str4.equals("MX6")) {
                                                            }
                                                            break;
                                                        case 78669:
                                                            if (str4.equals("P85")) {
                                                            }
                                                            break;
                                                        case 79305:
                                                            if (str4.equals("PLE")) {
                                                            }
                                                            break;
                                                        case 80618:
                                                            if (str4.equals("QX1")) {
                                                            }
                                                            break;
                                                        case 88274:
                                                            if (str4.equals("Z80")) {
                                                            }
                                                            break;
                                                        case 98846:
                                                            if (str4.equals("cv1")) {
                                                            }
                                                            break;
                                                        case 98848:
                                                            if (str4.equals("cv3")) {
                                                            }
                                                            break;
                                                        case 99329:
                                                            if (str4.equals("deb")) {
                                                            }
                                                            break;
                                                        case 101481:
                                                            if (str4.equals("flo")) {
                                                            }
                                                            break;
                                                        case 1513190:
                                                            if (str4.equals("1601")) {
                                                            }
                                                            break;
                                                        case 1514184:
                                                            if (str4.equals("1713")) {
                                                            }
                                                            break;
                                                        case 1514185:
                                                            if (str4.equals("1714")) {
                                                            }
                                                            break;
                                                        case 2133089:
                                                            if (str4.equals("F01H")) {
                                                            }
                                                            break;
                                                        case 2133091:
                                                            if (str4.equals("F01J")) {
                                                            }
                                                            break;
                                                        case 2133120:
                                                            if (str4.equals("F02H")) {
                                                            }
                                                            break;
                                                        case 2133151:
                                                            if (str4.equals("F03H")) {
                                                            }
                                                            break;
                                                        case 2133182:
                                                            if (str4.equals("F04H")) {
                                                            }
                                                            break;
                                                        case 2133184:
                                                            if (str4.equals("F04J")) {
                                                            }
                                                            break;
                                                        case 2436959:
                                                            if (str4.equals("P681")) {
                                                            }
                                                            break;
                                                        case 2463773:
                                                            if (str4.equals("Q350")) {
                                                            }
                                                            break;
                                                        case 2464648:
                                                            if (str4.equals("Q427")) {
                                                            }
                                                            break;
                                                        case 2689555:
                                                            if (str4.equals("XE2X")) {
                                                            }
                                                            break;
                                                        case 3154429:
                                                            if (str4.equals("fugu")) {
                                                            }
                                                            break;
                                                        case 3284551:
                                                            if (str4.equals("kate")) {
                                                            }
                                                            break;
                                                        case 3351335:
                                                            if (str4.equals("mido")) {
                                                            }
                                                            break;
                                                        case 3386211:
                                                            if (str4.equals("p212")) {
                                                            }
                                                            break;
                                                        case 41325051:
                                                            if (str4.equals("MEIZU_M5")) {
                                                            }
                                                            break;
                                                        case 51349633:
                                                            if (str4.equals("601LV")) {
                                                            }
                                                            break;
                                                        case 51350594:
                                                            if (str4.equals("602LV")) {
                                                            }
                                                            break;
                                                        case 55178625:
                                                            if (str4.equals("Aura_Note_2")) {
                                                            }
                                                            break;
                                                        case 61542055:
                                                            if (str4.equals("A1601")) {
                                                            }
                                                            break;
                                                        case 65355429:
                                                            if (str4.equals("E5643")) {
                                                            }
                                                            break;
                                                        case 66214468:
                                                            if (str4.equals("F3111")) {
                                                            }
                                                            break;
                                                        case 66214470:
                                                            if (str4.equals("F3113")) {
                                                            }
                                                            break;
                                                        case 66214473:
                                                            if (str4.equals("F3116")) {
                                                            }
                                                            break;
                                                        case 66215429:
                                                            if (str4.equals("F3211")) {
                                                            }
                                                            break;
                                                        case 66215431:
                                                            if (str4.equals("F3213")) {
                                                            }
                                                            break;
                                                        case 66215433:
                                                            if (str4.equals("F3215")) {
                                                            }
                                                            break;
                                                        case 66216390:
                                                            if (str4.equals("F3311")) {
                                                            }
                                                            break;
                                                        case 76402249:
                                                            if (str4.equals("PRO7S")) {
                                                            }
                                                            break;
                                                        case 76404105:
                                                            if (str4.equals("Q4260")) {
                                                            }
                                                            break;
                                                        case 76404911:
                                                            if (str4.equals("Q4310")) {
                                                            }
                                                            break;
                                                        case 80963634:
                                                            if (str4.equals("V23GB")) {
                                                            }
                                                            break;
                                                        case 82882791:
                                                            if (str4.equals("X3_HK")) {
                                                            }
                                                            break;
                                                        case 98715550:
                                                            if (str4.equals("i9031")) {
                                                            }
                                                            break;
                                                        case 101370885:
                                                            if (str4.equals("l5460")) {
                                                            }
                                                            break;
                                                        case 102844228:
                                                            if (str4.equals("le_x6")) {
                                                            }
                                                            break;
                                                        case 165221241:
                                                            if (str4.equals("A2016a40")) {
                                                            }
                                                            break;
                                                        case 182191441:
                                                            if (str4.equals("CPY83_I00")) {
                                                            }
                                                            break;
                                                        case 245388979:
                                                            if (str4.equals("marino_f")) {
                                                            }
                                                            break;
                                                        case 287431619:
                                                            if (str4.equals("griffin")) {
                                                            }
                                                            break;
                                                        case 307593612:
                                                            if (str4.equals("A7010a48")) {
                                                            }
                                                            break;
                                                        case 308517133:
                                                            if (str4.equals("A7020a48")) {
                                                            }
                                                            break;
                                                        case 316215098:
                                                            if (str4.equals("TB3-730F")) {
                                                            }
                                                            break;
                                                        case 316215116:
                                                            if (str4.equals("TB3-730X")) {
                                                            }
                                                            break;
                                                        case 316246811:
                                                            if (str4.equals("TB3-850F")) {
                                                            }
                                                            break;
                                                        case 316246818:
                                                            if (str4.equals("TB3-850M")) {
                                                            }
                                                            break;
                                                        case 407160593:
                                                            if (str4.equals("Pixi5-10_4G")) {
                                                            }
                                                            break;
                                                        case 507412548:
                                                            if (str4.equals("QM16XE_U")) {
                                                            }
                                                            break;
                                                        case 793982701:
                                                            if (str4.equals("GIONEE_WBL5708")) {
                                                            }
                                                            break;
                                                        case 794038622:
                                                            if (str4.equals("GIONEE_WBL7365")) {
                                                            }
                                                            break;
                                                        case 794040393:
                                                            if (str4.equals("GIONEE_WBL7519")) {
                                                            }
                                                            break;
                                                        case 835649806:
                                                            if (str4.equals("manning")) {
                                                            }
                                                            break;
                                                        case 917340916:
                                                            if (str4.equals("A7000plus")) {
                                                            }
                                                            break;
                                                        case 958008161:
                                                            if (str4.equals("j2xlteins")) {
                                                            }
                                                            break;
                                                        case 1060579533:
                                                            if (str4.equals("panell_d")) {
                                                            }
                                                            break;
                                                        case 1150207623:
                                                            if (str4.equals("LS-5017")) {
                                                            }
                                                            break;
                                                        case 1176899427:
                                                            if (str4.equals("itel_S41")) {
                                                            }
                                                            break;
                                                        case 1280332038:
                                                            if (str4.equals("hwALE-H")) {
                                                            }
                                                            break;
                                                        case 1306947716:
                                                            if (str4.equals("EverStar_S")) {
                                                            }
                                                            break;
                                                        case 1349174697:
                                                            if (str4.equals("htc_e56ml_dtul")) {
                                                            }
                                                            break;
                                                        case 1522194893:
                                                            if (str4.equals("woods_f")) {
                                                            }
                                                            break;
                                                        case 1691543273:
                                                            if (str4.equals("CPH1609")) {
                                                            }
                                                            break;
                                                        case 1691544261:
                                                            if (str4.equals("CPH1715")) {
                                                            }
                                                            break;
                                                        case 1709443163:
                                                            if (str4.equals("iball8735_9806")) {
                                                            }
                                                            break;
                                                        case 1865889110:
                                                            if (str4.equals("santoni")) {
                                                            }
                                                            break;
                                                        case 1906253259:
                                                            if (str4.equals("PB2-670M")) {
                                                            }
                                                            break;
                                                        case 1977196784:
                                                            if (str4.equals("Infinix-X572")) {
                                                            }
                                                            break;
                                                        case 2006372676:
                                                            if (str4.equals("BRAVIA_ATV3_4K")) {
                                                            }
                                                            break;
                                                        case 2019281702:
                                                            if (str4.equals("DM-01K")) {
                                                            }
                                                            break;
                                                        case 2029784656:
                                                            if (str4.equals("HWBLN-H")) {
                                                            }
                                                            break;
                                                        case 2030379515:
                                                            if (str4.equals("HWCAM-H")) {
                                                            }
                                                            break;
                                                        case 2033393791:
                                                            if (str4.equals("ASUS_X00AD_2")) {
                                                            }
                                                            break;
                                                        case 2047190025:
                                                            if (str4.equals("ELUGA_Note")) {
                                                            }
                                                            break;
                                                        case 2047252157:
                                                            if (str4.equals("ELUGA_Prim")) {
                                                            }
                                                            break;
                                                        case 2048319463:
                                                            if (str4.equals("HWVNS-H")) {
                                                            }
                                                            break;
                                                        case 2048855701:
                                                            if (str4.equals("HWWAS-H")) {
                                                            }
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case -321033677:
                                            if (str3.equals("AFTKMST12")) {
                                            }
                                            break;
                                        case 2006354:
                                            if (str3.equals("AFTA")) {
                                            }
                                            break;
                                        case 2006367:
                                            if (str3.equals("AFTN")) {
                                            }
                                            break;
                                        case 2006371:
                                            if (str3.equals("AFTR")) {
                                            }
                                            break;
                                        case 1785421873:
                                            if (str3.equals("AFTEU011")) {
                                            }
                                            break;
                                        case 1785421876:
                                            if (str3.equals("AFTEU014")) {
                                            }
                                            break;
                                        case 1798172390:
                                            if (str3.equals("AFTSO001")) {
                                            }
                                            break;
                                        case 2119412532:
                                            if (str3.equals("AFTEUFF014")) {
                                            }
                                            break;
                                    }
                                }
                                z = true;
                            } else {
                                z = true;
                            }
                            break;
                        case -1220081023:
                            if (str2.equals("dangalFHD")) {
                            }
                            break;
                        case -1220066608:
                            if (str2.equals("dangalUHD")) {
                            }
                            break;
                        case -1012436106:
                            if (str2.equals("oneday")) {
                            }
                            break;
                        case -760312546:
                            if (str2.equals("aquaman")) {
                            }
                            break;
                        case -64886864:
                            if (str2.equals("magnolia")) {
                            }
                            break;
                        case 3415681:
                            if (str2.equals("once")) {
                            }
                            break;
                        case 825323514:
                            if (str2.equals("machuca")) {
                            }
                            break;
                    }
                    zzd = z;
                    zzc = true;
                }
            }
        }
        return zzd;
    }

    public static final boolean zzbr(zzvm zzvmVar) {
        return Build.VERSION.SDK_INT >= 35 && zzvmVar.zzh;
    }

    private static List zzbs(Context context, zzvv zzvvVar, zzv zzvVar, boolean z, boolean z2) {
        String str = zzvVar.zzp;
        if (str == null) {
            return zzgwm.zzi();
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzadb.zza(context)) {
            List listZzd = zzwf.zzd(zzvvVar, zzvVar, z, z2);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zzwf.zzc(zzvvVar, zzvVar, z, z2);
    }

    private final void zzbt(zzxk zzxkVar) {
        int iZze;
        zzbf zzbfVarZzN = zzN();
        if (zzbfVarZzN.zzg() || (iZze = zzbfVarZzN.zze(zzxkVar.zza)) == -1) {
            this.zzR = -9223372036854775807L;
        } else {
            this.zzR = zzbfVarZzN.zzd(iZze, new zzbd(), false).zzd;
        }
    }

    private final void zzbu(Object obj) throws zzjk {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzv == surface) {
            if (surface != null) {
                zzbC();
                Surface surface2 = this.zzv;
                if (surface2 == null || !this.zzy) {
                    return;
                }
                this.zzg.zzg(surface2);
                return;
            }
            return;
        }
        this.zzv = surface;
        if (this.zzr == null) {
            this.zzi.zzd(surface);
        }
        this.zzy = false;
        int iZze = zze();
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null && this.zzr == null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (!zzby(zzvmVarZzaL) || this.zzp) {
                zzaM();
                zzaE();
            } else {
                Surface surfaceZzbz = zzbz(zzvmVarZzaL);
                if (surfaceZzbz != null) {
                    zzvjVarZzaI.zzn(surfaceZzbz);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        Home$$ExternalSyntheticBUOutline0.m$2();
                        return;
                    }
                    zzvjVarZzaI.zzo();
                }
            }
        }
        if (surface != null) {
            zzbC();
        } else {
            this.zzM = null;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzq();
            }
        }
        if (iZze == 2) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(true);
            } else {
                this.zzi.zzj(true);
            }
        }
    }

    private final boolean zzbv(zziv zzivVar) {
        if (zzcW() || zzivVar.zzd() || this.zzR == -9223372036854775807L) {
            return true;
        }
        return this.zzR - (zzivVar.zze - zzbg()) <= 100000;
    }

    private final boolean zzbw(zziv zzivVar) {
        return zzivVar.zze < zzH();
    }

    private final void zzbx(long j, long j2, zzv zzvVar) {
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            zzadrVar.zzcS(j, j2, zzvVar, zzaK());
        }
    }

    private final boolean zzby(zzvm zzvmVar) {
        if (this.zzr != null) {
            return true;
        }
        Surface surface = this.zzv;
        return (surface != null && surface.isValid()) || zzbr(zzvmVar) || zzaC(zzvmVar);
    }

    private final Surface zzbz(zzvm zzvmVar) {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzk();
        }
        Surface surface = this.zzv;
        if (surface != null) {
            return surface;
        }
        if (zzbr(zzvmVar)) {
            return null;
        }
        zzgtj.zzi(zzaC(zzvmVar));
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            if (zzadgVar.zza != zzvmVar.zzf) {
                zzbA();
            }
        }
        if (this.zzw == null) {
            this.zzw = zzadg.zzb(this.zze, zzvmVar.zzf);
        }
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzA(long j, boolean z, boolean z2) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null && !z) {
            zzaeuVar.zzg(true);
        }
        if (z2) {
            this.zzG = j;
        }
        super.zzA(j, z, z2);
        if (this.zzr == null) {
            this.zzi.zzl();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        if (z) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(false);
            } else {
                this.zzi.zzj(false);
            }
        }
        this.zzD = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzB() {
        this.zzC = 0;
        this.zzB = zzM().zzb();
        this.zzI = 0L;
        this.zzJ = 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zza();
        } else {
            this.zzi.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzC() {
        if (this.zzC > 0) {
            long jZzb = zzM().zzb();
            this.zzg.zzd(this.zzC, jZzb - this.zzB);
            this.zzC = 0;
            this.zzB = jZzb;
        }
        int i = this.zzJ;
        if (i != 0) {
            this.zzg.zze(this.zzI, i);
            this.zzI = 0L;
            this.zzJ = 0;
        }
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzb();
        } else {
            this.zzi.zzc();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzD() {
        this.zzM = null;
        this.zzR = -9223372036854775807L;
        this.zzy = false;
        this.zzH = true;
        try {
            super.zzD();
        } finally {
            zzaeo zzaeoVar = this.zzg;
            zzaeoVar.zzi(((zzvt) this).zza);
            zzaeoVar.zzf(zzbv.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzE() {
        try {
            super.zzE();
        } finally {
            this.zzs = false;
            this.zzQ = -9223372036854775807L;
            zzbA();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzF() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzf) {
            return;
        }
        zzaeuVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzix
    public final void zzG(zzbf zzbfVar) {
        zzxk zzxkVarZzO = zzO();
        if (zzxkVarZzO != null) {
            zzbt(zzxkVarZzO);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzW(long j) {
        if (zzbf() == -9223372036854775807L || j < this.zzG) {
            return false;
        }
        long jZzaY = zzaY();
        return jZzaY == -9223372036854775807L || j > jZzaY;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzX(float f, float f2) throws zzjk {
        super.zzX(f, f2);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzm(f);
        } else {
            this.zzi.zzn(f);
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzc(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzY() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            this.zzi.zzh();
            return;
        }
        int i = this.zzt;
        if (i == 0 || i == 1) {
            this.zzt = 0;
        } else {
            zzaeuVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzZ(long j, long j2) throws Throwable {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            try {
                zzaeuVar.zzv(j, j2);
            } catch (zzaet e) {
                throw zzP(e, e.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
        super.zzZ(j, j2);
    }

    public final void zzaA(long j) {
        zzjb zzjbVar = ((zzvt) this).zza;
        zzjbVar.zzk += j;
        zzjbVar.zzl++;
        this.zzI += j;
        this.zzJ++;
    }

    public final void zzaB(zzvj zzvjVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzvjVar.zzd(i, j2);
        Trace.endSection();
        ((zzvt) this).zza.zze++;
        this.zzD = 0;
        if (this.zzr == null) {
            zzbv zzbvVar = this.zzL;
            if (!zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzM)) {
                this.zzM = zzbvVar;
                this.zzg.zzf(zzbvVar);
            }
            if (!this.zzi.zzf() || this.zzv == null) {
                return;
            }
            zzbo();
        }
    }

    public final boolean zzaC(zzvm zzvmVar) {
        if (zzbq(zzvmVar.zza)) {
            return false;
        }
        return !zzvmVar.zzf || zzadg.zza(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final boolean zzaG(zzvm zzvmVar) {
        return zzby(zzvmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final boolean zzaO() {
        zzvm zzvmVarZzaL = zzaL();
        if (this.zzr != null && zzvmVarZzaL != null) {
            String str = zzvmVarZzaL.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaO();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzaP() {
        boolean z;
        zzv zzvVarZzaJ = zzaJ();
        long j = this.zzR;
        if (j != -9223372036854775807L) {
            z = zzaQ() + (j + 1) > Long.MAX_VALUE - (zzbg() + this.zzR);
        }
        return this.zzF == null || this.zzH || (zzvVarZzaJ != null && zzvVarZzaJ.zzr > 0) || z || zzbe() != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzaR() {
        super.zzaR();
        this.zzn.clear();
        this.zzE = 0;
        this.zzT = 0;
        this.zzH = false;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzacnVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzacy(th, zzvmVar, this.zzv);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final boolean zzaU(zzv zzvVar) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || zzaeuVar.zze()) {
            return true;
        }
        try {
            zzaeuVar.zzd(zzvVar);
            return true;
        } catch (zzaet e) {
            throw zzP(e, zzvVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzaV(zziv zzivVar) {
        ByteBuffer byteBuffer;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (zzvmVarZzaL.zzb.equals("video/av01") && zzivVar.zzc() && (byteBuffer = zzivVar.zzc) != null) {
                zzacnVar.zzb(byteBuffer);
            }
        }
        this.zzT = 0;
        int iZzaW = zzaW(zzivVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzaW & 32) == 0) {
            this.zzE++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final int zzaW(zziv zzivVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzF == null || !zzbw(zzivVar) || zzbv(zzivVar)) ? 0 : 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0098  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzaX(zziv zzivVar) {
        boolean z;
        ByteBuffer byteBuffer;
        boolean z2 = false;
        if (zzbv(zzivVar)) {
            return false;
        }
        boolean zZzbw = zzbw(zzivVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            long jZzb = zzadvVar.zzb(zzivVar.zze);
            z = jZzb != -9223372036854775807L && jZzb < this.zzl;
        }
        if ((!zZzbw && !z) || zzivVar.zze()) {
            return false;
        }
        if (!zzivVar.zzf()) {
            zzacn zzacnVar = this.zzk;
            if (zzacnVar != null) {
                zzvm zzvmVarZzaL = zzaL();
                zzvmVarZzaL.getClass();
                if (zzvmVarZzaL.zzb.equals("video/av01") && (byteBuffer = zzivVar.zzc) != null) {
                    boolean z3 = zZzbw || this.zzT <= 0;
                    ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                    byteBufferAsReadOnlyBuffer.flip();
                    int iZza = zzacnVar.zza(byteBufferAsReadOnlyBuffer, z3);
                    if (iZza == 0) {
                        zzivVar.zza();
                    } else if (iZza != byteBufferAsReadOnlyBuffer.limit()) {
                        zzadd zzaddVar = this.zzo;
                        zzaddVar.getClass();
                        if (zzaddVar.zzc + iZza < byteBufferAsReadOnlyBuffer.capacity() && !zzivVar.zzk()) {
                            ByteBuffer byteBuffer2 = zzivVar.zzc;
                            byteBuffer2.getClass();
                            byteBuffer2.position(iZza);
                        }
                    }
                }
            }
            if (z2) {
                if (zZzbw) {
                    ((zzvt) this).zza.zzd++;
                    return z2;
                }
                this.zzn.add(Long.valueOf(zzivVar.zze));
                this.zzT++;
            }
            return z2;
        }
        zzivVar.zza();
        z2 = true;
        if (z2) {
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzaZ(long j) {
        super.zzaZ(j);
        this.zzE--;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzaa() {
        boolean zZzba = zzba();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzh(zZzba);
        }
        if (zZzba && zzaI() == null) {
            return true;
        }
        return this.zzi.zzi(zZzba);
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzab() {
        if (!super.zzab()) {
            return false;
        }
        zzaeu zzaeuVar = this.zzr;
        return zzaeuVar == null || zzaeuVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final int zzae(zzvv zzvvVar, zzv zzvVar) {
        boolean z;
        String str = zzvVar.zzp;
        if (!zzas.zzb(str)) {
            return 128;
        }
        Context context = this.zze;
        int i = 0;
        boolean z2 = zzvVar.zzt != null;
        List listZzbs = zzbs(context, zzvvVar, zzvVar, z2, false);
        if (z2 && listZzbs.isEmpty()) {
            listZzbs = zzbs(context, zzvvVar, zzvVar, false, false);
        }
        if (listZzbs.isEmpty()) {
            return 129;
        }
        if (!zzvt.zzbj(zzvVar)) {
            return 130;
        }
        zzvm zzvmVar = (zzvm) listZzbs.get(0);
        boolean zZzc = zzvmVar.zzc(context, zzvVar);
        if (zZzc) {
            z = true;
        } else {
            for (int i2 = 1; i2 < listZzbs.size(); i2++) {
                zzvm zzvmVar2 = (zzvm) listZzbs.get(i2);
                if (zzvmVar2.zzc(context, zzvVar)) {
                    zZzc = true;
                    z = false;
                    zzvmVar = zzvmVar2;
                    break;
                }
            }
            z = true;
        }
        int i3 = true != zZzc ? 3 : 4;
        int i4 = true != zzvmVar.zze(zzvVar) ? 8 : 16;
        int i5 = true != zzvmVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !zzadb.zza(context)) {
            i6 = 256;
        }
        if (zZzc) {
            List listZzbs2 = zzbs(context, zzvvVar, zzvVar, z2, true);
            if (!listZzbs2.isEmpty()) {
                zzvm zzvmVar3 = (zzvm) zzwf.zze(context, listZzbs2, zzvVar).get(0);
                if (zzvmVar3.zzc(context, zzvVar) && zzvmVar3.zze(zzvVar)) {
                    i = 32;
                }
            }
        }
        return i3 | i4 | i | i5 | i6;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z) {
        Context context = this.zze;
        return zzwf.zze(context, zzbs(context, zzvvVar, zzvVar, false, false), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f) {
        zzadd zzaddVar;
        Point pointZzi;
        int i;
        int i2;
        int i3;
        boolean z;
        zzv[] zzvVarArr;
        byte b;
        boolean z2;
        Pair pairZze;
        int iZzaw;
        zzv[] zzvVarArrZzJ = zzJ();
        int length = zzvVarArrZzJ.length;
        int iZzbm = zzbm(zzvmVar, zzvVar);
        int i4 = zzvVar.zzx;
        int i5 = zzvVar.zzw;
        if (length == 1) {
            if (iZzbm != -1 && (iZzaw = zzaw(zzvmVar, zzvVar)) != -1) {
                iZzbm = Math.min((int) (iZzbm * 1.5f), iZzaw);
            }
            zzaddVar = new zzadd(i5, i4, iZzbm);
        } else {
            int iMax = i4;
            int iMax2 = i5;
            int i6 = 0;
            boolean z3 = false;
            while (i6 < length) {
                zzv zzvVarZzO = zzvVarArrZzJ[i6];
                zzi zziVar = zzvVar.zzF;
                if (zziVar != null && zzvVarZzO.zzF == null) {
                    zzt zztVarZza = zzvVarZzO.zza();
                    zztVarZza.zzE(zziVar);
                    zzvVarZzO = zztVarZza.zzO();
                }
                if (zzvmVar.zzf(zzvVar, zzvVarZzO).zzd != 0) {
                    int i7 = zzvVarZzO.zzw;
                    b = -1;
                    if (i7 != -1) {
                        zzvVarArr = zzvVarArrZzJ;
                        if (zzvVarZzO.zzx != -1) {
                            z2 = false;
                        }
                        z3 |= z2;
                        iMax2 = Math.max(iMax2, i7);
                        iMax = Math.max(iMax, zzvVarZzO.zzx);
                        iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                    } else {
                        zzvVarArr = zzvVarArrZzJ;
                    }
                    z2 = true;
                    z3 |= z2;
                    iMax2 = Math.max(iMax2, i7);
                    iMax = Math.max(iMax, zzvVarZzO.zzx);
                    iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                } else {
                    zzvVarArr = zzvVarArrZzJ;
                    b = -1;
                }
                i6++;
                zzvVarArrZzJ = zzvVarArr;
            }
            if (z3) {
                zzeg.zzc("MediaCodecVideoRenderer", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iMax2).length() + 44 + String.valueOf(iMax).length()), iMax2, "Resolutions unknown. Codec max resolution: ", iMax, "x"));
                boolean z4 = i4 > i5;
                int i8 = z4 ? i4 : i5;
                int i9 = true != z4 ? i4 : i5;
                int[] iArr = zzb;
                int i10 = 0;
                while (i10 < 9) {
                    float f2 = i9;
                    float f3 = i8;
                    int i11 = iArr[i10];
                    int i12 = i10;
                    float f4 = i11;
                    if (i11 <= i8 || (i = (int) (f4 * (f2 / f3))) <= i9) {
                        break;
                    }
                    int i13 = i8;
                    if (true != z4) {
                        i2 = i9;
                        i3 = i11;
                    } else {
                        i2 = i9;
                        i3 = i;
                    }
                    if (true != z4) {
                        i11 = i;
                    }
                    pointZzi = zzvmVar.zzi(i3, i11);
                    float f5 = zzvVar.zzA;
                    if (pointZzi != null) {
                        z = z4;
                        if (zzvmVar.zzg(pointZzi.x, pointZzi.y, f5)) {
                            break;
                        }
                    } else {
                        z = z4;
                    }
                    i10 = i12 + 1;
                    i8 = i13;
                    i9 = i2;
                    z4 = z;
                }
                pointZzi = null;
                if (pointZzi != null) {
                    iMax2 = Math.max(iMax2, pointZzi.x);
                    iMax = Math.max(iMax, pointZzi.y);
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzv(iMax2);
                    zztVarZza2.zzw(iMax);
                    iZzbm = Math.max(iZzbm, zzaw(zzvmVar, zztVarZza2.zzO()));
                    zzeg.zzc("MediaCodecVideoRenderer", zzba$$ExternalSyntheticOutline0.m(new StringBuilder(zzba$$ExternalSyntheticOutline0.m(iMax2, 35) + String.valueOf(iMax).length()), iMax2, "Codec max resolution adjusted to: ", iMax, "x"));
                }
            }
            zzaddVar = new zzadd(iMax2, iMax, iZzbm);
        }
        String str = zzvmVar.zzc;
        this.zzo = zzaddVar;
        boolean z5 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i5);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4);
        zzej.zza(mediaFormat, zzvVar.zzs);
        float f6 = zzvVar.zzA;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzej.zzb(mediaFormat, "rotation-degrees", zzvVar.zzB);
        zzi zziVar2 = zzvVar.zzF;
        if (zziVar2 != null) {
            zzej.zzb(mediaFormat, "color-transfer", zziVar2.zzd);
            zzej.zzb(mediaFormat, "color-standard", zziVar2.zzb);
            zzej.zzb(mediaFormat, "color-range", zziVar2.zzc);
            byte[] bArr = zziVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzvVar.zzp) && (pairZze = zzdq.zze(zzvVar)) != null) {
            zzej.zzb(mediaFormat, "profile", ((Integer) pairZze.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzaddVar.zza);
        mediaFormat.setInteger("max-height", zzaddVar.zzb);
        zzej.zzb(mediaFormat, "max-input-size", zzaddVar.zzc);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzN));
        }
        zzbi(mediaFormat);
        Surface surfaceZzbz = zzbz(zzvmVar);
        if (this.zzr != null && !zzfl.zzU(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zzvg.zzb(zzvmVar, mediaFormat, zzvVar, surfaceZzbz, null);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        int i;
        int i2;
        int i3;
        zzjc zzjcVarZzf = zzvmVar.zzf(zzvVar, zzvVar2);
        int i4 = zzjcVarZzf.zze;
        zzadd zzaddVar = this.zzo;
        zzaddVar.getClass();
        if (zzvVar2.zzw > zzaddVar.zza || zzvVar2.zzx > zzaddVar.zzb) {
            i4 |= 256;
        }
        if (zzbm(zzvmVar, zzvVar2) > zzaddVar.zzc) {
            i4 |= 64;
        }
        if (this.zzA != Integer.MIN_VALUE) {
            float f = zzvVar.zzA;
            if (f != -1.0f) {
                float f2 = zzvVar2.zzA;
                if (f2 != -1.0f && Math.abs(f2 - f) > 1.0f && ((i3 = Build.VERSION.SDK_INT) < 30 || (i3 == 30 && Build.MODEL.startsWith("MiTV")))) {
                    i4 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                }
            }
        }
        String str = zzvmVar.zza;
        if (i4 != 0) {
            i2 = 0;
            i = i4;
        } else {
            i = 0;
            i2 = zzjcVarZzf.zzd;
        }
        return new zzjc(str, zzvVar, zzvVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final float zzak(float f, zzv zzvVar, zzv[] zzvVarArr) {
        zzvm zzvmVarZzaL;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f2 = zzvVar2.zzA;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.zzF == null || (zzvmVarZzaL = zzaL()) == null) {
            return f3;
        }
        float fZzh = zzvmVarZzaL.zzh(zzvVar.zzw, zzvVar.zzx);
        return f3 != -1.0f ? Math.max(f3, fZzh) : fZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzal(String str, zzvg zzvgVar, long j, long j2) {
        this.zzg.zzb(str, j, j2);
        this.zzp = zzbq(str);
        zzvm zzvmVarZzaL = zzaL();
        zzvmVarZzaL.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(zzvmVarZzaL.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzb = zzvmVarZzaL.zzb();
            int length = codecProfileLevelArrZzb.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (codecProfileLevelArrZzb[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.zzq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzam(String str) {
        this.zzg.zzh(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzan(Exception exc) {
        zzeg.zzf("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final zzjc zzao(zzlw zzlwVar) throws zzjk {
        zzjc zzjcVarZzao = super.zzao(zzlwVar);
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        this.zzg.zzc(zzvVar, zzjcVarZzao);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        return zzjcVarZzao;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzap(zzv zzvVar, MediaFormat mediaFormat) {
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null) {
            zzvjVarZzaI.zzq(this.zzz);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        float f = zzvVar.zzC;
        int i = zzvVar.zzB;
        if (i == 90 || i == 270) {
            f = 1.0f / f;
            int i2 = integer2;
            integer2 = integer;
            integer = i2;
        }
        this.zzL = new zzbv(integer, integer2, f);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzS) {
            this.zzi.zze(zzvVar.zzA);
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzv(integer);
            zztVarZza.zzw(integer2);
            zztVarZza.zzB(f);
            zzv zzvVarZzO = zztVarZza.zzO();
            int i3 = this.zzt;
            List listZzi = this.zzu;
            if (listZzi == null) {
                listZzi = zzgwm.zzi();
            }
            zzaeuVar.zzs(1, zzvVarZzO, zzbh(), i3, listZzi);
            this.zzt = 2;
        }
        this.zzS = false;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final boolean zzaq(long j, long j2, long j3, boolean z, boolean z2) throws zzjk {
        int iZzR;
        if (this.zzr != null && this.zzf) {
            j2 -= -this.zzQ;
        }
        if (j >= -500000 || z || (iZzR = zzR(j2)) == 0) {
            return false;
        }
        this.zzG = j2;
        zzjb zzjbVar = ((zzvt) this).zza;
        if (z2) {
            int i = zzjbVar.zzd + iZzR;
            zzjbVar.zzd = i;
            zzjbVar.zzf += this.zzE;
            zzjbVar.zzd = this.zzn.size() + i;
        } else {
            zzjbVar.zzj++;
            zzaz(this.zzn.size() + iZzR, this.zzE);
        }
        zzaN();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzg(false);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzar() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
            long jZzbh = this.zzQ;
            if (jZzbh == -9223372036854775807L) {
                jZzbh = zzbh();
                this.zzQ = jZzbh;
            }
            this.zzr.zzo(-jZzbh);
        } else {
            this.zzi.zza(2);
        }
        this.zzS = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    @Override // com.google.android.gms.internal.ads.zzvt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzas(long j, long j2, zzvj zzvjVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) {
        zzade zzadeVar;
        long j4;
        zzvjVar.getClass();
        long jZzbg = j3 - zzbg();
        int i4 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzn;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            priorityQueue.poll();
            i4++;
        }
        zzaz(i4, 0);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            if (!z || z2) {
                return zzaeuVar.zzu(j3, new zzada(this, zzvjVar, i, jZzbg));
            }
            zzax(zzvjVar, i, jZzbg);
            return true;
        }
        zzadu zzaduVar = this.zzi;
        long jZzbh = zzbh();
        zzads zzadsVar = this.zzj;
        int iZzk = zzaduVar.zzk(j3, j, j2, jZzbh, z, z2, zzadsVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar == null) {
            if (iZzk != 0) {
                long jZzc = zzM().zzc();
                zzbx(jZzbg, jZzc, zzvVar);
                zzaB(zzvjVar, i, jZzbg, jZzc);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk == 1) {
                long jZzb = zzadsVar.zzb();
                long jZza = zzadsVar.zza();
                if (jZzb == this.zzK) {
                    zzax(zzvjVar, i, jZzbg);
                    j4 = jZzb;
                    zzadeVar = this;
                } else {
                    zzbx(jZzbg, jZzb, zzvVar);
                    zzaB(zzvjVar, i, jZzbg, jZzb);
                    zzadeVar = this;
                    j4 = jZzb;
                }
                zzadeVar.zzaA(jZza);
                zzadeVar.zzK = j4;
                return true;
            }
            if (iZzk == 2) {
                zzay(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk == 3) {
                zzax(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
        } else if (iZzk != 5 && iZzk != 4) {
            zzadvVar.zza(j3, zzadsVar.zza());
            if (iZzk != 0) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzat(zziz zzizVar) {
        this.zzg.zzk(zzizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzau() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
        } else if (zzbe() != -9223372036854775807L) {
            zzbe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public final void zzav(zziv zzivVar) {
        if (this.zzq) {
            ByteBuffer byteBuffer = zzivVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzvj zzvjVarZzaI = zzaI();
                        zzvjVarZzaI.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzvjVarZzaI.zzp(bundle);
                    }
                }
            }
        }
    }

    public final void zzax(zzvj zzvjVar, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzvjVar.zzc(i, false);
        Trace.endSection();
        ((zzvt) this).zza.zzf++;
    }

    public final void zzay(zzvj zzvjVar, int i, long j) {
        Trace.beginSection("dropVideoBuffer");
        zzvjVar.zzc(i, false);
        Trace.endSection();
        zzaz(0, 1);
    }

    public final void zzaz(int i, int i2) {
        zzjb zzjbVar = ((zzvt) this).zza;
        zzjbVar.zzh += i;
        int i3 = i + i2;
        zzjbVar.zzg += i3;
        this.zzC += i3;
        int i4 = this.zzD + i3;
        this.zzD = i4;
        zzjbVar.zzi = Math.max(i4, zzjbVar.zzi);
    }

    public final /* synthetic */ Surface zzbp() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzmv
    public final void zzx(int i, Object obj) throws zzjk {
        if (i == 1) {
            zzbu(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            zzadr zzadrVar = (zzadr) obj;
            this.zzP = zzadrVar;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzl(zzadrVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzO != iIntValue) {
                this.zzO = iIntValue;
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzz = iIntValue2;
            zzvj zzvjVarZzaI = zzaI();
            if (zzvjVarZzaI != null) {
                zzvjVarZzaI.zzq(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzA = iIntValue3;
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzr(iIntValue3);
                return;
            } else {
                this.zzi.zzm(iIntValue3);
                return;
            }
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.zza)) {
                zzaeu zzaeuVar3 = this.zzr;
                if (zzaeuVar3 == null || !zzaeuVar3.zze()) {
                    return;
                }
                zzaeuVar3.zzf();
                return;
            }
            this.zzu = list;
            zzaeu zzaeuVar4 = this.zzr;
            if (zzaeuVar4 != null) {
                zzaeuVar4.zzn(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            zzeu zzeuVar = (zzeu) obj;
            if (zzeuVar.zza() == 0 || zzeuVar.zzb() == 0) {
                return;
            }
            this.zzx = zzeuVar;
            zzaeu zzaeuVar5 = this.zzr;
            if (zzaeuVar5 != null) {
                Surface surface = this.zzv;
                surface.getClass();
                zzaeuVar5.zzp(surface, zzeuVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.zzN = ((Integer) obj).intValue();
                zzvj zzvjVarZzaI2 = zzaI();
                if (zzvjVarZzaI2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzN));
                    zzvjVarZzaI2.zzp(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzv;
                zzbu(null);
                obj.getClass();
                ((zzade) obj).zzx(1, surface2);
                break;
            case 18:
                boolean z = this.zzF != null;
                zznh zznhVar = (zznh) obj;
                this.zzF = zznhVar;
                if (z != (zznhVar != null)) {
                    zzbd();
                }
                break;
            default:
                super.zzx(i, obj);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzy(boolean z, boolean z2) {
        super.zzy(z, z2);
        zzK();
        this.zzg.zza(((zzvt) this).zza);
        if (!this.zzs) {
            if (this.zzu != null && this.zzr == null) {
                zzadi zzadiVar = new zzadi(this.zze, this.zzi);
                zzadiVar.zza(true);
                zzadiVar.zzc(-this.zzl);
                zzadiVar.zzb(zzM());
                zzadq zzadqVarZzd = zzadiVar.zzd();
                zzadqVarZzd.zza(1);
                this.zzr = zzadqVarZzd.zzb(0);
            }
            this.zzs = true;
        }
        int i = !z2 ? 1 : 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            zzadu zzaduVar = this.zzi;
            zzaduVar.zzg(zzM());
            zzaduVar.zza(i);
            return;
        }
        zzaeuVar.zzc(new zzacz(this), zzhcn.zza());
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            this.zzr.zzl(zzadrVar);
        }
        if (this.zzv != null && !this.zzx.equals(zzeu.zza)) {
            this.zzr.zzp(this.zzv, this.zzx);
        }
        this.zzr.zzr(this.zzA);
        this.zzr.zzm(zzbb());
        List list = this.zzu;
        if (list != null) {
            this.zzr.zzn(list);
        }
        this.zzt = i;
        zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    public final void zzz(zzv[] zzvVarArr, long j, long j2, zzxk zzxkVar) {
        super.zzz(zzvVarArr, j, j2, zzxkVar);
        zzbt(zzxkVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }
}
