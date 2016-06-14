use vangbacdaquy;

delimiter //

/*******************************************
* Table: CT_TONKHO
**********************************************/



create procedure CT_TONKHO_Ins (MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
insert into ct_tonkho ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA ) values ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA );
end//


create procedure CT_TONKHO_Upd (MACTP_TK INT, MAP_TK INT, MAHANG INT, TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
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
end//


create procedure CT_TONKHO_Del (MACTP_TK INT )
begin
delete from ct_tonkho 
where MACTP_TK = MACTP_TK;
end//


/*******************************************
* Table: CTP_BANHANG
**********************************************/



create procedure CTP_BANHANG_Ins (MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_banhang ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN ) values ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN );
end//


create procedure CTP_BANHANG_Upd (MACTP_BH INT, MAP_BH INT, MASP INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_banhang as a 
set 
a.MAP_BH = if(a.MAP_BH <> MAP_BH, MAP_BH, a.MAP_BH),
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_BH = MACTP_BH;
end//


create procedure CTP_BANHANG_Del (MACTP_BH INT )
begin
delete from ctp_banhang 
where MACTP_BH = MACTP_BH;
end//




/*******************************************
* Table: CTP_DICHVU
**********************************************/



create procedure CTP_DICHVU_Ins (MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_dichvu ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN ) values ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN );
end//


create procedure CTP_DICHVU_Upd (MACTP_DV INT, MAP_DV INT, MADV INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_dichvu as a 
set 
a.MAP_DV = if(a.MAP_DV <> MAP_DV, MAP_DV, a.MAP_DV),
a.MADV = if(a.MADV <> MADV, MADV, a.MADV),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_DV = MACTP_DV;
end//


create procedure CTP_DICHVU_Del (MACTP_DV INT )
begin
delete from ctp_dichvu 
where MACTP_DV = MACTP_DV;
end//

delimiter //
create procedure  CTP_DICHVU_getLastID(out maxId INT)
begin
select MACTP_DV into maxid
from ctp_dichvu
order by MACTP_DV desc
limit 1;
end//


/*******************************************
* Table: CTP_GIACONG
**********************************************/



create procedure CTP_GIACONG_Ins (MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_giacong ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN ) values ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN );
end//


create procedure CTP_GIACONG_Upd (MACTP_GC INT, MAP_GC INT, MALOAIGC INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_giacong as a 
set 
a.MAP_GC = if(a.MAP_GC <> MAP_GC, MAP_GC, a.MAP_GC),
a.MALOAIGC = if(a.MALOAIGC <> MALOAIGC, MALOAIGC, a.MALOAIGC),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_GC = MACTP_GC;
end//


create procedure CTP_GIACONG_Del (MACTP_GC INT )
begin
delete from ctp_giacong 
where MACTP_GC = MACTP_GC;
end//

delimiter //
create procedure  CTP_GIACONG_getLastID(out maxId INT)
begin
select MACTP_GC into maxid
from ctp_giacong
order by MACTP_GC desc
limit 1;
end//


/*******************************************
* Table: CTP_MUAHANG
**********************************************/



create procedure CTP_MUAHANG_Ins (MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_muahang ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN ) values ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN );
end//


create procedure CTP_MUAHANG_Upd (MACTP_MH INT, MASP INT, MAP_MH INT, SOLUONG int, THANHTIEN decimal )
begin
update ctp_muahang as a 
set 
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.MAP_MH = if(a.MAP_MH <> MAP_MH, MAP_MH, a.MAP_MH),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_MH = MACTP_MH;
end//


create procedure CTP_MUAHANG_Del (MACTP_MH INT )
begin
delete from ctp_muahang 
where MACTP_MH = MACTP_MH;
end//


/*******************************************
* Table: DICHVU
**********************************************/



create procedure DICHVU_Ins (MADV INT, TENDV varchar(30), DONGIA decimal )
begin
insert into dichvu ( MADV, TENDV, DONGIA ) values ( MADV, TENDV, DONGIA );
end//


create procedure DICHVU_Upd (MADV INT, TENDV varchar(30), DONGIA decimal )
begin
update dichvu as a 
set 
a.TENDV = if(a.TENDV <> TENDV, TENDV, a.TENDV),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MADV = MADV;
end//


create procedure DICHVU_Del (MADV INT )
begin
delete from dichvu 
where MADV = MADV;
end//


/*******************************************
* Table: HANGGIACONG
**********************************************/



create procedure HANGGIACONG_Ins (MALOAIGC INT, TENLOAIGC varchar(20), DONGIA decimal )
begin
insert into hanggiacong ( MALOAIGC, TENLOAIGC, DONGIA ) values ( MALOAIGC, TENLOAIGC, DONGIA );
end//


create procedure HANGGIACONG_Upd (MALOAIGC INT, TENLOAIGC varchar(20), DONGIA decimal )
begin
update hanggiacong as a 
set 
a.TENLOAIGC = if(a.TENLOAIGC <> TENLOAIGC, TENLOAIGC, a.TENLOAIGC),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MALOAIGC = MALOAIGC;
end//


create procedure HANGGIACONG_Del (MALOAIGC INT )
begin
delete from hanggiacong 
where MALOAIGC = MALOAIGC;
end//


/*******************************************
* Table: KHACHHANG
**********************************************/



create procedure KHACHHANG_Ins (MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
insert into khachhang ( MAKH, MANGUOI, LAKHACHQUEN ) values ( MAKH, MANGUOI, LAKHACHQUEN );
end//


create procedure KHACHHANG_Upd (MAKH INT, MANGUOI INT, LAKHACHQUEN tinyint )
begin
update khachhang as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI),
a.LAKHACHQUEN = if(a.LAKHACHQUEN <> LAKHACHQUEN, LAKHACHQUEN, a.LAKHACHQUEN)
where a.MAKH = MAKH;
end//


create procedure KHACHHANG_Del (MAKH INT )
begin
delete from khachhang 
where MAKH = MAKH;
end//

delimiter //
create procedure  KHACHHANG_getLastID(out maxId INT)
begin
select MAKH into maxid
from khachhang
order by MAKH desc
limit 1;
end//


/*******************************************
* Table: NGUOI
**********************************************/



create procedure NGUOI_Ins (MANGUOI INT, SHORTID int, HOTEN varchar(50), DIACHI varchar(200) )
begin
insert into nguoi ( MANGUOI, SHORTID, HOTEN, DIACHI ) values ( MANGUOI, SHORTID, HOTEN, DIACHI );
end//


create procedure NGUOI_Upd (MANGUOI INT, SHORTID int, HOTEN varchar(50), DIACHI varchar(200) )
begin
update nguoi as a 
set 
a.SHORTID = if(a.SHORTID <> SHORTID, SHORTID, a.SHORTID),
a.HOTEN = if(a.HOTEN <> HOTEN, HOTEN, a.HOTEN),
a.DIACHI = if(a.DIACHI <> DIACHI, DIACHI, a.DIACHI)
where a.MANGUOI = MANGUOI;
end//


create procedure NGUOI_Del (MANGUOI INT )
begin
delete from nguoi 
where MANGUOI = MANGUOI;
end//

delimiter //
create procedure  NGUOI_getLastID(out maxId INT)
begin
select MANGUOI into maxid
from nguoi
order by MANGUOI desc
limit 1;
end//


/*******************************************
* Table: P_BANHANG
**********************************************/



create procedure P_BANHANG_Ins (MAP_BH INT, MAP_THU INT )
begin
insert into p_banhang ( MAP_BH, MAP_THU ) values ( MAP_BH, MAP_THU );
end//


create procedure P_BANHANG_Upd (MAP_BH INT, MAP_THU INT )
begin
update p_banhang as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_BH = MAP_BH;
end//


create procedure P_BANHANG_Del (MAP_BH INT )
begin
delete from p_banhang 
where MAP_BH = MAP_BH;
end//


/*******************************************
* Table: P_CHI
**********************************************/
create procedure P_CHI_Ins (MAP_CHI INT, NGAYCHI timestamp, NOIDUNG varchar(300), SOTIENCHI decimal )
begin
insert into p_chi ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI ) values ( MAP_CHI, NGAYCHI,NOIDUNG, SOTIENCHI );
end//


create procedure P_CHI_Upd (MAP_CHI INT, NGAYCHI timestamp, NOIDUNG varchar(300),SOTIENCHI decimal )
begin
update p_chi as a 
set 
a.NGAYCHI = if(a.NGAYCHI <> NGAYCHI, NGAYCHI, a.NGAYCHI),
a.SOTIENCHI = if(a.SOTIENCHI <> SOTIENCHI, SOTIENCHI, a.SOTIENCHI),
a.NOIDUNG = if(a.NOIDUNG <> NOIDUNG, NOIDUNG, a.NOIDUNG)
where a.MAP_CHI = MAP_CHI;
end//


create procedure P_CHI_Del (MAP_CHI INT )
begin
delete from p_chi 
where MAP_CHI = MAP_CHI;
end//


/*******************************************
* Table: P_DICHVU
**********************************************/



create procedure P_DICHVU_Ins (MAP_DV INT, MAP_THU INT )
begin
insert into p_dichvu ( MAP_DV, MAP_THU ) values ( MAP_DV, MAP_THU );
end//


create procedure P_DICHVU_Upd (MAP_DV INT, MAP_THU INT )
begin
update p_dichvu as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_DV = MAP_DV;
end//


create procedure P_DICHVU_Del (MAP_DV INT )
begin
delete from p_dichvu 
where MAP_DV = MAP_DV;
end//

delimiter //
create procedure  P_DICHVU_getLastID(out maxId INT)
begin
select MAP_DV into maxid
from p_dichvu
order by MAP_DV desc
limit 1;
end//

/*******************************************
* Table: P_GIACONG
**********************************************/



create procedure P_GIACONG_Ins (MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into p_giacong ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG ) values ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG );
end//


create procedure P_GIACONG_Upd (MAP_GC INT, MATHOGC INT, NGAYNHANHANG timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update p_giacong as a 
set 
a.MATHOGC = if(a.MATHOGC <> MATHOGC, MATHOGC, a.MATHOGC),
a.NGAYNHANHANG = if(a.NGAYNHANHANG <> NGAYNHANHANG, NGAYNHANHANG, a.NGAYNHANHANG),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_GC = MAP_GC;
end//


create procedure P_GIACONG_Del (MAP_GC INT )
begin
delete from p_giacong 
where MAP_GC = MAP_GC;
end//

delimiter //
create procedure  P_GIACONG_getLastID(out maxId INT)
begin
select MAP_GC into maxid
from p_giacong
order by MAP_GC desc
limit 1;
end//


/*******************************************
* Table: P_MUAHANG
**********************************************/



create procedure P_MUAHANG_Ins (MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
insert into p_muahang ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG ) values ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG );
end//


create procedure P_MUAHANG_Upd (MAP_MH INT, MAKH INT, NGAYMUA timestamp, NGAYTHANHTOAN timestamp, TONGCONG decimal )
begin
update p_muahang as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYMUA = if(a.NGAYMUA <> NGAYMUA, NGAYMUA, a.NGAYMUA),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_MH = MAP_MH;
end//


create procedure P_MUAHANG_Del (MAP_MH INT )
begin
delete from p_muahang 
where MAP_MH = MAP_MH;
end//


/*******************************************
* Table: P_NO
**********************************************/



create procedure P_NO_Ins (MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
insert into p_no ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA ) values ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA );
end//


create procedure P_NO_Upd (MAP_NO INT, MAP_THU INT, NGAYNO timestamp, SOTIENNO decimal, NGAYTRA timestamp, SOTIENTRA decimal )
begin
update p_no as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU),
a.NGAYNO = if(a.NGAYNO <> NGAYNO, NGAYNO, a.NGAYNO),
a.SOTIENNO = if(a.SOTIENNO <> SOTIENNO, SOTIENNO, a.SOTIENNO),
a.NGAYTRA = if(a.NGAYTRA <> NGAYTRA, NGAYTRA, a.NGAYTRA),
a.SOTIENTRA = if(a.SOTIENTRA <> SOTIENTRA, SOTIENTRA, a.SOTIENTRA)
where a.MAP_NO = MAP_NO;
end//


create procedure P_NO_Del (MAP_NO INT )
begin
delete from p_no 
where MAP_NO = MAP_NO;
end//


/*******************************************
* Table: P_THU
**********************************************/



create procedure P_THU_Ins (MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
insert into p_thu ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG ) values ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG );
end//


create procedure P_THU_Upd (MAP_THU INT, MAKH INT, NGAYLAPPHIEU timestamp, NGAYKETTHUC timestamp, TONGCONG decimal )
begin
update p_thu as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYLAPPHIEU = if(a.NGAYLAPPHIEU <> NGAYLAPPHIEU, NGAYLAPPHIEU, a.NGAYLAPPHIEU),
a.NGAYKETTHUC = if(a.NGAYKETTHUC <> NGAYKETTHUC, NGAYKETTHUC, a.NGAYKETTHUC),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_THU = MAP_THU;
end//


create procedure P_THU_Del (MAP_THU INT )
begin
delete from p_thu 
where MAP_THU = MAP_THU;
end//

delimiter //
create procedure  P_THU_getLastID(out maxId INT)
begin
select MAP_THU into maxid
from p_thu
order by MAP_THU desc
limit 1;
end//


/*******************************************
* Table: SANPHAM
**********************************************/



create procedure SANPHAM_Ins (MASP INT, TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
insert into sanpham ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON ) values ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON );
end//


create procedure SANPHAM_Upd (MASP INT, TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
update sanpham as a 
set 
a.TENLOAISP = if(a.TENLOAISP <> TENLOAISP, TENLOAISP, a.TENLOAISP),
a.DONGIAMUA = if(a.DONGIAMUA <> DONGIAMUA, DONGIAMUA, a.DONGIAMUA),
a.DONGIABAN = if(a.DONGIABAN <> DONGIABAN, DONGIABAN, a.DONGIABAN),
a.SOLUONGTON = if(a.SOLUONGTON <> SOLUONGTON, SOLUONGTON, a.SOLUONGTON)
where a.MASP = MASP;
end//


create procedure SANPHAM_Del (MASP INT )
begin
delete from sanpham 
where MASP = MASP;
end//


/*******************************************
* Table: THOGIACONG
**********************************************/



create procedure THOGIACONG_Ins (MATHOGC INT, MANGUOI INT )
begin
insert into thogiacong ( MATHOGC, MANGUOI ) values ( MATHOGC, MANGUOI );
end//


create procedure THOGIACONG_Upd (MATHOGC INT, MANGUOI INT )
begin
update thogiacong as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI)
where a.MATHOGC = MATHOGC;
end//


create procedure THOGIACONG_Del (MATHOGC INT )
begin
delete from thogiacong 
where MATHOGC = MATHOGC;
end//


/*******************************************
* Table: TONKHO
**********************************************/



create procedure TONKHO_Ins (MAP_TK INT, NGAYBAOCAO timestamp )
begin
insert into tonkho ( MAP_TK, NGAYBAOCAO ) values ( MAP_TK, NGAYBAOCAO );
end//


create procedure TONKHO_Upd (MAP_TK INT, NGAYBAOCAO timestamp )
begin
update tonkho as a 
set 
a.NGAYBAOCAO = if(a.NGAYBAOCAO <> NGAYBAOCAO, NGAYBAOCAO, a.NGAYBAOCAO)
where a.MAP_TK = MAP_TK;
end//


create procedure TONKHO_Del (MAP_TK INT )
begin
delete from tonkho 
where MAP_TK = MAP_TK;
end//

/************************************************
* 	Nhật PROCEDURE
*************************************************/
/* 
	1. Lấy mã khách hàng, họ tên bởi mã phiếu bán khi đã tồn tại phiếu nợ.
*/
create procedure P_BanHang_getMaKHHoTenByMaP_BH(in maP_BH INT)
begin
select k.MAKH, n.HOTEN
from ((p_banhang as b inner join p_thu as t
    on t.MAP_THU = b.MAP_THU) inner join khachhang as k
    on t.makh = k.makh ) inner join nguoi as n
	on k.MANGUOI = n.MANGUOI
where b.map_bh = map_BH;
end//


/* 
	2. Lấy index cuối cùng của phiếu nợ
*/

create procedure  P_No_getLastID(out maxid INT)
begin
select MAP_NO into maxid
from p_no
order by MAP_NO desc
limit 1;
end//

/* 
	3. Lấy thông tin tiền còn lại, ngày thu
	3.1. Nếu phiếu thu đã lập => lấy theo bảng phiếu nợ
	3.2. Nếu phiếu thu chưa lập => kiểm tra , nếu là khách quen => cho lập
	3.3 1,2 ko thỏa => trả về conLao = 0, ngayLap = "0000-00-00
*/
create procedure  P_Thu_getLastConLaiNgayTraByMaP_Thu(in maKH INT, in maP_Thu INT,
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
end//


/* 
	4. Lấy mã phiếu thu bởi mã phiếu bán hàng
*/
create procedure P_BanHang_getMaP_ThuByMaP_BH(in maP_BH INT,out maP_Thu INT)
begin
select b.MAP_THU into maP_Thu
from p_banhang as b
where b.MAP_BH = maP_BH;
end//

/* tồn kho*/
/*
* 5.Lấy id cuối cùng của bảng tồn kho
*/
delimiter //
create procedure  TonKho_getLastRow()
begin
select *
from tonkho
order by Map_tk desc
limit 1;
end//

/*
* 6. Load tat cả sản phẩm 
*/
create procedure SanPham_getSanPham()
begin
select MaSP
from sanpham
order by MASP asc;
end//

/*
*  7. lấy sản phẩm, tồn cuối kỳ theo mã tồn kho trong bảng chi tiết tồn kho
*/
delimiter //
create procedure TonKho_getMaSPTonCuoiKyByMaTK(in MaTK INT)
begin
select t.MAHANG, t.TONCUOIKY
from ct_tonkho as t
where t.MAP_TK = maTK
order by t.MAHANG;
end//

/*
* 8. Lấy mã sản phẩm, tổng số lượng bán nhóm theo mã sản phẩm trong bảng ctp_banHang
1. từ ngày lập tồn kho gần nhất đến ngày lập tồn kho hiện tại, có bao nhiêu phiếu bán hàng được lập
2. Dựa vào số phiếu bán hàng này -> lấy maSP và tổng lượng bán của sản phẩm
*/
delimiter //
create procedure P_BanHang_getMaSPTongBan(in lastedNgayBC timestamp, in newNgayBC timestamp)
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
end//

/*
* 9. Lấy mã sản phẩm, tổng số lượng mua nhóm theo mã sản phẩm trong bảng ctp_muahang
1. từ ngày lập tồn kho gần nhất đến ngày lập tồn kho hiện tại, có bao nhiêu phiếu mua hàng được lập
2. Dựa vào số phiếu bán hàng này -> lấy maSP và tổng lượng mua của sản phẩm
*/
delimiter //
create procedure P_MuaHang_getMaSPTongMua(in lastedNgayBC timestamp, in newNgayBC timestamp)
begin

-- lấy maSP và tổng lượng bán
select masp, sum(soluong)
from ctp_muahang as c
where c.map_mh in (select distinct MAP_MH
					from p_muahang as m
					where m.ngayMua > lastedNgayBC and m.NGAYMUA <= newNgayBC)
 group by masp
order by masp asc;
end//

/*
* 20. Lấy id cuối cùng của bảng chi tiết tồn kho
*/
delimiter //
create procedure  CT_TonKho_getLastID(out maxID int)
begin
select MACTP_TK into maxID
from ct_tonkho
order by MACTP_TK desc
limit 1;
end//



/* Phiếu chi*/
/*
11. Lấy id cuối cùng của phiếu chi
*/
delimiter //
create procedure P_Chi_getLastID(out maxid INT)
begin
select MAP_CHI
into maxid
from p_chi
order by MAP_CHI desc
limit 1; 
end//

/***********************************************************************************/
/*********************** 		Hậu procedure 		  ******************************/
*			table:  SANPHAM
/***********************************************************************************/

/*
	Lấy Id cuối cùng của P_BANHANG
*/
delimiter //
create procedure  P_BANHANG_getLastID(out maxId INT)
begin
select MAP_BH into maxId
from P_BANHANG
order by MAP_BH desc
limit 1;
end//


/*
	Lấy Id cuối cùng của CTP_BANHANG
*/
delimiter //
create procedure  CTP_BANHANG_getLastID(out maxId INT)
begin
select MACTP_BH into maxId
from CTP_BANHANG
order by MACTP_BH desc
limit 1;
end//

/*
	Lấy Id cuôi cùng của P_MUAHANG
*/
delimiter //
create procedure P_MUAHANG_getLastID(out maxId INT)
begin
select MAP_MH into maxId
from P_MUAHANG
order by MAP_MH desc
limit 1;
end//

/*
	Lấy Id cuối cùng của CTP_MUAHANG
*/
delimiter //
create procedure CTP_MUAHANG_getLastID( out maxId INT )
begin
select MACTP_MH into maxId 
from CTP_MUAHANG
order by MACTP_MH desc
limit 1;
end//


delimiter ;


