package com.urbandroid.sleep;

import android.content.Context;
import android.net.Uri;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.FileProvider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.DefaultRingtoneResolveService;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.Md5Util;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0015\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\t\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\"\u001b\u0010\u000e\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\u00008\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "md5", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/net/Uri;", "getActualDefaultRingtoneUri", "(Landroid/content/Context;)Landroid/net/Uri;", "Ljava/io/File;", "toUri", "(Ljava/io/File;Landroid/content/Context;)Landroid/net/Uri;", "", "isOurExperimentalPhone$delegate", "Lkotlin/Lazy;", "isOurExperimentalPhone", "()Z", "FALLBACK_RING_TONE_URI", "Ljava/lang/String;", "Sleep_prodRelease"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "com/urbandroid/sleep/SleepUtils")
abstract /* synthetic */ class SleepUtils__SleepCommonsKt {
    private static final Lazy isOurExperimentalPhone$delegate = LazyKt.lazy(new SleepUtils__SleepCommonsKt$$ExternalSyntheticLambda0());

    public static final Uri getActualDefaultRingtoneUri(Context context) {
        Object next;
        context.getClass();
        Settings settings = new Settings(context);
        if (settings.getActualDefaultRingtoneUri() != null) {
            Uri uri = Uri.parse(settings.getActualDefaultRingtoneUri());
            uri.getClass();
            return uri;
        }
        DefaultRingtoneResolveService.INSTANCE.start(context);
        List<InternalRingtones.InternalRingtone> ringtoneList = InternalRingtones.getRingtoneList();
        ringtoneList.getClass();
        Iterator<T> it = ringtoneList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InternalRingtones.InternalRingtone) next).getTitleRes() == R.string.ringtone_nature_BIRDS) {
                break;
            }
        }
        InternalRingtones.InternalRingtone internalRingtone = (InternalRingtones.InternalRingtone) next;
        if (internalRingtone == null) {
            internalRingtone = (InternalRingtones.InternalRingtone) CollectionsKt.firstOrNull((List) ringtoneList);
        }
        if (internalRingtone != null) {
            Uri uri2 = Uri.parse(internalRingtone.getUri());
            uri2.getClass();
            return uri2;
        }
        Logger.logWarning("no internal rigntone found - selecting fallback: android.resource://com.urbandroid.sleep/raw/fallbackring");
        Uri uri3 = Uri.parse("android.resource://com.urbandroid.sleep/raw/fallbackring");
        uri3.getClass();
        return uri3;
    }

    public static final boolean isOurExperimentalPhone() {
        return ((Boolean) isOurExperimentalPhone$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isOurExperimentalPhone_delegate$lambda$0$SleepUtils__SleepCommonsKt() {
        return Experiments.getInstance().isOurExperimentalPhone();
    }

    public static final String md5(String str) {
        if (str == null) {
            return null;
        }
        return Md5Util.md5(str);
    }

    public static final Uri toUri(File file, Context context) {
        file.getClass();
        context.getClass();
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        uriForFile.getClass();
        return uriForFile;
    }
}
