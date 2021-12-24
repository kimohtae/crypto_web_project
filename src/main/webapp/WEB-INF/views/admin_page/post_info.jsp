<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/post_info.css">
    <%@include file="/WEB-INF/views/includes/header.jsp"%>
    <script src="/assets/js/post_info.js"></script>

        

</head>
<body>
    
    <div class="main_container">
        <div class="main_upper_wrap">
            <a href="/admin/member" id="member">Member</a>
            <a href="/admin/post" id="post">Post</a>
            <button><i class="fas fa-ellipsis-h"></i></button>
            
        </div>
        <div class="page_container">
            <div class="member_page_wrap">
                <div class="button_container">


                </div>
                <table class="post_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>종류</th>
                            <th>종목</th>
                            <th>조회수</th>
                            <th>추천수</th>
                            <th>상태</th>
                            <th>등록일</th>
                            <th>수정일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data.cnt==0}">
                            <tr>
                                <td id="nodata" colspan="11">회원 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="li">
                            <tr>
                                <td>${li.pi_seq}</td>
                                <td>${li.mi_name}</td>
                                <td>${li.pi_title}</td>
                                <td>${li.pi_contents}</td>
                                <td>${li.ti_table}</td>
                                <td>${li.iti_type}</td>
                                <td>${li.pi_views}</td>
                                <td>${li.pi_like}</td>
                                <td>${li.pi_status}</td>
                                <td>${li.pi_reg_dt}</td>
                                <td>${li.pi_mod_dt}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>



