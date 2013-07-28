package gridframework.model;

import java.awt.image.BufferedImage;

public class ImageCell extends Cell{
    private BufferedImage image;

    public ImageCell(BufferedImage image) {
        super();
        setInputCell(false);
        this.image = image;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public boolean setValue(char character) {
        return false;
    }

    @Override
    public void erase() {
        return;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
