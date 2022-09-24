package data.command.images

import data.command.Command

class TakeScreenShotCommand(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int,
    private val path: String,
    private val imageCommand: ImageCommand
) : Command {

    override fun execute() {
        imageCommand.takeScreenshot(x, y, width, height, path)
    }

}