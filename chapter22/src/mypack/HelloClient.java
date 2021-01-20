package mypack;   
import javax.xml.namespace.QName;  
import org.apache.axis2.AxisFault;  
import org.apache.axis2.addressing.EndpointReference;  
import org.apache.axis2.client.Options;  
import org.apache.axis2.rpc.client.RPCServiceClient;  

public class HelloClient {  
  public static void main(String args[]) throws AxisFault{  

    //ʹ��RPC��ʽ����SOAP����          
    RPCServiceClient serviceClient = new RPCServiceClient();  
    Options options = serviceClient.getOptions();  
    //ָ������HelloService��URL  
    EndpointReference targetEPR = new EndpointReference(  
             "http://localhost:8080/axis2/services/HelloService");  
    options.setTo(targetEPR);  

    //ָ��sayHello�����Ĳ���ֵ  
    Object[] parameters = new Object[] {"Tom"};  
    //ָ��sayHello��������ֵ���������͵�Class����  
    Class[] returnTypes = new Class[] {String.class};  
    //ָ��Ҫ���õ�sayHello������WSDL�ļ��������ռ�  
    QName methodEntry = new QName("http://mypack", "sayHello");  

    //����sayHello����������÷����ķ���ֵ  
    Object[] response =serviceClient.invokeBlocking(methodEntry, parameters, returnTypes);
    String result=(String)response[0];
    System.out.println(result);  
  }  
}  
