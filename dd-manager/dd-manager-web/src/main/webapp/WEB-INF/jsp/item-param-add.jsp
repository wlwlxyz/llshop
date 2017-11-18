<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-panel" title="商品规格参数模板详情" data-options="fit:true">

    <form class="form" id="itemParamAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="cid" name="cid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">规格参数：</td>
                <td>
                    <button class="easyui-linkbutton" onclick="addGroup()" type="button" data-options="iconCls:'icon-add'">添加分组</button>
                    <ul id="item-param-group">

                    </ul>
                    <ul id="item-param-group-template" style="display:none;">
                        <li>
                            <input name="group">
                            <button title="添加参数" class="easyui-linkbutton" onclick="addParam(this)" type="button" data-options="iconCls:'icon-add'"></button>
                            <button title="删除分组" class="easyui-linkbutton" onclick="delGroup(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                            <ul class="item-param">
                                <li>
                                    <input name="param">
                                    <button title="删除参数" class="easyui-linkbutton" onclick="delParam(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="easyui-linkbutton" onclick="submitForm()" type="button" data-options="iconCls:'icon-ok'">保存</button>
                    <button class="easyui-linkbutton" onclick="clearForm()" type="button" data-options="iconCls:'icon-undo'">重置</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    //初始化类别选择树
    $('#cid').combotree({
        url: 'itemCats?parentId=0',
        required: true,
        onBeforeExpand: function(node){
            console.log(node);
            console.log("~~~~~");
            console.log(node.id);
            //获取当前被点击的tree
            var $currentTree = $('#cid').combotree('tree');
            //调用easyui tree组件的options方法
            var option = $currentTree.tree('options');
            console.log(option);
            //修改option的url属性
            option.url = 'itemCats?parentId=' + node.id;
        },
        onBeforeSelect: function(node){

            var isLeaf = $('#cid').tree('isLeaf', node.target);

            if(!isLeaf){
                $.messager.alert('警告','请选择最终类目', 'warning');
                return false;
            }

        }
    });
    //增加分组
    function addGroup() {
        var $clone = $("#item-param-group-template li").eq(0).clone();
        $("#item-param-group").append($clone);
    }
    //增加分组的一个类目
    function addParam(ele){
        console.log(ele);
        var $paramLi = $('#item-param-group-template .item-param li').eq(0).clone();
        $(ele).parent().find('.item-param').append($paramLi);
    }
    //删除分组
    function delGroup(ele) {
        $(ele).parent().remove();
    }
    //删除分组
    function delParam(ele) {
        $(ele).parent().remove();
    }
    function submitForm() {
            var groupValue=[];
            var $group = $("#item-param-group [name=group]");
            $group.each(function (index,ele) {
                var paramValue=[];
                var $param = $(ele).parent().find(".item-param [name=param]");
                $param.each(function (_index,_ele) {
                    var _val = $(_ele).val();
                        if ($.trim(_val).length>0){
                            paramValue.push(_val);
                        }
                });
                    var val = $(ele).val();
                    var o={};
                    o.group=val;
                    o.prama=paramValue;
                    if($.trim(val).length>0&&paramValue.length>0){
                        groupValue.push(o);
                    }

            })
        console.log(groupValue);
        var cid = $('#cid').combotree('getValue');
        console.log(cid);
        var url = 'item/param/save/' + cid;
        var stringify = JSON.stringify(groupValue);
        console.log(stringify);
        $.post(
            url,
            {paramDate:stringify},
            function (data) {

                llshop.closeTabs('新增商品规格模板');
                llshop.addTabs('规格参数', 'item-param-list');
            }
        )


    }


    //重置
    function clearForm() {
        $('#itemParamAddForm')[0].reset();
    }
    
</script>
