package javaprg;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import javax.imageio.ImageIO;
	import com.google.zxing.BarcodeFormat;
	import com.google.zxing.MultiFormatWriter;
	import com.google.zxing.common.BitMatrix;

	public class Barcodeenator  {

	    public static void main(String[] args) {
	        String barcodeData = "123456789"; // Replace with your desired number
	        String filePath = "output.png"; // Output file path

	        int width = 300; // Width of the barcode
	        int height = 100; // Height of the barcode

	        try {
	            // Encode the data into a BitMatrix
	            BitMatrix bitMatrix = new MultiFormatWriter().encode(
	                barcodeData, BarcodeFormat.CODE_128, width, height,
	                // Encoding hints can be specified here, but are optional
	                null
	            );
	            // Convert the BitMatrix to a BufferedImage
	            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            for (int x = 0; x < width; x++) {
	                for (int y = 0; y < height; y++) {
	                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	                }
	            }
	            // Save the image to a file
	            File outputFile = new File(filePath);
	            ImageIO.write(image, "png", outputFile);

	            System.out.println("Barcode saved to: " + filePath);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


