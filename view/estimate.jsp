<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body{
            margin:auto;
        }
        
        @font-face {
		font-family: 'NanumSquareB';
		src: url("fonts/NanumSquareB.ttf") format('truetype'); 
        }
        .section{
            margin-top:30px;
            width:100%;
            height:1000px;
            background-color: aqua;
        }
        .estimate{
            width:1200px;
            display: flex;
            margin:auto;
        }
        .estimate a:link{ text-decoration:none;} 
        .estimate a:visited{ text-decoration:none;} 
        .estimate a:active{ text-decoration:none;} 
        .estimate a:hover{ text-decoration:none;} 
        .estimate_category{
            width:600px;
            height:850px;
            overflow-y : scroll;
            overflow-x : hidden;
            background-color:coral;
        }

        .products{
            border-bottom: 1px solid #999999;
            background-color:#FFFFFF;
        }
        .products_id{
            font-family: 'NanumSquareB';
            font-size:17px;
            color:black;
        }
        .products_spec{
            font-size:8px;
            color:#999999;
        }
        .products_price{
            font-family: 'NanumSquareB';
            font-size:17px;
            color:black;
        }
        .products_btn{
            width:50px;
            height:30px;
            background-color: #f8f8f8;
            color: #888;
            border: 1px solid #e8e8e8;
            font-size: 12px;
            letter-spacing: 0px;
            cursor: pointer;
            display: inline-block;
            margin: 3px 5px; 
        }
        .products_btn:hover{
            background-color: #EB0000;
            color: #FFFFFF;
            transition: all 1.1s;
        }
        .products:hover{
            background:#F9F9F9;

        }
        .estimate_list{
            width:600px;
            height:850px;
            overflow-y : scroll;
            background-color:darkgoldenrod;
        }
        .estimate_listsort{
            border-bottom: 1px solid #999999;
            background-color:#FFFFFF;
        }
    </style>
    <%			response.setCharacterEncoding("utf-8"); // 한글 처리
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=UTF-8");
    	ArrayList model = (ArrayList)request.getAttribute("model");
   		ArrayList price = (ArrayList)request.getAttribute("price");
    	ArrayList context = (ArrayList)request.getAttribute("context");
    	Object product = request.getAttribute("product");
    	request.setAttribute("page", "estimate");
    	System.out.println(product+"입니다.");
		String pro_1 = (String)session.getAttribute("pro_cpu");
		String pro_2 = (String)session.getAttribute("pro_mother");
		String pro_3 = (String)session.getAttribute("pro_memory");
		String pro_4 = (String)session.getAttribute("pro_gpu");
		String pro_5 = (String)session.getAttribute("pro_power");
		String pro_6 = (String)session.getAttribute("pro_device");
		String pro_7 = (String)session.getAttribute("pro_cooler");
		String pro_8 = (String)session.getAttribute("pro_case");
		String pro_9 = (String)session.getAttribute("pro_keyboard");
		String pro_10 = (String)session.getAttribute("pro_mouse");
		String pro_11 = (String)session.getAttribute("pro_monitor");
		
    		%>
    <title>Document</title>
</head>
<body>
    
    
    
<!------------------------------ ▼ 상단 공통 헤더 ▼ ------------------------------>
<div id="headers"></div>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">   
$(document).ready( function() {

$("#headers").load("Header.html");
});
</script>
<!------------------------------ ▲ 상단 공통 헤더 ▲ ------------------------------>

<div class="section">  
    
    <%HttpSession estimated = request.getSession(true);
    	int y =0; %>
    <form action = "estimateObject">
    <%if (product.equals("cpu")){ %>
        <table class="sortitems_combobox"><td>CPU 제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">CPU 제조사 선택</option>
        <option value="intel">인텔</option><option value="amd">암드</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>코어 수</td> <td><input type = "hidden" id="detail_2" name="detail_2" value="core"> <select name="second"><option value="null" selected="selected">코어 구분</option>
    	<option value="8">8코어</option><option value="4">4코어</option><option value="16">16코어</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>Intel 소켓</td><td><input type = "hidden" id="detail_3" name="detail_3" value="socket"><select name="third"><option value="null" selected="selected">인텔 소켓 구분</option>
        <option value="1151v2">1151</option><option value="1150">1150</option><option value="775">775</option>
		</select></td></table>
           
        <table class="sortitems_combobox"><td>AMD 소켓</td><td><input type = "hidden" id="detail_4" name="detail_4" value="socket"><select name="fourth"><option value="null" selected="selected">AMD 소켓구분</option>
        <option value="AM4">am4</option><option value="AM3">am3</option><option value="AM2">am2</option>
        </select></td></table>
       	<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="cpu">
        <input type = "hidden" id="product" name="productObject" value="cpu_t">
    <%} %>
    
        <%if (product.equals("mother")){ %>
        <table class="sortitems_combobox"><td>칩셋 제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="c_company"><select name="first"><option value="null" selected="selected">칩셋 제조사 선택</option>
        <option value="Intel">인텔</option><option value="AMD">AMD</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>메인보드 제조사</td><td><input type = "hidden" id="detail_2" name="detail_2" value="company"><select name="second"><option value="null" selected="selected">메인보드 제조사 선택</option>
        <option value="GIGABYTE">기가바이트</option><option value="ASUS">ASUS</option><option value="MSI">MSI</option><option value="Asrock">Asrock</option><option value="BIOSTAR">BIOSTAR</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>메인보드 칩셋</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="chipset"> <select name="third"><option value="null" selected="selected">칩셋 구분</option>
    	<option value="H310">(인텔)H310</option><option value="B360">(인텔)B360</option><option value="B365">(인텔)B365</option><option value="H110">(인텔)H110</option><option value="H410">(인텔)H410</option><option value="B460">(인텔)B460</option><option value="H470">(인텔)H470</option><option value="Z490">(인텔)Z490</option><option value="A320">(AMD)A320</option><option value="B450">(AMD)B450</option><option value="A520">(AMD)A520</option><option value="B550">(AMD)B550</option><option value="X570">(AMD)X570</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>소켓</td><td><input type = "hidden" id="detail_4" name="detail_4" value="socket"><select name="fourth"><option value="null" selected="selected">소켓 구분</option>
        <option value="1151v2">(인텔)1151v2</option><option value="1151">(인텔)1151</option><option value="1200">(인텔)1200</option><option value="3647">(인텔)3647</option><option value="AM4">(AMD)AM4</option><option value="TR4">(AMD)TR4</option><option value="sTRX4">(AMD)sTRX4</option>
		</select></td></table>
           
        <table class="sortitems_combobox"><td>폼팩터</td><td><input type = "hidden" id="detail_5" name="detail_5" value="form"><select name="fifth"><option value="null" selected="selected">폼팩터 구분</option>
        <option value="M-ATX">M-ATX</option><option value="ATX">ATX</option><option value="M-ITX">M-ITX</option><option value="E-ATX">E-ATX</option>
        </select></td></table>
       
        <input type = "hidden" id="product" name="product" value="mother">
        <input type = "hidden" id="product" name="productObject" value="mainboard_t">
    <%} %>
    
     	<%if (product.equals("memory")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="삼성전자">삼성전자</option><option value="마이크론">마이크론</option><option value="TeamGroup">TeamGroup</option><option value="타무즈">타무즈</option><option value="GeIL">GeIL</option><option value="GIGABYTE">기가바이트</option><option value="ADATA">ADATA</option><option value="HP">HP</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>메모리 타입</td><td><input type = "hidden" id="detail_2" name="detail_2" value="type"><select name="second"><option value="null" selected="selected">메모리 타입 선택</option>
        <option value="DDR4">DDR4</option><option value="DDR3">DDR3</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>메모리 용량</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="mem"> <select name="third"><option value="null" selected="selected">메모리 용량 선택</option>
    	<option value="8GB">8GB</option><option value="16GB">16GB</option><option value="32GB">32GB</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>메모리 클럭</td><td><input type = "hidden" id="detail_4" name="detail_4" value="clock"><select name="fourth"><option value="null" selected="selected">메모리 클럭 선택</option>
        <option value="1600MHz">1600MHz</option><option value="2133MHz">2133MHz</option><option value="2666MHz">2666MHz</option><option value="2933MHz">2933MHz</option><option value="3200MHz">3200MHz</option><option value="3600MHz">3600MHz</option>
		</select></td></table>
           
       	<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="memory">
        <input type = "hidden" id="product" name="productObject" value="memory_t">
    <%} %>
    
        <%if (product.equals("gpu")){ %>
        <table class="sortitems_combobox"><td>칩셋 제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="chip_com"><select name="first"><option value="null" selected="selected">칩셋 제조사 선택</option>
        <option value="NVIDIA">NVIDIA</option><option value="AMD">AMD</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>그래픽카드 제조사</td><td><input type = "hidden" id="detail_2" name="detail_2" value="company"><select name="second"><option value="null" selected="selected">그래픽카드 제조사 선택</option>
        <option value="GIGABYTE">기가바이트</option><option value="ASUS">ASUS</option><option value="MSI">MSI</option><option value="이엠텍">이엠텍</option><option value="갤럭시">갤럭시</option><option value="ZOTAC">ZOTAC</option><option value="SAPPHIRE">사파이어</option><option value="COLORFUL">COLORFUL</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>칩셋 명</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="chipname"> <select name="third"><option value="null" selected="selected">칩셋 구분</option>
    	<option value="GTX1650">GTX1650</option><option value="GTX1660">GTX1660</option><option value="RTX2060">RTX2060</option><option value="RTX2070">RTX2070</option><option value="RTX2080">RTX2080</option><option value="RTX3060TI">RTX3060TI</option><option value="RTX3080">RTX3080</option><option value="RTX3090">RTX3090</option><option value="RX5500">RX5500</option><option value="RX5600">(AMD)RX5600</option><option value="RX5700">RX5700</option><option value="RX6800">RX6800</option><option value="RX6900">RX6900</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>메모리 용량</td><td><input type = "hidden" id="detail_4" name="detail_4" value="mem"><select name="fourth"><option value="null" selected="selected">메모리 용량</option>
        <option value="4GB">4GB</option><option value="6GB">6GB</option><option value="8GB">8GB</option><option value="10GB">10GB</option><option value="11GB">11GB</option><option value="16GB">16GB</option><option value="24GB">24GB</option>
		</select></td></table>

       <input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="gpu">
        <input type = "hidden" id="product" name="productObject" value="gpu_t">
    <%} %>
    
        <%if (product.equals("power")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="ABKO">ABKO</option><option value="Antec">Antec</option><option value="CORSAIR">CORSAIR</option><option value="EVGA">EVGA</option><option value="FSP">FSP</option><option value="SuperFlower">SuperFlower</option><option value="마이크로닉스">마이크로닉스</option><option value="시소닉">시소닉</option><option value="에너맥스">에너맥스</option><option value="잘만">잘만</option><option value="쿨러마스터">쿨러마스터</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>폼팩터</td><td><input type = "hidden" id="detail_2" name="detail_2" value="form"><select name="second"><option value="null" selected="selected">폼팩터 선택</option>
        <option value="ATX">ATX</option><option value="M-ATX">M-ATX</option><option value="TFX">TFX</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>정격출력</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="output"> <select name="third"><option value="null" selected="selected">정격 출력</option>
    	<option value="500W">500W</option><option value="600W">600W</option><option value="650W">650W</option><option value="700W">700W</option><option value="750W">750W</option><option value="850W">850W</option><option value="1000W">1000W</option><option value="1050W">1050W</option><option value="1200W">1200W</option><option value="1300W">1300W</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>인증</td><td><input type = "hidden" id="detail_4" name="detail_4" value="authen"><select name="fourth"><option value="null" selected="selected">80+인증</option>
        <option value="80+Standard">80+ Standard</option><option value="80+Bronze">80+ Bronze</option><option value="80+Silver">80+ Silver</option><option value="80+Gold">80+ Gold</option><option value="80+Platinum">80+ Platinum</option><option value="80+Titaninum">80+ Titanium</option>
		</select></td></table>

       	<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="power">
        <input type = "hidden" id="product" name="productObject" value="power_t">    
    <%} %>
    
        <%if (product.equals("device")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="Seagate">Seagate</option><option value="Wastern Deigital">WD</option><option value="Toshiba">Toshiba</option><option value="삼성전자">삼성전자</option><option value="마이크론">마이크론</option><option value="ADATA">ADATA</option><option value="타무즈">타무즈</option><option value="SK 하이닉스">SK 하이닉스</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>폼팩터</td><td><input type = "hidden" id="detail_2" name="detail_2" value="form"><select name="second"><option value="null" selected="selected">폼팩터 선택</option>
        <option value="3.5인치">3.5인치</option><option value="2.5형">2.5형</option><option value="M.2(2280)">M.2(2280)</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>인터페이스</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="interface"> <select name="third"><option value="null" selected="selected">인터페이스</option>
    	<option value="SATA3">SATA3</option><option value="PCIe3.0x4">PCIe3.0x4</option><option value="PCIe4.0x4">PCIe4.0x4</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>용량</td><td><input type = "hidden" id="detail_4" name="detail_4" value="mem"><select name="fourth"><option value="null" selected="selected">용량</option>
        <option value="480GB">480GB</option><option value="500GB">500GB</option><option value="512GB">512GB</option><option value="1TB">1TB</option><option value="2TB">2TB</option><option value="3TB">3TB</option><option value="4TB">4TB</option><option value="8TB">8TB</option><option value="10TB">10TB</option>
		</select></td></table>
		
		<table class="sortitems_combobox"><td>메모리 타입</td><td><input type = "hidden" id="detail_4" name="detail_4" value="type"><select name="fifth"><option value="null" selected="selected">메모리 타입</option>
        <option value="CMR">CMR</option><option value="PMR">PMR</option><option value="SMR">SMR</option><option value="MTC">MTC</option><option value="MLC">MLC</option><option value="TLC">TLC</option>
		</select></td></table>

        <input type = "hidden" id="product" name="product" value="device">
        <input type = "hidden" id="product" name="productObject" value="device_t">
   	<%} %>
   	
   	    <%if (product.equals("cooler")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="ABKO">ABKO</option><option value="ALSYE">ALSYE</option><option value="darkFlash">DarkFlash</option><option value="DEEPCOOL">DEEPCOOL</option><option value="3RSYS">3RSYS</option><option value="NZXT">NZXT</option><option value="JONSBO">JONSBO</option><option value="마이크로닉스">마이크로닉스</option><option value="에너맥스">에너맥스</option><option value="얼티메이크">얼티메이크</option><option value="잘만">잘만</option><option value="쿨러마스터">쿨러마스터</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>냉각방식</td><td><input type = "hidden" id="detail_2" name="detail_2" value="ice"><select name="second"><option value="null" selected="selected">냉각 방식</option>
        <option value="공랭">공랭</option><option value="수랭">수랭</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>팬크기</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="fan_size"> <select name="third"><option value="null" selected="selected">팬 크기</option>
    	<option value="92mm">92mm</option><option value="120mm">120mm</option><option value="140mm">140mm</option>
    	</select></td></table> 
                   
        <table class="sortitems_combobox"><td>TDP</td><td><input type = "hidden" id="detail_4" name="detail_4" value="tdp"><select name="fourth"><option value="null" selected="selected">용량</option>
        <option value="130W">130W</option><option value="150W">150W</option><option value="180W">180W</option><option value="195W">195W</option><option value="200W">200W</option><option value="230W">230W</option><option value="280W">280W</option><option value="360W">360W</option>
		</select></td></table>

		<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="cooler">
        <input type = "hidden" id="product" name="productObject" value="cooler_t">
   	<%} %>
   	
   	   	<%if (product.equals("case")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="3RSYS">3RSYS</option><option value="ABKO">ABKO</option><option value="BRAVOTEC">BRAVOTEC</option><option value="CORSAIR">CORSAIR</option><option value="DAVEN">DAVEN</option><option value="MSI">MSI</option><option value="NZXT">NZXT</option><option value="OPBIS">OPBIS</option><option value="리안리">리안리</option><option value="마이크로닉스">마이크로닉스</option><option value="써멀테이크">써멀테이크</option><option value="아이구주">아이구주</option><option value="잘만">잘만</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>케이스 크기</td><td><input type = "hidden" id="detail_2" name="detail_2" value="sized"><select name="second"><option value="null" selected="selected">케이스 크기</option>
        <option value="미니타워">미니타워</option><option value="미들타워">미들타워</option><option value="빅타워">빅타워</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>폼팩터</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="max"> <select name="third"><option value="null" selected="selected">폼팩터</option>
    	<option value="M-ITX">M-ITX</option><option value="M-ATX">M-ATX</option><option value="ATX">ATX</option><option value="E-ATX">E-ATX</option>
    	</select></td></table> 
                   
        <input type = "hidden" id="detail_4" name="fourth" value="null">      
		<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="case">
        <input type = "hidden" id="product" name="productObject" value="case_t">
   	<%} %>
   	
   	   	   	<%if (product.equals("keyboard")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="ABKO">ABKO</option><option value="CHERRY">CHERRY</option><option value="COX">COX</option><option value="VARMILO">VARMILO</option><option value="로지텍">로지텍</option><option value="마이크로닉스">마이크로닉스</option><option value="한성컴퓨터">한성컴퓨터</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>연결 방식</td><td><input type = "hidden" id="detail_2" name="detail_2" value="conn"><select name="second"><option value="null" selected="selected">연결 방식</option>
        <option value="유선">유선</option><option value="무선">무선</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>접점 방식</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="select_s"> <select name="third"><option value="null" selected="selected">접점 방식</option>
    	<option value="멤브레인">멤브레인</option><option value="펜타그래프">펜타그래프</option><option value="무접점(광축)">무접점(광축)</option><option value="기계식">기계식</option>
    	</select></td></table> 
    	
    	<table class="sortitems_combobox"><td>스위치</td> <td><input type = "hidden" id="detail_4" name="detail_4" value="switch"> <select name="fourth"><option value="null" selected="selected">스위치</option>
    	<option value="청축">청축</option><option value="적축">적축</option><option value="저소음 적축">저소음 적축</option><option value="갈축">갈축</option><option value="황축">황축</option>
    	</select></td></table>
    	
    	<table class="sortitems_combobox"><td>키 배열</td> <td><input type = "hidden" id="detail_5" name="detail_5" value="array"> <select name="fifth"><option value="null" selected="selected">키 배열</option>
    	<option value="87키">87키</option><option value="104키">104키</option><option value="108키">108키</option><option value="109키">109키</option>
    	</select></td></table> 
                   
        <input type = "hidden" id="product" name="product" value="keyboard">
        <input type = "hidden" id="product" name="productObject" value="keyboard_t">
   	<%} %>
   	
   	   	<%if (product.equals("mouse")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="ABKO">ABKO</option><option value="COX">COX</option><option value="MAXTILL">MAXTILL</option><option value="로지텍">로지텍</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>연결 방식</td><td><input type = "hidden" id="detail_2" name="detail_2" value="conn"><select name="second"><option value="null" selected="selected">연결 방식</option>
        <option value="유선">유선</option><option value="무선">무선</option><option value="무선+유선">무선+유선</option><option value="무선+블루투스">무선+블루투스</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>감도</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="feel"> <select name="third"><option value="null" selected="selected">감도</option>
    	<option value="4000">4000 DPI</option><option value="5600">5600 DPI</option><option value="8000">8000 DPI</option><option value="12000">12000 DPI</option><option value="16000">16000 DPI</option><option value="25600">25600 DPI</option>
    	</select></td></table> 

        <input type = "hidden" id="detail_4" name="fourth" value="null">      
		<input type = "hidden" id="detail_5" name="fifth" value="null">
        <input type = "hidden" id="product" name="product" value="mouse">
        <input type = "hidden" id="product" name="productObject" value="mouse_t">
   	<%} %>
   	
   	   	<%if (product.equals("monitor")){ %>
        <table class="sortitems_combobox"><td>제조사</td><td><input type = "hidden" id="detail_1" name="detail_1" value="company"><select name="first"><option value="null" selected="selected">제조사 선택</option>
        <option value="삼성전자">삼성전자</option><option value="LG전자">LG전자</option><option value="알파스캔">알파스캔</option><option value="한성컴퓨터">한성컴퓨터</option>
        </select></td></table>
        
        <table class="sortitems_combobox"><td>화면 크기</td><td><input type = "hidden" id="detail_2" name="detail_2" value="inchi"><select name="second"><option value="null" selected="selected">화면 크기</option>
        <option value="24">24인치</option><option value="27">27인치</option><option value="32">32인치</option><option value="49">49인치</option>
        </select></td></table>
       
    	<table class="sortitems_combobox"><td>해상도</td> <td><input type = "hidden" id="detail_3" name="detail_3" value="hae"> <select name="third"><option value="null" selected="selected">해상도</option>
    	<option value="FHD">FHD</option><option value="QHD">QHD</option><option value="DQHD">DQHD</option><option value="4K UHD">4K UHD</option>
    	</select></td></table> 
    	
    	<table class="sortitems_combobox"><td>화면 비율</td> <td><input type = "hidden" id="detail_4" name="detail_4" value="rate"> <select name="fourth"><option value="null" selected="selected">화면 비율</option>
    	<option value="와이드16:9">와이드16:9</option><option value="울트라 와이드(32:9)">울트라 와이드(32:9)</option>
    	</select></td></table>
    	
    	<table class="sortitems_combobox"><td>주사율</td> <td><input type = "hidden" id="detail_5" name="detail_5" value="hz"> <select name="fifth"><option value="null" selected="selected">주사율</option>
    	<option value="60Hz">60Hz</option><option value="75Hz">75Hz</option><option value="144Hz">144Hz</option><option value="240Hz">240Hz</option>
    	</select></td></table> 
                   
        <input type = "hidden" id="product" name="product" value="monitor">
        <input type = "hidden" id="product" name="productObject" value="monitor_t">
   	<%} %>
    
    
    
    
    <input type = "submit" name="page" value="estimate">
    	</form>
    	
    	
                   
        
           
    
    
    
    
    
    
    
    
    
    
    
    <div class="estimate">
        
<!------------------------------ ▼ 견적 카테고리 ▼ ------------------------------>
        <div class="estimate_category" id="cpu">
            <!----- 여기부터 ----->
            <% for(int i=0; i<model.size(); i++){ y=i; %>
            <a href="productSearchCon?productname=<%=model.get(i)%>&productid=<%=product%>" target="_blank"><div class="products"> <!-- href안에 상품페이지 주소로 연결되게-->
                <table width="580px">
                    <tr>
                        <td width="80px" height="80px" class="products_img">
                            <img src="Product\<%=product%>\<%=model.get(i)%>.jpg" width="80px">
                        </td>
                        <td align="left" >
                            <span class="products_class" id="products_id<%=i%>"><%=model.get(i) %></span><br>
                            <span class="products_spec"><%=context.get(i) %>

                                
                            </span>
                        </td>
                        <td align="right" class="products_price" rowspan="2"  width="100px">
                            <%=price.get(i) %>원
                        </td>
                        <td align="center" rowspan="2">
                                <button class="products_btn" name="gift" id="button">더담기</button>
                            </div>
                        </td>
                    </table>
                    </div></a><button class="products_btn" name="gift" id="button<%=y%>" onclick="button<%=y%>_click();">더담기</button>
            <!----- 여기까지 반복문 씌우면 됨 -----><%} %>
        </div>
<!------------------------------ ▲ 견적 카테고리 ▲ ------------------------------>        

<!------------------------------- ▼ 견적 리스트 ▼ ------------------------------->
        <div class="estimate_list">
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="cpu" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_1 == null){ %>
                    <td align="center"><span id="output_cpu">제품을 선택해주세요</span></td>
                    <%}else if (pro_1 != null){ %>
                     <td align="center"><span id="output_cpu"><%=pro_1%><button id="d_button_cpu" onclick="d_button_cpu_click();">삭제</button></span></td> <%} %>
                    
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="mother" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_2 == null){ %>
                    <td align="center"><span id="output_mother">제품을 선택해주세요</span></td>
                    <%}else if (pro_2 != null){ %>
                     <td align="center"><span id="output_mother"><%=pro_2%><button id="d_button_mother" onclick="d_button_mother_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="memory" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_3 == null){ %>
                    <td align="center"><span id="output_memory">제품을 선택해주세요</span></td>
                    <%}else if (pro_3 != null){ %>
                     <td align="center"><span id="output_memory"><%=pro_3%><button id="d_button_memory" onclick="d_button_memory_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="gpu" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_4 == null){ %>
                    <td align="center"><span id="output_gpu">제품을 선택해주세요</span></td>
                    <%}else if (pro_4 != null){ %>
                     <td align="center"><span id="output_gpu"><%=pro_4%><button id="d_button_gpu" onclick="d_button_gpu_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="power" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_5 == null){ %>
                    <td align="center"><span id="output_power">제품을 선택해주세요</span></td>
                    <%}else if (pro_5 != null){ %>
                     <td align="center"><span id="output_power"><%=pro_5%><button id="d_button_power" onclick="d_button_power_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="device" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_6 == null){ %>
                    <td align="center"><span id="output_device">제품을 선택해주세요</span></td>
                    <%}else if (pro_6 != null){ %>
                     <td align="center"><span id="output_device"><%=pro_6%><button id="d_button_device" onclick="d_button_device_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="cooler" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_7 == null){ %>
                    <td align="center"><span id="output_cooler">제품을 선택해주세요</span></td>
                    <%}else if (pro_7 != null){ %>
                     <td align="center"><span id="output_cooler"><%=pro_7%><button id="d_button_cooler" onclick="d_button_cooler_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="case" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_8 == null){ %>
                    <td align="center"><span id="output_case">제품을 선택해주세요</span></td>
                    <%}else if (pro_8 != null){ %>
                     <td align="center"><span id="output_case"><%=pro_8%><button id="d_button_case" onclick="d_button_case_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="keyboard" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_9 == null){ %>
                    <td align="center"><span id="output_keyboard">제품을 선택해주세요</span></td>
                    <%}else if (pro_9 != null){ %>
                     <td align="center"><span id="output_keyboard"><%=pro_9%><button id="d_button_keyboard" onclick="d_button_keyboard_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="mouse" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_10 == null){ %>
                    <td align="center"><span id="output_mouse">제품을 선택해주세요</span></td>
                    <%}else if (pro_10 != null){ %>
                     <td align="center"><span id="output_mouse"><%=pro_10%><button id="d_button_mouse" onclick="d_button_mouse_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                </tr>
            </table>
            </div>
            <div class="estimate_listsort">
            <table width="580px" border="1px">
                <tr>
                    <td align="center" width="80px" height="50px">
                        <form action ="estimateObject" method="post">
                            <input type="submit" value="monitor" name="product">
                            <input type="hidden" value="estimate" name="page">
                        </form>
                    </td>
                    <%if (pro_11 == null){ %>
                    <td align="center"><span id="output_monitor">제품을 선택해주세요</span></td>
                    <%}else if (pro_11 != null){ %>
                     <td align="center"><span id="output_monitor"><%=pro_11%><button id="d_button_monitor" onclick="d_button_monitor_click();">삭제</button></span></td><%} %>
                    <!-- 선택하면 이부분이 제품명으로 바뀌게 -->
                    <input type = "text" id="input">
                    <button onclick="ajaxCall()">evan</button>
                </tr>
            </table>
            </div>
        </div>
<!------------------------------- ▲ 견적 리스트 ▲ ------------------------------->
    </div>
</div>

<!------------------------- 스크립트 부분  ------------------------>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">



function d_button_cpu_click(){
	var output2 = document.getElementById("output_cpu");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_cpu"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });

	
}
function d_button_mother_click(){
	var output2 = document.getElementById("output_mother");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_mother"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	<% //session.removeAttribute("pro_mother");
		%>
	
}
function d_button_memory_click(){
	var output2 = document.getElementById("output_memory");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_memory"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	<% //session.removeAttribute("pro_memory");
		%>
	
}
function d_button_gpu_click(){
	var output2 = document.getElementById("output_gpu");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_gpu"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_power_click(){
	var output2 = document.getElementById("output_power");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_power"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_device_click(){
	var output2 = document.getElementById("output_device");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_device"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_cooler_click(){
	var output2 = document.getElementById("output_cooler");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_cooler"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_case_click(){
	var output2 = document.getElementById("output_case");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_case"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_keyboard_click(){
	var output2 = document.getElementById("output_keyboard");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_keyboard"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_mouse_click(){
	var output2 = document.getElementById("output_mouse");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_mouse"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}
function d_button_monitor_click(){
	var output2 = document.getElementById("output_monitor");
	output2.innerHTML = "제품을 선택해주세요";

	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":"d_monitor"},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
	
}




<%for(int i=0; i<=y; i++){%>


var inputs<%=i%> = document.getElementById("products_id<%=i%>").innerHTML;
var output = document.getElementById("output_<%=product%>");
var input<%=i%> =  document.getElementById("output_<%=product%>");
var value<%=i%> = document.getElementById(("output_<%=product%>").innerHTML);
var hey = "dada";




function button<%=i%>_click(){
	
	output.innerHTML = inputs<%=i%>;
	
<% if(product.equals("cpu")){	%>
var senestr = ['cpu',inputs<%=i%>];
	 $.ajax({
		 type : "post", //데이터 전송방식
		 data : {"id":senestr},//서버로 보내는 데이터
		 traditional : true,
		 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
		 dataType : "text",//서버에서 오는 응답방식
		 success: function(data){
			 //alert(data);
		 },
		 error  : function(){
			 alert("요청실패");
		 }
	 });
<%}%>
<% if(product.equals("mother")){%>
var senestr = ['mother',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("memory")){%>
var senestr = ['memory',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("gpu")){%>
var senestr = ['gpu',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("power")){%>
var senestr = ['power',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("device")){%>
var senestr = ['device',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("cooler")){%>
var senestr = ['cooler',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("case")){%>
var senestr = ['case',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("keyboard")){%>
var senestr = ['keyboard',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("mouse")){%>
var senestr = ['mouse',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
<% if(product.equals("monitor")){%>
var senestr = ['monitor',inputs<%=i%>];
$.ajax({
	 type : "post", //데이터 전송방식
	 data : {"id":senestr},//서버로 보내는 데이터
	 traditional : true,
	 url: "SpecialEstimate",//데이터를 전송할 서버 파일 이름
	 dataType : "text",//서버에서 오는 응답방식
	 success: function(data){
		 //alert(data);
	 },
	 error  : function(){
		 alert("요청실패");
	 }
});
<%}%>
}




<%}%>



	

//$.ajax({
   //	type : "post", //데이터 전송방식
  //  data : {"products_id1" : output}, //서버로 보내는 데이터
 //   url : "SpecialEstimate", //데이터를 전송할 서버 파일 이름
 //   dataType : "text", // 서버에서 오는 응답방식
//	 success: function(data){
//		 alert(data);
		 
		 
		 
//	 },
//	 error  : function(){
//		 alert("요청실패");
//	 }
//});
//}

</script>
    

</body>
</html>