<?php
include 'databaseconnect.php';
if (isset($_POST['btncarEdit'])){
	$id=$_POST['id'];
	$name = $_POST['car_name'];
	$desc=$_POST['car_desc'];
	$sql ="UPDATE cars set car_name='$name', car_description='$desc' where id=$id";
	mysqli_query($con,$sql);
	header("location:../editCarsInfo.php?msg=Edit successful");
	}
?>