package org.eclipse.californium.scandium.dtls;

import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.StringUtil;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ReassemblingHandshakeMessage extends GenericHandshakeMessage {
    private final List<FragmentRange> fragments;
    private final byte[] reassembledBytes;
    private final HandshakeType type;

    public static class FragmentRange {
        private int end;
        private int length;
        private int offset;

        private FragmentRange(int i, int i2) {
            this.offset = i;
            this.length = i2;
            this.end = i + i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void amendEnd(int i) {
            if (this.end < i) {
                this.end = i;
                this.length = i - this.offset;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reduceEnd(int i) {
            if (this.end > i) {
                int i2 = this.offset;
                if (i < i2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("adjusted end before offset!");
                } else {
                    this.end = i;
                    this.length = i - i2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int skipToOffset(int i) {
            int i2 = this.offset;
            if (i2 >= i) {
                return 0;
            }
            int i3 = this.end;
            if (i3 <= i) {
                this.length = 0;
                this.offset = i;
                this.end = i;
                return 0;
            }
            int i4 = i - i2;
            this.offset = i;
            this.length = i3 - i;
            return i4;
        }

        public String toString() {
            return String.format("range[%d:%d)", Integer.valueOf(this.offset), Integer.valueOf(this.end));
        }
    }

    public ReassemblingHandshakeMessage(FragmentedHandshakeMessage fragmentedHandshakeMessage) {
        super(fragmentedHandshakeMessage.getMessageType(), fragmentedHandshakeMessage.getPeer());
        this.fragments = new ArrayList();
        setMessageSeq(fragmentedHandshakeMessage.getMessageSeq());
        this.type = fragmentedHandshakeMessage.getMessageType();
        this.reassembledBytes = new byte[fragmentedHandshakeMessage.getMessageLength()];
        add(0, 0, new FragmentRange(fragmentedHandshakeMessage.getFragmentOffset(), fragmentedHandshakeMessage.getFragmentLength()), fragmentedHandshakeMessage);
    }

    public void add(FragmentedHandshakeMessage fragmentedHandshakeMessage) {
        if (this.type != fragmentedHandshakeMessage.getMessageType()) {
            StringBuilder sb = new StringBuilder("Fragment message type ");
            sb.append(fragmentedHandshakeMessage.getMessageType());
            Utf8$$ExternalSyntheticBUOutline0.m(sb, " differs from ", this.type, "!");
            return;
        }
        if (getMessageSeq() != fragmentedHandshakeMessage.getMessageSeq()) {
            Types$$ExternalSyntheticBUOutline0.m("Fragment message sequence number ", fragmentedHandshakeMessage.getMessageSeq(), " differs from ", getMessageSeq(), "!");
            return;
        }
        if (getMessageLength() != fragmentedHandshakeMessage.getMessageLength()) {
            Types$$ExternalSyntheticBUOutline0.m("Fragment message length ", fragmentedHandshakeMessage.getMessageLength(), " differs from ", getMessageLength(), "!");
            return;
        }
        if (!getPeer().equals(fragmentedHandshakeMessage.getPeer())) {
            StringBuilder sb2 = new StringBuilder("Fragment message peer ");
            sb2.append(fragmentedHandshakeMessage.getPeer());
            Utf8$$ExternalSyntheticBUOutline0.m(sb2, " differs from ", getPeer(), "!");
            return;
        }
        if (isComplete()) {
            return;
        }
        FragmentRange fragmentRange = new FragmentRange(fragmentedHandshakeMessage.getFragmentOffset(), fragmentedHandshakeMessage.getFragmentLength());
        if (getMessageLength() < fragmentRange.end) {
            Types$$ExternalSyntheticBUOutline0.m("Fragment message ", fragmentRange.end, " bytes exceeds message ", getMessageLength(), " bytes!");
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= this.fragments.size()) {
                break;
            }
            FragmentRange fragmentRange2 = this.fragments.get(i);
            if (fragmentRange.offset < fragmentRange2.offset) {
                if (fragmentRange2.offset < fragmentRange.end && fragmentRange.end <= fragmentRange2.end) {
                    fragmentRange.reduceEnd(fragmentRange2.offset);
                }
            } else {
                if (fragmentRange.end <= fragmentRange2.end) {
                    return;
                }
                if (fragmentRange.offset == fragmentRange2.offset) {
                    i++;
                    break;
                } else {
                    i2 = fragmentRange2.end;
                    i++;
                }
            }
        }
        int iSkipToOffset = fragmentRange.skipToOffset(i2);
        if (fragmentRange.length == 0) {
            return;
        }
        add(i, iSkipToOffset, fragmentRange, fragmentedHandshakeMessage);
        FragmentRange fragmentRange3 = this.fragments.get(0);
        int i3 = 1;
        while (i3 < this.fragments.size()) {
            FragmentRange fragmentRange4 = this.fragments.get(i3);
            if (fragmentRange4.offset <= fragmentRange3.end) {
                fragmentRange3.amendEnd(fragmentRange4.end);
                this.fragments.remove(i3);
                i3--;
            } else {
                fragmentRange3 = fragmentRange4;
            }
            i3++;
        }
    }

    @Override // org.eclipse.californium.scandium.dtls.GenericHandshakeMessage, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        return this.reassembledBytes;
    }

    @Override // org.eclipse.californium.scandium.dtls.GenericHandshakeMessage, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.reassembledBytes.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.GenericHandshakeMessage, org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return this.type;
    }

    public boolean isComplete() {
        FragmentRange fragmentRange = this.fragments.get(0);
        return fragmentRange.offset == 0 && getMessageLength() <= fragmentRange.end;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public String toString() {
        return "\tReassembled Handshake Protocol" + StringUtil.lineSeparator() + "\tType: " + getMessageType() + StringUtil.lineSeparator() + "\tPeer: " + getPeer() + StringUtil.lineSeparator() + "\tMessage Sequence No: " + getMessageSeq() + StringUtil.lineSeparator() + "\tFragment Offset: " + getFragmentOffset() + StringUtil.lineSeparator() + "\tFragment Length: " + getFragmentLength() + StringUtil.lineSeparator() + "\tLength: " + getMessageLength() + StringUtil.lineSeparator();
    }

    private void add(int i, int i2, FragmentRange fragmentRange, FragmentedHandshakeMessage fragmentedHandshakeMessage) {
        this.fragments.add(i, fragmentRange);
        System.arraycopy(fragmentedHandshakeMessage.fragmentToByteArray(), i2, this.reassembledBytes, fragmentRange.offset, fragmentRange.length);
    }
}
