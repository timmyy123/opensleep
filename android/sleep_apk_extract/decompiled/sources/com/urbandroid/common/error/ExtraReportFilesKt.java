package com.urbandroid.common.error;

import com.urbandroid.common.logging.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"parseExtraFiles", "", "Ljava/io/File;", "errorReport", "", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class ExtraReportFilesKt {
    public static final List<File> parseExtraFiles(String str) {
        str.getClass();
        try {
            List list = SequencesKt.toList(Regex.findAll$default(new Regex("extra_attachment_files:\t\\[.*"), str, 0, 2, null));
            if (list.isEmpty()) {
                Logger.logInfo("AttachExtraFiles: No extra_attachment_files found.");
                return CollectionsKt.emptyList();
            }
            if (list.size() > 1) {
                Logger.logInfo("AttachExtraFiles: Multiple extra_attachment_files found, ignoring all.");
                return CollectionsKt.emptyList();
            }
            String value = ((MatchResult) list.get(0)).getValue();
            if (value.length() < 27) {
                return CollectionsKt.emptyList();
            }
            String strSubstring = value.substring(25, value.length() - 1);
            Logger.logInfo("AttachExtraFiles: files str: ".concat(strSubstring));
            List listSplit$default = StringsKt.split$default(strSubstring, new String[]{","}, 0, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                File file = (File) obj;
                if (!file.exists()) {
                    Logger.logInfo("AttachExtraFiles: does not exist: " + file);
                } else if (!file.canRead()) {
                    Logger.logInfo("AttachExtraFiles: can not read: " + file);
                } else if (file.length() <= 0) {
                    Logger.logInfo("AttachExtraFiles: is empty: " + file);
                } else {
                    arrayList2.add(obj);
                }
            }
            Logger.logInfo("AttachExtraFiles: files: " + arrayList2);
            return arrayList2;
        } catch (Exception e) {
            Logger.logSevere("ExtraReportFiles.parseExtraFiles", e);
            return CollectionsKt.emptyList();
        }
    }
}
