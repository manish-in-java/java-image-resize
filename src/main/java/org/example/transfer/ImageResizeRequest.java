package org.example.transfer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageResizeRequest
{
  private BufferedImage image;

  public ImageResizeRequest(final InputStream stream) throws IOException
  {
    image = ImageIO.read(stream);
  }

  public BufferedImage getImage()
  {
    return image;
  }
}
