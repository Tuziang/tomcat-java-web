import org.apache.logging.log4j.*;
public class Log4JApp {
  //获得helloappLogger实例
  static Logger helloappLogger =
    LogManager.getLogger("helloappLogger");
  //获得childLogger实例
  static Logger childLogger =
    LogManager.getLogger("helloappLogger.childLogger");

  public static void main(String[] args) {


    //用helloappLogger输出各种级别的日志信息
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

    //用childLogger输出各种级别的日志信息
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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.net                *
 ***************************************************/
