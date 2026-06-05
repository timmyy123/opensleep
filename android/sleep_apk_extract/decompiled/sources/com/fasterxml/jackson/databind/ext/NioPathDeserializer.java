package com.fasterxml.jackson.databind.ext;

import com.facebook.FacebookSdk$$ExternalSyntheticLambda3;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes3.dex */
public class NioPathDeserializer extends StdScalarDeserializer<Path> {
    private static final boolean areWindowsFilePathsSupported;
    private static final long serialVersionUID = 1;

    static {
        File[] fileArrListRoots = File.listRoots();
        int length = fileArrListRoots.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String path = fileArrListRoots[i].getPath();
            if (path.length() >= 2 && Character.isLetter(path.charAt(0)) && path.charAt(1) == ':') {
                z = true;
                break;
            }
            i++;
        }
        areWindowsFilePathsSupported = z;
    }

    public NioPathDeserializer() {
        super((Class<?>) FacebookSdk$$ExternalSyntheticLambda3.m());
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Path deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!jsonParser.hasToken(JsonToken.VALUE_STRING)) {
            return FacebookSdk$$ExternalSyntheticLambda3.m(deserializationContext.handleUnexpectedToken(FacebookSdk$$ExternalSyntheticLambda3.m(), jsonParser));
        }
        String text = jsonParser.getText();
        if (text.indexOf(58) < 0) {
            return Paths.get(text, new String[0]);
        }
        if (areWindowsFilePathsSupported && text.length() >= 2 && Character.isLetter(text.charAt(0)) && text.charAt(1) == ':') {
            return Paths.get(text, new String[0]);
        }
        try {
            URI uri = new URI(text);
            try {
                return Paths.get(uri);
            } catch (FileSystemNotFoundException e) {
                try {
                    String scheme = uri.getScheme();
                    for (FileSystemProvider fileSystemProvider : ServiceLoader.load(FileSystemProvider.class)) {
                        if (fileSystemProvider.getScheme().equalsIgnoreCase(scheme)) {
                            return fileSystemProvider.getPath(uri);
                        }
                    }
                    return FacebookSdk$$ExternalSyntheticLambda3.m(deserializationContext.handleInstantiationProblem(this.handledType(), text, e));
                } catch (ServiceConfigurationError e2) {
                    e2.addSuppressed(e);
                    return FacebookSdk$$ExternalSyntheticLambda3.m(deserializationContext.handleInstantiationProblem(this.handledType(), text, e2));
                }
            } catch (Exception e3) {
                return FacebookSdk$$ExternalSyntheticLambda3.m(deserializationContext.handleInstantiationProblem(this.handledType(), text, e3));
            }
        } catch (URISyntaxException e4) {
            return FacebookSdk$$ExternalSyntheticLambda3.m(deserializationContext.handleInstantiationProblem(handledType(), text, e4));
        }
    }
}
