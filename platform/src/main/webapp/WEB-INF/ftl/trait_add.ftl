<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="cc.aisc.platform.eny.commons.dto.TraitAddDto" -->
<#include "tmpl/tmp1.ftl" />
<@htmlHead title="Create a new TRAIT">
<#--<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN &ndash;&gt;
<meta name="_csrf_header" content="${_csrf.headerName}"/>-->
<script type="text/javascript">
    $(document).ready(function () {
        $(function () {
            var token = "${_csrf.token}";
            var header = "${_csrf.headerName}";
            /*var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");*/
            $(document).ajaxSend(function(e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
        });
        $("#btn_ajax_trait").click(function (event) {
            event.preventDefault();
            var trait = $("#traitDetails :input").serializeObject();
            var data = JSON.stringify(trait);
            /*                var o = {};
                            o.trait = trait;
                            var data = JSON.stringify(o);*/
            $("#ajax_trait_json").html("SENT: <font color=green>"+data+"</font>");
            $.ajax({
                type:"POST",
                contentType: "application/json;charset=UTF-8",
                dataType:"json",
                url:"/ajax/trait/add",
                data:data,
                async:false,
                success:function(ret){
                    $("#ajax_trait_msg").html("SUCCESS return:<font color=blue>" + ret.trait + "</font>");
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    $("#ajax_trait_msg").html("ERROR:<font color=red>" + XMLHttpRequest.status + "</br>" + XMLHttpRequest.readyState + "</br>" + textStatus + "</font>");
                }
            });
        });
    });
    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
        /*var o={};
        var a=this.serializeArray();
        var str=this.serialize();
        $(a).each(function(){
            if(o[this.name]){
                if($.isArray(o[this.name])){
                    o[this.name].push(this.value);
                }else{
                    o[this.name]=[o[this.name],this.value];
                }
            }else{
                o[this.name]=this.value;
            }
        });
        return o;*/
    };
    function isNum(e) {
        var k = window.event ? e.keyCode : e.which;
        if (!(((k >= 48) && (k <= 57)) || k == 8 || k == 0)) {
            if (window.event) {
                window.event.returnValue = false;
            }
            else {
                e.preventDefault();//for firefox
            }
        }
    }
</script>
</@htmlHead>
<@htmlBody projectName="ENY">
    <div id="ajax_trait_msg" ></div>
    <div id="ajax_trait_json"></div>

    <form id="addTrait" action="" method="post">
        <div id="traitDetails">
            <div>
                <label for="trait">Trait</label>
                <input type="text" name="trait" id="trait" value="${dto.trait}"/>
            </div>
            <div>
                <label for="belong2">belong2</label>
                <input type="text" name="belong2" id="belong2" value="${dto.belong2}"/>

            </div>
            <div>
                <label for="belong2id">belong2id</label>
                <input type="text" name="belong2id" id="belong2id" value="${dto.belong2id}"/>

            </div>
            <div id="images">
                <label for="images">images</label>
                <input type="text" name="images" id="images" value="${dto.images}"/>
            </div>
            <div>
                <label for="orderNum">orderNum</label>
                <input type="text" name="orderNum" id="orderNum" value="${dto.orderNum}"/>

            </div>
        </div>
    </form>
    <button type="button" id="btn_ajax_trait">ajax trait</button>
</@htmlBody>