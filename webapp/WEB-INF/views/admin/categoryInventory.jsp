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
                            <td>${contextService.get("کد دسته‌بندی")}</td>
                            <td>${contextService.get("نام دسته‌بندی")}</td>
                            <td>

                            </td>
                        </tr>


                        </thead>

                        <tbody>
                        <c:forEach items="${categoryList}" var="category">
                            <tr>
                                <td>${category.getCategoryId()}</td>
                                <td>${category.getName()}</td>
                                <td>   <a href="<c:url value="/admin/removeCategory/${category.getCategoryId()}"/>"><i
                                        class="icon-remove icon-2x">remove</i></a>
                                    <a href="<c:url value="/admin/editCategory/${category.getCategoryId()}"/>">
                                        <span class="icon-pencil icon-2x">edit</span>
                                    </a></td>
                            </tr>


                        </c:forEach>
                        <tr>
                        </tr>
                        </tbody>
                    </table>

                    <a href="<c:url value="/admin/addCategory" />">
                        <button class="btn btn-primary">${contextService.get("افزودن دسته‌بندی جدید")}</button>
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