<?php
  include 'tolet_connect.php';
$imagepath=$decodedImage="";
$typeofproperty =$_POST['Customer_typeofproperty'];
//$lname =$_POST['Customer_lname'];
$selectedProertyTypeRadio=$_POST['Customer_selectedProertyTypeRadio'];
$paddress=$_POST['Customer_paddress'];
$ppricerange=$_POST['Customer_ppricerange'];
$pdetails=$_POST['Customer_pdetails'];
$pphoneno=$_POST['Customer_pphoneno'];
$pownername=$_POST['Customer_pownername'];
//$selectedPermissionsRadio=$_POST['Customer_selectedPermissionsRadio'];
$image=$_POST['Customer_image'];
//
$rand=rand(100,1000000);
if ($image!=null) {
	# code...

$decodedImage=base64_decode("$image");
file_put_contents("tolet_postimages/"."sell".$rand,$decodedImage);
//print_r($decodedImage);
$imagepath=("http://192.168.43.7/script/tolet_postimages/"."sell".$rand);
}

$sql="insert into tolet_postsell(id,typeofproperty,selectedProertyTypeRadio,paddress,ppricerange,pdetails,pphoneno,pownername,imagepath)values('$rand','$typeofproperty','$selectedProertyTypeRadio','$paddress','$ppricerange','$pdetails','$pphoneno','$pownername','$imagepath'  )";



  if(mysqli_query($con,$sql))
 {
echo ("UploadSuccess");
  }

  else
  {
      echo 'Uploadfailure';
     // echo $fname,$email,$gender,$mobno;
  } 
  mysqli_close($con);

?>