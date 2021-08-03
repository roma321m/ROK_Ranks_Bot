from PIL import Image
from PIL import ImageOps

def crop_ss_2(path, kingdom, rank, image_name):
    kingdom = "\\" + kingdom
    rank = "\\" + str(rank)
    image_name = "\\" + image_name + ".png"
    path += kingdom + rank

    im = Image.open(path + image_name)
    im = ImageOps.invert(im)
    thresh = 120
    fn = lambda x : 255 if x > thresh else 0
    im_power = im.convert('L').point(fn, mode='1')
    thresh = 138
    fn = lambda x : 255 if x > thresh else 0
    im = im.convert('L').point(fn, mode='1')

    name_snap = im.crop((480, 180, 760, 230))
    name_snap.save(path + "\\name_snap.png")

    power_snap = im_power.crop((960, 185, 1180, 225))
    power_snap.save(path + "\\power_snap.png")

    barbs_snap = im.crop((1300, 390, 1520, 430))
    barbs_snap.save(path + "\\barbs_snap.png")

    dead_snap = im.crop((1300, 530, 1520, 570))
    dead_snap.save(path + "\\dead_snap.png")

    rss_g_snap = im.crop((1300, 720, 1520, 760))
    rss_g_snap.save(path + "\\rss_g_snap.png")

    rss_a_snap = im.crop((1300, 790, 1520, 830))
    rss_a_snap.save(path + "\\rss_a_snap.png")

    helps_snap = im.crop((1300, 860, 1520, 900))
    helps_snap.save(path + "\\helps_snap.png")



    

# input from java: argv[] => [0] = crop_ss_1.py,  [1] = path, [2] = kingdom, [3] = rank, [4] = image_name 
#if __name__ == "__main__":
#    if len(sys.argv) == 5:
#        main(sys.argv[1:])
#    else:
#        print("nothing happened")