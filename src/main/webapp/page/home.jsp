<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Image Resizer</title>
    <link href="<c:url value='/webjars/bootstrap/3.3.5/css/bootstrap.min.css' />" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <script src="<c:url value='/webjars/jquery/2.1.4/jquery.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/webjars/bootstrap-filestyle/1.1.2/bootstrap-filestyle.js' />" type="text/javascript"></script>
  </head>
  <body>
    <div class="container">
      <div class="page-header">
        <h1>Image Resizer</h1>
        <p>
          This sample application demonstrates resizing images using various methods available
          with Java.  Upload an image file using the form below to see various resized samples.
        </p>
        <form class="form-inline"
          enctype="multipart/form-data"
          id="resizeForm"
          method="POST">
          <div class="panel panel-default">
            <div class="panel-body">
              <div class="input-group">
                <input accept="image/*"
                  class="filestyle"
                  id="file"
                  name="file"
                  type="file"
                  data-buttonBefore="true" />
              </div>
              <button class="btn btn-primary">Resize</button>
            </div>
          </div>
        </form>
        <c:if test="${pageContext.request.method == 'POST'}">
          <div class="row">
            <div class="col-xs-3">
              <div class="thumbnail">
                <img src="<c:url value='/imgScalr' />" />
                <div class="caption">
                  <h3>ImgScalr</h3>
                  <p>
                    Generated using <a href="http://www.thebuzzmedia.com/software/imgscalr-java-image-scaling-library">ImgScalr</a>.
                  </p>
                </div>
              </div>
            </div>
            <div class="col-xs-3">
              <div class="thumbnail">
                <img src="<c:url value='/thumbnailator' />" />
                <div class="caption">
                  <h3>Thumbnailator</h3>
                  <p>
                    Generated using <a href="https://code.google.com/p/thumbnailator">Thumbnailator</a>.
                  </p>
                </div>
              </div>
            </div>
            <div class="col-xs-3">
              <div class="thumbnail">
                <img src="<c:url value='/javaImageScaling' />" />
                <div class="caption">
                  <h3>Java Image Scaling</h3>
                  <p>
                    Generated using <a href="https://code.google.com/p/java-image-scaling">Java Image Scaling</a>.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </c:if>
      </div>
    </div>
  </body>
</html>
