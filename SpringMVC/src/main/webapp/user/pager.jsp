<%--
  author Tency
  
  Date 2016/11
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<pg:pager maxPageItems="5" items="${param.items }" export="curPage=pageNumber" url="${param.url }">

<ul class="pager">

  <li><pg:prev><a href="${pageUrl }">Previous</a></pg:prev></li>
  
  <li><pg:pages>
  <c:if test="${curPage eq pageNumber }">${pageNumber }</c:if>
  <c:if test="${curPage ne pageNumber }"><a href="${pageUrl }">${pageNumber }</a></c:if>
  </pg:pages></li>
  
  <li><pg:next><a href="${pageUrl }">Next</a></pg:next></li>
</ul> 

</pg:pager>