<%--
  Created by IntelliJ IDEA.
  User: jekss
  Date: 23.10.15
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_header.jsp"/>

<div class="company">
    <c:forEach var="comp" items="${allCompany}">
        <div class="allcompany">
            <img src="${pageContext.request.contextPath}/pages/img/errImg.png"/>
            <a href="/company/${comp.id}" ><c:out value="${comp.nameCompany}"/></a>
        </div>
    </c:forEach>
</div>


