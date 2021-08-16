import time
import cv2
import clipboard
import codecs
import sys

from controls import left_click
from controls import mouse_pos
from controls import scroll
from screen_images import check_image_match
from screen_images import screen_grab
from screen_images import screenshot
from crop_ss import crop_ss_1
from crop_ss import crop_ss_2
from crop_ss import crop_ss_power

PATH = "E:\\rok bot data\\bot templates\\"

def start_game():
    screenshot = screen_grab()
    gameLogoPic = cv2.imread(PATH + 'game logo.png')
    profilePic = cv2.imread(PATH + 'profile.png')
    errorPic = cv2.imread(PATH + 'login error.png')
    if check_image_match(screenshot, gameLogoPic, .6) != (0, 0):
        mouse_pos(1075, 190)
        left_click()
        time.sleep(10)
    
    while(True):
        time.sleep(2)
        screenshot = screen_grab()
        x1, y1 = check_image_match(screenshot, profilePic, .6)
        x2, y2 = check_image_match(screenshot, errorPic, .6)
        if x1 != 0 or y1 != 0:
            print("profile found\n")
            break
        if x2 != 0 or y2 != 0:
            print("conffirm found\n")
            mouse_pos(950, 690)
            left_click()
            time.sleep(15)


def open_ranks():
    # click the profile picture
    time.sleep(1)
    mouse_pos(120, 90)
    left_click()
    govProfile = cv2.imread(PATH + 'governor profile.png')
    ranksPic = cv2.imread(PATH + 'rankings.png')
    individualPowerPic = cv2.imread(PATH + 'individual power.png')
    errorPic = cv2.imread(PATH + 'login error.png')

    # wait for governor profile screen
    while(True):
        time.sleep(1)
        screenshot = screen_grab()
        x, y = check_image_match(screenshot, govProfile, .6)
        if x != 0 or y != 0:
            print("governor profile screen on\n")
            break
    
    # click rankings
    mouse_pos(670, 770)
    left_click()

    # wait for rankings screen
    while(True):
        time.sleep(1)
        screenshot = screen_grab()
        x, y = check_image_match(screenshot, ranksPic, .6)
        if x != 0 or y != 0:
            print("ranking screen on\n")
            break
    
    # click individual power ranks
    mouse_pos(500, 610)
    left_click()

    # wait for rankings screen
    count = 0
    while(count < 200):
        time.sleep(.1)
        screenshot = screen_grab()
        x, y = check_image_match(screenshot, individualPowerPic, .8)
        x2, y2 = check_image_match(screenshot, errorPic, .6)
        if x != 0 or y != 0:
            print("individual power ranking screen on\n")
            break
        if x2 != 0 or y2 != 0:
            print("error found\n")
            break
        count += 1


def loop_on_players_in_ranks(win, path, kingdom, lastRank):
    govProfile = cv2.imread(PATH + 'governor profile.png')
    killPoints  = cv2.imread(PATH + 'kill points.png')
    individualPowerPic = cv2.imread(PATH + 'individual power.png')
    errorPic = cv2.imread(PATH + 'login error.png')
    moreInfo = cv2.imread(PATH + 'more info.png')

    rank_y = 240
    rank = 1
    while rank <= lastRank:
        if rank < 5:
            rank_y += 112
        else:
            rank_y = 715

        print("rank: " + str(rank) + "\n")

        # check if ranking screen on
        count = 0
        while(count < 100): # 20 sec max waiting before break
            time.sleep(.2)
            snap = screen_grab()
            x, y = check_image_match(snap, individualPowerPic, .8)
            x2, y2 = check_image_match(snap, errorPic, .6)
            if x != 0 or y != 0:
                print("individual power ranking screen on\n")
                break
            if x2 != 0 or y2 != 0:
                print("error found\n")
                break
            count += 1
        if count == 100:
            break
        # click on the player in rank position
        mouse_pos(950, rank_y)
        left_click()

        # check if gov profile screen on
        count = 0
        while(count < 100): # 20 sec max waiting before break
            time.sleep(.2)
            snap = screen_grab()
            x, y = check_image_match(snap, govProfile, .6)
            x2, y2 = check_image_match(snap, errorPic, .6)
            if x != 0 or y != 0:
                print("gov profile screen on\n")
                break
            if x2 != 0 or y2 != 0:
                print("error found\n")
                break
            count += 1
        if count == 100:
            mouse_pos(950, 830) # point of the next rank
            left_click()
            count = 0
            while(count < 100): # 20 sec max waiting before break
                time.sleep(.2)
                snap = screen_grab()
                x, y = check_image_match(snap, govProfile, .6)
                x2, y2 = check_image_match(snap, errorPic, .6)
                if x != 0 or y != 0:
                    print("gov profile screen on\n")
                    break
                if x2 != 0 or y2 != 0:
                    print("error found\n")
                    break
                count += 1
            if count == 100:
                print("error on opening a gov profile")
                break
        # click kill points
        mouse_pos(1295, 430)
        left_click()

        # check kill points screen on
        count = 0
        while(count < 100): # 20 sec max waiting before break
            time.sleep(.2)
            snap = screen_grab()
            x, y = check_image_match(snap, killPoints, .6)
            x2, y2 = check_image_match(snap, errorPic, .6)
            if x != 0 or y != 0:
                print("kill points screen on\n")
                break
            if x2 != 0 or y2 != 0:
                print("error found\n")
                break
            count += 1
        if count == 100:
            break
        # run take ss 1 ########################
        screenshot(win, path, kingdom, rank, "\\1")
        # click more info
        mouse_pos(480, 780)
        left_click()

        # check more info (resource statistics)  and (battale statistics)
        count = 0
        while(count < 100): # 20 sec max waiting before break
            time.sleep(.2)
            snap = screen_grab()
            x, y = check_image_match(snap, moreInfo, .6)
            x2, y2 = check_image_match(snap, errorPic, .6)
            if x != 0 or y != 0:
                print("more info screen on\n")
                break
            if x2 != 0 or y2 != 0:
                print("error found\n")
                break
            count += 1
        if count == 100:
            break
        # run take ss 2 ########################
        screenshot(win, path, kingdom, rank, "\\2")

        # click copy name
        mouse_pos(510, 210)
        left_click()
        time.sleep(.3)
        with codecs.open(path + "\\" + kingdom + "\\" + str(rank) + "\\playerName.txt", "w", "utf-8-sig") as temp:
            temp.write(clipboard.paste())

        # crop images
        crop_ss_1(path, kingdom, rank)
        crop_ss_2(path, kingdom, rank)

        # click exit more info
        mouse_pos(1610, 95)
        left_click()

        # check if gov profile screen on
        count = 0
        while(count < 100): # 20 sec max waiting before break
            time.sleep(.2)
            snap = screen_grab()
            x, y = check_image_match(snap, govProfile, .6)
            x2, y2 = check_image_match(snap, errorPic, .6)
            if x != 0 or y != 0:
                print("gov profile screen on\n")
                break
            if x2 != 0 or y2 != 0:
                print("error found\n")
                break
            count += 1
        if count == 100:
            break
        # click exit governor profile
        mouse_pos(1570, 150)
        left_click()

        rank += 1


def loop_on_power_ranks(win, path, kingdom, lastRank):
    r = 1
    if lastRank == 300:
        r = 51    #(1, 51) = top 300 (1 pic = 6 players)
    else:
        r = 110   #(1, 110) = top 654 (1 pic = 6 players)
    for rank in range(1, r):
        screenshot(win, path, kingdom, "power", "\\"+str(rank))
        if rank%2 == 1:
            scroll(1400, 880, 1400, 183)
        else:
            scroll(1400, 880, 1400, 182)
        time.sleep(.2)
        crop_ss_power(path, kingdom, rank)


def main(argv):
    if argv[2] == "true":
        start_game()
    if argv[3] == "true":
        open_ranks()
    if argv[4] == "true":
        loop_on_players_in_ranks(argv[0], argv[1], argv[2], argv[5])
    else:
        loop_on_power_ranks(argv[0], argv[1], "Power - " + argv[2], argv[5])
    #("BlueStacks 2", "E:\\rok bot data", "Power - k1254  08-08-2021")


# input from java: argv[] => [0] = bot.py, [1] = window name, [2] = path, [3] = kingdom, [3] = start game (true/false),
# [4] = open ranks (true/false), [5] all stats (true/false), [6] = lastRank (300/650)
if __name__ == "__main__":
    if len(sys.argv) == 7:
        main(sys.argv[1:])
    else:
        print("nothing happened")
