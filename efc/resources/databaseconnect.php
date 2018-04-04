<?php
$servername='localhost';
$username='root';
$password='';
$databasename='raju00168589_19c';

$con = new mysqli($servername,$username,$password,$databasename);

if($con->connect_error){
	die("Connection not successful");
}
?>