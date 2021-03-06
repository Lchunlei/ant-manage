layui.extend({
	admin: '{/}../../static/js/admin'
});
layui.use(['laydate', 'jquery', 'admin'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        admin = layui.admin;
    //执行一个laydate实例
    laydate.render({
        elem: '#start' //指定元素
    });
    //执行一个laydate实例
    laydate.render({
        elem: '#end' //指定元素
    });
});
var table;
layui.use(['table', 'jquery','form', 'admin'], function() {

	table = layui.table,
		$ = layui.jquery,
		form = layui.form,
		admin = layui.admin;
	table.render({
		elem: '#bannerList',
        url:'../../ant/banner/list',
        method:'post',
		cellMinWidth: 80,
		cols: [
			[{
				type: 'checkbox'
			}, {
				field: 'bannerId',width: 60,title: 'ID'
			}, {
				field: 'title',title: '标题'
			}, {
                field: 'imgUrl',width: 150,title: '图片预览',toolbar: '#yulan'
            }, {
				field: 'actionUrl',width: 150,title: '链接地址',toolbar: '#lianjie'
            }, {
				field: 'channelId',width: 90,title: '图片渠道'
            }, {
                field: 'createTime',width: 200,title: '创建时间'
            }, {
				field: 'operate',title: '操作',toolbar: '#operateTpl',unresize: true
			}]
		],
		event: true,
		page: true
	});

	$(function(){
		form.render();
	});

	var active = {

		getCheckData: function() { //获取选中数据
			var checkStatus = table.checkStatus('bannerList'),
				data = checkStatus.data;
			//console.log(data);
			//layer.alert(JSON.stringify(data));
			if(data.length > 0) {
				layer.confirm('确认要删除吗？' + JSON.stringify(data), function(index) {
					layer.msg('删除成功', {
						icon: 1
					});
					//找到所有被选中的，发异步进行删除
					$(".layui-table-body .layui-form-checked").parents('tr').remove();
				});
			} else {
				layer.msg("请先选择需要删除的文章！");
			}

		},

		Recommend: function() {
			var checkStatus = table.checkStatus('bannerList'),
				data = checkStatus.data;
			if(data.length > 0) {
				layer.msg("您点击了推荐操作");
				for(var i = 0; i < data.length; i++) {
					console.log("a:" + data[i].recommend);
					data[i].recommend = "checked";
					console.log("aa:" + data[i].recommend);
					form.render();
				}

			} else {
				console.log("b");
				layer.msg("请先选择");
			}

			//$(".layui-table-body .layui-form-checked").parents('tr').children().children('input[name="zzz"]').attr("checked","checked");
		},
		Top: function() {
			layer.msg("您点击了置顶操作");
		},
		Review: function() {
			layer.msg("您点击了审核操作");
		},
	};

	$('.demoTable .layui-btn').on('click', function() {
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});

	/*用户-删除*/
	window.member_del = function(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发异步删除数据
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon: 1,
				time: 1000
			});
		});
	}

});

function delAll(argument) {
	var data = tableCheck.getData();
	layer.confirm('确认要删除吗？' + data, function(index) {
		//捉到所有被选中的，发异步进行删除
		layer.msg('删除成功', {
			icon: 1
		});
		$(".layui-form-checked").not('.header').parents('tr').remove();
	});
}

function ReTable(){
    var sDateV = $("#start").val();
    var eDateV = $("#end").val();
    var searchV = $("#search").val();
    table.reload('bannerList', {
        where: {searchValue:searchV, sDate:sDateV,eDate:eDateV},
        page: {
            curr: 1 //重新从第 1 页开始
        }
    });
}

function deleBanner(bannerId){
    $.ajax({
        url:"../../ant/banner/del?bannerId="+bannerId
        ,type:"GET"
        ,processData:false
        ,contentType:false
        ,success:function(data_resp){
            if('R000'==data_resp.code){
                //发异步，把数据提交给php
                layer.alert("操作成功！", {
                    icon: 6
                });
                table.reload('bannerList', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                });
            }else {
                layer.msg(data_resp.message, {
                    icon: 5,
                    time: 1000
                });
            }
        }
        ,error:function(e){
            layer.msg('系统异常!', {
                icon: 5,
                time: 1000
            });
        }
    });
}