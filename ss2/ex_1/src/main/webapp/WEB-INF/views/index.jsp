<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action="/save" method="post">
    <h1>SANDWICH CONDIMENTS</h1>
    <table class="table">
        <thead>
        <tr>
            <th><input type="checkbox" name="condiment" value="Lettuce">Lettuce</th>
            <th><input type="checkbox" name="condiment" value="Tomato">Tomato</th>
            <th><input type="checkbox" name="condiment" value="Mustard">Mustard</th>
            <th><input type="checkbox" name="condiment" value="Sprouts">Sprouts</th>
            <th>
                <button class="btn btn-primary">SUBMIT</button>
            </th>
        </tr>
    </table>
</form>
<p>${result}</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>