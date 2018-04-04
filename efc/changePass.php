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
	<?php
		$username = $_SESSION['login_user'];
		if(isset($_COOKIE['id'])){
			$id = $_COOKIE['id'];
			$sql = "select * from user where id=$id";
		}
		else{
			$sql = "select * from user where username='$username'";
		}
		$result = $con->query($sql);
		$row =  $result->fetch_assoc();
		$id = $row["id"];
		$_SESSION['login_user'] = $username;
		setcookie('id', $id, time() + (86400 * 30), "/");
	?>
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
				<form action="resources/changePassword.php" method="post">
					<input type="password" name="previousPass" placeholder="Previous password" required><br />
					<input type="password" name="pass" placeholder="Type password" required><br />
					<input type="password" name="retypepass" placeholder="Re-type password" required><br />
					<input class="loginBtn" type="submit" name="submit" value="Submit"><br />
				</form>
			</div>	
		</div>
	</div>
</body>
</html>