<?php
include 'databaseconnect.php';
if(isset($_GET['answerid'])){
		$answerid=$_GET['answerid'];
		$asker = $_GET['asker'];
		$question = $_GET['question'];
		$questionid=$_GET['questionId'];
		$sql = "Delete from answer where id = $answerid";
		$result=$con->query($sql);
		echo $sql;
		header("Location:../answerPage.php?questionid=$questionid&asker=$asker&question=$question");
}
?>
