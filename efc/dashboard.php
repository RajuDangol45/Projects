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
	<script type="text/javascript">
		window.addEventListener('load', function () {
			function go() {
				i = i < width ? i + step : -420;
				m.style.marginLeft = -i + 'px';
			}
			var i = 0,
			step = 4;
			var m = document.getElementById('marquee');
			m.style.position = 'absolute'; 
			var width = (m.clientWidth - 280);
			m.style.position = '';
			m.addEventListener('mouseenter', function () {
				step = 0;
			}, true);
			m.addEventListener('mouseleave', function () {
				step = 4;
			}, true);
			setInterval(go, 100);
		}, true);
	</script>
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
				<h2 class="visitor"><?php 
					$sql = "select * from visitor";
					$result = $con->query($sql);
					$row =  $result->fetch_assoc();
					$firstcount = $row["count"];
					$firstcount++;
					$sql = "update visitor set count=$firstcount";
					mysqli_query($con, $sql);
					echo "Visitor count : ".$firstcount;
				?></h2>
				<h3>Please view cars in the below list.</h3>
				<div id="marquee">The most famous car this months is <b><?php  
					$sql = "select * from  cars";
					$result = $con->query($sql);
					$mostViewedCar = "";
					$viewCount = 0;
					while($row =  $result->fetch_assoc()){
						if($row["car_view_count"]>$viewCount){
							$viewCount = $row["car_view_count"];
							$mostViewedCar = $row["car_name"];
						}
					}
					echo $mostViewedCar.".";
				?> </b></div>
				<?php include 'resources/carsCount.php' ?>
				<?php 
					$counter = 1;
					while ($counter <= $carsCount) {
				?>
				<div class="carsTitle"><h3><u><a href="carDetails.php?id=<?php echo $counter;?>">
				<?php 
					$sql = "select * from  cars where id=$counter";
					$result = $con->query($sql);
					$row =  $result->fetch_assoc();
					echo $row["car_name"];
				?>
				</a></u></h3></div>
				<div class="cars">
				<?php
					echo $row["car_description"];
				?>
				</div>
				<?php $counter++; } ?>
			</div>	
			<div class="rss"><a href="rss/rss.php"><img src="images/rss.png" width="35" height="35"></a></div>
		</div>
	</div>
</body>
</html>