package org.example.transfer;

import java.awt.image.BufferedImage;

public class ImageResizeResponse
{
  private BufferedImage imageScalrImage;
  private BufferedImage javaImageScalingImage;
  private BufferedImage thumbnailatorImage;

  public final BufferedImage getImageScalrImage()
  {
    return imageScalrImage;
  }

  public final BufferedImage getJavaImageScalingImage()
  {
    return javaImageScalingImage;
  }

  public final BufferedImage getThumbnailatorImage()
  {
    return thumbnailatorImage;
  }

  public final void setImageScalrImage(final BufferedImage image)
  {
    imageScalrImage = image;
  }

  public final void setJavaImageScalingImage(final BufferedImage image)
  {
    javaImageScalingImage = image;
  }

  public final void setThumbnailatorImage(final BufferedImage image)
  {
    thumbnailatorImage = image;
  }
}
