package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Conten-Disposition","attachment;filename=ShipmentTypeExcelView.xlsx");
		Sheet sheet=workbook.createSheet();
		sheetHead(sheet);
		List<ShipmentType> sh=(List<ShipmentType>)model.get("sht");
		sheetBody(sheet, sh);
		
	}

	private void sheetHead(Sheet sheet) {
		Row r=sheet.createRow(0);
		r.createCell(0).setCellValue("ShipmentId");
		r.createCell(1).setCellValue("ShipmentMode");
		r.createCell(2).setCellValue("ShipmentCode");
		r.createCell(3).setCellValue("EnableShipment");
		r.createCell(4).setCellValue("ShipmentGrade");
		r.createCell(5).setCellValue("Description");
	}

	private void sheetBody(Sheet sheet, List<ShipmentType> sh) {
		 int rowNum=1;
		 for(ShipmentType s:sh) {
			 Row r=sheet.createRow(rowNum++);
			 r.createCell(0).setCellValue(s.getId());
			 r.createCell(1).setCellValue(s.getMode());
			 r.createCell(2).setCellValue(s.getCode());
			 r.createCell(3).setCellValue(s.getEnabled());
			 r.createCell(4).setCellValue(s.getGrade());
			 r.createCell(5).setCellValue(s.getDsc());
	}
	}

}
