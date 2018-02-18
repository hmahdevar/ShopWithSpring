<%@include file="/WEB-INF/views/layout/header.jsp" %>


<div class="container-warpper">
    <div class="container">
        <div id="mainBody">
            <div class="container">
                <form:form action="${pageContext.request.contextPath}/admin/editProduct" method="post" commandName="product" enctype="multipart/form-data">
                    <div class="form">
                        <input type="hidden" name="productId" value="${product.getProductId()}">
                        <label  class="">Name</label><form:errors path="name" cssStyle="color: #990014"/>
                        <form:input path="name" id="name" cssClass="input-large"/>
                        <label  class="">Description</label>
                        <form:input path="description" id="description" cssClass="input-large"/>
                        <label  class="">SummaryDescripation</label>
                        <form:input path="summaryDescription" id="summaryDescription" cssClass="input-large"/>

                        <label  class="">Quantity</label><form:errors path="quantity" cssStyle="color: #990014"/>
                        <form:input path="quantity" id="quantity" cssClass="input-large"/>
                        <label  class="">Price</label><form:errors path="price" cssStyle="color: #990014"/>
                        <form:input path="price" id="price" cssClass="input-large"/>


                        <input type="submit" value="add">
                        <a href="<spring:url value="/admin/productInventory"/> " >Cancel</a>
                    </div>
                </form:form>

            </div>

        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/layout/footer.jsp" %>

