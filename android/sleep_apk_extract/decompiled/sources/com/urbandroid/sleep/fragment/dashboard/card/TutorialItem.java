package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialItem;", "", "", "title", "summary", "", "imageRes", "color", "Lkotlin/Function0;", "", "f", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/jvm/functions/Function0;)V", "show", "()V", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "getSummary", "I", "getImageRes", "()I", "getColor", "Lkotlin/jvm/functions/Function0;", "getF", "()Lkotlin/jvm/functions/Function0;", "", "last", "Z", "getLast", "()Z", "setLast", "(Z)V", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int color;
    private final Function0<Unit> f;
    private final int imageRes;
    private boolean last;
    private final String summary;
    private final String title;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ<\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialItem$Companion;", "", "<init>", "()V", "createItemFromRes", "Lcom/urbandroid/sleep/fragment/dashboard/card/TutorialItem;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "titleRes", "", "summaryRes", "imageRes", "colorRes", "f", "Lkotlin/Function0;", "", "summary", "", "title", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TutorialItem createItemFromRes(Activity context, int titleRes, int summaryRes, int imageRes, int colorRes, Function0<Unit> f) {
            context.getClass();
            f.getClass();
            String string = context.getString(titleRes);
            string.getClass();
            String string2 = context.getString(summaryRes);
            string2.getClass();
            return new TutorialItem(string, string2, imageRes, ColorUtil.i(context, colorRes), f);
        }

        private Companion() {
        }

        public final TutorialItem createItemFromRes(Activity context, int titleRes, String summary, int imageRes, int colorRes, Function0<Unit> f) {
            context.getClass();
            summary.getClass();
            f.getClass();
            String string = context.getString(titleRes);
            string.getClass();
            return new TutorialItem(string, summary, imageRes, ColorUtil.i(context, colorRes), f);
        }

        public final TutorialItem createItemFromRes(Activity context, String title, int summaryRes, int imageRes, int colorRes, Function0<Unit> f) {
            context.getClass();
            title.getClass();
            f.getClass();
            String string = context.getString(summaryRes);
            string.getClass();
            return new TutorialItem(title, string, imageRes, ColorUtil.i(context, colorRes), f);
        }

        public final TutorialItem createItemFromRes(Activity context, String title, String summaryRes, int imageRes, int colorRes, Function0<Unit> f) {
            context.getClass();
            title.getClass();
            summaryRes.getClass();
            f.getClass();
            return new TutorialItem(title, summaryRes, imageRes, ColorUtil.i(context, colorRes), f);
        }
    }

    public TutorialItem(String str, String str2, int i, int i2, Function0<Unit> function0) {
        str.getClass();
        str2.getClass();
        function0.getClass();
        this.title = str;
        this.summary = str2;
        this.imageRes = i;
        this.color = i2;
        this.f = function0;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public final boolean getLast() {
        return this.last;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setLast(boolean z) {
        this.last = z;
    }

    public final void show() {
        this.f.invoke();
    }
}
