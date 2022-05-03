package com.example.test;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class PDFGenerate {




    public static void main()
    {
        System.out.println("This creates a blank PDF");
        String fileName="SampleTextFile.pdf"; ///File name that is generated
        try
        {

            PDDocument doc=new PDDocument();
            doc.addPage(new PDPage()); ///Duplicate to make multiple pages in single document!
            doc.addPage(new PDPage());
            doc.save(fileName);
            doc.close();
            System.out.println("File has been created!");

        }

        catch (IOException  e)
        {
            throw new RuntimeException(e);
        }
    }

}