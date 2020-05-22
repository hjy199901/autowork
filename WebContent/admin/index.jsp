<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="base/header.jsp" %>
	<title>后台首页-中山医院</title>
	</head>

	<body>
		<!-- 顶部开始 -->
		<div class="container" style="background:blue">
			<div class="logo">
				<a href="./index">中山大学第一附属医院</a>
			</div>
			<div class="left_open">
				<!-- <i title="展开左侧栏" class="iconfont">&#xe699;</i> -->
				<i title="展开左侧栏" class="layui-icon layui-icon-shrink-right"></i>
				
			</div>
			<ul class="layui-nav left fast-add" lay-filter="">
				<!-- <li class="layui-nav-item">
					<a href="javascript:;">+新增</a>
					<dl class="layui-nav-child">
						二级菜单
						<dd>
							<a onclick="WeAdminShow('资讯','https://www.baidu.com/')"><i class="layui-icon layui-icon-list"></i>资讯</a>
						</dd>
						<dd>
							<a onclick="WeAdminShow('图片','http://www.baidu.com')"><i class="layui-icon layui-icon-picture-fine"></i>图片</a>
						</dd>
						<dd>
							<a onclick="WeAdminShow('用户','https://www.baidu.com/')"><i class="layui-icon layui-icon-user"></i>用户</a>
						</dd>
					</dl>
				</li> -->
			</ul>
			<ul class="layui-nav right" lay-filter="">
				<li class="layui-nav-item">
					<a href="javascript:;">${username}</a>
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd>
							<a onclick="WeAdminShow('个人信息','./userinfo')">个人信息</a>
						</dd>
						<dd>
							<a href="./login">切换帐号</a>
						</dd>
						<dd>
							<a class="loginout" href="./loginout">退出</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item to-index">
					<a href="<%=request.getContextPath() %>/">前台首页</a>
				</li>
			</ul>

		</div>
		<!-- 顶部结束 -->
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav">
			<div id="side-nav">
				<ul id="nav">
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe6b8;</i>
							<cite>用户管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="<%=request.getContextPath() %>/admin/userlist">
									<i class="iconfont">&#xe6a7;</i>
									<cite>用户列表</cite>

								</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe705;</i>
							<cite>文章管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="./pages/article/list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>文章列表</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/article/category.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>分类管理</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe723;</i>
							<cite>订单管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="./pages/order/list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>订单列表</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe726;</i>
							<cite>管理员管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="./pages/admin/list.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>管理员列表</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/admin/role.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>角色管理</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/admin/cate.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>权限分类</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/admin/rule.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>权限管理</cite>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe6ce;</i>
							<cite>系统统计</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="<%=request.getContextPath() %>/pages/echarts/echarts1.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>拆线图</cite>
								</a>
							</li>
							<li>
								<a _href="<%=request.getContextPath() %>/pages/echarts/echarts2.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>柱状图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts3.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>地图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts4.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>饼图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts5.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>雷达图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts6.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>k线图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts7.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>热力图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts8.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>仪表图</cite>
								</a>
							</li>
							<li>
								<a _href="./pages/echarts/echarts9.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>地图DIY实例</cite>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<!-- <div class="x-slide_left"></div> -->
		<!-- 左侧菜单结束 -->
		<!-- 右侧主体开始 -->
		<div class="page-content">
			<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
				<ul class="layui-tab-title" id="tabName">
					<li>我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe src='<%=request.getContextPath() %>/pages/welcome.html' frameborder="0" scrolling="yes" class="weIframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="page-content-bg"></div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		<!-- 底部开始 -->
		<div class="footer">
			<div class="copyright">Copyright ©2018 WeAdmin v1.0 All Rights Reserved</div>
		</div>
		<!-- 底部结束 -->
		<script type="text/javascript">
//			layui扩展模块的两种加载方式-示例
//		    layui.extend({
//			  admin: '{/}../../static/js/admin' // {/}的意思即代表采用自有路径，即不跟随 base 路径
//			});
//			//使用拓展模块
//			layui.use('admin', function(){
//			  var admin = layui.admin;
//			});
			layui.config({
			  base: '<%=request.getContextPath() %>/static/js/'
			  ,version: '101100'
			}).use('admin');
			layui.use(['jquery','admin'], function(){
				var $ = layui.jquery;
				
			});

		</script>
	</body>
	<!--Tab菜单右键弹出菜单-->
	<ul class="rightMenu" id="rightMenu">
        <li data-type="fresh">刷新</li>
        <li data-type="current">关闭当前</li>
        <li data-type="other">关闭其它</li>
        <li data-type="all">关闭所有</li>
    </ul>

</html>