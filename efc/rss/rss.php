<?php
header("content-type:text/xml");
echo '<?xml version="1.0"?>';
echo '<ecocar>';
include '../resources/databaseconnect.php';
$sql = "select * from cars";
$result = mysqli_query($con,$sql);
while ($row=mysqli_fetch_array($result)){
	echo "<cars>";
	echo "<id>".$row[0]."</id>";
	echo "<carname>".$row[1]."</carname>";
	echo "<carshortdesc>".$row[2]."</carshortdesc>";
	echo "<carviewcount>".$row[3]."</carviewcount>";
	echo "</cars>";
}
$sql = "select * from carsdescription";
$result = mysqli_query($con,$sql);
while ($row=mysqli_fetch_array($result)){
	echo "<carsdescription>";
	echo "<id>".$row[0]."</id>";
	echo "<carname>".$row[1]."</carname>";
	$row[2] = str_replace("'", "", $row[2]);
	echo "<carlongdesc>".substr($row[2],0,260)."</carlongdesc>";
	echo "</carsdescription>";
}
echo '</ecocar>';
?>