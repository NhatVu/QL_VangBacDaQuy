/*
* Bảng: Người
*/
use vangbacdaquy;
insert into nguoi values(1,1,"Nguyễn Văn A", "Nguyễn Văn A - Địa chỉ");
insert into nguoi values(2,2,"Nguyễn Văn B", "Nguyễn Văn B - Địa chỉ");
insert into nguoi values(3,3,"Nguyễn Văn C", "Nguyễn Văn C - Địa chỉ");
insert into nguoi values("3asdf",3,"Nguyễn Văn D", "Nguyễn Văn C - Địa chỉ");


/*
* Bảng : Khách hàng
*/

insert into khachhang values (1,3,0);
insert into khachhang values (2,1,1);
insert into khachhang values (3,2,1);

/*
* Bảng : Phiếu thu
*/
insert into p_thu values (1,1,"2016-05-20","2016-05-21",20000);
insert into p_thu values (2,3,"2016-05-20","2016-05-21",30000);
insert into p_thu values (3,2,"2016-05-20","2016-05-21",10000);

/*
* Bẩng : Phiếu bán hàng
*/
insert into p_banhang values (1,2);
insert into p_banhang values (2,3);

/*
* Bảng : Phiếu nợ
*/

insert into p_no values (1,3,"2016-05-20",10000,"2016-05-22",1000);
insert into p_no values (2,3,"2016-05-22",9000,"2016-05-23",1000);

