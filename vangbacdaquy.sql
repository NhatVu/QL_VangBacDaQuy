-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2016 at 06:14 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vangbacdaquy`
--
CREATE DATABASE IF NOT EXISTS `vangbacdaquy` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `vangbacdaquy`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Del`(MACTP_BH INT )
begin
delete from ctp_banhang 
where MACTP_BH = MACTP_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_getLastID`(out maxId INT)
begin
select MACTP_BH into maxId
from CTP_BANHANG
order by MACTP_BH desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Ins`(MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_banhang ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN ) values ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_BANHANG_Upd`(MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_banhang as a 
set 
a.MAP_BH = if(a.MAP_BH <> MAP_BH, MAP_BH, a.MAP_BH),
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_BH = MACTP_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Del`(MACTP_DV INT )
begin
delete from ctp_dichvu 
where MACTP_DV = MACTP_DV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_getLastID`(out maxId INT)
begin
select MACTP_DV into maxid
from ctp_dichvu
order by MACTP_DV desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Ins`(MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_dichvu ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN ) values ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_DICHVU_Upd`(MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_dichvu as a 
set 
a.MAP_DV = if(a.MAP_DV <> MAP_DV, MAP_DV, a.MAP_DV),
a.MADV = if(a.MADV <> MADV, MADV, a.MADV),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_DV = MACTP_DV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Del`(MACTP_GC INT )
begin
delete from ctp_giacong 
where MACTP_GC = MACTP_GC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_getLastID`(out maxId INT)
begin
select MACTP_GC into maxid
from ctp_giacong
order by MACTP_GC desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Ins`(MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_giacong ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN ) values ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_GIACONG_Upd`(MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_giacong as a 
set 
a.MAP_GC = if(a.MAP_GC <> MAP_GC, MAP_GC, a.MAP_GC),
a.MALOAIGC = if(a.MALOAIGC <> MALOAIGC, MALOAIGC, a.MALOAIGC),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_GC = MACTP_GC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Del`(MACTP_MH INT )
begin
delete from ctp_muahang 
where MACTP_MH = MACTP_MH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_getLastID`( out maxId INT )
begin
select MACTP_MH into maxId 
from CTP_MUAHANG
order by MACTP_MH desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Ins`(MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_muahang ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN ) values ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CTP_MUAHANG_Upd`(MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_muahang as a 
set 
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.MAP_MH = if(a.MAP_MH <> MAP_MH, MAP_MH, a.MAP_MH),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_MH = MACTP_MH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Del`(MACTP_TK INT )
begin
delete from ct_tonkho 
where MACTP_TK = MACTP_TK;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TonKho_getLastID`(out maxID int)
begin
select MACTP_TK into maxID
from ct_tonkho
order by MACTP_TK desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Ins`(MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
insert into ct_tonkho ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA ) values ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CT_TONKHO_Upd`(MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
update ct_tonkho as a 
set 
a.MAP_TK = if(a.MAP_TK <> MAP_TK, MAP_TK, a.MAP_TK),
a.MAHANG = if(a.MAHANG <> MAHANG, MAHANG, a.MAHANG),
a.TONDAUKY = if(a.TONDAUKY <> TONDAUKY, TONDAUKY, a.TONDAUKY),
a.TONCUOIKY = if(a.TONCUOIKY <> TONCUOIKY, TONCUOIKY, a.TONCUOIKY),
a.SOLUONGBAN = if(a.SOLUONGBAN <> SOLUONGBAN, SOLUONGBAN, a.SOLUONGBAN),
a.SOLUONGMUA = if(a.SOLUONGMUA <> SOLUONGMUA, SOLUONGMUA, a.SOLUONGMUA)
where a.MACTP_TK = MACTP_TK;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Del`(MADV INT )
begin
delete from dichvu 
where MADV = MADV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Ins`(MADV INT, TENDV varchar(30), DONGIA decimal )
begin
insert into dichvu ( MADV, TENDV, DONGIA ) values ( MADV, TENDV, DONGIA );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DICHVU_Upd`(MADV INT, TENDV varchar(30), DONGIA decimal )
begin
update dichvu as a 
set 
a.TENDV = if(a.TENDV <> TENDV, TENDV, a.TENDV),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MADV = MADV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Del`(MALOAIGC INT )
begin
delete from hanggiacong 
where MALOAIGC = MALOAIGC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Ins`(MALOAIGC INT, TENLOAIGC varchar(20), DONGIA decimal )
begin
insert into hanggiacong ( MALOAIGC, TENLOAIGC, DONGIA ) values ( MALOAIGC, TENLOAIGC, DONGIA );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `HANGGIACONG_Upd`(MALOAIGC INT, TENLOAIGC varchar(20), DONGIA decimal )
begin
update hanggiacong as a 
set 
a.TENLOAIGC = if(a.TENLOAIGC <> TENLOAIGC, TENLOAIGC, a.TENLOAIGC),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MALOAIGC = MALOAIGC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Del`(MAKH INT )
begin
delete from khachhang 
where MAKH = MAKH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_getLastID`(out maxId INT)
begin
select MAKH into maxid
from khachhang
order by MAKH desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Ins`(MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
insert into khachhang ( MAKH, MANGUOI, LAKHACHQUEN ) values ( MAKH, MANGUOI, LAKHACHQUEN );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `KHACHHANG_Upd`(MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
update khachhang as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI),
a.LAKHACHQUEN = if(a.LAKHACHQUEN <> LAKHACHQUEN, LAKHACHQUEN, a.LAKHACHQUEN)
where a.MAKH = MAKH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Del`(MANGUOI INT )
begin
delete from nguoi 
where MANGUOI = MANGUOI;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_getLastID`(out maxId INT)
begin
select MANGUOI into maxid
from nguoi
order by MANGUOI desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Ins`(MANGUOI INT, SHORTID int, HOTEN varchar(50), DIACHI varchar(200) )
begin
insert into nguoi ( MANGUOI, SHORTID, HOTEN, DIACHI ) values ( MANGUOI, SHORTID, HOTEN, DIACHI );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `NGUOI_Upd`(MANGUOI INT, SHORTID int, HOTEN varchar(50), DIACHI varchar(200) )
begin
update nguoi as a 
set 
a.SHORTID = if(a.SHORTID <> SHORTID, SHORTID, a.SHORTID),
a.HOTEN = if(a.HOTEN <> HOTEN, HOTEN, a.HOTEN),
a.DIACHI = if(a.DIACHI <> DIACHI, DIACHI, a.DIACHI)
where a.MANGUOI = MANGUOI;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Del`(MAP_BH INT )
begin
delete from p_banhang 
where MAP_BH = MAP_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_getLastID`(out maxId INT)
begin
select MAP_BH into maxId
from P_BANHANG
order by MAP_BH desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaKHHoTenByMaP_BH`(in maP_BH INT)
begin
select k.MAKH, n.HOTEN
from ((p_banhang as b inner join p_thu as t
    on t.MAP_THU = b.MAP_THU) inner join khachhang as k
    on t.makh = k.makh ) inner join nguoi as n
	on k.MANGUOI = n.MANGUOI
where b.map_bh = map_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaP_ThuByMaP_BH`(in maP_BH INT,out maP_Thu INT)
begin
select b.MAP_THU into maP_Thu
from p_banhang as b
where b.MAP_BH = maP_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BanHang_getMaSPTongBan`(in lastedNgayBC timestamp, in newNgayBC timestamp)
begin

-- lấy maSP và tổng lượng bán
select masp, sum(soluong)
from ctp_banhang as c
where c.map_bh in (select distinct MAP_BH
					from p_banhang as b inner join p_thu as t
					on b.MAP_THU = t.map_thu
					where t.ngaylapphieu > lastedNgayBC and t.NGAYLAPPHIEU <= newNgayBC)
 group by masp
order by masp asc;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Ins`(MAP_BH INT, MAP_THU INT )
begin
insert into p_banhang ( MAP_BH, MAP_THU ) values ( MAP_BH, MAP_THU );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_BANHANG_Upd`(MAP_BH INT, MAP_THU INT )
begin
update p_banhang as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_BH = MAP_BH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Del`(MAP_CHI INT )
begin
delete from p_chi 
where MAP_CHI = MAP_CHI;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_Chi_getLastID`(out maxid INT)
begin
select MAP_CHI
into maxid
from p_chi
order by MAP_CHI desc
limit 1; 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Ins`(MAP_CHI INT, NGAYCHI timestamp, NOIDUNG varchar(300), SOTIENCHI decimal )
begin
insert into p_chi ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI ) values ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_CHI_Upd`(MAP_CHI INT, NGAYCHI timestamp, NOIDUNG varchar(300),SOTIENCHI decimal )
begin
update p_chi as a 
set 
a.NGAYCHI = if(a.NGAYCHI <> NGAYCHI, NGAYCHI, a.NGAYCHI),
a.SOTIENCHI = if(a.SOTIENCHI <> SOTIENCHI, SOTIENCHI, a.SOTIENCHI),
a.NOIDUNG = if(a.NOIDUNG <> NOIDUNG, NOIDUNG, a.NOIDUNG)
where a.MAP_CHI = MAP_CHI;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Del`(MAP_DV INT )
begin
delete from p_dichvu 
where MAP_DV = MAP_DV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_getLastID`(out maxId INT)
begin
select MAP_DV into maxid
from p_dichvu
order by MAP_DV desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Ins`(MAP_DV INT, MAP_THU INT )
begin
insert into p_dichvu ( MAP_DV, MAP_THU ) values ( MAP_DV, MAP_THU );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_DICHVU_Upd`(MAP_DV INT, MAP_THU INT )
begin
update p_dichvu as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_DV = MAP_DV;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Del`(MAP_GC INT )
begin
delete from p_giacong 
where MAP_GC = MAP_GC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_getLastID`(out maxId INT)
begin
select MAP_GC into maxid
from p_giacong
order by MAP_GC desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Ins`(MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into p_giacong ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG ) values ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GIACONG_Upd`(MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update p_giacong as a 
set 
a.MATHOGC = if(a.MATHOGC <> MATHOGC, MATHOGC, a.MATHOGC),
a.NGAYNHANHANG = if(a.NGAYNHANHANG <> NGAYNHANHANG, NGAYNHANHANG, a.NGAYNHANHANG),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_GC = MAP_GC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Del`(MAP_MH INT )
begin
delete from p_muahang 
where MAP_MH = MAP_MH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_getLastID`(out maxId INT)
begin
select MAP_MH into maxId
from P_MUAHANG
order by MAP_MH desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MuaHang_getMaSPTongMua`(in lastedNgayBC timestamp, in newNgayBC timestamp)
begin

-- lấy maSP và tổng lượng bán
select masp, sum(soluong)
from ctp_muahang as c
where c.map_mh in (select distinct MAP_MH
					from p_muahang as m
					where m.ngayMua > lastedNgayBC and m.NGAYMUA <= newNgayBC)
 group by masp
order by masp asc;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Ins`(MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into p_muahang ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG ) values ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_MUAHANG_Upd`(MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update p_muahang as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYMUA = if(a.NGAYMUA <> NGAYMUA, NGAYMUA, a.NGAYMUA),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_MH = MAP_MH;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Del`(MAP_NO INT )
begin
delete from p_no 
where MAP_NO = MAP_NO;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_No_getLastID`(out maxid INT)
begin
select MAP_NO into maxid
from p_no
order by MAP_NO desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Ins`(MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
insert into p_no ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA ) values ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_NO_Upd`(MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
update p_no as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU),
a.NGAYNO = if(a.NGAYNO <> NGAYNO, NGAYNO, a.NGAYNO),
a.SOTIENNO = if(a.SOTIENNO <> SOTIENNO, SOTIENNO, a.SOTIENNO),
a.NGAYTRA = if(a.NGAYTRA <> NGAYTRA, NGAYTRA, a.NGAYTRA),
a.SOTIENTRA = if(a.SOTIENTRA <> SOTIENTRA, SOTIENTRA, a.SOTIENTRA)
where a.MAP_NO = MAP_NO;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Del`(MAP_THU INT )
begin
delete from p_thu 
where MAP_THU = MAP_THU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_Thu_getLastConLaiNgayTraByMaP_Thu`(in maKH INT, in maP_Thu INT,
out conLai decimal(20,3), out ngayTra timestamp)
begin
declare checkKhachquen bool;
set conlai = 0;
 set ngayTra = '1970-01-02 00:00:00';
-- nếu phiếu nợ đã tồn tại

select (SOTIENNO - SOTIENTRA), n.NGAYTRA
into conlai, ngayTra
from p_no as n
where n.map_thu = maP_Thu
order by MAP_NO desc
limit 1;
-- nếu phiếu nợ chưa tồn tại
if(conlai = 0 and ngayTra = '1970-01-02 00:00:00')
then
select laKhachQuen into checkKhachquen
from khachhang as k
where k.makh = maKH;
-- nếu là khách quen
if (checkKhachquen = 1)
then
select tongcong, Ngaylapphieu into conlai, ngayTra
from p_thu as t
where t.map_thu = maP_Thu;
end if;
end if;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_getLastID`(out maxId INT)
begin
select MAP_THU into maxid
from p_thu
order by MAP_THU desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Ins`(MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
insert into p_thu ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG ) values ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_THU_Upd`(MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
update p_thu as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYLAPPHIEU = if(a.NGAYLAPPHIEU <> NGAYLAPPHIEU, NGAYLAPPHIEU, a.NGAYLAPPHIEU),
a.NGAYKETTHUC = if(a.NGAYKETTHUC <> NGAYKETTHUC, NGAYKETTHUC, a.NGAYKETTHUC),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_THU = MAP_THU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Del`(MASP INT )
begin
delete from sanpham 
where MASP = MASP;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SanPham_getSanPham`()
begin
select MaSP
from sanpham
order by MASP asc;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Ins`(MASP INT, TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
insert into sanpham ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON ) values ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SANPHAM_Upd`(MASP INT, TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
update sanpham as a 
set 
a.TENLOAISP = if(a.TENLOAISP <> TENLOAISP, TENLOAISP, a.TENLOAISP),
a.DONGIAMUA = if(a.DONGIAMUA <> DONGIAMUA, DONGIAMUA, a.DONGIAMUA),
a.DONGIABAN = if(a.DONGIABAN <> DONGIABAN, DONGIABAN, a.DONGIABAN),
a.SOLUONGTON = if(a.SOLUONGTON <> SOLUONGTON, SOLUONGTON, a.SOLUONGTON)
where a.MASP = MASP;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Del`(MATHOGC INT )
begin
delete from thogiacong 
where MATHOGC = MATHOGC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Ins`(MATHOGC INT, MANGUOI INT )
begin
insert into thogiacong ( MATHOGC, MANGUOI ) values ( MATHOGC, MANGUOI );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `THOGIACONG_Upd`(MATHOGC INT, MANGUOI INT )
begin
update thogiacong as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI)
where a.MATHOGC = MATHOGC;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Del`(MAP_TK INT )
begin
delete from tonkho 
where MAP_TK = MAP_TK;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TonKho_getLastRow`()
begin
select *
from tonkho
order by Map_tk desc
limit 1;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TonKho_getMaSPTonCuoiKyByMaTK`(in MaTK INT)
begin
select t.MAHANG, t.TONCUOIKY
from ct_tonkho as t
where t.MAP_TK = maTK
order by t.MAHANG;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Ins`(MAP_TK INT, NGAYBAOCAO timestamp )
begin
insert into tonkho ( MAP_TK, NGAYBAOCAO ) values ( MAP_TK, NGAYBAOCAO );
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TONKHO_Upd`(MAP_TK INT, NGAYBAOCAO timestamp )
begin
update tonkho as a 
set 
a.NGAYBAOCAO = if(a.NGAYBAOCAO <> NGAYBAOCAO, NGAYBAOCAO, a.NGAYBAOCAO)
where a.MAP_TK = MAP_TK;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `ctp_banhang`
--

CREATE TABLE IF NOT EXISTS `ctp_banhang` (
  `MACTP_BH` int(11) NOT NULL,
  `MAP_BH` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ctp_banhang`
--

INSERT INTO `ctp_banhang` (`MACTP_BH`, `MAP_BH`, `MASP`, `SOLUONG`, `THANHTIEN`) VALUES
(1, 1, 1, 2, '30000.000'),
(2, 1, 3, 1, '5000.000'),
(3, 2, 2, 2, '6000.000'),
(4, 2, 1, 2, '30000.000');

-- --------------------------------------------------------

--
-- Table structure for table `ctp_dichvu`
--

CREATE TABLE IF NOT EXISTS `ctp_dichvu` (
  `MACTP_DV` int(11) NOT NULL,
  `MAP_DV` int(11) NOT NULL,
  `MADV` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ctp_giacong`
--

CREATE TABLE IF NOT EXISTS `ctp_giacong` (
  `MACTP_GC` int(11) NOT NULL,
  `MAP_GC` int(11) NOT NULL,
  `MALOAIGC` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ctp_muahang`
--

CREATE TABLE IF NOT EXISTS `ctp_muahang` (
  `MACTP_MH` int(11) NOT NULL,
  `MAP_MH` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `THANHTIEN` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ctp_muahang`
--

INSERT INTO `ctp_muahang` (`MACTP_MH`, `MAP_MH`, `MASP`, `SOLUONG`, `THANHTIEN`) VALUES
(1, 1, 2, 2, '40000.000'),
(2, 2, 3, 5, '50000.000');

-- --------------------------------------------------------

--
-- Table structure for table `ct_tonkho`
--

CREATE TABLE IF NOT EXISTS `ct_tonkho` (
  `MACTP_TK` int(11) NOT NULL,
  `MAP_TK` int(11) NOT NULL,
  `MAHANG` int(11) NOT NULL,
  `TONDAUKY` int(11) DEFAULT NULL,
  `TONCUOIKY` int(11) DEFAULT NULL,
  `SOLUONGBAN` int(11) DEFAULT NULL,
  `SOLUONGMUA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dichvu`
--

CREATE TABLE IF NOT EXISTS `dichvu` (
  `MADV` int(11) NOT NULL,
  `TENDV` varchar(30) DEFAULT NULL,
  `DONGIA` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dichvu`
--

INSERT INTO `dichvu` (`MADV`, `TENDV`, `DONGIA`) VALUES
(1, 'Can trang suc', '100000.000'),
(2, 'Doi tien', '200000.000'),
(3, 'Ma trang suc', '30000.000');

-- --------------------------------------------------------

--
-- Table structure for table `hanggiacong`
--

CREATE TABLE IF NOT EXISTS `hanggiacong` (
  `MALOAIGC` int(11) NOT NULL,
  `TENLOAIGC` varchar(50) DEFAULT NULL,
  `DONGIA` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hanggiacong`
--

INSERT INTO `hanggiacong` (`MALOAIGC`, `TENLOAIGC`, `DONGIA`) VALUES
(1, 'Gia cong nhan', '100000.000'),
(2, 'Gia cong bong tai', '200000.000'),
(3, 'Gia cong vong', '30000.000');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE IF NOT EXISTS `khachhang` (
  `MAKH` int(11) NOT NULL,
  `MANGUOI` int(11) NOT NULL,
  `LAKHACHQUEN` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `MANGUOI`, `LAKHACHQUEN`) VALUES
(1, 3, 0),
(2, 1, 1),
(3, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `nguoi`
--

CREATE TABLE IF NOT EXISTS `nguoi` (
  `MANGUOI` int(11) NOT NULL,
  `SHORTID` int(11) DEFAULT NULL,
  `HOTEN` varchar(20) DEFAULT NULL,
  `DIACHI` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nguoi`
--

INSERT INTO `nguoi` (`MANGUOI`, `SHORTID`, `HOTEN`, `DIACHI`) VALUES
(1, 123456789, 'Nguyen Hoang Phat', '135 Nguyen XXX YYYY'),
(2, 12345678, 'Nguyen Hoang Minh', '252 Duong AAA Pho BBB'),
(3, 12345677, 'Nguyen Hoang Tuan', '252 Duong CCC Pho DDD'),
(4, 123456780, 'Vu Minh Nhat', '125 Vu XXX YYYY');

-- --------------------------------------------------------

--
-- Table structure for table `p_banhang`
--

CREATE TABLE IF NOT EXISTS `p_banhang` (
  `MAP_BH` int(11) NOT NULL,
  `MAP_THU` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_banhang`
--

INSERT INTO `p_banhang` (`MAP_BH`, `MAP_THU`) VALUES
(1, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `p_chi`
--

CREATE TABLE IF NOT EXISTS `p_chi` (
  `MAP_CHI` int(11) NOT NULL,
  `NGAYCHI` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NOIDUNG` varchar(300) DEFAULT NULL,
  `SOTIENCHI` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `p_dichvu`
--

CREATE TABLE IF NOT EXISTS `p_dichvu` (
  `MAP_DV` int(11) NOT NULL,
  `MAP_THU` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `p_giacong`
--

CREATE TABLE IF NOT EXISTS `p_giacong` (
  `MAP_GC` int(11) NOT NULL,
  `MATHOGC` int(11) NOT NULL,
  `NGAYNHANHANG` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYTHANHTOAN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `p_muahang`
--

CREATE TABLE IF NOT EXISTS `p_muahang` (
  `MAP_MH` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `NGAYMUA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYTHANHTOAN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_muahang`
--

INSERT INTO `p_muahang` (`MAP_MH`, `MAKH`, `NGAYMUA`, `NGAYTHANHTOAN`, `TONGCONG`) VALUES
(1, 1, '2016-05-19 17:00:00', '2016-05-19 17:00:00', '30000.000'),
(2, 2, '2016-05-20 17:00:00', '2016-05-21 17:00:00', '40000.000');

-- --------------------------------------------------------

--
-- Table structure for table `p_no`
--

CREATE TABLE IF NOT EXISTS `p_no` (
  `MAP_NO` int(11) NOT NULL,
  `MAP_THU` int(11) DEFAULT NULL,
  `NGAYNO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SOTIENNO` decimal(10,3) DEFAULT NULL,
  `NGAYTRA` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SOTIENTRA` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_no`
--

INSERT INTO `p_no` (`MAP_NO`, `MAP_THU`, `NGAYNO`, `SOTIENNO`, `NGAYTRA`, `SOTIENTRA`) VALUES
(1, 3, '2016-05-19 17:00:00', '10000.000', '2016-05-21 17:00:00', '1000.000'),
(2, 3, '2016-05-21 17:00:00', '9000.000', '2016-05-22 17:00:00', '1000.000');

-- --------------------------------------------------------

--
-- Table structure for table `p_thu`
--

CREATE TABLE IF NOT EXISTS `p_thu` (
  `MAP_THU` int(11) NOT NULL,
  `MAKH` int(11) NOT NULL,
  `NGAYLAPPHIEU` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `NGAYKETTHUC` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `TONGCONG` decimal(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_thu`
--

INSERT INTO `p_thu` (`MAP_THU`, `MAKH`, `NGAYLAPPHIEU`, `NGAYKETTHUC`, `TONGCONG`) VALUES
(1, 1, '2016-05-19 17:00:00', '2016-05-20 17:00:00', '20000.000'),
(2, 3, '2016-05-19 17:00:00', '2016-05-20 17:00:00', '30000.000'),
(3, 2, '2016-05-19 17:00:00', '2016-05-20 17:00:00', '10000.000');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE IF NOT EXISTS `sanpham` (
  `MASP` int(11) NOT NULL,
  `TENLOAISP` varchar(30) DEFAULT NULL,
  `DONGIAMUA` decimal(10,3) DEFAULT NULL,
  `DONGIABAN` decimal(10,3) DEFAULT NULL,
  `SOLUONGTON` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENLOAISP`, `DONGIAMUA`, `DONGIABAN`, `SOLUONGTON`) VALUES
(1, 'Vàng', '10000.000', '15000.000', 12),
(2, 'B?c', '2000.000', '3000.000', 5),
(3, '?á quý', '4000.000', '5000.000', 10);

-- --------------------------------------------------------

--
-- Table structure for table `thogiacong`
--

CREATE TABLE IF NOT EXISTS `thogiacong` (
  `MATHOGC` int(11) NOT NULL,
  `MANGUOI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `thogiacong`
--

INSERT INTO `thogiacong` (`MATHOGC`, `MANGUOI`) VALUES
(1, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `tonkho`
--

CREATE TABLE IF NOT EXISTS `tonkho` (
  `MAP_TK` int(11) NOT NULL,
  `NGAYBAOCAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctp_banhang`
--
ALTER TABLE `ctp_banhang`
  ADD PRIMARY KEY (`MACTP_BH`),
  ADD KEY `FK_CTP_BANHANG` (`MASP`),
  ADD KEY `FK_CTP_BANHANG2` (`MAP_BH`);

--
-- Indexes for table `ctp_dichvu`
--
ALTER TABLE `ctp_dichvu`
  ADD PRIMARY KEY (`MACTP_DV`),
  ADD KEY `FK_CTP_DICHVU` (`MADV`),
  ADD KEY `FK_CTP_DICHVU2` (`MAP_DV`);

--
-- Indexes for table `ctp_giacong`
--
ALTER TABLE `ctp_giacong`
  ADD PRIMARY KEY (`MACTP_GC`),
  ADD KEY `FK_CTP_GIACONG` (`MALOAIGC`),
  ADD KEY `FK_CTP_GIACONG2` (`MAP_GC`);

--
-- Indexes for table `ctp_muahang`
--
ALTER TABLE `ctp_muahang`
  ADD PRIMARY KEY (`MACTP_MH`),
  ADD KEY `FK_CTP_MUAHANG` (`MAP_MH`),
  ADD KEY `FK_CTP_MUAHANG2` (`MASP`);

--
-- Indexes for table `ct_tonkho`
--
ALTER TABLE `ct_tonkho`
  ADD PRIMARY KEY (`MACTP_TK`),
  ADD KEY `FK_BAOGOM` (`MAP_TK`);

--
-- Indexes for table `dichvu`
--
ALTER TABLE `dichvu`
  ADD PRIMARY KEY (`MADV`);

--
-- Indexes for table `hanggiacong`
--
ALTER TABLE `hanggiacong`
  ADD PRIMARY KEY (`MALOAIGC`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`),
  ADD KEY `FK_LANGUOI1` (`MANGUOI`);

--
-- Indexes for table `nguoi`
--
ALTER TABLE `nguoi`
  ADD PRIMARY KEY (`MANGUOI`);

--
-- Indexes for table `p_banhang`
--
ALTER TABLE `p_banhang`
  ADD PRIMARY KEY (`MAP_BH`),
  ADD KEY `FK_BANHANG` (`MAP_THU`);

--
-- Indexes for table `p_chi`
--
ALTER TABLE `p_chi`
  ADD PRIMARY KEY (`MAP_CHI`);

--
-- Indexes for table `p_dichvu`
--
ALTER TABLE `p_dichvu`
  ADD PRIMARY KEY (`MAP_DV`),
  ADD KEY `FK_CUNGCAPDICHVU` (`MAP_THU`);

--
-- Indexes for table `p_giacong`
--
ALTER TABLE `p_giacong`
  ADD PRIMARY KEY (`MAP_GC`),
  ADD KEY `FK_GIACONG` (`MATHOGC`);

--
-- Indexes for table `p_muahang`
--
ALTER TABLE `p_muahang`
  ADD PRIMARY KEY (`MAP_MH`),
  ADD KEY `FK_MUAHANG` (`MAKH`);

--
-- Indexes for table `p_no`
--
ALTER TABLE `p_no`
  ADD PRIMARY KEY (`MAP_NO`),
  ADD KEY `FK_NO` (`MAP_THU`);

--
-- Indexes for table `p_thu`
--
ALTER TABLE `p_thu`
  ADD PRIMARY KEY (`MAP_THU`),
  ADD KEY `FK_THUTIEN` (`MAKH`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`);

--
-- Indexes for table `thogiacong`
--
ALTER TABLE `thogiacong`
  ADD PRIMARY KEY (`MATHOGC`),
  ADD KEY `FK_LANGUOI2` (`MANGUOI`);

--
-- Indexes for table `tonkho`
--
ALTER TABLE `tonkho`
  ADD PRIMARY KEY (`MAP_TK`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctp_banhang`
--
ALTER TABLE `ctp_banhang`
  ADD CONSTRAINT `FK_CTP_BANHANG` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `FK_CTP_BANHANG2` FOREIGN KEY (`MAP_BH`) REFERENCES `p_banhang` (`MAP_BH`);

--
-- Constraints for table `ctp_dichvu`
--
ALTER TABLE `ctp_dichvu`
  ADD CONSTRAINT `FK_CTP_DICHVU` FOREIGN KEY (`MADV`) REFERENCES `dichvu` (`MADV`),
  ADD CONSTRAINT `FK_CTP_DICHVU2` FOREIGN KEY (`MAP_DV`) REFERENCES `p_dichvu` (`MAP_DV`);

--
-- Constraints for table `ctp_giacong`
--
ALTER TABLE `ctp_giacong`
  ADD CONSTRAINT `FK_CTP_GIACONG` FOREIGN KEY (`MALOAIGC`) REFERENCES `hanggiacong` (`MALOAIGC`),
  ADD CONSTRAINT `FK_CTP_GIACONG2` FOREIGN KEY (`MAP_GC`) REFERENCES `p_giacong` (`MAP_GC`);

--
-- Constraints for table `ctp_muahang`
--
ALTER TABLE `ctp_muahang`
  ADD CONSTRAINT `FK_CTP_MUAHANG` FOREIGN KEY (`MAP_MH`) REFERENCES `p_muahang` (`MAP_MH`),
  ADD CONSTRAINT `FK_CTP_MUAHANG2` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Constraints for table `ct_tonkho`
--
ALTER TABLE `ct_tonkho`
  ADD CONSTRAINT `FK_BAOGOM` FOREIGN KEY (`MAP_TK`) REFERENCES `tonkho` (`MAP_TK`);

--
-- Constraints for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD CONSTRAINT `FK_LANGUOI1` FOREIGN KEY (`MANGUOI`) REFERENCES `nguoi` (`MANGUOI`);

--
-- Constraints for table `p_banhang`
--
ALTER TABLE `p_banhang`
  ADD CONSTRAINT `FK_BANHANG` FOREIGN KEY (`MAP_THU`) REFERENCES `p_thu` (`MAP_THU`);

--
-- Constraints for table `p_dichvu`
--
ALTER TABLE `p_dichvu`
  ADD CONSTRAINT `FK_CUNGCAPDICHVU` FOREIGN KEY (`MAP_THU`) REFERENCES `p_thu` (`MAP_THU`);

--
-- Constraints for table `p_giacong`
--
ALTER TABLE `p_giacong`
  ADD CONSTRAINT `FK_GIACONG` FOREIGN KEY (`MATHOGC`) REFERENCES `thogiacong` (`MATHOGC`);

--
-- Constraints for table `p_muahang`
--
ALTER TABLE `p_muahang`
  ADD CONSTRAINT `FK_MUAHANG` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`);

--
-- Constraints for table `p_no`
--
ALTER TABLE `p_no`
  ADD CONSTRAINT `FK_NO` FOREIGN KEY (`MAP_THU`) REFERENCES `p_thu` (`MAP_THU`);

--
-- Constraints for table `p_thu`
--
ALTER TABLE `p_thu`
  ADD CONSTRAINT `FK_THUTIEN` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`);

--
-- Constraints for table `thogiacong`
--
ALTER TABLE `thogiacong`
  ADD CONSTRAINT `FK_LANGUOI2` FOREIGN KEY (`MANGUOI`) REFERENCES `nguoi` (`MANGUOI`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
