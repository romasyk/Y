<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://banner2.cleanpng.com/20180408/ice/kisspng-y-alphabet-letter-ue-a-letter-5ac9cc25a7b551.223091351523174437687.jpg">
    <title>Registration</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-signup {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signup h1 {
            font-size: 28px;
            color: #333;
            margin-bottom: 20px;
        }
        .form-signup label {
            display: none;
        }
        .form-signup input[type="text"],
        .form-signup input[type="email"],
        .form-signup input[type="password"],
        .form-signup textarea {
            font-size: 16px;
            height: 50px;
            border-radius: 5px;
            margin-bottom: 20px;
            padding: 10px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .form-signup button {
            font-size: 18px;
            height: 50px;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .form-signup button:hover {
            background-color: #0056b3;
        }
        .form-signup p {
            font-size: 14px;
            color: #777;
            margin-top: 20px;
        }
    </style>
</head>
<body class="text-center">
<form class="form-signup" action="/signup" method="POST" onsubmit="return validateForm()">
    <h1 class="h3 mb-3 font-weight-normal">Please sign up</h1>
    <label for="inputName" class="sr-only">Name</label>
    <input type="text" name="name" id="inputName" class="form-control" placeholder="Name" required autofocus>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required oninput="validateEmail()">
    <div id="emailError" class="text-danger"></div>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <label for="inputInfo" class="sr-only">About Me</label>
    <textarea name="info" id="inputInfo" class="form-control" placeholder="Tell us about yourself" required></textarea>
    <label for="inputPhotoLink" class="sr-only">Photo link</label>
    <input type="text" name="photoLink" id="inputPhotoLink" class="form-control" placeholder="Photo link">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
    <p class="mt-5 mb-3 text-muted">&copy; Y</p>
</form>

<script>
    function validateEmail() {
        var emailInput = document.getElementById("inputEmail");
        var email = emailInput.value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        var emailError = document.getElementById("emailError");

        if (!email.match(emailPattern)) {
            emailError.innerHTML = "Invalid email format. Please enter a valid email address.";
            emailInput.focus();
        } else {
            emailError.innerHTML = "";
        }
    }

    function validateForm() {
        var emailInput = document.getElementById("inputEmail");
        var email = emailInput.value;
        var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        var emailError = document.getElementById("emailError");

        if (!email.match(emailPattern)) {
            emailError.innerHTML = "Invalid email format. Please enter a valid email address.";
            emailInput.focus();
            return false;
        } else {
            emailError.innerHTML = "";
            return true;
        }
    }
</script>
</body>
</html>
