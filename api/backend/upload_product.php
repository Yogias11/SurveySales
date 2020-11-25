<?php
 
include 'koneksi.php';
 
// Create connection
// $conn = new mysqli($servername, $username, $password, $dbname);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $iduser = isset($_POST['iduser'])?$_POST['iduser']:"";
 $nm_product = isset($_POST['nm_product'])?$_POST['nm_product']:"";
 $harga = isset($_POST['harga'])?$_POST['harga']:"";
 $stok = isset($_POST['stok'])?$_POST['stok']:"";
 $image = isset($_POST['gambar'])?$_POST['gambar']:"";
 $now = DateTime::createFromFormat('U.u',microtime(true)); 
 $id = $now->format('YmdHis');
//  $extension = $fileinfo['extension'];
 
 $ImagePath = 'product/'.$id.'.png';
 $server_ip = gethostbyname(gethostname());
 $ServerURL = 'http://'.$server_ip.'/backend/'.$ImagePath;
 
 $InsertSQL = "INSERT INTO tbl_product (`idproduct`, `iduser`, `nm_product`, `harga`, `stok`, `gambar`) VALUES (NULL, '$iduser', '$nm_product', '$harga', '$stok', '$ServerURL')";
 
 if(mysqli_query($conn, $InsertSQL)){
 
 file_put_contents($ImagePath,base64_decode($image));
 
 echo "Your Image Has Been Uploaded.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Please Try Again";
 }
 
?>