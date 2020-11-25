-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2020 at 09:40 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sales`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_penjualan`
--

CREATE TABLE `tbl_penjualan` (
  `idpenjualan` int(11) NOT NULL,
  `tgl_input` datetime NOT NULL DEFAULT current_timestamp(),
  `iduser` int(11) NOT NULL,
  `idtoko` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_penjualan`
--

INSERT INTO `tbl_penjualan` (`idpenjualan`, `tgl_input`, `iduser`, `idtoko`, `stok`) VALUES
(1, '2020-11-24 21:07:39', 1, 1, 10),
(2, '2020-11-24 21:08:07', 1, 1, 19);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_product`
--

CREATE TABLE `tbl_product` (
  `idproduct` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `nm_product` varchar(100) NOT NULL,
  `harga` varchar(10) NOT NULL,
  `stok` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `gambar` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_product`
--

INSERT INTO `tbl_product` (`idproduct`, `iduser`, `nm_product`, `harga`, `stok`, `url`, `gambar`) VALUES
(1, 1, 'Kosmetik', '10000', 100, '', NULL),
(12, 1, 'Kosmetik', '10000', 100, '', 'http://192.168.234.2/backend/product/20201124144608.png'),
(13, 1, 'Kosmetik', '10000', 100, '', 'http://192.168.234.2/backend/product/20201125071018.png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_promo`
--

CREATE TABLE `tbl_promo` (
  `idpromo` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `promo` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_promo`
--

INSERT INTO `tbl_promo` (`idpromo`, `iduser`, `promo`, `name`) VALUES
(1, 2, 'Discon 10%', 'aa'),
(2, 2, 'Beli 1 Gratis 1', 'aa');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_toko`
--

CREATE TABLE `tbl_toko` (
  `idtoko` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  `nm_toko` varchar(30) NOT NULL,
  `almt_toko` varchar(255) NOT NULL,
  `list_kunjungan` enum('0','1') NOT NULL DEFAULT '0',
  `status_kunjungan` enum('0','1') NOT NULL DEFAULT '0',
  `long` varchar(10) NOT NULL,
  `lat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_toko`
--

INSERT INTO `tbl_toko` (`idtoko`, `idproduct`, `nm_toko`, `almt_toko`, `list_kunjungan`, `status_kunjungan`, `long`, `lat`) VALUES
(1, 1, 'ABAL', 'Jl. Wijaya No.06', '0', '0', '107.001', '97.002'),
(3, 1, 'ABAL1', 'Jl. Wijaya No.07', '0', '0', '107.002', '97.003');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `iduser` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fullname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`iduser`, `username`, `password`, `fullname`) VALUES
(1, 'abdul', 'abdul', 'Abdul'),
(2, 'budi', 'budi', 'Budi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD PRIMARY KEY (`idpenjualan`),
  ADD KEY `fk1` (`idtoko`),
  ADD KEY `fk2` (`iduser`);

--
-- Indexes for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD PRIMARY KEY (`idproduct`),
  ADD KEY `fk3` (`iduser`);

--
-- Indexes for table `tbl_promo`
--
ALTER TABLE `tbl_promo`
  ADD PRIMARY KEY (`idpromo`),
  ADD KEY `fk5` (`iduser`);

--
-- Indexes for table `tbl_toko`
--
ALTER TABLE `tbl_toko`
  ADD PRIMARY KEY (`idtoko`),
  ADD UNIQUE KEY `almt_toko` (`almt_toko`),
  ADD UNIQUE KEY `long` (`long`),
  ADD UNIQUE KEY `lat` (`lat`),
  ADD KEY `fk4` (`idproduct`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  MODIFY `idpenjualan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_product`
--
ALTER TABLE `tbl_product`
  MODIFY `idproduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_promo`
--
ALTER TABLE `tbl_promo`
  MODIFY `idpromo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_toko`
--
ALTER TABLE `tbl_toko`
  MODIFY `idtoko` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_penjualan`
--
ALTER TABLE `tbl_penjualan`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`idtoko`) REFERENCES `tbl_toko` (`idtoko`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`iduser`) REFERENCES `tbl_user` (`iduser`);

--
-- Constraints for table `tbl_product`
--
ALTER TABLE `tbl_product`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`iduser`) REFERENCES `tbl_user` (`iduser`);

--
-- Constraints for table `tbl_promo`
--
ALTER TABLE `tbl_promo`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`iduser`) REFERENCES `tbl_user` (`iduser`) ON UPDATE CASCADE;

--
-- Constraints for table `tbl_toko`
--
ALTER TABLE `tbl_toko`
  ADD CONSTRAINT `fk4` FOREIGN KEY (`idproduct`) REFERENCES `tbl_product` (`idproduct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
