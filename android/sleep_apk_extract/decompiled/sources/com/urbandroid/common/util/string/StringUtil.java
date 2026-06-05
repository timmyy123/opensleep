package com.urbandroid.common.util.string;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StringUtil {
    public static String countOrder(Context context, int i) {
        return i != 1 ? i != 2 ? i != 3 ? context.getString(R.string.count_many, Integer.valueOf(i)) : context.getString(R.string.count_third) : context.getString(R.string.count_second) : context.getString(R.string.count_first);
    }

    public static String getStringFromInputStream(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            Logger.logSevere("IOException in stream", e);
            return "";
        }
    }
}
