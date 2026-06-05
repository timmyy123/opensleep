package com.urbandroid.sleep.share.util;

import android.content.Context;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class CommentBuilderUtil {
    public static String createAsleepComment(Context context) {
        return context.getString(R.string.facebook_sleep_start_status) + " " + DateUtil.getShortDateInstanceWithoutYearsWithTime(context, null).format(new Date()) + " (" + context.getString(R.string.app_name_long) + ")";
    }
}
