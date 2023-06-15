<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<h1 style="text-align: center">Translate English Into Vietnamese</h1>
<form action="/translate" method="post">
    <table class="table">
        <thead>
        <tr>
            <th>English</th>
            <th></th>
            <th>Vietnamese</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td scope="row"><input name="english" value="${english}"></td>
            <td>
                <button class="btn btn-primary">Translate</button>
            </td>
            <td scope="row"><input name="vietnamese" value="${vietnamese}"></td>
        </tr>
        </tbody>
    </table>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>