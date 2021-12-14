<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/member_info.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/member_info.js"></script>

        

</head>
<body>
    <div class="main_container">
        <div class="main_upper_wrap">
            <p id="news">News</p>
            <p id=stra>Strategy</p>
            <p id="com">Community</p>
            <p id="adm">Administration</p>
            <button><i class="fas fa-ellipsis-h"></i></button>
            <!-- 높이 같아야 함 -->
        </div>
        <div class="page_container">
            <div class="member_page_wrap">
                <table class="member_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>아이디</th>
                            <th>전화번호</th>
                            <th>생년월일</th>
                            <th>이메일</th>
                            <th>주소</th>
                            <th>등록일</th>
                            <th>변경일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.list==null}">
                            <tr>
                                <td id="nodata" colspan="8">회원 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="li">
                            <tr>
                                <td>${li.mi_seq}</td>
                                <td>${li.mi_id}</td>
                                <td>${li.mi_phone}</td>
                                <td>${li.mi_birth}</td>
                                <td>${li.mi_email}</td>
                                <td>${li.mi_address}</td>
                                <td>${li.mi_reg_dt}</td>
                                <td>${li.mi_mod_dt}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>