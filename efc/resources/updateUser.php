<?php
	include 'databaseconnect.php';
	if (isset($_POST['submit'])){
		$username=$_POST['uname'];
		$email=$_POST['email'];
		$dob=$_POST['dob'];
		$address=$_POST['address'];
		$gender =$_POST['gender'];
		$id = $_COOKIE['id'];
		$sql_user= "SELECT username FROM user where username='$username' and id<>$id";
		$selected_user=mysqli_query($con,$sql_user);
		$num_rows = mysqli_num_rows($selected_user);
		if ($num_rows>0) {
			header("Location:../updateInfo.php?msg=Username already exists");		
		}
		else {
			$sql = "UPDATE user SET username='$username',email='$email',dob='$dob',postal_address='$address',gender='$gender' WHERE id=$id;";
			mysqli_query($con,$sql);
			$_SESSION['login_user'] = $username;
			header("Location:../updateInfo.php?msg=Change successful");
		}
	}
	else{
		echo "Denied";
	}
?>