package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;



public class UomExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("Content-Disposition", "attachment;filename=UomEXcelView.xlsx");
		Sheet sheet=workbook.createSheet("uom");
		setHead(sheet);
		List<Uom> um=(List<Uom>)model.get("uom");
		setBody(sheet,um);
	}
	
	private void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("Type");
		r.createCell(2).setCellValue("Model");
		r.createCell(3).setCellValue("Description");
		
	}
	
	private void setBody(Sheet sheet, List<Uom> um) {
		int rowNum=1;
		for(Uom u:um) {
			Row r=sheet.createRow(rowNum++);
			r.createCell(0).setCellValue(u.getId());
			r.createCell(1).setCellValue(u.getType());
			r.createCell(2).setCellValue(u.getModel());
			r.createCell(3).setCellValue(u.getDsc());	
		}
		
	}
   
}
