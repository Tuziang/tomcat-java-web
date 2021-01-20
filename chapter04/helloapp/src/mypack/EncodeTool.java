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
    //���Գ���

    String s1=new String("���".getBytes(),"GBK");
    String s2=new String("���".getBytes(),"UTF-8");
    String s3=new String("���".getBytes(),"ISO-8859-1");
    
    System.out.println("s1�ı���:"+getEncoding(s1));  //��ӡGBK
    System.out.println("s2�ı���:"+getEncoding(s2));  //��ӡUTF-8
    System.out.println("s3�ı���:"+getEncoding(s3));  //��ӡISO-8859-1
    System.out.println("Ĭ�ϵı���:"+getEncoding("���"));
  }
}