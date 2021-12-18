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
            <a href="/admin/member" id="member">Member</a>
            <a href="#" id="">Table</a>
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
                    <div class="status_change_wrap">
                        <select id="status_cat">
                            <option value="1">신규</option>
                            <option value="2">정상</option>
                            <option value="3">정지</option>
                            <option value="4">탈퇴</option>
                        </select>
                        <button id="status_btn">적용</button>
                    </div>

                </div>
                <table class="member_list_table">
                    <thead>
                        <tr id="sending" adesc="${data.adesc}" order="${data.order}" offset="${data.offset}">
                            <th>번호<span order-by="mi_seq"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>아이디<span order-by="mi_id"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>이름<span order-by="mi_name"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>전화번호<span order-by="mi_phone"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>생년월일<span order-by="mi_birth"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>이메일<span order-by="mi_email"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>상태<span order-by="mi_status"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>이미지<span order-by="mi_image"><i class="fas fa-arrows-alt-v"></i></span></th>
                            <th>등록일<span order-by="mi_reg_dt"><i class="fas fa-arrows-alt-v"></i></span></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="input_box">
                            <td>번호</td>
                            <td><input type="text" id="input_id" placeholder="아이디"></td>
                            <td><input type="text" id="input_name" placeholder="이름"></td>
                            <td><input type="text" id="input_phone" placeholder="ex) 01012345678"></td>
                            <td><input type="text" id="input_birth" placeholder="ex) 990814"></td>
                            <td><input type="text" id="input_email" placeholder="ex) mail@mail.com"></td>
                            <td>상태</td>
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
                                <td>${li.mi_name}</td>
                                <td>${li.mi_phone}</td>
                                <td>${li.mi_birth}</td>
                                <td>${li.mi_email}</td>
                                <td class="status_dec">
                                    <c:if test="${li.mi_status == 1}">
                                        <span style="color: blue">신규</span> 
                                    </c:if>
                                    <c:if test="${li.mi_status == 2}">
                                        <span style="color: green">정상</span> 
                                    </c:if>
                                    <c:if test="${li.mi_status == 3}">
                                        <span style="color: gray">정지</span> 
                                    </c:if>
                                    <c:if test="${li.mi_status == 4}">
                                        <span style="color: red">탈퇴</span> 
                                    </c:if>
                                </td>
                                <td>${li.mi_image}</td>
                                <td>${li.mi_reg_dt}<input type="checkbox" class="check_box">
                                </td>
                            </tr>
                            <tr class="modify_box"  id="${li.mi_seq*10000000000}">
                                <td>번호</td>
                                <td><input type="text" class="mod_id" placeholder="아이디"></td>
                                <td><input type="text" class="mod_name" placeholder="이름"></td>
                                <td><input type="text" class="mod_phone" placeholder="ex) 01012345678"></td>
                                <td><input type="text" class="mod_birth" placeholder="ex) 990814"></td>
                                <td><input type="text" class="mod_email" placeholder="ex) mail@mail.com"></td>
                                <td><input type="text" class="mod_status" placeholder="신규,정상,정지,탈퇴"></td>
                                <td><input type="text" class="mod_image" placeholder="이미지" value="기본이미지"></td>
                                <td>등록일</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="pager_wrap">
                    <span id="page_left_move"><</span>
                    <c:forEach begin="1" end="${data.page}" var="i">
                        <a id="${i}" href="/admin/member?offset=${(i-1)*30}&newOrder=${data.order}&adesc=${data.adesc}">${i}</a>
                    </c:forEach>
                    <span id="page_right_move">></span>
                </div>
            </div>
        </div>
    </div>
</body>
</html>



