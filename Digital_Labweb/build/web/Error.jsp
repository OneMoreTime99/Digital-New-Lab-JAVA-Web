<%-- 
    Document   : Error
    Created on : Feb 28, 2020, 9:09:37 AM
    Author     : Hoang Viet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content"> 
                <div class="main">  
                    <h2>${message}</h2>
                     <h2>${error}</h2>
                </div> 
                <jsp:include page="SideBar.jsp"/>   
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
