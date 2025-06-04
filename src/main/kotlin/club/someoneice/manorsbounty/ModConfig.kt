package club.someoneice.manorsbounty

import com.google.gson.Gson
import net.minecraftforge.fml.loading.FMLPaths
import java.io.File

object ModConfig {
    private val file = File(FMLPaths.CONFIGDIR.get().toFile(), ManorsBounty.NAME + ".json5")
    private val gson = Gson()

    var useFoodEffects = true

    var foodCooldownTimeA = 720
    var foodCooldownTimeB = 300
    var foodCooldownTimeC = 480
    var foodCooldownTimeX = 1080

    @JvmName("# read")
    internal fun read() {
        if (!file.exists() || !file.isFile) {
            save()
            return
        }

        fun check(str: String) = !str.startsWith("//") && str.contains(":")

        val map = HashMap<String, String>()
        file.readLines().map(String::trim).filter(::check).forEach {
            val strArr = it.split(":")
            map[strArr[0].trim().removeStringMark()] = strArr[1].trim().removeNextLineMark().removeStringMark()
        }

        useFoodEffects = map["useFoodEffects"]?.toBoolean() ?: useFoodEffects

        foodCooldownTimeA = map["foodCooldownTimeA"]?.toInt() ?: foodCooldownTimeA
        foodCooldownTimeB = map["foodCooldownTimeB"]?.toInt() ?: foodCooldownTimeB
        foodCooldownTimeC = map["foodCooldownTimeC"]?.toInt() ?: foodCooldownTimeC
        foodCooldownTimeX = map["foodCooldownTimeX"]?.toInt() ?: foodCooldownTimeX

        save()
    }

    private fun save() {
        val builder = ArrayList<JsonNode>()

        builder.add(JsonNode.Comment("启用食物效果"))
        builder.add(JsonNode.Node("useFoodEffects", useFoodEffects))
        builder.add(JsonNode.EnterLine)

        builder.add(JsonNode.Comment("食物冷却效果"))
        builder.add(JsonNode.Node("foodCooldownTimeA", foodCooldownTimeA))
        builder.add(JsonNode.Node("foodCooldownTimeB", foodCooldownTimeB))
        builder.add(JsonNode.Node("foodCooldownTimeC", foodCooldownTimeC))
        builder.add(JsonNode.Node("foodCooldownTimeX", foodCooldownTimeX))

        val sb = StringBuilder()
        sb.append("{\n")
        builder.forEach {
            when(it) {
                is JsonNode.EnterLine -> sb.append("\n")
                is JsonNode.Comment -> sb.append("    ").append(it.toString()).append("\n")
                is JsonNode.Node -> sb.append("    ").append(it.toString()).append(",\n")
            }
        }

        sb.deleteAt(sb.lastIndexOf(",")).append("}")
        file.writeText(sb.toString())
    }

    private sealed class JsonNode {
        data object EnterLine: JsonNode()

        class Comment(private val comment: String): JsonNode() {
            override fun toString(): String {
                return "// $comment"
            }
        }

        class Node(private val key: String, private val value: Any?): JsonNode() {
            override fun toString(): String {
                return "\"${key}\": ${if (value is String) "\"$value\"" else value ?: "null"}"
            }
        }
    }
}
