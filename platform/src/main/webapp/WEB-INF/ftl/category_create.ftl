<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.eny.product.dto.CategoryCreateForm" -->
<#-- @ftlvariable name="jo" type="cc.aisc.platform.eny.product.entity.Category" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new CATEGORY">
<script type="text/JavaScript">
    $(document).ready(function () {
        $(function () {
            var token = "${_csrf.token}";
            var header = "${_csrf.headerName}";
            /*$(document).ajaxSend(function(e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });*/
            $(document).bind("ajaxSend", function(elm, xhr, s){
                if (s.type == "POST") {
                    xhr.setRequestHeader(header, token);
                }
            });
        });
        $(function () {
            $.ajax({
                url:"/ajax/category",
                type:"POST",
                contentType: "application/text;charset=UTF-8",
                dataType:"json",
                data:"1",
                async:false,
                success:function(jo){
                    var treeobj;
                    var setting={callback:{onClick:ztreeOnClick}};
                    treeobj= $.fn.zTree.init($("#ctgrtree"), setting, jo);
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $("#ajax_msg").html("ERROR:<font color=red>" + XMLHttpRequest.status + "</br>" + XMLHttpRequest.readyState + "</br>" + textStatus + "</font>");
                }
            });
        });
        function ztreeOnClick(event, treeId, treeNode){
            /*alert("tid="+treeNode.tId +", name="+ treeNode.name);*/
            $("#ipt_pid").val(treeNode.id);
            $("#ipt_lvl").val(treeNode.level);
            $("#ctgrcrttips").html(treeNode.name+":"+treeNode.description);
        }
    });
</script>
</@htmlHead>
<@htmlBody projectName="ENY">
<div>
    <ul id="ctgrtree" class="ztree" ></ul>
</div>
<div>添加产品<span id="ctgrcrttips"></span>的子类产品</div>
<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input id="ipt_pid" type="hidden" name="parentId" value="${form.parentId}"/>
    <input id="ipt_lvl" type="hidden" name="level" value="${form.level}"/>
    <div>
        <label for="name">类别</label>
        <input type="text" name="name" id="name" value="${form.name}" required autofocus/>
    </div>
    <div>
        <label for="description">描述</label>
        <input type="text" name="description" id="description" required/>
    </div>
    <button type="submit">CREATE</button>
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