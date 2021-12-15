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
                <div class="button_container">
                    <div class="button_wrap">
                        <button id="modify_btn">
                            수정
                        </button>
                        <button id="add_btn">
                            추가
                        </button>
                        <button id="delete_btn">
                            삭제
                        </button>
                        <button id="cancel_btn">
                            취소
                        </button>
                    </div>
                </div>
                <table class="member_list_table">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>아이디</th>
                            <th>전화번호</th>
                            <th>생년월일</th>
                            <th>이메일</th>
                            <th>주소</th>
                            <th>이미지</th>
                            <th>등록일</th>
                            <th>변경일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="input_box">
                            <td>번호</td>
                            <td><input type="text" id="input_id" placeholder="아이디"></td>
                            <td><input type="text" id="input_phone" placeholder="ex) 01012345678"></td>
                            <td><input type="text" id="input_birth" placeholder="ex) 990814"></td>
                            <td><input type="text" id="input_email" placeholder="ex) mail@mail.com"></td>
                            <td><input type="text" id="input_address" placeholder="ex) 대구광역시 북구..."></td>
                            <td>이미지</td>
                            <td><input type="password" id="input_pwd" placeholder="비밀번호"></td>
                            <td><input type="password" id="input_pwd_con" placeholder="비밀번호확인"></td>
                        </tr>
                        <c:if test="${data.cnt==0}">
                            <tr>
                                <td id="nodata" colspan="9">회원 정보가 없습니다.</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${data.list}" var="li">
                            <tr id="${li.mi_seq}" tr-seq="${li.mi_seq}" class="member_data">
                                <td>${li.mi_seq}</td>
                                <td>${li.mi_id}</td>
                                <td>${li.mi_phone}</td>
                                <td>${li.mi_birth}</td>
                                <td>${li.mi_email}</td>
                                <td>${li.mi_address}</td>
                                <td>${li.mi_image}</td>
                                <td>${li.mi_reg_dt}</td>
                                <td>
                                    ${li.mi_mod_dt}<input type="checkbox" class="check_box">
                                </td>
                            </tr>
                            <tr class="modify_box"  id="${li.mi_seq*10000000000}">
                                <td>번호</td>
                                <td><input type="text" id="modify_id" placeholder="아이디"></td>
                                <td><input type="text" id="modify_phone" placeholder="ex) 01012345678"></td>
                                <td><input type="text" id="modify_birth" placeholder="ex) 990814"></td>
                                <td><input type="text" id="modify_email" placeholder="ex) mail@mail.com"></td>
                                <td><input type="text" id="modify_address" placeholder="ex) 대구광역시 북구..."></td>
                                <td>이미지</td>
                                <td>등록일</td>
                                <td>변경일</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>