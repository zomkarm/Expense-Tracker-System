<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<s:url var="login_url" value="user_login"/>
<%@ page isELIgnored="false" %>

<s:url var="dash" value="/dashboard"/>
<s:url var="baseURL" value="/"/>

<div class="p-3 bg-primary text-white text-left">
  <h3>Expense Tracker System</h3>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <ul class="navbar-nav">
	    	<c:if test="${sessionScope.userId!=null}">
	    	    <li class="nav-item">
			 		<a class="nav-link" href="${dash}">Dashboard</a>
			 	</li>
		 	</c:if>
      <li class="nav-item">
        <a class="nav-link active" href="${baseURL}">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Help</a>
      </li>
    </ul>
	    
    <ul class="navbar-nav ml-auto">
    	<c:if test="${sessionScope.userId!=null}">
	   	    <li class="nav-item">
		 		<a class="nav-link" href="${baseURL}/logout">Logout</a>
		 	</li>
	 	</c:if>
    	<c:if test="${sessionScope.userId==null}">
	  	    <li class="nav-item">
	              <a class="nav-link" href="${baseURL}/login">
	                Login
	              </a>
	          </li>
	          <li class="nav-item">
	              <a class="nav-link" href="${baseURL}/register">
	                Register
	              </a>
	          </li>
          </c:if>
       </ul>

  </div>
</nav>