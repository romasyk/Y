<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Emblem-favorites.svg/200px-Emblem-favorites.svg.png">
    <title>Список людей</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .user-panel {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
        }
        .panel-title {
            font-size: 24px;
            color: #333;
            margin: 0;
        }
        .avatar-img {
            max-width: 100px;
            margin-right: 20px;
        }
        .logout-btn {
            background-color: #dc3545;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <div class="user-panel p-4">
                <h3 class="panel-title mb-4">Список вподобаних</h3>
                <table class="table table-bordered">
                    <tbody>
                    <#list liked as like>
                        <#if like??>
                            <tr onclick="window.location.href='/message?id=${like.id}'; return false">
                                <td width="10">
                                    <div class="avatar-img">
                                        <img class="img-circle" src=${like.photo} />
                                    </div>
                                </td>
                                <td class="align-middle">
                                    ${like.name}
                                </td>
                            </tr>
                        </#if>
                    </#list>
                    </tbody>
                </table>
                <form method="GET" action="/logout">
                    <button type="submit" class="btn btn-danger logout-btn">Вийти</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
