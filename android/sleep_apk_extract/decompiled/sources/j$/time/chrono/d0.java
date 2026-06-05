package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;
    public byte a;
    public Object b;

    public d0(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    private Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objOf;
        byte b = objectInput.readByte();
        this.a = b;
        switch (b) {
            case 1:
                ConcurrentHashMap concurrentHashMap = a.a;
                objOf = k.of(objectInput.readUTF());
                break;
            case 2:
                objOf = ((b) objectInput.readObject()).z((LocalTime) objectInput.readObject());
                break;
            case 3:
                objOf = ((ChronoLocalDateTime) objectInput.readObject()).w((ZoneOffset) objectInput.readObject()).v((ZoneId) objectInput.readObject());
                break;
            case 4:
                LocalDate localDate = w.d;
                int i = objectInput.readInt();
                byte b2 = objectInput.readByte();
                byte b3 = objectInput.readByte();
                u.c.getClass();
                objOf = new w(LocalDate.of(i, b2, b3));
                break;
            case 5:
                x xVar = x.d;
                objOf = x.q(objectInput.readByte());
                break;
            case 6:
                n nVar = (n) objectInput.readObject();
                int i2 = objectInput.readInt();
                byte b4 = objectInput.readByte();
                byte b5 = objectInput.readByte();
                nVar.getClass();
                objOf = new p(nVar, i2, b4, b5);
                break;
            case 7:
                int i3 = objectInput.readInt();
                byte b6 = objectInput.readByte();
                byte b7 = objectInput.readByte();
                z.c.getClass();
                objOf = new b0(LocalDate.of(i3 + 1911, b6, b7));
                break;
            case 8:
                int i4 = objectInput.readInt();
                byte b8 = objectInput.readByte();
                byte b9 = objectInput.readByte();
                f0.c.getClass();
                objOf = new h0(LocalDate.of(i4 - 543, b8, b9));
                break;
            case 9:
                int i5 = g.e;
                objOf = new g(k.of(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.b = objOf;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                objectOutput.writeUTF(((a) obj).getId());
                return;
            case 2:
                f fVar = (f) obj;
                objectOutput.writeObject(fVar.a);
                objectOutput.writeObject(fVar.b);
                return;
            case 3:
                j jVar = (j) obj;
                objectOutput.writeObject(jVar.a);
                objectOutput.writeObject(jVar.b);
                objectOutput.writeObject(jVar.c);
                return;
            case 4:
                w wVar = (w) obj;
                wVar.getClass();
                objectOutput.writeInt(wVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(wVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(wVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((x) obj).a);
                return;
            case 6:
                p pVar = (p) obj;
                objectOutput.writeObject(pVar.a);
                objectOutput.writeInt(pVar.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(pVar.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(pVar.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                b0 b0Var = (b0) obj;
                b0Var.getClass();
                objectOutput.writeInt(b0Var.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(b0Var.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(b0Var.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                h0 h0Var = (h0) obj;
                h0Var.getClass();
                objectOutput.writeInt(h0Var.g(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(h0Var.g(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(h0Var.g(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                g gVar = (g) obj;
                objectOutput.writeUTF(gVar.a.getId());
                objectOutput.writeInt(gVar.b);
                objectOutput.writeInt(gVar.c);
                objectOutput.writeInt(gVar.d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public d0() {
    }
}
