<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<%--product content--%>
<section class="generalwrapper dm-shadow clearfix">
    <div class="container">
        <div class="row">


            <div id="content" class="first col-lg-10 col-md-6 col-sm-6 col-xs-12 clearfix">


                <div class="col-lg-8 col-md-6 col-sm-12">
                    <table class="table table-bordered">

                        <tbody>

                        <tr>
                            <td>${contextService.get("نام محصول")}</td>
                            <td>${product.getName()}</td>
                        </tr>


                        <c:forEach items="${product.getAttributeList().toArray()}" var="attribute">
                            <tr>
                                <td>${attribute.getAttributeItemName()}</td>
                                <td>${attribute.getValue()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="col-lg-4 col-md-6 col-sm-12">
                    <div data-effect="slide-right" class="effect-slide-right in row"
                         style="transition: all 0.7s ease-in-out 0s;">
                        <img class="" src="<c:url value="/resources/img/14.JPG" />" alt="">
                    </div><!-- image-container -->
                    <br>


                </div>


                <div class="clearfix"></div>
                <div class="row boxes agencies_widget " >
                    <span class="col-lg-3">
                         <button id="${product.getProductId()}"
                                 class="btn btn-primary pull-left addToCart ">${contextService.get("اضافه به سبد خرید")}</button>
                        <c:if test="${product.getQuantity()>0}">
                            <select class="form-control" style="width: 35%;"
                                    id="quantity${product.getProductId()}">
                                <% for (int i = 1; i < 11; i += 1) { %>
                                <option><%=i%></option>
                                <% } %>

                            </select>

                        </c:if>

                    </span>
                    <h4 class="col-lg-3"><span
                            class="label label-success pull-left">50</span> ${contextService.get("مقدار تخفیف")}</h4>

                    <h4 class="col-lg-3"><span
                            class="label label-primary pull-left">9878</span> ${contextService.get("قیمت نهایی")}</h4>
                    <h4 class="col-lg-3"><span
                            class="label label-danger pull-left">${product.getPrice()}</span>${contextService.get("قیمت")}
                    </h4>

                </div>
                <hr>
                <div>
                    <p>
                        ${product.getDescription()}
                    </p>

                </div>
                <hr>
                <div>
                    <p>
                        ${product.getSummaryDescription()}
                    </p>

                </div>

            </div>
            <%@include file="/WEB-INF/views/layout/rightsidebar.jsp" %>
        </div>

    </div>

</section>
<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>
