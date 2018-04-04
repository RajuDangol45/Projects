<?php
	include 'databaseconnect.php';
	if (isset($_POST['btncarAdd'])){
		$name=$_POST['car_name'];
		$desc=$_POST['car_desc'];
		$long_desc=$_POST['car_long_desc'];
		$sql = "SELECT count(*) as count FROM cars";
		$result = mysqli_query($con,$sql);
		$row = mysqli_fetch_assoc($result);
		$id = $row['count'];
		$id++;
		$sql = "INSERT INTO cars values($id,'$name','$desc',0);";
		mysqli_query($con,$sql);
		echo $sql;
		$sql = "INSERT INTO carsdescription values($id,'$name','$long_desc');";
		mysqli_query($con,$sql);
		echo $sql;
		header("Location:../addcar.php?msg=Successfully added car");
	}
	else{
		echo "Access Denied";
	}
?>