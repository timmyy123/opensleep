package org.apache.commons.math3.exception.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;
    private Throwable throwable;
    private List<Localizable> msgPatterns = new ArrayList();
    private List<Object[]> msgArguments = new ArrayList();
    private Map<String, Object> context = new HashMap();

    public ExceptionContext(Throwable th) {
        this.throwable = th;
    }

    private String buildMessage(Locale locale, String str) {
        StringBuilder sb = new StringBuilder();
        int size = this.msgPatterns.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(new MessageFormat(this.msgPatterns.get(i2).getLocalizedString(locale), locale).format(this.msgArguments.get(i2)));
            i++;
            if (i < size) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    private void deSerializeContext(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int i = objectInputStream.readInt();
        this.context = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            this.context.put((String) objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void deSerializeMessages(ObjectInputStream objectInputStream) throws IOException {
        int i = objectInputStream.readInt();
        this.msgPatterns = new ArrayList(i);
        this.msgArguments = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.msgPatterns.add((Localizable) objectInputStream.readObject());
            int i3 = objectInputStream.readInt();
            Object[] objArr = new Object[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                objArr[i4] = objectInputStream.readObject();
            }
            this.msgArguments.add(objArr);
        }
    }

    private String nonSerializableReplacement(Object obj) {
        return "[Object could not be serialized: " + obj.getClass().getName() + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.throwable = (Throwable) objectInputStream.readObject();
        deSerializeMessages(objectInputStream);
        deSerializeContext(objectInputStream);
    }

    private void serializeContext(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.context.keySet().size());
        for (String str : this.context.keySet()) {
            objectOutputStream.writeObject(str);
            Object obj = this.context.get(str);
            if (obj instanceof Serializable) {
                objectOutputStream.writeObject(obj);
            } else {
                objectOutputStream.writeObject(nonSerializableReplacement(obj));
            }
        }
    }

    private void serializeMessages(ObjectOutputStream objectOutputStream) throws IOException {
        int size = this.msgPatterns.size();
        objectOutputStream.writeInt(size);
        for (int i = 0; i < size; i++) {
            objectOutputStream.writeObject(this.msgPatterns.get(i));
            Object[] objArr = this.msgArguments.get(i);
            objectOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                if (obj instanceof Serializable) {
                    objectOutputStream.writeObject(obj);
                } else {
                    objectOutputStream.writeObject(nonSerializableReplacement(obj));
                }
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.throwable);
        serializeMessages(objectOutputStream);
        serializeContext(objectOutputStream);
    }

    public void addMessage(Localizable localizable, Object... objArr) {
        this.msgPatterns.add(localizable);
        this.msgArguments.add(ArgUtils.flatten(objArr));
    }

    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }

    public String getMessage() {
        return getMessage(Locale.US);
    }

    public String getMessage(Locale locale) {
        return buildMessage(locale, ": ");
    }
}
