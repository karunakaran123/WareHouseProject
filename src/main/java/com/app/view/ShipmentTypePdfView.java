package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=ShipmentTypePDfView.pdf");
		
		Paragraph p=new Paragraph("ShipmentType Pdf Data!...");
		document.add(p);
		List<ShipmentType> sht=(List<ShipmentType>)model.get("shtp");
		PdfPTable t=new PdfPTable(6);
		
		t.addCell("ShipmentId");
		t.addCell("ShipmentMode");
		t.addCell("ShipmentCode");
		t.addCell("EnableShipment");
		t.addCell("ShipmentGrade");
		t.addCell("Description");
		for(ShipmentType s:sht) {
			t.addCell(s.getId().toString());
			t.addCell(s.getMode());
			t.addCell(s.getCode());
			t.addCell(s.getEnabled());
			t.addCell(s.getGrade());
			t.addCell(s.getDsc());
		}
		document.add(t);
	
	}

}
