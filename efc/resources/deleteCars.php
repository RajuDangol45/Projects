<?php
$id ="";
if(!isset($_SESSION['login_user'])){
	header("Location:index.php");
}
include 'databaseconnect.php';
if(isset($_GET['id'])){
		$id=$_GET['id'];
		$sql = "Delete from cars where id = $id";
		$result=$con->query($sql);
		$sql = "Delete from carsdescription where id = $id";
		$result=$con->query($sql);
		header("Location:../editCarsInfo.php?msg=Delete successful");
}
?>
