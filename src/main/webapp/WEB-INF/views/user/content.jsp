<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<s:url var="login_url" value="user_login"/>
<%@ page isELIgnored="false" %>

<div class="container mt-5">
	<div class="row">
		${sessionScope.user.getUserName()}
	</div>
</div>