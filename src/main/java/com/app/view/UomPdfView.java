package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Paragraph p=new Paragraph("Unit of Measurement Data!...");
		document.add(p);
		response.addHeader("Content-Disposition","attachment;filename=UomPdfView.pdf");
		List<Uom> uo=(List<Uom>)model.get("uom");
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("Type");
		table.addCell("Model");
		table.addCell("Description");
		for(Uom um:uo) {
			table.addCell(um.getId().toString());
			table.addCell(um.getType());
			table.addCell(um.getModel());
			table.addCell(um.getDsc());
		}
		document.add(table);
	
	}
	
}
