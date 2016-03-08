<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/headerRes.jsp"%>
<!-- content -->
<div id="content">
    <div class="row">
        <div class="col-md-12">&nbsp;</div>
    </div>

    <!-- authFalse -->
    <div id="authFalse" class="row">
        <div class="col-md-1"></div>
        <form class="col-md-10">
            <div class="row">
                <div class="col-md-5"></div>
                <h3 class="col-md-3" style="font-weight: bold;">认证失败</h3>
                <div class="col-md-4"></div>
            </div>
            <div class="row">
                <h5 class="col-md-10 signal">根据您输入的内容</h5>
                <h5 class="col-md-2 pL50"><a class="signal" href="${reqBaseURL}/router/search.action">返回系统首页</a></h5>
            </div>
            <div>
                <table class="table border">
                    <tr>
                        <th class="col-md-3">学生姓名</th>
                        <th class="col-md-3">学位证号</th>
                        <th class="col-md-3">发证日期</th>
                        <th class="col-md-3">查询日期</th>
                    </tr>
                    <tr class="signBg">
                        <th class="col-md-3">${stu.stuName}</th>
                        <th class="col-md-3">${stu.stuMajorDegreeCertNum}</th>
                        <th class="col-md-3">${stu.stuPublicationDate}</th>
                        <th class="col-md-3">2015-07-06</th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div>
                <h5 class="errorTxt">抱歉，我们没有在数据库中找到对应的内容，请核对输入内容是否正确。</h5>
            </div>
            <div>
                <h6 id="care">＊注意：最终学位信息以学位部门记载为准，如有疑义，请与我校相关主管部门联系。联系电话：0411-84107635</h6>
            </div>
        </form>
        <div class="col-md-1"></div>
    </div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>

