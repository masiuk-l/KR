<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<div class="modal-dialog modal-sm">
    <div class="modal-content">
        <br>
        <div class="modal-body">
            <div id="myTabContent" class="tab-content">

                <div role="tabpanel" class="tab-pane fade in active show" id="signup">
                    <p><b>Редактирование профиля</b></p>
                    <form class="form-horizontal" action="frontController?command=editreader" method="post">
                        <fieldset>
                            <!-- Sign Up Form -->
                            <!-- email-->
                            <div class="control-group">
                                <label class="control-label" for="em"><fmt:message bundle="${i18n}"
                                                                                   key="login.email"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="em" name="em" class="form-control input-large"
                                           placeholder="${sreader.email}">
                                </div>
                            </div>

                            <!--password-->
                            <div class="control-group">
                                <label class="control-label" for="pass"><fmt:message bundle="${i18n}"
                                                                                     key="login.password"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="pass" name="pass" class="form-control input-large"
                                           type="password" placeholder="********">
                                </div>
                            </div>

                            <br>
                            <!-- surname-->
                            <div class="control-group">
                                <label class="control-label" for="surname"><fmt:message bundle="${i18n}"
                                                                                        key="login.surname"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="surname" class="form-control input-large"
                                           placeholder="${sreader.surname}" name="surname">
                                </div>
                            </div>

                            <!-- name-->
                            <div class="control-group">
                                <label class="control-label" for="name"><fmt:message bundle="${i18n}"
                                                                                     key="login.name"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="name" class="form-control input-large" placeholder="${sreader.name}"
                                           name="name">
                                </div>
                            </div>

                            <!-- second name-->
                            <div class="control-group">
                                <label class="control-label" for="secondname"><fmt:message bundle="${i18n}"
                                                                                           key="login.secondname"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="secondname" class="form-control input-large"
                                           placeholder="${sreader.secondName}" name="secondname"
                                    >
                                </div>
                            </div>

                            <br>

                            <!-- birthday-->
                            <div class="control-group">
                                <label class="control-label" for="birthday"><fmt:message bundle="${i18n}"
                                                                                         key="login.birthday"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="birthday" class="form-control input-large" name="birthday"
                                           type="Date" value="${sreader.birthday}">
                                </div>
                            </div>

                            <!-- gender-->
                            <div class="control-group">
                                <label class="control-label" for="gender"><fmt:message bundle="${i18n}"
                                                                                       key="login.gender"></fmt:message>:</label>
                                <div class="controls">
                                    <select class="form-control input-large" name="gender" id="gender">
                                        <c:choose>
                                            <c:when test="${sreader.gender eq 'male'}">
                                                <option value="1" selected><fmt:message bundle="${i18n}"
                                                                                        key="login.gender.male"></fmt:message></option>
                                                <option value="2"><fmt:message bundle="${i18n}"
                                                                               key="login.gender.female"></fmt:message></option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="1"><fmt:message bundle="${i18n}"
                                                                               key="login.gender.male"></fmt:message></option>
                                                <option value="2" selected><fmt:message bundle="${i18n}"
                                                                                        key="login.gender.female"></fmt:message></option>
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>
                            </div>

                            <!--button-->
                            <div class="control-group">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <input type="submit" class="btn btn-success"
                                           value="<fmt:message bundle="${i18n}" key="cabinet.edit"></fmt:message>"/>
                                    <input type="submit" class="btn btn-secondary"
                                           value="<fmt:message bundle="${i18n}" key="login.close"></fmt:message>"/>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>