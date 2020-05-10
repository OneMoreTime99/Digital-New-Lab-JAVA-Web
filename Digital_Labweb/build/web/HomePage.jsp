<%-- 
    Document   : HomePage
    Created on : Feb 1, 2020, 7:27:54 PM
    Author     : Hoang Viet
--%>

<%@page import="java.util.List"%>
<%@page import="model.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Home page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <div class="title">
                        ${getTop1.title}
                    </div>
                    <div class="image">
                        <img src="./images/${getTop1.images}">
                    </div>
                    <div class="post">
                        ${getTop1.content}
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${getTop1.author} | ${getTop1.getDateFormat()}
                    </div>
                </div>
                <jsp:include page="SideBar.jsp"/>   
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
