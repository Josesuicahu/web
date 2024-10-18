/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import com.google.gson.Gson;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import ventas.DetalleVenta;

/**
 *
 * @author Jorge
 */
public class constructorPDF {

    public static String crearPDF(String path,String fecha, String horaInicio, String horaFin, String mesero, String mesa, double precio, double descuento, double precioFinal, String cliente, String documento, String tipo, ArrayList<DetalleVenta> detalles) throws IOException {
        Gson gson = new Gson();
//        nombre y destino
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateName = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        DateTimeFormatter timeName = DateTimeFormatter.ofPattern("HH_mm_ss");
        String nameFile = "Detalle_venta_" + now.format(dateName) + now.format(timeName) + ".pdf";
        String dest_file = path + nameFile;
        
        File file = new File(dest_file);     
        file.getParentFile().mkdirs();
        file.createNewFile();
        
        PdfWriter pdfwrite = new PdfWriter(file);
        
        PdfDocument pdf = new PdfDocument(pdfwrite);
        // Información adicional
        try (Document document = new Document(pdf)) {
            
            // Información adicional
            document.add(new Paragraph("\t\tLa Guerrilla Grill & Bar")
                    .setFontColor(new DeviceRgb(0, 102, 204)) // Color azul
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER));
            
            Div infoDiv = new Div()
                    .setBorderTop(new SolidBorder(new DeviceRgb(0, 102, 204), 3)) // Línea superior de color azul
                    .add(new Div()
                            .add(new Paragraph(tipo + " de venta"))
                            .add(new Paragraph("Cliente: " + cliente))
                            .add(new Paragraph("N de documento: " + documento))
                    )
                    .add(new Div()
                            .add(new Paragraph("Fecha de venta: " + fecha))
                            .add(new Paragraph("Hora: " + horaFin))
                            .add(new Paragraph("Encargado de venta: " + mesero))
                    );
            document.add(infoDiv);
            
            document.add(new Paragraph("\nDetalle de venta\n ")
                    .setFontColor(new DeviceRgb(0, 102, 204)) // Color azul
                    .setFontSize(16)
                    .setBold());
            
            // Crear una tabla
            Table table = new Table(3).useAllAvailableWidth();
            
            // Añadir encabezados de la tabla
            table.addCell("ID").setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
            table.addCell("Nombre").setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
            table.addCell("Precio").setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
            
            // Añadir filas de datos a la tabla
            for (DetalleVenta pedido : detalles) {
                table.addCell(String.valueOf(pedido.getIdDetalle())).setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
                table.addCell(pedido.getConsumo()).setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
                table.addCell(String.valueOf(pedido.getPrecio())).setBorder(new SolidBorder(new DeviceRgb(0, 102, 204), 1));
            }
            
            // Añadir la tabla al documento
            Div centeredTable = new Div().add(table).setTextAlignment(TextAlignment.CENTER);
            document.add(centeredTable);
            
            double descTMP = precio * descuento / 100;
            document.add(new Paragraph("\nPrecio: s/." + precio));
            document.add(new Paragraph("Descuento: s/." + descTMP));
            document.add(new Paragraph("Precio Final: s/." + precioFinal));
        }

        return gson.toJson(nameFile);
    }
}
