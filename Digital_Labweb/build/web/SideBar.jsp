<%-- 
    Document   : Right
    Created on : Feb 1, 2020, 9:05:11 PM
    Author     : Hoang Viet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/sideBar.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <script>
            function submit() {
                document.getElementById("submit").submit();
            }
        </script>
        <div class="side-bar">
            <div class="new">
                <div class="new-title">
                    <span>Digital News</span>
                </div>
                <div class="synopsis">
                    ${synopsis}
                </div>
            </div>
            <div class="new">
                <div class="new-title">
                    <span>Search</span> 
                </div>
                <form action="SearchByTitle" method="POST">
                    <input class="searchBox" type="text" name="stringSearch" value="${stringSearch}" size="15" >
                    <input class="searchButton" type="submit" name="search" value="Go">
                </form>
            </div>
            <div class="new">
                <div class="new-title">
                    <span>Last Article</span>
                </div>
                <form id="submit" action="SearchById" method="POST">
                    <c:forEach items="${getTop5}" var="i">
                        <div class="last-article">
                            <a onclick="document.getElementById('id').value='${i.id}';submit()">${i.title}</a>
                            <input type="hidden" value="${i.id}" name="id" id="id">
                        </div>
                    </c:forEach>
                </form>             
            </div>
        </div>
    </body>
</html>
