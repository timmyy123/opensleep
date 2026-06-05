package com.urbandroid.sleep.fragment.preview;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.app.Activity;
import android.view.View;
import com.urbandroid.sleep.R;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b/\b\u0016\u0018\u0000 b2\u00020\u0001:\u0001bB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B=\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\fBE\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b#\u0010\u0017J\u0019\u0010$\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b$\u0010\u0017J\u0019\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010&\u001a\u00020 H\u0016¢\u0006\u0004\b&\u0010\u0003J\u001b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020 2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010=\u001a\u0004\bB\u0010?\"\u0004\bC\u0010AR\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010D\u001a\u0004\bL\u0010F\"\u0004\bM\u0010HR\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010D\u001a\u0004\bN\u0010F\"\u0004\bO\u0010HR$\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\bP\u0010:\"\u0004\bQ\u0010<R\"\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010D\u001a\u0004\bR\u0010F\"\u0004\bS\u0010HR$\u0010T\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00108\u001a\u0004\bU\u0010:\"\u0004\bV\u0010<R$\u0010W\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u00108\u001a\u0004\bX\u0010:\"\u0004\bY\u0010<R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010D\u001a\u0004\b`\u0010F\"\u0004\ba\u0010H¨\u0006c"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Ljava/io/Serializable;", "<init>", "()V", "", "title", "text", "", "backgroundResource", "bottomBackgroundResource", "imageResource", "anim", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)V", "", "id", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)V", "layout", "setLayout", "(I)Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "res", "setImageBottom", "permission", "setRequiresPermission", "(Ljava/lang/String;)Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "", "points", "addPoints", "([Ljava/lang/String;)Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "parent", "", "adjustLayout", "(Landroid/app/Activity;Landroid/view/View;)V", "setButton", "setCancel", "setImageRes", "action", "charSequence", "dot", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "hasOnlyLatinConsonants", "(Ljava/lang/CharSequence;)Z", "", "getDot", "()C", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "Ljava/io/ObjectInputStream;", "in", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "getText", "setText", "I", "getImageResource", "()I", "setImageResource", "(I)V", "imageBottomResource", "getImageBottomResource", "setImageBottomResource", "getBackgroundResource", "setBackgroundResource", "getBottomBackgroundResource", "setBottomBackgroundResource", "getPermission", "setPermission", "getAnim", "setAnim", "buttonText", "getButtonText", "setButtonText", "cancelText", "getCancelText", "setCancelText", "[Ljava/lang/String;", "getPoints", "()[Ljava/lang/String;", "setPoints", "([Ljava/lang/String;)V", "pageLayout", "getPageLayout", "setPageLayout", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PreviewPage implements Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PreviewPage LAST_PAGE = new PreviewPage();
    private static final String NO_BUTTON = "NO_BUTTON";
    private int anim;
    private int backgroundResource;
    private int bottomBackgroundResource;
    private String buttonText;
    private String cancelText;
    private String id;
    private int imageBottomResource;
    private int imageResource;
    private int pageLayout;
    private String permission;
    private String[] points;
    private transient CharSequence text;
    private transient CharSequence title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/PreviewPage$Companion;", "", "<init>", "()V", "LAST_PAGE", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "getLAST_PAGE", "()Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "NO_BUTTON", "", "getNO_BUTTON", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PreviewPage getLAST_PAGE() {
            return PreviewPage.LAST_PAGE;
        }

        public final String getNO_BUTTON() {
            return PreviewPage.NO_BUTTON;
        }

        private Companion() {
        }
    }

    public PreviewPage(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        this.id = getClass().getSimpleName();
        this.imageResource = -1;
        this.imageBottomResource = -1;
        this.backgroundResource = -1;
        this.bottomBackgroundResource = -1;
        this.anim = -1;
        this.points = new String[0];
        this.pageLayout = R.layout.fragment_preview_page;
        this.title = charSequence;
        this.text = dot(charSequence2);
        this.backgroundResource = i;
        this.bottomBackgroundResource = i2;
        this.anim = i4;
        this.imageResource = i3;
    }

    private final CharSequence dot(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        int length = StringsKt.trim(charSequence).length() - 1;
        if (length <= 0 || hasOnlyLatinConsonants(charSequence) || charSequence.charAt(length) == getDot() || charSequence.charAt(length) == '!' || charSequence.charAt(length) == '?') {
            return charSequence;
        }
        CharSequence charSequenceTrim = StringsKt.trim(charSequence);
        char dot = getDot();
        StringBuilder sb = new StringBuilder();
        sb.append((Object) charSequenceTrim);
        sb.append(dot);
        return sb.toString();
    }

    private final char getDot() {
        return Locale.JAPANESE.getLanguage().equals(Locale.getDefault().getLanguage()) ? (char) 12290 : '.';
    }

    private final boolean hasOnlyLatinConsonants(CharSequence charSequence) {
        String strNormalize = Normalizer.normalize(charSequence, Normalizer.Form.NFD);
        strNormalize.getClass();
        String lowerCase = StringsKt.replace$default(strNormalize, "\\p{InCombiningDiacriticalMarks}+", "").toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        if (new Regex("\\p{script=Latin}+").matches(lowerCase)) {
            return !new Regex("[aeiou]").containsMatchIn(lowerCase);
        }
        return false;
    }

    private final void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        if (out == null) {
            OggIO$$ExternalSyntheticBUOutline0.m("Error while writing object");
            return;
        }
        out.defaultWriteObject();
        out.writeObject(this.title);
        out.writeObject(this.text);
    }

    public void action() {
    }

    public PreviewPage addPoints(String[] points) {
        points.getClass();
        this.points = points;
        return this;
    }

    public void adjustLayout(Activity activity, View parent) {
        activity.getClass();
        parent.getClass();
    }

    public final int getAnim() {
        return this.anim;
    }

    public final int getBackgroundResource() {
        return this.backgroundResource;
    }

    public final int getBottomBackgroundResource() {
        return this.bottomBackgroundResource;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final String getId() {
        return this.id;
    }

    public final int getImageBottomResource() {
        return this.imageBottomResource;
    }

    public final int getImageResource() {
        return this.imageResource;
    }

    public final int getPageLayout() {
        return this.pageLayout;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final String[] getPoints() {
        return this.points;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public PreviewPage setButton(String text) {
        this.buttonText = text;
        return this;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public PreviewPage setCancel(String text) {
        this.cancelText = text;
        return this;
    }

    public PreviewPage setImageBottom(int res) {
        this.imageBottomResource = res;
        return this;
    }

    public PreviewPage setImageRes(int res) {
        this.imageResource = res;
        return this;
    }

    public PreviewPage setLayout(int layout) {
        this.pageLayout = layout;
        return this;
    }

    public final void setPageLayout(int i) {
        this.pageLayout = i;
    }

    public PreviewPage setRequiresPermission(String permission) {
        permission.getClass();
        this.permission = permission;
        return this;
    }

    public PreviewPage() {
        this.id = getClass().getSimpleName();
        this.imageResource = -1;
        this.imageBottomResource = -1;
        this.backgroundResource = -1;
        this.bottomBackgroundResource = -1;
        this.anim = -1;
        this.points = new String[0];
        this.pageLayout = R.layout.fragment_preview_page;
    }

    public PreviewPage(String str, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        str.getClass();
        this.imageResource = -1;
        this.imageBottomResource = -1;
        this.backgroundResource = -1;
        this.bottomBackgroundResource = -1;
        this.anim = -1;
        this.points = new String[0];
        this.pageLayout = R.layout.fragment_preview_page;
        this.id = str;
        this.title = charSequence;
        this.text = dot(charSequence2);
        this.backgroundResource = i;
        this.bottomBackgroundResource = i2;
        this.anim = i4;
        this.imageResource = i3;
    }
}
