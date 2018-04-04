<?php
session_start();
if(!isset($_SESSION['login_user'])){
	header("Location:index.php");
}
?>
<!DOCTYPE html>
<html>
<head>
	<?php include 'include/head.php' ?>
</head>
<body>
	<?php include 'resources/databaseconnect.php' ?>
	<h1><a class="text">Dash Board</a></h1>
	<div class="wrapper">
		<div class="left_box">
			<?php 
			if($_COOKIE['userType']=="admin"){
				include 'adminleftbar.php'; 
			}
			else {
				include 'leftbar.php'; 
			}
			?>	
		</div>
		<div class="right_box">
			<div class = "details">
				<?php 
					$questionID=$_GET['questionid'];
					$asker = $_GET['asker'];
					$question = $_GET['question'];
					$username = $_SESSION['login_user'];
					?>
				<div class="question">
					<?php
						echo $asker." : ".$question;
					?>
				</div>
					<?php
					$sql = "select * from answer where questionId=$questionID";
					$result = $con->query($sql);
					while($row =  $result->fetch_assoc()){
						$id = $row["id"];
						$answer = $row["answer"];
						$answerer = $row["answerer"];
				?>
				<?php if ($username==$answerer){ ?>
				<div class="delete"><a href="resources/deleteAnswer.php?answerid=<?php echo $id;?>&questionId=<?php echo $questionID;?>&asker=<?php echo $asker;?>&user=<?php echo $username;?>&question=<?php echo $question;?>">Delete</a></div>
				<?php } ?>
				<div class="answer"><?php echo $answerer." : ".$answer; ?></div>
				<?php } ?>
				<form action="resources/insertAnswer.php?questionId=<?php echo $questionID;?>&asker=<?php echo $asker;?>&user=<?php echo $username;?>&question=<?php echo $question;?>" method="post">
					<textarea class="askQuestion" name="answer" cols="80" rows="3"></textarea><br />
					<input class="btn" type="submit" name="submit" value="Answer"><br />
				</form>
			</div>
		</div>
	</div>
</body>
</html>