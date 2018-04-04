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
		$username = $row["username"];
		$email = $row["email"];
		$dob = $row["dob"];
		$address = $row["postal_address"];
		$gender = $row["gender"];
		$id = $row["id"];
		$_SESSION['login_user'] = $username;
		setcookie('id', $id, time() + (86400 * 30), "/");
	?>
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
				<div class="form">
					<form action="resources/updateUser.php" method="post">
						<input type="text" name="uname" placeholder="Username" value="<?php echo $username;?>" required><br />
						<input type="email" name="email" placeholder="E-mail" value="<?php echo $email;?>" required><br />
						<input type="text" name="dob" placeholder="Date of Birth" value="<?php echo $dob;?>" required><br />
						<input type="text" name="address" placeholder="Postal address" value="<?php echo $address;?>" required><br />
						<?php if($gender=="Male"){ ?>
							<input type="radio" name="gender" value="Male" checked>Male
							<input type="radio" name="gender" value="Female">Female<br />
						<?php } ?>
						<?php if($gender=="Female"){ ?>
							<input type="radio" name="gender" value="Male">Male
							<input type="radio" name="gender" value="Female" checked>Female<br />
						<?php } ?>
						<input class="loginBtn" type="submit" name="submit" value="Submit"><br />
					</form>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>