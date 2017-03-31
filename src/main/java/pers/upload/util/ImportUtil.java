package pers.upload.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 大数据批量导入工具类
 * Created by Administrator on 2017/3/30.
 * @author leo
 * @version v1.0
 */
public class ImportUtil {
    //java入口
    public static void main(String[] args) {
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        try {
            String excelUtil = "";
            FileInputStream inputStream = new FileInputStream(excelUtil);
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            for (int i=0;i<cols;i++){
                Cell[] cell = sheet.getRow(i+1);
                String title = cell[0].getContents();
                String desc = cell[1].getContents();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
