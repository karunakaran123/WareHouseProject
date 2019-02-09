package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition","attachment;filename=OrderMethod.pdf");
		
		Paragraph p=new Paragraph(" Order Method Data!!..");
		
		document.add(p);
		List<OrderMethod> or=(List<OrderMethod>)model.get("ord");
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("Code");
		t.addCell("Method");
		t.addCell("Accept");
		t.addCell("description");
		for(OrderMethod o:or) {
			t.addCell(o.getId().toString());
			t.addCell(o.getMode());
			t.addCell(o.getCode());
			t.addCell(o.getMethod());
			t.addCell(o.getAccept().toString());
			t.addCell(o.getDsc());
		}
		document.add(t);
	}

}
