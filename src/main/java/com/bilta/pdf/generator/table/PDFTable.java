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

        table.setTotalWidth(150);
        PdfPCell cell;
        for (int i = 0; i < 4 * 6; i++)
        {
            System.out.print("o"+i);
            Font font = new Font(Font.FontFamily.COURIER,16,Font.NORMAL,BaseColor.BLACK);

            cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.BLUE);
            cell.setBorder(Rectangle.BOX);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.addElement(new Paragraph(value,font));
            table.addCell(cell);
        }
        return  table;
    }


}
