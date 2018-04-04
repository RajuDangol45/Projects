<!DOCTYPE html>
<html>
<head>
	<?php include 'include/head.php' ?>
</head>
<body>
<h1><a class="text">Eco Friendly Cars</a></h1>
<div id="setupPage">
	<form action="resources/setup.php" method="post">
			<input class="btn" type="submit" name="submit" value="Setup"><br />
	</form>
</div>
<div class="wrapper">
	<div class="form">
		<?php if(isset($_GET['attempts'])){
			if(($_GET['attempts'])>2)
			{
				die("You are blocked for 5 minutes.");
			}
		}
		?>
		<form action="resources/login.php" method="post">
			<input type="text" name="username" placeholder="Username" required><br />
			<input type="password" name="password" placeholder="Password" required><br />
			<input class="btn" type="submit" name="submit" value="LOGIN"><br />
		</form>
		<?php if(isset($_GET['msg'])) echo $_GET['msg'];?>
		<div>Not member yet?? Register <a href="register.php">here</a></div>
	</div>
</div>
</body>
</html>