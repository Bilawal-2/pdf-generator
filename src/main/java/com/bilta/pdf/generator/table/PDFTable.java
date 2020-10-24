package com.bilta.pdf.generator.table;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import java.io.IOException;

public class PDFTable {

    public Table createTable(String value) throws IOException {

        float[] columnWidths = {1,5,5};
        Table table = new Table(UnitValue.createPercentArray(columnWidths))
                .useAllAvailableWidth();
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        Cell cell = new Cell(1,3)
                .add(new Paragraph("This is a header"))
                .setFont(font)
                .setFontSize(13)
                .setBackgroundColor(DeviceGray.BLACK)
                .setTextAlignment(TextAlignment.CENTER);
        table.addHeaderCell(cell);

        for (int i = 0; i < 2; i++) {
            Cell[] headerFooter = new Cell[]{
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).
                            add(new Paragraph("#")),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).
                            add(new Paragraph("Key")),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).
                            add(new Paragraph("Value"))
            };
            for (Cell hfCell: headerFooter){
                if(i==0)
                    table.addHeaderCell(hfCell);
                else
                    table.addFooterCell(hfCell);
            }
        }

        for (int i = 0; i < 100; i++) {
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER)
                    .add(new Paragraph(String.valueOf(i + 1))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER)
                    .add(new Paragraph("Key"+(i + 1))));
            table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER)
                    .add(new Paragraph("Value" + (i + 1))));
        }

        return  table;
    }
}
