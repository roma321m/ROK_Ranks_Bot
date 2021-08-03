import cv2
from PIL import ImageGrab
from PIL import Image
import win32gui, win32ui
import numpy as np
from ctypes import windll

def check_image_match(screenshot, template, threshold):
    result = cv2.matchTemplate(screenshot, template, cv2.TM_CCOEFF_NORMED)
    min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)
    w = template.shape[1]
    h = template.shape[0]
    # print(max_loc)
    # threshold = .6
    yloc, xloc = np.where(result >= threshold)
    # x, y, w, h
    rectangles = []
    for (x,y) in zip(xloc, yloc):
        rectangles.append([int(x), int(y), int(w), int(h)])
        rectangles.append([int(x), int(y), int(w), int(h)])
    rectangles, weights = cv2.groupRectangles(rectangles, 1, 0.1)
    #print(len(rectangles))
    if len(rectangles) == 1:
        return max_loc
    else:
        return (0,0)

def screen_grab():
    box = ()
    im = ImageGrab.grab(box)
    path = "E:\\rok bot data\\bot garbage\\full_snap.png"
    im.save(path, 'PNG')
    return cv2.imread('E:\\rok bot data\\bot garbage\\full_snap.png')

def screenshot(win, path, kingdom, rank, name):
    hwnd = win32gui.FindWindow(None, win)

    # Change the line below depending on whether you want the whole window
    # or just the client area.
    #left, top, right, bot = win32gui.GetClientRect(hwnd)
    left, top, right, bot = win32gui.GetWindowRect(hwnd)
    w = right - left
    h = bot - top

    hwndDC = win32gui.GetWindowDC(hwnd)
    mfcDC  = win32ui.CreateDCFromHandle(hwndDC)
    saveDC = mfcDC.CreateCompatibleDC()

    saveBitMap = win32ui.CreateBitmap()
    saveBitMap.CreateCompatibleBitmap(mfcDC, w, h)

    saveDC.SelectObject(saveBitMap)

    # Change the line below depending on whether you want the whole window
    # or just the client area. 
    #result = windll.user32.PrintWindow(hwnd, saveDC.GetSafeHdc(), 1)
    result = windll.user32.PrintWindow(hwnd, saveDC.GetSafeHdc(), 0)

    bmpinfo = saveBitMap.GetInfo()
    bmpstr = saveBitMap.GetBitmapBits(True)

    im = Image.frombuffer('RGB',
    (bmpinfo['bmWidth'], bmpinfo['bmHeight']),
    bmpstr, 'raw', 'BGRX', 0, 1)

    win32gui.DeleteObject(saveBitMap.GetHandle())
    saveDC.DeleteDC()
    mfcDC.DeleteDC()
    win32gui.ReleaseDC(hwnd, hwndDC)

    if result == 1:
        im.save(path + "\\" + kingdom + "\\" + str(rank) + name + ".png")
