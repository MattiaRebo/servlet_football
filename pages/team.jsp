<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Classifica</title>

  <!-- import fontawesom -->
  <script src="https://kit.fontawesome.com/b38354e4de.js" crossorigin="anonymous"></script>
  <!-- Import CSS file -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/team.css">

  <!-- Import JQUERY -->
  <script
          src="https://code.jquery.com/jquery-3.6.4.js"
          integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
          crossorigin="anonymous">
  </script>

  <!-- import Bottstrap 5.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<!-- Navbar -->
<div class="container pt-3">
  <div class="row">
    <div class="col-12 col-lg-3 d-flex justify-content-center">
      <img class="img-fluid" src="${team.crest}">
    </div>
    <div class="col-12 col-lg-9 row">
      <div class="col-12 col-lg-9 align-middle d-flex justify-content-center text-center text-lg-start" style="line-height: 1.5;vertical-align: middle">
        <p style="margin-top:6%"><a class="subtitle">Team</a><br>
          <b class="title">${team.name}</b>
        </p>
      </div>
    </div>
  </div>

  <div class="container text-center pt-5" style="font-size: 1.5rem">
    <p><b>Regione: </b><i>${team.region}</i></p>
    <p><b>City: </b><i>${team.city}</i></p>
  </div>
  <div class="col-12 d-flex justify-content-center">
    <a href="http://localhost:8080/servlet_football/competition?competition=${competitioncode}"> <i class="fa-solid fa-circle-arrow-left fa-6x" style="color: #5a5858;"></i></a>
  </div>
 </div>
</body>

</html>

