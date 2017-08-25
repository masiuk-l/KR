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
                                           value="<fmt:message bundle="${i18n}" key="addbook.title"></fmt:message>"/>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>