import java.text.NumberFormat
import java.util.*
import kotlin.math.abs

object Generator {
    private lateinit var random: Random
    fun generateEmpNum(): Int {
        if (!this::random.isInitialized) {
            random = Random()
        }
        return abs(random.nextInt())
    }

}