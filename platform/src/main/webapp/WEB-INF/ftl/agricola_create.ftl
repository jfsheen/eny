<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.eny.company.dto.AgricolaCreateForm" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new Agricola">

</@htmlHead>
<@htmlBody projectName="ENY">
<div class="col-xs-6">
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <label for="name">姓名</label>
            <input class="form-control" type="text" name="name" id="name" value="${form.name}" placeholder="Name" required autofocus/>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input class="form-control" type="password" name="password" id="password" required/>
        </div>
        <div class="form-group">
            <label for="passwordRepeated">重复密码</label>
            <input class="form-control" type="password" name="passwordRepeat" id="passwordRepeat" required/>
        </div>
        <div class="form-group">
            <label for="gender">性别</label>
            <select class="form-control" name="gender" id="gender" required>
                <option <#if form.gender == 'FEMALE'>selected</#if>>FEMALE</option>
                <option <#if form.gender == 'MALE'>selected</#if>>MALE</option>
            </select>
        </div>
        <div class="form-group">
            <label for="cellphone">cellphone</label>
            <input class="form-control" type="text" name="cellphone" id="cellphone" value="${form.cellphone}"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input class="form-control" type="email" name="email" id="email" value="${form.email}"/>
        </div>
        <div  class="form-group">
            <label for="qq">QQ</label>
            <input class="form-control" type="text" name="qq" id="qq" value="${form.qq}"/>
        </div>

        <button class="btn btn-primary btn-lg" type="submit">CREATE</button>
    </form>

    <@spring.bind "form" />
    <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
                <li>${error}</li>
            </#list>
        </ul>
    </#if>
</div>
</@htmlBody>