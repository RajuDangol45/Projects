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
		$id=$_GET['id'];
		$sql="select * from cars where id =$id";
		$result=$con->query($sql);
		$row =  $result->fetch_assoc();
		$carName = $row["car_name"];
		$carDesc = $row["car_description"];
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
				<form action="resources/editCarsinDb.php" method="post">
					<a><h4>Fill the form to edit cars details.</h4></a>
					<div><input type="text" name="id" value="<?php echo $id ;?>" readonly></div>
					<div><input type="text" name="car_name" value="<?php echo $carName;?>"></div>
					<div><input type="text" name="car_desc" class="longText"value="<?php echo $carDesc; ?>" required></div>
					<div><input type="submit" name="btncarEdit" value="Update"></div>
				</form>
			</div>
	</div>
</body>
</html>