
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://banner2.cleanpng.com/20180408/ice/kisspng-y-alphabet-letter-ue-a-letter-5ac9cc25a7b551.223091351523174437687.jpg">

    <title>Liked</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" >

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/css/style.css">
</head>



<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
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
                                        <td class="align-middle">
                                            ${like.info}
                                        </td>
                                        <td  class="align-middle">
                                            Last Login:  ${like.lastLogining} <br>
                                        </td>
                                    </tr>
                                </#if>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-auto">
                    <form method="GET" action="/logout">
                        <button type="submit" class="btn btn-logout">EXIT</button>
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

