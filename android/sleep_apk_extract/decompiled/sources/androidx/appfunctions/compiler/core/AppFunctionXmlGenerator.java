package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.AnnotatedAppFunctionSerializableProxy;
import androidx.appfunctions.compiler.core.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.compiler.core.metadata.CompileTimeAppFunctionMetadata;
import com.google.devtools.ksp.processing.CodeGenerator;
import com.google.devtools.ksp.processing.Dependencies;
import com.google.devtools.ksp.processing.KSPLogger;
import com.google.devtools.ksp.symbol.KSFile;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.io.CloseableKt;
import oauth.signpost.OAuth;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JL\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/compiler/core/AppFunctionXmlGenerator;", "", "codeGenerator", "Lcom/google/devtools/ksp/processing/CodeGenerator;", "logger", "Lcom/google/devtools/ksp/processing/KSPLogger;", "<init>", "(Lcom/google/devtools/ksp/processing/CodeGenerator;Lcom/google/devtools/ksp/processing/KSPLogger;)V", "generateXml", "", "appFunctionsByClass", "", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctions;", "resolvedAnnotatedSerializableProxies", "Landroidx/appfunctions/compiler/core/AnnotatedAppFunctionSerializableProxy$ResolvedAnnotatedSerializableProxies;", "appFunctionSerializablesDescriptionMap", "", "", "packageName", "fileName", "outputLocation", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionXmlGenerator {
    public static final String APP_FUNCTIONS_ELEMENTS_TAG = "appfunctions";
    public static final String APP_FUNCTION_ID_TAG = "functionId";
    public static final String APP_FUNCTION_ITEM_TAG = "appfunction";
    public static final String COMPONENT_ITEM_TAG = "AppFunctionComponentMetadataDocument";
    public static final String XML_EXTENSION = "xml";
    private final CodeGenerator codeGenerator;
    private final KSPLogger logger;

    public AppFunctionXmlGenerator(CodeGenerator codeGenerator, KSPLogger kSPLogger) {
        codeGenerator.getClass();
        kSPLogger.getClass();
    }

    public static /* synthetic */ void generateXml$default(AppFunctionXmlGenerator appFunctionXmlGenerator, List list, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map map, String str, String str2, String str3, int i, Object obj) throws TransformerConfigurationException, ProcessingException {
        if ((i & 32) != 0) {
            str3 = null;
        }
        appFunctionXmlGenerator.generateXml(list, resolvedAnnotatedSerializableProxies, map, str, str2, str3);
    }

    public final void generateXml(List<AnnotatedAppFunctions> appFunctionsByClass, AnnotatedAppFunctionSerializableProxy.ResolvedAnnotatedSerializableProxies resolvedAnnotatedSerializableProxies, Map<String, String> appFunctionSerializablesDescriptionMap, String packageName, String fileName, String outputLocation) throws TransformerConfigurationException, ProcessingException {
        appFunctionsByClass.getClass();
        resolvedAnnotatedSerializableProxies.getClass();
        appFunctionSerializablesDescriptionMap.getClass();
        packageName.getClass();
        fileName.getClass();
        List<AnnotatedAppFunctions> list = appFunctionsByClass;
        ArrayList<CompileTimeAppFunctionMetadata> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((AnnotatedAppFunctions) it.next()).createAppFunctionMetadataList(resolvedAnnotatedSerializableProxies, appFunctionSerializablesDescriptionMap));
        }
        Document documentNewDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        documentNewDocument.setXmlStandalone(true);
        Element elementCreateElement = documentNewDocument.createElement("appfunctions");
        documentNewDocument.appendChild(elementCreateElement);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata : arrayList) {
            for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : compileTimeAppFunctionMetadata.getComponents().getDataTypes().entrySet()) {
                linkedHashMap.putIfAbsent(entry.getKey(), entry.getValue());
            }
            CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadataCopy$default = CompileTimeAppFunctionMetadata.copy$default(compileTimeAppFunctionMetadata, null, false, null, null, null, new AppFunctionComponentsMetadata(null, 1, null), null, null, 223, null);
            Element xmlElement = XmlUtilsKt.toXmlElement(compileTimeAppFunctionMetadataCopy$default.toAppFunctionMetadataDocument(), documentNewDocument, "appfunction");
            xmlElement.appendChild(XmlUtilsKt.createElementWithTextNode(documentNewDocument, APP_FUNCTION_ID_TAG, compileTimeAppFunctionMetadataCopy$default.getId()));
            elementCreateElement.appendChild(xmlElement);
        }
        if (!linkedHashMap.isEmpty()) {
            elementCreateElement.appendChild(XmlUtilsKt.toXmlElement(new AppFunctionComponentsMetadata(linkedHashMap).toAppFunctionComponentsMetadataDocument(), documentNewDocument, COMPONENT_ITEM_TAG));
        }
        Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
        transformerNewTransformer.setOutputProperty("indent", "yes");
        transformerNewTransformer.setOutputProperty("encoding", OAuth.ENCODING);
        transformerNewTransformer.setOutputProperty("version", OAuth.VERSION_1_0);
        transformerNewTransformer.setOutputProperty("standalone", "yes");
        if (outputLocation != null) {
            try {
                XmlFileResolver resolver = XmlFileResolver.INSTANCE.getRESOLVER();
                Path path = Paths.get(outputLocation, new String[0]);
                path.getClass();
                Path pathResolve = path.resolve(fileName + ".xml");
                pathResolve.getClass();
                OutputStream writeStream = resolver.getWriteStream(pathResolve, null);
                try {
                    transformerNewTransformer.transform(new DOMSource(documentNewDocument), new StreamResult(writeStream));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(writeStream, null);
                } finally {
                }
            } catch (IOException e) {
                throw new ProcessingException("Failed to create AppFunctions XML file at: ".concat(outputLocation), null, e);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, ((AnnotatedAppFunctions) it2.next()).getSourceFiles());
        }
        KSFile[] kSFileArr = (KSFile[]) arrayList2.toArray(new KSFile[0]);
        new Dependencies(true, (KSFile[]) Arrays.copyOf(kSFileArr, kSFileArr.length));
        throw null;
    }
}
