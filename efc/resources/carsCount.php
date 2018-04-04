<?php
include 'databaseconnect.php';
$sql = "select * from  cars";
$result = $con->query($sql);
$carsCount = mysqli_num_rows($result);
?>