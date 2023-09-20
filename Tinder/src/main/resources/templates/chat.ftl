<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Emblem-favorites.svg/200px-Emblem-favorites.svg.png">

    <title>Чат</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Основні стилі Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Спеціальні стилі для цього шаблону -->
    <style>
        body {
            background-color: #f8f8f8;
        }

        .chat-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }

        .chat-header {
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }

        .chat-content {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 15px;
            overflow-y: scroll;
            max-height: 400px;
        }

        .message {
            display: flex;
            margin-bottom: 20px;
        }

        .sender-img img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .message-text {
            padding: 10px;
            border-radius: 10px;
            background-color: #f2f2f2;
        }

        .message-time {
            font-size: 12px;
            color: #777;
            margin-top: 5px;
        }

        .message-text a {
            text-decoration: underline;
        }

        .message-text img {
            max-width: 200px; /* Фіксований розмір фото */
            height: auto;
        }

        .message-input {
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 10px;
            margin-top: 10px;
            width: 100%;
            resize: none;
        }

        .custom-button {
            border: none;
            border-radius: 10px;
            padding: 10px 20px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 10px;
        }

        .send-button {
            background-color: #007bff;
            color: #fff;
        }

        .logout-button {
            background-color: #ff0000;
            color: #fff;
        }
    </style>
</head>
<body>

<div class="chat-container">
    <div class="chat-header">
        <h3>Ketty Peris</h3>
    </div>
    <div class="chat-content">
        <div class="message">
            <div class="sender-img">
                <img src="http://nicesnippets.com/demo/image1.jpg" alt="Користувач">
            </div>
            <div class="message-text">
                <p>Привіт, як справи?</p>
                <span class="message-time">Ketty, 25 січня, 18:20</span>
            </div>
        </div>
    </div>
    <textarea class="message-input" placeholder="Напишіть ваше повідомлення..."></textarea>
    <button class="custom-button send-button">Відправити</button>

    <!-- Кнопка для виходу методом POST -->
    <form method="GET" action="/logout">
        <button class="custom-button logout-button">Вийти</button>
    </form>
</div>

</body>
</html>
