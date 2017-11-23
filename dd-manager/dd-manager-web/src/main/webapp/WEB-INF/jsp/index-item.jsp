<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<div>
    <%--不管是a标签还是button标签只要class="easyui-linkbutton"，那么按钮的样式的是一样的，type="button"--%>
    <a id="import" class="easyui-linkbutton" onclick="importItems()">一键导入商品数据到索引库</a>
    <span id="msg"></span>
    <script>
        function importItems() {
            $("#import").linkbutton("disable");
            $('#msg').html('正在导入请稍后...');
            $.post(
                'item/search/import',
                null,
                function (data) {
                    if(data.success){
                        $.messager.alert('提示', data.message);
                    } else {
                        $.messager.alert('提示','导入索引库失败！');
                    }
                    $('#msg').html('');
                }

            );
        }
    </script>

