package logica;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class LogicaPDF {

    // Instancia de la ControladoraLogica para acceder a la base de datos
    private ControladoraLogica controladora = null;

    public LogicaPDF() {
        controladora = new ControladoraLogica();
    }

    public void generarPDF() {
        // Obtenemos la lista de todas las mascotas desde la base de datos a través de la controladora
        List<Mascota> listaMascotas = controladora.traerMascotas();

        if (listaMascotas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos de mascotas para exportar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Document documento = new Document();

        try {
            // Se crea el documento PDF en la raíz del proyecto
            PdfWriter.getInstance(documento, new FileOutputStream("ReporteMascotas.pdf"));
            documento.open();

            // Título del PDF
            documento.add(new Paragraph("Reporte de Mascotas - Peluquería Canina\n\n"));
            
            // Creamos una tabla para los datos
            // La tabla tendrá 8 columnas, coincidiendo con los datos que queremos mostrar
            PdfPTable tabla = new PdfPTable(8);
            
            // Añadimos los encabezados de la tabla
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Raza");
            tabla.addCell("Color");
            tabla.addCell("Alérgico");
            tabla.addCell("Atención Especial");
            tabla.addCell("Dueño");
            tabla.addCell("Celular Dueño");

            // Rellenamos la tabla con los datos de cada mascota
            for (Mascota mascota : listaMascotas) {
                tabla.addCell(String.valueOf(mascota.getIdMascota()));
                tabla.addCell(mascota.getNombre());
                tabla.addCell(mascota.getRaza());
                tabla.addCell(mascota.getColor());
                tabla.addCell(mascota.getAlergico());
                
                
                tabla.addCell(mascota.getAtencionEspecial()); 
                
                // Obtenemos los datos del dueño desde el objeto Mascota
                if (mascota.getDuenio() != null) {
                    tabla.addCell(mascota.getDuenio().getNombreDuenio());
                    tabla.addCell(mascota.getDuenio().getNumCelular());
                } else {
                    tabla.addCell("Sin dueño");
                    tabla.addCell("N/A");
                }
            }

            // Añadimos la tabla al documento
            documento.add(tabla);

            // Cerramos el documento
            documento.close();

            JOptionPane.showMessageDialog(null, "PDF generado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al generar el PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}