<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<table class="table">
    <form:form modelAttribute="email" method="post" action="/update">
        <thead>
        <tr>
            <th>Language</th>
            <th>
                <form:select path="language" items="${language}"/>
            </th>
        </tr>
        <tr>
            <th>Page Size</th>
            <th>
                Show
                <form:select path="size" items="${size}"/>
                emails per page
            </th>
        </tr>
        <tr>
            <th>Spam filter:</th>
            <th>
                <form:checkbox path="filter"/> <span>Enable spam filter</span>
            </th>
        </tr>
        <tr>
            <th>Signature</th>
            <th>
                <form:textarea path="signature"/>
            </th>
        </tr>
        <tr>
            <th>
                <button class="btn btn-primary" type="submit">Update</button>
                <button class="btn btn-primary" type="button">Cancel</button>
            </th>
        </tr>
        </thead>
    </form:form>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>