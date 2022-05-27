/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crearPDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.*;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class CrearPDF {

    public static void main(String[] args) {
        Document documento = new Document();
        try {
            FileOutputStream ficheroPdf = new FileOutputStream("fichero.pdf");
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            //Se abre el documento
            documento.open();
            //Añadir título
            Paragraph titulo = new Paragraph("Clasificacion ATP",
                    FontFactory.getFont("arial", // fuente
                            22, // tamaño
                            Font.ITALIC, // estilo
                            BaseColor.BLUE));
            titulo.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(titulo);
            //Añadir una línea en blanco
            documento.add(Chunk.NEWLINE);
            //Añadir párrafos
            documento.add(new Paragraph(
                    "El ranking ATP es una clasificación mundial de tenistas profesionales de la Asociación "
                    + "de Tenistas Profesionales. Se actualiza cada semana y abarca los resultados de las últimas 52 semanas. "
                    + "Se utiliza para seleccionar a los habilitados en cada torneo y a los cabezas de serie, el máximo galardón para "
                    + "cualquier tenista es ser considerado entre los 5 mejores del mundo en el ranking ATP."));          
            //Se cierra el documento
            documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
