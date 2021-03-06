<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Video, FFmpeg, JavaEE" />
<meta name="author" content="Lei Xiaohua" />
<meta name="description" content="The simplest video website based on JavaEE and FFmpeg" />

<title>BONO Video</title>

<link href="css/svw_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script> 
<script type="text/javascript" src="js/jquery-ui.min.js"></script> 
<script type="text/javascript" src="js/showhide.js"></script> 
<link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="js/jquery.mousewheel.js"></script> 
<script type="text/JavaScript" src="js/slimbox2.js"></script> 

</head>

<body id="subpage">

<div id="svw_header_wrapper">
	<!-- <%@ include file="/cheader1.jsp"%>  -->
</div>	<!-- END of svw_header_wrapper -->

<div id="svw_main">

			<h2>招聘视频</h2>
            <div class="post">
            <div class="meta">
            </div> 
            </div>
            <c:if test="${empty resultvideo}">
            <p><s:property value="%{getText('video.listempty')}"/></p>
            <div style="height:300px;"></div>
            </c:if>
            <c:forEach items="${resultvideo}" var="video">
			<div class="col one_fourth gallery_box" style="${video.videostate.cssstyle}">
                <a href="VideoReadByID1.action?videoid=${video.id}"><img src="${video.thumbnailurl}" alt="thumbnail" class="image_frame"/></a>
                <h5><a href="VideoReadByID1.action?videoid=${video.id}">${video.name}</a></h5>
                <p><s:property value="%{getText('video.edittime')}"/>:${video.edittime}</p>
                <p>
               	<a href="#"><s:property value="%{getText('video.content')}"/></a>|
                <a href="#"><s:property value="%{getText('video.edit')}"/></a>
                </p>
			</div>
            </c:forEach>    
            <div class="cleaner"></div>
    <div class="cleaner"></div>
</div> <!-- END of svw_main -->

 <!-- END of svw_bottom_wrapper -->

<div id="svw_footer_wrapper">
    <%@ include file="/cfooter.jsp"%>
</div> <!-- END of svw_footer -->

</body>
</html>