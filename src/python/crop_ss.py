import cv2
from PIL import Image

def crop_ss_1(path, kingdom, rank):
    kingdom = "\\" + kingdom
    rank = "\\" + str(rank)
    image_name = "\\1.png"
    path += kingdom + rank

    image = Image.open(path + image_name)
    id_snap = image.crop((915, 300, 1070, 330))
    id_snap.save(path + "\\id_snap.png")
    preprocess(path , "\\id_snap.png", False)
    t1_snap = image.crop((1017, 690, 1200, 730))
    t1_snap.save(path + "\\t1_snap.png")
    preprocess(path , "\\t1_snap.png", True)
    t2_snap = image.crop((1017, 740, 1200, 780))
    t2_snap.save(path + "\\t2_snap.png")
    preprocess(path , "\\t2_snap.png", True)
    t3_snap = image.crop((1017, 790, 1200, 830))
    t3_snap.save(path + "\\t3_snap.png")
    preprocess(path , "\\t3_snap.png", True)
    t4_snap = image.crop((1017, 840, 1200, 880))
    t4_snap.save(path + "\\t4_snap.png")
    preprocess(path , "\\t4_snap.png", True)
    t5_snap = image.crop((1017, 890, 1200, 930))
    t5_snap.save(path + "\\t5_snap.png")
    preprocess(path , "\\t5_snap.png", True)

def crop_ss_2(path, kingdom, rank):
    kingdom = "\\" + kingdom
    rank = "\\" + str(rank)
    image_name = "\\2.png"
    path += kingdom + rank

    image = Image.open(path + image_name)
    name_snap = image.crop((480, 180, 760, 230))
    name_snap.save(path + "\\name_snap.png")
    preprocess(path , "\\name_snap.png", False)
    power_snap = image.crop((960, 185, 1180, 225))
    power_snap.save(path + "\\power_snap.png")
    preprocess(path , "\\power_snap.png", False)
    barbs_snap = image.crop((1300, 390, 1520, 430))
    barbs_snap.save(path + "\\barbs_snap.png")
    preprocess(path , "\\barbs_snap.png", False)
    dead_snap = image.crop((1300, 530, 1520, 570))
    dead_snap.save(path + "\\dead_snap.png")
    preprocess(path , "\\dead_snap.png", False)
    rss_g_snap = image.crop((1300, 720, 1520, 760))
    rss_g_snap.save(path + "\\rss_g_snap.png")
    preprocess(path , "\\rss_g_snap.png", False)
    rss_a_snap = image.crop((1300, 790, 1520, 830))
    rss_a_snap.save(path + "\\rss_a_snap.png")
    preprocess(path , "\\rss_a_snap.png", False)
    helps_snap = image.crop((1300, 860, 1520, 900))
    helps_snap.save(path + "\\helps_snap.png")
    preprocess(path , "\\helps_snap.png", False)

def crop_ss_power(path, kingdom, rank):
    rank_str = "\\rank "
    png_str = ".png"
    kingdom = "\\" + kingdom
    r = "\\" + str(rank) + png_str
    path += kingdom
    image = Image.open(path + r)

    rank_plus_1 = image.crop((1340, 320, 1560, 380))
    rank_plus_1.save(path + rank_str + str((rank-1)*6 + 1) + png_str)
    preprocess(path , rank_str + str((rank-1)*6 + 1) + png_str, False)

    rank_plus_2 = image.crop((1340, 430, 1560, 490))
    rank_plus_2.save(path + rank_str + str((rank-1)*6 + 2) + png_str)
    preprocess(path , rank_str + str((rank-1)*6 + 2) + png_str, False)

    rank_plus_3 = image.crop((1340, 540, 1560, 600))
    rank_plus_3.save(path + rank_str + str((rank-1)*6 + 3) + png_str)
    preprocess(path , rank_str + str((rank-1)*6 + 3) + png_str, False)

    rank_plus_4 = image.crop((1340, 660, 1560, 710))
    rank_plus_4.save(path + rank_str + str((rank-1)*6 + 4) + png_str)
    preprocess(path , rank_str + str((rank-1)*6 + 4) + png_str, False)

    rank_plus_5 = image.crop((1340, 770, 1560, 830))
    rank_plus_5.save(path + rank_str + str((rank-1)*6 + 5) + png_str)
    preprocess(path , rank_str + str((rank-1)*6 + 5) + png_str, False)

    rank_plus_6 = image.crop((1340, 880, 1560, 940))
    rank_plus_6.save(path + rank_str + str((rank)*6) + png_str)
    preprocess(path , rank_str + str((rank)*6) + png_str, False)


def preprocess(path ,name, invert):
    # Grayscale, Gaussian blur, Otsu's threshold
    image = cv2.imread(path + name)
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    blur = cv2.GaussianBlur(gray, (1,1), 0)
    thresh = cv2.threshold(blur, 0, 255, cv2.THRESH_BINARY_INV + cv2.THRESH_OTSU)[1]

    # Morph open to remove noise and invert image
    kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (1,1))
    opening = cv2.morphologyEx(thresh, cv2.MORPH_OPEN, kernel, iterations=1)
    invert_pic = 255 - opening
    if invert:
        cv2.imwrite(path + name, invert_pic)
    else:
        cv2.imwrite(path + name, opening)