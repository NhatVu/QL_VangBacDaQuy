/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     5/24/2016 9:25:09 PM                         */
/*==============================================================*/


drop table if exists CTP_BANHANG;

drop table if exists CTP_CHI;

drop table if exists CTP_DICHVU;

drop table if exists CTP_GIACONG;

drop table if exists CTP_MUAHANG;

drop table if exists CT_TONKHO;

drop table if exists DICHVU;

drop table if exists HANGGIACONG;

drop table if exists KHACHHANG;

drop table if exists NGUOI;

drop table if exists P_BANHANG;

drop table if exists P_CHI;

drop table if exists P_DICHVU;

drop table if exists P_GIACONG;

drop table if exists P_MUAHANG;

drop table if exists P_NO;

drop table if exists P_THU;

drop table if exists SANPHAM;

drop table if exists THOGIACONG;

drop table if exists TONKHO;

/*==============================================================*/
/* Table: CTP_BANHANG                                           */
/*==============================================================*/
create table CTP_BANHANG
(
   MACTP_BH             varchar(10) not null,
   MAP_BH               varchar(10) not null,
   MASP                 varchar(10) not null,
   SOLUONG              int,
   THANHTIEN            decimal(10,3),
   primary key (MACTP_BH)
);

/*==============================================================*/
/* Table: CTP_CHI                                               */
/*==============================================================*/
create table CTP_CHI
(
   MACTP_CHI            varchar(10) not null,
   MAP_CHI              varchar(10),
   MAPHI                varchar(10) not null,
   TENPHI               varchar(30),
   THANHTIEN            decimal(10,3),
   primary key (MACTP_CHI)
);

/*==============================================================*/
/* Table: CTP_DICHVU                                            */
/*==============================================================*/
create table CTP_DICHVU
(
   MACTP_DV             varchar(10) not null,
   MAP_DV               varchar(10) not null,
   MADV                 varchar(10) not null,
   SOLUONG              int,
   THANHTIEN            decimal(10,3),
   primary key (MACTP_DV)
);

/*==============================================================*/
/* Table: CTP_GIACONG                                           */
/*==============================================================*/
create table CTP_GIACONG
(
   MACTP_GC             varchar(10) not null,
   MAP_GC               varchar(10) not null,
   MALOAIGC             varchar(10) not null,
   SOLUONG              int,
   THANHTIEN            decimal(10,3) not null,
   primary key (MACTP_GC)
);

/*==============================================================*/
/* Table: CTP_MUAHANG                                           */
/*==============================================================*/
create table CTP_MUAHANG
(
   MACTP_MH             varchar(10) not null,
   MASP                 varchar(10) not null,
   MAP_MH               varchar(10) not null,
   SOLUONG              int,
   THANHTIEN            decimal(10,3),
   primary key (MACTP_MH)
);

/*==============================================================*/
/* Table: CT_TONKHO                                             */
/*==============================================================*/
create table CT_TONKHO
(
   MACTP_TK             varchar(10) not null,
   MAP_TK               varchar(10),
   MAHANG               varchar(10) not null,
   TONDAUKY             int,
   TONCUOIKY            int,
   SOLUONGBAN           int,
   SOLUONGMUA           int,
   primary key (MACTP_TK)
);

/*==============================================================*/
/* Table: DICHVU                                                */
/*==============================================================*/
create table DICHVU
(
   MADV                 varchar(10) not null,
   TENDV                varchar(30),
   DONGIA               decimal(10,3),
   primary key (MADV)
);

/*==============================================================*/
/* Table: HANGGIACONG                                           */
/*==============================================================*/
create table HANGGIACONG
(
   MALOAIGC             varchar(10) not null,
   TENLOAGC             varchar(20),
   DONGIA               decimal(10,3),
   primary key (MALOAIGC)
);

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG
(
   MAKH                 varchar(10) not null,
   MANGUOI              varchar(10) not null,
   LAKHACHQUEN          bool,
   primary key (MAKH)
);

/*==============================================================*/
/* Table: NGUOI                                                 */
/*==============================================================*/
create table NGUOI
(
   MANGUOI              varchar(10) not null,
   HOTEN                varchar(50),
   DIACHI               varchar(100),
   SHORTID              int,
   primary key (MANGUOI)
);

/*==============================================================*/
/* Table: P_BANHANG                                             */
/*==============================================================*/
create table P_BANHANG
(
   MAP_BH               varchar(10) not null,
   MAP_THU              varchar(10) not null,
   primary key (MAP_BH)
);

/*==============================================================*/
/* Table: P_CHI                                                 */
/*==============================================================*/
create table P_CHI
(
   MAP_CHI              varchar(10) not null,
   NGAYBAOCAO           time,
   TONGCONG             decimal(10,3),
   primary key (MAP_CHI)
);

/*==============================================================*/
/* Table: P_DICHVU                                              */
/*==============================================================*/
create table P_DICHVU
(
   MAP_DV               varchar(10) not null,
   MAP_THU              varchar(10) not null,
   primary key (MAP_DV)
);

/*==============================================================*/
/* Table: P_GIACONG                                             */
/*==============================================================*/
create table P_GIACONG
(
   MAP_GC               varchar(10) not null,
   MATHOGC              varchar(10) not null,
   NGAYNHANHANG         time,
   NGAYTHANHTOAN        time,
   TONGCONG             decimal(10,3),
   primary key (MAP_GC)
);

/*==============================================================*/
/* Table: P_MUAHANG                                             */
/*==============================================================*/
create table P_MUAHANG
(
   MAP_MH               varchar(10) not null,
   MAKH                 varchar(10) not null,
   NGAYMUA              time,
   NGAYTHANHTOAN        time,
   TONGCONG             decimal(10,3),
   primary key (MAP_MH)
);

/*==============================================================*/
/* Table: P_NO                                                  */
/*==============================================================*/
create table P_NO
(
   MAP_NO               varchar(10) not null,
   MAP_THU              varchar(10),
   NGAYNO               time,
   SOTIENNO             decimal(10,3),
   NGAYTRA              time,
   SOTIENTRA            decimal(10,3),
   primary key (MAP_NO)
);

/*==============================================================*/
/* Table: P_THU                                                 */
/*==============================================================*/
create table P_THU
(
   MAP_THU              varchar(10) not null,
   MAKH                 varchar(10) not null,
   NGAYLAPPHIEU         time,
   NGAYKETTHUC          time,
   TONGCONG             decimal(10,3),
   primary key (MAP_THU)
);

/*==============================================================*/
/* Table: SANPHAM                                               */
/*==============================================================*/
create table SANPHAM
(
   MASP                 varchar(10) not null,
   TENLOAISP            varchar(30),
   DONGIAMUA            decimal(10,3),
   DONGIABAN            decimal(10,3),
   SOLUONGTON           int,
   primary key (MASP)
);

/*==============================================================*/
/* Table: THOGIACONG                                            */
/*==============================================================*/
create table THOGIACONG
(
   MATHOGC              varchar(10) not null,
   MANGUOI              varchar(10) not null,
   primary key (MATHOGC)
);

/*==============================================================*/
/* Table: TONKHO                                                */
/*==============================================================*/
create table TONKHO
(
   MAP_TK               varchar(10) not null,
   NGAYBAOCAO           time,
   primary key (MAP_TK)
);

alter table CTP_BANHANG add constraint FK_CTP_BANHANG foreign key (MASP)
      references SANPHAM (MASP) on delete restrict on update restrict;

alter table CTP_BANHANG add constraint FK_CTP_BANHANG2 foreign key (MAP_BH)
      references P_BANHANG (MAP_BH) on delete restrict on update restrict;

alter table CTP_CHI add constraint FK_CO2 foreign key (MAP_CHI)
      references P_CHI (MAP_CHI) on delete restrict on update restrict;

alter table CTP_DICHVU add constraint FK_CTP_DICHVU foreign key (MADV)
      references DICHVU (MADV) on delete restrict on update restrict;

alter table CTP_DICHVU add constraint FK_CTP_DICHVU2 foreign key (MAP_DV)
      references P_DICHVU (MAP_DV) on delete restrict on update restrict;

alter table CTP_GIACONG add constraint FK_CTP_GIACONG foreign key (MALOAIGC)
      references HANGGIACONG (MALOAIGC) on delete restrict on update restrict;

alter table CTP_GIACONG add constraint FK_CTP_GIACONG2 foreign key (MAP_GC)
      references P_GIACONG (MAP_GC) on delete restrict on update restrict;

alter table CTP_MUAHANG add constraint FK_CTP_MUAHANG foreign key (MAP_MH)
      references P_MUAHANG (MAP_MH) on delete restrict on update restrict;

alter table CTP_MUAHANG add constraint FK_CTP_MUAHANG2 foreign key (MASP)
      references SANPHAM (MASP) on delete restrict on update restrict;

alter table CT_TONKHO add constraint FK_CO1 foreign key (MAP_TK)
      references TONKHO (MAP_TK) on delete restrict on update restrict;

alter table KHACHHANG add constraint FK_LANGUOI1 foreign key (MANGUOI)
      references NGUOI (MANGUOI) on delete restrict on update restrict;

alter table P_BANHANG add constraint FK_LAP_THU1 foreign key (MAP_THU)
      references P_THU (MAP_THU) on delete restrict on update restrict;

alter table P_DICHVU add constraint FK_LAP_THU2 foreign key (MAP_THU)
      references P_THU (MAP_THU) on delete restrict on update restrict;

alter table P_GIACONG add constraint FK_THUOC2 foreign key (MATHOGC)
      references THOGIACONG (MATHOGC) on delete restrict on update restrict;

alter table P_MUAHANG add constraint FK_THUOC1 foreign key (MAKH)
      references KHACHHANG (MAKH) on delete restrict on update restrict;

alter table P_NO add constraint FK_NO foreign key (MAP_THU)
      references P_THU (MAP_THU) on delete restrict on update restrict;

alter table P_THU add constraint FK_THUOC3 foreign key (MAKH)
      references KHACHHANG (MAKH) on delete restrict on update restrict;

alter table THOGIACONG add constraint FK_LANGUOI2 foreign key (MANGUOI)
      references NGUOI (MANGUOI) on delete restrict on update restrict;

