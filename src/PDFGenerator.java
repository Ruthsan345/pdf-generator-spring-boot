import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class PDFGenerator {


     void generateBill(boolean wholesalerOrRetailer,int clientId,String clientName ,Product pro,int quantity, int billAmount, int discountPercentage,float gstAmount, float grandBillAmount) throws IOException {
        try {
        Document my_pdf_report = new Document();

        UUID randomUUID = UUID.randomUUID();

        if(wholesalerOrRetailer) {
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("./wholesaler_purchase_pdfs/"+clientId+"_"+randomUUID.toString().replaceAll("_", "")+".pdf"));
            }else{
                PdfWriter.getInstance(my_pdf_report, new FileOutputStream("./retailer_purchase_pdfs/"+clientId+"_"+randomUUID.toString().replaceAll("_", "")+".pdf"));
            }
        my_pdf_report.open();
        PdfPTable my_report_table = new PdfPTable(2);
        PdfPCell table_cell;
        Paragraph preface = new Paragraph();
        Paragraph preface1 = new Paragraph();
        preface.setSpacingAfter(4);
        preface.setSpacingBefore(1);
        preface.setIndentationLeft(200);
        preface.setIndentationRight(0);
        preface.setAlignment(Element.ALIGN_CENTER);
        preface.add(new Paragraph("QUINBAY - BLIBLI.COM\n"));
        preface1.setIndentationLeft(170);
        // preface1.setSpacingBefore(10);
            if(wholesalerOrRetailer) {
                preface1.add(new Paragraph("Product Purchase Infomartion For Wholesaler"));
            }else{
                preface1.add(new Paragraph("Product Purchase Infomartion for Retailer"));
                // addEmptyLine(preface, 2);
            }
        preface1.setSpacingAfter(25);
            my_pdf_report.add(preface);
            my_pdf_report.add(preface1);


            my_report_table.setSpacingAfter(10);
            my_report_table.setSpacingBefore(4);
            my_report_table.getRowHeight(10);

            table_cell=new PdfPCell(new Phrase("CLIENT ID :"));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Integer.toString(clientId)));
            my_report_table.addCell(table_cell);


            table_cell=new PdfPCell(new Phrase("CLIENT NAME:"));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(clientName));
            my_report_table.addCell(table_cell);


            table_cell=new PdfPCell(new Phrase("PRODUCT ID:"));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Integer.toString(pro.proId)));
            my_report_table.addCell(table_cell);


            table_cell=new PdfPCell(new Phrase("PRODUCT NAME:"));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(pro.proName));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("QUANTITY"));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Integer.toString(quantity)));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("BILL AMOUNT "));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Integer.toString(billAmount)));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("DISCOUNT PERCENTAGE "));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Integer.toString(discountPercentage)+"%"));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("GST PERCENTAGE: "));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase("18%"));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("GST AMOUNT: "));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Float.toString(gstAmount)));
            my_report_table.addCell(table_cell);

            table_cell=new PdfPCell(new Phrase("Grand Total Amount: "));
            my_report_table.addCell(table_cell);
            table_cell=new PdfPCell(new Phrase(Float.toString(grandBillAmount)));
            my_report_table.addCell(table_cell);


            Paragraph preface2 = new Paragraph();
            Paragraph preface3 = new Paragraph();
            preface2.setSpacingAfter(4);
            preface2.setSpacingBefore(1);
            preface2.setIndentationLeft(200);
            preface2.setIndentationRight(0);
            preface2.setSpacingBefore(80);
            preface2.setAlignment(400);
            preface2.setAlignment(Element.ALIGN_BOTTOM);
//            preface2.add(new Paragraph("*THIS IS AN AUTOMATICALLY GENRATED FORM THIS DOESNOT REQUIRE SIGNATURE."));
            preface3.setIndentationLeft(60);
            preface3.setIndentationRight(0);
            preface3.setSpacingBefore(30);
            preface3.add(new Paragraph(" THANKS FOR PURCHASING...KINDLY VISIT US AGAIN!"));
//            preface3.add(new Paragraph("(Station House Officer)"));
//            /* Attach report table to PDF */
            my_pdf_report.add(my_report_table);
            my_pdf_report.add(preface3);
            my_pdf_report.add(preface2);
            my_pdf_report.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
