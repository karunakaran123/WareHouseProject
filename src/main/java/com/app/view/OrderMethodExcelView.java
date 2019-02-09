package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=OrderMethod.xlsx");

		Sheet sheet=workbook.createSheet("ord");
		setHead(sheet);
		List<OrderMethod> or=(List<OrderMethod>)model.get("ord");
		setBody(sheet,or);
	}

	private void setHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("Mode");
		r.createCell(2).setCellValue("Code");
		r.createCell(3).setCellValue("Method");
		r.createCell(4).setCellValue("Accept");
		r.createCell(5).setCellValue("description");
	}
	private void setBody(Sheet sheet, List<OrderMethod> or) {
		int rowNum=1;
		for(OrderMethod u:or) {
			Row r=sheet.createRow(rowNum++);
			r.createCell(0).setCellValue(u.getId().toString());
			r.createCell(1).setCellValue(u.getMode());
			r.createCell(2).setCellValue(u.getCode());
			r.createCell(3).setCellValue(u.getMethod());
			r.createCell(4).setCellValue(u.getAccept().toString());
			r.createCell(5).setCellValue(u.getDsc());
		}

	}

}
