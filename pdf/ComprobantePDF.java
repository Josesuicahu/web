
package pdf;
import com.google.gson.Gson;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import ventas.DetalleVenta;

/**
 *
 * @author PC-LUIS
 */
public class ComprobantePDF {
    
    public static String generarComprobante(String Path,String fecha, String horaInicio, String horaFin, String mesero, String mesa, double precio, double descuento, double precioFinal, String cliente, String documento, String tipo, ArrayList<DetalleVenta> detalles) throws IOException {
        Gson gson = new Gson();
        
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeName = DateTimeFormatter.ofPattern("HH_mm_ss");
        String nameFile = "Detalle_venta_" + now.format(timeName) + ".pdf";
        String destFile = Path + nameFile;
        
        File file = new File(destFile);     
        file.getParentFile().mkdirs();
        file.createNewFile();

        PdfDocument pdf = new PdfDocument(new PdfWriter(file));
        try (Document document = new Document(pdf)) {
            document.add(new Paragraph("\t\tLa Guerrilla Grill & Bar")
                    .setFontColor(new DeviceRgb(0, 102, 204)) // Color azul
                    .setFontSize(18)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER));
            
            Div infoDiv = new Div()
                    .setBorderTop(new SolidBorder(new DeviceRgb(0, 102, 204), 3))
                    .add(new Div()
                            .add(new Paragraph(tipo + " de venta"))
                            .add(new Paragraph("Cliente: " + cliente))
                            .add(new Paragraph("N° de documento: " + documento))
                    )
                    .add(new Div()
                            .add(new Paragraph("Fecha de venta: " + fecha))
                            .add(new Paragraph("Hora: " + horaFin))
                            .add(new Paragraph("Mesero: " + mesero))
                            .add(new Paragraph("Mesa: " + mesa))
                    );
            document.add(infoDiv);
            
            document.add(new Paragraph("\nDetalle de venta\n ")
                    .setFontColor(new DeviceRgb(0, 102, 204))
                    .setFontSize(16)
                    .setBold());
            
            Table table = new Table(3).useAllAvailableWidth();
            
            table.addCell("ID").setBold().setBackgroundColor(new DeviceRgb(0, 102, 204)).setFontColor(DeviceRgb.WHITE);
            table.addCell("Nombre").setBold().setBackgroundColor(new DeviceRgb(0, 102, 204)).setFontColor(DeviceRgb.WHITE);
            table.addCell("Precio").setBold().setBackgroundColor(new DeviceRgb(0, 102, 204)).setFontColor(DeviceRgb.WHITE);
            
            // Añadir filas de datos a la tabla
            for (ventas.DetalleVenta detalle : detalles) {
                table.addCell(String.valueOf(detalle.getIdDetalle()));
                table.addCell(detalle.getConsumo());
                table.addCell(String.valueOf(detalle.getPrecio()));
            }
            
            document.add(table);
            
            document.add(new Paragraph("\nPrecio: s/." + precio));
            document.add(new Paragraph("Descuento: " + descuento + "%"));
            document.add(new Paragraph("Precio Final: s/." + precioFinal));
        }

        return gson.toJson(nameFile);
    }
}
