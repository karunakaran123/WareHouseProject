package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("Content-Disposition","attachment;filename=WhUserTypePdfView.pdf");
		
		Paragraph p=new Paragraph("WhUserType PDf Data ");
		document.add(p);
		
		List<WhUserType> wh=(List<WhUserType>)model.get("whr");
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");
		t.addCell("UserType");
		t.addCell("UserCode");
		t.addCell("Userfor");
		t.addCell("UserEmail");
		t.addCell("UserContact");
		t.addCell("IdType");
		t.addCell("IfOther");
		t.addCell("IdNumber");
		for(WhUserType w:wh) {
			t.addCell(w.getId().toString());
			t.addCell(w.getType());
			t.addCell(w.getCode());
			t.addCell(w.getForType());
			t.addCell(w.getEmail());
			t.addCell(w.getContact());
			t.addCell(w.getIdType());
			t.addCell(w.getIfOther());
			t.addCell(w.getIdNum());
		}
		document.add(t);
	}

}
