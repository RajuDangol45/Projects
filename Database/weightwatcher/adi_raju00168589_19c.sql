-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2018 at 03:07 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adi_raju00168589_19c`
--

-- --------------------------------------------------------

--
-- Table structure for table `calorie`
--

CREATE TABLE `calorie` (
  `day` int(11) NOT NULL,
  `caloricIntake` double NOT NULL,
  `caloricBurn` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calorie`
--

INSERT INTO `calorie` (`day`, `caloricIntake`, `caloricBurn`) VALUES
(1, 350, 345),
(2, 340, 335),
(3, 320, 360);

-- --------------------------------------------------------

--
-- Table structure for table `dailyrecord`
--

CREATE TABLE `dailyrecord` (
  `day` int(11) NOT NULL,
  `activity_level` varchar(200) NOT NULL,
  `weight` double NOT NULL,
  `waist_size` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailyrecord`
--

INSERT INTO `dailyrecord` (`day`, `activity_level`, `weight`, `waist_size`) VALUES
(1, 'INACTIVE', 80, 35),
(2, 'INACTIVE', 81, 33),
(3, 'INACTIVE', 85, 35);

-- --------------------------------------------------------

--
-- Table structure for table `exercise`
--

CREATE TABLE `exercise` (
  `name` varchar(200) NOT NULL,
  `calories_burned_per_minute` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exercise`
--

INSERT INTO `exercise` (`name`, `calories_burned_per_minute`) VALUES
('a', 1),
('b', 2),
('Squat', 14.4);

-- --------------------------------------------------------

--
-- Table structure for table `meal`
--

CREATE TABLE `meal` (
  `name` varchar(200) NOT NULL,
  `calorie_per_gram` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`name`, `calorie_per_gram`) VALUES
('a', 1),
('b', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `name` varchar(200) NOT NULL,
  `gender` varchar(200) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `waist_size`
--

CREATE TABLE `waist_size` (
  `waist_size_in_the_morning` double NOT NULL,
  `waist_size_in_the_evening` double NOT NULL,
  `last_waist_size_provided` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `waist_size`
--

INSERT INTO `waist_size` (`waist_size_in_the_morning`, `waist_size_in_the_evening`, `last_waist_size_provided`) VALUES
(33, 35, 35);

-- --------------------------------------------------------

--
-- Table structure for table `weight`
--

CREATE TABLE `weight` (
  `weight_in_the_morning` double NOT NULL,
  `weight_in_the_evening` double NOT NULL,
  `last_provided_weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weight`
--

INSERT INTO `weight` (`weight_in_the_morning`, `weight_in_the_evening`, `last_provided_weight`) VALUES
(84, 86, 86);

-- --------------------------------------------------------

--
-- Table structure for table `weights`
--

CREATE TABLE `weights` (
  `day` int(11) NOT NULL,
  `value` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weights`
--

INSERT INTO `weights` (`day`, `value`) VALUES
(1, 80),
(2, 81),
(3, 85);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `calorie`
--
ALTER TABLE `calorie`
  ADD UNIQUE KEY `day` (`day`);

--
-- Indexes for table `dailyrecord`
--
ALTER TABLE `dailyrecord`
  ADD UNIQUE KEY `day` (`day`);

--
-- Indexes for table `exercise`
--
ALTER TABLE `exercise`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `meal`
--
ALTER TABLE `meal`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `weights`
--
ALTER TABLE `weights`
  ADD PRIMARY KEY (`day`),
  ADD UNIQUE KEY `day` (`day`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `calorie`
--
ALTER TABLE `calorie`
  MODIFY `day` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `dailyrecord`
--
ALTER TABLE `dailyrecord`
  MODIFY `day` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `weights`
--
ALTER TABLE `weights`
  MODIFY `day` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
