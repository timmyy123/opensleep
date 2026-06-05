package org.mp4parser.boxes;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class UnknownBox extends AbstractBox {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_1;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_2;

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    ByteBuffer f124data;

    static {
        ajc$preClinit();
    }

    public UnknownBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("UnknownBox.java", UnknownBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getData", "org.mp4parser.boxes.UnknownBox", "", "", "", "java.nio.ByteBuffer"), 53);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setData", "org.mp4parser.boxes.UnknownBox", "java.nio.ByteBuffer", "data", "", "void"), 57);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, InAppPurchaseConstants.METHOD_TO_STRING, "org.mp4parser.boxes.UnknownBox", "", "", "", "java.lang.String"), 62);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.f124data = byteBuffer;
        byteBuffer.position(byteBuffer.remaining() + byteBuffer.position());
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        this.f124data.rewind();
        byteBuffer.put(this.f124data);
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return this.f124data.limit();
    }

    public ByteBuffer getData() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.f124data;
    }

    public void setData(ByteBuffer byteBuffer) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, byteBuffer));
        this.f124data = byteBuffer;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(TwitterImpl$$ExternalSyntheticOutline0.m(Factory.makeJP(ajc$tjp_2, this, this), "UnknownBox{type="), this.type, '}');
    }
}
