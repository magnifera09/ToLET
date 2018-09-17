-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 22, 2018 at 05:29 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tolet`
--

-- --------------------------------------------------------

--
-- Table structure for table `tolet_deal`
--

CREATE TABLE `tolet_deal` (
  `id` int(10) NOT NULL,
  `typeofproperty` varchar(15) NOT NULL,
  `selectedProertyTypeRadio` varchar(15) NOT NULL,
  `paddress` varchar(50) NOT NULL,
  `ppricerange` varchar(10) NOT NULL,
  `pdetails` varchar(100) NOT NULL,
  `pphoneno` varchar(10) NOT NULL,
  `pownername` varchar(50) NOT NULL,
  `selectedPermissionsRadio` varchar(25) NOT NULL,
  `imagepath` varchar(1000) NOT NULL,
  `dmail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `tolet_deal`
--

INSERT INTO `tolet_deal` (`id`, `typeofproperty`, `selectedProertyTypeRadio`, `paddress`, `ppricerange`, `pdetails`, `pphoneno`, `pownername`, `selectedPermissionsRadio`, `imagepath`, `dmail`) VALUES
(1, 'Rent', 'PG', 'alambagh', '120000', 'ok', '2147483647', 'dharmendr', 'Not Allowed', 'http://192.168.43.7/script/tolet_postimages/rent70146', 'd@g.c'),
(2, 'Rent', 'Flat', 'alambagh', '120000', 'ok', '2147483647', 'dharmendr', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent482469', 'd@g.c'),
(3, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(4, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(5, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(6, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(7, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(8, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(9, 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'Not Mention', 'http://192.168.43.7/script/tolet_postimages/sell947985', 'd@g.c'),
(10, 'Rent', 'Hostel', 'lda', '120000', 'ok', '2147483647', 'krishna', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent689782', 'd@g.c');

-- --------------------------------------------------------

--
-- Table structure for table `tolet_postad`
--

CREATE TABLE `tolet_postad` (
  `id` int(10) NOT NULL,
  `typeofproperty` varchar(15) NOT NULL,
  `selectedProertyTypeRadio` varchar(15) NOT NULL,
  `paddress` varchar(50) NOT NULL,
  `ppricerange` varchar(15) NOT NULL,
  `pdetails` varchar(50) NOT NULL,
  `pphoneno` int(15) NOT NULL,
  `pownername` varchar(20) NOT NULL,
  `selectedPermissionsRadio` varchar(20) NOT NULL,
  `imagepath` varchar(1000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `tolet_postad`
--

INSERT INTO `tolet_postad` (`id`, `typeofproperty`, `selectedProertyTypeRadio`, `paddress`, `ppricerange`, `pdetails`, `pphoneno`, `pownername`, `selectedPermissionsRadio`, `imagepath`) VALUES
(1, 'Rent', 'Flat', 'alambagh', '120000', 'ok', 2147483647, 'dharmendr', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent482469'),
(2, 'Rent', 'PG', 'alambagh', '120000', 'ok', 2147483647, 'dharmendr', 'Not Allowed', 'http://192.168.43.7/script/tolet_postimages/rent70146'),
(3, 'Rent', 'Hostel', 'alambagh', '120000', 'ok', 2147483647, 'rama', 'Not Allowed', 'http://192.168.43.7/script/tolet_postimages/rent401977'),
(4, 'Rent', 'Hostel', 'lda', '120000', 'ok', 2147483647, 'krishna', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent689782'),
(5, 'Rent', 'Flat', 'alambagh', '120000', 'ok', 2147483647, 'dharmendr', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent18889'),
(6, 'Rent', 'Flat', 'bankok', '120000', 'ok', 2147483647, 'dharmendr', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent840245'),
(7, 'Rent', 'Flat', 'alambagh', '120000', 'ok', 2147483647, 'dharmendr', 'Roomates Allowed', 'http://192.168.43.7/script/tolet_postimages/rent736566');

-- --------------------------------------------------------

--
-- Table structure for table `tolet_postsell`
--

CREATE TABLE `tolet_postsell` (
  `id` varchar(10) NOT NULL,
  `typeofproperty` varchar(10) NOT NULL,
  `selectedProertyTypeRadio` varchar(10) NOT NULL,
  `paddress` text NOT NULL,
  `ppricerange` text NOT NULL,
  `pdetails` varchar(100) NOT NULL,
  `pphoneno` varchar(10) NOT NULL,
  `pownername` varchar(30) NOT NULL,
  `imagepath` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16;

--
-- Dumping data for table `tolet_postsell`
--

INSERT INTO `tolet_postsell` (`id`, `typeofproperty`, `selectedProertyTypeRadio`, `paddress`, `ppricerange`, `pdetails`, `pphoneno`, `pownername`, `imagepath`) VALUES
('210887', 'sell', 'land', 'ramnagar', '20000', 'good', '8127445599', 'rajnikant', 'http://192.168.43.7/script/tolet_postimages/sell210887'),
('782287', 'sell', 'Flat', 'alambagh', '5000', 'good', '81258859', 'ravi', 'http://192.168.43.7/script/tolet_postimages/sell782287'),
('818903', 'sell', 'land', 'alambagh', '50000', 'best', '', '9000000', 'http://192.168.43.7/script/tolet_postimages/sell818903'),
('876058', 'sell', 'Flat', 'kasmir', '800000', 'good', '8127442587', 'ram', 'http://192.168.43.7/script/tolet_postimages/sell876058'),
('947985', 'sell', 'Flat', 'engineer college', '20000', 'nice', '9991676767', 'subhi', 'http://192.168.43.7/script/tolet_postimages/sell947985'),
('967566', 'sell', 'Flat', 'transport nagar', '100000', 'ggjkkjjj', '998794846', 'xyz', 'http://192.168.43.7/script/tolet_postimages/sell967566');

-- --------------------------------------------------------

--
-- Table structure for table `tolet_tb`
--

CREATE TABLE `tolet_tb` (
  `id` int(10) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mobno` varchar(12) NOT NULL,
  `dob` varchar(10) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `maritalstatus` varchar(20) NOT NULL,
  `profession` varchar(40) NOT NULL,
  `address` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16;

--
-- Dumping data for table `tolet_tb`
--

INSERT INTO `tolet_tb` (`id`, `fname`, `email`, `mobno`, `dob`, `gender`, `maritalstatus`, `profession`, `address`, `password`) VALUES
(1, 'dell', 'dellpell@cell.com', '987654321', '12345678', 'Female', 'Living Relationship', 'fdsgsdgsdgsgs', 'addressssooo', ''),
(2, 'batman', 'batsy@catsy.com', '123456978', '12457896', 'Female', 'Living Relationship', 'superhero', 'bat cave', ''),
(3, 'dymatize', 'dymatize@co.in', '987645123', '1234569', 'Male', 'Married', 'gym', 'califorina usa ..charbagh', '12345'),
(4, 'magneto', 'd@g.c', '987654321', '12122012', 'Male', 'Committed', 'super hero', 'vikas nagar', 'hello'),
(5, 'xiaomi', 'xiaomi@c.co.', '123456789', '12121997', 'Male', 'Single', 'gshshsbsb', 'jzhsbsbsbsb', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tolet_deal`
--
ALTER TABLE `tolet_deal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tolet_postad`
--
ALTER TABLE `tolet_postad`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tolet_postsell`
--
ALTER TABLE `tolet_postsell`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `tolet_tb`
--
ALTER TABLE `tolet_tb`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tolet_deal`
--
ALTER TABLE `tolet_deal`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tolet_postad`
--
ALTER TABLE `tolet_postad`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tolet_tb`
--
ALTER TABLE `tolet_tb`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
