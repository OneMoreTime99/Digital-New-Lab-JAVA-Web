<%-- 
    Document   : PostInTop5
    Created on : Feb 3, 2020, 9:33:40 PM
    Author     : Hoang Viet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>${postById.title}</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <c:if test="${message!=null}" >
                        <h2>${message}</h2>
                    </c:if>
                    <c:if test="${message==null}">
                        <div class="title">
                            ${postById.title}
                        </div>
                        <div class="image">
                            <img src="${imagesId}">
                        </div>
                        <div class="post">
                            ${postById.content}
                        </div>
                        <div class="signature">
                            <div class="icon1"></div>
                            <div class="icon2"></div>
                            By ${postById.author} | ${postById.getDateFormat()}
                        </div>
                    </c:if>
                </div> 
                <jsp:include page="SideBar.jsp"/>   
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
