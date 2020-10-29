package com.bilta.pdf.generator;
import com.bilta.pdf.generator.table.PDFTable;
import com.bilta.pdf.generator.table.chart.BarChart;
import com.itextpdf.awt.DefaultFontMapper;

import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;


public class PDFGenerator {


    public static int width = 300;
    public static int height = 300;
    static PdfWriter writer;
    static PdfTemplate template;
    public static void main( String[] args ) throws Exception
    {
        Document doc = new Document(PageSize.A4.rotate(), 36, 36, 36, 36);
        //Initialize writer
        writer = PdfWriter.getInstance(doc, new FileOutputStream(
                "hello.pdf"));

        doc.open();
        //Initialize document

        PdfContentByte contentByte = writer.getDirectContent();
        template = contentByte.createTemplate(width, height);
        Graphics2D graphics2d = template.createGraphics(width, height,
                new DefaultFontMapper());
        Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                height);

        (new BarChart()).generateBarChart().draw(graphics2d, rectangle2d);
        graphics2d.dispose();

        contentByte.addTemplate(template, 0, 0);

        template = contentByte.createTemplate(width, height);
        graphics2d = template.createGraphics(width, height,
                new DefaultFontMapper());
        rectangle2d = new Rectangle2D.Double(0, 0, width,
                height);

        (new BarChart()).generateBarChart().draw(graphics2d, rectangle2d);
        graphics2d.dispose();

        contentByte.addTemplate(template, 0, 600);

        template = contentByte.createTemplate(width, height);
        ((new PDFTable()).createTable("HI")).writeSelectedRows(0, -1, 110, 115, template);
        contentByte.addTemplate(template, 0, 500);

        //Close document
        doc.close();

    }



}


