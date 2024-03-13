package com.Backend.HarvestMaster.PaddyHealth.Controler;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
@CrossOrigin("http://localhost:5173/")
public class ImageController {

    public static byte[] optimizeImage(byte[] imageData, int maxWidth, int maxHeight, float quality) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
        BufferedImage image = ImageIO.read(inputStream);

        // Resize image if necessary
        if (image.getWidth() > maxWidth || image.getHeight() > maxHeight) {
            image = resizeImage(image, maxWidth, maxHeight);
        }

        // Compress image
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "JPEG", outputStream);

        return outputStream.toByteArray();
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int maxWidth, int maxHeight) {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        double aspectRatio = (double) width / (double) height;

        if (width > maxWidth) {
            width = maxWidth;
            height = (int) (width / aspectRatio);
        }

        if (height > maxHeight) {
            height = maxHeight;
            width = (int) (height * aspectRatio);
        }

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        resizedImage.createGraphics().drawImage(originalImage, 0, 0, width, height, null);

        return resizedImage;
    }
}
