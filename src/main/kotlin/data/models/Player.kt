package data.models

data class Player(
    var name: String,
    var id: Long = 0,
    var power: Long = 0,
    var t1: Long = 0,
    var t2: Long = 0,
    var t3: Long = 0,
    var t4: Long = 0,
    var t5: Long = 0,
    var killPoints: Long = (t1 * 0.2).toLong() + t2 * 2 + t3 * 4 + t4 * 10 + t5 * 20,
    var deaths: Long = 0,
    var rss_a: Long = 0,
    var rss_g: Long = 0,
    var helps: Long = 0,
    var barbs: Long = 0
)