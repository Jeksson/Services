<%--
  Created by IntelliJ IDEA.
  User: jekss
  Date: 05.11.15
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="_header.jsp"/>

name: ${company.nameCompany}<br/>
tell: ${company.tellCompany}<br/>
mail: ${company.mailCompany}<br/>

<div>
  <c:forEach var="adress" items="${company.adressCompanySet}">
    <c:if test="${adress.city.cityName != null}">
      Adress:
      <div style="border: solid black 1px;">
        city: <c:out value="${adress.city.cityName}"/><br/>
        street: <c:out value="${adress.street}"/><br/>
        numberHome: <c:out value="${adress.numberHouse}"/><br/>
      </div>
    </c:if>

  </c:forEach>
</div>
sales: ${company.sales.salesName}<br/>
<div>
  <c:forEach var="services" items="${company.servicesSet}">
    <c:if test="${services.name != null}">
     Services:
      <div style="border: solid chartreuse 2px">
        name: <c:out value="${services.name}"/><br/>
        description: <c:out value="${services.description}"/>
      </div>
    </c:if>

  </c:forEach>
</div>

