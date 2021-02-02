package com.codeworld.fc.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * ClassName ExcelUtil
 * Description Excel工具类
 * Author Lenovo
 * Date 2021/2/2
 * Version 1.0
 **/
@Slf4j
@Component
public class ExcelUtil {

    public void exportOrderExcel(HttpServletResponse response, String fileName, String title, String[] colName, List<Object[]> dataList) {
        //声明输出流
        OutputStream os = null;
        try {
            //获取输出流
            os = response.getOutputStream();
            /*execl文件生成*/
            //创建工作簿对象
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建工作表
            HSSFSheet sheet = workbook.createSheet(title);

            /*首先生成样式*/
            //获取列头样式对象
            HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
            //单元格样式对象
            HSSFCellStyle style = this.getStyle(workbook);

            /*数据标题生成*/
            //产生表格标题行
            HSSFRow rowm = sheet.createRow(0);
            //产生标题单元格
            HSSFCell cellTiltle = rowm.createCell(0);
            //设置标题单元格高度
            rowm.setHeight((short) (25 * 35));
            //标题单元格的合成合成0列到指定的行，来生成excel单元格
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (colName.length - 1)));
            //设置标题单元格的样式
            cellTiltle.setCellStyle(columnTopStyle);
            //设置单元格的值
            cellTiltle.setCellValue(title);

            /*定义列*/
            //定义所需列数
            int columnNum = colName.length;
            //在索引2的位置创建行(最顶端的行开始的第二行)，这一行作为列名称
            HSSFRow rowRowName = sheet.createRow(1);
            //设置高度
            rowRowName.setHeight((short) (25 * 25));
            //将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                //设置高度
                HSSFCell cellRowName = rowRowName.createCell(n);
                //设置列头单元格的数据类型
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);
                //设置列头单元格的值
                HSSFRichTextString text = new HSSFRichTextString(colName[n]);
                cellRowName.setCellValue(text);
                //设置列头单元格样式
                cellRowName.setCellStyle(columnTopStyle);
            }

            /*将查询出的数据设置到sheet对应的单元格中*/
            for (int i = 0; i < dataList.size(); i++) {
                //遍历每个对象，这个的每一个Object[]其实就是一个行中的所有数据
                Object[] obj = dataList.get(i);
                //创建所需的行数
                HSSFRow row = sheet.createRow(i + 2);
                //设置创建的每一行的高度
                row.setHeight((short) (25 * 20));
                //将不同的对象的具体信息放到每一行中
                for (int j = 0; j < obj.length; j++) {
                    //设置单元格的数据类型
                    HSSFCell cell = null;

                    //第0列插入行号
                    if (j == 0) {
                        //为0的时候先插入ID
                        cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
                        cell.setCellValue(i + 1);
                        cell.setCellStyle(style);

                        //再插入第一个数据
                        cell = row.createCell(j + 1, HSSFCell.CELL_TYPE_STRING);
                        cell.setCellValue(obj[0].toString());
                    } else {
                        cell = row.createCell(j + 1, HSSFCell.CELL_TYPE_STRING);

                        if (!StringUtils.isEmpty(obj[j])) {
                            //设置单元格的值
                            cell.setCellValue(obj[j].toString());
                        }
                        //为空直接设置控制
                        else {
                            //设置单元格的值
                            cell.setCellValue("");
                        }
                    }

                    //设置单元格样式
                    cell.setCellStyle(style);
                }
            }

            /*让列宽随着导出的列长自动适应*/
            for (int colNum = 0; colNum < columnNum; colNum++) {
                //一个excel文件中存在多个表，一个sheet就是一张表
                int columnWidth = sheet.getColumnWidth(colNum) / 256;

                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;

                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }

                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);

                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;

                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }

                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 128);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
            //将整理好的excel数据写入流中
            response.setHeader("Content-type","application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输出流
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置每一列的开头的样式
     *
     * @param workbook 工作簿
     * @return 设置号的样式
     */
    public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //设置单元格背景颜色
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        return style;
    }

    /**
     * 普通数据的单元格的样式设置
     *
     * @param workbook 工作薄
     * @return
     */
    public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        //设置字体
        HSSFFont font = workbook.createFont();
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //将单元格数据设置为文本格式
        HSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("@"));

        return style;
    }
}
