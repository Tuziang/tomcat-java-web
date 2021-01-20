package mypack;
public class EncodeTool{
  private static final String[] encodes={"GBK","GB2312","ISO-8859-1","UTF-8"};
   
  public static boolean isEncoding(String str,String encode){
    try{    
           
      if(str.equals(new String(str.getBytes(encode), encode))) 
        return true;
      else
        return false; 
    }catch (Exception exception){ return false; }
  }

  public static String getEncoding(String str){
    for(int i=0;i<encodes.length;i++){
      if(isEncoding(str,encodes[i]))
        return encodes[i];
    }
    return null;
  }

  public static void main(String args[])throws Exception{
    //测试程序

    String s1=new String("你好".getBytes(),"GBK");
    String s2=new String("你好".getBytes(),"UTF-8");
    String s3=new String("你好".getBytes(),"ISO-8859-1");
    
    System.out.println("s1的编码:"+getEncoding(s1));  //打印GBK
    System.out.println("s2的编码:"+getEncoding(s2));  //打印UTF-8
    System.out.println("s3的编码:"+getEncoding(s3));  //打印ISO-8859-1
    System.out.println("默认的编码:"+getEncoding("你好"));
  }
}