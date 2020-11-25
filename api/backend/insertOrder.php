<?php 
 require_once 'koneksi.php';

 header('Content-Type: application/json');

 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 	$iduser = $_POST['iduser'];
 	$idtoko = $_POST['idtoko'];
 	$stok = $_POST['stok'];

 	$query = "INSERT INTO tbl_penjualan (iduser, idtoko, stok) VALUES ('$iduser','$idtoko','$stok')";

 	$exeQuery = mysqli_query($conn, $query); 

     echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'berhasil menambahkan data')) :  
     json_encode(array('kode' =>2, 'pesan' => 'data gagal ditambahkan'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }

 ?>