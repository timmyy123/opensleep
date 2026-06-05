package kotlin.io;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Ljava/io/File;", "", "deleteRecursively", "(Ljava/io/File;)Z", "", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", ShareConstants.MEDIA_EXTENSION, "kotlin-stdlib"}, k = 5, mv = {2, 3, 0}, xi = 49, xs = "kotlin/io/FilesKt")
public abstract class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static boolean deleteRecursively(File file) {
        file.getClass();
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt__FileTreeWalkKt.walkBottomUp(file)) {
                if (!file2.delete() && file2.exists()) {
                    z = false;
                } else {
                    if (z) {
                        break;
                    }
                    z = false;
                }
            }
            return z;
        }
    }

    public static String getExtension(File file) {
        file.getClass();
        String name = file.getName();
        name.getClass();
        return StringsKt__StringsKt.substringAfterLast(name, '.', "");
    }
}
