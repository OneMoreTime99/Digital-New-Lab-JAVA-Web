USE [digital_HoangViet]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 4/12/2020 4:46:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](50) NULL,
	[image] [nvarchar](250) NULL,
	[content] [text] NULL,
	[date] [date] NULL,
	[author] [nvarchar](50) NULL,
 CONSTRAINT [PK_Article] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Article] ON 

INSERT [dbo].[Article] ([id], [title], [image], [content], [date], [author]) VALUES (1, N'Making security feeds smaster via machine learning', N'i1.jpg', N'IN today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report.<br>It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.<br>While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi.<br>', CAST(N'2020-04-15' AS Date), N'Hoang Viet1')
INSERT [dbo].[Article] ([id], [title], [image], [content], [date], [author]) VALUES (2, N'Elevenia tawarkan layanan Mokado1', N'i1.jpg', N'“Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics.<br>“This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for,” he says, in a conversation with Digital News Asia (DNA) in Singapore recently.<br>“We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves,” he adds.', CAST(N'2020-04-14' AS Date), N'Hoang Viet2')
INSERT [dbo].[Article] ([id], [title], [image], [content], [date], [author]) VALUES (3, N'Elevenia tawarkan layanan Mokado2', N'i1.jpg', N'“Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics.<br>“This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for,” he says, in a conversation with Digital News Asia (DNA) in Singapore recently.<br>“We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves,” he adds.', CAST(N'2012-04-13' AS Date), N'Hoang Dinh Viet1')
INSERT [dbo].[Article] ([id], [title], [image], [content], [date], [author]) VALUES (4, N'Elevenia tawarkan layanan Mokado3', N'i1.jpg', N'IN today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report.<br>It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.<br>While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi.<br>', CAST(N'2012-04-12' AS Date), N'Hoang Dinh Viet2')
INSERT [dbo].[Article] ([id], [title], [image], [content], [date], [author]) VALUES (5, N'Making security feeds smaster via machine1', N'i1.jpg', N'IN today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report.<br>It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.<br>While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi.<br>', CAST(N'2012-04-11' AS Date), N'Hoang Dinh Viet3')
SET IDENTITY_INSERT [dbo].[Article] OFF
