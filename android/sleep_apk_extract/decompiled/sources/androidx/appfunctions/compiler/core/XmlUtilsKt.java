package androidx.appfunctions.compiler.core;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.core.metadata.AppFunctionComponentsMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDataTypeMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionDeprecationMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionNamedDataTypeMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionParameterMetadataDocument;
import androidx.appfunctions.compiler.core.metadata.AppFunctionResponseMetadataDocument;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"createElementWithTextNode", "Lorg/w3c/dom/Element;", "Lorg/w3c/dom/Document;", "elementName", "", "text", "toXmlElement", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionMetadataDocument;", "doc", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionComponentsMetadataDocument;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDataTypeMetadataDocument;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionNamedDataTypeMetadataDocument;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionResponseMetadataDocument;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionParameterMetadataDocument;", "Landroidx/appfunctions/compiler/core/metadata/AppFunctionDeprecationMetadataDocument;", "appfunctions-compiler"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XmlUtilsKt {
    public static final Element createElementWithTextNode(Document document, String str, String str2) {
        document.getClass();
        str.getClass();
        str2.getClass();
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(document.createTextNode(str2));
        return elementCreateElement;
    }

    private static final Element toXmlElement(AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, Document document, String str) {
        Element elementCreateElement = document.createElement(str);
        Iterator<AppFunctionDataTypeMetadataDocument> it = appFunctionDataTypeMetadataDocument.getAllOf().iterator();
        while (it.hasNext()) {
            elementCreateElement.appendChild(toXmlElement(it.next(), document, "allOf"));
        }
        Iterator<AppFunctionDataTypeMetadataDocument> it2 = appFunctionDataTypeMetadataDocument.getOneOf().iterator();
        while (it2.hasNext()) {
            elementCreateElement.appendChild(toXmlElement(it2.next(), document, "oneOf"));
        }
        String dataTypeReference = appFunctionDataTypeMetadataDocument.getDataTypeReference();
        if (dataTypeReference != null) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "dataTypeReference", dataTypeReference));
        }
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionDataTypeMetadataDocument.getId()));
        elementCreateElement.appendChild(createElementWithTextNode(document, "isNullable", String.valueOf(appFunctionDataTypeMetadataDocument.isNullable())));
        AppFunctionDataTypeMetadataDocument itemType = appFunctionDataTypeMetadataDocument.getItemType();
        if (itemType != null) {
            elementCreateElement.appendChild(toXmlElement(itemType, document, "itemType"));
        }
        String objectQualifiedName = appFunctionDataTypeMetadataDocument.getObjectQualifiedName();
        if (objectQualifiedName != null) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "objectQualifiedName", objectQualifiedName));
        }
        if (appFunctionDataTypeMetadataDocument.getDescription().length() > 0) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "description", appFunctionDataTypeMetadataDocument.getDescription()));
        }
        Iterator<AppFunctionNamedDataTypeMetadataDocument> it3 = appFunctionDataTypeMetadataDocument.getProperties().iterator();
        while (it3.hasNext()) {
            elementCreateElement.appendChild(toXmlElement(it3.next(), document, "properties"));
        }
        Iterator<String> it4 = appFunctionDataTypeMetadataDocument.getRequired().iterator();
        while (it4.hasNext()) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "required", it4.next()));
        }
        Iterator<String> it5 = appFunctionDataTypeMetadataDocument.getEnumValues().iterator();
        while (it5.hasNext()) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "enumValues", it5.next()));
        }
        elementCreateElement.appendChild(createElementWithTextNode(document, "type", String.valueOf(appFunctionDataTypeMetadataDocument.getType())));
        return elementCreateElement;
    }

    public static final Element toXmlElement(AppFunctionComponentsMetadataDocument appFunctionComponentsMetadataDocument, Document document, String str) {
        appFunctionComponentsMetadataDocument.getClass();
        document.getClass();
        str.getClass();
        Element elementCreateElement = document.createElement(str);
        Iterator<AppFunctionNamedDataTypeMetadataDocument> it = appFunctionComponentsMetadataDocument.getDataTypes().iterator();
        while (it.hasNext()) {
            elementCreateElement.appendChild(toXmlElement(it.next(), document, "dataTypes"));
        }
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionComponentsMetadataDocument.getId()));
        return elementCreateElement;
    }

    public static final Element toXmlElement(AppFunctionMetadataDocument appFunctionMetadataDocument, Document document, String str) {
        appFunctionMetadataDocument.getClass();
        document.getClass();
        str.getClass();
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionMetadataDocument.getId()));
        elementCreateElement.appendChild(createElementWithTextNode(document, "enabledByDefault", String.valueOf(appFunctionMetadataDocument.isEnabledByDefault())));
        if (appFunctionMetadataDocument.getDescription().length() > 0) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "description", appFunctionMetadataDocument.getDescription()));
        }
        List<AppFunctionParameterMetadataDocument> parameters = appFunctionMetadataDocument.getParameters();
        if (parameters != null) {
            Iterator<AppFunctionParameterMetadataDocument> it = parameters.iterator();
            while (it.hasNext()) {
                elementCreateElement.appendChild(toXmlElement(it.next(), document, IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME));
            }
        }
        AppFunctionResponseMetadataDocument response = appFunctionMetadataDocument.getResponse();
        if (response != null) {
            elementCreateElement.appendChild(toXmlElement(response, document, "response"));
        }
        String schemaCategory = appFunctionMetadataDocument.getSchemaCategory();
        if (schemaCategory != null) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "schemaCategory", schemaCategory));
        }
        String schemaName = appFunctionMetadataDocument.getSchemaName();
        if (schemaName != null) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "schemaName", schemaName));
        }
        Long schemaVersion = appFunctionMetadataDocument.getSchemaVersion();
        if (schemaVersion != null) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "schemaVersion", String.valueOf(schemaVersion.longValue())));
        }
        if (appFunctionMetadataDocument.getDeprecation() != null) {
            elementCreateElement.appendChild(toXmlElement(appFunctionMetadataDocument.getDeprecation(), document, "deprecation"));
        }
        return elementCreateElement;
    }

    private static final Element toXmlElement(AppFunctionNamedDataTypeMetadataDocument appFunctionNamedDataTypeMetadataDocument, Document document, String str) {
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(toXmlElement(appFunctionNamedDataTypeMetadataDocument.getDataTypeMetadata(), document, "dataTypeMetadata"));
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionNamedDataTypeMetadataDocument.getId()));
        elementCreateElement.appendChild(createElementWithTextNode(document, "name", appFunctionNamedDataTypeMetadataDocument.getName()));
        return elementCreateElement;
    }

    private static final Element toXmlElement(AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, Document document, String str) {
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionResponseMetadataDocument.getId()));
        elementCreateElement.appendChild(toXmlElement(appFunctionResponseMetadataDocument.getValueType(), document, "valueType"));
        if (appFunctionResponseMetadataDocument.getDescription().length() > 0) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "description", appFunctionResponseMetadataDocument.getDescription()));
        }
        return elementCreateElement;
    }

    private static final Element toXmlElement(AppFunctionParameterMetadataDocument appFunctionParameterMetadataDocument, Document document, String str) {
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(toXmlElement(appFunctionParameterMetadataDocument.getDataTypeMetadata(), document, "dataTypeMetadata"));
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionParameterMetadataDocument.getId()));
        elementCreateElement.appendChild(createElementWithTextNode(document, "isRequired", String.valueOf(appFunctionParameterMetadataDocument.isRequired())));
        elementCreateElement.appendChild(createElementWithTextNode(document, "name", appFunctionParameterMetadataDocument.getName()));
        if (appFunctionParameterMetadataDocument.getDescription().length() > 0) {
            elementCreateElement.appendChild(createElementWithTextNode(document, "description", appFunctionParameterMetadataDocument.getDescription()));
        }
        return elementCreateElement;
    }

    private static final Element toXmlElement(AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument, Document document, String str) {
        Element elementCreateElement = document.createElement(str);
        elementCreateElement.appendChild(createElementWithTextNode(document, "id", appFunctionDeprecationMetadataDocument.getId()));
        elementCreateElement.appendChild(createElementWithTextNode(document, "message", appFunctionDeprecationMetadataDocument.getMessage()));
        return elementCreateElement;
    }
}
