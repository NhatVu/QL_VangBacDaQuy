delimiter //

/*******************************************
* Table: CT_TONKHO
**********************************************/



create procedure CT_TONKHO_Ins (MACTP_TK varchar(10), MAP_TK varchar(10), MAHANG varchar(10), TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
begin
insert into ct_tonkho ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA ) values ( MACTP_TK, MAP_TK, MAHANG, TONDAUKY, TONCUOIKY, SOLUONGBAN, SOLUONGMUA );
end//

create procedure CT_TONKHO_Upd (MACTP_TK varchar(10), MAP_TK varchar(10), MAHANG varchar(10), TONDAUKY int, TONCUOIKY int, SOLUONGBAN int, SOLUONGMUA int )
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

create procedure CT_TONKHO_Del (MACTP_TK varchar(10) )
begin
delete from ct_tonkho 
where MACTP_TK = MACTP_TK;
end//


/*****************************CTP_BANHANG_DelCTP_BANHANG_InsCTP_BANHANG_Ins**************
* Table: CTP_BANHANG
**********************************************/



create procedure CTP_BANHANG_Ins (MACTP_BH varchar(10), MAP_BH varchar(10), MASP varchar(10), SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_banhang ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN ) values ( MACTP_BH, MAP_BH, MASP, SOLUONG, THANHTIEN );
end//


create procedure CTP_BANHANG_Upd (MACTP_BH varchar(10), MAP_BH varchar(10), MASP varchar(10), SOLUONG int, THANHTIEN decimal )
begin
update ctp_banhang as a 
set 
a.MAP_BH = if(a.MAP_BH <> MAP_BH, MAP_BH, a.MAP_BH),
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_BH = MACTP_BH;
end//

create procedure CTP_BANHANG_Del (MACTP_BH varchar(10) )
begin
delete from ctp_banhang 
where MACTP_BH = MACTP_BH;
end//


/*******************************************
* Table: CTP_CHI
**********************************************/



create procedure CTP_CHI_Ins (MACTP_CHI varchar(10), MAP_CHI varchar(10), MAPHI varchar(10), TENPHI varchar(30), THANHTIEN decimal )
begin
insert into ctp_chi ( MACTP_CHI, MAP_CHI, MAPHI, TENPHI, THANHTIEN ) values ( MACTP_CHI, MAP_CHI, MAPHI, TENPHI, THANHTIEN );
end//


create procedure CTP_CHI_Upd (MACTP_CHI varchar(10), MAP_CHI varchar(10), MAPHI varchar(10), TENPHI varchar(30), THANHTIEN decimal )
begin
update ctp_chi as a 
set 
a.MAP_CHI = if(a.MAP_CHI <> MAP_CHI, MAP_CHI, a.MAP_CHI),
a.MAPHI = if(a.MAPHI <> MAPHI, MAPHI, a.MAPHI),
a.TENPHI = if(a.TENPHI <> TENPHI, TENPHI, a.TENPHI),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_CHI = MACTP_CHI;
end//


create procedure CTP_CHI_Del (MACTP_CHI varchar(10) )
begin
delete from ctp_chi 
where MACTP_CHI = MACTP_CHI;
end//


/*******************************************
* Table: CTP_DICHVU
**********************************************/



create procedure CTP_DICHVU_Ins (MACTP_DV varchar(10), MAP_DV varchar(10), MADV varchar(10), SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_dichvu ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN ) values ( MACTP_DV, MAP_DV, MADV, SOLUONG, THANHTIEN );
end//


create procedure CTP_DICHVU_Upd (MACTP_DV varchar(10), MAP_DV varchar(10), MADV varchar(10), SOLUONG int, THANHTIEN decimal )
begin
update ctp_dichvu as a 
set 
a.MAP_DV = if(a.MAP_DV <> MAP_DV, MAP_DV, a.MAP_DV),
a.MADV = if(a.MADV <> MADV, MADV, a.MADV),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_DV = MACTP_DV;
end//


create procedure CTP_DICHVU_Del (MACTP_DV varchar(10) )
begin
delete from ctp_dichvu 
where MACTP_DV = MACTP_DV;
end//


/*******************************************
* Table: CTP_GIACONG
**********************************************/



create procedure CTP_GIACONG_Ins (MACTP_GC varchar(10), MAP_GC varchar(10), MALOAIGC varchar(10), SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_giacong ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN ) values ( MACTP_GC, MAP_GC, MALOAIGC, SOLUONG, THANHTIEN );
end//


create procedure CTP_GIACONG_Upd (MACTP_GC varchar(10), MAP_GC varchar(10), MALOAIGC varchar(10), SOLUONG int, THANHTIEN decimal )
begin
update ctp_giacong as a 
set 
a.MAP_GC = if(a.MAP_GC <> MAP_GC, MAP_GC, a.MAP_GC),
a.MALOAIGC = if(a.MALOAIGC <> MALOAIGC, MALOAIGC, a.MALOAIGC),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_GC = MACTP_GC;
end//


create procedure CTP_GIACONG_Del (MACTP_GC varchar(10) )
begin
delete from ctp_giacong 
where MACTP_GC = MACTP_GC;
end//


/*******************************************
* Table: CTP_MUAHANG
**********************************************/



create procedure CTP_MUAHANG_Ins (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10), SOLUONG int, THANHTIEN decimal )
begin
insert into ctp_muahang ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN ) values ( MACTP_MH, MASP, MAP_MH, SOLUONG, THANHTIEN );
end//


create procedure CTP_MUAHANG_Upd (MACTP_MH varchar(10), MASP varchar(10), MAP_MH varchar(10), SOLUONG int, THANHTIEN decimal )
begin
update ctp_muahang as a 
set 
a.MASP = if(a.MASP <> MASP, MASP, a.MASP),
a.MAP_MH = if(a.MAP_MH <> MAP_MH, MAP_MH, a.MAP_MH),
a.SOLUONG = if(a.SOLUONG <> SOLUONG, SOLUONG, a.SOLUONG),
a.THANHTIEN = if(a.THANHTIEN <> THANHTIEN, THANHTIEN, a.THANHTIEN)
where a.MACTP_MH = MACTP_MH;
end//


create procedure CTP_MUAHANG_Del (MACTP_MH varchar(10) )
begin
delete from ctp_muahang 
where MACTP_MH = MACTP_MH;
end//


/*******************************************
* Table: DICHVU
**********************************************/



create procedure DICHVU_Ins (MADV varchar(10), TENDV varchar(30), DONGIA decimal )
begin
insert into dichvu ( MADV, TENDV, DONGIA ) values ( MADV, TENDV, DONGIA );
end//


create procedure DICHVU_Upd (MADV varchar(10), TENDV varchar(30), DONGIA decimal )
begin
update dichvu as a 
set 
a.TENDV = if(a.TENDV <> TENDV, TENDV, a.TENDV),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MADV = MADV;
end//


create procedure DICHVU_Del (MADV varchar(10) )
begin
delete from dichvu 
where MADV = MADV;
end//


/*******************************************
* Table: HANGGIACONG
**********************************************/



create procedure HANGGIACONG_Ins (MALOAIGC varchar(10), TENLOAGC varchar(20), DONGIA decimal )
begin
insert into hanggiacong ( MALOAIGC, TENLOAGC, DONGIA ) values ( MALOAIGC, TENLOAGC, DONGIA );
end//


create procedure HANGGIACONG_Upd (MALOAIGC varchar(10), TENLOAGC varchar(20), DONGIA decimal )
begin
update hanggiacong as a 
set 
a.TENLOAGC = if(a.TENLOAGC <> TENLOAGC, TENLOAGC, a.TENLOAGC),
a.DONGIA = if(a.DONGIA <> DONGIA, DONGIA, a.DONGIA)
where a.MALOAIGC = MALOAIGC;
end//


create procedure HANGGIACONG_Del (MALOAIGC varchar(10) )
begin
delete from hanggiacong 
where MALOAIGC = MALOAIGC;
end//


/*******************************************
* Table: KHACHHANG
**********************************************/



create procedure KHACHHANG_Ins (MAKH varchar(10), MANGUOI varchar(10), LAKHACHQUEN tinyint )
begin
insert into khachhang ( MAKH, MANGUOI, LAKHACHQUEN ) values ( MAKH, MANGUOI, LAKHACHQUEN );
end//


create procedure KHACHHANG_Upd (MAKH varchar(10), MANGUOI varchar(10), LAKHACHQUEN tinyint )
begin
update khachhang as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI),
a.LAKHACHQUEN = if(a.LAKHACHQUEN <> LAKHACHQUEN, LAKHACHQUEN, a.LAKHACHQUEN)
where a.MAKH = MAKH;
end//


create procedure KHACHHANG_Del (MAKH varchar(10) )
begin
delete from khachhang 
where MAKH = MAKH;
end//


/*******************************************
* Table: NGUOI
**********************************************/



create procedure NGUOI_Ins (MANGUOI varchar(10), HOTEN varchar(50), DIACHI varchar(100) )
begin
insert into nguoi ( MANGUOI, HOTEN, DIACHI ) values ( MANGUOI, HOTEN, DIACHI );
end//


create procedure NGUOI_Upd (MANGUOI varchar(10), HOTEN varchar(50), DIACHI varchar(100) )
begin
update nguoi as a 
set 
a.HOTEN = if(a.HOTEN <> HOTEN, HOTEN, a.HOTEN),
a.DIACHI = if(a.DIACHI <> DIACHI, DIACHI, a.DIACHI)
where a.MANGUOI = MANGUOI;
end//


create procedure NGUOI_Del (MANGUOI varchar(10) )
begin
delete from nguoi 
where MANGUOI = MANGUOI;
end//


/*******************************************
* Table: P_BANHANG
**********************************************/



create procedure P_BANHANG_Ins (MAP_BH varchar(10), MAP_THU varchar(10) )
begin
insert into p_banhang ( MAP_BH, MAP_THU ) values ( MAP_BH, MAP_THU );
end//


create procedure P_BANHANG_Upd (MAP_BH varchar(10), MAP_THU varchar(10) )
begin
update p_banhang as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_BH = MAP_BH;
end//


create procedure P_BANHANG_Del (MAP_BH varchar(10) )
begin
delete from p_banhang 
where MAP_BH = MAP_BH;
end//


/*******************************************
* Table: P_CHI
**********************************************/



create procedure P_CHI_Ins (MAP_CHI varchar(10), NGAYBAOCAO time, TONGCONG decimal )
begin
insert into p_chi ( MAP_CHI, NGAYBAOCAO, TONGCONG ) values ( MAP_CHI, NGAYBAOCAO, TONGCONG );
end//


create procedure P_CHI_Upd (MAP_CHI varchar(10), NGAYBAOCAO time, TONGCONG decimal )
begin
update p_chi as a 
set 
a.NGAYBAOCAO = if(a.NGAYBAOCAO <> NGAYBAOCAO, NGAYBAOCAO, a.NGAYBAOCAO),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_CHI = MAP_CHI;
end//


create procedure P_CHI_Del (MAP_CHI varchar(10) )
begin
delete from p_chi 
where MAP_CHI = MAP_CHI;
end//


/*******************************************
* Table: P_DICHVU
**********************************************/



create procedure P_DICHVU_Ins (MAP_DV varchar(10), MAP_THU varchar(10) )
begin
insert into p_dichvu ( MAP_DV, MAP_THU ) values ( MAP_DV, MAP_THU );
end//


create procedure P_DICHVU_Upd (MAP_DV varchar(10), MAP_THU varchar(10) )
begin
update p_dichvu as a 
set 
a.MAP_THU = if(a.MAP_THU <> MAP_THU, MAP_THU, a.MAP_THU)
where a.MAP_DV = MAP_DV;
end//


create procedure P_DICHVU_Del (MAP_DV varchar(10) )
begin
delete from p_dichvu 
where MAP_DV = MAP_DV;
end//


/*******************************************
* Table: P_GIACONG
**********************************************/



create procedure P_GIACONG_Ins (MAP_GC varchar(10), MATHOGC varchar(10), NGAYNHANHANG time, NGAYTHANHTOAN time, TONGCONG decimal )
begin
insert into p_giacong ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG ) values ( MAP_GC, MATHOGC, NGAYNHANHANG, NGAYTHANHTOAN, TONGCONG );
end//


create procedure P_GIACONG_Upd (MAP_GC varchar(10), MATHOGC varchar(10), NGAYNHANHANG time, NGAYTHANHTOAN time, TONGCONG decimal )
begin
update p_giacong as a 
set 
a.MATHOGC = if(a.MATHOGC <> MATHOGC, MATHOGC, a.MATHOGC),
a.NGAYNHANHANG = if(a.NGAYNHANHANG <> NGAYNHANHANG, NGAYNHANHANG, a.NGAYNHANHANG),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_GC = MAP_GC;
end//


create procedure P_GIACONG_Del (MAP_GC varchar(10) )
begin
delete from p_giacong 
where MAP_GC = MAP_GC;
end//


/*******************************************
* Table: P_MUAHANG
**********************************************/



create procedure P_MUAHANG_Ins (MAP_MH varchar(10), MAKH varchar(10), NGAYMUA time, NGAYTHANHTOAN time, TONGCONG decimal )
begin
insert into p_muahang ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG ) values ( MAP_MH, MAKH, NGAYMUA, NGAYTHANHTOAN, TONGCONG );
end//


create procedure P_MUAHANG_Upd (MAP_MH varchar(10), MAKH varchar(10), NGAYMUA time, NGAYTHANHTOAN time, TONGCONG decimal )
begin
update p_muahang as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYMUA = if(a.NGAYMUA <> NGAYMUA, NGAYMUA, a.NGAYMUA),
a.NGAYTHANHTOAN = if(a.NGAYTHANHTOAN <> NGAYTHANHTOAN, NGAYTHANHTOAN, a.NGAYTHANHTOAN),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_MH = MAP_MH;
end//


create procedure P_MUAHANG_Del (MAP_MH varchar(10) )
begin
delete from p_muahang 
where MAP_MH = MAP_MH;
end//


/*******************************************
* Table: P_NO
**********************************************/



create procedure P_NO_Ins (MAP_NO varchar(10), MAP_THU varchar(10), NGAYNO time, SOTIENNO decimal, NGAYTRA time, SOTIENTRA decimal )
begin
insert into p_no ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA ) values ( MAP_NO, MAP_THU, NGAYNO, SOTIENNO, NGAYTRA, SOTIENTRA );
end//


create procedure P_NO_Upd (MAP_NO varchar(10), MAP_THU varchar(10), NGAYNO time, SOTIENNO decimal, NGAYTRA time, SOTIENTRA decimal )
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


create procedure P_NO_Del (MAP_NO varchar(10) )
begin
delete from p_no 
where MAP_NO = MAP_NO;
end//


/*******************************************
* Table: P_THU
**********************************************/



create procedure P_THU_Ins (MAP_THU varchar(10), MAKH varchar(10), NGAYLAPPHIEU time, NGAYKETTHUC time, TONGCONG decimal )
begin
insert into p_thu ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG ) values ( MAP_THU, MAKH, NGAYLAPPHIEU, NGAYKETTHUC, TONGCONG );
end//


create procedure P_THU_Upd (MAP_THU varchar(10), MAKH varchar(10), NGAYLAPPHIEU time, NGAYKETTHUC time, TONGCONG decimal )
begin
update p_thu as a 
set 
a.MAKH = if(a.MAKH <> MAKH, MAKH, a.MAKH),
a.NGAYLAPPHIEU = if(a.NGAYLAPPHIEU <> NGAYLAPPHIEU, NGAYLAPPHIEU, a.NGAYLAPPHIEU),
a.NGAYKETTHUC = if(a.NGAYKETTHUC <> NGAYKETTHUC, NGAYKETTHUC, a.NGAYKETTHUC),
a.TONGCONG = if(a.TONGCONG <> TONGCONG, TONGCONG, a.TONGCONG)
where a.MAP_THU = MAP_THU;
end//


create procedure P_THU_Del (MAP_THU varchar(10) )
begin
delete from p_thu 
where MAP_THU = MAP_THU;
end//


/*******************************************
* Table: SANPHAM
**********************************************/



create procedure SANPHAM_Ins (MASP varchar(10), TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
insert into sanpham ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON ) values ( MASP, TENLOAISP, DONGIAMUA, DONGIABAN, SOLUONGTON );
end//


create procedure SANPHAM_Upd (MASP varchar(10), TENLOAISP varchar(30), DONGIAMUA decimal, DONGIABAN decimal, SOLUONGTON int )
begin
update sanpham as a 
set 
a.TENLOAISP = if(a.TENLOAISP <> TENLOAISP, TENLOAISP, a.TENLOAISP),
a.DONGIAMUA = if(a.DONGIAMUA <> DONGIAMUA, DONGIAMUA, a.DONGIAMUA),
a.DONGIABAN = if(a.DONGIABAN <> DONGIABAN, DONGIABAN, a.DONGIABAN),
a.SOLUONGTON = if(a.SOLUONGTON <> SOLUONGTON, SOLUONGTON, a.SOLUONGTON)
where a.MASP = MASP;
end//


create procedure SANPHAM_Del (MASP varchar(10) )
begin
delete from sanpham 
where MASP = MASP;
end//


/*******************************************
* Table: THOGIACONG
**********************************************/



create procedure THOGIACONG_Ins (MATHOGC varchar(10), MANGUOI varchar(10) )
begin
insert into thogiacong ( MATHOGC, MANGUOI ) values ( MATHOGC, MANGUOI );
end//


create procedure THOGIACONG_Upd (MATHOGC varchar(10), MANGUOI varchar(10) )
begin
update thogiacong as a 
set 
a.MANGUOI = if(a.MANGUOI <> MANGUOI, MANGUOI, a.MANGUOI)
where a.MATHOGC = MATHOGC;
end//


create procedure THOGIACONG_Del (MATHOGC varchar(10) )
begin
delete from thogiacong 
where MATHOGC = MATHOGC;
end//


/*******************************************
* Table: TONKHO
**********************************************/



create procedure TONKHO_Ins (MAP_TK varchar(10), NGAYBAOCAO time )
begin
insert into tonkho ( MAP_TK, NGAYBAOCAO ) values ( MAP_TK, NGAYBAOCAO );
end//


create procedure TONKHO_Upd (MAP_TK varchar(10), NGAYBAOCAO time )
begin
update tonkho as a 
set 
a.NGAYBAOCAO = if(a.NGAYBAOCAO <> NGAYBAOCAO, NGAYBAOCAO, a.NGAYBAOCAO)
where a.MAP_TK = MAP_TK;
end//


create procedure TONKHO_Del (MAP_TK varchar(10) )
begin
delete from tonkho 
where MAP_TK = MAP_TK;
end//



delimiter ;
