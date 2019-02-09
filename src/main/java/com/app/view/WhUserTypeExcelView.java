package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=WhUserExcelView.xlsx");
		
		Sheet sheet=workbook.createSheet("whr");
		List<WhUserType> wr=(List<WhUserType>)model.get("whr");
		sheetBody(sheet,wr);
		setHead(sheet);
		
	}

	
	private void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("UserId");
		r.createCell(1).setCellValue("UserType");
		r.createCell(2).setCellValue("UserCode");
		r.createCell(3).setCellValue("UserFor");
		r.createCell(4).setCellValue("UserEmail");
		r.createCell(5).setCellValue("UserContact");
		r.createCell(6).setCellValue("UserIDType");
		r.createCell(7).setCellValue("UserIfOther");
		r.createCell(8).setCellValue("IdNumber");

	}
	private void sheetBody(Sheet sheet, List<WhUserType> wr) {
			int rowNum=1;
			
			for(WhUserType w:wr) {
				Row r=sheet.createRow(rowNum++);
				r.createCell(0).setCellValue(w.getId());
				r.createCell(1).setCellValue(w.getType());
				r.createCell(2).setCellValue(w.getCode());
				r.createCell(3).setCellValue(w.getForType());
				r.createCell(4).setCellValue(w.getEmail());
				r.createCell(5).setCellValue(w.getContact());
				r.createCell(6).setCellValue(w.getIdType());
				r.createCell(7).setCellValue(w.getIfOther());
				r.createCell(8).setCellValue(w.getIdNum());
			}
		
	}


}
