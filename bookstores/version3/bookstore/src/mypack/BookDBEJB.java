

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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
