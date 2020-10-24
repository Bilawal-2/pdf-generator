package com.bilta.pdf.generator.table;

import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class PDFTable {

    public Table createTable(String value){

        Table table = new Table(UnitValue.createPercentArray(8))
                .useAllAvailableWidth();

        for (int i = 0; i < 16; i++)
            table.addCell(value);

        return  table;
    }
}
