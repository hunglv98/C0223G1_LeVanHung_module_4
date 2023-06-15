<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">CONVERT USD TO VND </h1>
<form action="/convert" method="get">
    <table class="table">
        <thead>
        <tr>
            <th>USD</th>
            <th>RATE</th>
            <th>VND</th>
            <th>CONVERT</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td scope="row"><input required type="number" name="usd" value="${usd}"></td>
            <td><input required type="number" name="rate" value="${rate}"></td>
            <td><input type="number" name="vnd" value="${vnd}" readonly></td>
            <td>
                <button class="btn btn-primary" type="submit">CONVERT</button>
            </td>
        </tr>

        </tbody>
    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>