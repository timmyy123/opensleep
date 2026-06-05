package com.urbandroid.sleep.media;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.documentfile.provider.DocumentFile;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseDirectory {
    private final Context context;

    /* JADX INFO: loaded from: classes5.dex */
    public enum State {
        NOT_FOUND,
        DELETED,
        NOT_DELETED
    }

    public NoiseDirectory(Context context) {
        this.context = context;
    }

    public static boolean checkReadWriteAccessUri(Context context, Uri uri) {
        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(context, uri);
        boolean zCanRead = documentFileFromTreeUri.canRead();
        boolean zCanWrite = documentFileFromTreeUri.canWrite();
        Logger.logInfo("Picked dir access: read " + zCanRead + " write: " + zCanWrite);
        if (zCanRead && zCanWrite) {
            return true;
        }
        if (zCanRead) {
            Toast.makeText(context, "No write access to " + uri, 0).show();
        } else {
            Toast.makeText(context, "No read access to " + uri, 0).show();
        }
        return false;
    }

    public static boolean exists(Context context, String str) {
        return isContentUri(str) ? new NoiseDirectory(context).exists(str) : new File(str).exists();
    }

    public static String getDefaultStoragePath(Context context) {
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        if (!Experiments.getInstance().isScopedStorageExperiment()) {
            return com.urbandroid.common.util.Environment.getExternalPublicWriteableStorage().getAbsolutePath();
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        return (externalFilesDir == null || Environment.isExternalStorageEmulated(externalFilesDir) || zEquals) ? context.getFilesDir().getAbsolutePath() : externalFilesDir.getAbsolutePath();
    }

    public static String getHumanReadablePath(Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        if (string.startsWith("content://com.android.externalstorage.documents/tree/primary%3A")) {
            string = "Internal:".concat(string.substring(63));
        } else if (string.startsWith("content://com.android.externalstorage.documents/tree/")) {
            string = "SD Card:".concat(string.substring(53));
        } else if (string.startsWith("content://com.android.providers.media.documents/document")) {
            string = string.substring(56);
        } else if (string.startsWith("content://com.google.android.apps.docs.storage/document/")) {
            string = "Google Drive:".concat(string.substring(56));
        } else if (string.startsWith("content://com.android.providers.downloads.documents/document/")) {
            string = "Downloads/".concat(string.substring(61));
        }
        try {
            return URLDecoder.decode(string, OAuth.ENCODING);
        } catch (UnsupportedEncodingException e) {
            Logger.logWarning("Unable decode string: ".concat(string), e);
            return string;
        }
    }

    public static boolean isContentUri(String str) {
        return str != null && str.startsWith("content://");
    }

    public State delete(String str) {
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.context, Uri.parse(str));
        if (documentFileFromSingleUri == null || !documentFileFromSingleUri.exists()) {
            return State.NOT_FOUND;
        }
        boolean zCanRead = documentFileFromSingleUri.canRead();
        boolean zCanWrite = documentFileFromSingleUri.canWrite();
        boolean zDelete = documentFileFromSingleUri.delete();
        if (zDelete) {
            Logger.logDebug(str + " ... deleted");
        } else {
            Logger.logDebug("Unable delete " + str + " CanRead: " + zCanRead + " CanWrite: " + zCanWrite);
        }
        if (!zDelete) {
            try {
                Logger.logDebug("Deleting through content provider, deleted " + (this.context.getContentResolver().delete(Uri.parse(str), null, null) > 0));
                return State.DELETED;
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return zDelete ? State.DELETED : State.NOT_DELETED;
    }

    public OutputStream getOutputStream(DocumentFile documentFile) {
        return this.context.getContentResolver().openOutputStream(documentFile.getUri());
    }

    public boolean isContentUriDirAccessible() {
        DocumentFile documentFileFindFile;
        Uri noiseDirUri = SharedApplicationContext.getSettings().getNoiseDirUri();
        if (noiseDirUri == null) {
            Logger.logWarning("Noise dir not picked yet");
            return false;
        }
        DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.context, noiseDirUri);
        boolean z = documentFileFromTreeUri != null && documentFileFromTreeUri.exists() && documentFileFromTreeUri.canRead() && documentFileFromTreeUri.canWrite();
        if (!z) {
            if (documentFileFromTreeUri != null) {
                Logger.logWarning("Noise dir " + noiseDirUri.toString() + " exists:" + documentFileFromTreeUri.exists() + " canRead:" + documentFileFromTreeUri.canRead() + " canWrite:" + documentFileFromTreeUri.canWrite());
                try {
                    DocumentFile documentFileFindFile2 = documentFileFromTreeUri.findFile("rec");
                    if (documentFileFindFile2 == null && (documentFileFindFile = documentFileFromTreeUri.findFile("sleep-data")) != null) {
                        documentFileFindFile2 = documentFileFindFile.findFile("rec");
                    }
                    Logger.logInfo("Noise dir: Has rec child " + documentFileFindFile2);
                    if (documentFileFindFile2 != null && documentFileFindFile2.exists() && documentFileFindFile2.canRead()) {
                        if (documentFileFindFile2.canWrite()) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    Logger.logSevere(e);
                    return z;
                }
            }
            Logger.logWarning("Noise dir not found via saf");
        }
        return z;
    }

    public DocumentFile prepareDocumentDir(boolean z) throws NoiseDirectoryException {
        DocumentFile documentFileCreateFile;
        Uri noiseDirUri = SharedApplicationContext.getSettings().getNoiseDirUri();
        if (noiseDirUri == null) {
            throw new NoiseDirectoryException("No noise uri stored at settings");
        }
        try {
            DocumentFile documentFileFromTreeUri = DocumentFile.fromTreeUri(this.context, noiseDirUri);
            if (documentFileFromTreeUri == null || !documentFileFromTreeUri.exists()) {
                throw new NoiseDirectoryException("Noise uri does not exist: " + noiseDirUri);
            }
            DocumentFile documentFileFindFile = documentFileFromTreeUri.findFile("sleep-data");
            if ((documentFileFindFile == null || !documentFileFindFile.exists()) && (documentFileFindFile = documentFileFromTreeUri.createDirectory("sleep-data")) == null) {
                throw new NoiseDirectoryException("Unable to create dir: " + documentFileFromTreeUri.getUri() + "/sleep-data");
            }
            DocumentFile documentFileFindFile2 = documentFileFindFile.findFile("rec");
            if ((documentFileFindFile2 == null || !documentFileFindFile2.exists()) && (documentFileFindFile2 = documentFileFindFile.createDirectory("rec")) == null) {
                throw new NoiseDirectoryException("Unable to create dir: " + documentFileFindFile.getUri() + "/rec");
            }
            if (!documentFileFindFile2.isDirectory() || !documentFileFindFile2.exists()) {
                throw new NoiseDirectoryException("Enable to access noise dir: " + documentFileFindFile2.getUri());
            }
            DocumentFile documentFileFindFile3 = documentFileFindFile2.findFile(".nomedia");
            if ((documentFileFindFile3 == null || !documentFileFindFile3.exists()) && ((documentFileCreateFile = documentFileFindFile2.createFile("text/nomedia", ".nomedia")) == null || !documentFileCreateFile.exists())) {
                Logger.logWarning("Can't create .nomedia file: " + documentFileCreateFile);
            }
            return z ? documentFileFindFile2 : documentFileFindFile;
        } catch (SecurityException e) {
            Logger.logSevere("prepareNoiseDir", e);
            throw new NoiseDirectoryException(e.toString());
        }
    }

    public DocumentFile prepareNoiseDir() {
        return prepareDocumentDir(true);
    }

    public boolean exists(String str) {
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.context, Uri.parse(str));
        return documentFileFromSingleUri != null && documentFileFromSingleUri.exists();
    }
}
