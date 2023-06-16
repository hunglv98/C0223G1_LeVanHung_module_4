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
<div class="container">
    <h1>Calculator</h1>
    <form action="/calculator" method="post">
        <div class="row" style="margin-bottom: 10px">
            <span class="col-3"><input style="width: 100%" required type="number" name="num1" value="${num1}"></span>
            <span class="col-3"><input style="width: 100%" required type="number" name="num2" value="${num2}"></span>
        </div>

        <div class="row" style="margin-bottom: 10px">
            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%;border-radius: 10px" type="submit" name="calculation"
                        value="Addition">Addition(+)
                </button>
            </div>
            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%;border-radius: 10px" type="submit" name="calculation"
                        value="Subtraction">Subtraction(-)
                </button>
            </div>
            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%;border-radius: 10px" type="submit" name="calculation"
                        value="Multiplication">Multiplication(*)
                </button>
            </div>
            <div class="col-2">
                <button class="btn btn-primary" style="width: 100%;border-radius: 10px" type="submit" name="calculation"
                        value="Division">Division(/)
                </button>
            </div>
        </div>
    </form>
    <h2>Result: <span>${result}</span></h2>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>