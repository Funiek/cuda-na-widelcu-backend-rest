package pl.ds360.cudanawidelcubackendrest.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import pl.ds360.cudanawidelcubackendrest.interfaces.FileService;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class FileServiceImpl implements FileService {

    @PostConstruct
    private void init() {

    }
    @Override
    public byte[] downloadImage(String name) {
        try {
            File image = new File(this.getClass().getClassLoader().getResource("data\\" + name + ".jpeg").getFile());
            return Files.readAllBytes(image.toPath());
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public byte[] downloadRecipeProductsPdf(String recipeName, String products) throws IOException {
        Path pdfPath = Paths.get("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");
        File f = new File("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");

        if(f.exists())
            return Files.readAllBytes(pdfPath);

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Krzysiek\\Documents\\CudaNaWidelcu\\" + recipeName + ".pdf");
            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, fos);
            doc.open();

            doc.add(new Paragraph(recipeName + " - składniki:"));

            for(String product: products.split(";")) {
                doc.add(new Paragraph(product));
            }

            doc.close();
            fos.close();
            writer.close();
        } catch (DocumentException ex) {
            Logger.getLogger(FileServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return Files.readAllBytes(pdfPath);
    }
}
