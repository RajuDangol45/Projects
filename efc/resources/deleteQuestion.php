<?php
include 'databaseconnect.php';
if(isset($_GET['questionid'])){
		$questionid=$_GET['questionid'];
		$carId = $_GET['carId'];
		$sql = "Delete from question where id = $questionid";
		$result=$con->query($sql);
		$sql = "Delete from answer where questionid = $questionid";
		$result=$con->query($sql);
		header("Location:../questionPage.php?id=$carId");
}
?>
