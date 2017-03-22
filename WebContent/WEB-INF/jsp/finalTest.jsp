<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>




<!--
<script type="text/javascript" src="/resources/js/drag-arrange.js"></script>
 <script type="text/javascript" src="/resources/js/date.js"></script>
<script type="text/javascript" src="/resources/js/tcal.js"></script>
<link rel="StyleSheet" type="text/css" href="/resources/css/tcal.css" />
<script type="text/javascript" src="/resources/js/drag-arrange.js"></script> -->


<spring:url value="resources/js/date.js" var="date" />
<script src="${date}"></script>

<spring:url value="resources/js/tcal.js" var="tcal" />
<script src="${tcal}"></script>


 <spring:url value="resources/js/drag-arrange.js" var="drag-arrange" />
<script src="${drag-arrange}"></script> 

<spring:url value="resources/css/tcal.css" var="tcal" />
<link href="${tcal}" rel="stylesheet" />





<script type="text/javascript">
	$(function() {
		$('.draggable-element').arrangeable();
		$('li').arrangeable({
			dragSelector : '.drag-area'
		});
	});
</script>
<script>
	function Concat(val)

	{
		document.getElementById('task').value = val;
	}
</script>
<script>
	function ConcatFunction(va) {

		document.getElementById('task2').value = va;

	}

	$(document)
			.ready(
					function() {
						var max_fields = 10000000000; //maximum input boxes allowed
						var wrapper = $(".input_fields_wrap"); //Fields wrapper
						var add_button = $(".add_field_button"); //Add button ID

						var x = 1; //initlal text box count
						$(add_button)
								.click(
										function(e) { //on add input button click
											e.preventDefault();
											if (x < max_fields) { //max input box allowed
												x++; //text box increment
												var i = 1;
												i = $('input').size() + 1;
												console.log(i);
												/* alert(i); */
												$(
														'<li><a href="#" class="remove_field">x</a><span class="title"><input placeholder=":task name'
																+ i
																+ '" id="task" width="45px" height="40" type="text" name="task'
																+ i
																+ '" onfocus="ConcatFunction(this.value)" onkeyup="ConcatFunction(this.value);"/></span><span class="drag-area"></span><a id="help-anchor" class="hidden" href="index.html"> &nbsp;></a><a id="help-anchor" href="javascript:location.reload(true);">__</a></li>')
														.appendTo('.drag-list');
												$('li').arrangeable({
													dragSelector : '.drag-area'
												});

												/*$("ul")
														.append(
																'<li><a href="#" class="remove_field">[]</a><span class="title"><input id="task" width="180" height="40" type="text" name="task" onfocus="ConcatFunction(this.value)" onkeyup="ConcatFunction(this.value);"/></span><span class="drag-area"></span><a id="help-anchor" href="index.html"> &nbsp;></a></li>');
												 ("li").className="drag-list";  */
												//$('#drag-list').append(newElement);
											}
											//<input id="task" width="180" height="40" type="text" name="task" onfocus="ConcatFunction(this.value)" onkeyup="ConcatFunction(this.value);"/>
										});

						$("ul").on("click", ".remove_field", function(e) { //user click on remove text
							e.preventDefault();
							$(this).parent('li').remove();
							x--;
						})
					});

	function myFunction() {
		alert("Do You want to create a new usertask!");
	}
	$(document).ready(function() {
		$('#closeButton').on('click', function(e) {
			$('#previewBox').remove();
		});
	});
</script>

<script>
	$(document).ready(function() {

		//if you wish to keep both the divs hidden by default then dont forget to hide //them           
		$("#help-content").hide();
		$("#about-content").hide();

		$("#about-anchor").click(function() {
			$("#help-content").hide();
			$("#about-content").show();
		});

		$("#help-anchor").click(function() {
			$("#help-content").show();
			$("#about-content").hide();
		});
	});
</script>
<script>
	function TimedRefresh(t) {

		setTimeout("location.reload(true);", t);

	}
</script>
<!-- 
------------------------------------------------------------------------Script end------------------------------------------------------------------------------------------

 -->
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

.left {
	float: left;
	background-color: #898989;
	width: 30%;
}

.left h1 {
	font-size: 20px;
	float: right;
	padding: 1px 5px;
	color: #fff;
}

.right {
	float: right;
	background-color: pink;
	width: 50%;
}

.right ul {
	float: left;
}

.right ul li {
	float: left;
	list-style-type: none;
	color: red;
	padding: 0 5px;
}

.right ul li a {
	color: green;
	text-decoration: none;
}

.staticBox {
	/* border: 2px solid #00f0fd; */
	/* height:; /* This doesn't change the height as I thought. If I change this to use px units the height works fine so why not %? */
	border-right-width: 30px;
}

.statusbox:hover {
	background-color: #fff333;
}

.close-icon {
	display: block;
	box-sizing: border-box;
	width: 20px;
	height: 20px;
	border-width: 3px;
	border-style: solid;
	border-color: red;
	border-radius: 100%;
	background: -webkit-linear-gradient(-45deg, transparent 0%, transparent 46%, white
		46%, white 56%, transparent 56%, transparent 100%),
		-webkit-linear-gradient(45deg, transparent 0%, transparent 46%, white
		46%, white 56%, transparent 56%, transparent 100%);
	background-color: red;
	box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.5);
	transition: all 0.3s ease;
}

.style-5 input[type="text"] {
	padding: 10px;
	border: solid 1px #fff;
	box-shadow: inset 1px 1px 2px 0 #707070;
	transition: box-shadow 0.3s;
}

.style-5 input[type="text"]:focus, .style-5 input[type="text"].focus {
	box-shadow: inset 1px 1px 2px 0 #c9c9c9;
}

body {
	font-family: arial;
	background: rgb(242, 244, 246);
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

h3 {
	color: rgb(199, 204, 209);
	font-size: 28px;
	text-align: center;
}

#elements-container {
	text-align: center;
}

.draggable-element {
	display: inline-block;
	width: 200px;
	height: 200px;
	background: white;
	border: 1px solid rgb(196, 196, 196);
	line-height: 200px;
	text-align: center;
	margin: 10px;
	color: rgb(51, 51, 51);
	font-size: 30px;
	cursor: move;
}

.drag-list {
	width: 400px;
	margin: 0 auto;
}

.drag-list>li {
	list-style: none;
	background: rgb(255, 255, 255);
	border: 1px solid rgb(196, 196, 196);
	margin: 5px 0;
	font-size: 24px;
}

.drag-list .title {
	display: inline-block;
	width: 230px;
	padding: 6px 6px 6px 12px;
	vertical-align: top;
}

.drag-list .drag-area {
	display: inline-block;
	background-image:
		url("file:///C:/Users/Lenovo/workspace2/SImpleComment/calendar.gif");
	width: 60px;
	height: 40px;
	vertical-align: top;
	float: left;
	cursor: move;
	/* background-image: url("handle-icon-custom.svg"); */
}

.code {
	background: rgb(255, 255, 255);
	border: 1px solid rgb(196, 196, 196);
	width: 600px;
	margin: 22px auto;
	position: relative;
}

.code::before {
	content: 'Code';
	background: rgb(80, 80, 80);
	width: 96%;
	position: absolute;
	padding: 8px 2%;
	color: rgb(255, 255, 255);
}

.code pre {
	margin-top: 50px;
	padding: 0 13px;
	font-size: 1em;
}

.add_field_button {
	padding: 10px 15px;
	font-size: 20px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	border: none;
	border-radius: 15px;
	box-shadow: 0 5px #999;
	background-color: #4CAF50;
}

<!--
background-color: #3e8e41
 -->.add_field_button:hover input[type="submit"] {
	visibility: visible !important;
}

.add_field_button:active {
	background-color: #3e8e41;
	box-shadow: 0 5px #888;
	transform: translateY(4px);
}

.hidden {
	display: none;
}

.hidden:hover a {
	display: block;
}
</style>

<style type="text/css">
.drag-list:hover input[type="submit"] {
	visibility: visible !important;
}
</style>
<!-- 
------------------------------------------------------------------------Show left side------------------------------------------------------------------------------------------
<button
				class="add_field_button">
 -->
<section class="showcase showcase-2"
	onload="JavaScript:TimedRefresh(3000);">
	<div id="anchor-div" class="staticBox"
		style="float: left; width: 100% font-size:20px; padding: 1px 5px; color: gray;">

		<ul class="drag-list">
			<a id="about-anchor" href="javascript:location.reload(true);"><input
				class="add_field_button" type="button" value="Add Task" /></a>
			<a href="#"><input class="add_field_button" type="submit"
				value="Add Section" style="visibility: hidden;" /></a>
			<!-- <li><span class="title">list 7</span><span class="drag-area"></span></li>
			<li><span class="title">list 8</span><span class="drag-area"></span></li>
			<li><span class="title">This is the new one</span> <span
				class="drag-area"></span></li> -->
		</ul>

	</div>
</section>
<!-- 
------------------------------------------------------- right side upper-----------------------------------------------------------------------------------------------------------
<div>
<div></div>
<div></div>
</div>
 -->

<div id="previewBox" class="right" style="float: right; width: 57%">

	<div id="about-content">
		<button class="close"
			onclick="document.getElementById('about-content').style.display='none'"
			align="right">Close</button>

		<!-- 
------------------------------------------------------------------------------------Script for ajax

 -->



		<form id="myform" method="get">
			<pre>
			<table align="center">
				<tr>
					<td><em>Task Name</em></td>
					<td><input type="text" id="task2" name="task2"
							placeholder=":task name" onkeyup="Concat(this.value)"></td>
				</tr>
				<tr>
					<td><label for="start">Start Date:</label></td>
					<td><input type="text" id="sdate" name="sdate" class="tcal"
							value="" placeholder=":start date like 02/21/2017"></td>
				</tr>
				<tr>
					<td><label for="end">End Date:</label></td>
					<td><input type="text" id="edate" name="edate" class="tcal"
							value="" placeholder=":start date like 02/21/2017"></td>
				</tr>
				<tr>
					<td><label> Assign To</label></td>
					<td><select name="Mname" id="Mname">
							<option>Aung Aung</option>
							<option>Zaw Zaw</option>
							<option>Swe Swe</option>
					</select></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="create"
							id='mysubmit'></td>
				</tr>
			</table>
			</pre>
		</form>

		<script type="text/javascript">
			$(document).ready(function() {
				//alert("Onready the page");
				$("#myform").on('submit', (function(e) {
					alert("Data  will be added to the database");
					e.preventDefault();
					var task2 = $("#task2").val();
					console.log("task2");

					var sdate = $("#sdate").val();
					console.log("sdate");
					var edate = $("#edate").val();
					console.log("edate");
					var Mname = $("#Mname").val();
					console.log("Mname");
					$.ajax({
						url : "createTask1",
						type : "GET",
						data : {
							task2 : task2,
							sdate : sdate,
							edate : edate,
							Mname : Mname
						},
						contentType : false,
						/* cache: false,
						processData:false, */
						success : function(data) {
							alert(data);
						},
						error : function() {
							alert("Something Went wrong");
						}
					});
				}));
			});
		</script>





		<!-- 
------------------------------------------------------------------------------------right side lower
</div>
<div id="about-content">
 -->

		<script>
			var request;
			function postComment() {
				var comment = document.commentform.comment.value;
				var email = document.commentform.email.value;

				var url = "viewComment?comment=" + comment + "&email=" + email;

				if (window.XMLHttpRequest) {
					request = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					request = new ActiveXObject("Microsoft.XMLHTTP");
				}

				try {
					request.onreadystatechange = function() {
						if (request.readyState == 4) {
							var val = request.responseText;
							document.getElementById('mylocation').innerHTML = val;
						}
					}//end of function  
					request.open("GET", url, true);
					request.send();
				} catch (e) {
					alert("Unable to connect to server");
				}
			}
		</script>


		<form name="commentform">
			<table align="center">

				<tr>
					<td colspan="2">Enter Comment:</td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="comment"
							style="width: 300px; height: 100px" required>  
</textarea></td>
				</tr>
				<tr>
					<td colspan="2">Enter Email:<br /> <input type="text"
						name="email" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="Post Comment"
						onclick="postComment()"></td>
				</tr>
			</table>
		</form>

		<span id="mylocation"></span>
	</div>
</div>

<!-- 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------the end
</div>
 -->


