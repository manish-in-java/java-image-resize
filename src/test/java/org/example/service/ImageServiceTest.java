package org.example.service;

import org.example.transfer.ImageResizeRequest;
import org.example.transfer.ImageResizeResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

@ContextConfiguration("classpath:springServiceContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageServiceTest
{
  @Autowired
  private ImageService service;

  @Test
  public void testResizeWithLargeImage() throws IOException
  {
    testResizeImage(1080, 720, 240, 160);
  }

  @Test
  public void testResizeWithMediumImage() throws IOException
  {
    testResizeImage(540, 360, 240, 160);
  }

  @Test
  public void testResizeWithNormalImage() throws IOException
  {
    testResizeImage(270, 180, 240, 160);
  }

  @Test
  public void testResizeWithSmallImage() throws IOException
  {
    testResizeImage(135, 90, 240, 160);
  }

  private void testResizeImage(final int imageWidth, final int imageHeight, final int expectedWidth, final int expectedHeight) throws IOException
  {
    final ImageResizeResponse response = service.resize(new ImageResizeRequest(getImageStream(String.format("%dx%d.png", imageWidth, imageHeight))));

    Assert.assertNotNull(response);

    Assert.assertNotNull(response.getImageScalrImage());
    Assert.assertEquals(expectedHeight, response.getImageScalrImage().getHeight());
    Assert.assertEquals(expectedWidth, response.getImageScalrImage().getWidth());

    Assert.assertNotNull(response.getJavaImageScalingImage());
    Assert.assertEquals(expectedHeight, response.getJavaImageScalingImage().getHeight());
    Assert.assertEquals(expectedWidth, response.getJavaImageScalingImage().getWidth());

    Assert.assertNotNull(response.getThumbnailatorImage());
    Assert.assertEquals(expectedHeight, response.getThumbnailatorImage().getHeight());
    Assert.assertEquals(expectedWidth, response.getThumbnailatorImage().getWidth());
  }

  private InputStream getImageStream(final String imageFileName)
  {
    return getClass().getClassLoader().getResourceAsStream(imageFileName);
  }
}
