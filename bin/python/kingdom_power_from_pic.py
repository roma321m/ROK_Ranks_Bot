import pytesseract
import sys
import cv2

def main(argv):
    path = argv[0]
    kingdom = "\\Power - " + argv[1]
    end_rank = argv[2]

    pytesseract.pytesseract.tesseract_cmd = r"C:\\Program Files\\Tesseract-OCR\\tesseract.exe"

    path += kingdom
    str_rank = "\\rank "
    str_png = ".png"
    result = 0
    result_cap = 0
    top50 = 0
    top100 = 0
    top150 = 0
    top200 = 0
    top300 = 0
    top300cap = 0
    top650 = 0
    end = int(end_rank)

    if end >= 50:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 1, 51)
        top50 = result
        
    if end >= 100:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 51, 101)
        top100 = result

    if end >= 150:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 101, 151)
        top150 = result
        
    if end >= 200:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 151, 201)
        top200 = result
        
    if end >= 300:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 201, 301)
        top300 = result
        top300cap = result_cap
        
    if end >= 650:
        result, result_cap = loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, 301, 651)
        top650 = result
    
    res = "\n " + str(top50) + "\n " + str(top100) + "\n " + str(top150) + "\n " + str(top200) + "\n " + str(top300cap) + "\n " + str(top300) + "\n " + str(top650)
    print(res)

def str_to_digits_only(str):
    str_number = ""
    for c in str:
        if c.isdigit():
            str_number += c
    return str_number

def loop_on_rank_pic_from_start_to_finish(path, str_rank, str_png, result, result_cap, start, finish):
    for rank in range(start, finish):
        try:
            image = cv2.imread(path + str_rank + str(rank) + str_png)
            power = pytesseract.image_to_string(image)
        except Exception as e:
            print(e)
        if power == None:
            return 0, 0
        else:
            if int(str_to_digits_only(power)) > 150000000:
                result_cap += 150000000
            else:
                result_cap += int(str_to_digits_only(power))
        result += int(str_to_digits_only(power))
    return result, result_cap

# input from java: argv[] => [0] = kingdom_power_from_pic.py, [1] = path, [2] = kingdom,
#    [3] = end rank

if __name__ == "__main__":
    if len(sys.argv) == 4:
        main(sys.argv[1:])
    else:
        print("nothing happened")
