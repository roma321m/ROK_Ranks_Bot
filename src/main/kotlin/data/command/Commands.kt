package data.command

import data.command.images.ImageCommand
import util.Constants
import java.awt.Rectangle
import java.awt.Robot
import java.io.File
import javax.imageio.ImageIO

class Commands : ImageCommand {

    override fun takeScreenshot(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        path: String
    ) {
        val robot = Robot()
        val image = robot.createScreenCapture(Rectangle(x, y, width, height))
        val output = File(path)
        ImageIO.write(image, Constants.IMAGE_TYPE, output)
    }

}