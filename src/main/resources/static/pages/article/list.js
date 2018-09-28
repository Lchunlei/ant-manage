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
		elem: '#articleList',
        url:'../../ant/task/list',
        method:'post',
		cellMinWidth: 80,
		cols: [
			[{
				type: 'checkbox'
			}, {
				field: 'taskId',width: 60,title: 'ID'
			}, {
				field: 'title',width: 90,title: '一级标题'
			}, {
                field: 'jobUrl',width: 90,title: '链接地址'
            }, {
				field: 'jobAmount',width: 90,title: '充值金额'
            }, {
				field: 'balance',width: 90,title: '余额'
            }, {
				field: 'serviceCharge',width: 90,title: '手续费'
            }, {
				field: 'readVol',width: 90,title: '阅读总量'
            }, {
				field: 'moneyRead',width: 90,title: '有赏阅读量'
            },  {
                field: 'getVol',width: 90,title: '领取数'
            },  {
                field: 'seTime',width: 200,title: '有效期'
            }, {
				field: 'operate',title: '操作',toolbar: '#operateTpl',unresize: true
			}]
		],
        //data:tabData,
		// data: [{
		// 	"id": "1",
		// 	"title": "WeAdmin的第一个版本在不断地抽空完善学习中",
		// 	"date": "2018-02-03",
		// 	"category": "官方动态",
		// 	"sort": "1",
		// 	"recommend": "checked",
		// 	"top": "checked"
		// }, {
		// 	"id": "2",
		// 	"title": "WeAdmin的测试数据一二三四五六七",
		// 	"date": "2018-02-03",
		// 	"category": "新闻资讯",
		// 	"sort": "1",
		// 	"recommend": "",
		// 	"top": "checked"
		// }],
		event: true,
		page: true
	});

	$(function(){
		form.render();
	});

	var active = {

		getCheckData: function() { //获取选中数据
			var checkStatus = table.checkStatus('articleList'),
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
			var checkStatus = table.checkStatus('articleList'),
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
		}

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
    table.reload('articleList', {
        where: {searchValue:searchV, sDate:sDateV,eDate:eDateV},
        page: {
            curr: 1 //重新从第 1 页开始
        }
    });
}