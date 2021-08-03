import cv2
from PIL import Image
from PIL import ImageOps

def crop_ss_1(path, kingdom, rank, image_name):
    kingdom = "\\" + kingdom
    rank = "\\" + str(rank)
    image_name = "\\" + image_name + ".png"
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

    '''
    im = Image.open(path + image_name)
    thresh = 118
    fn = lambda x : 255 if x > thresh else 0
    im_id = ImageOps.invert(im)
    im_id = im_id.convert('L').point(fn, mode='1')
    id_snap = im_id.crop((915, 300, 1070, 330))
    id_snap.save(path + "\\id_snap.png")

    thresh = 138
    fn = lambda x : 255 if x > thresh else 0
    im = im.convert('L').point(fn, mode='1')
    
    t1_snap = im.crop((1017, 690, 1200, 730))
    t1_snap.save(path + "\\t1_snap.png")

    t2_snap = im.crop((1017, 740, 1200, 780))
    t2_snap.save(path + "\\t2_snap.png")

    t3_snap = im.crop((1017, 790, 1200, 830))
    t3_snap.save(path + "\\t3_snap.png")

    t4_snap = im.crop((1017, 840, 1200, 880))
    t4_snap.save(path + "\\t4_snap.png")

    t5_snap = im.crop((1017, 890, 1200, 930))
    t5_snap.save(path + "\\t5_snap.png")
    '''


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
    

# input from java: argv[] => [0] = crop_ss_1.py,  [1] = path, [2] = kingdom, [3] = rank, [4] = image_name 
#if __name__ == "__main__":
#    if len(sys.argv) == 5:
#        main(sys.argv[1:])
#    else:
#        print("nothing happened")