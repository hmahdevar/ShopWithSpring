<%@include file="/WEB-INF/views/header.jsp" %>

<div id="mainBody">
    <div class="container">
        <table class="table table-bordered">
            <%--<c:if test="${pageContext.request.remoteUser != null}">--%>
                <%--<h2>Welcome ${pageContext.request.remoteUser}</h2>--%>
            <%--</c:if>--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th>Name</th>--%>
                <%--&lt;%&ndash;<th>Category</th>&ndash;%&gt;--%>
                <%--<th>Description</th>--%>
                <%--<th>SummaryDescripation</th>--%>
                <%--<th>Quantity</th>--%>
                <%--<th>Addtime</th>--%>
                <%--<th>Price</th>--%>
                <%--<th></th>--%>
            <%--</tr>--%>

            <%--</thead>--%>
            <%--<tbody>--%>

            <%--<c:forEach items="${productList}" var="product">--%>
                <%--<tr>--%>

                    <%--<td>${product.getName()}</td>--%>
                    <%----%>
                    <%--<td>${product.getDescription()}</td>--%>
                    <%--<td>${product.getSummaryDescription()}</td>--%>
                    <%--<td>${product.getQuantity()}</td>--%>
                    <%--<td>${product.getAddTime()}</td>--%>

                    <%--<td>${product.getPrice()}</td>--%>

                    <%--<td><a href="<spring:url value="/ProductList/Product/${product.getProductId()}"/>"> <span--%>
                            <%--class="icon-info-sign icon-2x"></span></a>--%>
                        <%--<a href="<spring:url value="/Admin/ProductInventory/DeleteProduct/${product.getProductId()}"/>"><i--%>
                                <%--class="icon-remove icon-2x"></i></a>--%>
                        <%--<a href="<spring:url value="/Admin/ProductInventory/EditProduct/${product.getProductId()}"/>">--%>
                            <%--<span class="icon-pencil icon-2x"></span>--%>
                        <%--</a>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        </table>

        <%--<a href="<spring:url value="/admin/addProduct"/> " class=" btn-link">Add Product</a>--%>
    </div>

</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
