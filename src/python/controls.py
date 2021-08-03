import pyautogui
import time

def left_click():
    pyautogui.click(button = 'left')

def mouse_pos(x, y):
    pyautogui.dragTo(x, y)

def scroll(x1, y1, x2, y2):
    pyautogui.moveTo(x1, y1)
    pyautogui.mouseDown()
    time.sleep(.5)
    pyautogui.moveTo(x2, y2, duration = .6, tween = pyautogui.easeInQuad)
    time.sleep(.5)
    pyautogui.mouseUp()
    time.sleep(.2)