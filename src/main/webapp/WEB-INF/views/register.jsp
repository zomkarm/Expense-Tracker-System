<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
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
							<h3 class="mb-4"><u>Sign up</u></h3>
							<c:if test="${pageErrorMsg!=null}" >
								<p style="color:red"> ${pageErrorMsg} </p>
							</c:if>
							<c:if test="${pageSuccessMsg!=null}" >
								<p style="color:green"> ${pageSuccessMsg} </p>
							</c:if>
							
						</div>
					</div>
					<form method="post" action="${baseURL}/reg_form" class="signin-form">
						<div class="form-group mb-3">
							<label class="label" for="name">Name</label>
							<input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
						</div>
						
						<div class="form-group mb-3">
							<label class="label" for="name">Email</label> <input
								type="text" class="form-control" id="email" name="email" placeholder="Email" required>
						</div>
						
						<div class="form-group mb-3">
							<label class="label" for="name">Username</label> <input
								type="text" class="form-control"  id="userName" name="userName" placeholder="Username" required>
						</div>
						<div class="form-group mb-3">
							<label class="label" for="password">Password</label> <input
								type="password" class="form-control"  id="password" name="password" placeholder="Password"
								required>
						</div>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary rounded submit px-3">Register</button>
						</div>
						<br>
						<div class="form-group d-md-flex">
							<div class="w-50 text-left">
								<label class="checkbox-wrap checkbox-primary mb-0">Remember
									Me <input type="checkbox" checked> <span
									class="checkmark"></span>
								</label>
							</div>
							<div class="w-50 text-md-right">
								<a href="#">Forgot Password</a>
							</div>
						</div>
					</form>
					<p class="text-center">
						Not a member? <a data-toggle="tab" href="#signup">Sign Up</a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-4">
		
		</div>
	</div>
</div>
