<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">
    <title>Chat</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="chat-main col-6 offset-3">
            <div class="col-md-12 chat-header">
                <div class="row header-one text-white p-1">
                    <div class="col-md-6 name pl-2">
                        <i class="fa fa-comment"></i>
                        <#if names??><h6 class="ml-1 mb-0">${names[2]}</h6></#if>
                    </div>

                    <div class="col-md-6 options text-right pr-0">

                        <button title="Back to Liked Users" onclick="window.location.href='/liked'; return false" style="border: none; background-color: transparent;"><i class="fa fa-times hover text-center pt-1"></i></button>


                    </div>
                </div>
                <div class="row header-two w-100">
                    <div class="col-md-6 options-left pl-1">
                        <i class="fa fa-video-camera mr-3"></i>
                        <i class="fa fa-video-camera mr-3"></i>
                    </div>

                    <div class="col-md-6 options-right text-right pr-2">
                        <button title="LogOut" onclick="window.location.href='/logout'; return false" style="border: none; background-color: transparent;">
                            <i class="fa fa-cog"></i>
                        </button>
                    </div>

                </div>
            </div>
            <div class="chat-content">
                <div class="col-md-12 chats pt-3 pl-2 pr-3 pb-3">
                    <ul class="p-0">
                        <#list messages as message>
                            <#if names??>
                                <#if messages??>
                                    <#if data??>
                                        <#if data[0] == message.senderId>
                                            <li class="send-msg float-right mb-2">
                                                <p class="pt-1 pb-1 pl-2 pr-2 m-0 rounded">
                                                    ${message.content}
                                                </p>
                                            </li>
                                        </#if>
                                        <#if data[1] == message.senderId>
                                            <li class="receive-msg float-left mb-2">
                                                <div class="sender-img">
                                                    <img src=${names[3]} class="float-left">
                                                </div>
                                                <div class="receive-msg-desc float-left ml-2">
                                                    <p class="bg-white m-0 pt-1 pb-1 pl-2 pr-2 rounded">
                                                        ${message.content}
                                                    </p>
                                                </div>
                                            </li>
                                        </#if>
                                    </#if>
                                </#if>
                            </#if>
                        </#list>
                    </ul>
                </div>
                <form action="/message"  method="post" >
                    <div class="col-md-12 p-2 msg-box border border-primary">
                        <div class="row">
                            <div class="col-md-2 options-left">
                                <img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gU3ZnIFZlY3RvciBJY29ucyA6IGh0dHA6Ly93d3cub25saW5ld2ViZm9udHMuY29tL2ljb24gLS0+DQo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB2aWV3Qm94PSIwIDAgMjU2IDI1NiIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAwIDAgMjU2IDI1NiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8bWV0YWRhdGE+IFN2ZyBWZWN0b3IgSWNvbnMgOiBodHRwOi8vd3d3Lm9ubGluZXdlYmZvbnRzLmNvbS9pY29uIDwvbWV0YWRhdGE+DQo8Zz48Zz48cGF0aCBmaWxsPSIjMDAwMDAwIiBkPSJNMjMzLjIsMjEwLjJIMjIuOGMtNy4xLDAtMTIuOC00LjktMTIuOC0xMC45VjU2LjhjMC02LDUuOC0xMC45LDEyLjgtMTAuOWgyMTAuNGM3LjEsMCwxMi44LDQuOSwxMi44LDEwLjl2MTQyLjVDMjQ2LDIwNS4zLDI0MC4zLDIxMC4yLDIzMy4yLDIxMC4yeiBNMjIuOCw1My44Yy0yLjcsMC00LjgsMS41LTQuOCwyLjl2MTQyLjVjMCwxLjQsMiwyLjksNC44LDIuOWgyMTAuNGMyLjcsMCw0LjgtMS41LDQuOC0yLjlWNTYuOGMwLTEuNC0yLTIuOS00LjgtMi45SDIyLjh6Ii8+PHBhdGggZmlsbD0iIzAwMDAwMCIgZD0iTTkxLjUsMTI2LjJsNS43LDUuN2wtNzcuMyw3Ny4zbC01LjctNS43TDkxLjUsMTI2LjJMOTEuNSwxMjYuMnoiLz48cGF0aCBmaWxsPSIjMDAwMDAwIiBkPSJNMTY0LjcsMTI1LjZsNzguOCw3OC44bC01LjcsNS43TDE1OSwxMzEuM0wxNjQuNywxMjUuNkwxNjQuNywxMjUuNnoiLz48cGF0aCBmaWxsPSIjMDAwMDAwIiBkPSJNMTI3LjcsMTY2LjZjLTIuNiwwLTUuMS0xLTctMi45TDE1LjIsNTguMmw1LjctNS43TDEyNi4zLDE1OGMwLjUsMC41LDEuMSwwLjYsMS4zLDAuNnMwLjktMC4xLDEuMy0wLjZMMjM1LjEsNTEuOWw1LjcsNS43TDEzNC43LDE2My42QzEzMi44LDE2NS41LDEzMC4zLDE2Ni42LDEyNy43LDE2Ni42eiIvPjwvZz48L2c+DQo8L3N2Zz4=" width="32" height="32">
                            </div>
                            <div class="col-md-7 pl-0">
                                <input type="text"  name ="message" class="border-0" placeholder=" Send message" />
                            </div>
                            <div class="col-md-3 text-right options-right">
                                <button class="fa fa-picture-o mr-2" style="border: none; background-color: white;" type="submit " value="submit"><img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gU3ZnIFZlY3RvciBJY29ucyA6IGh0dHA6Ly93d3cub25saW5ld2ViZm9udHMuY29tL2ljb24gLS0+DQo8IURPQ1RZUEUgc3ZnIFBVQkxJQyAiLS8vVzNDLy9EVEQgU1ZHIDEuMS8vRU4iICJodHRwOi8vd3d3LnczLm9yZy9HcmFwaGljcy9TVkcvMS4xL0RURC9zdmcxMS5kdGQiPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB2aWV3Qm94PSIwIDAgMjU2IDI1NiIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAwIDAgMjU2IDI1NiIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8bWV0YWRhdGE+IFN2ZyBWZWN0b3IgSWNvbnMgOiBodHRwOi8vd3d3Lm9ubGluZXdlYmZvbnRzLmNvbS9pY29uIDwvbWV0YWRhdGE+DQo8Zz48Zz48cGF0aCBmaWxsPSIjMDAwMDAwIiBkPSJNMjAuNSwyMi43bDIxNSwxMDUuM2wtMjE1LDEwNS4zTDQxLDEzNy42bDEyOS04Ljl2LTEuM2wtMTI5LTguOUwyMC41LDIyLjcgTTIwLjUsMTIuMmMtMi4zLDAtNC42LDAuNy02LjUsMi4yYy0zLjIsMi41LTQuNiw2LjUtMy44LDEwLjVsMjAuNSw5NS44YzAuNywzLjMsMyw2LDUuOSw3LjRjLTMsMS4zLTUuMiw0LTUuOSw3LjRsLTIwLjUsOTUuOGMtMC44LDMuOSwwLjYsOCwzLjgsMTAuNGMxLjksMS41LDQuMiwyLjIsNi41LDIuMmMxLjYsMCwzLjItMC40LDQuNi0xLjFsMjE1LTEwNS4zYzMuNi0xLjgsNS45LTUuNCw1LjktOS40YzAtNC0yLjMtNy43LTUuOS05LjRMMjUuMSwxMy4zQzIzLjYsMTIuNiwyMiwxMi4yLDIwLjUsMTIuMkwyMC41LDEyLjJ6Ii8+PC9nPjwvZz4NCjwvc3ZnPg==" width="32" height="32"></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
