<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<section class="generalwrapper dm-shadow clearfix">
    <div class="container">

        <div class="row">
            <div class="container-warpper">
                <div class="container">

                    <form:form action="${pageContext.request.contextPath}/admin/addProduct" method="post"
                               commandName="product" enctype="multipart/form-data"
                               cssClass="boxes clearfix">
                        <form:errors
                                     cssStyle="color: #990014"/>
                        <form:input path="productId" id="productId" cssClass="form-control" value="${product.getProductId()}" type="hidden"/>
                        <h2>${contextService.get("افزودن/ویرایش محصول")}</h2>
                        <label for="name">
                            <form:errors path="name" cssStyle="color: #990014"/>
                                ${contextService.get("نام محصول")}
                        </label>
                        <form:input path="name" id="name" cssClass="form-control"/>



                        <label for="description">
                                ${contextService.get("توضیح محصول")}
                        </label>
                        <form:input path="description" id="description" cssClass="form-control"/>


                        <label for="price">
                            <form:errors path="price"
                                         cssStyle="color: #990014"/>

                                ${contextService.get("قیمت محصول")}
                        </label>
                        <form:input path="price" id="price" cssClass="form-control"/>

                        <label for="quantity">
                            <form:errors path="quantity" cssStyle="color: #990014"/>
                                ${contextService.get("تعداد محصول")}


                        </label>
                        <form:input path="quantity" id="quantity" cssClass="form-control"/>

                        <div class="form">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <td>
                                            ${contextService.get("کد مشخصه")}
                                    </td>
                                    <td>
                                            ${contextService.get("نام مشخصه")}
                                    </td>
                                    <td>
                                            ${contextService.get("مقدار فعلی مشخصه")}
                                    </td>  <td>
                                            ${contextService.get("مقدار جدید مشخصه")}
                                    </td>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${product.getAttributeList().toArray()}" var="attribute" varStatus="status">
                                    <tr id="attributeId${attribute.attributeId}">
                                        <td>${attribute.attributeItem.attributeItemId}</td>
                                        <td>${attribute.attributeItem.name}</td>
                                        <td>${attribute.value}</td>
                                        <td>
                                            <form:input path="attributeList[${status.index}].value" cssClass="form-control" />
                                        </td >
                                        <form:input path="attributeList[${status.index}].attributeId" value="${attribute.attributeId}" type="hidden"  />

                                        <form:input path="attributeList[${status.index}].attributeItem.attributeItemId" value="${attribute.attributeItem.attributeItemId}" type="hidden" />
                                        <form:input path="attributeList[${status.index}].attributeItem.name" value="${attribute.attributeItem.name}" type="hidden"  />
                                        <td><input class="removeAttribute btn btn-danger" id="${attribute.attributeId}" vlaue="remove"></td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td>
                                        <%--<form:input path="attributeList[100].value" cssClass="form-control" />--%>
                                        <%--<form:input path="attributeList[100].attributeItem.attributeItemId" type="hidden"  value="3"/>--%>
                                        <%--<form:input path="attributeList[100].attributeId" type="hidden"  value="31"/>--%>
                                        <%--<form:input path="attributeList[0].attributeItem.name"  value="سری"/>--%>
                                        <%--<form:input path="attributeList[0].product.productId"  value="${product.getProductId()}" type="hidden" />--%>
                                        <%--<form:input path="productId"  value="${product.getProductId()}" type="hidden" />--%>

                                    </td>
                                    <%--<td>--%>
                                        <select class="form-control input-sm" >
                                            <c:forEach items="${attributeItemList.toArray()}" var="attributeItem">
                                                <option id="${attributeItem.getAttributeItemId()}">${attributeItem.getName()}</option>
                                            </c:forEach>
                                        </select>
                                    <%--</td>--%>
                                </tr>
                                </tbody>
                            </table>

                                <%--<label class="">${contextService.get("توضیح خاص محصول")}</label>--%>
                                <%--<form:input path="summaryDescription" id="summaryDescription"--%>
                                <%--cssClass="input-large"/>--%>


                            <input type="submit" value="${contextService.get("افزودن محصول")}"
                                   class="btn btn-primary">
                            <a href="<spring:url value="/admin/productInventory" /> "><input
                                    value="${contextService.get("انصراف")}" class="btn btn-default"></a>
                        </div>
                    </form:form>

                </div>

            </div>
        </div>
    </div>
</section>

<%@include file="/WEB-INF/views/layout/bottommessage.jsp" %>
<%@include file="/WEB-INF/views/layout/bottombar.jsp" %>
<%@include file="/WEB-INF/views/layout/copyright.jsp" %>
<%@include file="/WEB-INF/views/layout/footer.jsp" %>


