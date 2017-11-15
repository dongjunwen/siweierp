package com.fangxin.siwei.fangzhi.common.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel 样式定制
 * （如有需要，可自由在此方法中，增加方法设置需要的样式）
 *
 * @author zhangby
 * @date 2017/8/22 8:42
 */
public class ExcelStyle {
    private CellStyle cellStyle;
    private Font font;

    /**
     * 底部边框
     */
    public static short BORDER_BOTTOM = 1;
    /**
     * 左部边框
     */
    public static short BORDER_LEFT = 2;
    /**
     * 右部边框
     */
    public static short BORDER_RIGHT = 3;
    /**
     * 顶部边框
     */
    public static short BORDER_TOP = 4;

    private ExcelStyle(Workbook workbook) {
        this.cellStyle = workbook.createCellStyle();
        this.font = workbook.createFont();
    }
    private ExcelStyle(CellStyle cellStyle, Font font) {
        this.cellStyle = cellStyle;
        this.font = font;
    }

    /**
     * 构建ExcelStyle
     *
     * @param workbook
     * @return
     */
    public static ExcelStyle builder(Workbook workbook) {
        return new ExcelStyle(workbook);
    }

    public static ExcelStyle builder(Excel excel) {
        return new ExcelStyle(excel.getWorkbook());
    }

    public static ExcelStyle getCellStyle(Sheet sheet, int row, int cell) {
        CellStyle cellStyle = sheet.getRow(row).getCell(cell).getCellStyle();
        return new ExcelStyle(cellStyle, sheet.getWorkbook().createFont());
    }


    /**
     * 返回CellStyle
     *
     * @return
     */
    public CellStyle build() {
        CellStyle cellStyle = this.cellStyle;
        cellStyle.setFont(this.font);
        return cellStyle;
    }

    /**
     * 设置表格加粗
     *
     * @return
     */
    public ExcelStyle cloneStyle(CellStyle csl) {
        this.cellStyle.cloneStyleFrom(csl);
        return this;
    }

    /**
     * 对齐方式
     *
     * @param align_status <br>
     *                     HSSFCellStyle.ALIGN_LEFT    居左 <br>
     *                     HSSFCellStyle.ALIGN_CENTER  居中 <br>
     *                     HSSFCellStyle.ALIGN_RIGHT   居右 <br>
     *                     .....
     * @return
     */
    public ExcelStyle align(Short align_status) {
        this.cellStyle.setAlignment(align_status);
        return this;
    }

    /**
     * 垂直对齐方式
     *
     * @param align_status <br>
     *                     HSSFCellStyle.VERTICAL_TOP       顶部 <br>
     *                     HSSFCellStyle.VERTICAL_BOTTOM    底部 <br>
     *                     HSSFCellStyle.VERTICAL_CENTER    居中 <br>
     *                     HSSFCellStyle.VERTICAL_JUSTIFY   对齐 <br>
     * @return
     */
    public ExcelStyle verticalAlign(Short align_status) {

        this.cellStyle.setVerticalAlignment(align_status);
        return this;
    }

    /**
     * 设置边框
     *
     * @param border_status <br>
     *                      BORDER_BOTTOM   底边框 <br>
     *                      BORDER_LEFT     左边框 <br>
     *                      BORDER_RIGHT    右边框 <br>
     *                      BORDER_TOP      顶边框 <br>
     * @return
     */
    public ExcelStyle border(Short... border_status) {
        List<Short> shorts = new ArrayList<>();
        for (Short st : border_status) {
            shorts.add(st);
        }
        if (shorts.size() < 1) return this;
        if (shorts.contains(BORDER_BOTTOM)) {
            this.cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        }
        if (shorts.contains(BORDER_LEFT)) {
            this.cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        }
        if (shorts.contains(BORDER_RIGHT)) {
            this.cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        }
        if (shorts.contains(BORDER_TOP)) {
            this.cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        }
        return this;
    }

    /**
     * 设置边框颜色
     *
     * @param border_status <br>
     *                      BORDER_BOTTOM   底边框 <br>
     *                      BORDER_LEFT     左边框 <br>
     *                      BORDER_RIGHT    右边框 <br>
     *                      BORDER_TOP      顶边框 <br>
     * @param color         颜色
     * @return
     */
    public ExcelStyle borderColor(Short border_status, Short color) {
        if (border_status == BORDER_BOTTOM) {
            this.cellStyle.setBottomBorderColor(color);
        }
        if (border_status == BORDER_LEFT) {
            this.cellStyle.setLeftBorderColor(color);
        }
        if (border_status == BORDER_RIGHT) {
            this.cellStyle.setRightBorderColor(color);
        }
        if (border_status == BORDER_TOP) {
            this.cellStyle.setTopBorderColor(color);
        }
        return this;
    }

    /**
     * 设置表格加粗
     *
     * @return
     */
    public ExcelStyle boldweight(Short bweight) {
        this.font.setBoldweight(bweight);
        return this;
    }

    /**
     * 设置字体
     *
     * @return
     */
    public ExcelStyle fondFamily(String fontName) {
        this.font.setFontName(fontName);
        return this;
    }

    /**
     * 设置字体
     *
     * @return
     */
    public ExcelStyle fondSize(Short size) {
        this.font.setFontHeightInPoints(size);
        return this;
    }

    /**
     * 设置加粗
     *
     * @return
     */
    public ExcelStyle fondWeight(Short size) {
        this.font.setBoldweight(size);
        return this;
    }

    /**
     * 设置字体颜色
     *
     * @return
     */
    public ExcelStyle fondColor(Short color) {
        this.font.setColor(color);
        return this;
    }

    /**
     * 设置字体高度
     *
     * @return
     */
    public ExcelStyle fondHeightInPoints(Short size) {
        this.font.setFontHeightInPoints(size);
        return this;
    }

    /**
     * 设置背景
     *
     * @param color       颜色
     * @param fillPattern 填充样式
     * @return
     */
    public ExcelStyle backGround(Short color, Short fillPattern) {
        this.cellStyle.setFillForegroundColor(color);// 设置背景色
        this.cellStyle.setFillPattern(fillPattern);
        return this;
    }

    /*******************************   默认样式  ***********************************/
    /**
     * title 默认样式
     * @return
     */
    public static CellStyle getCommTitle(Workbook workbook) {
        return createStyles(workbook).get("title");
    }
    /**
     * header 默认样式
     * @return
     */
    public static CellStyle getCommHeader(Workbook workbook) {
        return createStyles(workbook).get("header");
    }
    /**
     * data 默认样式
     * @return
     */
    public static CellStyle getCommData(Workbook workbook) {
        return createStyles(workbook).get("data");
    }
    /**
     * data1 默认样式
     * @return
     */
    public static CellStyle getCommData1(Workbook workbook) {
        return createStyles(workbook).get("data1");
    }
    /**
     * data2 默认样式
     * @return
     */
    public static CellStyle getCommData2(Workbook workbook) {
        return createStyles(workbook).get("data2");
    }
    /**
     * data3 默认样式
     * @return
     */
    public static CellStyle getCommData3(Workbook workbook) {
        return createStyles(workbook).get("data3");
    }

    /**
     * excel 样式
     *
     * @return
     */
    private static Map<String, CellStyle> createStyles(Workbook workbook) {
        Map<String, CellStyle> styles = new HashMap();
        CellStyle style = workbook.createCellStyle();
        style.setAlignment((short) 2);
        style.setVerticalAlignment((short) 1);
        Font titleFont = workbook.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBoldweight((short) 700);
        style.setFont(titleFont);
        styles.put("title", style);
        style = workbook.createCellStyle();
        style.setVerticalAlignment((short) 1);
        style.setBorderRight((short) 1);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft((short) 1);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop((short) 1);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom((short) 1);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = workbook.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);
        style = workbook.createCellStyle();
        style.cloneStyleFrom((CellStyle) styles.get("data"));
        style.setAlignment((short) 1);
        styles.put("data1", style);
        style = workbook.createCellStyle();
        style.cloneStyleFrom((CellStyle) styles.get("data"));
        style.setAlignment((short) 2);
        styles.put("data2", style);
        style = workbook.createCellStyle();
        style.cloneStyleFrom((CellStyle) styles.get("data"));
        style.setAlignment((short) 3);
        styles.put("data3", style);
        style = workbook.createCellStyle();
        style.cloneStyleFrom((CellStyle) styles.get("data"));
        style.setAlignment((short) 2);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern((short) 1);
        Font headerFont = workbook.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setBoldweight((short) 700);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);
        return styles;
    }
}
