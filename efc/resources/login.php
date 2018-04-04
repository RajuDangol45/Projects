<?php

session_start();

include 'databaseconnect.php';

if(isset($_COOKIE['login_attempts'])){
	if($_COOKIE['login_attempts']>2){
		//setcookie('login_attempts',$_COOKIE['login_attempts']+1,time()-300);
		die("You are blocked for 5 minutes.");
	}
}
	if(isset($_POST['submit'])){
		$username = $_POST['username'];
		$password = $_POST['password'];
		$username = stripslashes($username);
		$password = stripslashes($password);
		$sql = "select * from user where username = '$username' and password = '$password'";
		$result = $con->query($sql);
		$row =  $result->fetch_assoc();
		$userType = $row["user_type"];
		$count = mysqli_num_rows($result);
		if($count == 1){
			setcookie('login_attempts',1);
			if($userType=="admin"){
				$_SESSION['login_user'] = $username;
				setcookie('id', $id, time() + (86400 * 30), "/");
				setcookie('userType', $userType, time() + (86400 * 30), "/");
				header("location:../dashboard.php");
			}
			else{
				$_SESSION['login_user'] = $username;
				setcookie('id', $id, time() + (86400 * 30), "/");
				setcookie('userType', $userType, time() + (86400 * 30), "/");
				header("location:../dashboard.php");
			}
		}
		else{
			if(isset($_COOKIE['login_attempts'])){
				setcookie('login_attempts',$_COOKIE['login_attempts']+1,time()+300);
			}
			else{
				setcookie('login_attempts',1);
			}
			$attempts = $_COOKIE['login_attempts'];
			header("location:../index.php?msg=Incorrect username/password&attempts=$attempts");
		}
	}
?>