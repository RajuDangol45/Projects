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
				<?php  if (isset($_GET['id'])) {
					$id = $_GET['id'];
					$sql = "select * from cars where id=$id";
					$result = $con->query($sql);
					$row =  $result->fetch_assoc();
					$firstcount = $row["car_view_count"];
					$firstcount++;
					$sql = "update cars set car_view_count=$firstcount where id=$id";
					mysqli_query($con, $sql);
				}
				?>
				<?php include 'resources/carsCount.php' ?>
					<?php 
						$counter = 1;
						while ($counter <= $carsCount) {
					?>
					<div class="carsTitle"><h2><u>
					<?php 
						$sql = "select * from  carsdescription where id=$counter";
						$result = $con->query($sql);
						$row =  $result->fetch_assoc();
						echo $row["car_name"];
					?>
					</u></h2></div>
					<div class="cars">
					<?php
						echo $row["car_description"];
					?>
					</div>
					<?php $counter++; }?>
				</div>
			</div>	
		</div>
	</div>
</body>
</html>