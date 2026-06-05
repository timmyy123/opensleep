package com.urbandroid.sleep.captcha.list;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0002\u0016\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\"\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/AbstractCaptchaDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "<init>", "()V", "", "dismiss", "", "perAlarm", "Z", "getPerAlarm", "()Z", "setPerAlarm", "(Z)V", "", "selectedCaptchaId", "I", "getSelectedCaptchaId", "()I", "setSelectedCaptchaId", "(I)V", "Companion", "OnCloseListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractCaptchaDialogFragment extends DialogFragment implements ICaptchaTileList {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NOT_INITIALIZED = Integer.MIN_VALUE;
    private boolean perAlarm;
    private int selectedCaptchaId = NOT_INITIALIZED;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/AbstractCaptchaDialogFragment$Companion;", "", "<init>", "()V", "", "NOT_INITIALIZED", "I", "getNOT_INITIALIZED", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getNOT_INITIALIZED() {
            return AbstractCaptchaDialogFragment.NOT_INITIALIZED;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/AbstractCaptchaDialogFragment$OnCloseListener;", "", "onClose", "", "selectedCaptchaId", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnCloseListener {
        void onClose(int selectedCaptchaId);
    }

    @Override // androidx.fragment.app.DialogFragment, com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public void dismiss() {
        super.dismiss();
    }

    @Override // com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public boolean getPerAlarm() {
        return this.perAlarm;
    }

    public int getSelectedCaptchaId() {
        return this.selectedCaptchaId;
    }

    public void setPerAlarm(boolean z) {
        this.perAlarm = z;
    }

    @Override // com.urbandroid.sleep.captcha.list.ICaptchaTileList
    public void setSelectedCaptchaId(int i) {
        this.selectedCaptchaId = i;
    }
}
