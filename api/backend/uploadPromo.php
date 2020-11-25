<?php
 
include 'koneksi.php' ;
 
$iduser = isset($_POST['iduser'])?$_POST['iduser']:"";
$promo = isset($_POST['promo'])?$_POST['promo']:"";
$name = isset($_POST['name'])?$_POST['name']:"";

$path = "promo/$name.png";

$sql = "INSERT INTO tbl_promo(iduser, promo, 'name') values('','$promo','$path');";
 
if(mysqli_query($conn,$sql))
{
file_put_contents($path,base64_decode($name));
echo json_encode(array('response'=>"Successfully Uploaded..."));
}
else
{
echo json_encode(array('response'=>"Failed..."));
}
mysqli_close($conn);
 
?>