package pers.lovecode.util;
import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * 二维码工具类
 * Created by Administrator on 2017/3/31.
 * @author leo
 * @version v1.0
 */
public class QrcodeUtil {

    public static void QrcodeImg(String content,String imagePath) {
        Qrcode qrcode = new Qrcode();
        try {
            qrcode.setQrcodeErrorCorrect('M');
            qrcode.setQrcodeEncodeMode('B');
            qrcode.setQrcodeVersion(7);

            int width = 140;
            int height = 140;

            BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.setBackground(Color.white);
            graphics2D.setColor(Color.black);
            graphics2D.clearRect(0,0,width,height);

            byte[] contentByte = content.getBytes("utf-8");
            boolean[][] booleans = qrcode.calQrcode(contentByte);

            for (int i = 0;i<booleans.length;i++){
                for (int j = 0;j<booleans.length;j++){
                    if(booleans[j][i]){
                        graphics2D.fillRect(j*3+2,i*3+2,3,3);
                    }
                }
            }
//            graphics2D.fillRect(2,2,30,30);
            File file = new File(imagePath);
            ImageIO.write(bufferedImage,"png",file);
            graphics2D.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        QrcodeImg("万事如意","G:\\idea_workspace\\CMS_Demo\\src\\main\\resources\\images\\Qrcode.png");
    }
}
