<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizzazione</title>

    <!-- Import CSS file -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/match.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/competition.css">

    <!-- import fontawesom -->
    <script src="https://kit.fontawesome.com/b38354e4de.js" crossorigin="anonymous"></script>

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
    <div class="container">
        <div class="row">
            <div class="col-12 col-lg-3 d-flex justify-content-center">
                <img class="img-fluid" src="${emblem}">
            </div>
            <div class="col-12 col-lg-9 row">
                <div class="col-12 col-lg-9 align-middle d-flex justify-content-center justify-content-lg-start text-center text-lg-start" style="line-height: 1.5;vertical-align: middle">
                    <p style="margin-top:6%; color: #113057"><a class="subtitle">Competizione</a><br>
                        <b class="title">${comp}</b>
                    </p>
                </div>
                <div class="row align-left text-center menu d-flex justify-content-center justify-content-lg-start">
                    <div class="col-12 col-lg-3 element"><a href="http://104.46.43.181:8080:8080/servlet_football/competition?competition=${competitioncode}">Informazioni</a></div>
                    <div class="col-12 col-lg-3 disable"><a href="http://104.46.43.181:8080/servlet_football/match?matchday=${currentMatchday}&season=${year}&competitioncode=${competitioncode}&competitions=${comp}&emblem=${emblem}">Partite</a></div>
                    <div class="col-12 col-lg-3 element"><a href="http://104.46.43.181:8080/servlet_football/standing?matchday=${matchday}&season=${season}&competitioncode=${competitioncode}&competitions=${comp}&emblem=${emblem}">Classifica</a></div>
                </div>
            </div>
        </div>
    </div>

    <div class="ms-5 me-5">
        <div class="row g-2 d-flex align-middle">
            <div class="col-7 text-center" id="title">
                Calendario e risultati
            </div>
            <div class="col-5 row d-flex justify-content-around align-bottom pt-4">
                    <div class="col-6 align-bottom row d-flex justify-content-center">
                        <div class="col-12 text-center" style="font-size: 1.3rem"><b>Giornata</b></div>
                        <select class="col-12 form-select form-select-sm w-auto" id="dropdown_matchday" name="dropdown_matchday" aria-label=".form-select-sm example">
                            <option value="38">38a giornata</option>
                            <option value="37">37a giornata</option>
                            <option value="36">36a giornata</option>
                            <option value="35">35a giornata</option>
                            <option value="34">34a giornata</option>
                            <option value="33">33a giornata</option>
                            <option value="32">32a giornata</option>
                            <option value="31">31a giornata</option>
                            <option value="30">30a giornata</option>
                            <option value="29">29a giornata</option>
                            <option value="28">28a giornata</option>
                            <option value="27">27a giornata</option>
                            <option value="26">26a giornata</option>
                            <option value="25">25a giornata</option>
                            <option value="24">24a giornata</option>
                            <option value="23">23a giornata</option>
                            <option value="22">22a giornata</option>
                            <option value="21">21a giornata</option>
                            <option value="20">20a giornata</option>
                            <option value="19">19a giornata</option>
                            <option value="18">18a giornata</option>
                            <option value="17">17a giornata</option>
                            <option value="16">16a giornata</option>
                            <option value="15">15a giornata</option>
                            <option value="14">14a giornata</option>
                            <option value="13">13a giornata</option>
                            <option value="12">12a giornata</option>
                            <option value="11">11a giornata</option>
                            <option value="10">10a giornata</option>
                            <option value="9">9a giornata</option>
                            <option value="8">8a giornata</option>
                            <option value="7">7a giornata</option>
                            <option value="6">6a giornata</option>
                            <option value="5">5a giornata</option>
                            <option value="4">4a giornata</option>
                            <option value="3">3a giornata</option>
                            <option value="2">2a giornata</option>
                            <option value="1">1a giornata</option>
                        </select>
                    </div>
                    <div class="col-6 align-bottom row d-flex justify-content-center">
                        <div class="col-12 text-center" style="font-size: 1.3rem"><b>Stagione</b></div>
                        <select class="col-12 form-select form-select-sm w-auto" id="dropdown_season" aria-label=".form-select-sm example">
                            <option value="2022">2022/2023</option>
                            <option value="2021">2021/2022</option>
                            <option value="2020">2020/2021</option>
                        </select>
                    </div>
            </div>
        </div>
        <div class="mt-5 pt-1 pb-1 align-items-center" id="head2head">
        <c:forEach items="${matches}" var="match">
            <div class="row pt-3 pb-3 border-bottom d-flex justify-content-beetween align-items-center align-middle">
                <div class="col-1 text-left" id="time">
                    <div>${match.round}<sup>a</sup>giornata</div>
                    <div>${match.date}</div>
                </div>
                <div class="col-9 d-flex justify-content-center align-middle" id="squadree">
                    <div class="col-4 text-end">
                        <a class="squadre" href="http://104.46.43.181:8080/servlet_football/team?name=${match.homeTeam}&crest=${match.homeTeamCrest}&competitioncode=${competitioncode}" id="squadre">
                                ${match.homeTeam}</a>&ensp;
                        <img src="${match.homeTeamCrest}" height="45" width="45">
                        &ensp;&ensp;${match.homeScore}
                    </div>
                    <div class="col-1 text-center" style="color: #2047e3; font-size: 1.4rem;">
                        VS
                    </div>
                    <div class="col-4 text-left squadre" id="squadree">
                            ${match.awayScore}&ensp;&ensp;
                        <img src="${match.awayTeamCrest}" height="45" width="45">&ensp;
                        <a class="squadre" href="http://104.46.43.181:8080/servlet_football/team?name=${match.awayTeamNoSpace}&crest=${match.awayTeamCrest}&competitioncode=${competitioncode}" id="squadre">
                            ${match.awayTeam}
                        </a>
                    </div>
                </div>
                <div class="col-1 text-end" ID="status">${match.status}</div>
            </div>
        </c:forEach>
            <br>
        </div>

        <div class="col-12 d-flex justify-content-center pt-1 pb-4">
            <a href="http://104.46.43.181:8080/servlet_football/home"> <i class="fa-solid fa-circle-arrow-left fa-4x" style="color: #5a5858;"></i></a>
        </div>
    </div>
</body>
</html>

<!-- <a href="http://104.46.43.181:8080/servlet_football/team?name=${match.awayTeam}&crest=${match.awayTeamCrest}" style="text-decoration: none; color: black;:hover{color: #1616e8}"> -->


<script type="text/javascript">
    $(document).ready(function() {
        // set select options with jquery and EL
        $("#dropdown_matchday").val("${matchday}");
        $("#dropdown_season").val("${season}");

        $("#dropdown_season").on('change', function (){
            var match = document.getElementById("dropdown_matchday").value;
            var season = document.getElementById("dropdown_season").value;
            var link = "http://104.46.43.181:8080/servlet_football/match?matchday="+ match +"&season="+ season +"&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}";

            document.open(link, "_self", "get");
        });

        $("#dropdown_matchday").on('change', function (){
            var match = document.getElementById("dropdown_matchday").value;
            var season = document.getElementById("dropdown_season").value;
            var link = "http://104.46.43.181:8080/servlet_football/match?matchday="+ match +"&season="+ season+"&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}";

            document.open(link, "_self", "get");
        });
    });
</script>