<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Описание вашей страницы здесь. Это описание может содержать информацию о вашем веб-приложении или сайте.">
    <meta name="author" content="">
    <link rel="icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Emblem-favorites.svg/200px-Emblem-favorites.svg.png">
    <title>Like page</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/style.css">
    <style>
        .card img {
            width: 200px; /* Фиксированная ширина фотографии */
            height: 200px; /* Фиксированная высота фотографии */
            object-fit: cover; /* Обрезка изображения, чтобы сохранить соотношение сторон */
        }
        .card {
            margin-top: 20px;
            background-color: #ffffff;
            border: 1px solid #e0e0e0;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            border-radius: 5px;
        }
        .card-body {
            text-align: center;
        }
        .btn-dislike {
            background-color: #dc3545;
            color: #fff;
        }
        .btn-like {
            background-color: #28a745;
            color: #fff;
        }
    </style>
</head>
<body style="background-color: #f5f5f5;">

<div class="container mt-5">
    <div class="row">
        <div class="col-12 col-lg-4 offset-lg-4">
            <div class="card">
                <img src="${photo}" class="card-img-top mx-auto" alt="User Photo">
                <div class="card-body">
                    <h3 class="mb-0">${name}</h3>
                    <form action="/users" method="post">
                        <div class="row">
                            <div class="col-6">
                                <button type="submit" name="liked" value ="NO" class="btn btn-dislike btn-block"><span class="fa fa-times"></span> Dislike</button>
                            </div>
                            <div class="col-6">
                                <button type="submit" name="liked" value ="YES" class="btn btn-like btn-block"><span class="fa fa-heart"></span> Like</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
