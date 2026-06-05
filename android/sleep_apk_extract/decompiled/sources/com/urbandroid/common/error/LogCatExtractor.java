package com.urbandroid.common.error;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.BoundedLinkedList;
import com.urbandroid.common.util.Environment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LogCatExtractor {
    public static List<String> getLogcatOutput(String str, int i, String str2) {
        int iIndexOf;
        BoundedLinkedList boundedLinkedList = null;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            if (str != null) {
                arrayList.add("-b");
                arrayList.add(str);
            }
            ArrayList arrayList2 = new ArrayList(Arrays.asList("-t", String.valueOf(i), "-v", "time"));
            if (Environment.getAPILevel() < 8 && (iIndexOf = arrayList2.indexOf("-t")) > -1 && iIndexOf < arrayList2.size()) {
                arrayList2.remove(iIndexOf + 1);
                arrayList2.remove(iIndexOf);
                arrayList2.add("-d");
            }
            BoundedLinkedList boundedLinkedList2 = new BoundedLinkedList(i);
            try {
                arrayList.addAll(arrayList2);
                arrayList.add("*:" + str2);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()])).getInputStream()));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        return boundedLinkedList2;
                    }
                    boundedLinkedList2.add(line + "\n");
                }
            } catch (IOException e) {
                e = e;
                boundedLinkedList = boundedLinkedList2;
                Logger.logWarning("Failed to retrieve data from Logcat.", e);
                return boundedLinkedList;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static List<String> getLogcatOutput(int i, String str) {
        return getLogcatOutput("main", i, str);
    }
}
