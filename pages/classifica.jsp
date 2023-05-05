<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
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

    <title>Classifica</title>
</head>
<body>
<!-- Navbar -->
<div class="container">
    <div class="row">
        <div class="col-3">
            <img src="${emblem}" style="border-radius: 50%; height: 100%; width: 100%">
        </div>
        <div class="col-9">
            <div class="col-9 align-middle" style="line-height: 1.5;vertical-align: middle">
                <p style="margin-top:6%"><a class="subtitle">Competizione</a><br>
                    <b class="title">${comp}</b>
                </p>
            </div>
            <div class="row align-left text-center menu">
                <div class="col-2 element"><a href="http://localhost:8080/servlet_football/competition?competition=${competitioncode}">Informazioni</a></div>
                <div class="col-2 element"><a href="http://localhost:8080/servlet_football/match?matchday=${matchday}&season=${season}&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}">Partite</a></div>
                <div class="col-2 disable"><a href="http://localhost:8080/servlet_football/standing?matchday=${matchday}&season=${season}&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}">Classifica</a></div>
            </div>
        </div>
    </div>



    <div class="container mt-5">
        <div class="row">
            <div class="col-7"></div>
            <div class="col-3 d-flex justify-content-around">
                <div class="text-center justify-content-around" style="width: 50px">G</div>
                <div class="text-center justify-content-around" style="width: 50px">V</div>
                <div class="text-center justify-content-around" style="width: 50px">N</div>
                <div class="text-center justify-content-around" style="width: 50px">GF</div>
                <div class="text-center justify-content-around" style="width: 50px">GS</div>
                <div class="text-center justify-content-around" style="width: 50px">PTS</div>
            </div>
        </div>

        <c:forEach items="${classifica}" var="squadra">
            <div class="row">
                <div class="col-4">${squadra.position} <img src="${squadra.crest}" height="25" width="25">${squadra.name}</div>
                <div class="col-3"></div>
                <div class="col-3 d-flex justify-content-around">
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.matchPlayed}</div>
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.won}</div>
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.goalFor}</div>
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.goalsAgainst}</div>
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.goalsAgainst}</div>
                    <div class="text-center justify-content-around" style="width: 50px">${squadra.point}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
