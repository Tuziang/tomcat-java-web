import org.apache.logging.log4j.*;
public class Log4JApp {
  //���helloappLoggerʵ��
  static Logger helloappLogger =
    LogManager.getLogger("helloappLogger");
  //���childLoggerʵ��
  static Logger childLogger =
    LogManager.getLogger("helloappLogger.childLogger");

  public static void main(String[] args) {


    //��helloappLogger������ּ������־��Ϣ
    helloappLogger.trace("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.debug("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.info("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.warn("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.error("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.fatal("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.log(Level.ERROR,"This is an error message");

    //��childLogger������ּ������־��Ϣ
    childLogger.debug("This is a log message from the " +
      childLogger.getName());
    childLogger.info("This is a log message from the " +
      childLogger.getName());
    childLogger.warn("This is a log message from the " +
      childLogger.getName());
    childLogger.error("This is a log message from the " +
      childLogger.getName());
    childLogger.fatal("This is a log message from the " +
      childLogger.getName());
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.net                *
 ***************************************************/
