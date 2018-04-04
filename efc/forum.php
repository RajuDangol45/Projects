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
				<?php include 'resources/carsCount.php' ?>
				<?php 
					$counter = 1;
					while ($counter <= $carsCount) {
				?>
				<div class="carsTitle"><h3><a href="questionPage.php?id=<?php echo $counter;?>">
				<?php 
					$sql = "select * from  cars where id=$counter";
					$result = $con->query($sql);
					$row =  $result->fetch_assoc();
					echo $row["car_name"];
				?>
			</a></h3>
				<?php $counter++; } ?>
			</div>
		</div>
	</div>
</body>
</html>