<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/homepage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body style="background-color: #f8f8f8">
    <div class="m-3">
        <div class="col-12 text-center" id="title">Competizioni in evidenza</div>
        <div class="row d-flex justify-content-around m-2">
            <a href="http://localhost:8080/servlet_football/competition?competition=SA" class="col-12 col-md-6 col-xl-3 link-none">
                <div class="competition col-12">
                    <div class="m-2 justify-content-center">
                        <div class="d-flex align-middle align-content-center">
                            <img class="img-fluid" src="https://oneftbl-cms.imgix.net/https%3A%2F%2Fimages.onefootball.com%2Ficons%2FleagueColoredCompetition%2F128%2F13.png?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=0&q=25&w=48&s=dadee12f2bb8d404d7e58f10fc2d8817" height="95" width="95">
                            <div class="col-7 ms-xl-3 align-content-center align-middle">
                                <div class="text-center col-12 align-middle comptext" style="">COMPETIZIONE</div>
                                <div class="text-center col-12 align-middle catext">Serie A</div>
                            </div>
                        </div>
                    </div>
                </div>
            </a>

            <a href="http://localhost:8080/servlet_football/competition?competition=PL" class="col-12 col-md-6 col-xl-3 link-none">
                <div class="competition col-12">
                    <div class="m-2 justify-content-center">
                        <div class="d-flex align-middle">
                            <img class="img-fluid" src="https://oneftbl-cms.imgix.net/https%3A%2F%2Fimages.onefootball.com%2Ficons%2FleagueColoredCompetition%2F128%2F9.png?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=0&q=25&w=48&s=d9f204c9bd3ec998bbeb7eeaac47b710" height="95" width="95">
                            <div class="d-block ms-xl-3 col-7">
                                <div class="align-middle text-center comptext" style="">COMPETIZIONE</div>
                                <div class="align-middle text-center catext">Premier League</div>
                            </div>
                        </div>
                    </div>
                </div>
            </a>

            <a href="http://localhost:8080/servlet_football/competition?competition=FL1" class="col-12 col-md-6 col-xl-3 link-none">
                <div class="competition col-12">
                    <div class="m-2 justify-content-center">
                        <div class="d-flex align-middle">
                            <img class="img-fluid" src=https://oneftbl-cms.imgix.net/https%3A%2F%2Fimages.onefootball.com%2Ficons%2FleagueColoredCompetition%2F128%2F23.png?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=0&q=25&w=48&s=b26f9c761c37650213e1a563fbdbb8ff" class="rounded" height="95" width="95">
                            <div class="d-block ms-xl-3 col-7">
                                <div class="align-middle text-center comptext" style="">COMPETIZIONE</div>
                                <div class="align-middle text-center catext">Ligue 1</div>
                            </div>
                        </div>
                    </div>
                </div>
            </a>

            <a href="http://localhost:8080/servlet_football/competition?competition=BL1" class="col-12 col-md-6 col-xl-3 link-none">
                <div class="competition col-12">
                    <div class="m-2 justify-content-center">
                        <div class="d-flex align-middle">
                            <img class="img-fluid" src=https://oneftbl-cms.imgix.net/https%3A%2F%2Fimages.onefootball.com%2Ficons%2FleagueColoredCompetition%2F128%2F1.png?auto=format%2Ccompress&crop=faces&dpr=2&fit=crop&h=0&q=25&w=48&s=51040edbbe59606d90cc109efe59c085" class="rounded" height="95" width="95">
                            <div class="d-block ms-xl-3 col-7">
                                <div class="align-middle text-center comptext" style="">COMPETIZIONE</div>
                                <div class="align-middle text-center catext">Bundesliga</div>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-12 text-center" id="title">Partite del giorno</div>
        <div class="m-3 d-flex justify-content-around row">
            <c:forEach items="${matches}" var="match">
                <div class="col-12 col-md-6 col-xl-4 p-3">
                    <div class="row match">
                        <div class="col-12 text-center comptext"> ${match.date} - ${match.competition}</div>
                        <div class="col-12">
                            <div class="col-12 team d-flex">
                                <div class="col-10 d-flex align-content-center align-middle">
                                    <img src="${match.homeTeamCrest}" style="width: 30px; height: 30px;"> &ensp; <div class="text-center">${match.homeTeam}</div>
                                </div>
                                <div class="col-2 text-end">${match.homeScore}</div>
                            </div>
                            <div class="col-12 text-center align-content-center align-middle" style="vertical-align: middle">
                                <c:set var="test" value="${match.status}"/>
                                <div><div style="background-color: white; font-family: Switzer, serif; font-weight: bold; color: #196A2B; padding-bottom: 0">${match.status}</div></div>
                            </div>
                            <div class="col-12 team d-flex">
                                <div class="col-10 d-flex align-content-center align-middle">
                                    <img src="${match.awayTeamCrest}" style="width: 30px; height: 30px;"> &ensp; <div class="text-center">${match.awayTeam}</div>
                                </div>
                                <div class="col-2 text-end">${match.awayScore}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>


</body>
</html>