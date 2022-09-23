package data.models.theme

data class Player(
    val name: String,
    val id: Long = 0,
    val power: Long = 0,
    val t1: Long = 0,
    val t2: Long = 0,
    val t3: Long = 0,
    val t4: Long = 0,
    val t5: Long = 0,
    val killPoints: Long = (t1 * 0.2).toLong() + t2 * 2 + t3 * 4 + t4 * 10 + t5 * 20,
    val deaths: Long = 0,
    val rss_a: Long = 0,
    val rss_g: Long = 0,
    val helps: Long = 0,
    val barbs: Long = 0
)