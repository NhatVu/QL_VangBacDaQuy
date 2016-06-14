/*
* Bảng: Người
*/
use vangbacdaquy;
/*insert into nguoi values(1,1,"Nguyễn Văn A", "Nguyễn Văn A - Địa chỉ");*/

insert into NGUOI values ('NGUOI1',123456789,'Nguyen Hoang Phat','135 Nguyen XXX YYYY');
insert into NGUOI values ('NGUOI2',12345678,'Nguyen Hoang Minh','252 Duong AAA Pho BBB');
insert into NGUOI values ('NGUOI3',12345677,'Nguyen Hoang Tuan','252 Duong CCC Pho DDD');
insert into NGUOI values ('NGUOI4',123456780,'Vu Minh Nhat','125 Vu XXX YYYY');

/*
* Bảng : Khách hàng
*/

insert into khachhang values ('KHACHHANG1','NGUOI3',0);
insert into khachhang values ('KHACHHANG2','NGUOI1',1);
insert into khachhang values ('KHACHHANG3','NGUOI2',1);

/*
* Bảng : Phiếu thu
*/
insert into p_thu values ('P_THU1','KHACHHANG1',"2016-05-20","2016-05-21",20000);
insert into p_thu values ('P_THU2','KHACHHANG3',"2016-05-20","2016-05-21",30000);
insert into p_thu values ('P_THU3','KHACHHANG2',"2016-05-20","2016-05-21",10000);

/*
* Bẩng : Phiếu bán hàng
*/
insert into p_banhang values ('P_BANHANG1','P_THU2');
insert into p_banhang values ('P_BANHANG2','P_THU3');

/*
* Bảng : Phiếu nợ
*/

insert into p_no values ('P_NO1','P_THU3',"2016-05-20",10000,"2016-05-22",1000);
insert into p_no values ('P_NO2','P_THU3',"2016-05-22",9000,"2016-05-23",1000);

/*
* Bảng : Sản phẩm
*/
insert into SanPham values ('SANPHAM1', "Vàng", 10000, 15000, 12);
insert into SanPham values ('SANPHAM2', "Bạc", 2000,3000,5);
insert into sanpham values ('SANPHAM3', "Đá quý", 4000, 5000, 10);

/*
* Bảng : Chi tiết phiếu bán hàng. sp1:4, sp2:2, sp3:1
*/
insert into ctp_banhang values ('CTP_BANHANG1','P_BANHANG1','SANPHAM1',2,30000);
insert into ctp_banhang values ('CTP_BANHANG2','P_BANHANG1','SANPHAM3',1,5000);
insert into ctp_banhang values ('CTP_BANHANG3','P_BANHANG2','SANPHAM2',2,6000);
insert into ctp_banhang values ('CTP_BANHANG4','P_BANHANG2','SANPHAM1',2,30000);

/*
* Bảng : Phiếu mua hàng
*/
insert into p_muahang(MAP_MH, makh,NGAYMUA,NGAYTHANHTOAN,TONGCONG) values ('P_MUAHANG1','KHACHHANG1','2016-5-20','2016-5-20',30000);
insert into p_muahang(MAP_MH, makh,NGAYMUA,NGAYTHANHTOAN,TONGCONG) values ('P_MUAHANG2','KHACHHANG2','2016-5-21','2016-5-22',40000);

/*
* Bảng : Chi tiết phiếu mua hàng. sản phẩm 2: 2, sp3: 5
*/
insert into ctp_muahang(MACTP_MH,MAP_MH,MASP,SOLUONG,THANHTIEN) values ('CTP_MUAHANG1','P_MUAHANG1','SANPHAM2',2,40000);
insert into ctp_muahang(MACTP_MH,MAP_MH,MASP,SOLUONG,THANHTIEN) values ('CTP_MUAHANG2','P_MUAHANG2','SANPHAM3',5,50000);

/* phát */


insert into DICHVU values('DICHVU1','Cao long nach',100000);
insert into DICHVU values('DICHVU2','Cao long chan',200000);
insert into DICHVU values('DICHVU3','Cao long vung kin',30000);



insert into THOGIACONG values ('THOGIACONG1','NGUOI2');
insert into THOGIACONG values ('THOGIACONG2','NGUOI3');

insert into HANGGIACONG values('HANGGIACONG1','Long nach',100000);
insert into HANGGIACONG values('HANGGIACONG2','Long chan',200000);
insert into HANGGIACONG values('HANGGIACONG3','Long tay',30000);

/*select * from khachhang;


delete from ctp_giacong;
delete from p_giacong;
delete from hanggiacong;
delete from thogiacong;

delete from ctp_dichvu;
delete from p_dichvu;
delete from dichvu;

delete from p_no;
delete from ctp_banhang;
delete from p_banhang;
delete from p_thu;
delete from ctp_muahang;
delete from p_muahang;
delete from khachhang;
delete from nguoi;
delete from sanpham;*/