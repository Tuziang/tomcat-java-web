<%@ page contentType="text/html; charset=GB2312" %>
<%
//��ҳ��������
final int e=3;            //ÿҳ��ʾ�ļ�¼��
int totalPages=0;         //ҳ������
int currentPage=1;        //��ǰҳ����
int totalCount=0;         //���ݿ������ݵ��ܼ�¼��
int p=1;                  //��ǰҳ������ʾ�ĵ�һ����¼���α�

//��ȡ��ǰ����ʾ��ҳ����
String tempStr=request.getParameter("currentPage");
if(tempStr!=null && !tempStr.equals(""))
  currentPage=Integer.parseInt(tempStr);

/* ��ҳԤ�� */

String sql="select ID,NAME,TITLE,PRICE from BOOKS order by ID";
rs=stmt.executeQuery(sql);

rs.last(); //���α궨λ�����һ����¼
totalCount=rs.getRow(); //�����ܼ�¼��

//�����ܵ�ҳ��
totalPages=((totalCount%e==0)?(totalCount/e):(totalCount/e+1));
if(totalPages==0) totalPages=1;

//������ǰҳ���ţ�ȷ����1<=currentPage<=totalPages
if(currentPage>totalPages) 
  currentPage=totalPages;
else if(currentPage<1) 
  currentPage=1;

//���㵱ǰҳ������ʾ�ĵ�һ����¼�ڽ�����е��α�
p=(currentPage-1)*e+1;

rs.absolute(p);//���α궨λ����P����¼

%>

<%-- ��ʾҳ��ǩ --%>
ҳ�룺
<% for(int i=1;i<=totalPages;i++){
     if(i==currentPage){ 
%>
       <%=i%>
<%   }else{ %>
       <a href="dbaccess3.jsp?currentPage=<%=i%>"><%=i %></a>
<%   } %>

<% } %>

&nbsp; ��<%=totalPages%>ҳ,��<%=totalCount%>����¼


<table border="1" width=400>

<tr>
<td bgcolor="#D8E4F1"><b>����</b></td>
<td bgcolor="#D8E4F1"><b>����</b></td>
<td bgcolor="#D8E4F1"><b>����</b></td>
<td bgcolor="#D8E4F1"><b>�۸�</b></td>
</tr>

<%
int count=0;
do{
  String id=rs.getString(1);
  String name=rs.getString(2);
  String title=rs.getString(3);
  float price=rs.getFloat(4);
%>

<tr>
<td><%=id %></td>
<td><%=name %></td>
<td><%=title %></td>
<td><%=price %></td>
</tr>

<% 
}while(rs.next() && ++count<e); //#while 
%> 

</table>


