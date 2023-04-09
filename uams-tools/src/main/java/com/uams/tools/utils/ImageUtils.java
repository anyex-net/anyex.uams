package com.uams.tools.utils;

import com.uams.tools.enums.CommonEnums;
import com.uams.tools.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;

/**
 * ImageUtils 介绍
 * <p>File：ImageUtils.java </p>
 * <p>Title: ImageUtils </p>
 * <p>Description:ImageUtils </p>
 * <p>Copyright: Copyright (c) 2017/7/14 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
@SuppressWarnings("restriction")
public class ImageUtils
{
    public static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);
    
    /**
     * 本地图片转BASE64
     * @author admin
     * @param imgPath
     * @return
     */
    public static String toString(String imgPath)
    {
        InputStream in;
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] data = null;
        // 读取图片字节数组
        try
        {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            LoggerUtils.logError(logger, e.getLocalizedMessage());
        }
        return encoder.encode(data);
    }
    
    /**
     * 字符串转BufferedImage
     * @param base64string
     * @return
     */
    public static BufferedImage toBufferedImage(String base64string)
    {
        BufferedImage image = null;
        try
        {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64string);
            image = ImageIO.read(new ByteArrayInputStream(bytes));
        }
        catch (IOException e)
        {
            LoggerUtils.logError(logger, e.getLocalizedMessage());
        }
        return image;
    }

    /**
     * BufferedImage转base64
     * @param bufferedImage
     * @return
     */
    public static String BufferedImageToBase64 (BufferedImage bufferedImage)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try
        {
            ImageIO.write(bufferedImage, "jpg", baos);
        }
        catch (IOException e)
        {
            throw new BusinessException(CommonEnums.FAIL);
        }
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        return encoder.encodeBuffer(bytes).trim();
    }

    /**
     *获取提币确认图片
     * @param amount
     * @param address
     * @param confirmCode
     * @return
     */
    public static BufferedImage GraphicsToConfirmWithdrawBufferedImage (BigDecimal amount,String address,String confirmCode)
    {
        int imageWidth = 500;// 图片的宽度
        int imageHeight = 270;// 图片的高度
        BufferedImage image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(new Color(104,137,28));
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.white);
        graphics.setFont(new Font("黑体", Font.BOLD, 20));
        graphics.drawString("Tamper-proof Confirmation", 107, 80);
        graphics.drawString("Withdraw "+amount+" BTC to", 127, 120);
        graphics.drawString(address, 60, 160);
        graphics.drawString("Confirmation number :", 97, 230);
        graphics.setColor(Color.red);
        graphics.setFont(new Font("黑体", Font.BOLD, 28));
        graphics.drawString(confirmCode, 327, 228);
        return image;
    }
    
    /**
     * BASE图片
     * @param imgStr
     * @return
     */
    public static boolean toImage(String imgStr, String imgFilePath)
    {
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            for (int i = 0; i < b.length; ++i)
            {
                if (b[i] < 0)
                {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
            out.flush();
            out.close();
            return true;
        }
        catch (Exception e)
        {
            LoggerUtils.logError(logger, e.getLocalizedMessage());
            return false;
        }
    }
    
    /**
     * 删除文件
     * @param filePath
     */
    public static void delFile(String filePath)
    {
        File file = new File(filePath);
        if (file.exists())
        {
            file.delete();
        }
    }
}
