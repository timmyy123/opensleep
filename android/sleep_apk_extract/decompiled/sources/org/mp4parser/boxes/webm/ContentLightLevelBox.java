package org.mp4parser.boxes.webm;

import com.facebook.appevents.AppEventsConstants;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class ContentLightLevelBox extends AbstractFullBox {
    public static final String TYPE = "CoLL";
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_1;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_2;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_3;
    private int maxCLL;
    private int maxFALL;

    static {
        ajc$preClinit();
    }

    public ContentLightLevelBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("ContentLightLevelBox.java", ContentLightLevelBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getMaxCLL", "org.mp4parser.boxes.webm.ContentLightLevelBox", "", "", "", "int"), 38);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setMaxCLL", "org.mp4parser.boxes.webm.ContentLightLevelBox", "int", "maxCLL", "", "void"), 42);
        ajc$tjp_2 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getMaxFALL", "org.mp4parser.boxes.webm.ContentLightLevelBox", "", "", "", "int"), 46);
        ajc$tjp_3 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setMaxFALL", "org.mp4parser.boxes.webm.ContentLightLevelBox", "int", "maxFALL", "", "void"), 50);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxCLL = IsoTypeReader.readUInt16(byteBuffer);
        this.maxFALL = IsoTypeReader.readUInt16(byteBuffer);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt16(byteBuffer, this.maxCLL);
        IsoTypeWriter.writeUInt16(byteBuffer, this.maxFALL);
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return 8L;
    }

    public int getMaxCLL() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.maxCLL;
    }

    public int getMaxFALL() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
        return this.maxFALL;
    }

    public void setMaxCLL(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
        this.maxCLL = i;
    }

    public void setMaxFALL(int i) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
        this.maxFALL = i;
    }
}
