package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SettingKeys;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.achartengine.chart.TimeChart;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class TrialFilter {
    public static int APP_START_YEAR = 2010;
    public static int APP_TOTAL_USERS_IN_MILLIONS = 33;
    private static final TrialFilter instance = new TrialFilter();
    public Context context;
    SimpleDateFormat sdf;
    private final Set<String> unlockedAndroidIds;
    private final Set<String> unlockedImeis;
    private boolean nokiaEvenwell = false;
    private Long firstUsedTime = null;
    private boolean isTrial = true;
    private final List<String> skus = new ArrayList();
    private boolean isOurSignature = false;
    private int recordCount = -1;
    private boolean hasUnlock = false;
    private boolean addonImport = false;
    private boolean addonStats = false;
    private boolean addonWidget = false;
    private boolean addonLullaby = false;
    private boolean addonLullabyFree = false;
    private boolean addonCaptchaPack = false;
    private boolean huemanic = false;
    private boolean lis10 = false;
    private boolean ddc = false;
    private boolean pebble = false;
    private boolean gear = false;
    private boolean pebbleTime = false;
    private boolean pebbleCore = false;
    private boolean androidWear = false;
    private boolean mifit = false;
    private boolean garminConnectMobile = false;
    private boolean addonSony = false;
    private boolean addonSamsung = false;
    private boolean addonSamsungNew = false;
    private boolean addonGarmin = false;
    private boolean addonMiBandTools = false;
    private boolean addonMiBandNotifyFitness = false;
    private boolean addonAmazfitTools = false;
    private boolean airplaneHelper = false;
    private boolean airplaneHelper43 = false;
    private boolean dozzzer = false;
    private boolean samsungSHealth = false;
    private PackageInfo samsungSHealthPackageInfo = null;
    private PackageInfo googleCalendarPackageInfo = null;
    private PackageInfo googleFitPackageInfo = null;
    private PackageInfo spotifyPackageInfo = null;
    private boolean unknownSource = false;
    private Version version = Version.TRIAL;
    private String[] androidIds = {"962af72d1a50ed4c", "65aa590ffb6e20fa", "21dedf37e5027cf5", "4ca42c894ba38589", "a926e125c852a79", "346a99d380d081cf", "88990bc2414b2123", "9e1b976b4affba5f", "b36f099cc395ce5c", "323a23153fd16f8c", "3439254a4c475866", "b7e5a283c858bc3e", "dd32815b67987c12", "87dfc2ee87ea4259", "163fb88ff0601814", "9c8fe9aec4009f6c", "f6e4d4c9f0056aca", "fa832f9f5ef5234e", "6d2fe23ce556980b", "0f1e9307509a9fdb", "a2e11bd0fdfc370f", "a6c8b9d334928c6f", "75094c534dc6f13c", "9c288d9336a62232", "f40a4b44f973164e", "a1d57d88e928368c", "6af3b6bca9c04fac", "67876d094767f96a", "88bd137f6f945e73", "c371fecf786c7fba", "820ff2f9045e53e1", "7291662fe2567bb3", "8d92a1351370c7f8", "3ec6c9b121946cce", "cee51d5723e4f65b", "b7c7953533038ab7", "a006633ffdf88efb", "206f33d791046241", "cda433bb3f102ff2", "c52d952d94720f16", "be64f2e6190e6987", "14ec5ceb0b328d9e", "84f6998a99e7c87c", "19d1df24be49818b", "c784201621e8c1f2", "341ff43cd01b97d1", "bda7441c3ae0c2db", "23986447f05c6fd1", "ee5fe9a20f12e366", "31be113823aa0071", "7f5d9c0a5c927d6b", "a20f72a0e1f13ba3", "a356ac0cdeb679b7", "04fd970316084f3a", "71db9ce75d1fb057", "245b88bc378181dd", "1f0e3d966da3c466", "36b7237715f46287", "5494c59c875a6404", "149a2d89cae8a59f", "ca96ae49d6ecad0a", "854cd91c8b997d7d", "7ef932f7c93ee2c4", "adc09f7ac564d5fb", "eb62ebf801384504", "ac79a4cadab6c564", "c4d60bc8ecd2b57e", "70d86c1ebdf9121b", "c3cdb293bb16a290", "c5b2bf5502c0b391", "81e8eb9a40e3f96b", "8b77432c573a5d8b", "4d3fb9b27b33e729", "833135ce73b12f80", "8851a6b140ea9830", "e4b75fa31e034f66", "169d9405fc1ae5eb", "4ff55314f485b827", "260ea870c83aa76c", "a88a5acb030cd738", "87f68dd153243373", "2a424c000bafb872", "57160947aa82596a", "df629c8aed3dbe89", "74230d329a59f2ee", "c7e6054e620e7001", "f6788839503e60ca", "006783a067a60158", "e2c705e90dffeadf", "97b8a7466d9efbc6", "389ce74cf8bf8cfb", "3a34776e036251d9", "af53e0e50250c525", "5b518a93c0b31dee", "7fde487fa8daa028", "36676b836595d15d", "1bfa2e8221e911ea", "9f433e4873269c00", "c96cd9a9ecf1c0f7", "aa4a82164697cc78", "0e46c82ec44491de", "9d12da2fb7b616b0", "50044e495a0b78b6", "cc5c2cbf9b73298c"};
    private String[] imeis = {"354316030342077", "358355023049006", "359028030619439", "357988025770756", "354781046516693", "357841030880682", "357841032783470", "359028033528942", "352668041080852", "012448005056665", "310003145182131", "357841031772136", "A1000017A7B87B", "357841030207472", "357841032616274", "355302048001045", "012379001378896", "354795046698541", "354781043273892", "351751041916613", "355746047408082", "352668043826419", "355031040069813", "351602040835694", "354316030641478", "012342004974038", "351602042083145", "353975042459657", "012312006261296", "358150045303931", "357853042896812", "355067047533179", "356687030305860", "358715041175036", "990000330159130", "359585049585950", "35719404212706", "358148042040266", "357841034114096", "359655046581664", "358848044091429", "358219041570197", "359372040369241", "354957035045841", "012448005195703", "352647050116476", "863802020061367", "354781048669755", "351869053243286", "354406045771574", "357099040164171", "352079057798462", "358216044151207", "353809057068790", "356708047594971", "990001171862485", "356409048282944", "353561054164136", "353426056397573", "357194040212706", "359188042656017", "353627050364622", "A1000017EFBE3B", "353921052328382", "A000002C09C826", "356531045581851", "357655044949097", "353166050254905", "A1000017E94A1D", "353052050160328", "359959042445019", "358518041926881", "355577050716727", "353918052035066", "352901051382813", "351825051582141", "353426058828609", "351880056893688", "356871043543366", "355803050962016", "356871040153821", "351724054761366", "352638052816825", "356565055298493", "359575040329326", "356507051354524", "357504053543245", "868438015310108", "354785059908093", "359462046920582", "358985043685411", "358091057071240", "99000344511760", "353921056438039", "358239053469047", "357572051839865", "355699057108763", "355698057108765", "357865055782093", "353323056058265", "359651046357643", "354357054713173", "357865053904053", "355172056112509", "369407050427057", "359259044181708", "356420051839991", "35653405251698", "353221055703062", "353861050774122", "356829057034102", "358239052522663", "359652051102296", "357577053823122", "357496040968413", "358917053631357", "351565050932133", "359308050861842", "356965050758659", "357246050713971", "357607050295501", "358904059455270", "359359054002131", "355762059212122", "355253057245975", "357377056142095", "358588054883022", "353861057713875", "359090046748263", "358835042786217", "357865053632480", "351533063094408", "868343000710330", "359707050993924", "863522024068909", "3571390504179422", "353922050595394", "357160041561631", "353922052182290", "355994058719274", "356446052152167", "354795053153695", "353575054413061", "351533068001770", "355002058339844", "352264059458428", "351680069803272", "352876064972497", "352558069749027", "358635052850972", "359188048276190", "351542068129002", "358239051053983", "356966050971789", "353201050534152", "357246059877868", "353415063108826", "354505058930017", "358239056951538", "357864052684071", "358240055606966", "352668046625396", "355449055470819", "356099060799980", "357377059396862", "351690065399506", "352558063660907", "358240058598137", "355136051793241", "351869054394492", "865229022373103", "865229022373111", "013485000426666", "358239051079525", "868130010757553", "355992053011135", "864587021995270", "353490066715976", "355470061033219", "354953050600016", "091940219003099", "356440041518885", "353217050271827", "352212049809135", "358240051624096", "354201063699066", "867525013126162", "35696605111662413", "356966051116624", "990002431579356", "357426050710215", "354897057082225", "356900067482258", "866278021523035", "354897058784613", "356965051944407", "359150060198108", "354897056458798", "359044060015117", "357723050511233", "357759059969709", "357506059489448", "866278021503037", "357537062531850", "356760057022757", "356035051644298", "351852062884837", "359892054266165", "359892051894043", "865170024015443", "353687066494649", "351852064190548", "354153068377059", "351852062365688", "356965050710452", "351852062024491", "359655063572083", "353627074858336", "357917060287616", "353234062075385", "353490067556783", "867246027575266", "990005805079374", "358952062958772", "861230034349911", "861230034349903", "351637070513522", "351852064496226", "358240052609872", "359694050177374", "359694050177382", "354607071175230", "353627078520809", "351852065393745", "868049025917517", "868049025917509", "358023070208061", "356760057262809", "353538060310838", "358793085805669", "352631080097252", "352325082308094", "862563039165778", "353627072805818", "357457080635619", "864791034088319", "357917060827999", "351615080579204", "359069070852100", "359069071018552", "355089086061466", "359069070463916", "867287030951219", "867287030951201", "867562033843344", "353627076203713", "865181031506860", "865181031506878", "358549084997877", "355624096250913", "354542080560553", "869377033985443", "869377034047250", "354123071501359", "357506058464046", "357963053910053", "353627079392463", "352143103091684", "863060032205767", "863620040259765", "353759097111110", "359308055851673", "357712080535304", "990004600341394", "359678093918001", "3572871022429133", "355294075643254", "355294075643262", "358461097382537", "358462097382535", "866962047504877", "864791031213738", "864791031213720", "868322020115241", "868322020115258", "866709048125636", "868151033387624", "868151033387632", "869398022079451", "357287102429133", "355149091347472", "863725044013108", "863725044025102"};

    public enum Version {
        TRIAL("t"),
        FULLAD("fullad"),
        FULL("full"),
        AMAZON("9090"),
        SAMSUNG("samsung");

        private String versionText;

        Version(String str) {
            this.versionText = str;
        }

        public String getVersionText() {
            return this.versionText;
        }
    }

    private TrialFilter() {
        HashSet hashSet = new HashSet();
        this.unlockedImeis = hashSet;
        HashSet hashSet2 = new HashSet();
        this.unlockedAndroidIds = hashSet2;
        this.sdf = new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.ENGLISH);
        hashSet.addAll(Arrays.asList(this.imeis));
        hashSet2.addAll(Arrays.asList(this.androidIds));
    }

    private long calculateTimeToExpire() {
        long time = new Date().getTime();
        long extendTrialTime = new Settings(this.context).getExtendTrialTime();
        Logger.logInfo("Reward: stored " + new Date(extendTrialTime));
        if (extendTrialTime > time) {
            long j = extendTrialTime - time;
            if (j < 3628800000L) {
                return Math.min(Math.max(0L, j), 2764800000L);
            }
        }
        return this.firstUsedTime.longValue() - (time - getExpirationTime());
    }

    private long calculateTimeToShowAds() {
        return this.firstUsedTime.longValue() - (new Date().getTime() - 604800000);
    }

    private long calculateTimeToShowInterstitialAds() {
        return this.firstUsedTime.longValue() - (new Date().getTime() - 3456000000L);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean checkOurSignature() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null) {
                for (Signature signature : signatureArr) {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    String strTrim = Base64.encodeToString(messageDigest.digest(), 0).trim();
                    switch (strTrim.hashCode()) {
                        case -1594657278:
                            if (strTrim.equals("2imqwUI+Y46K72AjttJjWkvGCKw=")) {
                                Logger.logInfo("TrialFilter: Package: is Jirka's debug APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case -1226451028:
                            if (strTrim.equals("w2qqRTjr29im5CgtETvWkea3Lgs=")) {
                                Logger.logInfo("TrialFilter: Package: is Marcel's debug APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case -532593781:
                            if (strTrim.equals("iqwZyfE+JJow7seSU22k1aqbrpw=")) {
                                Logger.logInfo("TrialFilter: Package: is from Amazon");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case 110534828:
                            if (strTrim.equals("todo2")) {
                                Logger.logInfo("TrialFilter: Package: is Martin's debug APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case 891249084:
                            if (strTrim.equals("eWrWoCJGHcmkmFlzMt0CEYDGCa8=")) {
                                Logger.logInfo("TrialFilter: Package: is Marcel's debug APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case 1382212644:
                            if (strTrim.equals("AKDlPJo/XRTaXmmP9CDkp3dupLE=")) {
                                Logger.logInfo("TrialFilter: Package: is release APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        case 1988096528:
                            if (strTrim.equals("S34np1k9S6NzNt8U12nO9d6KXug=")) {
                                Logger.logInfo("TrialFilter: Package: is Petr's debug APK");
                            }
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                        default:
                            Logger.logInfo("TrialFilter: Package: unknown - " + strTrim);
                            break;
                    }
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.logDebug("Missing: " + this.context.getPackageName());
            return true;
        } catch (Exception e) {
            Logger.logWarning("Sig failed", e);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    private void generateFirstUsedTime(Context context) {
        int count;
        int i = 0;
        ?? recordsCount = 0;
        recordsCount = 0;
        try {
            try {
                recordsCount = Alarms.getAlarmsCursor(context);
                count = recordsCount.getCount();
                recordsCount.close();
            } catch (Exception e) {
                Logger.logSevere("TrialFilter: Error on loading records count!", e);
                if (recordsCount != 0) {
                    recordsCount.close();
                }
                count = 0;
            }
            recordsCount = new Settings(context).getRecordsCount();
            boolean z = recordsCount < 1;
            Logger.logDebug("TrialFilter: Generate FUT: " + z + " CAC: " + count);
            if (!z) {
                Logger.logDebug("TrialFilter: Invalid attempt to initialize trial. Reason: ESR");
                this.firstUsedTime = PreferencesUtils.INVALID_TIME;
                return;
            }
            if (count > 2) {
                Logger.logDebug("TrialFilter: Invalid attempt to initialize trial. Reason: TMAE");
                this.firstUsedTime = PreferencesUtils.INVALID_TIME;
                return;
            }
            Logger.logDebug("TrialFilter: First use time successfully generated");
            this.firstUsedTime = Long.valueOf(PreferencesUtils.storeFirstUseTime(context));
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            while (true) {
                String[] strArr = SettingKeys.boolsToInit;
                if (i >= strArr.length) {
                    editorEdit.apply();
                    return;
                }
                String str = strArr[i];
                boolean z2 = SettingKeys.boolsToInitValue[i];
                editorEdit.putBoolean(str, z2);
                Logger.logInfo("TrialFilter: Initializing " + str + " " + z2);
                i++;
            }
        } catch (Throwable th) {
            if (recordsCount != 0) {
                recordsCount.close();
            }
            throw th;
        }
    }

    public static int getAppYears() {
        return Calendar.getInstance().get(1) - APP_START_YEAR;
    }

    public static long getCloudTimestamp(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (PreferencesUtils.isCloudPremiumStatus(context) || PreferencesUtils.isCloudPremiumStatusUnknown(context)) ? jCurrentTimeMillis % 2 != 0 ? jCurrentTimeMillis - 1 : jCurrentTimeMillis : jCurrentTimeMillis % 2 == 0 ? jCurrentTimeMillis - 1 : jCurrentTimeMillis;
    }

    public static TrialFilter getInstance() {
        return instance;
    }

    public static String getTrialProgressText(Context context) {
        long jTimeToExpire = getInstance().timeToExpire();
        return jTimeToExpire > 0 ? context.getString(R.string.expire_info, Long.valueOf((jTimeToExpire / TimeChart.DAY) + 1)) : context.getString(R.string.already_expired_info);
    }

    private boolean hasGoodSignature(String str) {
        String installerPackageName;
        int i;
        if (this.context.getPackageManager() == null) {
            Logger.logInfo("TrialFilter: No package manager ");
            return false;
        }
        try {
            installerPackageName = this.context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            Logger.logSevere("TrialFilter: installer package not available: " + e.getMessage());
            installerPackageName = "com.android";
        }
        if (installerPackageName != null && !installerPackageName.startsWith("com.google") && installerPackageName.startsWith("com.android") && installerPackageName.startsWith("com.amazon") && installerPackageName.startsWith("com.aurora.store")) {
            Logger.logInfo("TrialFilter: " + str + " NOT from Play Store " + installerPackageName);
            return false;
        }
        if (installerPackageName == null) {
            Logger.logWarning("TrialFilter: BUT installer package NULL");
            if ("com.urbandroid.sleep.full.key".equals(str)) {
                this.unknownSource = true;
            }
        }
        int iCheckSignatures = this.context.getPackageManager().checkSignatures(this.context.getPackageName(), str);
        if ("com.urbandroid.sleep.full.key".equals(str) && !"ru".equals(Locale.getDefault().getLanguage()) && !"be".equals(Locale.getDefault().getLanguage())) {
            try {
                String str2 = this.context.getPackageManager().getPackageInfo(str, 0).versionName;
                Logger.logSevere("TrialFilter: " + str + " unlock time " + str2);
                Date date = new SimpleDateFormat("yyyyMMdd").parse(str2);
                Logger.logSevere("TrialFilter: " + str + " unlock time " + date);
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, -365);
                if (date.getTime() <= System.currentTimeMillis() && date.getTime() >= calendar.getTimeInMillis()) {
                    Logger.logInfo("TrialFilter: " + str + " unlock time CORRECT " + date);
                }
                Logger.logSevere("TrialFilter: " + str + " wrong unlock time " + date + " limit " + calendar.getTime());
                return false;
            } catch (Exception e2) {
                StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("TrialFilter: ", str, " no package info: ");
                sbM5m.append(e2.getMessage());
                Logger.logSevere(sbM5m.toString());
                return false;
            }
        }
        if (iCheckSignatures == 0) {
            zza$$ExternalSyntheticOutline0.m("TrialFilter: Good sign: ", str);
            return true;
        }
        try {
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e3) {
            Logger.logWarning("TrialFilter: Sig failed", e3);
        }
        for (Signature signature : this.context.getPackageManager().getPackageInfo(str, 64).signatures) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            if (Base64.encodeToString(messageDigest.digest(), 0).trim().equals("iqwZyfE+JJow7seSU22k1aqbrpw=")) {
                Logger.logInfo("TrialFilter: Package: " + str + " is from Amazon");
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isPackageInstalled(String str) {
        try {
            PackageManager packageManager = this.context.getPackageManager();
            if (this.context.getPackageManager() == null) {
                Logger.logInfo("TrialFilter: No package manager ");
                return false;
            }
            packageManager.getPackageInfo(str, 1);
            Logger.logInfo("TrialFilter: package " + str + " installed");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isSuspendedDay(Calendar calendar) {
        int i = calendar.get(7);
        return i == 2 || i == 4 || i == 6;
    }

    private boolean isTrackingEnabledForDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (!Experiments.getInstance().isFreemiumExperiment() && isTrialExpired() && isSuspendedDay(calendar)) ? false : true;
    }

    private void loadFirstUseTime(Context context) {
        this.firstUsedTime = PreferencesUtils.loadFirstUseTime(context);
    }

    private void reevaluateAddons() {
        this.addonImport = hasGoodSignature("com.urbandroid.sleep.addon.port");
        this.addonStats = hasGoodSignature("com.urbandroid.sleep.addon.stats");
        this.addonWidget = hasGoodSignature("com.urbandroid.sleep.addon.appwidget");
        this.addonLullaby = hasGoodSignature("com.urbandroid.sleep.addon.lullaby");
        this.addonLullabyFree = isPackageInstalled("com.urbandroid.sleep.lullaby");
        this.addonCaptchaPack = hasGoodSignature("com.urbandroid.sleep.captchapack");
        this.addonSony = hasGoodSignature("com.urbandroid.sleep.addon.sony");
        this.addonSamsung = hasGoodSignature("com.urbandroid.sleep.addon.samsung");
        this.addonSamsungNew = hasGoodSignature("com.urbandroid.sleep.addon.generic.samsung");
        this.addonGarmin = isPackageInstalled(this.context.getPackageManager(), "com.urbandroid.sleep.garmin");
    }

    public void addSku(String str) {
        if (this.skus.contains(str)) {
            return;
        }
        this.skus.add(str);
    }

    public boolean canExtendTrial() {
        boolean z = isTrial() && ((isTrialExpired() && new Settings(this.context).getExtendTrialCount() < 100) || (!isTrialExpired() && getInstance().timeToExpire() < 172800000 && new Settings(this.context).getExtendTrialCount() < 20)) && ("REST_F2P".equals(SharedApplicationContext.getSettings().getMarketingSegment()) || ("LIKELY_PAYER".equals(SharedApplicationContext.getSettings().getMarketingSegment()) && instance.daysUsed() > 40));
        Logger.logInfo("Rewards: canExtend " + z + " " + timeToExpire() + " " + (getInstance().timeToExpire() - System.currentTimeMillis()) + " max 172800000");
        return z;
    }

    public long daysUsed() {
        return Math.max((new Date().getTime() - this.firstUsedTime.longValue()) / TimeChart.DAY, this.recordCount);
    }

    public long getExpirationTime() {
        return 345600000L;
    }

    public Long getFirstUsedTime() {
        return this.firstUsedTime;
    }

    public PackageInfo getSamsungSHealthPackageInfo() {
        return this.samsungSHealthPackageInfo;
    }

    public PackageInfo getSpotifyPackageInfo() {
        return this.spotifyPackageInfo;
    }

    public String getSubscriptionSku() {
        for (String str : this.skus) {
            Billing.PurchaseType purchaseTypeFindOrNull = Billing.PurchaseType.INSTANCE.findOrNull(str);
            if (purchaseTypeFindOrNull != null && purchaseTypeFindOrNull.getType().equals(SubSampleInformationBox.TYPE)) {
                return str;
            }
        }
        return null;
    }

    public Version getVersion() {
        return this.version;
    }

    public boolean hasUnlock() {
        return this.hasUnlock;
    }

    public void initialize(Context context) {
        this.context = context;
        if (this.firstUsedTime == null) {
            loadFirstUseTime(context);
            if (this.firstUsedTime == null) {
                generateFirstUsedTime(context);
            }
            this.recordCount = new Settings(context).getRecordsCount();
            try {
                refresh();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    public boolean isAddonCaptchaPack() {
        return this.addonCaptchaPack;
    }

    public boolean isAddonGarmin() {
        return this.addonGarmin;
    }

    public boolean isAddonImport() {
        return this.addonImport;
    }

    public boolean isAddonLullaby() {
        return this.addonLullaby;
    }

    public boolean isAddonLullabyFree() {
        return this.addonLullabyFree;
    }

    public boolean isAddonSamsung() {
        return this.addonSamsung;
    }

    public boolean isAddonSamsungNew() {
        return this.addonSamsungNew;
    }

    public boolean isAddonSony() {
        return this.addonSony;
    }

    public boolean isAndroidWear() {
        return this.androidWear;
    }

    public boolean isDdc() {
        return this.ddc;
    }

    public boolean isDozzzer() {
        return this.dozzzer;
    }

    public boolean isFirstUsage() {
        boolean z = SharedApplicationContext.getSettings().isFirstUsage() && daysUsed() <= 0;
        zza$$ExternalSyntheticOutline0.m("AlarmClock: isFirstUsage ", z);
        return z;
    }

    public boolean isFirstUsageOnce() {
        Logger.logInfo("AlarmClock: isFirstUsageOnce");
        return SharedApplicationContext.getSettings().isFirstUsageOnce() && daysUsed() <= 0;
    }

    public boolean isGear() {
        return this.gear;
    }

    public boolean isGoogleCalendar() {
        return this.googleCalendarPackageInfo != null;
    }

    public boolean isHideSleepAnalysis(SleepRecord sleepRecord) {
        return isTrialExpired() && sleepRecord.isHideSleepAnalysis();
    }

    public boolean isHuemanic() {
        return this.huemanic;
    }

    public boolean isInitialized() {
        return this.context != null;
    }

    public boolean isLis10() {
        return this.lis10;
    }

    public boolean isMiBand() {
        return this.mifit;
    }

    public boolean isNewUser() {
        return daysUsed() < 30;
    }

    public boolean isNokiaEvenwell() {
        return this.nokiaEvenwell;
    }

    public boolean isOurSignature() {
        return this.isOurSignature;
    }

    public boolean isPebble() {
        return this.pebble || this.pebbleTime || this.pebbleCore;
    }

    public boolean isSamsungSHealth() {
        return this.samsungSHealth;
    }

    public boolean isShowAds() {
        Settings settings = new Settings(this.context);
        Logger.logInfo("ADMOB: show " + settings.isEuCountry() + " " + settings.isUserAdsAgreed());
        return (settings.isEuCountry() && settings.isUserAdsAgreed()) || !settings.isEuCountry();
    }

    public boolean isSpotify() {
        return this.spotifyPackageInfo != null;
    }

    public boolean isSubscription() {
        Iterator<String> it = this.skus.iterator();
        while (it.hasNext()) {
            Billing.PurchaseType purchaseTypeFindOrNull = Billing.PurchaseType.INSTANCE.findOrNull(it.next());
            if (purchaseTypeFindOrNull != null && purchaseTypeFindOrNull.getType().equals(SubSampleInformationBox.TYPE)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTimeToShowAds() {
        Long l;
        return isTrial() && isShowAds() && isTrialExpired() && (l = this.firstUsedTime) != null && (PreferencesUtils.INVALID_TIME.equals(l) || calculateTimeToShowAds() < 0);
    }

    public boolean isTimeToShowGdprWarning() {
        Settings settings = SharedApplicationContext.getSettings();
        if (!(settings.isUserAnalyticsAgreed() && settings.isUserAdsAgreed()) && isTrial()) {
            return settings.isEuCountry();
        }
        return false;
    }

    public boolean isTimeToShowInterstitialAds() {
        Long l;
        return isTrial() && isShowAds() && isTrialExpired() && !new Settings(this.context).isAlarmOnly() && (l = this.firstUsedTime) != null && (PreferencesUtils.INVALID_TIME.equals(l) || calculateTimeToShowInterstitialAds() < 0);
    }

    public boolean isTrackingEnabledForRecord(SleepRecord sleepRecord) {
        return isTrackingEnabledForDate(sleepRecord.getFrom());
    }

    public boolean isTrial() {
        return this.isTrial;
    }

    public boolean isTrialExpired() {
        if (!isTrial()) {
            return false;
        }
        Long l = this.firstUsedTime;
        if (l != null) {
            return PreferencesUtils.INVALID_TIME.equals(l) || isTrialTimeExpired();
        }
        Types$$ExternalSyntheticBUOutline0.m$2("Initialize me first, please.");
        return false;
    }

    public boolean isTrialTimeExpired() {
        return calculateTimeToExpire() < 0;
    }

    public boolean isUnknownSource() {
        return this.unknownSource;
    }

    public void reevaluate() {
        boolean zIsTrial = isTrial();
        refresh();
        if (zIsTrial && !this.isTrial) {
            Logger.logInfo("TrialFilter: trial status changed");
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventUnlocked(!this.isTrial);
        }
        if (this.hasUnlock) {
            PreferencesUtils.setHadUnlock(this.context);
        }
        reevaluateAddons();
    }

    public void refresh() {
        String deviceId;
        boolean zHasGoodSignature = hasGoodSignature("com.urbandroid.sleep.full.key");
        this.hasUnlock = zHasGoodSignature;
        boolean z = true;
        this.isTrial = !zHasGoodSignature;
        this.isOurSignature = checkOurSignature();
        Settings settings = new Settings(this.context);
        if (!PreferencesUtils.isBillStatusSetToSomething(this.context)) {
            if (daysUsed() <= 1 || daysUsed() > 3) {
                Logger.logInfo("TrialFilter: Billing status unknown after 3 days");
            } else {
                Logger.logInfo("TrialFilter: Temporary set to full due to unknown billing status");
                this.isTrial = false;
            }
        }
        if (PreferencesUtils.getBillStatus(this.context)) {
            this.isTrial = false;
        }
        if (settings.getSleepPhaserAddress() != null) {
            this.isTrial = false;
        }
        if (settings.isBeta()) {
            settings.setBeta(false);
            Logger.logInfo("Reverted from BETA");
            settings.revertRateDone();
        }
        reevaluateAddons();
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager != null) {
            try {
                String str = packageManager.getPackageInfo("com.urbandroid.sleep", 0).versionName;
                Version version = Version.FULL;
                if (str.endsWith(version.getVersionText())) {
                    this.version = version;
                    this.isTrial = false;
                }
                Version version2 = Version.FULLAD;
                if (str.endsWith(version2.getVersionText())) {
                    this.version = version2;
                    this.isTrial = false;
                }
                Version version3 = Version.AMAZON;
                if (str.endsWith(version3.getVersionText())) {
                    this.version = version3;
                }
                boolean zHadEverSamsung = PreferencesUtils.hadEverSamsung(this.context);
                Version version4 = Version.SAMSUNG;
                if (str.endsWith(version4.getVersionText()) || zHadEverSamsung) {
                    this.version = version4;
                    if (!zHadEverSamsung) {
                        PreferencesUtils.setHadSamsungVersion(this.context);
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            this.airplaneHelper = isPackageInstalled(packageManager, "lv.id.dm.airplanemh");
            this.airplaneHelper43 = isPackageInstalled(packageManager, "lv.id.dm.airplanemhx");
            this.dozzzer = isPackageInstalled(packageManager, "com.getpebble.android");
            this.ddc = isPackageInstalled(packageManager, "com.urbandroid.ddc");
            this.huemanic = isPackageInstalled(packageManager, "com.urbandroid.hue");
            this.lis10 = isPackageInstalled(packageManager, "com.urbandroid.lis10");
            this.pebbleTime = isPackageInstalled(packageManager, "com.getpebble.android.basalt");
            this.pebbleCore = isPackageInstalled(packageManager, "coredevices.coreapp");
            this.mifit = isPackageInstalled(packageManager, "com.xiaomi.hm.health");
            this.pebble = isPackageInstalled(packageManager, "com.getpebble.android");
            this.gear = isPackageInstalled(packageManager, "com.samsung.android.app.watchmanager");
            this.androidWear = isPackageInstalled(packageManager, "com.google.android.wearable.app");
            this.addonMiBandTools = isPackageInstalled(packageManager, "cz.zdenekhorak.mibandtools");
            this.addonMiBandNotifyFitness = isPackageInstalled(packageManager, "com.mc.miband1");
            this.addonAmazfitTools = isPackageInstalled(packageManager, "cz.zdenekhorak.amazfittools");
            this.nokiaEvenwell = isPackageInstalled(packageManager, "com.evenwell.powersaving.g3");
            try {
                try {
                    this.samsungSHealthPackageInfo = packageManager.getPackageInfo("com.sec.android.app.shealth", 0);
                    this.samsungSHealth = true;
                } catch (PackageManager.NameNotFoundException unused2) {
                    Logger.logInfo("com.sec.android.app.shealth not installed");
                    this.samsungSHealth = isPackageInstalled(packageManager, "com.samsung.android.sdkapp.health");
                }
                try {
                    this.googleCalendarPackageInfo = packageManager.getPackageInfo("com.google.android.calendar", 0);
                } catch (PackageManager.NameNotFoundException unused3) {
                    Logger.logInfo("com.google.android.calendar not installed");
                }
                try {
                    this.googleFitPackageInfo = packageManager.getPackageInfo("com.google.android.apps.fitness", 0);
                } catch (PackageManager.NameNotFoundException unused4) {
                    Logger.logInfo("com.google.android.apps.fitness not installed");
                }
                try {
                    this.spotifyPackageInfo = packageManager.getPackageInfo("com.spotify.music", 0);
                } catch (PackageManager.NameNotFoundException unused5) {
                    Logger.logInfo("com.spotify.music not installed");
                }
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("TrialFilter: check trial "), this.isTrial);
        if (this.isTrial) {
            try {
                String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
                if (string != null && this.unlockedAndroidIds.contains(string)) {
                    z = false;
                }
                this.isTrial = z;
                Logger.logInfo("TrialFilter: has Android ID " + this.isTrial);
                if (!this.isTrial) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 29 || !SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.READ_PHONE_STATE")) {
                    Logger.logInfo("TrialFilter: Permissions: PHONE Denied ");
                } else {
                    Logger.logInfo("TrialFilter: Permissions: PHONE Granted");
                    TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                    if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null && this.unlockedImeis.contains(deviceId)) {
                        this.isTrial = false;
                        Logger.logInfo("TrialFilter: has IMEI");
                        return;
                    }
                }
            } catch (Exception e3) {
                Logger.logSevere(e3);
            }
        } else {
            this.hasUnlock = true;
        }
        Logger.logDebug("TrialFilter: T status: " + this.isTrial);
    }

    public void refreshByBillingStatus() {
        if (PreferencesUtils.getBillStatus(this.context)) {
            this.isTrial = false;
        }
    }

    public void removeSku(String str) {
        this.skus.remove(str);
    }

    public long timeToExpire() {
        if (isTrial()) {
            return Math.max(0L, calculateTimeToExpire());
        }
        return -1L;
    }

    public boolean tryAirplaneRootHack() {
        if (this.airplaneHelper && Environment.isJellyBeanWithAirplaneRootHack()) {
            return true;
        }
        return this.airplaneHelper43 && Environment.isNewJellyBeanOrGreater();
    }

    public boolean daysUsed(int i, int i2) {
        if (this.firstUsedTime == null) {
            return false;
        }
        long jDaysUsed = daysUsed();
        return jDaysUsed >= ((long) i) && (jDaysUsed <= ((long) i2) || i2 == -1);
    }

    public boolean daysUsed(int i) {
        return daysUsed(i, -1);
    }

    public boolean isPackageInstalled(PackageManager packageManager, String str) {
        if (packageManager == null) {
            return false;
        }
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}
