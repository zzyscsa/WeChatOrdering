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
                                <tr>
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

<#--弹窗-->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button onclick="javascript:document.getElementById('notice').pause();" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">查看</button>
            </div>
        </div>
    </div>
</div>

<#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
</audio>


<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script>
    /*webSocket客户端*/
    var websocket = null;
    if ("WebSocket" in window) {
        websocket = new WebSocket('ws://mrscsa.natapp1.cc/sell/webSocket');
    } else {
        alert('该浏览器不支持websocket!');
    }

    websocket.onopen = function (event) {
        console.log('建立连接');
    }

    websocket.onclose = function (event) {
        console.log('连接关闭');
    }
    /*消息来的事件*/
    websocket.onmessage = function (event) {
        console.log('收到消息：'+event.data);
        //弹窗提醒，播放音乐
        $('#myModal').modal('show');
        document.getElementById('notice').play();
    }

    websocket.onerror = function () {
        alert('websocket通信发生错误')
    }

    window.onbeforeunload = function () {
        websocket.close();
    }
</script>

</body>
</html>




