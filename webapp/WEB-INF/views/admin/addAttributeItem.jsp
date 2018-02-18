<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<section class="generalwrapper dm-shadow clearfix">
    <div class="container">

        <div class="row">
            <div class="container-warpper">
                <div class="container">
                    <div>
                        <form:form action="${pageContext.request.contextPath}/admin/addAttributeItem" method="post"
                                   commandName="attributeItem" enctype="multipart/form-data">
                            <div class="col-lg-8 col-md-6 col-sm-12 table">
                                <label class="">${contextService.get("نام مشخصه")}</label>
                                <form:errors path="name"
                                             cssStyle="color: #990014"/>
                                <form:input path="name" id="name" cssClass="input-large"/>

                                <form:input path="attributeItemId" id="attributeItemId" type="hidden"
                                            value="${attributeItem.getAttributeItemId()}"/>
                                <input type="submit" class="btn btn-primary" value="${contextService.get("افزودن")}">
                                <a href="<spring:url value="/admin/attributeItemInventory"/>"
                                   class="btn btn-default">${contextService.get("انصراف")}</a>
                            </div>
                        </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>

<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>

