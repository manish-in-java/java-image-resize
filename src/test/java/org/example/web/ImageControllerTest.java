package org.example.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration({ "classpath:springServiceContext.xml", "classpath:springWebContext.xml", "classpath:springWebMultipartContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ImageControllerTest
{
  @Autowired
  private ImageController imageController;

  private MockMvc mock;

  @Before
  public void setup()
  {
    mock = MockMvcBuilders.standaloneSetup(imageController).build();
  }

  @Test
  public void testImgScalrWithModel() throws Exception
  {
    mock.perform(get("/imgScalr")
                     .session((MockHttpSession) uploadLargeFile().andReturn().getRequest().getSession()))
        .andExpect(status().isOk())
        .andExpect(content().contentType("image/png"));
  }

  @Test
  public void testImgScalrWithoutModel() throws Exception
  {
    mock.perform(get("/imgScalr"))
        .andExpect(status().isOk())
        .andExpect(content().string(""));
  }

  @Test
  public void testJavaImageScalingWithModel() throws Exception
  {
    mock.perform(get("/javaImageScaling")
                     .session((MockHttpSession) uploadLargeFile().andReturn().getRequest().getSession()))
        .andExpect(status().isOk())
        .andExpect(content().contentType("image/png"));
  }

  @Test
  public void testJavaImageScalingWithoutModel() throws Exception
  {
    mock.perform(get("/javaImageScaling"))
        .andExpect(status().isOk())
        .andExpect(content().string(""));
  }

  @Test
  public void testThumbnailatorWithModel() throws Exception
  {
    mock.perform(get("/thumbnailator")
                     .session((MockHttpSession) uploadLargeFile().andReturn().getRequest().getSession()))
        .andExpect(status().isOk())
        .andExpect(content().contentType("image/png"));
  }

  @Test
  public void testThumbnailatorWithoutModel() throws Exception
  {
    mock.perform(get("/thumbnailator"))
        .andExpect(status().isOk())
        .andExpect(content().string(""));
  }

  @Test
  public void testResizeWithFile() throws Exception
  {
    uploadLargeFile()
        .andExpect(status().isOk())
        .andExpect(view().name("home"));
  }

  @Test
  public void testResizeWithoutFile() throws Exception
  {
    mock.perform(fileUpload("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home"));
  }

  @Test
  public void testUpload() throws Exception
  {
    mock.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("home"));
  }

  private ResultActions uploadLargeFile() throws Exception
  {
    return mock.perform(fileUpload("/")
                            .file(new MockMultipartFile("file", "1080x720.png", "image/png", getClass().getClassLoader().getResourceAsStream("1080x720.png"))));
  }
}
