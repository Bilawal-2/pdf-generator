package com.bilta.pdf.generator;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class PDFGenerator {

    public static void main( String[] args ) throws Exception
    {
        //Initialize writer
        PdfWriter writer = new PdfWriter("hello.pdf");

        //Initialize document
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        //Add paragraph to the document
        doc.add(new Paragraph("Hello World!"));

        //Close document
        doc.close();

    }



}


