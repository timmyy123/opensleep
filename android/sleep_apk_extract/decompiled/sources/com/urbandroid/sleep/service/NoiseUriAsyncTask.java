package com.urbandroid.sleep.service;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.FileProvider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.media.NoiseDirectory;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0004\u0018\u00010\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000b\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/service/NoiseUriAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/urbandroid/sleep/domain/Noise;", "Ljava/lang/Void;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "withFileToUriConvertion", "()Lcom/urbandroid/sleep/service/NoiseUriAsyncTask;", "", "noises", "doInBackground", "([Lcom/urbandroid/sleep/domain/Noise;)Ljava/lang/String;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "convertFileToUri", "Z", "getConvertFileToUri", "()Z", "setConvertFileToUri", "(Z)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class NoiseUriAsyncTask extends AsyncTask<Noise, Void, String> {
    private final Context context;
    private boolean convertFileToUri;

    public NoiseUriAsyncTask(Context context) {
        context.getClass();
        this.context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(Noise... noises) throws Throwable {
        String string;
        noises.getClass();
        Noise noise = (Noise) ArraysKt.firstOrNull(noises);
        Uri uriForFile = null;
        if (noise == null) {
            return null;
        }
        if (noise.isSync()) {
            Uri noiseMediaStoreUri = NoiseMediaStoreJob.INSTANCE.getNoiseMediaStoreUri(this.context, noise);
            Logger.logInfo("PlayAudioActivity Noise MediaStore uri " + noiseMediaStoreUri);
            string = noiseMediaStoreUri != null ? noiseMediaStoreUri.toString() : null;
        }
        if (string != null) {
            return string;
        }
        String uriFix = noise.getUriFix(this.context);
        Logger.logInfo("Noise.getFixUri() '" + noise.getUri() + "' -> '" + uriFix + "'");
        if (uriFix == null) {
            return null;
        }
        if (NoiseDirectory.isContentUri(uriFix)) {
            return uriFix;
        }
        try {
            Context context = this.context;
            uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", new File(uriFix));
        } catch (Exception e) {
            Logger.logSevere(null, e);
        }
        return uriForFile != null ? uriForFile.toString() : uriFix;
    }

    public final NoiseUriAsyncTask withFileToUriConvertion() {
        this.convertFileToUri = true;
        return this;
    }
}
