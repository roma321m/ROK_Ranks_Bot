import sys
import win32gui
import win32ui
from ctypes import windll
from PIL import Image

def screenshot(win, path, name):
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
        im.save(path + name + ".png")

def main(argv):
    window_name = argv[0]
    path = argv[1]
    kingdom = "\\" + argv[2]
    rank = "\\" + argv[3]
    image_name = "\\" + argv[4]

    path += kingdom + rank

    # path = r"E:\\rok bot data\\1254\\1"
    # image_name = "1.png" || "2.png"
    screenshot(window_name, path, image_name)
    

# input from java: argv[] => [0] = take_ss.py, [1] = window name,  [2] = path, [3] = kingdom, [4] = rank, [5] = image_name 
if __name__ == "__main__":
    if len(sys.argv) == 6:
        main(sys.argv[1:])
    else:
        print("nothing happened")