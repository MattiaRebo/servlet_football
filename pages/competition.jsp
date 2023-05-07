<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Classifica</title>
    <!-- Import CSS file -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/competition.css">

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
    <div class="container pt-3 ">
        <div class="row">
            <div class="col-12 col-lg-3 d-flex justify-content-center">
                <img class="img-fluid" src="${comp.emblem}">
            </div>
            <div class="col-12 col-lg-9">
                <div class="col-12 col-lg-9 align-middle d-flex justify-content-center justify-content-lg-start text-center text-lg-start" style="line-height: 1.5;vertical-align: middle">
                    <p style="margin-top:6%"><a class="subtitle">Competizione</a><br>
                        <b class="title">${comp.competition}</b>
                    </p>
                </div>
                <div class="row align-left text-center menu d-flex justify-content-center justify-content-lg-start">
                    <div class="col-2 disable"><a href="">Informazioni</a></div>
                    <div class="col-2 element"><a href="http://localhost:8080/servlet_football/match?matchday=${comp.currentMatchday}&season=${comp.year}&competitioncode=${comp.competitioncode}&competitions=${comp.competition}&emblem=${comp.emblem}">Partite</a></div>
                    <div class="col-2 element"><a href="http://localhost:8080/servlet_football/standing?matchday=${comp.currentMatchday}&season=${comp.year}&competitioncode=${comp.competitioncode}&competitions=${comp.competition}&emblem=${comp.emblem}">Classifica</a></div>
                </div>
            </div>
        </div>

        <div class="container text-center pt-5" style="font-size: 1.5rem">
            <p><b>Nazione: </b><i>${comp.area}</i></p>
            <p><b>Nome della competizione: </b><i>${comp.competition}</i></p>
            <p><b>Giornata di campionato corrente: </b><i>${comp.currentMatchday}</i></p>
            <p><b>Stagione: </b><i>${comp.year}</i></p>
            <p><b>Data di inizio: </b><i>${comp.startDate}</i></p>
            <p><b>Data fine: </b><i>${comp.endDate}</i></p>
        </div>
    </div>
</body>

</html>

