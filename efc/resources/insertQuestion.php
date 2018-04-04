<?php
	include 'databaseconnect.php';
	if (isset($_POST['submit'])){
		$carId=$_GET['carId'];
		$question=$_POST['question'];
		$username = $_GET['user'];
		$sql = "INSERT INTO question(question,car_id,asker) values('$question','$carId','$username')";
		mysqli_query($con,$sql);
		echo $sql;
		header("Location:../questionPage.php?id=$carId");
	}
	else{
		echo "Access Denied";
	}
?>