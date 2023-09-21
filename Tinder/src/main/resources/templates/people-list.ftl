<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Emblem-favorites.svg/200px-Emblem-favorites.svg.png">

    <title>Список людей</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Підключення Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Підключення власних стилів для цього шаблону -->
    <link rel="stylesheet" href="/css/style.css">
    <style>
        /* Ваші додаткові стилі тут */
        body {
            background-color: #f8f9fa;
        }

        .user-panel {
            margin-top: 30px;
        }

        .panel-title {
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .table-users {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .table-users td, .table-users th {
            border: 1px solid #e1e1e1;
            padding: 10px;
            text-align: center;
        }

        .avatar-img img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }

        .user-text {
            margin-left: 10px;
        }

        .logout-btn {
            text-align: center;
            margin-top: 20px;
        }

        /* Додаткові стилі для покращення вигляду таблиці та кнопки */
        .table-container {
            overflow-x: auto;
        }

        .table-users th {
            background-color: #f2f2f2;
        }

        .table-users tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .table-users th, .table-users td {
            vertical-align: middle;
        }

        .table-users tr:hover {
            background-color: #d9edf7;
        }

        /* Нові стилі для відображення фото і тексту вертикально */
        .user-row {
            display: flex;
            align-items: center;
        }

        /* Стилі для роботи з tbody і зменшення його висоти */
        tbody {
            display: block;
            max-height: 300px; /* Змініть це значення на те, яке вам підходить */
            overflow-y: auto;
        }

        tr {
            display: flex;
            justify-content: space-between;
        }

        .btn-logout {
            background-color: #dc3545;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 12px 24px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn-logout:hover {
            background-color: #c82333;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="panel panel-default user-panel">
                <div class="panel-heading">
                    <h3 class="panel-title">Список користувачів</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table">
                            <tbody>
                            <#list liked as like>
                                <#if like??>
                                    <tr onclick="window.location.href='/message?id=${like.id}'; return false">
                                        <td>
                                            <div class="user-row">
                                                <div class="avatar-img">
                                                    <img class="img-circle" src=${like.photo} alt="${like.name}" />
                                                </div>
                                                <div class="user-text">
                                                    <p>${like.name}</p>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </#if>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-auto">
                            <form method="GET" action="/logout">
                                <button type="submit" class="btn btn-logout">Вийти</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
