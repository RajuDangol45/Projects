<!DOCTYPE html>
<html>
<head>
	<?php include 'include/head.php' ?>
</head>
<body>
<h1><a class="text">Eco Friendly Cars</a></h1>
<div class="wrapper">
	<div class="form">
		<form action="resources/insertuser.php" method="post">
			<input type="text" name="uname" placeholder="Username" required><br />
			<input type="password" name="password" placeholder="Password" required><br />
			<input type="email" name="email" placeholder="E-mail" required><br />
			<input type="text" name="dob" placeholder="DoB : yyyy-mm-dd" required><br />
			<input type="text" name="address" placeholder="Postal address" required><br />
			<input type="radio" name="gender" value="Male" checked>Male
			<input type="radio" name="gender" value="Female">Female<br />
			<input class="loginBtn" type="submit" name="submit" value="Register"><br />
		</form>
	</div>
</div>
</body>
</html>