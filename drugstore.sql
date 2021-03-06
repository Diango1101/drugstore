USE [drugstore]
GO
/****** Object:  Table [dbo].[Reserve]    Script Date: 2019/1/18 10:11:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reserve](
	[Rno] [varchar](8) NOT NULL,
	[Sid] [varchar](8) NULL,
	[Ramount] [int] NOT NULL,
 CONSTRAINT [PK_RESERVE] PRIMARY KEY CLUSTERED 
(
	[Rno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Stock]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stock](
	[Dno] [varchar](8) NOT NULL,
	[Sid] [varchar](8) NOT NULL,
	[Ptime] [datetime] NOT NULL,
	[Stime] [datetime] NOT NULL,
	[Vtime] [datetime] NOT NULL,
	[Samount] [int] NOT NULL,
	[Sprice] [float] NOT NULL,
 CONSTRAINT [PK_STOCK] PRIMARY KEY CLUSTERED 
(
	[Sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Out_Stock]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Out_Stock](
	[Oid] [varchar](8) NOT NULL,
	[Sid] [varchar](8) NOT NULL,
	[Rno] [varchar](8) NULL,
	[Oprice] [float] NOT NULL,
	[Oamount] [int] NOT NULL,
	[Cno] [varchar](8) NOT NULL,
	[Ono] [varchar](8) NOT NULL,
	[Otime] [datetime] NOT NULL,
 CONSTRAINT [PK_Out_Stock_1] PRIMARY KEY CLUSTERED 
(
	[Oid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Commodity]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Commodity](
	[Dno] [varchar](8) NOT NULL,
	[Dcate] [varchar](50) NULL,
	[Dname] [varchar](50) NULL,
	[Place] [varchar](50) NULL,
 CONSTRAINT [PK_COMMODITY] PRIMARY KEY CLUSTERED 
(
	[Dno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[销售情况]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




CREATE VIEW [dbo].[销售情况]
AS
SELECT   Out_stock.oid, stock.dno, out_stock.cno, out_stock.ono, commodity.dname, out_stock.oprice, 
                stock.samount, out_stock.oamount, reserve.ramount, commodity.dcate, out_stock.Rno, 
                out_stock.Otime
FROM      commodity INNER JOIN
                stock ON commodity.dno = stock.Dno INNER JOIN
                reserve ON stock.sid = reserve.sid INNER JOIN
                out_stock ON reserve.rno = out_stock.rno
GO
/****** Object:  View [dbo].[选项卡]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO










CREATE VIEW [dbo].[选项卡]
AS
SELECT   commodity.dcate, commodity.dname, commodity.place, reserve.ramount, stock.ptime, 
                stock.stime, stock.vtime
FROM     Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
/****** Object:  View [dbo].[仓库情况]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO








CREATE VIEW [dbo].[仓库情况]
AS
SELECT   reserve.rno, commodity.dno, stock.sid, commodity.dcate, commodity.dname, 
                stock.stime, stock.vtime, reserve.ramount, commodity.place
FROM      Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
/****** Object:  View [dbo].[逼仓情况]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO













CREATE VIEW [dbo].[逼仓情况]
AS
SELECT   TOP (100) PERCENT stock.sid, commodity.dname, stock.sprice, stock.samount, stock.vtime, 
                reserve.ramount
FROM      commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
WHERE   datediff(year,getdate(),stock.vtime)<=0 OR
                (reserve.ramount < 60)
GO
/****** Object:  View [dbo].[进货情况]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE VIEW [dbo].[进货情况]
AS
SELECT   Stock.Sid, commodity.dno, commodity.dname, reserve.rno, stock.stime, 
                stock.vtime, stock.samount, commodity.dcate, commodity.place, stock.sprice
FROM      commodity  INNER JOIN stock 
                 ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
/****** Object:  Table [dbo].[users]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [varchar](8) NOT NULL,
	[password] [varchar](20) NULL,
	[uidentity] [varchar](20) NULL,
 CONSTRAINT [PK_Table_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Stock] ADD  DEFAULT (getdate()) FOR [Stime]
GO
ALTER TABLE [dbo].[Out_Stock]  WITH NOCHECK ADD  CONSTRAINT [FK_OUT_STOC_REFERENCE_RESERVE] FOREIGN KEY([Rno])
REFERENCES [dbo].[Reserve] ([Rno])
NOT FOR REPLICATION 
GO
ALTER TABLE [dbo].[Out_Stock] NOCHECK CONSTRAINT [FK_OUT_STOC_REFERENCE_RESERVE]
GO
ALTER TABLE [dbo].[Reserve]  WITH NOCHECK ADD  CONSTRAINT [FK_RESERVE_REFERENCE_STOCK] FOREIGN KEY([Sid])
REFERENCES [dbo].[Stock] ([Sid])
NOT FOR REPLICATION 
GO
ALTER TABLE [dbo].[Reserve] NOCHECK CONSTRAINT [FK_RESERVE_REFERENCE_STOCK]
GO
ALTER TABLE [dbo].[Stock]  WITH NOCHECK ADD  CONSTRAINT [FK_STOCK_REFERENCE_COMMODIT] FOREIGN KEY([Dno])
REFERENCES [dbo].[Commodity] ([Dno])
NOT FOR REPLICATION 
GO
ALTER TABLE [dbo].[Stock] NOCHECK CONSTRAINT [FK_STOCK_REFERENCE_COMMODIT]
GO
ALTER TABLE [dbo].[Commodity]  WITH CHECK ADD  CONSTRAINT [CKC_DCATE_COMMODIT] CHECK  (([Dcate]='中成药' OR [Dcate]='草药' OR [Dcate]='中药'))
GO
ALTER TABLE [dbo].[Commodity] CHECK CONSTRAINT [CKC_DCATE_COMMODIT]
GO
ALTER TABLE [dbo].[Commodity]  WITH CHECK ADD  CONSTRAINT [CKT_COMMODITY] CHECK  (([Dcate]='中成药' OR [Dcate]='草药' OR [Dcate]='中药'))
GO
ALTER TABLE [dbo].[Commodity] CHECK CONSTRAINT [CKT_COMMODITY]
GO
ALTER TABLE [dbo].[Out_Stock]  WITH CHECK ADD  CONSTRAINT [CKC_OAMOUNT_OUT_STOC] CHECK  (([Oamount]>(0)))
GO
ALTER TABLE [dbo].[Out_Stock] CHECK CONSTRAINT [CKC_OAMOUNT_OUT_STOC]
GO
ALTER TABLE [dbo].[Out_Stock]  WITH CHECK ADD  CONSTRAINT [CKT_OUT_STOCK] CHECK  (([Oprice]>(0)))
GO
ALTER TABLE [dbo].[Out_Stock] CHECK CONSTRAINT [CKT_OUT_STOCK]
GO
ALTER TABLE [dbo].[Stock]  WITH CHECK ADD  CONSTRAINT [CKC_SAMOUNT_STOCK] CHECK  (([Samount]>(0)))
GO
ALTER TABLE [dbo].[Stock] CHECK CONSTRAINT [CKC_SAMOUNT_STOCK]
GO
ALTER TABLE [dbo].[Stock]  WITH CHECK ADD  CONSTRAINT [CKC_SPRICE_STOCK] CHECK  (([Sprice]>(0)))
GO
ALTER TABLE [dbo].[Stock] CHECK CONSTRAINT [CKC_SPRICE_STOCK]
GO
ALTER TABLE [dbo].[Stock]  WITH CHECK ADD  CONSTRAINT [CKC_VTIME_STOCK] CHECK  (([Vtime]>[Stime]))
GO
ALTER TABLE [dbo].[Stock] CHECK CONSTRAINT [CKC_VTIME_STOCK]
GO
/****** Object:  StoredProcedure [dbo].[Out]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/*
create TRIGGER UpIn
   ON  Stock
   FOR Insert
AS 
	declare @仓位号 INT
	declare @进货编号 INT
	declare @库存数量 INT
	select @进货编号=Sid
		from INSERTED
	select @库存数量=Samount
		from INSERTED
	select @仓位号=(1000*RAND())
begin	
	insert
	into Reserve
	values (@仓位号,@进货编号,@库存数量)
	


END

create TRIGGER Up
   ON  Out_Stock
   FOR INSERT
AS 
	declare	@仓位号 int
	declare @数量 int
	declare @库存数量 int
	select @仓位号=Rno
		from INSERTED
	
	if exists(select * from Reserve where Rno=@仓位号)
		BEGIN
		select @数量=Oamount
		from INSERTED
		select @库存数量=Ramount
		from  Reserve where Rno=@仓位号
		if @库存数量-@数量<1
			BEGIN
			ROLLBACK TRAN
			print '库存量不足，不允许出库'
			END
		else
			update Reserve set Ramount =@库存数量-@数量 where Rno=@仓位号

END

create TRIGGER  UpDates
   ON  Reserve
   FOR INSERT
AS 
	declare @仓位号 int 
		BEGIN
		select @仓位号=Rno
		from INSERTED
		if exists(select * from Reserve where Rno=@仓位号)
			print '成功入库'
		else
			BEGIN
				ROLLBACK TRAN
				print '该仓位已满，请更换仓位'
			END


END

create PROCEDURE Commodity_insert
	@药品编号   varchar(8),
	@药品类别   varchar(20),
	@药品名称   varchar(20),
	@产地   varchar(20)
AS
	if exists(select * from Commodity where Dno=@药品编号)
		Rollback TransAction
	else
		insert 
		into Commodity(Dno,Dcate,Dname,place)
		values(@药品编号,@药品类别,@药品名称,@产地)
*/
create PROCEDURE [dbo].[Out]
	@仓位号 varchar(8) ,
	@数量 int 
	
AS
	
	if exists(select * from Reserve where Rno=@仓位号)
	BEGIN
		if((select Ramount from Reserve where Rno=@仓位号) > @数量 )
		BEGIN 
			update Reserve set Ramount =(select Ramount from Reserve where Rno=@仓位号)-@数量 where Rno=@仓位号
		END
		
	END
		else
		BEGIN
			return 0
		END
GO
/****** Object:  StoredProcedure [dbo].[SearchOut_Stock]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/*CREATE VIEW 进货情况
AS
SELECT   Stock.Sid, commodity.dno, commodity.dname, reserve.rno, stock.stime, 
                stock.vtime, stock.samount, commodity.dcate, commodity.place, stock.sprice
FROM      commodity  INNER JOIN stock 
                 ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = stock.sid
GO


CREATE VIEW 销售情况
AS
SELECT   Out_stock.oid, stock.dno, out_stock.cno, out_stock.ono, commodity.dname, out_stock.oprice, 
                stock.samount, out_stock.oamount, reserve.ramount, commodity.dcate, out_stock.Rno, 
                out_stock.Otime
FROM      commodity INNER JOIN
                stock ON commodity.dno = stock.Dno INNER JOIN
                reserve ON stock.sid = reserve.sid INNER JOIN
                out_stock ON reserve.rno = out_stock.rno
GO


CREATE VIEW 仓库情况
AS
SELECT   reserve.rno, commodity.dno, stock.sid, commodity.dcate, commodity.dname, 
                stock.stime, stock.vtime, reserve.ramount, commodity.place
FROM      Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO

CREATE VIEW 选项卡
AS
SELECT   commodity.dcate, commodity.dname, commodity.place, reserve.ramount, stock.ptime, 
                stock.stime, stock.vtime
FROM     Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
*/
/*
create TRIGGER UpIn
   ON  Stock
   FOR Insert
AS 
	declare @仓位号 INT
	declare @进货编号 INT
	declare @库存数量 INT
	select @进货编号=Sid
		from INSERTED
	select @库存数量=Samount
		from INSERTED
	select @仓位号=(1000*RAND())
begin	
	insert
	into Reserve
	values (@仓位号,@进货编号,@库存数量)
	


END

create TRIGGER Up
   ON  Out_Stock
   FOR INSERT
AS 
	declare	@仓位号 int
	declare @数量 int
	declare @库存数量 int
	select @仓位号=Rno
		from INSERTED
	
	if exists(select * from Reserve where Rno=@仓位号)
		BEGIN
		select @数量=Oamount
		from INSERTED
		select @库存数量=Ramount
		from  Reserve where Rno=@仓位号
		if @库存数量-@数量<1
			BEGIN
			ROLLBACK TRAN
			print '库存量不足，不允许出库'
			END
		else
			update Reserve set Ramount =@库存数量-@数量 where Rno=@仓位号

END

create TRIGGER  UpDates
   ON  Reserve
   FOR INSERT
AS 
	declare @仓位号 int 
		BEGIN
		select @仓位号=Rno
		from INSERTED
		if exists(select * from Reserve where Rno=@仓位号)
			print '成功入库'
		else
			BEGIN
				ROLLBACK TRAN
				print '该仓位已满，请更换仓位'
			END


END

create PROCEDURE Commodity_insert
	@药品编号   varchar(8),
	@药品类别   varchar(20),
	@药品名称   varchar(20),
	@产地   varchar(20)
AS
	if exists(select * from Commodity where Dno=@药品编号)
		Rollback TransAction
	else
		insert 
		into Commodity(Dno,Dcate,Dname,place)
		values(@药品编号,@药品类别,@药品名称,@产地)

create PROCEDURE Out
	@仓位号 varchar(8) ,
	@数量 int 
	
AS
	
	if exists(select * from Reserve where Rno=@仓位号)
	BEGIN
		if((select Ramount from Reserve where Rno=@仓位号) > @数量 )
		BEGIN 
			update Reserve set Ramount =(select Ramount from Reserve where Rno=@仓位号)-@数量 where Rno=@仓位号
		END
		
	END
		else
		BEGIN
			return 0
		END
		
		create PROCEDURE PrintAll_Commodity
AS
	select * from commodity
	

	create PROCEDURE Stock_insert
	@进货编号 varchar(8),
	@药品编号   varchar(8),
	@生产日期   datetime,
	@进货日期   datetime,
	@有效期		datetime,
	@进货单价	 float ,
	@进货数量  int 
AS
	if exists(select * from Stock where Sid=@进货编号)
		Rollback TransAction
	else
		insert 
		into Stock(Sid,Dno,Ptime,Stime,Vtime,Samount,Sprice)
		values(@进货编号,@药品编号,@生产日期,@进货日期,@有效期,@进货单价,@进货数量)
		

		create PROCEDURE Out_Stock_insert
	@销售编号 varchar(8),
	@进货编号 varchar(8),
	@仓位号   varchar(8),
	@销售单价 float,
	@销售数量 int,
	@柜台号	  varchar(8),
	@销售人工号 varchar(8),
	@销售日期 datetime
AS
	if exists(select * from Out_Stock where Oid=@销售编号)
		Rollback TransAction
	else
		insert 
		into Sale(销售编号,进货编号,仓位号,销售单价,销售数量,柜台号,销售人工号,销售日期)
		values(@销售编号,@进货编号,@仓位号,@销售单价,@销售数量,@柜台号,@销售人工号,@销售日期)
	

	CREATE PROCEDURE SearchStock
	@药品名称	varchar(20),
	@药品类别	varchar(20),
	@产地		varchar(20)
AS
		
		if(@药品名称 is not  null and @药品类别 is not null and @产地 is not null )
		BEGIN
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 and place=@产地
		END
	if(@药品名称 is   null and @药品类别 is  null  and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where place=@产地
		
	if(@药品类别 is not null and  @药品名称 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称
	if(@药品名称 is not null and  @药品类别 is  not null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称  and place=@产地
	if(@药品名称 is  null and  @药品类别 is  not null and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 and place=@产地 


GO
*/
CREATE PROCEDURE [dbo].[SearchOut_Stock]
	@药品名称 varchar(20),
	@药品类别 varchar(20)
AS
	
		if(@药品名称 is not  null and @药品类别 is not null )
		BEGIN
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where dname=@药品名称 and dcate=@药品类别
		END
	if(@药品名称 is  not null and @药品类别 is  null)
		
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where  dname=@药品名称
		
	if(@药品类别 is not null and  @药品名称 is  null)
		
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where dcate=@药品类别 


GO
/****** Object:  StoredProcedure [dbo].[SearchRV]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/*CREATE VIEW 进货情况
AS
SELECT   Stock.Sid, commodity.dno, commodity.dname, reserve.rno, stock.stime, 
                stock.vtime, stock.samount, commodity.dcate, commodity.place, stock.sprice
FROM      commodity  INNER JOIN stock 
                 ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = stock.sid
GO


CREATE VIEW 销售情况
AS
SELECT   Out_stock.oid, stock.dno, out_stock.cno, out_stock.ono, commodity.dname, out_stock.oprice, 
                stock.samount, out_stock.oamount, reserve.ramount, commodity.dcate, out_stock.Rno, 
                out_stock.Otime
FROM      commodity INNER JOIN
                stock ON commodity.dno = stock.Dno INNER JOIN
                reserve ON stock.sid = reserve.sid INNER JOIN
                out_stock ON reserve.rno = out_stock.rno
GO


CREATE VIEW 仓库情况
AS
SELECT   reserve.rno, commodity.dno, stock.sid, commodity.dcate, commodity.dname, 
                stock.stime, stock.vtime, reserve.ramount, commodity.place
FROM      Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO

CREATE VIEW 选项卡
AS
SELECT   commodity.dcate, commodity.dname, commodity.place, reserve.ramount, stock.ptime, 
                stock.stime, stock.vtime
FROM     Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
*/
/*
create TRIGGER UpIn
   ON  Stock
   FOR Insert
AS 
	declare @仓位号 INT
	declare @进货编号 INT
	declare @库存数量 INT
	select @进货编号=Sid
		from INSERTED
	select @库存数量=Samount
		from INSERTED
	select @仓位号=(1000*RAND())
begin	
	insert
	into Reserve
	values (@仓位号,@进货编号,@库存数量)
	


END

create TRIGGER Up
   ON  Out_Stock
   FOR INSERT
AS 
	declare	@仓位号 int
	declare @数量 int
	declare @库存数量 int
	select @仓位号=Rno
		from INSERTED
	
	if exists(select * from Reserve where Rno=@仓位号)
		BEGIN
		select @数量=Oamount
		from INSERTED
		select @库存数量=Ramount
		from  Reserve where Rno=@仓位号
		if @库存数量-@数量<1
			BEGIN
			ROLLBACK TRAN
			print '库存量不足，不允许出库'
			END
		else
			update Reserve set Ramount =@库存数量-@数量 where Rno=@仓位号

END

create TRIGGER  UpDates
   ON  Reserve
   FOR INSERT
AS 
	declare @仓位号 int 
		BEGIN
		select @仓位号=Rno
		from INSERTED
		if exists(select * from Reserve where Rno=@仓位号)
			print '成功入库'
		else
			BEGIN
				ROLLBACK TRAN
				print '该仓位已满，请更换仓位'
			END


END

create PROCEDURE Commodity_insert
	@药品编号   varchar(8),
	@药品类别   varchar(20),
	@药品名称   varchar(20),
	@产地   varchar(20)
AS
	if exists(select * from Commodity where Dno=@药品编号)
		Rollback TransAction
	else
		insert 
		into Commodity(Dno,Dcate,Dname,place)
		values(@药品编号,@药品类别,@药品名称,@产地)

create PROCEDURE Out
	@仓位号 varchar(8) ,
	@数量 int 
	
AS
	
	if exists(select * from Reserve where Rno=@仓位号)
	BEGIN
		if((select Ramount from Reserve where Rno=@仓位号) > @数量 )
		BEGIN 
			update Reserve set Ramount =(select Ramount from Reserve where Rno=@仓位号)-@数量 where Rno=@仓位号
		END
		
	END
		else
		BEGIN
			return 0
		END
		
		create PROCEDURE PrintAll_Commodity
AS
	select * from commodity
	

	create PROCEDURE Stock_insert
	@进货编号 varchar(8),
	@药品编号   varchar(8),
	@生产日期   datetime,
	@进货日期   datetime,
	@有效期		datetime,
	@进货单价	 float ,
	@进货数量  int 
AS
	if exists(select * from Stock where Sid=@进货编号)
		Rollback TransAction
	else
		insert 
		into Stock(Sid,Dno,Ptime,Stime,Vtime,Samount,Sprice)
		values(@进货编号,@药品编号,@生产日期,@进货日期,@有效期,@进货单价,@进货数量)
		

		create PROCEDURE Out_Stock_insert
	@销售编号 varchar(8),
	@进货编号 varchar(8),
	@仓位号   varchar(8),
	@销售单价 float,
	@销售数量 int,
	@柜台号	  varchar(8),
	@销售人工号 varchar(8),
	@销售日期 datetime
AS
	if exists(select * from Out_Stock where Oid=@销售编号)
		Rollback TransAction
	else
		insert 
		into Sale(销售编号,进货编号,仓位号,销售单价,销售数量,柜台号,销售人工号,销售日期)
		values(@销售编号,@进货编号,@仓位号,@销售单价,@销售数量,@柜台号,@销售人工号,@销售日期)
	

	CREATE PROCEDURE SearchStock
	@药品名称	varchar(20),
	@药品类别	varchar(20),
	@产地		varchar(20)
AS
		
		if(@药品名称 is not  null and @药品类别 is not null and @产地 is not null )
		BEGIN
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 and place=@产地
		END
	if(@药品名称 is   null and @药品类别 is  null  and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where place=@产地
		
	if(@药品类别 is not null and  @药品名称 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称
	if(@药品名称 is not null and  @药品类别 is  not null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称  and place=@产地
	if(@药品名称 is  null and  @药品类别 is  not null and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 and place=@产地 


GO

CREATE PROCEDURE SearchOut_Stock
	@药品名称 varchar(20),
	@药品类别 varchar(20)
AS
	
		if(@药品名称 is not  null and @药品类别 is not null )
		BEGIN
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where dname=@药品名称 and dcate=@药品类别
		END
	if(@药品名称 is  not null and @药品类别 is  null)
		
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where  dname=@药品名称
		
	if(@药品类别 is not null and  @药品名称 is  null)
		
			select oid,rno,dname,dcate,oamount,oamount,cno,ono,otime from  销售情况 where dcate=@药品类别 


GO

CREATE PROCEDURE SearchRS
	@药品名称 varchar(20),
	@药品类别 varchar(20)
AS	
		if(@药品名称 is not  null and @药品类别 is not null )	
			select sid,dno,dname,dcate,place,stime from 仓储情况 where dname=@药品名称 and dcate=@药品类别
		
	if(@药品名称 is  not null and @药品类别 is  null)
		
			select sid,dno,dname,dcate,place,stime from 仓储情况 where dname=@药品名称 
		
		
	if(@药品类别 is not null and  @药品名称 is  null)
		
			select sid,dno,dname,dcate,place,stime from 仓储情况 where  dcate=@药品类别

GO
*/
CREATE PROCEDURE [dbo].[SearchRV] 
	@药品名称 varchar(20),
	@药品类别 varchar(20)
AS
	if(@药品名称 is null and @药品类别 is null  )
		
			return 0
		
	else	
		if(@药品名称 is not  null and @药品类别 is not null )
			select rno,dname,dcate,stime,vtime,ramount from 仓库情况 where dname=@药品名称 and dcate=@药品类别
	
	if(@药品名称 is  not null and @药品类别 is  null)
		
			select rno,dname,dcate,stime,vtime,ramount from 仓库情况 where dname=@药品名称 
		
	if(@药品类别 is not null and  @药品名称 is  null)
		
			select rno,dname,dcate,stime,vtime,ramount from 仓库情况 where dcate=@药品类别
	
GO
/****** Object:  StoredProcedure [dbo].[SearchStock]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
/*CREATE VIEW 进货情况
AS
SELECT   Stock.Sid, commodity.dno, commodity.dname, reserve.rno, stock.stime, 
                stock.vtime, stock.samount, commodity.dcate, commodity.place, stock.sprice
FROM      commodity  INNER JOIN stock 
                 ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = stock.sid
GO


CREATE VIEW 销售情况
AS
SELECT   Out_stock.oid, stock.dno, out_stock.cno, out_stock.ono, commodity.dname, out_stock.oprice, 
                stock.samount, out_stock.oamount, reserve.ramount, commodity.dcate, out_stock.Rno, 
                out_stock.Otime
FROM      commodity INNER JOIN
                stock ON commodity.dno = stock.Dno INNER JOIN
                reserve ON stock.sid = reserve.sid INNER JOIN
                out_stock ON reserve.rno = out_stock.rno
GO


CREATE VIEW 仓库情况
AS
SELECT   reserve.rno, commodity.dno, stock.sid, commodity.dcate, commodity.dname, 
                stock.stime, stock.vtime, reserve.ramount, commodity.place
FROM      Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO

CREATE VIEW 选项卡
AS
SELECT   commodity.dcate, commodity.dname, commodity.place, reserve.ramount, stock.ptime, 
                stock.stime, stock.vtime
FROM     Commodity INNER JOIN
                stock ON commodity.dno = stock.dno INNER JOIN
                reserve ON stock.sid = reserve.sid
GO
*/
/*
create TRIGGER UpIn
   ON  Stock
   FOR Insert
AS 
	declare @仓位号 INT
	declare @进货编号 INT
	declare @库存数量 INT
	select @进货编号=Sid
		from INSERTED
	select @库存数量=Samount
		from INSERTED
	select @仓位号=(1000*RAND())
begin	
	insert
	into Reserve
	values (@仓位号,@进货编号,@库存数量)
	


END

create TRIGGER Up
   ON  Out_Stock
   FOR INSERT
AS 
	declare	@仓位号 int
	declare @数量 int
	declare @库存数量 int
	select @仓位号=Rno
		from INSERTED
	
	if exists(select * from Reserve where Rno=@仓位号)
		BEGIN
		select @数量=Oamount
		from INSERTED
		select @库存数量=Ramount
		from  Reserve where Rno=@仓位号
		if @库存数量-@数量<1
			BEGIN
			ROLLBACK TRAN
			print '库存量不足，不允许出库'
			END
		else
			update Reserve set Ramount =@库存数量-@数量 where Rno=@仓位号

END

create TRIGGER  UpDates
   ON  Reserve
   FOR INSERT
AS 
	declare @仓位号 int 
		BEGIN
		select @仓位号=Rno
		from INSERTED
		if exists(select * from Reserve where Rno=@仓位号)
			print '成功入库'
		else
			BEGIN
				ROLLBACK TRAN
				print '该仓位已满，请更换仓位'
			END


END

create PROCEDURE Commodity_insert
	@药品编号   varchar(8),
	@药品类别   varchar(20),
	@药品名称   varchar(20),
	@产地   varchar(20)
AS
	if exists(select * from Commodity where Dno=@药品编号)
		Rollback TransAction
	else
		insert 
		into Commodity(Dno,Dcate,Dname,place)
		values(@药品编号,@药品类别,@药品名称,@产地)

create PROCEDURE Out
	@仓位号 varchar(8) ,
	@数量 int 
	
AS
	
	if exists(select * from Reserve where Rno=@仓位号)
	BEGIN
		if((select Ramount from Reserve where Rno=@仓位号) > @数量 )
		BEGIN 
			update Reserve set Ramount =(select Ramount from Reserve where Rno=@仓位号)-@数量 where Rno=@仓位号
		END
		
	END
		else
		BEGIN
			return 0
		END
		
		create PROCEDURE PrintAll_Commodity
AS
	select * from commodity
	

	create PROCEDURE Stock_insert
	@进货编号 varchar(8),
	@药品编号   varchar(8),
	@生产日期   datetime,
	@进货日期   datetime,
	@有效期		datetime,
	@进货单价	 float ,
	@进货数量  int 
AS
	if exists(select * from Stock where Sid=@进货编号)
		Rollback TransAction
	else
		insert 
		into Stock(Sid,Dno,Ptime,Stime,Vtime,Samount,Sprice)
		values(@进货编号,@药品编号,@生产日期,@进货日期,@有效期,@进货单价,@进货数量)
		

		create PROCEDURE Out_Stock_insert
	@销售编号 varchar(8),
	@进货编号 varchar(8),
	@仓位号   varchar(8),
	@销售单价 float,
	@销售数量 int,
	@柜台号	  varchar(8),
	@销售人工号 varchar(8),
	@销售日期 datetime
AS
	if exists(select * from Out_Stock where Oid=@销售编号)
		Rollback TransAction
	else
		insert 
		into Sale(销售编号,进货编号,仓位号,销售单价,销售数量,柜台号,销售人工号,销售日期)
		values(@销售编号,@进货编号,@仓位号,@销售单价,@销售数量,@柜台号,@销售人工号,@销售日期)
	*/

	CREATE PROCEDURE [dbo].[SearchStock]
	@药品名称	varchar(20),
	@药品类别	varchar(20),
	@产地		varchar(20)
AS
		
		if(@药品名称 is not  null and @药品类别 is not null and @产地 is not null )
		BEGIN
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 and place=@产地
		END
	if(@药品名称 is   null and @药品类别 is  null  and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where place=@产地
		
	if(@药品类别 is not null and  @药品名称 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称
	if(@药品名称 is not null and  @药品类别 is  not null and @产地 is  null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称 and dcate=@药品类别 
	if(@药品名称 is not null and  @药品类别 is  null and @产地 is  not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dname=@药品名称  and place=@产地
	if(@药品名称 is  null and  @药品类别 is  not null and @产地 is not null)
		
			select sid,dno,dname,dcate,place,stime,vtime,samount from 进货情况 where dcate=@药品类别 and place=@产地 


GO
/****** Object:  StoredProcedure [dbo].[sumdcate]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sumdcate]
	
AS
	select dcate,SUM(ramount) 库存
	from 仓库情况 
	GROUP BY dcate
GO
/****** Object:  StoredProcedure [dbo].[sumdno]    Script Date: 2019/1/18 10:11:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[sumdno]
@药品编号 int
AS
	select dno,dname,SUM(ramount) 库存
	from 仓库情况 where dno=@药品编号
	GROUP BY dno,dname
GO
