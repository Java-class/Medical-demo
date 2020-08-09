-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2020 at 08:52 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicaldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `add_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `profession_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `add_date`, `profession_id`) VALUES
(1, 'doc1', '2020-08-08 09:01:36', 1),
(2, 'doc1', '2020-08-08 09:15:57', 1),
(3, 'اکرم اسماعیلی', '2020-08-09 06:19:05', 3),
(4, 'بهمن پور اقدم', '2020-08-09 06:19:05', 4),
(5, 'ریحانه شعبانی', '2020-08-09 06:19:05', 5),
(6, 'علی جلالی نژاد', '2020-08-09 06:19:05', 6),
(7, 'کیان دارابی', '2020-08-09 06:19:05', 7);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(100) COLLATE utf8_persian_ci NOT NULL DEFAULT 'MALE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `name`, `age`, `sex`) VALUES
(1, 'Alireza', 23, '0'),
(2, 'Ahmad', 28, '0'),
(3, 'علیرضا حسینی', 23, '0'),
(4, 'زهرا ناصری', 45, '1'),
(5, 'علی احمدی', 16, '0'),
(6, 'محمد محمدی', 60, '0'),
(7, 'فاطمه محمدی', 30, '1');

-- --------------------------------------------------------

--
-- Table structure for table `profession`
--

CREATE TABLE `profession` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8_persian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `profession`
--

INSERT INTO `profession` (`id`, `title`, `description`) VALUES
(1, 'profe1', NULL),
(2, 'profe2', NULL),
(3, 'پزشک عمومی', NULL),
(4, 'دندانپزشکی', NULL),
(5, 'قلب و عروق', NULL),
(6, 'گوش، حلق و بینی', NULL),
(7, 'کودکان', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `work_schedule`
--

CREATE TABLE `work_schedule` (
  `id` int(11) NOT NULL,
  `dc_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `pt_id` int(11) DEFAULT NULL,
  `description` varchar(1000) COLLATE utf8_persian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

--
-- Dumping data for table `work_schedule`
--

INSERT INTO `work_schedule` (`id`, `dc_id`, `date`, `pt_id`, `description`) VALUES
(13, 1, '2020-08-08 09:00:00', 1, NULL),
(14, 1, '2020-08-08 09:30:00', 2, 'some description for booking'),
(15, 1, '2020-08-08 10:00:00', NULL, NULL),
(16, 1, '2020-08-08 10:30:00', NULL, NULL),
(17, 1, '2020-08-08 11:00:00', NULL, NULL),
(18, 1, '2020-08-08 11:30:00', NULL, NULL),
(19, 3, '2020-08-09 06:25:07', NULL, NULL),
(20, 3, '2020-08-09 06:55:07', NULL, NULL),
(21, 3, '2020-08-09 07:25:07', NULL, NULL),
(22, 3, '2020-08-09 07:55:07', NULL, NULL),
(23, 3, '2020-08-09 08:25:07', NULL, NULL),
(24, 3, '2020-08-09 08:55:07', NULL, NULL),
(25, 4, '2020-08-09 06:26:59', NULL, NULL),
(26, 4, '2020-08-09 06:46:59', NULL, NULL),
(27, 4, '2020-08-09 07:06:59', NULL, NULL),
(28, 4, '2020-08-09 07:26:59', NULL, NULL),
(29, 4, '2020-08-09 07:46:59', NULL, NULL),
(30, 4, '2020-08-09 08:06:59', 3, 'دارای تب خفیف و سردرد و...');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profession`
--
ALTER TABLE `profession`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `work_schedule`
--
ALTER TABLE `work_schedule`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `profession`
--
ALTER TABLE `profession`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `work_schedule`
--
ALTER TABLE `work_schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
