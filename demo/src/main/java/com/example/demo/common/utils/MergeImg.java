package com.example.demo.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author huyue01@sinovatech.com 2019/6/23 15:32
 */
@Slf4j
public class MergeImg {
    private BufferedImage getImageFromLocal(String path) throws IOException {
        return ImageIO.read(new File(path));

    }

    private BufferedImage mergeImage(BufferedImage img1, BufferedImage img2) {
        if (!StringUtils.isEmpty(img1) && !StringUtils.isEmpty(img2)) {
            int width = img1.getWidth();
            int height = img1.getHeight();

            Graphics2D graphics2D = img2.createGraphics();
            graphics2D.drawImage(img1, 380, 412, width, height, null);
            graphics2D.dispose();
        }
        return img2;
    }

    private void writeImageToLocal(String newPath, BufferedImage img) throws IOException {
        if (!StringUtils.isEmpty(newPath) && !StringUtils.isEmpty(img)) {
            ImageIO.write(img, "png", new File(newPath));
        }
    }

    public void saveMergeImage(String path1, String path2, String newPath) {
        log.info("合成图片开始");
        try {
            writeImageToLocal(newPath, mergeImage(getImageFromLocal(path1), getImageFromLocal(path2)));
            log.info("合成图片结束");
        } catch (IOException e) {
            log.error("合成图片异常");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MergeImg img = new MergeImg();
        String path1 = "D:\\qrcode\\fee46d35ce2547adbded2475927df26f1561274933918.png";
        String path2 = "D:\\qrcode\\timg.jpg";
        String newPath = "D:\\qrcode\\mergeImg"+System.currentTimeMillis() + ".png";
        img.saveMergeImage(path1,path2,newPath);

    }

}
