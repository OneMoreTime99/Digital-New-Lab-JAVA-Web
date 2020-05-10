<%-- 
    Document   : SearchByTitle
    Created on : Feb 4, 2020, 9:20:02 PM
    Author     : Hoang Viet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <title>Search by title</title>
    </head>
    <body>
        <script>
            function submit() {
                document.getElementById("submit").submit();
            }
        </script>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <c:forEach items="${listSearch}" var="i">
                        <div class="title-search" >
                            <form id="submit" action="SearchById" method="POST">
                                <a onclick="document.getElementById('id').value = '${i.id}';
                                        submit()" style="cursor: pointer">${i.title}</a>
                                <input type="hidden" value="${i.id}" name="id" id="id">
                            </form>     
                        </div>
                        <div class="image-search" >
                            <img src="./images/${i.images}">
                            ${i.getSynopsisContent()}
                        </div>
                        <br>
                    </c:forEach>
                    <div class="paging">
                        <c:if test="${stringSearch==null}">
                            <h2>${message}</h2>
                        </c:if>
                        <c:if test="${numberPage<1}">
                            <h2>Not found!</h2>
                        </c:if>
                        <c:if test="${numberPage>1}">
                            <form action="SearchByTitle" method="POST">
                                <c:forEach begin="1" end="${numberPage}" var="i">                                
                                    <input class="${i==index?"isChoose":"notChoose"}" type="submit" value="${i}" name="index">
                                    <input type="hidden" value="${stringSearch}" name="stringSearch">
                                </c:forEach> 
                            </form>
                        </c:if>
                    </div>        
                </div>
                <jsp:include page="SideBar.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
