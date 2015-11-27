<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.eny.company.dto.AgricolaCreateForm" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new Agricola">

</@htmlHead>
<@htmlBody projectName="ENY">
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="name">姓名</label>
            <input type="text" name="name" id="name" value="${form.name}" required autofocus/>
        </div>
        <div>
            <label for="password">密码</label>
            <input type="password" name="password" id="password" required/>
        </div>
        <div>
            <label for="passwordRepeated">重复密码</label>
            <input type="password" name="passwordRepeat" id="passwordRepeat" required/>
        </div>
        <div>
            <label for="gender">性别</label>
            <select name="gender" id="gender" required>
                <option <#if form.gender == 'FEMALE'>selected</#if>>FEMALE</option>
                <option <#if form.gender == 'MALE'>selected</#if>>MALE</option>
            </select>
        </div>
        <div>
            <label for="cellphone">cellphone</label>
            <input type="text" name="cellphone" id="cellphone" value="${form.cellphone}"/>
        </div>
        <div>
            <label for="email">Email</label>
            <input type="email" name="email" id="email" value="${form.email}"/>
        </div>
        <div>
            <label for="qq">QQ</label>
            <input type="text" name="qq" id="qq" value="${form.qq}"/>
        </div>

        <button type="submit">Save</button>
    </form>

    <@spring.bind "form" />
    <#if spring.status.error>
        <ul>
            <#list spring.status.errorMessages as error>
                <li>${error}</li>
            </#list>
        </ul>
    </#if>
</@htmlBody>