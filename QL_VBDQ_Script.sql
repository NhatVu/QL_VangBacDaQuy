/*
* Bảng: Người
*/
use vangbacdaquy;
/*insert into nguoi values(1,1,"Nguyễn Văn A", "Nguyễn Văn A - Địa chỉ");*/

insert into NGUOI values ('1',123456789,'Nguyen Hoang Phat','135 Nguyen XXX YYYY');
insert into NGUOI values ('2',12345678,'Nguyen Hoang Minh','252 Duong AAA Pho BBB');
insert into NGUOI values ('3',12345677,'Nguyen Hoang Tuan','252 Duong CCC Pho DDD');
insert into NGUOI values ('4',123456780,'Vu Minh Nhat','125 Vu XXX YYYY');

/*
* Bảng : Khách hàng
*/

insert into khachhang values (1,3,0); -- kh 1, người 3
insert into khachhang values (2,1,1); -- kh 2, người 1
insert into khachhang values (3,2,1); -- kh 3, người 2

/*
* Bảng : Phiếu thu
*/
insert into p_thu values (1,1,"2016-05-20","2016-05-21",20000);-- pt 1, kh 1
insert into p_thu values (2,3,"2016-05-20","2016-05-21",30000);-- pt 2, kh 3
insert into p_thu values (3,2,"2016-05-20","2016-05-21",10000); -- pt 3, kh2

/*
* Bẩng : Phiếu bán hàng
*/
insert into p_banhang values (1,2); -- pbh 1, pt 2
insert into p_banhang values (2,3);-- pbh 2, pt 3

/*
* Bảng : Phiếu nợ
*/

insert into p_no values (1,3,"2016-05-20",10000,"2016-05-22",1000); -- no 1, thu 3
insert into p_no values (2,3,"2016-05-22",9000,"2016-05-23",1000); -- no 2, thu 3

/*
* Bảng : Sản phẩm
*/
insert into SanPham values (1, "Vàng", 10000, 15000, 12);
insert into SanPham values (2, "Bạc", 2000,3000,5);
insert into sanpham values (3, "Đá quý", 4000, 5000, 10);

/*
* Bảng : Chi tiết phiếu bán hàng. sp1:4, sp2:2, sp3:1
*/
insert into ctp_banhang values (1,1,1,2,30000); -- ctp 1, bh 1, sp1
insert into ctp_banhang values (2,1,3,1,5000); -- ctp 2, bh 1, sp3
insert into ctp_banhang values (3,2,2,2,6000); -- ctp 3, bh 2, sp2
insert into ctp_banhang values (4,2,1,2,30000); -- ctp 4, bh 2, sp1

/*
* Bảng : Phiếu mua hàng
*/
insert into p_muahang(MAP_MH, makh,NGAYMUA,NGAYTHANHTOAN,TONGCONG) values (1,1,'2016-5-20','2016-5-20',30000); -- mh 1, kh 1
insert into p_muahang(MAP_MH, makh,NGAYMUA,NGAYTHANHTOAN,TONGCONG) values (2,2,'2016-5-21','2016-5-22',40000); -- mh2, kh 2

/*
* Bảng : Chi tiết phiếu mua hàng. sản phẩm 2: 2, sp3: 5
*/
insert into ctp_muahang(MACTP_MH,MAP_MH,MASP,SOLUONG,THANHTIEN) values (1,1,2,2,40000); -- ctp 1, mh 1, sp 2
insert into ctp_muahang(MACTP_MH,MAP_MH,MASP,SOLUONG,THANHTIEN) values (2,2,3,5,50000); -- ctp2, mh 2, sp 3

/* phát */


insert into DICHVU values(1,'Can trang suc',100000);
insert into DICHVU values(2,'Doi tien',200000);
insert into DICHVU values(3,'Ma trang suc',30000);



insert into THOGIACONG values (1,2); -- gc 1, nguoi 2
insert into THOGIACONG values (2,3); -- gc 2, nuoi 3

insert into HANGGIACONG values(1,'Gia cong nhan',100000);
insert into HANGGIACONG values(2,'Gia cong bong tai',200000);
insert into HANGGIACONG values(3,'Gia cong vong',30000);

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
delete from sanpham*/