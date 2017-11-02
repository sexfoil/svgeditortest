<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

    <!-- Editing page -->
    <div class="jumbotron">
      <div class="container">
        <div class="col-xs-12" align="center">
		
		<c:if test="${sessionScope.editing == false}">			
			<br>Invalid format of file! It must be SVG-file only!
		</c:if>		
		<c:if test="${sessionScope.nofile != null}">			
			<br>${sessionScope.nofile}
		</c:if>		
		<c:if test="${sessionScope.editImage != null}">	
			${sessionScope.editImage}			
		</c:if>
		
		</div>
      </div>
    </div>

<%@ include file="footer.jsp" %>
