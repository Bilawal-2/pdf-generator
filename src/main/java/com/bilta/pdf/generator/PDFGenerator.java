package com.bilta.pdf.generator;
import com.bilta.pdf.generator.table.PDFTable;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class PDFGenerator {

    public static final String path = "./target/bilCorp/tables/simple.pdf";

    public static void main( String[] args ) throws Exception
    {
        //Initialize writer
        PdfWriter writer = new PdfWriter("hello.pdf");

        //Initialize document
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        PDFTable pdfTable = new PDFTable();
        //Add paragraph to the document
        doc.add(pdfTable.createTable("Hello"));

        //Close document
        doc.close();

    }



}


