<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<section class="generalwrapper dm-shadow clearfix">
    <div class="container">

        <div class="row">
            <div id="mainBody">
                <div class="container">
                    <table class="table table-bordered">
                        <c:if test="${pageContext.request.remoteUser != null}">
                            <h2>Welcome ${pageContext.request.remoteUser}</h2>
                        </c:if>
                        <thead>
                        <tr>
                            <th>${contextService.get("کد محصول")}</th>
                            <th>${contextService.get("نام محصول")}</th>
                            <th>${contextService.get("تعداد محصول موجود")}</th>
                            <th>${contextService.get("آخرین تارخ به روز رسانی")}</th>
                            <th>${contextService.get("قیمت محصول")}</th>
                            <th></th>
                        </tr>

                        </thead>
                        <tbody>

                        <c:forEach items="${productList}" var="product">
                            <tr>

                                <td>${product.getProductId()}</td>
                                <td>${product.getName()}</td>
                                <td>${product.getQuantity()}</td>
                                <td>${product.getAddTime()}</td>
                                <td>${product.getPrice()}</td>

                                <td>
                                    <a href="<spring:url value="/product/${product.getProductId()}"/>"> <span
                                            class="icon-info-sign icon-2x">info</span></a>
                                    <a href="<spring:url value="/admin/removeProduct/${product.getProductId()}"/>"><i
                                            class="icon-remove icon-2x">delete</i></a>
                                    <a href="<spring:url value="/admin/editProduct/${product.getProductId()}"/>">
                                        <span class="icon-pencil icon-2x">edit</span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <a href="<spring:url value="/admin/addProduct"/> " class="btn btn-primary">
                        ${contextService.get("افرودن محصول جدید")}
                    </a>
                </div>

            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>

