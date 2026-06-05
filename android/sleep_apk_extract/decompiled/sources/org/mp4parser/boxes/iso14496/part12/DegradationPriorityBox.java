package org.mp4parser.boxes.iso14496.part12;

import com.facebook.appevents.AppEventsConstants;
import java.nio.ByteBuffer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
import org.mp4parser.support.AbstractFullBox;
import org.mp4parser.support.RequiresParseDetailAspect;
import org.mp4parser.tools.IsoTypeReader;
import org.mp4parser.tools.IsoTypeWriter;

/* JADX INFO: loaded from: classes5.dex */
public class DegradationPriorityBox extends AbstractFullBox {
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_0;
    private static /* synthetic */ JoinPoint.StaticPart ajc$tjp_1;
    int[] priorities;

    static {
        ajc$preClinit();
    }

    public DegradationPriorityBox() {
        super("stdp");
        this.priorities = new int[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("DegradationPriorityBox.java", DegradationPriorityBox.class);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "getPriorities", "org.mp4parser.boxes.iso14496.part12.DegradationPriorityBox", "", "", "", "[I"), 38);
        ajc$tjp_1 = factory.makeSJP("method-execution", factory.makeMethodSig(AppEventsConstants.EVENT_PARAM_VALUE_YES, "setPriorities", "org.mp4parser.boxes.iso14496.part12.DegradationPriorityBox", "[I", "priorities", "", "void"), 42);
    }

    @Override // org.mp4parser.support.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.priorities = new int[byteBuffer.remaining() / 2];
        int i = 0;
        while (true) {
            int[] iArr = this.priorities;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = IsoTypeReader.readUInt16(byteBuffer);
            i++;
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (int i : this.priorities) {
            IsoTypeWriter.writeUInt16(byteBuffer, i);
        }
    }

    @Override // org.mp4parser.support.AbstractBox
    public long getContentSize() {
        return (this.priorities.length * 2) + 4;
    }

    public int[] getPriorities() {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
        return this.priorities;
    }

    public void setPriorities(int[] iArr) {
        RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, iArr));
        this.priorities = iArr;
    }
}
