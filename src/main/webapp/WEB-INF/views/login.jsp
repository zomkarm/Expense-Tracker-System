<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<s:url var="login_url" value="user_login"/>
<%@ page isELIgnored="false" %>
<div class="container">
	<div class="row">
		<div class="col-md-4">

		</div>
		<div class="col-md-4">
			<div class="wrap d-md-flex" >
				<div class="img">
				</div>
				<div class="login-wrap p-4 p-md-5">
					<div class="d-flex">
						<div class="w-100 center">
							<h3 class="mb-4"><u>Sign in</u></h3>
							<c:if test="${pageErrorMsg!=null}" >
								<p style="color:red"> ${pageErrorMsg} </p>
							</c:if>
						</div>
					</div>
					<f:form action="${login_url}" modelAttribute="login" method="post">
						<div class="form-group mb-3">
							<label class="label" for="name">Username</label> 
							<f:input cssClass="form-control" path="userName" name="userName" id="userName" placeholder="Username" required="required"/>
						</div>
						<div class="form-group mb-3">
							<label class="label" for="password">Password</label>
							<f:input cssClass="form-control" path="password" name="password" id="password" placeholder="Password" required="required"/>
						</div>
						<div class="form-group d-md-flex">
							<div class="w-50 text-left">
								<label class="checkbox-wrap checkbox-primary mb-0">
									<input type="checkbox" checked> <span
									class="checkmark"></span>Remember Me 
								</label>
							</div>
							<div class="w-50 text-md-right">
								<a href="#">Forgot Password</a>
							</div>
						</div><br>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary rounded submit px-3">Sign
								In</button>
						</div>
					</f:form>
				</div>
			</div>
		</div>
		<div class="col-md-4">
		
		</div>
	</div>
</div>
