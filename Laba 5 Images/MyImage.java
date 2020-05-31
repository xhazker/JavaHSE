import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyImage {
    private BufferedImage resized;
    private int width, height, imageSize;
    private String imagePath, name;
    private float similarity = 0;
    BasicFileAttributes attributes = null;

    public MyImage(String path, String name) {
        imagePath = path;
        this.name = name;
        resized = new BufferedImage(8, 8, 5);
        setAttributes();
        resizeImage(8, 8);
    }

    public int getPixel(int i, int j) {
        return resized.getRGB(i,j);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return imagePath+name;
    }

    public BufferedImage getImage() {
        return resized;
    }

    public void setSemilarity(float similarity) {
        this.similarity = similarity;
    }

    public float getSemilarity() {
        return similarity;
    }

    public long getSizeImage() {
        return attributes.size();
    }

    public String getDate() {
        long miliSec = attributes.creationTime().to(TimeUnit.MILLISECONDS);
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
        Date dateCreate = new Date(miliSec);
        return simple.format(dateCreate);
    }

    public long getDateInMillisec() {
        return attributes.creationTime().to(TimeUnit.MILLISECONDS);
    }

    public void setAttributes() {
        File originalImage = new File(imagePath + name);
        Path filePath = originalImage.toPath();
        try
        {
            attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        }
        catch (IOException exception)
        {
            System.out.println("Exception handled when trying to get file " +
                    "attributes: " + exception.getMessage());
        }
    }

    public void resizeImage (int width, int height) {
        try {
            File originalImage = new File(imagePath + name);
            BufferedImage original = ImageIO.read(originalImage);
            Graphics2D g2 = resized.createGraphics();
            g2.drawImage(original, 0, 0, width, height, null);
            g2.dispose();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


//    @Override
//    public int compare(MyImage image, MyImage image2) {
//        return  (int) (image2.getSemilarity() - image.getSemilarity());
//    }
}
