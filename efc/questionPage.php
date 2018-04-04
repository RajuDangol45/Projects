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
					$carId=$_GET['id'];
					$username = $_SESSION['login_user'];
					$sql = "select * from question where car_id=$carId";
					$result = $con->query($sql);
					while($row =  $result->fetch_assoc()){
						$question = $row["question"];
						$asker = $row["asker"];
						$id = $row["id"];
						$asker = $row["asker"];
				?>
				<?php if ($username==$asker){ ?>
				<div class="delete"><a href="resources/deleteQuestion.php?questionid=<?php echo $id;?>&carId=<?php echo $carId;?>">Delete</a></div>
				<?php } ?>
				<div class="question"><a href="answerPage.php?questionid=<?php echo $id;?>&asker=<?php echo $asker;?>&question=<?php echo $question;?>">
					<?php
						echo $asker." : ".$question;
					?>
				</a></div> 
				<?php } ?>
				<form action="resources/insertQuestion.php?carId=<?php echo $carId;?>&user=<?php echo $username;?>" method="post">
					<textarea class="askQuestion" name="question" cols="80" rows="2"></textarea><br />
					<input class="btn" type="submit" name="submit" value="Ask"><br />
				</form>
			</div>
		</div>
	</div>
</body>
</html>