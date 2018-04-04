<?php
session_start();
if(!isset($_SESSION['login_user'])){
	header("Location:index.php");
}
?>
<!DOCTYPE html>
<html>
<head>
	<?php include 'include/head.php' ?>
</head>
<body>
	<?php include 'resources/databaseconnect.php' ?>
	<h1><a class="text">Dash Board</a></h1>
	<div class="wrapper">
		<div class="left_box">
			<?php 
			if($_COOKIE['userType']=="admin"){
				include 'adminleftbar.php'; 
			}
			else {
				include 'leftbar.php'; 
			}
			?>	
		</div>
		<div class="right_box">
			<div class = "details">
				<div class = "msg"><?php if(isset($_GET['msg'])) {echo $_GET['msg'];} ?></div>
				<form action="resources/addCarDb.php" method="post">
					<a><h4>Fill the form to add cars.</h4></a>
					<div><input type="text" name="car_name" placeholder="Car Name"></div>
					<div><input type="text" name="car_desc" placeholder="Car Description" class="longText" required></div>
					<div><input type="text" name="car_long_desc" placeholder="Full Description" class="longText" required></div>
					<div><input type="submit" name="btncarAdd" value="Add"></div>
				</form>
			</div>
	</div>
</body>
</html>