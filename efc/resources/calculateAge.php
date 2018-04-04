<?php
include 'databaseconnect.php';
$username = $_GET['username'];
$sql = "SELECT YEAR(CURRENT_DATE) - YEAR(dob) as age FROM user";
$result = mysqli_query($con,$sql);
while($row =  $result->fetch_assoc()){
	$age = $row["age"];
}
$sql = "INSERT INTO userage(age) VALUES ($age);";
mysqli_query($con,$sql);
header("Location:../index.php?msg=Successfully signed up");
?>