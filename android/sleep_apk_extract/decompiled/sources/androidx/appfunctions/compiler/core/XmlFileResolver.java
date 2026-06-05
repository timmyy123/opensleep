package androidx.appfunctions.compiler.core;

import com.google.devtools.ksp.processing.KSPLogger;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/compiler/core/XmlFileResolver;", "", "getWriteStream", "Ljava/io/OutputStream;", "filePath", "Ljava/nio/file/Path;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface XmlFileResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003*\u0001\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/appfunctions/compiler/core/XmlFileResolver$Companion;", "", "<init>", "()V", "RESOLVER", "Landroidx/appfunctions/compiler/core/XmlFileResolver;", "getRESOLVER", "()Landroidx/appfunctions/compiler/core/XmlFileResolver;", "RESOLVER$delegate", "Lkotlin/Lazy;", "DEFAULT_RESOLVER", "androidx/appfunctions/compiler/core/XmlFileResolver$Companion$DEFAULT_RESOLVER$1", "Landroidx/appfunctions/compiler/core/XmlFileResolver$Companion$DEFAULT_RESOLVER$1;", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: RESOLVER$delegate, reason: from kotlin metadata */
        private static final Lazy<XmlFileResolver> RESOLVER = LazyKt.lazy(new XmlFileResolver$Companion$$ExternalSyntheticLambda0());
        private static final XmlFileResolver$Companion$DEFAULT_RESOLVER$1 DEFAULT_RESOLVER = new XmlFileResolver() { // from class: androidx.appfunctions.compiler.core.XmlFileResolver$Companion$DEFAULT_RESOLVER$1
            @Override // androidx.appfunctions.compiler.core.XmlFileResolver
            public OutputStream getWriteStream(Path filePath, KSPLogger logger) throws IOException {
                filePath.getClass();
                logger.getClass();
                Path parent = filePath.getParent();
                if (parent != null && !Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)).getClass();
                }
                KSPLogger.info$default(logger, "Writing XML file to " + filePath.toAbsolutePath(), null, 2, null);
                OutputStream outputStreamNewOutputStream = Files.newOutputStream(filePath, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
                outputStreamNewOutputStream.getClass();
                return outputStreamNewOutputStream;
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final XmlFileResolver RESOLVER_delegate$lambda$0() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(XmlFileResolver.class);
            serviceLoaderLoad.getClass();
            XmlFileResolver xmlFileResolver = (XmlFileResolver) CollectionsKt.firstOrNull(serviceLoaderLoad);
            if (xmlFileResolver != null) {
                return xmlFileResolver;
            }
            ServiceLoader serviceLoaderLoad2 = ServiceLoader.load(XmlFileResolver.class, XmlFileResolver.class.getClassLoader());
            serviceLoaderLoad2.getClass();
            XmlFileResolver xmlFileResolver2 = (XmlFileResolver) CollectionsKt.firstOrNull(serviceLoaderLoad2);
            return xmlFileResolver2 == null ? DEFAULT_RESOLVER : xmlFileResolver2;
        }

        public final XmlFileResolver getRESOLVER() {
            return RESOLVER.getValue();
        }
    }

    OutputStream getWriteStream(Path filePath, KSPLogger logger);
}
