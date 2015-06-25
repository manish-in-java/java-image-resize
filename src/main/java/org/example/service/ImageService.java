package org.example.service;

import com.mortennobel.imagescaling.DimensionConstrain;
import com.mortennobel.imagescaling.ResampleOp;
import net.coobird.thumbnailator.Thumbnails;
import org.example.transfer.ImageResizeRequest;
import org.example.transfer.ImageResizeResponse;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageService
{
  private static final int        SIZE                       = 240;
  private static final ResampleOp JAVA_IMAGE_SCALING_SAMPLER = new ResampleOp(DimensionConstrain.createMaxDimension(SIZE, SIZE));

  public ImageResizeResponse resize(final ImageResizeRequest request) throws IOException
  {
    final ImageResizeResponse response = new ImageResizeResponse();

    response.setImageScalrImage(Scalr.resize(request.getImage(), SIZE, SIZE, Scalr.OP_ANTIALIAS));
    response.setJavaImageScalingImage(JAVA_IMAGE_SCALING_SAMPLER.filter(request.getImage(), null));
    response.setThumbnailatorImage(Thumbnails.of(request.getImage()).size(SIZE, SIZE).asBufferedImage());

    return response;
  }
}
