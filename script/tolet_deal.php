<?php
  include 'tolet_connect.php';

$typeofproperty =$_POST['Customer_typeofproperty'];
$selectedProertyTypeRadio=$_POST['Customer_selectedProertyTypeRadio'];
$paddress=$_POST['Customer_paddress'];
$ppricerange=$_POST['Customer_ppricerange'];
$pdetails=$_POST['Customer_pdetails'];
$pphoneno=$_POST['Customer_pphoneno'];
$pownername=$_POST['Customer_pownername'];
$selectedPermissionsRadio=$_POST['Customer_selectedPermissionsRadio'];
$imagepath=$_POST['Customer_image'];
$demail=$_POST['Dealer_email'];
//
/*
$rand=rand(100,1000000);
$decodedImage=base64_decode("$image");
file_put_contents("tolet_postimages/"."rent".$rand,$decodedImage);
//print_r($decodedImage);
$imagepath=("http://192.168.43.7/script/tolet_postimages/"."rent".$rand);
*/

$sql="insert into tolet_deal(typeofproperty,selectedProertyTypeRadio,paddress,ppricerange,pdetails,pphoneno,pownername,selectedPermissionsRadio,imagepath,dmail)values('$typeofproperty','$selectedProertyTypeRadio','$paddress','$ppricerange','$pdetails','$pphoneno','$pownername','$selectedPermissionsRadio','$imagepath','$demail')";



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