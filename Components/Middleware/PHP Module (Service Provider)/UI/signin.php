<?php

  include('connection.php');
  $cookie_name = "loggedin";


  if (isset($_POST['submit'])) {
    session_start();
    $username = $_POST['username'];
    $password = $_POST['password'];
    //$password = md5($password);

    $sql = "SELECT * FROM serviceproviders WHERE username='$username' AND password='$password'";
    $result = mysqli_query($conn, $sql);

    if (mysqli_num_rows($result) == 1) {
      $_SESSION['message'] = "You are now logged in";
      $_SESSION['username'] = $username;
      $cookie_value = $username;
      setcookie($cookie_name, $cookie_value, time()+86400, "/");
      header("location: home.php"); // redirect to home page
    } else {
      $_SESSION['message'] = "Username/password combination incorrect";
    }


  }
  


?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <script src="assets/ie-emulation-modes-warning.js"></script>
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action="signin.php" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUsername" class="sr-only"></label>
        <input type="username" id="inputUsername" class="form-control" placeholder="Username" name="username" required autofocus>
        <label for="inputPassword" class="sr-only"></label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <a button class="btn btn-lg btn-primary btn-block" type="submit" href="index.php" name="submit">Sign in</a>
      </form>
    </div> <!-- /container -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
