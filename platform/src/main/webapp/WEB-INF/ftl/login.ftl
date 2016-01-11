<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Log in">
</@htmlHead>
<@htmlBody projectName="ENY">
    <#if error.isPresent()>
    <p>The email or password you have entered is invalid, try again.</p>
    </#if>
<p>You can use: demo@localhost / demo</p>
<form role="form" action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <label for="username">USERNAME</label>
        <input type="email" name="username" id="username" PLACEHOLDER="EMAIL ADDRESS" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" PLACEHOLDER="PASSWORD" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button class="btn btn-primary" type="submit">Login</button>
</form>
</@htmlBody>