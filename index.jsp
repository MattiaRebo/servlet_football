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
    <div class="m-5">
        <div class="row g-2">
            <div class="col-7 text-center" id="title">
                Calendario e risultati
            </div>
            <div class="col-5">
                <div class="row justify-content-around">
                    <div class="col-2">
                        <div>Giornata</div>
                        <select class="form-select form-select-sm w-auto" id="dropdown_matchday" aria-label=".form-select-sm example">
                            <option value="38">38<sup>a</sup> giornata</option>
                            <option value="37">37<sup>a</sup> giornata</option>
                            <option value="36">36<sup>a</sup> giornata</option>
                            <option value="35">35<sup>a</sup> giornata</option>
                            <option value="34">34<sup>a</sup> giornata</option>
                            <option value="33">33<sup>a</sup> giornata</option>
                            <option value="32">32<sup>a</sup> giornata</option>
                            <option value="31">31<sup>a</sup> giornata</option>
                            <option value="30">30<sup>a</sup> giornata</option>
                            <option value="29">29<sup>a</sup> giornata</option>
                            <option value="28">28<sup>a</sup> giornata</option>
                            <option value="27">27<sup>a</sup> giornata</option>
                            <option value="26">26<sup>a</sup> giornata</option>
                            <option value="25">25<sup>a</sup> giornata</option>
                            <option value="24">24<sup>a</sup> giornata</option>
                            <option value="23">23<sup>a</sup> giornata</option>
                            <option value="22">22<sup>a</sup> giornata</option>
                            <option value="21">21<sup>a</sup> giornata</option>
                            <option value="20">20<sup>a</sup> giornata</option>
                            <option value="19">19<sup>a</sup> giornata</option>
                            <option value="18">18<sup>a</sup> giornata</option>
                            <option value="17">17<sup>a</sup> giornata</option>
                            <option value="16">16<sup>a</sup> giornata</option>
                            <option value="15">15<sup>a</sup> giornata</option>
                            <option value="14">14<sup>a</sup> giornata</option>
                            <option value="13">13<sup>a</sup> giornata</option>
                            <option value="12">12<sup>a</sup> giornata</option>
                            <option value="11">11<sup>a</sup> giornata</option>
                            <option value="10">10<sup>a</sup> giornata</option>
                            <option value="9">9<sup>a</sup> giornata</option>
                            <option value="8">8<sup>a</sup> giornata</option>
                            <option value="7">7<sup>a</sup> giornata</option>
                            <option value="6">6<sup>a</sup> giornata</option>
                            <option value="5">5<sup>a</sup> giornata</option>
                            <option value="4">4<sup>a</sup> giornata</option>
                            <option value="3">3<sup>a</sup> giornata</option>
                            <option value="2">2<sup>a</sup> giornata</option>
                            <option value="1">1<sup>a</sup> giornata</option>
                        </select>
                    </div>
                    <div class="col-3">
                        <div class="">Stagione</div>
                        <select class="form-select form-select-sm w-auto" id="dropdown_season" aria-label=".form-select-sm example">
                            <option value="2022">2022/2023</option>
                            <option value="2021">2021/2022</option>
                            <option value="2020">2020/2021</option>
                            <option value="2019">2019/2020</option>
                        </select>
                    </div>
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
                    </div>
                    <div class="col-1 text-center" style="color: #2047e3;">
                        VS
                    </div>
                    <div class="col-4 text-left">
                        <img src="${match.awayTeamCrest}" height="25" width="25">&ensp;${match.awayTeam}
                    </div>
                </div>
                <div class="col-1 text-end">ciao</div>
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
    });
</script>




<!-- url request saved 
    - /v4/competitions/SA/matches?matchday=31: competizioni serie A 31esima giornata

-->