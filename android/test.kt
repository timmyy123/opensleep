import com.google.ai.edge.litertlm.EngineConfig
import java.lang.reflect.Modifier

fun main() {
    val clazz = EngineConfig::class.java
    for (method in clazz.declaredMethods) {
        println("${Modifier.toString(method.modifiers)} ${method.returnType.name} ${method.name}(...)")
    }
    for (field in clazz.declaredFields) {
        println("${Modifier.toString(field.modifiers)} ${field.type.name} ${field.name}")
    }
}
