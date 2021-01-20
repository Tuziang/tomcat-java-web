

package mypack;

import javax.ejb.Remote;
import java.util.*;

@Remote
public interface BookDBEJB{
  public BookDetails getBookDetails(String bookId)throws Exception ;
  public int getNumberOfBooks()throws Exception ;
  public Collection getBooks()throws Exception ;
  public void buyBooks(ShoppingCart cart)throws Exception ;
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
