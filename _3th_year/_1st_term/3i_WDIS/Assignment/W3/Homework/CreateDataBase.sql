CREATE DATABASE Aviation_Database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE CHUYENBAY (
  -- Mô tả về thông tin chuyến bay
  MaCB CHAR(5) NOT NULL,
  GaDi VARCHAR(50) NOT NULL,
  GaDen VARCHAR(50) NOT NULL,
  DoDai INT NOT NULL,
  GioDi TIME NOT NULL,
  GioDen TIME NOT NULL,
  ChiPhi INT NOT NULL,

  PRIMARY KEY (MaCB)
);

CREATE TABLE MAYBAY(
  -- Mô tả thông tin máy bay
  MaMB INT NOT NULL,
  Loai VARCHAR(50) NOT NULL,
  TamBay INT NOT NULL,

  PRIMARY KEY (MaMB)
);

CREATE TABLE NHANVIEN(
  -- Mô tả thông tin nhân vien
  MaNV CHAR(9) NOT NULL,
  Ten VARCHAR(50) NOT NULL,
  Luong INT NOT NULL,

  PRIMARY KEY (MaNV)
);

CREATE TABLE CHUNGNHAN(
  -- Mô tả tin chứng nhận lái máy bay của phi công
  MaNV CHAR(9) NOT NULL,
  MaMB INT NOT NULL,

  PRIMARY KEY (MaNV, MaMB)
)
