<?php
	include 'databaseconnect.php';
	if (isset($_POST['submit'])){
		$username=$_POST['uname'];
		$password=$_POST['password'];
		$email=$_POST['email'];
		$dob=$_POST['dob'];
		$address=$_POST['address'];
		$gender =$_POST['gender'];
		$userType = "normal";
		$sql_user= "SELECT username FROM user where username='$username'";
		$selected_user=mysqli_query($con,$sql_user);
		$num_rows = mysqli_num_rows($selected_user);
		if ($num_rows>0) {
			header("Location:../index.php?msg=User already exists");		
		}
		else {
			$sql = "INSERT INTO user(username,password,email,dob,postal_address,gender,user_type) VALUES ('$username','$password','$email','$dob', '$address', '$gender','$userType');";
			mysqli_query($con,$sql);
			echo $sql;
			header("Location:calculateAge.php?username=$username");
		}
	}
	else{
		echo "Access Denied";
	}
?>