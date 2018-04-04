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
				<table border="1">
					<?php
						echo "<tr>";
						echo "<th>id</th>";
						echo "<th>Car name</th>";
						echo "<th>Description</th>";
						echo "<th>Edit</th>";
						echo "<th>Delete</th>";
						echo "</tr>";
						$sql= "SELECT * FROM cars";
						$result = $con->query($sql);
						while($row = $result->fetch_assoc()) {
							$id = $row["id"];
							$name = $row["car_name"];
							$desc = $row["car_description"];
							echo "<tr>";
							echo "<td>".$id."</td>";
							echo "<td>".$name."</td>";
							echo "<td>".$desc."</td>";
							echo "<td><a href='editCars.php?id=$id'>EDIT</a></td>";
							echo "<td><a href='resources/deleteCars.php?id=$id'>Delete</a></td>";
							echo "</tr>";
						}
					?>
				</table>
			</div>
	</div>
</body>
</html>