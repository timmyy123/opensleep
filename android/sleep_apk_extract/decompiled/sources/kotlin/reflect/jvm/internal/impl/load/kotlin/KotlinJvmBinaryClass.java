package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes5.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(Name name, Object obj);

        AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId);

        AnnotationArrayArgumentVisitor visitArray(Name name);

        void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(Name name, ClassId classId, Name name2);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(Object obj);

        AnnotationArgumentVisitor visitAnnotation(ClassId classId);

        void visitClassLiteral(ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(ClassId classId, Name name);
    }

    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement);

        void visitEnd();
    }

    public interface MemberVisitor {
        AnnotationVisitor visitField(Name name, String str, Object obj);

        MethodAnnotationVisitor visitMethod(Name name, String str);
    }

    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor annotationVisitor, byte[] bArr);

    void visitMembers(MemberVisitor memberVisitor, byte[] bArr);
}
