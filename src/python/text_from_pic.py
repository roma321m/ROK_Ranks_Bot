import pytesseract
import sys
import cv2

def main(argv):
    # input from java: argv[] => [0] = text_from_pic.py, [1] = path, [2] = kingdom, [3] = rank
    path = argv[0]
    kingdom = "\\" + argv[1]
    rank = "\\" + argv[2]

    barbs = "\\barbs_snap.png"
    deads = "\\dead_snap.png"
    helps = "\\helps_snap.png"
    gov_id = "\\id_snap.png"
    power = "\\power_snap.png"
    rss_a = "\\rss_a_snap.png"
    rss_g = "\\rss_g_snap.png"
    t1 = "\\t1_snap.png"
    t2 = "\\t2_snap.png"
    t3 = "\\t3_snap.png"
    t4 = "\\t4_snap.png"
    t5 = "\\t5_snap.png"

    pytesseract.pytesseract.tesseract_cmd = r"C:\\Program Files\\Tesseract-OCR\\tesseract.exe"

    path += kingdom + rank

    try:
        image = cv2.imread(path + barbs)
        text_barbs = pytesseract.image_to_string(image)
        if text_barbs == None:
            text_barbs = "0"

        image2 = cv2.imread(path + deads)
        text_deads = pytesseract.image_to_string(image2)
        if text_deads == None:
            text_deads = "0"

        image = cv2.imread(path + helps)
        text_helps = pytesseract.image_to_string(image)
        if text_helps == None:
            text_helps = "0"

        image = cv2.imread(path + gov_id)
        text_gov_id = pytesseract.image_to_string(image)
        if text_gov_id == None:
            text_gov_id = "0"

        image = cv2.imread(path + power)
        text_power = pytesseract.image_to_string(image)
        if text_power == None:
            text_power = "0"

        image = cv2.imread(path + rss_a)
        text_rss_a = pytesseract.image_to_string(image)
        if text_rss_a == None:
            text_rss_a = "0"

        image = cv2.imread(path + rss_g)
        text_rss_g = pytesseract.image_to_string(image)
        if text_rss_g == None:
            text_rss_g = "0"

        image = cv2.imread(path + t1)
        text_t1 = pytesseract.image_to_string(image)
        if text_t1 == None:
            text_t1 = "0"

        image = cv2.imread(path + t2)
        text_t2 = pytesseract.image_to_string(image)
        if text_t2 == None:
            text_t2 = "0"

        image = cv2.imread(path + t3)
        text_t3 = pytesseract.image_to_string(image)
        if text_t3 == None:
            text_t3 = "0"

        image = cv2.imread(path + t4)
        text_t4 = pytesseract.image_to_string(image)
        if text_t4 == None:
            text_t4 = "0"

        image = cv2.imread(path + t5)
        text_t5 = pytesseract.image_to_string(image)
        if text_t5 == None:
            text_t5 = "0"

        text = text_barbs + text_deads + text_helps + text_gov_id + text_power + text_rss_a + text_rss_g + text_t1 + text_t2 + text_t3 + text_t4 + text_t5
        print (text)
        return text
    except Exception as e:
        print(e)
    return "error"

if __name__ == "__main__":
    if len(sys.argv) == 4:
        main(sys.argv[1:])
    else:
        print("nothing happened")
