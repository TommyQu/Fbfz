<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<Html>
<Head>
<Title>用户注册</Title>
<Meta Http-Equiv="Pragma" Content="No-Cache">
<Meta Name="Copyright" Content="www.sccnn.com">
<Meta Name="Author" Content="WMaple">
<Meta Http-Equiv="Content-Type" Content="Text/Html; Charset=UTF-8">
</Head>
<BODY bgcolor="#00CCFF" text=#000000>
<DIV align=center>
  <table border="0" cellpadding="0" cellspacing="0" width="615">
    <tr> 
      <td bgcolor="#3399FF" height="6"></td>

    </tr>
    <tr> 
      <td rowspan="2" valign="top" bgcolor="#AEE6EC"> 
        
        <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr> 
            <td height="6"></td>
          </tr>
          <tr> 
            <td><b>[ 会员注册 ]</b></td>
          </tr>

          <tr> 
            <td height="1" align="center" bgcolor="#666666"> </td>
          </tr>
          <tr> 
            <td height="1" align="center" bgcolor="#FFFFFF"></td>
          </tr>
        </table>
        <TABLE cellSpacing=0 cellPadding=0 width=100% border=0>
          <TBODY> 
          <TR> 
            <TD width=260 height=247 align="right" vAlign=top> 
              <table width="92%" border="0" cellspacing="0" cellpadding="0">

                <tr> 
                  <td align="right">&nbsp; </td>
                </tr>
              </table>
              <textarea cols=36 name=Agreement rows=21 style="FONT-SIZE: 9pt">　　　　　　 服 务 条 款
1、本网站享有所有条款内容的解释权及修改权.
2、会员须遵守《国际互联网安全信息管理条例》，对违反本规定而产生的一切后果承担相应责任。
3、所有注册用户，应妥善保管用户名称及密码。如果出现密码被盗现象请用密码保护找回，因此填写的密码保护资料一定牢记。
4、"吃喝玩乐在福州"网络管理中心，依法保障每一位会员的个人隐私权，对只属本网络管理中心的个人信息绝不向第三方公开。
5、以上条款完全忠实于国家现行法律法规，如遇抵触，皆以法律条款为准。
</textarea>
            </TD>
            <TD height=247 valign="top" width="356"> 
              <table width="100%" border="0" cellspacing="8" cellpadding="2">
                <tr> 
                  <td valign="top"> 
                    <table width="100%" border="0" cellspacing="4">
                      <form action="<%=request.getContextPath()%>/frontusermember!register.action" method="post">
                        <tr> 
                          <td width="29%" align="right" valign="top" bgcolor="#AEE6EC">用户名：&nbsp;</td>
                          <td width="71%"> 
                            <input name="username" type='text' class="input1" size="16" maxlength='12' >
                            <font color=#ff0000>*</font> <font color=#ff0000>&nbsp; 
                            </font><br>
                            　必填,且必须是英文字母或数字,长度3-15 </td>
                        </tr>

                        <tr> 
                          <td align="right" valign="top" bgcolor="#AEE6EC">密码：&nbsp;</td>
                          <td> 
                            <input type='password' class="input1" name="password" maxlength='15'>
                            <font color=#ff0000>*<br>
                            </font>必填,且长度3-15 </td>
                        </tr>
			
                        <tr> 
                          <td align="right" valign="top" bgcolor="#AEE6EC">确认密码：&nbsp;</td>
                          <td> 
                            <input type='password' class="input1" name="checkpassword" maxlength='15'>
                            <font color=#ff0000>*</font><br>值要和密码框的值相同</td>
                        </tr>

			<tr> 
                          <td width="29%" align="right" valign="top" bgcolor="#AEE6EC">性别：&nbsp;</td>
                          <td width="71%"> 
			    <input name="usersex" type="radio" value="1" checked="checked"/>男
			    <input name="usersex" type="radio" value="2"/>女
                            <font color=#ff0000>*</font> <font color=#ff0000>&nbsp; 
                            </font><br>
                          	 </td>
                        </tr>

                        <tr> 
                          <td align="right" valign="top" bgcolor="#AEE6EC">电子邮箱：&nbsp;</td>
                          <td> 
                            <input name='email' type='text' class="input1" maxlength='20'>

                            <font color=#ff0000>*</font><br>必填, 且格式要正确</td>
                        </tr>

                        <tr> 
                          <td align="right" valign="top" bgcolor="#AEE6EC">QQ号码：&nbsp;</td>
                          <td> 
                            <input type='text' class="input1" name="qq" value="">
                            <font color=#ff0000>* 
                           
                            </font><br>必填, 且是数字</td>
                        </tr>

			<tr> 
                          <td align="right" valign="top" bgcolor="#AEE6EC">手机号码：&nbsp;</td>
                          <td> 
                            <input type='text' class="input1" name="mobileno" value="" maxlength='11'>
                            <font color=#ff0000>* 
                          
                            </font><br>必填, 且是数字</td>
                        </tr>

                        <tr align="center" valign="bottom"> 
                          <td height="42" colspan="2"> 
                            <input  type="submit" value="注册" width="67" height="31" border="0">
                            &nbsp;&nbsp;&nbsp;&nbsp; 
                            <input type="reset" value="重填" width="67" height="31" border="0">
                          </td>
                        </tr>
                      </form>
                    </table>

                  </td>
                </tr>
              </table>
            </TD>
          </TR>
          <s:actionMessage/>
          <TR align="center"> 
            <TD colSpan=2> 
              <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0" >
                <tr> 
                  <td align="center"><font color="#333333">如果你不同意以上条款，请离开本站！<br>

                    如果你同意以上条款，请输入注册信息，并牢记你的用户名和密码，*为必填项！</font> </td>
                </tr>
              </table>
              <br>
            </TD>
          </TR>
          </TBODY> 
        </TABLE>

      </td>
    </tr>
    <tr> </tr>
    <tr> 
      <td bgcolor="#3399FF">&nbsp;</td>
    </tr>
  </table>
</DIV>
</BODY>
</HTML>