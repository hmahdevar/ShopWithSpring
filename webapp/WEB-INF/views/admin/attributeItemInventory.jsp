<%@include file="/WEB-INF/views/layout/header.jsp" %>
<%@include file="/WEB-INF/views/layout/topbar.jsp" %>
<%@include file="/WEB-INF/views/layout/menu.jsp" %>
<section class="generalwrapper dm-shadow clearfix">
    <div class="container">

        <div class="row">
            <div class="container-warpper">
                <div class="container">

                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <td>${contextService.get("کد مشخصه")}</td>
                            <td>${contextService.get("متن مشخصه")}</td>
                            <td>

                            </td>
                        </tr>


                        </thead>

                        <tbody>
                        <c:forEach items="${attributeItemList}" var="attributeItem">
                            <tr>
                                <td>${attributeItem.getAttributeItemId()}</td>
                                <td>${attributeItem.getName()}</td>
                                <td>   <a href="<c:url value="/admin/removeAttributeItem/${attributeItem.getAttributeItemId()}"/>"><i
                                        class="icon-remove icon-2x">remove</i></a>
                                    <a href="<c:url value="/admin/editAttributeItem/${attributeItem.getAttributeItemId()}"/>">
                                        <span class="icon-pencil icon-2x">edit</span>
                                    </a></td>
                            </tr>


                        </c:forEach>
                        <tr>
                        </tr>
                        </tbody>
                    </table>

                    <a href="<c:url value="/admin/addAttributeItem" />">
                        <button class="btn btn-primary">${contextService.get("افزودن مشخصه جدید")}</button>
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