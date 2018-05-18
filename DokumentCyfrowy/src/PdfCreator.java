
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;


/**
 * Klasa obs³uguj¹ca zapisywanie przepisów i list zakupów do pdf
 * @author Ma³gorzata Muszyñska
 *
 */
public class PdfCreator {

	/**
	 * Czcionka bazowa
	 */
	private static BaseFont helvetica;
	/**
	 * czcionka z polskimi znakami do tytu³u
	 */
	private Font polishFontTitle;
	/**
	 * czcionka z polskimi znakami do treœci standardowej
	 */
	private Font polishFontStandard;
	/**
	 * czcionka z polskimi znakami do treœci pomniejszonej
	 */
	private Font polishFontSmall;
	/**
	 * czcionka z polskimi znakami do treœci w tabeli
	 */
	private Font polishFontTable;
	/**
	 * czcionka z polskimi znakami do treœci w tabeli 2
	 */
	private Font polishFontTable2;
	/**
	 * czcionka z polskimi znakami do treœci pogrubionej
	 */
	private Font polishFontStandardB;
	/**
	 * czcionka z polskimi znakami do nag³ówka sekcji
	 */
	private Font polishFontSection;
	/**
	 * Tworzony dokument pdf
	 */
	private Document document;

	/**
	 * Konstruktor odpowiada za wszystkich utworzenie czcionek
	 */
	PdfCreator() {
		try {
			helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		polishFontTitle = new Font(helvetica, 16, Font.BOLD);
		polishFontStandard = new Font(helvetica, 11);
		polishFontTable = new Font(helvetica, 10);
		polishFontTable2 = new Font(helvetica, 9);
		polishFontSmall = new Font(helvetica, 8);
		polishFontStandardB = new Font(helvetica, 11, Font.BOLD);
		polishFontSection = new Font(helvetica, 13, Font.BOLD);

	}

	/**
	 * Metoda tworz¹ca dokument pdf z historia choroby
	 * @param dish Potrawa do zapisania
	 */
	public void createHistoriaChorobyDocument(TyphistoriaChoroby historiaChoroby, String filename, String wiek) {
		Rectangle pageSize = new Rectangle(PageSize.A5.rotate());
		document = new Document(pageSize);
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filename));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		document.open();
		document.newPage();
		addHeader(historiaChoroby.poradnia, String.valueOf(historiaChoroby.numerKarty), historiaChoroby.pacjent.dataRejestracji.toString().substring(0, 10), historiaChoroby.pacjent.nrKsiazeczkiZdrowia);
		String oddzialNfz;
		if (null == historiaChoroby.pacjent.ubezpieczenie.getUbezpieczonyStatus()) {
			oddzialNfz = "";
		} else oddzialNfz = String.valueOf(historiaChoroby.pacjent.ubezpieczenie.getUbezpieczonyStatus().oddzialNfz);
		addPatientInfo(historiaChoroby.pacjent.imie, historiaChoroby.pacjent.nazwisko, historiaChoroby.pacjent.plec, historiaChoroby.pacjent.dataUrodzenia.toString().substring(0, 10), historiaChoroby.pacjent.pesel.toString(), String.valueOf(wiek), historiaChoroby.pacjent.adres, oddzialNfz);
		PdfPTable bloodTable, insuranceTable;
		if (oddzialNfz == "") {
			insuranceTable = createInsuranceTable(historiaChoroby.pacjent.ubezpieczenie.getNieubezpieczonyStatus());
		} else 
		insuranceTable = createInsuranceTable(historiaChoroby.pacjent.ubezpieczenie.getUbezpieczonyStatus().value);
		
		if (null == historiaChoroby.pacjent.krew)
		{
			bloodTable = createBloodTable("", "");
		} else {
		bloodTable = createBloodTable(historiaChoroby.pacjent.krew.grupa, historiaChoroby.pacjent.krew.rh );
		}
		addTwoTablesInRow(insuranceTable,bloodTable);
		addIllnessTable(historiaChoroby.historia.getChoroba());
		document.close();
	}



	/**
	 * Metoda dodaj¹ca nag³ówek do dokumentu
	 * @param title Tytu³ nag³ówka
	 */
	private void addHeader(String poradnia, String numerKarty, String dataRejestracji, String numerKsiazeczki) {
		Paragraph p = new Paragraph("", polishFontStandard);
		Chunk glue = new Chunk(new VerticalPositionMark());
		p.add(new Chunk(glue));
		p.setAlignment(Element.ALIGN_CENTER);
		p.add(new Chunk("         "+"HISTORIA CHOROBY", polishFontTitle));
		p.add(new Chunk(glue));
		p.add(new Chunk("Numer karty:  "+numerKarty+"            "+"  ",polishFontSmall));
		
		Paragraph p1 = new Paragraph("Data zarejestr.   "+dataRejestracji, polishFontSmall);
		p1.setAlignment(Element.ALIGN_RIGHT);
		
		Paragraph p2 = new Paragraph("Piecz¹tka zak³adu", polishFontSmall);
		
		p2.add(new Chunk(glue));
		p2.add(new Chunk("PORADNI "+"  "+poradnia+"                         ",polishFontStandard));
		p2.add(new Chunk(glue));
		p2.add(new Chunk("Nr ks. zdrowia:  "+numerKsiazeczki+"    ",polishFontSmall));
		
		Paragraph p3 = new Paragraph("      "+"dzia³ A", polishFontSmall);
		p3.setAlignment(Element.ALIGN_LEFT);

		addEmptyLine(p3, 1);
		try {
			document.add(p);
			document.add(p1);
			document.add(p2);
			document.add(p3);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	private void addTwoTablesInRow(PdfPTable insuranceTable, PdfPTable bloodTable) {
		PdfPTable lineTable = new PdfPTable(2);
		lineTable.setTotalWidth(520);
		lineTable.setLockedWidth(true);
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);

		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		cell.addElement(insuranceTable);
		lineTable.addCell(cell);
		cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		cell.addElement(bloodTable);
		lineTable.addCell(cell);
		try {
			document.add(lineTable);
			document.add(new Paragraph(" "));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Metoda dodajaca do dokumentu tabele z wpisami dla przebytych chorób - historia chorob
	 */
	private void addIllnessTable(List<TypHistoria.Choroba> illnesses) {

		PdfPTable table = createHeaderOfIllnessTable();
		for (int i=0; i<illnesses.size(); i++) {
		PdfPCell cell = new PdfPCell(new Phrase(illnesses.get(i).data.toString(),polishFontStandard));
		cell.setBorderWidth(1.5f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(illnesses.get(i).wywiad,polishFontStandard));
		cell.setBorderWidth(1.5f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(illnesses.get(i).numerChoroby,polishFontStandard));
		cell.setBorderWidth(1.5f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(illnesses.get(i).pierwszeZachorowanie, polishFontStandard));
		cell.setBorderWidth(1.5f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		if (null == illnesses.get(i).niezdolnoscPraca.od) {
			cell = new PdfPCell(new Phrase(" "));
		}else {
		cell = new PdfPCell(new Phrase(illnesses.get(i).niezdolnoscPraca.od.toString()+" - "+
				illnesses.get(i).niezdolnoscPraca._do.toString(),polishFontStandard));
		}
		cell.setBorderWidth(1.5f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(cell);
		}
		PdfPCell cell = new PdfPCell(new Phrase(" "));
		cell.setBorderWidth(1.5f);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
		table.addCell(cell);
        try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private PdfPTable createHeaderOfIllnessTable() {
		PdfPTable table = new PdfPTable(5);
        table.setTotalWidth(520);
       try {
			table.setWidths(new float[] { 1.2f, 5, 1, 1.1f, 1.3f });
		} catch (DocumentException e) {
			e.printStackTrace();
		}
        table.setLockedWidth(true);
       // table.setHeaderRows(1);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Data",polishFontTable2));
        cell.setBorderWidth(1.5f);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Wywiad: objawy, rozpoznanie, leczenie\nuwagi i podpis lekarza",polishFontTable2));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(1.5f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Nr\nstatystyczny\nchoroby",polishFontTable2));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(1.5f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Czy pierwsze\nzachorowanie\nwpisaæ \"tak\"\nlub \"nie\"",polishFontTable2));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(1.5f);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Niezdolnoœæ\ndo pracy\nod - do",polishFontTable2));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setBorderWidth(1.5f);
        table.addCell(cell);
        return table;
	}
	
	/**
	 * Metoda dodajaca do dokumentu tabele z ewentualna informacja o grupie krwi
	 */
	private PdfPTable createBloodTable(String group, String rh) {
		PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(180);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(" "));
        cell.setBorderWidthBottom(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(group,polishFontStandard));
        cell.setBorderWidthBottom(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setRowspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(rh,polishFontStandard));

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidthBottom(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Grupa krwi",polishFontSmall));
        cell.setBorderWidthTop(0);
        cell.setBorderWidthBottom(0);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Rh",polishFontSmall));
        cell.setBorderWidthTop(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" "));
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthTop(0);
        cell.setBorderWidthRight(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" "));
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthRight(0);
        cell.setBorderWidthLeft(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" "));
        cell.setBorderWidthBottom(0);
        cell.setBorderWidthLeft(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Podpis lekarza",polishFontSmall));
        cell.setBorderWidthTop(0);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        table.addCell(cell);
return table;
	}
	
	
	/**
	 * Metoda dodajaca do dokumentu tabele z ubezpieczeniem
	 */
	private PdfPTable createInsuranceTable(String insuranceStatus) {
		
		PdfPTable table = new PdfPTable(4);
        table.setTotalWidth(240);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Ubezpieczony",polishFontTable));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Nieubezpieczony",polishFontTable));
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        Map<Integer, String> insuranceStatusSet = new HashMap<Integer,String>();
        insuranceStatusSet.put(0, "czynny");
        insuranceStatusSet.put(1, "bierny");
        insuranceStatusSet.put(2, "samop³ac¹cy");
        insuranceStatusSet.put(3, "leczony bezp³atnie");
        
        for (int i=0; i<insuranceStatusSet.size(); i++) {
        	cell = new PdfPCell(new Phrase(" "));
        if (insuranceStatus.equals(insuranceStatusSet.get(i))) {
        	cell = new PdfPCell(new Phrase("X"));
        } else {}
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderWidthBottom(0);
        table.addCell(cell);
        }
        
        String[] insuranceOptions = {"czynny","bierny","samo-\nplacacy","leczony\nbezplatnie"};
        
        for (int i=0; i<insuranceOptions.length; i++) {
        cell = new PdfPCell(new Paragraph(insuranceOptions[i],polishFontSmall));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.setBorderWidthTop(0);
       // cell.setRowspan(3);
        table.addCell(cell);
        }
return table;
        
	}

	/**
	 * Metoda dodaj¹ca do dokumentu informacje osobowe pacjenta
	 * @param name imie
	 * @param surname nazwisko pacjenta
	 * @param sex plec wyrazona M(êska) lub ¯(eñska)
	 * @param dateOfBirth data urodzenia w formacie rrrr-mm-dd
	 * @param pesel nr pesel pacjenta (11 cyfr)
	 */
	private void addPatientInfo(String name, String surname, String sex, String dateOfBirth, String pesel, String wiek, String adres, String oddzialNfz) {

		Chunk glue = new Chunk(new VerticalPositionMark());
		Chunk chunk1 = new Chunk("Nazwisko:   "+surname, polishFontStandard);
		Chunk chunk2 = new Chunk("Imie:   "+name, polishFontStandard);
		Chunk chunk3 = new Chunk("Plec:  "+sex, polishFontStandard);
		Chunk chunk4 = new Chunk("Data urodzenia:   "+dateOfBirth, polishFontStandard);
		Chunk chunk5 = new Chunk("PESEL   "+pesel+"   ", polishFontStandard);
		Chunk chunk6 = new Chunk("Wiek:  "+wiek, polishFontStandard);
		Chunk chunk7 = new Chunk("Adres:   "+adres, polishFontStandard);
		Chunk chunk8 = new Chunk("Oddzia³ NFZ:   "+oddzialNfz, polishFontStandard);
		Paragraph p1 = new Paragraph();
		p1.add(chunk1);
		p1.add(glue);
		p1.add(chunk2);
		p1.add(glue);
		p1.add(chunk3);
		addEmptyLine(p1, 1);
		Paragraph p2 = new Paragraph();
		p2.add(chunk4);
		p2.add(glue);
		p2.add(chunk5);
		p2.add(glue);
		p2.add(chunk6);
		addEmptyLine(p2, 1);
		Paragraph p3 = new Paragraph();
		p3.add(chunk7);
		p3.add(glue);
		p3.add(new Chunk(" "));
		p3.add(glue);
		p3.add(chunk8);
		addEmptyLine(p3, 1);
		try {
			document.add(p1);
			document.add(p2);
			document.add(p3);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		addEmptyLine(p2, 3);
	}


	/**
	 * Metoda dodaj¹ca do paragrafu pust¹ liniê
	 * @param paragraph Paragraf
	 * @param number iloœæ linii do dodania
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}