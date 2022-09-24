package ui.util

enum class Mode {
    DARK,
    LIGHT,
    SYSTEM
}

fun String?.toMode(): Mode {
    return if (this.isNullOrEmpty()) Mode.SYSTEM else Mode.valueOf(this)
}