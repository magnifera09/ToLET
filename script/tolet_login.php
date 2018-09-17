<?php

  include 'tolet_connect.php';
  
$email1 = $_POST['Customer_email'];
$pass1 = $_POST['Customer_password'];



$sql="select * FROM tolet_tb where email='$email1' and password='$pass1'";

$res=mysqli_query($con,$sql);
$check=mysqli_fetch_array($res);
if(isset($check))
{
	
   echo ("LoginSuccess");
    
}
else
{
	echo 'failure';
}
mysqli_close($con);
?>