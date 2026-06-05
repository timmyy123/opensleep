package com.urbandroid.sleep.captcha;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ResourceUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/captcha/CaptchaDrawableUtil;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CaptchaDrawableUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/captcha/CaptchaDrawableUtil$Companion;", "", "<init>", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "captchaId", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Drawable getDrawable(Context context, int captchaId) {
            String lowerCase;
            String activityName;
            context.getClass();
            if (captchaId == 0) {
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_captcha_disabled);
                drawable.getClass();
                return drawable;
            }
            CaptchaInfo captchaInfoFindById = SharedApplicationContext.getCaptchaManager().getFinder().findById(captchaId);
            Logger.logInfo("CAPTCHA DRW " + captchaId + " " + captchaInfoFindById);
            if (captchaInfoFindById == null) {
                ContextCompat.getDrawable(context, R.drawable.ic_captcha_default).getClass();
            }
            String strSubstringAfterLast$default = (captchaInfoFindById == null || (activityName = captchaInfoFindById.getActivityName()) == null) ? null : StringsKt__StringsKt.substringAfterLast$default(activityName, ".", (String) null, 2, (Object) null);
            if (strSubstringAfterLast$default != null) {
                try {
                    lowerCase = strSubstringAfterLast$default.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } catch (Exception unused) {
                    Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.ic_captcha_default);
                    drawable2.getClass();
                    return drawable2;
                }
            } else {
                lowerCase = "default";
            }
            Drawable drawable3 = ContextCompat.getDrawable(context, ResourceUtil.getResourceByName(context, "drawable", "ic_captcha_".concat(lowerCase)));
            if (drawable3 != null) {
                return drawable3;
            }
            Drawable drawable4 = ContextCompat.getDrawable(context, R.drawable.ic_captcha_default);
            drawable4.getClass();
            return drawable4;
        }

        private Companion() {
        }
    }

    public static final Drawable getDrawable(Context context, int i) {
        return INSTANCE.getDrawable(context, i);
    }
}
