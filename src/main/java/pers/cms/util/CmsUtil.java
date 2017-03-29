package pers.cms.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/24.
 */
public class CmsUtil {
    public static boolean getHtmlByUrl(String u ,String charset ,String htmlPath){
        boolean result=false;
        try {
            URL url = new URL(u);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,charset));

            StringBuffer buffer = new StringBuffer();
            while (reader.ready()){
                buffer.append(reader.readLine()+"\n");
            }
            reader.close();
            inputStream.close();
            File file = new File(htmlPath);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(file)));
            writer.write(buffer.toString());
            result = true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean getHtmlTemplate(String template, String htmlPath, Map<String ,String> value){

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(template);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String string = "";
            StringBuffer buffer = new StringBuffer();
            while ((string=reader.readLine())!=null){
                buffer.append(string+"\n");
            }
            reader.close();
            inputStream.close();

            Iterator<String> iterator = value.keySet().iterator();
            String content = buffer.toString();

            while (iterator.hasNext()){
                String key = iterator.next();
                content.replaceAll(key,value.get(key));
            }
            File file = new File(htmlPath);

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(file)
            ));
            writer.write(content.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

        return false;
    }

    public static void main(String[] args) {
        boolean flag = getHtmlByUrl("http://www.qq.com","gbk", "G:/idea_workspace/CMS_Demo/src/main/resources/index.html");
    }
}
