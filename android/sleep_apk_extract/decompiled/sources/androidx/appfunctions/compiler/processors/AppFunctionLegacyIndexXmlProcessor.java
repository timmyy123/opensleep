package androidx.appfunctions.compiler.processors;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.AppFunctionCompilerOptions;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.AnnotatedAppFunctions;
import androidx.appfunctions.compiler.core.AppFunctionSymbolResolver;
import androidx.appfunctions.compiler.core.ProcessingException;
import androidx.appfunctions.compiler.core.XmlFileResolver;
import androidx.appfunctions.compiler.core.XmlUtilsKt;
import androidx.appfunctions.compiler.core.metadata.AppFunctionMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.CompileTimeAppFunctionMetadata;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.processing.Resolver;
import com.google.devtools.ksp.processing.SymbolProcessor;
import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSFile;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import oauth.signpost.OAuth;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0002J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionLegacyIndexXmlProcessor;", "Lcom/google/devtools/ksp/processing/SymbolProcessor;", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "process", "", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "resolver", "Lcom/google/devtools/ksp/processing/Resolver;", "generateLegacyIndexXml", "", "appFunctionsByClass", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "writeXmlFile", "appFunctionMetadataList", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionMetadataDocument;", "createAppFunctionElement", "Lorg/w3c/dom/Element;", "Lorg/w3c/dom/Document;", "appFunctionMetadata", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionLegacyIndexXmlProcessor implements SymbolProcessor {
    private static final Companion Companion = new Companion(null);
    private static final String XML_EXTENSION = "xml";
    private static final String XML_FILE_NAME = "app_functions";
    private static final String XML_PACKAGE_NAME = "assets";
    private final CodeGenerator codeGenerator;
    private final KSPLogger logger;
    private final AppFunctionCompilerOptions options;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionLegacyIndexXmlProcessor$Companion;", "", "<init>", "()V", "XML_PACKAGE_NAME", "", "XML_FILE_NAME", "XML_EXTENSION", "XmlElement", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/appfunctions/compiler/processors/AppFunctionLegacyIndexXmlProcessor$Companion$XmlElement;", "", "<init>", "()V", "APP_FUNCTIONS_ELEMENTS_TAG", "", "APP_FUNCTION_ITEM_TAG", "APP_FUNCTION_ID_TAG", "APP_FUNCTION_SCHEMA_CATEGORY_TAG", "APP_FUNCTION_SCHEMA_NAME_TAG", "APP_FUNCTION_SCHEMA_VERSION_TAG", "APP_FUNCTION_ENABLE_BY_DEFAULT_TAG", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class XmlElement {
            public static final String APP_FUNCTIONS_ELEMENTS_TAG = "appfunctions";
            public static final String APP_FUNCTION_ENABLE_BY_DEFAULT_TAG = "enabled_by_default";
            public static final String APP_FUNCTION_ID_TAG = "function_id";
            public static final String APP_FUNCTION_ITEM_TAG = "appfunction";
            public static final String APP_FUNCTION_SCHEMA_CATEGORY_TAG = "schema_category";
            public static final String APP_FUNCTION_SCHEMA_NAME_TAG = "schema_name";
            public static final String APP_FUNCTION_SCHEMA_VERSION_TAG = "schema_version";
            public static final XmlElement INSTANCE = new XmlElement();

            private XmlElement() {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppFunctionLegacyIndexXmlProcessor(CodeGenerator codeGenerator, AppFunctionCompilerOptions appFunctionCompilerOptions, KSPLogger kSPLogger) {
        codeGenerator.getClass();
        appFunctionCompilerOptions.getClass();
        kSPLogger.getClass();
        this.options = appFunctionCompilerOptions;
    }

    private final Element createAppFunctionElement(Document document, AppFunctionMetadataDocument appFunctionMetadataDocument) {
        Element elementCreateElement = document.createElement("appfunction");
        elementCreateElement.appendChild(XmlUtilsKt.createElementWithTextNode(document, Companion.XmlElement.APP_FUNCTION_ID_TAG, appFunctionMetadataDocument.getId()));
        String schemaName = appFunctionMetadataDocument.getSchemaName();
        String schemaCategory = appFunctionMetadataDocument.getSchemaCategory();
        Long schemaVersion = appFunctionMetadataDocument.getSchemaVersion();
        if (schemaName != null && schemaCategory != null && schemaVersion != null) {
            elementCreateElement.appendChild(XmlUtilsKt.createElementWithTextNode(document, Companion.XmlElement.APP_FUNCTION_SCHEMA_CATEGORY_TAG, schemaCategory));
            elementCreateElement.appendChild(XmlUtilsKt.createElementWithTextNode(document, Companion.XmlElement.APP_FUNCTION_SCHEMA_NAME_TAG, schemaName));
            elementCreateElement.appendChild(XmlUtilsKt.createElementWithTextNode(document, Companion.XmlElement.APP_FUNCTION_SCHEMA_VERSION_TAG, String.valueOf(schemaVersion.longValue())));
        }
        elementCreateElement.appendChild(XmlUtilsKt.createElementWithTextNode(document, Companion.XmlElement.APP_FUNCTION_ENABLE_BY_DEFAULT_TAG, String.valueOf(appFunctionMetadataDocument.isEnabledByDefault())));
        return elementCreateElement;
    }

    private final void generateLegacyIndexXml(List<AnnotatedAppFunctions> appFunctionsByClass, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies) throws TransformerConfigurationException, ProcessingException {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = appFunctionsByClass.iterator();
        while (it.hasNext()) {
            List listCreateAppFunctionMetadataList$default = AnnotatedAppFunctions.createAppFunctionMetadataList$default((AnnotatedAppFunctions) it.next(), resolvedAnnotatedSerializableProxies, null, 2, null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listCreateAppFunctionMetadataList$default, 10));
            Iterator it2 = listCreateAppFunctionMetadataList$default.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((CompileTimeAppFunctionMetadata) it2.next()).toAppFunctionMetadataDocument());
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        writeXmlFile(arrayList, appFunctionsByClass);
    }

    private final void writeXmlFile(List<AppFunctionMetadataDocument> appFunctionMetadataList, List<AnnotatedAppFunctions> appFunctionsByClass) throws TransformerConfigurationException, ProcessingException {
        Document documentNewDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        documentNewDocument.setXmlStandalone(true);
        Element elementCreateElement = documentNewDocument.createElement("appfunctions");
        documentNewDocument.appendChild(elementCreateElement);
        Iterator<AppFunctionMetadataDocument> it = appFunctionMetadataList.iterator();
        while (it.hasNext()) {
            elementCreateElement.appendChild(createAppFunctionElement(documentNewDocument, it.next()));
        }
        Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
        transformerNewTransformer.setOutputProperty("indent", "yes");
        transformerNewTransformer.setOutputProperty("encoding", OAuth.ENCODING);
        transformerNewTransformer.setOutputProperty("version", OAuth.VERSION_1_0);
        transformerNewTransformer.setOutputProperty("standalone", "yes");
        if (this.options.getAppFunctionsXmlLocation() != null) {
            try {
                XmlFileResolver resolver = XmlFileResolver.INSTANCE.getRESOLVER();
                Path path = Paths.get(this.options.getAppFunctionsXmlLocation(), new String[0]);
                path.getClass();
                Path pathResolve = path.resolve("app_functions.xml");
                pathResolve.getClass();
                OutputStream writeStream = resolver.getWriteStream(pathResolve, null);
                try {
                    transformerNewTransformer.transform(new DOMSource(documentNewDocument), new StreamResult(writeStream));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writeStream, null);
                } finally {
                }
            } catch (IOException e) {
                throw new ProcessingException(FileInsert$$ExternalSyntheticOutline0.m("Failed to create AppFunctions XML file at: ", this.options.getAppFunctionsXmlLocation()), null, e);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = appFunctionsByClass.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((AnnotatedAppFunctions) it2.next()).getSourceFiles());
        }
        KSFile[] kSFileArr = (KSFile[]) arrayList.toArray(new KSFile[0]);
        new Dependencies(true, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length));
        throw null;
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public /* bridge */ /* synthetic */ void finish() {
        super.finish();
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public /* bridge */ /* synthetic */ void onError() {
        super.onError();
    }

    @Override // com.google.devtools.ksp.processing.SymbolProcessor
    public List<KSAnnotated> process(Resolver resolver) throws TransformerConfigurationException, ProcessingException {
        resolver.getClass();
        AppFunctionSymbolResolver appFunctionSymbolResolver = new AppFunctionSymbolResolver(resolver);
        generateLegacyIndexXml(appFunctionSymbolResolver.getAnnotatedAppFunctionsFromAllModules(), new AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies(appFunctionSymbolResolver.resolveAllAnnotatedSerializableProxiesFromModule()));
        return CollectionsKt.emptyList();
    }
}
