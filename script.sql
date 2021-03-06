USE [Quanlykhachsan]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDichVu] [int] IDENTITY(1,1) NOT NULL,
	[Ten] [nvarchar](100) NOT NULL,
	[DonGia] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[NgayThanhToan] [date] NOT NULL,
	[HinhThucThanhToan] [int] NOT NULL,
	[MaKhuyenMai] [varchar](255) NULL,
	[TongTien] [float] NOT NULL,
	[MaPhieuDK] [int] NULL,
	[MaNhanVien] [varchar](100) NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK__HoaDon__835ED13B3A4DD835] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHoaDon] [int] NOT NULL,
	[MaDichVu] [int] NOT NULL,
	[Soluong] [int] NOT NULL,
	[NgayThem] [date] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
 CONSTRAINT [PK_HDCT] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC,
	[MaDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDonTamTinh]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTamTinh](
	[MaHoaDonTamTinh] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [int] NULL,
	[TongTien] [float] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHoaDonTamTinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[QuocTich] [nvarchar](100) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[DiaChi] [nvarchar](255) NOT NULL,
	[GioiTinh] [int] NOT NULL,
	[SDT] [varchar](15) NOT NULL,
	[CMND] [nvarchar](20) NOT NULL,
	[Hinh] [varchar](255) NULL,
	[NgayThem] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[MaLoaiPhong] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiPhong] [nvarchar](100) NOT NULL,
	[DonGia] [float] NOT NULL,
	[SoNguoi] [int] NOT NULL,
	[HinhAnh] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MaKhuyenMai]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MaKhuyenMai](
	[MaKhuyenMai] [varchar](255) NOT NULL,
	[GiaTri] [float] NOT NULL,
	[ThoiHan] [date] NOT NULL,
	[TrangThai] [int] NOT NULL,
	[NgayTao] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNhanVien] [varchar](100) NOT NULL,
	[Password] [varchar](100) NOT NULL,
	[VaiTro] [int] NOT NULL,
	[Ho] [nvarchar](50) NOT NULL,
	[Ten] [nvarchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[SDT] [varchar](15) NOT NULL,
	[DiaChi] [nvarchar](255) NOT NULL,
	[GioiTinh] [int] NOT NULL,
	[Hinh] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuDangKy]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhieuDangKy](
	[MaPhieuDK] [int] IDENTITY(1,1) NOT NULL,
	[NgayLap] [date] NOT NULL,
	[NgayNhanPhong] [date] NOT NULL,
	[NgayTraPhongDuKien] [date] NOT NULL,
	[NgayTraPhongThucTe] [date] NOT NULL,
	[TrangThai] [int] NOT NULL,
	[MaKhachHang] [int] NULL,
	[MaNhanVien] [varchar](100) NULL,
	[MaPhong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhieuDK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [int] IDENTITY(1,1) NOT NULL,
	[TenPhong] [varchar](100) NOT NULL,
	[TrangThai] [int] NOT NULL,
	[GhiChu] [nvarchar](255) NULL,
	[MaLoaiPhong] [int] NOT NULL,
	[Tang] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[DichVu] ON 

INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (1, N'Dọn phòng', 50000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (2, N'Giặt, ủi', 30000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (3, N'Spa', 500000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (4, N'Tennis', 50000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (5, N'Karaoke', 120000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (6, N'Rửa xe 2 bánh', 35000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (7, N'Rửa xe 4 bánh', 100000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (8, N'Văn phòng(photocopy, máy in, ...)', 10000)
INSERT [dbo].[DichVu] ([MaDichVu], [Ten], [DonGia]) VALUES (9, N'Đền trang thiết bị', 0)
SET IDENTITY_INSERT [dbo].[DichVu] OFF
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (1, CAST(N'2020-01-24' AS Date), 0, NULL, 54483.3333443, 1, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (2, CAST(N'2020-02-24' AS Date), 0, NULL, 210000, 2, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (3, CAST(N'2020-03-24' AS Date), 0, NULL, 311333.333396, 3, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (4, CAST(N'2020-03-24' AS Date), 0, NULL, 210000, 4, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (5, CAST(N'2020-04-25' AS Date), 0, NULL, 1050000, 5, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (6, CAST(N'2020-04-25' AS Date), 0, NULL, 1195000, 6, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (7, CAST(N'2020-04-25' AS Date), 0, NULL, 3500000, 7, N'ducnm', 1)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (8, CAST(N'2020-04-24' AS Date), 0, NULL, 21000, 8, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (9, CAST(N'2020-04-24' AS Date), 0, NULL, 630000, 9, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (10, CAST(N'2020-04-25' AS Date), 0, NULL, 120000, 10, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (11, CAST(N'2020-04-25' AS Date), 0, NULL, 210000, 11, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (12, CAST(N'2020-04-25' AS Date), 0, NULL, 120000, 12, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (13, CAST(N'2020-04-25' AS Date), 0, NULL, 210000, 13, N'ducnm', 0)
INSERT [dbo].[HoaDon] ([MaHoaDon], [NgayThanhToan], [HinhThucThanhToan], [MaKhuyenMai], [TongTien], [MaPhieuDK], [MaNhanVien], [TrangThai]) VALUES (14, CAST(N'2020-04-25' AS Date), 0, NULL, 450000, 14, N'ducnm', 0)
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (1, 1, 1, CAST(N'2020-04-24' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (1, 2, 1, CAST(N'2020-04-24' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (1, 3, 5, CAST(N'2020-04-24' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (1, 4, 1, CAST(N'2020-04-24' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (1, 5, 2, CAST(N'2020-04-24' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (6, 1, 1, CAST(N'2020-04-25' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (6, 4, 1, CAST(N'2020-04-25' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (6, 6, 1, CAST(N'2020-04-25' AS Date), N'')
INSERT [dbo].[HoaDonChiTiet] ([MaHoaDon], [MaDichVu], [Soluong], [NgayThem], [GhiChu]) VALUES (6, 8, 1, CAST(N'2020-04-25' AS Date), N'')
SET IDENTITY_INSERT [dbo].[HoaDonTamTinh] ON 

INSERT [dbo].[HoaDonTamTinh] ([MaHoaDonTamTinh], [MaHoaDon], [TongTien], [TrangThai]) VALUES (1, 7, 3500000, 1)
INSERT [dbo].[HoaDonTamTinh] ([MaHoaDonTamTinh], [MaHoaDon], [TongTien], [TrangThai]) VALUES (2, 6, 1195000, 1)
INSERT [dbo].[HoaDonTamTinh] ([MaHoaDonTamTinh], [MaHoaDon], [TongTien], [TrangThai]) VALUES (3, 5, 1050000, 1)
INSERT [dbo].[HoaDonTamTinh] ([MaHoaDonTamTinh], [MaHoaDon], [TongTien], [TrangThai]) VALUES (4, 10, -80000, 0)
SET IDENTITY_INSERT [dbo].[HoaDonTamTinh] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (1, N'Lê Thị Thu', N'Vietnamese', N'thu125@gmail.com', N'Chùa VĨnh Nghiêm', 0, N'0924526123', N'065215445', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (2, N'Hoảng Thị Ngọc Hoàng Nhân', N'Vietnamese', N'hoangnhan0212@gmail.com', N'K biết', 1, N'0903552552', N'254285214', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (3, N'Trần Văn Đảng', N'Vietnamese', N'vandan@fpt.edu.vn', N'Tp. Hồ Chí Minh', 1, N'0908752123', N'097493712', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (4, N'Phùng Khắn Đoan', N'Vietnamese', N'khacdoan@gmail.com', N'Quận 2', 1, N'0903341561', N'087495612', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (5, N'Hai Mươi Ba', N'ThaiLan', N'chimuoihai@gmail.com', N'Thái Lan', 0, N'0836651881', N'020388719', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (6, N'Lê Văn Tí', N'Vietnames', N'levanti2@yahoo.com.vn', N'Tp. Hồ Chí Minh', 1, N'0937481759', N'082731980', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (7, N'Nguyễn Đình Văn', N'Vietnamese', N'vandinh@fpt.edu.vn', N'Quận 7', 1, N'0981385631', N'083481978', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (8, N'Nguyễn Thị Thu', N'Vietnamese', N'nguyenthu@gmail.com', N'Tp. Hồ Chí Minh', 0, N'0971927411', N'028759812', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (9, N'Trần Cao Văn', N'Vietnamese', N'caovan@yahoo.com.vn', N'Vũng Tàu', 0, N'0908761723', N'083979123', NULL, CAST(N'2020-04-24' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (10, N'Nguyễn Văn An', N'Vietnamese', N'anguyenvan@gmail.com', N'Tp. Hồ Chí Minh', 1, N'0906716231', N'197234178', NULL, CAST(N'2020-04-25' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (11, N'Trần Tài', N'Vietnamese', N'taitrang@yahoo.com.vn', N'Vũng Tàu', 1, N'0128491911', N'012849019', NULL, CAST(N'2020-04-25' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (12, N'Bùi Thịnh', N'Vietnamese', N'thinhbui99@fpt.edu.vn', N'Tp. Hồ Chí Minh', 1, N'0817561823', N'917018323', NULL, CAST(N'2020-04-25' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (13, N'Cao Văn Lầu', N'Vietnmaese', N'caovanlau@gmail.com.vn', N'Quận 8', 1, N'0817591711', N'917247190', NULL, CAST(N'2020-04-25' AS Date))
INSERT [dbo].[KhachHang] ([MaKhachHang], [HoTen], [QuocTich], [Email], [DiaChi], [GioiTinh], [SDT], [CMND], [Hinh], [NgayThem]) VALUES (14, N'Nguyễn Luận Văn', N'Vietnnamese', N'vannguyen@fpt.edu.vn', N'Tp. Hồ Chí Minh', 1, N'0122851900', N'837101823', NULL, CAST(N'2020-04-25' AS Date))
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[LoaiPhong] ON 

INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (1, N'Standard', 400000, 2, NULL)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (2, N'Superior', 700000, 2, NULL)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (3, N'Deluxe', 1000000, 4, NULL)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (4, N'Suite', 1500000, 6, NULL)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (5, N'Junior Suite', 2100000, 8, NULL)
INSERT [dbo].[LoaiPhong] ([MaLoaiPhong], [TenLoaiPhong], [DonGia], [SoNguoi], [HinhAnh]) VALUES (6, N'Executive Suite', 5000000, 15, NULL)
SET IDENTITY_INSERT [dbo].[LoaiPhong] OFF
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'IPCYL0', 23, CAST(N'2020-04-15' AS Date), 2, CAST(N'2020-04-15' AS Date))
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'OUGXB9', 100, CAST(N'2020-04-23' AS Date), 2, CAST(N'2020-04-21' AS Date))
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'P67VC689', 30, CAST(N'2020-04-20' AS Date), 2, CAST(N'2020-04-15' AS Date))
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'QJTZRX', 23, CAST(N'2020-04-10' AS Date), 2, CAST(N'2020-04-15' AS Date))
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'VQYGHE', 70, CAST(N'2019-04-01' AS Date), 2, CAST(N'2020-04-15' AS Date))
INSERT [dbo].[MaKhuyenMai] ([MaKhuyenMai], [GiaTri], [ThoiHan], [TrangThai], [NgayTao]) VALUES (N'XVW3YN', 50, CAST(N'2020-04-24' AS Date), 2, CAST(N'2020-04-15' AS Date))
INSERT [dbo].[NhanVien] ([MaNhanVien], [Password], [VaiTro], [Ho], [Ten], [Email], [SDT], [DiaChi], [GioiTinh], [Hinh]) VALUES (N'anhtn', N'123456', 2, N'Nguyễn', N'Anh', N'anhtn@fpt.edu.vn', N'0', N'Tp. Hồ Chí Minh', 1, N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [Password], [VaiTro], [Ho], [Ten], [Email], [SDT], [DiaChi], [GioiTinh], [Hinh]) VALUES (N'ducnm', N'123456', 2, N'Nguyễn', N'Đức', N'ducnm@fpt.edu.vn', N'0', N'Tp. Hồ Chí Minh', 1, N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [Password], [VaiTro], [Ho], [Ten], [Email], [SDT], [DiaChi], [GioiTinh], [Hinh]) VALUES (N'phucpb', N'123456', 2, N'Phạm', N'Phúc', N'phambaphuc1999@gmail.com', N'0938697503', N'Tp. Hồ Chí Minh', 1, N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [Password], [VaiTro], [Ho], [Ten], [Email], [SDT], [DiaChi], [GioiTinh], [Hinh]) VALUES (N'tuanncq', N'123456', 2, N'Nguyễn', N'Quang Tuấn', N'tncq@fpt.edu.vn', N'0', N'Tp. Hồ Chí Minh', 1, N'')
INSERT [dbo].[NhanVien] ([MaNhanVien], [Password], [VaiTro], [Ho], [Ten], [Email], [SDT], [DiaChi], [GioiTinh], [Hinh]) VALUES (N'tuannn', N'123456', 2, N'Nguyễn', N'Tuấn', N'tuann@fpt.edu.vn', N'0', N'Tp. Hồ Chí Minh', 1, N'')
SET IDENTITY_INSERT [dbo].[PhieuDangKy] ON 

INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (1, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-27' AS Date), CAST(N'2020-04-24' AS Date), 1, 1, N'ducnm', 3)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (2, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-26' AS Date), CAST(N'2020-04-26' AS Date), 2, 2, N'ducnm', 42)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (3, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-26' AS Date), CAST(N'2020-04-24' AS Date), 1, 3, N'ducnm', 1)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (4, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-28' AS Date), CAST(N'2020-04-30' AS Date), CAST(N'2020-04-30' AS Date), 2, 4, N'ducnm', 12)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (5, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), 1, 5, N'ducnm', 19)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (6, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), 1, 6, N'ducnm', 24)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (7, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), 1, 7, N'ducnm', 32)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (8, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-24' AS Date), CAST(N'2020-04-28' AS Date), CAST(N'2020-04-28' AS Date), 0, 8, N'ducnm', 3)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (9, CAST(N'2020-04-24' AS Date), CAST(N'2020-04-26' AS Date), CAST(N'2020-04-28' AS Date), CAST(N'2020-04-28' AS Date), 0, 9, N'ducnm', 34)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (10, CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-26' AS Date), CAST(N'2020-04-26' AS Date), 0, 10, N'ducnm', 1)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (11, CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-26' AS Date), CAST(N'2020-04-26' AS Date), 0, 11, N'ducnm', 12)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (12, CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-28' AS Date), CAST(N'2020-04-28' AS Date), 0, 12, N'ducnm', 8)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (13, CAST(N'2020-04-25' AS Date), CAST(N'2020-04-28' AS Date), CAST(N'2020-04-29' AS Date), CAST(N'2020-04-29' AS Date), 0, 13, N'ducnm', 16)
INSERT [dbo].[PhieuDangKy] ([MaPhieuDK], [NgayLap], [NgayNhanPhong], [NgayTraPhongDuKien], [NgayTraPhongThucTe], [TrangThai], [MaKhachHang], [MaNhanVien], [MaPhong]) VALUES (14, CAST(N'2020-04-25' AS Date), CAST(N'2020-04-25' AS Date), CAST(N'2020-04-27' AS Date), CAST(N'2020-04-27' AS Date), 0, 14, N'ducnm', 41)
SET IDENTITY_INSERT [dbo].[PhieuDangKy] OFF
SET IDENTITY_INSERT [dbo].[Phong] ON 

INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (1, N'P101', 1, N'phòng tiêu chuẩn, giường đơn, 1 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (2, N'P102', 0, N'phòng tiêu chuẩn, giường đơn, 1 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (3, N'P103', 2, N'phòng tiêu chuẩn, giường đơn, 1 người, hướng biển', 2, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (4, N'P104', 0, N'phòng tiêu chuẩn, 2 giường đơn, 2 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (5, N'P105', 0, N'phòng tiêu chuẩn, 2 giường đơn, 2 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (6, N'P106', 0, N'phòng tiêu chuẩn, 2 giường đơn, 2 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (7, N'P107', 0, N'phòng tiêu chuẩn, giường đôi, 2 người', 1, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (8, N'P201', 1, N'phòng tiêu chuẩn, giường đơn, 1 người', 1, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (9, N'P202', 0, N'phòng tiêu chuẩn, giường đôi, 2 người', 1, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (10, N'P203', 0, N'phòng tiêu chuẩn, giường đôi, 2 người', 1, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (11, N'P204', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người', 2, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (12, N'P205', 1, N'phòng tiêu chuẩn, giường đôi lớn, 2 người', 2, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (13, N'P206', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (14, N'P207', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 2)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (15, N'P301', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người', 2, 3)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (16, N'P302', 5, N'phòng tiêu chuẩn, giường đôi lớn, 2 người', 2, 3)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (17, N'P303', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 3)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (18, N'P304', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 3)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (19, N'P305', 2, N'phòng lớn, 2 giường đôi lớn, 1 giường đơn, 6 người, hướng biển', 4, 3)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (20, N'P401', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (21, N'P402', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (22, N'P403', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (23, N'P404', 0, N'phòng tiêu chuẩn, giường đôi lớn, 2 người, hướng biển', 3, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (24, N'P405', 2, N'phòng lớn, 2 giường đôi lớn, 1 giường đơn, 6 người, hướng biển', 4, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (25, N'P406', 0, N'phòng cực lớn, 2 giường đôi lớn, 2 giường đôi, 8 người, hướng biển', 5, 4)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (26, N'P501', 0, N'phòng lớn, 2 giường đôi lớn, 1 giường đơn, 6 người, hướng biển', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (27, N'P502', 0, N'phòng lớn, 2 giường đôi lớn, 1 giường đơn, 6 người, hướng biển', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (28, N'P503', 0, N'phòng cực lớn, 2 giường đôi lớn, 2 giường đôi, 8 người, hướng biển', 5, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (29, N'P504', 0, N'phòng cực lớn, 2 giường đôi lớn, 2 giường đôi, 8 người, hướng biển', 5, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (30, N'P505', 0, N'phòng tổng thống, tầm bao quát đẹp, hồi bơi trong phòng, bồn tắm nằm và bồn tắm đứng, 4 giường đôi lớn, 2 giường đôi, 1 giường đơn nhỏ, phòng khách và phòng ăn riêng, trang trí theo kiểu cổ điển', 6, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (31, N'P506', 0, N'phòng tổng thống, tầm bao quát đẹp, hồi bơi trong phòng, bồn tắm nằm và bồn tắm đứng, 4 giường đôi lớn, 2 giường đôi, 1 giường đơn nhỏ, phòng khách và phòng ăn riêng, trang trí theo kiểu hiện đại', 6, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (32, N'P507', 2, N'phòng tổng thống, tầm bao quát đẹp, hồi bơi trong phòng, bồn tắm nằm và bồn tắm đứng, 4 giường đôi lớn, 2 giường đôi, 1 giường đơn nhỏ, phòng khách và phòng ăn riêng, trang trí theo kiểu châu á', 6, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (33, N'P508', 0, N'', 6, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (34, N'P509', 5, N'', 5, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (35, N'P510', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (36, N'P511', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (37, N'P512', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (38, N'P513', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (39, N'P514', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (40, N'P515', 0, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (41, N'P516', 1, N'', 4, 5)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (42, N'P108', 0, N'', 2, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (43, N'P109', 0, N'', 2, 1)
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [TrangThai], [GhiChu], [MaLoaiPhong], [Tang]) VALUES (44, N'P110', 0, N'', 2, 1)
SET IDENTITY_INSERT [dbo].[Phong] OFF
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaKhuyen__1FCDBCEB] FOREIGN KEY([MaKhuyenMai])
REFERENCES [dbo].[MaKhuyenMai] ([MaKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaKhuyen__1FCDBCEB]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaNhanVi__20C1E124] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaNhanVi__20C1E124]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__MaPhieuD__21B6055D] FOREIGN KEY([MaPhieuDK])
REFERENCES [dbo].[PhieuDangKy] ([MaPhieuDK])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__MaPhieuD__21B6055D]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HDCT_MDV] FOREIGN KEY([MaDichVu])
REFERENCES [dbo].[DichVu] ([MaDichVu])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HDCT_MDV]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HDCT_MHD] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HDCT_MHD]
GO
ALTER TABLE [dbo].[HoaDonTamTinh]  WITH CHECK ADD FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[PhieuDangKy]  WITH CHECK ADD FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[KhachHang] ([MaKhachHang])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuDangKy]  WITH CHECK ADD FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NhanVien] ([MaNhanVien])
GO
ALTER TABLE [dbo].[PhieuDangKy]  WITH CHECK ADD FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD FOREIGN KEY([MaLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([MaLoaiPhong])
GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeDoanhThu]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ThongKeDoanhThu]
AS
BEGIN
SELECT
	MONTH(NgayLap) Thang,
	COUNT(HoaDon.MaPhieuDK) SoLuongPhieu,
	SUM(TongTien) TongDoanhThu,
	MIN(TongTien) ThapNhat,
	MAX(TongTien) CaoNhat,
	AVG(TongTien) TrungBinhThang
FROM dbo.HoaDon JOIN dbo.PhieuDangKy ON PhieuDangKy.MaPhieuDK = HoaDon.MaPhieuDK
GROUP BY MONTH(NgayLap)
END


GO
/****** Object:  StoredProcedure [dbo].[sp_ThongKeKhachHang]    Script Date: 4/25/2020 9:24:44 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_ThongKeKhachHang]
AS
	BEGIN
		SELECT	MONTH(NgayNhanPhong) Thang,
				COUNT(*) SoLuongKhach,
				MIN(NgayNhanPhong) NgayDauTien,
				MAX(NgayNhanPhong) NgayCuoiCung
		FROM dbo.KhachHang JOIN dbo.PhieuDangKy ON PhieuDangKy.MaKhachHang = KhachHang.MaKhachHang
		GROUP BY MONTH(NgayNhanPhong), YEAR(NgayNhanPhong)
	END


GO
