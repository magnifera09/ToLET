<?php
  include 'tolet_connect.php';

$fname =$_POST['Customer_fname'];
//$lname =$_POST['Customer_lname'];
$email=$_POST['Customer_email'];
$mobno=$_POST['Customer_mobno'];
$dob=$_POST['Customer_dob'];
$gender=$_POST['Customer_gender'];
$maritalstatus=$_POST['Customer_ms'];
$profession=$_POST['Customer_profession'];
$address=$_POST['Customer_address'];
$password=$_POST['Customer_password'];

//file_put_contents("images_beauty/".$name7,$decodedImage);
//$imagePath=("http://192.168.43.106/project/images_beauty/".$name7);


$sql="insert into tolet_tb(fname,email,mobno,dob,gender,maritalstatus,profession,address,password)values('$fname','$email','$mobno','$dob','$gender','$maritalstatus','$profession','$address','$password')";



  if(mysqli_query($con,$sql))
 {
echo ("RegistrationSuccess");
  }

  else
  {
      echo 'Registrationfailure';
     // echo $fname,$email,$gender,$mobno;
  } 
  mysqli_close($con);

?>