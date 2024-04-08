<?php
$servername = "database-1.clg0y6oqkpd2.ap-south-1.rds.amazonaws.com"; // Change to your MySQL server hostname or IP address
$username = "admin"; // Change to your MySQL username
$password = "Sumeddha2004"; // Change to your MySQL password
$dbname = "cdd"; // Change to your MySQL database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
