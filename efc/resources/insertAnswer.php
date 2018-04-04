<?php
	include 'databaseconnect.php';
	if (isset($_POST['submit'])){
		$questionId=$_GET['questionId'];
		$answer=$_POST['answer'];
		$username = $_GET['user'];
		$asker = $_GET['asker'];
		$question = $_GET['question'];
		$sql = "INSERT INTO answer(questionId,answer,answerer) values('$questionId','$answer','$username')";
		mysqli_query($con,$sql);
		echo $sql;
		header("Location:../answerPage.php?questionid=$questionId&asker=$asker&question=$question");
	}
	else{
		echo "Access Denied";
	}
?>