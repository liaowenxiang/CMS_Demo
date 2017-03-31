package pers.mark.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @className HandImg
 * @author leo
 * @description 图片水印系统
 * @version v1.0
 * Created by Administrator on 2017/3/29.
 */
public class HandImg {

    public static void addWatermark(String img,String targetImg) {
        FileOutputStream fs = null;
        try {

            //加载水印
            File imageFile = new File(img);
            Image image = ImageIO.read(imageFile);
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            //添加底图
            File target = new File(targetImg);
            Image mark = ImageIO.read(target);
            int _width = mark.getWidth(null);
            int _height = mark.getHeight(null);

            //创建一个画板
            BufferedImage bufferedImage = new BufferedImage(_width,_height,BufferedImage.TYPE_INT_RGB);
            //绘制工具
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.drawImage(mark,0,0,_width,_height,null);
            graphics2D.drawImage(image,(_width-width)/2,(_height-height)/2,null);

            //结束绘制
            graphics2D.dispose();

            fs = new FileOutputStream(targetImg);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fs);
            encoder.encode(bufferedImage);
            System.out.println("添加水印成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs!=null)
                    fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        addWatermark("G:\\idea_workspace\\CMS_Demo\\src\\main\\resources\\images\\car.png","G:\\idea_workspace\\CMS_Demo\\src\\main\\resources\\images\\1.jpg");
    }
}
