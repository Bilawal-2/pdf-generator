package com.bilta.pdf.generator.table;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;

public class PDFTable {

    public PdfPTable createTable(String value)  {

        PdfPTable table = new PdfPTable(4);
        Font font = new Font(Font.FontFamily.COURIER,16,Font.NORMAL,BaseColor.BLACK);
        table.setTotalWidth(200);
        PdfPCell cell;


        // S.No/ BANK /Branch/Load/ EMS-ID/ /EMS Online Operation (Hours)/ /Load shedding Event Count/ /Load Shedding Hours/ /Anomalies Count/
        // 6 Month PWR(KW) consumed/ /Health/ /Load Connected /Max PWR(Kw) during (Outage)/ /Max AMP (Outage)/ /Min Battery Voltage (Outage)/

        cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
            cell.setBorder(Rectangle.BOX);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.addElement(new Phrase(value,font));
        table.addCell(cell);

        for (int i = 0; i < 4 * 6; i++)
        {
            System.out.print("o"+i);

            cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.BLUE);
//            cell.setBorder(Rectangle.BOX);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.addElement(new Paragraph(value,font));
            table.addCell(cell);
        }
        return  table;
    }


}
