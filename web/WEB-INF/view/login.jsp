<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<!-- Button trigger modal -->
<c:if test="${not (errorMsg eq '')}">
    <div class="error"> ${errorMsg}</div>
</c:if>

<div class="container">
    <hr class="prettyline">
    <br>
    <div class="text-center">
        <h3><fmt:message bundle="${i18n}" key="login.continue"></fmt:message></h3>
        <br>
        <a class="btn btn-primary btn-lg" href="#signin" data-toggle="modal" data-target=".bs-modal-sm">
            <fmt:message bundle="${i18n}" key="login.signin"></fmt:message>/<fmt:message bundle="${i18n}"
                                                                                         key="login.signup"></fmt:message>
        </a>
    </div>
    <br>
    <hr class="prettyline">
</div>


<!-- Modal -->
<div class="modal fade bs-modal-sm" id="myModal" tabindex="1" role="dialog" aria-labelledby="mySmallModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <br>
            <div class="bs-example bs-example-tabs">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item active">
                        <a class="nav-link active" href="#signin" role="tab" data-toggle="tab"><fmt:message
                                bundle="${i18n}" key="login.signin"></fmt:message></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#signup" role="tab" data-toggle="tab"><fmt:message bundle="${i18n}"
                                                                                                     key="login.signup"></fmt:message></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#lib" role="tab" data-toggle="tab"><fmt:message bundle="${i18n}"
                                                                                                  key="login.librarians"></fmt:message></a>
                    </li>
                </ul>
            </div>


            <div class="modal-body">
                <div id="myTabContent" class="tab-content">

                    <div role="tabpanel" class="tab-pane fade in active show" id="signin">
                        <form class="form-horizontal" action="frontController?command=login" method="post">
                            <fieldset>
                                <!-- Sign In Form -->
                                <!-- email-->
                                <div class="control-group">
                                    <label class="control-label" for="log"><fmt:message bundle="${i18n}"
                                                                                        key="login.email"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="log" name="login" type="text" class="form-control input-medium"
                                               placeholder="JoeSixpack" required="">
                                    </div>
                                </div>

                                <!--password-->
                                <div class="control-group">
                                    <label class="control-label" for="pass"><fmt:message bundle="${i18n}"
                                                                                         key="login.password"></fmt:message>:</label>
                                    <div class="controls">
                                        <input required="" id="pass" name="password"
                                               class="form-control input-medium" type="password" placeholder="********">
                                    </div>
                                </div>

                                <!-- submit -->
                                <div class="control-group">
                                    <label class="control-label"></label>
                                    <div class="controls">
                                        <input type="submit" class="btn btn-success"
                                               value="<fmt:message bundle="${i18n}" key="login.signin"></fmt:message>"/>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>


                    <div role="tabpanel" class="tab-pane fade" id="signup">
                        <form class="form-horizontal" action="frontController?command=signup" method="post">
                            <fieldset>
                                <!-- Sign Up Form -->
                                <!-- email-->
                                <div class="control-group">
                                    <label class="control-label" for="email"><fmt:message bundle="${i18n}"
                                                                                          key="login.email"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="email" name="email" class="form-control input-large"
                                               placeholder="JohnDoe@example.com" required="">
                                    </div>
                                </div>

                                <!--password-->
                                <div class="control-group">
                                    <label class="control-label" for="password"><fmt:message bundle="${i18n}"
                                                                                             key="login.password"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="password" name="password" class="form-control input-large"
                                               type="password" placeholder="********" required="">
                                    </div>
                                </div>

                                <!-- password2-->
                                <div class="control-group">
                                    <label class="control-label" for="reenterpassword"><fmt:message bundle="${i18n}"
                                                                                                    key="login.repassword"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="reenterpassword" class="form-control input-large"
                                               name="reenterpassword" type="password" placeholder="********"
                                               required="">
                                    </div>
                                </div>

                                <br>
                                <!-- surname-->
                                <div class="control-group">
                                    <label class="control-label" for="surname"><fmt:message bundle="${i18n}"
                                                                                            key="login.surname"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="surname" class="form-control input-large" name="surname" required="">
                                    </div>
                                </div>

                                <!-- name-->
                                <div class="control-group">
                                    <label class="control-label" for="name"><fmt:message bundle="${i18n}"
                                                                                         key="login.name"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="name" class="form-control input-large" name="name" required="">
                                    </div>
                                </div>

                                <!-- second name-->
                                <div class="control-group">
                                    <label class="control-label" for="secondname"><fmt:message bundle="${i18n}"
                                                                                               key="login.secondname"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="secondname" class="form-control input-large" name="secondname"
                                               required="">
                                    </div>
                                </div>

                                <br>
                                <!-- birthday-->
                                <div class="control-group">
                                    <label class="control-label" for="birthday"><fmt:message bundle="${i18n}"
                                                                                             key="login.birthday"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="birthday" class="form-control input-large" name="birthday"
                                               type="Date" required="" value="2015-05-09">
                                    </div>
                                </div>

                                <!-- gender-->
                                <div class="control-group">
                                    <label class="control-label" for="gender"><fmt:message bundle="${i18n}"
                                                                                           key="login.gender"></fmt:message>:</label>
                                    <div class="controls">
                                        <select class="form-control input-large" name="gender" id="gender" required>
                                            <option value="1"><fmt:message bundle="${i18n}"
                                                                           key="login.gender.male"></fmt:message></option>
                                            <option value="2"><fmt:message bundle="${i18n}"
                                                                           key="login.gender.female"></fmt:message></option>
                                        </select>
                                    </div>
                                </div>

                                <!--button-->
                                <div class="control-group">
                                    <label class="control-label"></label>
                                    <div class="controls">
                                        <input type="submit" class="btn btn-success"
                                               value="<fmt:message bundle="${i18n}" key="login.signup"></fmt:message>"/>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>

                    <div role="tabpanel" class="tab-pane fade" id="lib">
                        <form class="form-horizontal" action="frontController?command=loginlib" method="post">
                            <fieldset>
                                <!-- Sign In Form -->
                                <!-- email-->
                                <div class="control-group">
                                    <label class="control-label" for="login"><fmt:message bundle="${i18n}"
                                                                                          key="login.email"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="login" name="login" type="text" class="form-control input-medium"
                                               required="">
                                    </div>
                                </div>

                                <!--password-->
                                <div class="control-group">
                                    <label class="control-label" for="passw"><fmt:message bundle="${i18n}"
                                                                                          key="login.password"></fmt:message>:</label>
                                    <div class="controls">
                                        <input required="" id="passw" name="password"
                                               class="form-control input-medium" type="password" placeholder="********">
                                    </div>
                                </div>

                                <!-- submit -->
                                <div class="control-group">
                                    <label class="control-label"></label>
                                    <div class="controls">
                                        <input type="submit" class="btn btn-success"
                                               value="<fmt:message bundle="${i18n}" key="login.signin"></fmt:message>"/>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message bundle="${i18n}"
                                                                                                key="login.close"></fmt:message></button>
            </div>
        </div>
    </div>
</div>
