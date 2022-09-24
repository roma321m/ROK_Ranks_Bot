package data.command.images

interface ImageCommand {
    fun takeScreenshot(x: Int, y: Int, width: Int, height: Int, path: String)
}
