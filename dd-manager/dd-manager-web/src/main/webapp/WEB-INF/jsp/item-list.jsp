<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<table id="dg"></table>
<script>
    $('#dg').datagrid({
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url:'items',
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
            {field: 'title', title: '商品名称', width: 100},
            {field: 'sellPoint', title: '卖点', width: 100},
            {field: 'price', title: '价格', width: 100},
            {field: 'catName', title: '商品类型', width: 100},
            {field: 'num', title: '数量', width: 100},
            {field: 'created', title: '创建时间', width: 100},
            {field: 'updated', title: '修改时间', width: 100},
            {field: 'stuting', title: '状态', width: 100}

        ]]
    });


</script>