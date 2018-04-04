<?php
	include 'databaseconnect.php';
	if (isset($_POST['submit'])){
		$previousPass = $_POST['previousPass'];
		$pass = $_POST['pass'];
		$rePass = $_POST['retypepass'];
		$id = $_COOKIE['id'];
		$sql= "SELECT * FROM user where id='$id'";
		$result = $con->query($sql);
		$row =  $result->fetch_assoc();
		$sql_pass = $row["password"];
		echo $sql_pass;
		if($sql_pass!=$previousPass){
			header("Location:../changePass.php?msg=Wrong password");
		}
		else if($pass!=$rePass){
			header("Location:../changePass.php?msg=Passwords don't match");
		}else{
			$sql = "UPDATE user SET password='$pass' WHERE id=$id;";
			mysqli_query($con,$sql);
			$_SESSION['login_user'] = $username;
			header("Location:../changePass.php?msg=Change successful");
		}
	}
	else{
		echo "Denied";
	}
?>