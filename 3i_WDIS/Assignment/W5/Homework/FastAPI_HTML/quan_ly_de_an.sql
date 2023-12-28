-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 15, 2021 lúc 12:52 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_de_an`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `congviec`
--

CREATE TABLE `congviec` (
  `MADA` int(11) NOT NULL DEFAULT 0,
  `STT` int(11) NOT NULL DEFAULT 0,
  `TEN_CONG_VIEC` char(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `congviec`
--

INSERT INTO `congviec` (`MADA`, `STT`, `TEN_CONG_VIEC`) VALUES
(1, 1, 'Thiet ke san pham X'),
(1, 2, 'Thu nghiem san pham X'),
(2, 1, 'San xuat san pham Y'),
(2, 2, 'Quang cao san pham Y'),
(3, 1, 'Khuyen mai san pham Z'),
(10, 1, 'Tin hoc hoa nhan su tien luong'),
(10, 2, 'Tin hoc hoa phong kinh doanh'),
(20, 1, 'Lap dat cap quang'),
(30, 1, 'Dao tao nhan vien Marketing'),
(30, 2, 'Dao tao chuyen vien thiet ke');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dean`
--

CREATE TABLE `dean` (
  `TENDA` char(15) NOT NULL DEFAULT '',
  `MADA` int(11) NOT NULL DEFAULT 0,
  `DDIEM_DA` char(15) NOT NULL DEFAULT '',
  `PHONG` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `dean`
--

INSERT INTO `dean` (`TENDA`, `MADA`, `DDIEM_DA`, `PHONG`) VALUES
('San pham X', 1, 'Vũng Tàu', 5),
('San pham Y', 2, 'Nha Trang', 5),
('San pham Z', 3, 'TP HCM', 5),
('Tin hoc hoa', 10, 'Hà Nội', 4),
('Cap quang', 20, 'TP HCM', 1),
('Dao tao', 30, 'Hà Nội', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diadiem_phg`
--

CREATE TABLE `diadiem_phg` (
  `MAPHG` int(11) NOT NULL DEFAULT 0,
  `DIADIEM` char(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `diadiem_phg`
--

INSERT INTO `diadiem_phg` (`MAPHG`, `DIADIEM`) VALUES
(1, 'TP HCM'),
(4, 'Hà Nội'),
(5, 'TAU'),
(5, 'Nha Trang'),
(5, 'TP HCM');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `HONV` char(15) NOT NULL DEFAULT '',
  `TENLOT` char(15) NOT NULL DEFAULT '',
  `TENNV` char(15) NOT NULL DEFAULT '',
  `MANV` char(9) NOT NULL DEFAULT '',
  `NGSINH` date NOT NULL,
  `DCHI` varchar(30) NOT NULL DEFAULT '',
  `PHAI` char(3) NOT NULL DEFAULT '',
  `LUONG` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `MA_NQL` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `PHG` int(10) UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`HONV`, `TENLOT`, `TENNV`, `MANV`, `NGSINH`, `DCHI`, `PHAI`, `LUONG`, `MA_NQL`, `PHG`) VALUES
('Lê', 'Quỳnh', 'Như', '001', '1967-02-01', '291 Hồ Văn Huệ, Tp HCM', 'Nữ', 30000, 6, 4),
('Trần', 'Thanh', 'Tâm', '003', '1957-05-04', '34 Mai Thị Lự, Tp HCM', 'Nam', 25000, 5, 5),
('Nguyễn', 'Mạnh', 'Hùng', '004', '1967-03-04', '95 Bà Rịa, Vũng Tàu', 'Nam', 38000, 5, 5),
('Nguyễn', 'Thanh', 'Tùng', '005', '1962-08-20', '222 Nguyễn Văn Cừ, Tp HCM', 'Nam', 40000, 6, 5),
('Phạm', 'Văn', 'Vinh', '006', '1965-01-01', '45 Hùng Vương, Hà Nội', 'Nữ', 55000, 0, 1),
('Bùi', 'Ngọc', 'Hằng', '007', '1954-03-11', '332 Nguyễn Thái Học, Tp HCM', 'Nữ', 25000, 1, 4),
('Trần', 'Hồng', 'Quang', '008', '1967-09-01', '80 Lê Hồng Phong, Tp HCM', 'Nam', 25000, 1, 4),
('Đinh', 'Bá', 'Tiến', '009', '1960-02-11', '119 Cổng Quỳnh, Tp HCM', 'Nam', 30000, 5, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phancong`
--

CREATE TABLE `phancong` (
  `MANV` char(9) NOT NULL DEFAULT '',
  `MADA` int(11) NOT NULL DEFAULT 0,
  `STT` int(11) NOT NULL DEFAULT 0,
  `THOIGIAN` decimal(5,1) NOT NULL DEFAULT 0.0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phancong`
--

INSERT INTO `phancong` (`MANV`, `MADA`, `STT`, `THOIGIAN`) VALUES
('009', 1, 1, '32.0'),
('009', 2, 2, '8.0'),
('004', 3, 1, '40.0'),
('003', 1, 2, '20.0'),
('003', 2, 1, '20.0'),
('008', 10, 1, '35.0'),
('008', 30, 2, '5.0'),
('001', 30, 1, '20.0'),
('001', 20, 1, '15.0'),
('006', 20, 1, '10.0'),
('005', 3, 1, '10.0'),
('005', 10, 2, '10.0'),
('005', 20, 1, '10.0'),
('007', 30, 2, '30.0'),
('007', 10, 2, '10.0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phongban`
--

CREATE TABLE `phongban` (
  `TENPHG` int(11) NOT NULL DEFAULT 0,
  `MAPHG` int(11) NOT NULL DEFAULT 0,
  `TRPHG` char(15) NOT NULL DEFAULT '',
  `NG_NHANCHUC` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phongban`
--

INSERT INTO `phongban` (`TENPHG`, `MAPHG`, `TRPHG`, `NG_NHANCHUC`) VALUES
(0, 1, '006', '1954-03-11'),
(0, 4, '008', '1962-08-20'),
(0, 5, '005', '1960-02-11');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thannhan`
--

CREATE TABLE `thannhan` (
  `MANV` char(9) NOT NULL DEFAULT '',
  `TENTN` char(15) NOT NULL DEFAULT '',
  `NGSINH` date NOT NULL,
  `PHAI` char(3) NOT NULL DEFAULT '',
  `QUANHE` char(15) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `thannhan`
--

INSERT INTO `thannhan` (`MANV`, `TENTN`, `NGSINH`, `PHAI`, `QUANHE`) VALUES
('005', 'Trinh', '0000-00-00', '197', 'Con gái'),
('005', 'Khang', '0000-00-00', '197', 'Con gái'),
('005', 'Phương', '0000-00-00', '194', 'Vợ chồng'),
('001', 'Minh', '0000-00-00', '193', 'Vợ chồng'),
('009', 'Tiến', '0000-00-00', '197', 'Con trai'),
('009', 'Châu', '0000-00-00', '197', 'Con trai'),
('009', 'Phương', '0000-00-00', '195', 'Vợ chồng');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `dean`
--
ALTER TABLE `dean`
  ADD PRIMARY KEY (`MADA`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Chỉ mục cho bảng `phongban`
--
ALTER TABLE `phongban`
  ADD PRIMARY KEY (`MAPHG`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
