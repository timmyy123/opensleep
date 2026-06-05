package com.garmin.android.connectiq;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Build;
import android.util.Base64;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u001d\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001dR \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/garmin/android/connectiq/IQTrustedGarminPackageVerifier;", "", "()V", "TrustedPackagesAndHashes", "", "", "", "gcmSignatureList", "checkTrustedPackage", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "packageName", "enforceTrustedPackage", "", "getPackageNameForUid", "uid", "", "getPackageSignature", "Landroid/content/pm/Signature;", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageSignatureHash", "getSignatureHash", "signature", "getSignersFromPackageInfo", "", "packageInfo", "Landroid/content/pm/PackageInfo;", "(Landroid/content/pm/PackageInfo;)[Landroid/content/pm/Signature;", "connectiq-companion-app-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IQTrustedGarminPackageVerifier {
    public static final IQTrustedGarminPackageVerifier INSTANCE = new IQTrustedGarminPackageVerifier();
    private static final Map<String, Set<String>> TrustedPackagesAndHashes;
    private static final Set<String> gcmSignatureList;

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{"ZDGzxtZUafh0Nb_0KPUKscpcu4f1YBkHDwPA6OOeFik", "hP8r-jlcWiHlOuKWM-Sm5otrXGcHu2CEwltw-Ga3Fyk"});
        gcmSignatureList = of;
        TrustedPackagesAndHashes = MapsKt.mapOf(TuplesKt.to("com.garmin.android.apps.connectmobile", of));
    }

    private IQTrustedGarminPackageVerifier() {
    }

    private final boolean checkTrustedPackage(Context context, String packageName) {
        Set<String> set;
        String packageSignatureHash = getPackageSignatureHash(context, packageName);
        Map<String, Set<String>> map = TrustedPackagesAndHashes;
        return map.containsKey(packageName) && (set = map.get(packageName)) != null && set.contains(packageSignatureHash);
    }

    private final String getPackageNameForUid(Context context, int uid) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(uid);
        if (packagesForUid == null || packagesForUid.length == 0) {
            throw new SecurityException(FileInsert$$ExternalSyntheticOutline0.m(uid, "No packages found for UID: "));
        }
        if (packagesForUid.length > 1) {
            throw new SecurityException(FileInsert$$ExternalSyntheticOutline0.m(uid, "Multiple packages found for UID: "));
        }
        String str = packagesForUid[0];
        str.getClass();
        return str;
    }

    private final Signature getPackageSignature(PackageManager packageManager, String packageName) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, Build.VERSION.SDK_INT >= 28 ? 134217728 : 64);
            packageInfo.getClass();
            if (!Intrinsics.areEqual(packageName, packageInfo.packageName)) {
                throw new SecurityException(Fragment$$ExternalSyntheticOutline1.m("Package name mismatch: expected ", packageName, ", found ", packageInfo.packageName));
            }
            Signature[] signersFromPackageInfo = getSignersFromPackageInfo(packageInfo);
            if (signersFromPackageInfo == null || signersFromPackageInfo.length == 0) {
                throw new SecurityException(FileInsert$$ExternalSyntheticOutline0.m("No signatures found for package: ", packageName));
            }
            return signersFromPackageInfo[0];
        } catch (PackageManager.NameNotFoundException unused) {
            throw new SecurityException(FileInsert$$ExternalSyntheticOutline0.m("Package not found: ", packageName));
        }
    }

    private final String getPackageSignatureHash(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        packageManager.getClass();
        return getSignatureHash(getPackageSignature(packageManager, packageName));
    }

    private final String getSignatureHash(Signature signature) {
        try {
            String strEncodeToString = Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(signature.toByteArray()), 11);
            strEncodeToString.getClass();
            return strEncodeToString;
        } catch (NoSuchAlgorithmException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        }
    }

    private final Signature[] getSignersFromPackageInfo(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT < 28) {
            return packageInfo.signatures;
        }
        SigningInfo signingInfo = packageInfo.signingInfo;
        return (signingInfo == null || signingInfo.hasMultipleSigners()) ? packageInfo.signatures : signingInfo.getSigningCertificateHistory();
    }

    public final void enforceTrustedPackage(Context context) {
        context.getClass();
        String packageNameForUid = getPackageNameForUid(context, Binder.getCallingUid());
        if (!checkTrustedPackage(context, packageNameForUid)) {
            throw new SecurityException(FileInsert$$ExternalSyntheticOutline0.m("Untrusted package: ", packageNameForUid));
        }
    }
}
