package com.netcracker.ca.service.reportsExport;

import com.netcracker.ca.model.reports.ProjectReport;
import com.netcracker.ca.model.reports.StudentReport;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr on 30.11.2016.
 */
public class StudentsListExcelView extends AbstractXlsxView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"StudentsReport.xlsx\"");

        List<StudentReport> studentReports = (List<StudentReport>) model.get("stRep");

        Sheet sheet = workbook.createSheet("Student Report");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("First Name");
        header.createCell(1).setCellValue("Last Name");
        header.createCell(2).setCellValue("Defense Feedback");
        header.createCell(3).setCellValue("General Interview");
        header.createCell(4).setCellValue("Technical Interview");
        header.createCell(5).setCellValue("Status");

        int rowCount = 1;
        for (StudentReport studentReport : studentReports){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(studentReport.getFirstName());
            courseRow.createCell(1).setCellValue(studentReport.getLastName());
            courseRow.createCell(2).setCellValue(studentReport.getDefense());
            courseRow.createCell(3).setCellValue(studentReport.getGeneralInt());
            courseRow.createCell(4).setCellValue(studentReport.getTechInt());
            courseRow.createCell(5).setCellValue(studentReport.getStatus());
        }

        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(HSSFColor.BLUE_GREY.index);
        cellStyle.setFont(font);
        cellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
        for (int i=0; i<=5; i++){
            header.getCell(i).setCellStyle(cellStyle);
            sheet.autoSizeColumn(i);
        }
    }
}
