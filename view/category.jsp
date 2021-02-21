<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
    
        body{
        margin:auto;
        }
        a:link{ text-decoration:none;} 
        a:visited{ text-decoration:none;} 
        a:active{ text-decoration:none;} 
        a:hover{ text-decoration:none;} 
        
        @font-face {
		font-family: 'NanumSquareB';
		src: url("fonts/NanumSquareB.ttf") format('truetype'); 
        }
        
        .category_menu{
            margin-top:20px;
            width:1200px;
        }
        .img{
            width:180px;
            height:180px;
        }
        .img:hover > .nametag{
            color:orange;
            transition: all 0.3s;
            
        }
        .nametag{
            font-family: 'NanumSquareB';
            position:relative;
            bottom:36px;
            height:33px;
            background-color:#3F3F3F;
            color:white;
            font-size:18px;
            line-height:33px;
        }
        .nametag span{
            margin-top:50px;
        }
        
        .sortitems{
            margin-top:20px;
            width:1200px;
            background-color:black;
            color:white;
            border-bottom: 2px solid #999999;
            display: flex;
        }

        .products{
            margin:auto;
            margin-top:30px;
            width:1200px;
            border-bottom: 1px solid #999999;
        }
        .products_id{
            font-family: 'NanumSquareB';
            font-size:18px;
            color:black;
        }
        .products_spec{
            font-size:11px;
            color:#999999;
        }
        .products_price{
            font-family: 'NanumSquareB';
            font-size:18px;
            color:black;
        }
        .btn{
            width:120px;
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
        .btn:hover{
            background-color: #EB0000;
            color: #FFFFFF;
            transition: all 1.1s;
        }
        
        .products:hover{
            background:#F1F1F1;
            transition: all 0.3s;
        }
        
    </style>
    <title>Document</title>
</head>
<%
response.setCharacterEncoding("utf-8"); // �ѱ� ó��
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=UTF-8"); 
ArrayList model = (ArrayList)request.getAttribute("model");
ArrayList price = (ArrayList)request.getAttribute("price");
ArrayList context = (ArrayList)request.getAttribute("context");
Object product = request.getAttribute("product");
%>
<body>
    
    
    
<!------------------------------ �� ��� ���� ��� �� ------------------------------>
<div id="headers"></div>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">   
$(document).ready( function() {

$("#headers").load("Header.html");
});
</script>
<!------------------------------ �� ��� ���� ��� �� ------------------------------>

    
    
    
    
    
<div class="section" align="center">
    
<!------------------------------ �� ī�װ� �޴� �� ------------------------------>
    <!-- ���� �ڹ� �ǵ帱 �κ��� ���� ���� ��ũ�� �޾��ְ� ���� ����-->
    <div class=category_menu>
        <table >
            <tr>
                <td>
                    <a href=categoryCon?product=cpu> <!-- CPU ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_cpu.png"> 
                        <div class="nametag" align="center">CPU</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=mother> <!-- ���κ��� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_mainboard.png"> 
                        <div class="nametag" align="center">���κ���</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=memory> <!-- �޸� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_ram.png"> 
                        <div class="nametag" align="center">�޸�</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=gpu> <!-- �׷���ī�� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_gpu.png"> 
                        <div class="nametag" align="center">�׷���ī��</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=power> <!-- PSU ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_psu.png"> 
                        <div class="nametag" align="center">�Ŀ�</div>
                    </div>
                    </a>
                </td>
            </tr>
            <tr>
                <td>
                    <a href=categoryCon?product=cooler> <!-- �� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_cooler.png"> 
                        <div class="nametag" align="center">��</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=case> <!-- ���̽� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_case.png"> 
                        <div class="nametag" align="center">���̽�</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=mouse> <!-- ���콺 ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_mouse.png"> 
                        <div class="nametag" align="center">���콺</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=keyboard> <!-- Ű���� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_keyboard.png"> 
                        <div class="nametag" align="center">Ű����</div>
                    </div>
                    </a>
                </td>
                <td>
                    <a href=categoryCon?product=monitor> <!-- ����� ī�װ��� �̵��ϰ� ����-->
                    <div class="img">
                        <img class="img" src="images/menu_monitor.png"> 
                        <div class="nametag" align="center">�����</div>
                    </div>
                    </a>
                </td>
            </tr>
        </table>
    
    </div>
<!------------------------------ �� ī�װ� �޴� �� ------------------------------>
    


    <div class="sort-items">
       <a href="��������">��������</a>
        <a href="��������">��������</a>
          <input type="text" name="return" id="money" value="��"> ~
			<input type="text" name="return" id="money" value="��">
			 <input type="button" name="return" id="search" value="�˻�">
	        	<select name="count">
	    <option value="">���ú���</option>
	    <option value="10">10��</option>
	    <option value="20">20��</option>
	    <option value="30">30��</option>
	    <option value="40">40��</option>
	</select>
    </div>
     <form action = "estimateObject">
    <div id="selectbox-wrap">
    <input type="hidden" id ="page" name="page" value="category">
    
    <%if (product.equals("cpu")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="core">
	<input type="hidden" id ="detail_3" name="detail_3" value="socket">
	<input type="hidden" id ="detail_4" name="detail_4" value="socket">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>CPU ������</span>   
				<select name="first"><option value="null" selected="selected">CPU ������ ����</option>
				<option value="intel">����</option><option value="amd">�ϵ�</option>
                </select>
  
                <span>�ھ� ��</span>
                <select name="second">
					<option value="null" selected="selected">�ھ� ����</option>
					<option value="8">8�ھ�</option><option value="4">4�ھ�</option><option value="16">16�ھ�</option>
                </select>

                <span>Intel ����</span>
                <select name="third">
  					<option value="null" selected="selected">���� ���� ����</option>
      				<option value="1151v2">1151</option><option value="1150">1150</option><option value="775">775</option>
                </select>
	
                <span>AMD ����</span>
                <select name="fourth">
					<option value="null" selected="selected">AMD ���ϱ���</option>
        			<option value="AM4">am4</option><option value="AM3">am3</option><option value="AM2">am2</option>
                </select>
                
      			<input type = "hidden" id="product" name="product" value="cpu">
        		<input type = "hidden" id="product" name="productObject" value="cpu_t">
    <%} %>
    <%if (product.equals("mother")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="c_company">
	<input type="hidden" id ="detail_2" name="detail_2" value="company">
	<input type="hidden" id ="detail_3" name="detail_3" value="chipset">
	<input type="hidden" id ="detail_4" name="detail_4" value="socket">
	<input type="hidden" id ="detail_5" name="detail_5" value="form">
	
                <span>Ĩ�� ������</span>   
				<select name="first">
					<option value="null" selected="selected">Ĩ�� ������ ����</option>
					<option value="Intel">����</option><option value="AMD">AMD</option>
                </select>
  
                <span>���κ��� ������</span>
                <select name="second">
					<option value="null" selected="selected">���κ��� ������ ����</option>
					<option value="GIGABYTE">�Ⱑ����Ʈ</option><option value="ASUS">ASUS</option><option value="MSI">MSI</option><option value="Asrock">Asrock</option><option value="BIOSTAR">BIOSTAR</option>
                </select>

                <span>���κ��� Ĩ��</span>
                <select name="third">
  					<option value="null" selected="selected">Ĩ�� ����</option>
      				<option value="H310">(����)H310</option><option value="B360">(����)B360</option><option value="B365">(����)B365</option><option value="H110">(����)H110</option><option value="H410">(����)H410</option><option value="B460">(����)B460</option><option value="H470">(����)H470</option><option value="Z490">(����)Z490</option><option value="A320">(AMD)A320</option><option value="B450">(AMD)B450</option><option value="A520">(AMD)A520</option><option value="B550">(AMD)B550</option><option value="X570">(AMD)X570</option>
                </select>
	
                <span>����</span>
                <select name="fourth">
					<option value="null" selected="selected">���� ����</option>
        			<option value="1151v2">(����)1151v2</option><option value="1151">(����)1151</option><option value="1200">(����)1200</option><option value="3647">(����)3647</option><option value="AM4">(AMD)AM4</option><option value="TR4">(AMD)TR4</option><option value="sTRX4">(AMD)sTRX4</option>
                </select>
                
                <span>������</span>
                <select name="fifth">
					<option value="null" selected="selected">������ ����</option>
        			<option value="M-ATX">M-ATX</option><option value="ATX">ATX</option><option value="M-ITX">M-ITX</option><option value="E-ATX">E-ATX</option>
                </select>
               
               
      			<input type = "hidden" id="product" name="product" value="mother">
        		<input type = "hidden" id="product" name="productObject" value="mainboard_t">
    <%} %>
     
        <%if (product.equals("memory")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="type">
	<input type="hidden" id ="detail_3" name="detail_3" value="mem">
	<input type="hidden" id ="detail_4" name="detail_4" value="clock">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="�Ｚ����">�Ｚ����</option><option value="����ũ��">����ũ��</option><option value="TeamGroup">TeamGroup</option><option value="Ÿ����">Ÿ����</option><option value="GeIL">GeIL</option><option value="GIGABYTE">�Ⱑ����Ʈ</option><option value="ADATA">ADATA</option><option value="HP">HP</option>
                </select>
  
                <span>�޸� Ÿ��</span>
                <select name="second">
					<option value="null" selected="selected">�޸� Ÿ�� ����</option>
					<option value="DDR4">DDR4</option><option value="DDR3">DDR3</option>
                </select>

                <span>�뷮</span>
                <select name="third">
  					<option value="null" selected="selected">�޸� �뷮 ����</option>
      				<option value="8GB">8GB</option><option value="16GB">16GB</option><option value="32GB">32GB</option>
                </select>
	
                <span>Ŭ��</span>
                <select name="fourth">
					<option value="null" selected="selected">�޸� Ŭ�� ����</option>
        			<option value="1600MHz">1600MHz</option><option value="2133MHz">2133MHz</option><option value="2666MHz">2666MHz</option><option value="2933MHz">2933MHz</option><option value="3200MHz">3200MHz</option><option value="3600MHz">3600MHz</option>
                </select>
                <input type = "hidden" id="detail_5" name="fifth" value="null">
      			<input type = "hidden" id="product" name="product" value="memory">
        		<input type = "hidden" id="product" name="productObject" value="memory_t">
    <%} %>
        <%if (product.equals("gpu")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="chip_com">
	<input type="hidden" id ="detail_2" name="detail_2" value="company">
	<input type="hidden" id ="detail_3" name="detail_3" value="chipname">
	<input type="hidden" id ="detail_4" name="detail_4" value="mem">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>Ĩ�� ������</span>   
				<select name="first">
					<option value="null" selected="selected">Ĩ�� ������ ����</option>
					<option value="NVIDIA">NVIDIA</option><option value="AMD">AMD</option>
                </select>
  
                <span>������</span>
                <select name="second">
					<option value="null" selected="selected">�׷��� ī�� ������ ����</option>
					<option value="GIGABYTE">�Ⱑ����Ʈ</option><option value="ASUS">ASUS</option><option value="MSI">MSI</option><option value="�̿���">�̿���</option><option value="������">������</option><option value="ZOTAC">ZOTAC</option><option value="SAPPHIRE">�����̾�</option><option value="COLORFUL">COLORFUL</option>
                </select>

                <span>Ĩ�� ��</span>
                <select name="third">
  					<option value="null" selected="selected">Ĩ�� ����</option>
      				<option value="GTX1650">GTX1650</option><option value="GTX1660">GTX1660</option><option value="RTX2060">RTX2060</option><option value="RTX2070">RTX2070</option><option value="RTX2080">RTX2080</option><option value="RTX3060TI">RTX3060TI</option><option value="RTX3080">RTX3080</option><option value="RTX3090">RTX3090</option><option value="RX5500">RX5500</option><option value="RX5600">(AMD)RX5600</option><option value="RX5700">RX5700</option><option value="RX6800">RX6800</option><option value="RX6900">RX6900</option>
                </select>
	
                <span>�޸� �뷮</span>
                <select name="fourth">
					<option value="null" selected="selected">�޸� �뷮</option>
        			 <option value="4GB">4GB</option><option value="6GB">6GB</option><option value="8GB">8GB</option><option value="10GB">10GB</option><option value="11GB">11GB</option><option value="16GB">16GB</option><option value="24GB">24GB</option>
                </select>
                <input type = "hidden" id="detail_5" name="fifth" value="null">
      			<input type = "hidden" id="product" name="product" value="gpu">
        		<input type = "hidden" id="product" name="productObject" value="gpu_t">
    <%} %>
        <%if (product.equals("power")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="form">
	<input type="hidden" id ="detail_3" name="detail_3" value="output">
	<input type="hidden" id ="detail_4" name="detail_4" value="authen">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="ABKO">ABKO</option><option value="Antec">Antec</option><option value="CORSAIR">CORSAIR</option><option value="EVGA">EVGA</option><option value="FSP">FSP</option><option value="SuperFlower">SuperFlower</option><option value="����ũ�δн�">����ũ�δн�</option><option value="�üҴ�">�üҴ�</option><option value="���ʸƽ�">���ʸƽ�</option><option value="�߸�">�߸�</option><option value="�𷯸�����">�𷯸�����</option>
                </select>
  
                <span>������</span>
                <select name="second">
					<option value="null" selected="selected">������ ����</option>
					<option value="ATX">ATX</option><option value="M-ATX">M-ATX</option><option value="TFX">TFX</option>
                </select>

                <span>���� ���</span>
                <select name="third">
  					<option value="null" selected="selected">���� ���</option>
      				<option value="500W">500W</option><option value="600W">600W</option><option value="650W">650W</option><option value="700W">700W</option><option value="750W">750W</option><option value="850W">850W</option><option value="1000W">1000W</option><option value="1050W">1050W</option><option value="1200W">1200W</option><option value="1300W">1300W</option>
                </select>
	
                <span>����</span>
                <select name="fourth">
					<option value="null" selected="selected">80+����</option>
        			<option value="80+Standard">80+ Standard</option><option value="80+Bronze">80+ Bronze</option><option value="80+Silver">80+ Silver</option><option value="80+Gold">80+ Gold</option><option value="80+Platinum">80+ Platinum</option><option value="80+Titaninum">80+ Titanium</option>
                </select>
               
      			<input type = "hidden" id="product" name="product" value="power">
        		<input type = "hidden" id="product" name="productObject" value="power_t">
    <%} %>
        <%if (product.equals("device")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="form">
	<input type="hidden" id ="detail_3" name="detail_3" value="interface">
	<input type="hidden" id ="detail_4" name="detail_4" value="mem">
	<input type="hidden" id ="detail_4" name="detail_5" value="type">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="Seagate">Seagate</option><option value="Wastern Deigital">WD</option><option value="Toshiba">Toshiba</option><option value="�Ｚ����">�Ｚ����</option><option value="����ũ��">����ũ��</option><option value="ADATA">ADATA</option><option value="Ÿ����">Ÿ����</option><option value="SK ���̴н�">SK ���̴н�</option>
                </select>
  
                <span>������</span>
                <select name="second">
					<option value="null" selected="selected">������ ����</option>
					<option value="3.5��ġ">3.5��ġ</option><option value="2.5��">2.5��</option><option value="M.2(2280)">M.2(2280)</option>
                </select>

                <span>�������̽�</span>
                <select name="third">
  					<option value="null" selected="selected">�������̽�</option>
      				<option value="SATA3">SATA3</option><option value="PCIe3.0x4">PCIe3.0x4</option><option value="PCIe4.0x4">PCIe4.0x4</option>
                </select>
	
                <span>�뷮</span>
                <select name="fourth">
					<option value="null" selected="selected">�뷮</option>
        			<option value="480GB">480GB</option><option value="500GB">500GB</option><option value="512GB">512GB</option><option value="1TB">1TB</option><option value="2TB">2TB</option><option value="3TB">3TB</option><option value="4TB">4TB</option><option value="8TB">8TB</option><option value="10TB">10TB</option>
                </select>
                
                <span>�޸� Ÿ��</span>
                <select name="fourth">
					<option value="null" selected="selected">�޸� Ÿ��</option>
        			<option value="CMR">CMR</option><option value="PMR">PMR</option><option value="SMR">SMR</option><option value="MTC">MTC</option><option value="MLC">MLC</option><option value="TLC">TLC</option>
                </select>
               
      			<input type = "hidden" id="product" name="product" value="device">
        		<input type = "hidden" id="product" name="productObject" value="device_t">
    <%} %>
        <%if (product.equals("cooler")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="ice">
	<input type="hidden" id ="detail_3" name="detail_3" value="fan_size">
	<input type="hidden" id ="detail_4" name="detail_4" value="tdp">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="ABKO">ABKO</option><option value="ALSYE">ALSYE</option><option value="darkFlash">DarkFlash</option><option value="DEEPCOOL">DEEPCOOL</option><option value="3RSYS">3RSYS</option><option value="NZXT">NZXT</option><option value="JONSBO">JONSBO</option><option value="����ũ�δн�">����ũ�δн�</option><option value="���ʸƽ�">���ʸƽ�</option><option value="��Ƽ����ũ">��Ƽ����ũ</option><option value="�߸�">�߸�</option><option value="�𷯸�����">�𷯸�����</option>
                </select>
  
                <span>�ð����</span>
                <select name="second">
					<option value="null" selected="selected">�ð� ���</option>
					<option value="����">����</option><option value="����">����</option>
                </select>

                <span>�� ũ��</span>
                <select name="third">
  					<option value="null" selected="selected">�� ũ��</option>
      				<option value="92mm">92mm</option><option value="120mm">120mm</option><option value="140mm">140mm</option>
                </select>
	
                <span>TDP</span>
                <select name="fourth">
					<option value="null" selected="selected">�뷮</option>
        			<option value="130W">130W</option><option value="150W">150W</option><option value="180W">180W</option><option value="195W">195W</option><option value="200W">200W</option><option value="230W">230W</option><option value="280W">280W</option><option value="360W">360W</option>
                </select>
                
      			<input type = "hidden" id="product" name="product" value="cooler">
        		<input type = "hidden" id="product" name="productObject" value="cooler_t">
    <%} %>
        <%if (product.equals("case")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="sized">
	<input type="hidden" id ="detail_3" name="detail_3" value="max">
	<input type="hidden" id ="detail_4" name="fourth" value="null">
    <input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="3RSYS">3RSYS</option><option value="ABKO">ABKO</option><option value="BRAVOTEC">BRAVOTEC</option><option value="CORSAIR">CORSAIR</option><option value="DAVEN">DAVEN</option><option value="MSI">MSI</option><option value="NZXT">NZXT</option><option value="OPBIS">OPBIS</option><option value="���ȸ�">���ȸ�</option><option value="����ũ�δн�">����ũ�δн�</option><option value="�������ũ">�������ũ</option><option value="���̱���">���̱���</option><option value="�߸�">�߸�</option>
                </select>
  
                <span>���̽� ũ��</span>
                <select name="second">
					<option value="null" selected="selected">���̽� ũ��</option>
					<option value="�̴�Ÿ��">�̴�Ÿ��</option><option value="�̵�Ÿ��">�̵�Ÿ��</option><option value="��Ÿ��">��Ÿ��</option>
                </select>

                <span>������</span>
                <select name="third">
  					<option value="null" selected="selected">������</option>
      				<option value="M-ITX">M-ITX</option><option value="M-ATX">M-ATX</option><option value="ATX">ATX</option><option value="E-ATX">E-ATX</option>
                </select>
	

      			<input type = "hidden" id="product" name="product" value="case">
        		<input type = "hidden" id="product" name="productObject" value="case_t">
    <%} %>
        <%if (product.equals("keyboard")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="conn">
	<input type="hidden" id ="detail_3" name="detail_3" value="select_s">
	<input type="hidden" id ="detail_4" name="detail_4" value="switch">
	<input type="hidden" id ="detail_5" name="detail_5" value="array">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="ABKO">ABKO</option><option value="CHERRY">CHERRY</option><option value="COX">COX</option><option value="VARMILO">VARMILO</option><option value="������">������</option><option value="����ũ�δн�">����ũ�δн�</option><option value="�Ѽ���ǻ��">�Ѽ���ǻ��</option>
                </select>
  
                <span>���� ���</span>
                <select name="second">
					<option value="null" selected="selected">���� ���</option>
					 <option value="����">����</option><option value="����">����</option>
                </select>

                <span>���� ���</span>
                <select name="third">
  					<option value="null" selected="selected">���� ���</option>
      				<option value="��극��">��극��</option><option value="��Ÿ�׷���">��Ÿ�׷���</option><option value="������(����)">������(����)</option><option value="����">����</option>
                </select>
	
                <span>����ġ</span>
                <select name="fourth">
					<option value="null" selected="selected">����ġ</option>
        			<option value="û��">û��</option><option value="����">����</option><option value="������ ����">������ ����</option><option value="����">����</option><option value="Ȳ��">Ȳ��</option>
                </select>
                
                <span>Ű �迭</span>
                <select name="fifth">
					<option value="null" selected="selected">Ű �迭</option>
        			<option value="87Ű">87Ű</option><option value="104Ű">104Ű</option><option value="108Ű">108Ű</option><option value="109Ű">109Ű</option>
                </select>
                
                
      			<input type = "hidden" id="product" name="product" value="keyboard">
        		<input type = "hidden" id="product" name="productObject" value="keyboard_t">
    <%} %>
        <%if (product.equals("mouse")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="conn">
	<input type="hidden" id ="detail_3" name="detail_3" value="feel">
	<input type="hidden" id="detail_4" name="fourth" value="null">
	<input type="hidden" id="detail_5" name="fifth" value="null">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="ABKO">ABKO</option><option value="COX">COX</option><option value="MAXTILL">MAXTILL</option><option value="������">������</option>
                </select>
  
                <span>������</span>
                <select name="second">
					<option value="null" selected="selected">���� ���</option>
					<option value="����">����</option><option value="����">����</option><option value="����+����">����+����</option><option value="����+�������">����+�������</option>
                </select>

                <span>����</span>
                <select name="third">
  					<option value="null" selected="selected">����</option>
      				<option value="4000">4000 DPI</option><option value="5600">5600 DPI</option><option value="8000">8000 DPI</option><option value="12000">12000 DPI</option><option value="16000">16000 DPI</option><option value="25600">25600 DPI</option>
                </select>

      			<input type = "hidden" id="product" name="product" value="mouse">
        		<input type = "hidden" id="product" name="productObject" value="mouse_t">
    <%} %>
    <%if (product.equals("monitor")){ %>
	<input type="hidden" id ="detail_1" name="detail_1" value="company">
	<input type="hidden" id ="detail_2" name="detail_2" value="inchi">
	<input type="hidden" id ="detail_3" name="detail_3" value="hae">
	<input type="hidden" id ="detail_4" name="detail_4" value="rate">
	<input type="hidden" id ="detail_5" name="detail_5" value="hz">
	
                <span>������</span>   
				<select name="first">
					<option value="null" selected="selected">������ ����</option>
					<option value="�Ｚ����">�Ｚ����</option><option value="LG����">LG����</option><option value="���Ľ�ĵ">���Ľ�ĵ</option><option value="�Ѽ���ǻ��">�Ѽ���ǻ��</option>
                </select>
  
                <span>ȭ�� ũ��</span>
                <select name="second">
					<option value="null" selected="selected">ȭ�� ũ��</option>
					<option value="24">24��ġ</option><option value="27">27��ġ</option><option value="32">32��ġ</option><option value="49">49��ġ</option>
                </select>

                <span>�ػ�</span>
                <select name="third">
  					<option value="null" selected="selected">�ػ�</option>
      				<option value="FHD">FHD</option><option value="QHD">QHD</option><option value="DQHD">DQHD</option><option value="4K UHD">4K UHD</option>
                </select>
	
                <span>ȭ�� ����</span>
                <select name="fourth">
					<option value="null" selected="selected">ȭ�� ����</option>
        			<option value="���̵�16:9">���̵�16:9</option><option value="��Ʈ�� ���̵�(32:9)">��Ʈ�� ���̵�(32:9)</option>
                </select>
                <span>�ֻ���</span>
                <select name="fifth">
					<option value="null" selected="selected">�ֻ���</option>
        			<option value="60Hz">60Hz</option><option value="75Hz">75Hz</option><option value="144Hz">144Hz</option><option value="240Hz">240Hz</option>
                </select>
                
      			<input type = "hidden" id="product" name="product" value="monitor">
        		<input type = "hidden" id="product" name="productObject" value="monitor_t">
    <%} %>
                
        
                <input type="submit">
               
        </div>
    </div>
     </form> 

<!------------------------------ �� ��ǰ ��� ĭ �� ------------------------------>
	<%for(int i=0; i<model.size(); i++){ %>
	<a href="productSearchCon?productname=<%=model.get(i)%>&productid=<%=product%>"target="_blank"><div class="products">
    <table width="1200px" >
    
    <tr>
        <td width="120px" height="120px" class="products_img">
            <img src="Product\<%=product%>\<%=model.get(i)%>.jpg" width="120px">
        </td>
        <td align="left" width="500px">
            <span class="products_id"><%=model.get(i) %></span><br>
            <span class="products_spec"><%=context.get(i) %>
            </span>
        </td>
        <td align="right" class="products_price" rowspan="2" width="350px">
	       <%=price.get(i)%>��
        </td>
        <td width="30px"></td>
        <td align="center" class="products_btn" rowspan="2">
            <div class="btngroup">
                <button class="btn" name="gift" id="button">���ɻ�ǰ</button><br>
                <button class="btn" name="basket" id="button">��ٱ���</button><br>
                <button class="btn" name="buy" id="button">�ٷα���</button>
            </div>

        </td>

          
    </table> 
    </div></a><%} %>
<!------------------------------ �� ��ǰ ��� ĭ �� ------------------------------>


    
    
    
</div>

    

</body>
</html>