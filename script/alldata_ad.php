<?php
	 include 'tolet_connect.php';

	define('HOST','localhost');
	define('USER','root');
	define('PASS','');	
	define('DB','tolet');	
	$con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');

$sql="select * from tolet_postad";
$result=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_array($result))
{
array_push($response,array(
"top"=>$row['typeofproperty'],
"topr"=>$row['selectedProertyTypeRadio'],
"paddress"=>$row['paddress'],
"ppricerange"=>$row['ppricerange'],
"pdetails"=>$row['pdetails'],
"pphoneno"=>$row['pphoneno'],
"pownername"=>$row['pownername'],
"selectedPermissionsRadio"=>$row['selectedPermissionsRadio'],
"imagepath"=>$row['imagepath'],
));
}

 echo json_encode($response);


?>
