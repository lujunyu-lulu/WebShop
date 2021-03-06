function initHisOrd(hisordData){
	$("span#orderID").text(hisordData.orderInfo.orderNum);
	$("span#orderStatus").text(hisordData.stateInfo);
	$("span#ordCreTime").text(hisordData.orderInfo.createTime);
	//添加历史订单商品信息.
	$("div#ho_wares table").find("tr").not("tr.titleTr").remove();
	for (var i = 0; i < hisordData.orderItemList.length; i++) {
		var product_id = hisordData.orderItemList[i].productId;
		var product_image =  ctxImg +hisordData.productList[i].image;
		var product_name = hisordData.orderItemList[i].productName;
		var product_quanity = hisordData.orderItemList[i].quantity;
		var product_price = hisordData.orderItemList[i].price;
		var trHtml = "<tr><td><a href='' product_id='" + product_id + "'><img src='" + product_image + "'></a><p>" +
			product_name + "</p></td><td><span id='count'>" + product_quanity + "</span></td><td>￥<span id=''totalprice'>" +
			eval(product_price * product_quanity) + "</span></td><td>￥<span id='postage'>0</span></td>" +
			"<td><button type='button' class='addAccessBtn' data-toggle='modal' data-target='.addAccessDiv'>添加评论</button></td></tr>";
		var $new = $(trHtml);
		$("tr.titleTr").after($new);
	}
	$("span#inforAddress").text(hisordData.orderInfo.contactAddress);
	$("span#inforTel").text(hisordData.orderInfo.contactMobile);
	$("span#inforName").text(hisordData.orderInfo.contactName);
	$("span#nhr").text(hisordData.orderInfo.price);
	
	setPageHeight();
}

function setPageHeight(){
	var num = $("#ho_wares table tr").length;
	$("#ho_wares").height(eval((num - 1) * 200 + 650));
	$("#ho_left").height(eval((num - 1) * 200 + 870));
	$("#ho_center").height(eval((num - 1) * 200 + 870));
	$("#ho_right").height(eval((num - 1) * 200 + 870));
	$("#ho_container").height(eval((num - 1) * 200 + 1060));
}

/*页面加载时请求并填充数据*/
/*$(document).ready(function() {
	$("span#orderID").text(hisordData.orderInfo.orderNum);
	$("span#orderStatus").text(hisordData.orderInfo.status);
	$("span#ordCreTime").text(hisordData.orderInfo.createTime);
	//添加历史订单商品信息.
	for (var i = 0; i < hisordData.orderItemList.length; i++) {
		var product_id = hisordData.orderItemList[i].productId;
		var product_image = hisordData.productList[i].image;
		var product_name = hisordData.orderItemList[i].productName;
		var product_quanity = hisordData.orderItemList[i].quantity;
		var product_price = hisordData.orderItemList[i].price;
		var trHtml = "<tr><td><a href='' product_id='" + product_id + "'><img src='" + product_image + "'></a><p>" +
			product_name + "</p></td><td><span id='count'>" + product_quanity + "</span></td><td>￥<span id=''totalprice'>" +
			eval(product_price * product_quanity) + "</span></td><td>￥<span id='postage'>1</span></td>" +
			"<td><button type='button' class='addAccessBtn' data-toggle='modal' data-target='.addAccessDiv'>添加评论</button></td></tr>";
		var $new = $(trHtml);
		$("tr.titleTr").after($new);
	}
	$("span#inforAddress").text(hisordData.orderInfo.contactAddress);
	$("span#inforTel").text(hisordData.orderInfo.contactMobile);
	$("span#inforName").text(hisordData.orderInfo.contactName);
	$("span#nhr").text(hisordData.orderInfo.price);
});*/

/*添加点击事件*/
$(document).ready(function() {
	/* 添加评论 点击 内容初始化 */
	$("div#ho_wares table").on("click", "button.addAccessBtn", function() {
		var productId = $(this).closest("tr").children().eq(0).find("a").attr("product_id");
		var productName = $(this).closest("tr").children().eq(0).find("p").text();
		$("div.addAccessDiv").find("input#aproductId").val(productId);
		$("div.addAccessDiv").find("input#aproductName").val(productName);
		$("div.addAccessDiv").find("input#InputContent").val("");
	});

	/* 添加评论 上传 */
	$("div.addAccessDiv").on("click", "button#addAccessSub", function() {
		var productId = $("div.addAccessDiv").find("input#aproductId").val();
		var accessContent = $("div.addAccessDiv").find("input#InputContent").val();
		var userName = $("div#ho_personal").attr("userName");
		var data = {
			"productId": productId,
			"content": accessContent,
			"userName": userName,
			"star": 5
		}
		$.ajax({
			url: ctx+"/products/comments",
			type: "post",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(data),
			success: function(data) {
				if (JSON.parse(data).success) {
					alert("添加成功~");
				}
			}
		});
	});

	/* 查看商品详情  */
	$("div#ho_wares table").on("click", "td a", function() {
		var product_id = $(this).attr("product_id");
		var search_url = ctx+"/products/" + product_id;
		$(this).attr("href", search_url);
		$(this).attr("target", "_blank");
	});

	/* 打开个人页面 */
	$("div#ho_personal").on("click", "a#personal", function() {
		var userName = $("div#ho_personal").attr("userName");
		var search_url = ctx+"/users/" + userName;
		$(this).attr("href", search_url);
		$(this).attr("target", "_blank");
		/*$.ajax({
			url: search_url,
			type: "get",
			success: function() {}
		});*/
	});

	/* 打开购物车 */
	$("div#ho_personal").on("click", "a#shoppingCart", function() {
		var userName = $("div#ho_personal").attr("userName");
		var search_url = ctx+"/users/" + userName + "/carts";
		$(this).attr("href", search_url);
		$(this).attr("target", "_blank");
		/*$.ajax({
			url: search_url,
			type: "get",
			success: function() {

			}
		});*/
	});

	/* 打开收藏页面 */
	$("div#ho_personal").on("click", "a#collection", function() {
		var userName = $("div#ho_personal").attr("userName");
		var search_url = ctx+"/users/" + userName + "/stars";
		$(this).attr("href", search_url);
		$(this).attr("target", "_blank");
		/*$.ajax({
			url: search_url,
			type: "get",
			success: function() {

			}
		});*/
	});

	/* 退出登录 */
	$("div#ho_personal").on("click", "a#outLogin", function() {
		/*$.ajax({
			url: ctx+"/users/logout",
			type: "post",
			success: function() {}
		});*/
		var out_url=ctx+"/users/logout";
		$("form#logOutForm").attr("action",out_url);
		$("form#logOutForm").submit();
	});
});

/*设置页面框架元素高度*/
$(document).ready(function() {
	setPageHeight();
});
