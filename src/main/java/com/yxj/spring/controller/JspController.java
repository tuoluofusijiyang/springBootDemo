package com.yxj.spring.controller;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

/**
 * @ProjectName: springBootDemo
 * @Package: com.yxj.spring.controller
 * @Description:
 * @Author: 阿杰
 * @CreateDate: 2019/1/28 0:00
 * @UpdateUser: 暂无
 * @UpdateDate: 2019/1/28 0:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Controller
public class JspController {

    @GetMapping(value = "/toTsetJsp/{id}")
    public ModelAndView toTsetJsp(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testParam", id);
        return modelAndView;
    }

    @GetMapping(value = "/toB")
    public ModelAndView toA() {
        ModelAndView modelAndView = new ModelAndView("b");
        return modelAndView;
    }

    @PostMapping(value = "/excel")
    @ResponseBody
    public void excel() {

    }

    public static void main(String[] args) {
        String[][] rowArray = getArrayFromXLSX("D:\\logs\\a.xlsx",2);
        for (String[] row : rowArray) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 获取xlsx文件内容某个sheet（从0开始）的内容，以二维数组形式返回
     *
     * @param fileAbsolutePath xlsx文件的绝对路径
     * @return xlsx文件的文本内容
     */
    public static String[][] getArrayFromXLSX(String fileAbsolutePath, int bookIndex) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(fileAbsolutePath));
            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            if (bookIndex >= book.getNumberOfSheets()) {
                System.out.println("getArrayFromXLSX error: bookIndex={} is to large! "+ bookIndex);
                return null;
            }
            XSSFSheet sheet = book.getSheetAt(bookIndex);
            int rowNum = sheet.getLastRowNum() + 1;//多少行
            int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells() - 1;//多少列，此处可以写死为
            String[][] contents = new String[rowNum][coloumNum];
            for (int j = 0; j < rowNum; j++) {
                XSSFRow row = sheet.getRow(j);
                if (row != null) {
                    for (int k = 0; k < row.getLastCellNum(); k++) {
                        contents[j][k] = getXCellFormatValue(row.getCell(k));
                    }
                }
            }
            return contents;
        } catch (Exception ie) {
            System.out.println("getArrayFromXLSX error: IOException"+ ie.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    System.out.println("getArrayFromXLSX close Exception"+ e.getMessage());
                }
            }
        }
        return null;
    }

    private static String getXCellFormatValue(XSSFCell cell) {
        String cellValue = "";
        if (null != cell) {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    cellValue = (new Double(cell.getNumericCellValue())).intValue() + "";
                    break;
                default:
                    cellValue = " ";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

}
