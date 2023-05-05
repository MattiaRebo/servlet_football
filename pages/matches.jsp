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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/competition.css">

    <!-- Import JQUERY -->
    <script
            src="https://code.jquery.com/jquery-3.6.4.js"
            integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
            crossorigin="anonymous"></script>

    <!-- import Bottstrap 5.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-3">
                <img src="${emblem}" style="height: 80%; width: 80%">
            </div>
            <div class="col-9">
                <div class="col-9 align-middle" style="line-height: 1.5;vertical-align: middle">
                    <p style="margin-top:6%; color: #113057"><a class="subtitle">Competizione</a><br>
                        <b class="title">${comp}</b>
                    </p>
                </div>
                <div class="row align-left text-center menu">
                    <div class="col-2 element"><a href="http://localhost:8080/servlet_football/competition?competition=${competizione}">Informazioni</a></div>
                    <div class="col-2 disable"><a href="http://localhost:8080/servlet_football/match?matchday=${currentMatchday}&season=${year}&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}">Partite</a></div>
                    <div class="col-2 element"><a href="http://localhost:8080/servlet_football/standing?matchday=${matchday}&season=${season}&competitioncode=${competitioncode}&competitions=${competition}&emblem=${emblem}">Classifica</a></div>
                </div>
            </div>
        </div>
    </div>

    <div class="ms-5 me-5">
        <div class="row g-2 align-middle">
            <div class="col-7 text-center" id="title">
                Calendario e risultati
            </div>
            <div class="col-5 row d-flex justify-content-around align-bottom">
                    <div class="col-2 align-bottom">
                        <div>Giornata</div>
                        <select class="form-select form-select-sm w-auto" id="dropdown_matchday" name="dropdown_matchday" aria-label=".form-select-sm example">
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
                    <div class="col-3">
                        <div class="">Stagione</div>
                        <select class="form-select form-select-sm w-auto" id="dropdown_season" aria-label=".form-select-sm example">
                            <option value="2022">2022/2023</option>
                            <option value="2021">2021/2022</option>
                            <option value="2020">2020/2021</option>
                        </select>
                    </div>
            </div>
        </div>
        
        <div class="mt-5 pt-1 pb-1 align-items-center" id="head2head">
        <c:forEach items="${matches}" var="match">
            <div class="row pt-3 pb-3 border-bottom border-top d-flex justify-content-beetween align-items-center align-middle">
                <div class="col-1 text-left" id="time">
                    <div>${match.round}<sup>a</sup> GIORNATA</div>
                    <div>${match.date}</div>
                </div>
                <div class="col-9 d-flex justify-content-center align-middle" id="squadre">
                    <div class="col-4 text-end">
                            ${match.homeTeam}&ensp;
                        <img src="${match.homeTeamCrest}" height="25" width="25">
                        &ensp;&ensp;${match.homeScore}
                    </div>
                    <div class="col-1 text-center" style="color: #2047e3;">
                        VS
                    </div>
                    <div class="col-4 text-left">
                            ${match.awayScore}&ensp;&ensp;
                        <img src="${match.awayTeamCrest}" height="25" width="25">&ensp;${match.awayTeam}
                    </div>
                </div>
                <div class="col-1 text-end" ID="status">${match.status}</div>
            </div>
        </c:forEach>
            <br>
        </div>
    </div>
</body>
</html>


<script type="text/javascript">
    $(document).ready(function() {
        // set select options with jquery and EL
        $("#dropdown_matchday").val("${matchday}");
        $("#dropdown_season").val("${season}");

        $("#dropdown_season").on('change', function (){
            var match = document.getElementById("dropdown_matchday").value;
            var season = document.getElementById("dropdown_season").value;
            var link = "http://localhost:8080/servlet_football/match?matchday="+match+"&season="+season+"&competition=${competizione}&competitions=${comp}&emblem=${emblem}";

            document.open(link, "_self", "get");
        });

        $("#dropdown_matchday").on('change', function (){
            var match = document.getElementById("dropdown_matchday").value;
            var season = document.getElementById("dropdown_season").value;
            var link = "http://localhost:8080/servlet_football/match?matchday="+match+"&season="+season+"&competition=${competizione}&competitions=${comp}&emblem=${emblem}";

            document.open(link, "_self", "get");
        });
    });
</script>