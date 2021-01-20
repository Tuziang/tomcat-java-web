package mypack;
import javax.xml.namespace.QName;  
import org.apache.axis2.AxisFault;  
import org.apache.axis2.addressing.EndpointReference;  
import org.apache.axis2.client.Options;  
import org.apache.axis2.rpc.client.RPCServiceClient;  
import java.util.*;

public class BookDBDelegate {
  RPCServiceClient serviceClient;
  final String namespace="http://mypack";

  public BookDBDelegate() throws Exception{
     //ʹ��RPC��ʽ����WebService          
     serviceClient = new RPCServiceClient();  
     Options options = serviceClient.getOptions();  
     //ָ������WebService��URL  
     EndpointReference targetEPR = new EndpointReference(  
             "http://localhost:8080/axis2/services/BookDBService");  
     options.setTo(targetEPR);    
  }

  public int getNumberOfBooks() throws Exception {

    Object[] parameters = new Object[]{};  
    Class[] returnTypes = new Class[] {Integer.class};  
    QName methodEntry = new QName(namespace, "getNumberOfBooks");  

    Object[] response =serviceClient.invokeBlocking(methodEntry, parameters, returnTypes);
    Integer result=(Integer)response[0];
    return result.intValue();
  }

  public Collection getBooks()throws Exception{
    Object[] parameters = new Object[]{};  
    Class[] returnTypes = new Class[] {BookDetails[].class};  
    QName methodEntry = new QName(namespace, "getBooks");  

    Object[] response =serviceClient.invokeBlocking(methodEntry, parameters, returnTypes);
    BookDetails[] result = (BookDetails[])response[0];  
 
    ArrayList<BookDetails> list=new ArrayList<BookDetails>();
    for(int i=0;i<result.length;i++)
      list.add(result[i]);
    return list;
  }

  public BookDetails getBookDetails(String bookId) throws Exception {
    Object[] parameters = new Object[]{bookId};  
    Class[] returnTypes = new Class[]{BookDetails.class};  
    QName methodEntry = new QName(namespace, "getBookDetails");  

    Object[] response =serviceClient.invokeBlocking(methodEntry, parameters, returnTypes);
    BookDetails result = (BookDetails)response[0];  

    return result;
  }

  public void buyBooks(ShoppingCart cart)throws Exception {
    //�Ѵ��ShoppingCartItem��collection����ת��Ϊitems���飬Ȼ������Ϊ����������Զ�̷��񷽷�
    Collection collection = cart.getItems();
    ShoppingCartItem[] items=new ShoppingCartItem[collection.size()];
    Iterator it =collection.iterator();
    int i=0;
    while (it.hasNext()) 
      items[i++]=(ShoppingCartItem)it.next();

    Object[] parameters = new Object[]{items};  
    QName methodEntry = new QName(namespace, "buyBooks");  

    serviceClient.invokeBlocking(methodEntry, parameters);
 
  }

}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
