-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2023 at 03:21 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uas_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `nim` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jurusan` varchar(255) NOT NULL,
  `angkatan` varchar(4) NOT NULL,
  `ukm` varchar(255) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `jabatan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_anggota`
--

INSERT INTO `tb_anggota` (`nim`, `nama`, `jurusan`, `angkatan`, `ukm`, `telp`, `alamat`, `email`, `password`, `jabatan`) VALUES
(1, 'Farhan', 'RPL', '20', 'DPM', '0877412413', 'Cianjur', 'faruzaan@upi.edu', '123', 'Staff Badan Legislasi'),
(2002, 'Ucup', 'PGSD', '19', 'DPM', '0988832828', 'Cicalengka', 'ucup@mail.com', '2002DPM19', 'Bendahara'),
(2004, 'Rizky', 'RPL', '20', 'HIMA RPL', '0897384918', 'Bandung', 'rizky@mail.com', '123', 'Sekretaris'),
(2005, 'Zulfa', 'RPL', '20', 'BEM', '087884295', 'Cibiru', 'zulfa@mail.com', '123', 'Unit Pengembangan Diri'),
(2008, 'Budi', 'PEDIA', '2020', 'BEM', '09829738', 'Bandung', 'budi@mail.com', '2008BEM2020', 'Kabiro Akademik'),
(2009, 'Farhan', 'TEKOM', '2021', 'BEM', '098273872', 'Jatinangor', 'farhan@mail.com', '2009BEM2021', 'Ketua');

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `id` int(11) NOT NULL,
  `ukm` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jml_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`id`, `ukm`, `nama`, `jml_barang`) VALUES
(1, 'DPM', 'Tripod', 1),
(2, 'HIMA RPL', 'Audio Mixer', 1),
(4, 'DPM', 'Lens', 4),
(5, 'DPM', 'Kamera', 4),
(6, 'HIMA RPL', 'Proyektor', 9),
(7, 'HIMA RPL', 'Printer', 7),
(8, 'HIMA RPL', 'Kabel HDMI', 5),
(9, 'BEM', 'Meja', 12),
(10, 'BEM', 'Tenda', 9),
(11, 'BEM', 'Kursi', 28),
(12, 'BEM', 'Kamera', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_peminjaman`
--

CREATE TABLE `tb_detail_peminjaman` (
  `id` int(11) NOT NULL,
  `id_peminjaman` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jml_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_detail_peminjaman`
--

INSERT INTO `tb_detail_peminjaman` (`id`, `id_peminjaman`, `id_barang`, `jml_barang`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 1),
(10, 7, 1, 7),
(11, 7, 2, 7),
(12, 8, 2, 3),
(13, 8, 1, 3),
(14, 9, 1, 5),
(15, 9, 2, 5),
(16, 9, 1, 2),
(17, 9, 2, 2),
(18, 12, 1, 1),
(20, 10, 4, 3),
(21, 11, 4, 1),
(22, 12, 6, 2),
(23, 13, 6, 1),
(24, 15, 4, 1),
(25, 16, 5, 1),
(26, 16, 7, 2),
(27, 16, 9, 5),
(28, 17, 5, 1),
(29, 18, 10, 1),
(30, 18, 5, 1),
(31, 19, 9, 1),
(32, 19, 10, 1),
(33, 19, 11, 1),
(34, 20, 9, 1),
(35, 20, 10, 1),
(36, 21, 6, 1),
(37, 21, 7, 1),
(38, 22, 6, 1),
(39, 22, 7, 1),
(40, 22, 8, 1),
(41, 23, 9, 1),
(42, 23, 11, 1),
(43, 24, 6, 1),
(44, 24, 7, 1),
(45, 25, 8, 2),
(46, 27, 6, 1),
(47, 27, 8, 1),
(48, 28, 1, 1),
(49, 28, 4, 1),
(50, 29, 1, 1),
(51, 29, 5, 1);

--
-- Triggers `tb_detail_peminjaman`
--
DELIMITER $$
CREATE TRIGGER `update_stok` AFTER INSERT ON `tb_detail_peminjaman` FOR EACH ROW BEGIN
UPDATE tb_barang SET jml_barang = jml_barang - NEW.jml_barang WHERE id = NEW.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tb_peminjaman`
--

CREATE TABLE `tb_peminjaman` (
  `id` int(11) NOT NULL,
  `id_peminjam` int(11) NOT NULL,
  `ukm` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_peminjaman`
--

INSERT INTO `tb_peminjaman` (`id`, `id_peminjam`, `ukm`, `status`) VALUES
(1, 1, 'DPM', 'Declice'),
(2, 1, 'HIMA RPL', 'Accept'),
(3, 1, 'DPM', 'Pending'),
(4, 1, 'DPM', 'Pending'),
(5, 1, 'DPM', 'Pending'),
(6, 1, 'RPL', 'Accept'),
(7, 1, 'HIMA RPL', 'Pending'),
(8, 1, 'DPM', 'Pending'),
(9, 1, 'DPM', 'Declice'),
(10, 1, 'DPM', 'Accept'),
(11, 1, 'DPM', 'Pending'),
(12, 2004, 'HIMA RPL', 'Accept'),
(13, 2004, 'HIMA RPL', 'Pending'),
(14, 2004, 'HIMA RPL', 'Pending'),
(15, 2004, 'HIMA RPL', 'Declice'),
(16, 2005, 'BEM', 'Declice'),
(17, 2005, 'BEM', 'Declice'),
(18, 2005, 'BEM', 'Declice'),
(19, 2005, 'BEM', 'Declice'),
(20, 2005, 'BEM', 'Declice'),
(21, 2005, 'BEM', 'Pending'),
(22, 2005, 'HIMA RPL', 'Accept'),
(23, 2004, 'BEM', 'Accept'),
(24, 2005, 'HIMA RPL', 'Accept'),
(25, 2005, 'HIMA RPL', 'Declice'),
(26, 2005, 'HIMA RPL', 'Pending'),
(27, 2005, 'HIMA RPL', 'Accept'),
(28, 2005, 'DPM', 'Accept'),
(29, 2005, 'DPM', 'Declice');

-- --------------------------------------------------------

--
-- Table structure for table `tb_proker`
--

CREATE TABLE `tb_proker` (
  `id` int(11) NOT NULL,
  `proker` varchar(125) NOT NULL,
  `pelaksanaan` varchar(50) NOT NULL,
  `department` varchar(125) NOT NULL,
  `pemasukan` varchar(125) NOT NULL,
  `nominal` varchar(125) NOT NULL,
  `ukm` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_proker`
--

INSERT INTO `tb_proker` (`id`, `proker`, `pelaksanaan`, `department`, `pemasukan`, `nominal`, `ukm`) VALUES
(1, 'Makrab', '16 Juni 2022', 'PSDO', 'IUK', '500000', 'BEM'),
(2, 'Proker Mingguan', '29 Juni 2022', 'KOMINFO', 'IUK', '900000', 'HIMA RPL'),
(4, 'Proker 3', 'Lusa', 'KOMINFO', 'Lembaga', '500', 'BEM'),
(5, 'Seminar PAI', '2 Juni', 'KASTRAD', 'Lembaga', '7000', 'BEM'),
(6, 'OPAH', '9 mei', 'PSDO', 'IUK', '9000', 'HIMA RPL'),
(7, 'Seminar Masuk Kmapus', '28 mei', 'KASTRAD', 'Lembaga', '6000', 'HIMA RPL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_detail_peminjaman`
--
ALTER TABLE `tb_detail_peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_proker`
--
ALTER TABLE `tb_proker`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  MODIFY `nim` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2010;

--
-- AUTO_INCREMENT for table `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tb_detail_peminjaman`
--
ALTER TABLE `tb_detail_peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `tb_peminjaman`
--
ALTER TABLE `tb_peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `tb_proker`
--
ALTER TABLE `tb_proker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
