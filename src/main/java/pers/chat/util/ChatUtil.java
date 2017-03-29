package pers.chat.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 人工智能客服 IM系统工具类
 * @author Leo
 * @version v1.0
 * Created by Administrator on 2017/3/25.
 */
public class ChatUtil {

    /**
     *对话人工智能来获取答案
     * @author Leo
     * @param message 消息
     * @return 智能客服回复的内容
     *  </br>
     *  <a href="http://www.baidu.com">百度一下，你就知道</a>
     */
    public static String getResult(String message){
        StringBuffer buffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        InputStreamReader reader = null;
        try {
            //设置编码格式
            String question = URLEncoder.encode(message,"utf-8");
            //请求URL对接图灵机器人接口
            String requestUrl = "http://www.tuling123.com/openapi/api?key=ae824a24e8e34146ad04b8e03f85b93f&info="+question;
            // 建立网络连接
            URL url = new URL(requestUrl);
            //获取链接对象，打开链接
            URLConnection connection = url.openConnection();
            //直接链接
            connection.connect();
            //获取请求结果
            reader = new InputStreamReader(connection.getInputStream(),"utf-8");
            //建立文件缓冲流
            bufferedReader = new BufferedReader(reader);

            String temp = null;

            while ((temp = bufferedReader.readLine())!=null){
                buffer.append(temp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null)
            {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(getResult("你上几年级？"));
    }
}
