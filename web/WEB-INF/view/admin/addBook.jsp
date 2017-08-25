<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>

<div class="modal-dialog ">
    <div class="modal-content">
        <div class="modal-body">
            <div id="myTabContent" class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active show" id="addbook">
                    <p><b>Добавление книги</b></p>
                    <form class="form-horizontal" action="frontController?command=addbook" method="post">
                        <fieldset>
                            <!-- Add Book Form -->
                            <!-- name-->
                            <div class="control-group">
                                <label class="control-label" for="name"><fmt:message bundle="${i18n}"
                                                                                     key="book.name"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="name" name="name" class="form-control input-large">
                                </div>
                            </div>

                            <!--author(s)-->
                            <div class="control-group">
                                <label class="control-label" for="author"><fmt:message bundle="${i18n}"
                                                                                       key="catalog.author"></fmt:message>:</label>
                                <div class="controls">
                                    <select multiple class="form-control input-large" name="author" id="author"
                                            required="">
                                        <c:forEach var="author" items="${authors}">
                                            <option value="${author.authorID}">${author.surname} ${author.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <small class="form-text text-muted">
                                    <a href="#addauthor" data-toggle="modal" data-target=".bs-modal-sm">
                                        <fmt:message bundle="${i18n}" key="author.add"/>
                                    </a>
                                </small>
                            </div>

                            <br>
                            <!--isbn-->
                            <div class="control-group">
                                <label class="control-label" for="isbn"><fmt:message bundle="${i18n}"
                                                                                     key="catalog.isbn"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="isbn" class="form-control input-large" name="isbn">
                                </div>
                            </div>

                            <!--genre-->
                            <div class="control-group">
                                <label class="control-label" for="genre"><fmt:message bundle="${i18n}"
                                                                                      key="catalog.genre"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="genre" class="form-control input-large" name="genre">
                                </div>
                            </div>

                            <!--year-->
                            <div class="control-group">
                                <label class="control-label" for="year"><fmt:message bundle="${i18n}"
                                                                                     key="catalog.year"></fmt:message>:</label>
                                <div class="controls">
                                    <input id="year" class="form-control input-large" name="year">
                                </div>
                            </div>

                            <!--quantity-->
                            <div class="control-group">
                                <label class="control-label" for="year">
                                    <fmt:message bundle="${i18n}" key="catalog.quantity"></fmt:message>:
                                </label>
                                <div class="controls">
                                    <input type="number" value="1" id="quantity" class="form-control input-large"
                                           name="quantity">
                                </div>
                            </div>


                            <!--button-->
                            <div class="control-group">
                                <label class="control-label"></label>
                                <div class="controls">
                                    <input type="submit" class="btn btn-success"
                                           value="<fmt:message bundle="${i18n}" key="addbook.title"/>"/>
                                    <a href="${pageContext.request.contextPath}/frontController?command=main"
                                       class="btn btn-secondary">
                                        <fmt:message bundle="${i18n}" key="login.close"/>
                                    </a>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade bs-modal-sm" id="Modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-body">
                <div id="TabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade in active show" id="addauthor">
                        <p><b>Добавление книги</b></p>
                        <form class="form-horizontal" action="frontController?command=addauthor" method="post">
                            <fieldset>
                                <!-- Add Author Form -->
                                <!-- surname-->
                                <div class="control-group">
                                    <label class="control-label" for="surname"><fmt:message bundle="${i18n}"
                                                                                            key="login.surname"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="surname" name="surname" class="form-control input-medium">
                                    </div>
                                </div>
                                <!-- name-->
                                <div class="control-group">
                                    <label class="control-label" for="authorName"><fmt:message bundle="${i18n}"
                                                                                               key="login.name"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="authorName" name="name" class="form-control input-medium">
                                    </div>
                                </div>
                                <!-- secondname-->
                                <div class="control-group">
                                    <label class="control-label" for="secondname"><fmt:message bundle="${i18n}"
                                                                                               key="login.surname"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="secondname" name="secondname" class="form-control input-medium">
                                    </div>
                                </div>

                                <!-- birthday -->
                                <div class="control-group">
                                    <label class="control-label" for="birthday"><fmt:message bundle="${i18n}"
                                                                                             key="login.birthday"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="birthday" class="form-control input-large" name="birthday"
                                               type="Date" required="" value="2015-05-09">
                                    </div>
                                </div>

                                <!-- country-->
                                <div class="control-group">
                                    <label class="control-label" for="country"><fmt:message bundle="${i18n}"
                                                                                            key="author.country"></fmt:message>:</label>
                                    <div class="controls">
                                        <input id="country" name="country" class="form-control input-medium">
                                    </div>
                                </div>

                                <!-- submit -->
                                <div class="control-group">
                                    <label class="control-label"></label>
                                    <div class="controls">
                                        <input type="submit" class="btn btn-success"
                                               value="<fmt:message bundle='${i18n}' key='author.add'/>"/>
                                    </div>
                                </div>
                                <%--<!-- cancel -->--%>
                                <%--<div class="control-group">--%>
                                <%--<label class="control-label"></label>--%>
                                <%--<div class="controls">--%>
                                <%--<a href="${pageContext.request.contextPath}/frontController?command=main" class="btn btn-success"--%>
                                <%--value="<fmt:message bundle="${i18n}" key="login.close"></fmt:message>"></a>--%>
                                <%--</div>--%>
                                <%--</div>--%>
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
