<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/header.jsp"%>

<div class="col-md-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <ul class="nav nav-pills">
                <li role="presentation" class="active"><a>查看日志文件</a></li>
                <li role="presentation" style="float: right;"><a href="${reqBaseURL}/admin/log/all.action">查看所有日志文件</a></li>
            </ul>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" id="log-form" action="${reqBaseURL}/admin/log/query.action" method="post">
                <div class="form-group">
                    <label for="logDate" class="col-sm-2 control-label">日志日期</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="logDate" placeholder="2015-06-08" name="logDate">
                    </div>
                </div>
                <div class="form-group">
                    <label for="authCode" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="authCode" placeholder="请输入验证码" name="authCode">
                    </div>
                </div>
                <div class="form-group">
                    <label for="authCode" class="col-sm-2 control-label"></label>
                    <div class="col-sm-10">
                        <a id="change">
                            <img id="authCodeImg" src="${reqBaseURL}/captchaImage.action" />
                            <span style="color: #0f0f0f;">看不清，换一张</span>
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">查询日志文件</button>
                    </div>
                </div>
            </form>
            <script type="text/javascript">
                $(function() {
                    $("#change").on('click', function() {
                        $("#authCodeImg").attr("src", "${reqBaseURL}/captchaImage.action?ran=" + new Date() / 100);
                    });

                    $("#log-form").validate({
                        rules : {
                            authCode: {
                                required: true,
                                remote: {
                                    url : "${reqBaseURL}/router/validateCode.action",
                                    type : "post",
                                    dataType : "json",
                                    data : {
                                        authCode : function() {
                                            return $("#authCode").val();
                                        }
                                    }
                                }
                            },
                            logDate: {
                                required: true
                            }
                        },
                        messages: {
                            authCode: {
                                required: "请填写验证码",
                                remote: "请输入正确的验证码"
                            },
                            logDate: {
                                required: "请输入日期"
                            }
                        }
                    });
                });
            </script>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/admin/include/footer.jsp"%>