 <?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "tolet";

// Create connection
$con= new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($con->connect_error) {
    die("Connection failed:<br>".$con->connect_error);
} 

?> 