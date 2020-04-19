package com.amsidh.views;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.amsidh.domain.SpecialDeal;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class HomePagePdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Paragraph header = new Paragraph(new Chunk(
				"FlightSearch Special Deals. ", FontFactory.getFont(
						FontFactory.HELVETICA, 24)));
		document.add(header);
		List<SpecialDeal> specials = (List<SpecialDeal>) model.get("specials");
		for (SpecialDeal deal : specials) {
			document.add(new Paragraph(deal.getDepartFrom().getName() + " - "
					+ deal.getArriveAt().getName() + " from $" + deal.getCost()));
		}
	}

}