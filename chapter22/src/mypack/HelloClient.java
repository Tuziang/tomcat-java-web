package mypack;   
import javax.xml.namespace.QName;  
import org.apache.axis2.AxisFault;  
import org.apache.axis2.addressing.EndpointReference;  
import org.apache.axis2.client.Options;  
import org.apache.axis2.rpc.client.RPCServiceClient;  

public class HelloClient {  
  public static void main(String args[]) throws AxisFault{  

    //使用RPC方式访问SOAP服务          
    RPCServiceClient serviceClient = new RPCServiceClient();  
    Options options = serviceClient.getOptions();  
    //指定调用HelloService的URL  
    EndpointReference targetEPR = new EndpointReference(  
             "http://localhost:8080/axis2/services/HelloService");  
    options.setTo(targetEPR);  

    //指定sayHello方法的参数值  
    Object[] parameters = new Object[] {"Tom"};  
    //指定sayHello方法返回值的数据类型的Class对象  
    Class[] returnTypes = new Class[] {String.class};  
    //指定要调用的sayHello方法及WSDL文件的命名空间  
    QName methodEntry = new QName("http://mypack", "sayHello");  

    //调用sayHello方法并输出该方法的返回值  
    Object[] response =serviceClient.invokeBlocking(methodEntry, parameters, returnTypes);
    String result=(String)response[0];
    System.out.println(result);  
  }  
}  
