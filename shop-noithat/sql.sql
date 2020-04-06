use DB_shop;
create table DanhMucSanPham(
MaDanhMuc int  primary key auto_increment,
TenDanhmuc nvarchar(100));
create table SanPham(
MaSanPham int auto_increment primary key,
MaDanhMuc int ,
TenSanPham Nvarchar(100),
GiaGoc float,
KhuyenMai float,
MoTaNgan nvarchar(220),
MoTaChiTiet text,
foreign key (MaDanhMuc) REFERENCES DanhMucSanPham(MaDanhMuc));
create table TinTuc(
MaTinTuc int primary key auto_increment,
TieuDe nvarchar(220),
NoiDung text);
create table LienHe(
MaLienHe int primary key auto_increment,
HoTen nvarchar(70),
Email varchar(100),
ChuDe Nvarchar(200),
NoiDung text);
create table NguoiDung(
TaiKhoan varchar (100),
MatKhau varchar (100),
HoTen Nvarchar (100),
GioiTinh bit,
NgaySinh datetime,
DiaChi nvarchar(200),
Email varchar(100),
SoDT varchar(20),
NhomQuyen int not null );
create table DonHang(
MaDonHang int auto_increment primary key,
NgayDatHang datetime,
Hoten Nvarchar (100),
DiaChi nvarchar(200),
Email varchar(100),
SoDT varchar(20),
SoLoaiSanPham int,
TongTien float);

create table DonHangChiTiet(
MaDHCT int primary key auto_increment,
MaSanPham int,
GiaBan float,
SoLuongSP int,
TongTien float,
foreign key(MaSanPham) references SanPham(MaSanPham));