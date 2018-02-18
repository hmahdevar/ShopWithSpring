<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<%--product content--%>
<section class="generalwrapper dm-shadow clearfix">
<div class="container">
    <div class="row">

        <div id="content" class=" first left col-lg-10 col-md-6 col-sm-6 col-xs-12 clearfix">

            <c:forEach items="${productList.toArray()}" var="product">
                <div class="boxes agencies_widget">

                    <div class="col-lg-9">
                        <div class="agencies_desc">
                            <h3 class="title">${product.getName()}</h3>


                                <%--<a href="single-agency.html" class="btn btn-primary btn-sm">About Agencie</a> <a href="list-view.html" class="btn btn-primary btn-sm">Assigned Properties</a>--%>

                        </div><!-- agencies_desc -->

                        <div>
                            <div class="tab-content tabbed_widget clearfix">
                                <div class="property_desc clearfix">
                                    <ul class="nav nav-tabs" style="float: right">
                                        <li class=""><a href="#tab2${product.getProductId()}" data-toggle="tab">${contextService.get("معرفی محصول")}</a>
                                        </li>
                                        <li class="active"><a href="#tab${product.getProductId()}" data-toggle="tab">${contextService.get("مشخصات")}</a>
                                        </li>
                                    </ul>
                                </div>


                                <div class="tab-pane active" id="tab${product.getProductId()}">
                                    <div id="showtable">
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
                                </div>
                                <div class="tab-pane" id="tab2${product.getProductId()}">
                                    <p>${product.getDescription()}</p>
                                </div>


                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="image">
                            <img class="img-responsive img-thumbnail right"
                                 src="<c:url value="/resources/img/14.JPG" />" alt="">
                        </div><!-- end agencies img -->
                        <div class="">

                            <div class="well ">
                                <h4><span class="label label-danger pull-left">${product.getPrice()}</span>${contextService.get("قیمت")}</h4>
                                <h4><span class="label label-primary pull-left">9878</span> ${contextService.get("قیمت نهایی")}</h4>
                                <h4><span class="label label-success pull-left">50</span> ${contextService.get("مقدار تخفیف")}</h4>
                                <div class="">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="fa fa-shopping-cart"></span></span>
                                        <c:if test="${product.getQuantity()>0}">
                                            <select class="form-control input-sm"
                                                    id="quantity${product.getProductId()}">
                                                <% for (int i = 1; i < 11; i += 1) { %>
                                                <option><%=i%></option>
                                                <% } %>

                                            </select>

                                        </c:if>


                                    </div>


                                </div>
                                <span class="label">
                                                        <div class="row">
                                                            <div id="header-right-container"
                                                                 class="col-lg-3 col-md-4 col-sm-4 col-xs-12"
                                                                 >

                                                            </div>
                                                        </div>
                                                    </span>
                                <span class="label center-bt">
                                                         <button id="${product.getProductId()}"
                                                                 class="btn btn-primary addToCart">${contextService.get("اضافه به سبد خرید")}</button>
                                                                                                           </span>


                            </div>
                        </div>
                    </div>
                        <%--<div class="clearfix"></div>--%>
                        <%--<div class="agencies_meta">--%>
                        <%--<span><i class="fa fa-envelope"></i> <a href="mailto:support@sitename.com">support@sitename.com</a></span>--%>
                        <%--<span><i class="fa fa-link"></i> <a href="#">www.sitename.com</a></span>--%>
                        <%--<span><i class="fa fa-phone-square"></i> +1 232 444 55 66</span>--%>
                        <%--</div><!-- end agencies_meta -->--%>
                </div>
                <!-- end boxes -->
            </c:forEach>
            <div class="pagination_wrapper clearfix">
                <!-- Pagination Normal -->
                <ul class="pagination">
                    <li><a href="#">Â«</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li class="disabled"><a href="#">Â»</a></li>
                </ul>
            </div>

        </div><!-- end content -->
        <%@include file="/WEB-INF/views/layout/rightsidebar.jsp"%>


        <!-- end sidebar -->

    </div><!-- end row -->
</div>
<!-- end container -->
</section>
<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>
