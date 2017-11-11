<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()"  type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
    <%-- <a onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
     <a onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
     <a onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
     <a onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</a>
     <a onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</a>--%>

</div>
<table id="dg"></table>

<script  type="text/javascript">
    function add(){
        llshop.addTabs('新增商品','item-add');
    };

    function edit(){
        console.log('edit');
    };
    function remove() {
        var selectrows=$('#dg').datagrid('getSelections');
        console.log(selectrows);
        if (selectrows==0){
            $.messager.alert("提示","请至少选择一条记录哟^_^!");
            return ;
        }
        $.messager.confirm("确认","亲，是否要删除这些记录~_~!",function (r) {
            if(r) {
                var ids=[];
                for(var i=0;i<selectrows.length;i++){
                    ids.push(selectrows[i].id);
                }
                $.post(
                    'items/batch',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    'json'
                )
            }
        })
    };
    function down(){
        var downrows= $("#dg").datagrid("getSelections");
        if (downrows==0){
            $.messager.alert("提示","至少选择一条记录哟~_~");
            return ;
        }
        $.messager.confirm("确认","是否将选中商品改为下架",function (r) {
            if(r){
                var ids=[];
                for(var i=0;i<downrows.length;i++){
                    ids.push(downrows[i].id);
                }
                $.post(
                    'items/downrows',
                    {"ids[]":ids},
                    function (data) {
                        $("#dg").datagrid("reload");
                    },
                    'json'
                )
            }
        })
    };
    function up(){
        var  uprows=$('#dg').datagrid("getSelections");
        if(uprows==0){
            $.messager.alert("提示","请至少选择一条记录哟^_^!");
            return ;
        }
        $.messager.confirm("确认","选中的商品确定上架？_？",function (r) {
            if(r){
                var ids=[];
                for(var i=0;i<uprows.length;i++){
                    ids.push(uprows[i].id);
                }
                $.post(
                    'items/uprows',
                    {'ids[]':ids},
                    function (data) {
                        $('#dg').datagrid('reload');
                    },
                    'json'
                )
            }
        })
    };
    function searchForm(){

        $('#dg').datagrid('load',{
            title: $('#title').val(),
            status: $('#status').combobox('getValue')
        });

    }
</script>


<script>
    <%-- var toolbar = [{
            iconCls: 'icon-add',
            text: '增加',
            handler: function () {
                console.log('add');
            }
        },{
            iconCls: 'icon-edit',
            text: '编辑',
            handler: function () {
                console.log('edit');
            }
        },{
            iconCls: 'icon-remove',
            text: '删除',
            handler: function () {
                var selectrows=$('#dg').datagrid('getSelections');
                console.log(selectrows);
                if (selectrows==0){
                    $.messager.alert("提示","请至少选择一条记录哟^_^!");
                    return ;
                }
                $.messager.confirm("确认","亲，是否要删除这些记录~_~!",function (r) {
                    if(r) {
                        var ids=[];
                        for(var i=0;i<selectrows.length;i++){
                            ids.push(selectrows[i].id);
                        }
                        $.post(
                            'items/batch',
                            {'ids[]':ids},
                            function (data) {
                                $('#dg').datagrid('reload');
                            },
                            'json'
                        )
                    }
                })
            }
        },{
            iconCls: 'icon-up',
            text: '上架',
            handler: function () {
                var  uprows=$('#dg').datagrid("getSelections");
                if(uprows==0){
                    $.messager.alert("提示","请至少选择一条记录哟^_^!");
                    return ;
                }
                $.messager.confirm("确认","选中的商品确定上架？_？",function (r) {
                    if(r){
                        var ids=[];
                        for(var i=0;i<uprows.length;i++){
                            ids.push(uprows[i].id);
                        }
                        $.post(
                            'items/uprows',
                            {'ids[]':ids},
                            function (data) {
                                $('#dg').datagrid('reload');
                            },
                            'json'
                        )
                    }
                })

            }
        },{
            iconCls: 'icon-down',
            text: '下架',
            handler: function () {
                var downrows= $("#dg").datagrid("getSelections");
                if (downrows==0){
                    $.messager.alert("提示","至少选择一条记录哟~_~");
                    return ;
                }
                $.messager.confirm("确认","是否将选中商品改为下架",function (r) {
                    if(r){
                        var ids=[];
                        for(var i=0;i<downrows.length;i++){
                            ids.push(downrows[i].id);
                        }
                        $.post(
                            'items/downrows',
                            {"ids[]":ids},
                            function (data) {
                                $("#dg").datagrid("reload");
                            },
                            'json'
                        )
                    }
                })
            }
        }];--%>
    $('#dg').datagrid({
        //使用按钮
        toolbar: '#toolbar',
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url:'items',
        //允许多列排序
        multiSort: true,
        //按钮实行
        /*toolbar:toolbar,*/
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
       rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20,30,50,100],
        //列属性
        columns:[[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品编号', width: 100},
            {field: 'title', title: '商品名称', width: 100,sortable:true},
            {field: 'sellPoint', title: '卖点', width: 100,sortable:true},
            {field: 'priceView', title: '价格', width: 100},
            {field: 'statusName', title: '商品类型', width: 100},
            {field: 'num', title: '数量', width: 100},
            {field: 'created', title: '创建时间', width: 100,formatter:function (value,row,index) {
                return moment(value).format("l");
            }},
            {field: 'updatedtime', title: '修改时间', width: 100},
            {field: 'stuting', title: '状态', width: 100}
        ]]

    });


</script>