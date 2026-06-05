package com.facebook.share.model;

import android.os.Parcel;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\b\u0014\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton;", "Lcom/facebook/share/model/ShareModel;", "builder", "Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "(Lcom/facebook/share/model/ShareMessengerActionButton$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "title", "", "getTitle", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "flags", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001a\u00028\u00012\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00028\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "M", "Lcom/facebook/share/model/ShareMessengerActionButton;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", "title", "", "getTitle$facebook_common_release", "()Ljava/lang/String;", "setTitle$facebook_common_release", "(Ljava/lang/String;)V", "readFrom", DeviceRequestsHelper.DEVICE_INFO_MODEL, "(Lcom/facebook/share/model/ShareMessengerActionButton;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "setTitle", "(Ljava/lang/String;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        private String title;

        /* JADX INFO: renamed from: getTitle$facebook_common_release, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(M model) {
            return model == null ? this : (B) setTitle(model.getTitle());
        }

        public final B setTitle(String title) {
            this.title = title;
            return this;
        }

        public final void setTitle$facebook_common_release(String str) {
            this.title = str;
        }
    }

    public ShareMessengerActionButton(Builder<?, ?> builder) {
        builder.getClass();
        this.title = builder.getTitle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.title);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        parcel.getClass();
        this.title = parcel.readString();
    }
}
