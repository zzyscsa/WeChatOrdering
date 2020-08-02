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
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <#--占2列-->
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#--framemaker遍历数据,返回的就是一个list-->
                            <#list orderDTOPage.content as orderDTO>
                                <tr class="info">
                                    <td>${orderDTO.orderId}</td>
                                    <td>${orderDTO.buyerName}</td>
                                    <td>${orderDTO.buyerPhone}</td>
                                    <td>${orderDTO.buyerAddress}</td>
                                    <td>${orderDTO.orderAmount}</td>
                                    <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                                    <td>${orderDTO.getPayStatusEnum().getMessage()}</td>
                                    <td>${orderDTO.createTime}</td>
                                    <td>
                                        <a href="/sell/seller/order/detail?orderId=${orderDTO.getOrderId()}">详情</a>
                                    </td>
                                    <td>
                                        <#if orderDTO.getOrderStatusEnum().getMessage() == "新订单">
                                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}">取消</a>
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
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#--当前页小于等于1，-->
                            <#if currentPage gte orderDTOPage.getTotalPages()>
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




