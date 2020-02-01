package com.example.demo.common.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

/**
 * @author huyue01@sinovatech.com 2019/6/2 13:04
 */
@Slf4j
public class QRCode {
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

//    @Value("QRCode.local.dir")
//    private String dir;
//    @Value("QRCode.local.width")
//    private int width;
//    @Value("QRCode.local.height")
//    private int height;
//    @Value("QRCode.local.content")
//    private String content;
//    @Value("QRCode.local.imageType")
//    private String imageType;
//    @Value("QRCode.local.format")
//    private String type;

    public static void main(String[] args) {
        QRCode qrCode = new QRCode();
        qrCode.encode(BarcodeFormat.QR_CODE,"https://blog.csdn.net/hy_coming","D:\\qrcode\\");
    }

    /**
     * 生成二维码
     *
     * @param format
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void encode(BarcodeFormat format,String content,String dir) {
        log.info("生成二维码开始");
        try {
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdirs();
            }
            String path = dir + UUID.randomUUID().toString().replace("-", "") + System.currentTimeMillis() + ".png";
            file = new File(path);
            content = new String(content.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            //相关参数设置
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, format, 200, 200);
            writeToFile(bitMatrix, "png", file);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        log.info("生成二维码结束");
    }

    private static void writeToFile(BitMatrix bitMatrix, String format, File file) throws IOException {
        BufferedImage image = toBufferImage(bitMatrix);
        ImageIO.write(image, format, file);
    }


    private static BufferedImage toBufferImage(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     * 解析二维码内容
     *
     * @param file
     */
    private void decode(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            if (null == image) {
                System.out.println("image is null");
                return;
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(bitmap, hints);
            System.out.println("解析后的内容：" + result);
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }
    }


}