<%@include file="/WEB-INF/views/layout/header.jsp" %>

<div id="mainBody">
    <div class="container">
        <table class="table table-bordered">
            <tbody>
            <c:forEach items="${cart.getCartItemList().toArray()}" var="cartItem">
            <tr>
                <td>${cartItem.getProduct().getProductId()}</td>
                <td>${cartItem.getProduct().getName()}</td>
                <td>${cartItem.getQuantity()}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>
