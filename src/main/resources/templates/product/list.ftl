<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">

    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主要内容content-->
    <div id="page-content-wrapper">
        <#--样式流动布局，fluid-->
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <#--占2列-->
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#--framemaker遍历数据,返回的就是一个list-->
                        <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <#--根据图片连接显示图片-->
                                <td><img height="100" width="100" src="${productInfo.productIcon}"></td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td>${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td>
                                    <a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a>
                                </td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().message == "在架">
                                        <a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a>
                                    <#else>
                                        <a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#--当前页小于等于1，-->
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">Prev</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">Prev</a></li>
                        </#if>

                        <#--遍历1 ~ 总页数-->
                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>

                        <#--当前页小于等于1，-->
                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled"><a href="#">Next</a></li>
                        <#else>
                            <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">Next</a></li>
                        </#if>

                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>




