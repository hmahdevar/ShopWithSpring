<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>

<section class="generalwrapper dm-shadow clearfix">
    <div class="container">
        <div class="row">
            <%@include file="/WEB-INF/views/layout/leftsidebar.jsp" %>
            <div id="content" class="col-lg-7 col-md-6 col-sm-6 col-xs-12 clearfix">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="col-lg-6 col-md-6 col-sm-12">
                    <div class="widget clearfix">
                        <div class="title">
                            <h3>${contextService.get("وارد شوید")}</h3>
                        </div>
                        <c:if test="${not empty logout}">
                            <div class="logout">${logout}</div>
                        </c:if>
                        <c:url value="/j_spring_security_check" var="loginUrl"/>

                        <form id="loginform" method="post" name="loginform" action="${loginUrl}">
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input name="email" id="email" type="text" class="form-control" placeholder="${contextService.get("ایمیل")}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                    <input name="password" id="password" type="password" class="form-control"
                                           placeholder="${contextService.get("رمز ورود")}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> ${contextService.get("مرا بخاطر بسپار")}
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary">${contextService.get("ورود")}</button>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        </form>
                    </div>
                </div><!-- end login -->

                <div class="col-lg-6 col-md-6 col-sm-12">
                    <div class="widget clearfix">
                        <div class="title">
                            <h3>${contextService.get("ثبت نام کنید")}</h3>
                        </div>
                        <form:form id="registerform" name="registerform"
                                   action="${pageContext.request.contextPath}/register"
                                   method="post" commandName="customer">

                            <div class="form-group">
                                <form:input path="customerEmail" type="email" class="form-control" placeholder="${contextService.get('ایمیل')}" />
                            </div>
                            <div class="form-group">
                                <form:input path="customerPassword" type="password" class="form-control"
                                            placeholder="${contextService.get('رمز ورود')}"/>
                            </div>
                            <div class="form-group">
                                <label for="name">${contextService.get('نام و نام خانوادگی(اختیاری)')}</label>
                                <form:input path="customerName" cssClass="form-control" id="name"/>
                            </div>

                            <div class="form-group">
                                <label for="phoneNumber">${contextService.get('شماره تلفن(اختیاری)')}</label>
                                <form:input path="customerPhoneNumber" cssClass="form-control" id="phoneNumber"/>
                            </div>
                            <div class="form-group">
                                <a href="<c:url value="/" />" class="btn btn-default">${contextService.get('انصراف')}</a>
                                <input type="submit" class="btn btn-primary" value="${contextService.get('عضویت')}">

                            </div>
                        </form:form>
                    </div>
                </div><!-- end register -->
            </div>
            <%@include file="/WEB-INF/views/layout/rightsidebar.jsp" %>
        </div>

    </div>

</section>
<!-- end content -->
<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>

