<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container-warpper">
    <div class="container">
        <div id="login-box">
            <h2>Register Page</h2>
            <form:form name="loginform" action="${pageContext.request.contextPath}/register" method="post" commandName="customer">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;" >${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="email" >ایمیل</label>
                    <form:input path="customerEmail" cssClass="form-control" id="email"/>
                </div>
                <div class="form-group">
                    <label for="password" >Password:</label>
                    <form:password path="customerPassword" cssClass="form-control" id="password"/>
                </div>


                <div class="form-group">
                    <label for="name" >Name:</label>
                    <form:input path="customerName" cssClass="form-control" id="name"/>
                </div>

                <div class="form-group">
                    <label for="phoneNumber" >Phone Number:</label>
                    <form:input path="customerPhoneNumber" cssClass="form-control" id="phoneNumber"/>
                </div>

                <input type="submit" value="Submite" class="btn btn-default"/>
                <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

            </form:form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>


