-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 17-10-2023 a las 16:30:32
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cellphones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE IF NOT EXISTS `brand` (
  `code` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `brand`
--

INSERT INTO `brand` (`code`, `brand`) VALUES
('12345', 'iPhone'),
('54321', 'Samsung');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cellphone`
--

DROP TABLE IF EXISTS `cellphone`;
CREATE TABLE IF NOT EXISTS `cellphone` (
  `code` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `ram` varchar(30) NOT NULL,
  `storage` varchar(30) NOT NULL,
  `color` varchar(30) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `cellphone`
--

INSERT INTO `cellphone` (`code`, `brand`, `name`, `ram`, `storage`, `color`) VALUES
('209888', 'Samsung', 'Z-flip', '12 gb ram', '512 gb', 'Blanco neutro'),
('100450', 'iPhone', 'iPhone 15 pro', '8 ram', '256 gb', 'Azul meadianoche');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
