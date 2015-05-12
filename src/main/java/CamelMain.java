import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelMain {
    static Logger LOG = LoggerFactory.getLogger(CamelMain.class);
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        CamelContext camelContext = (CamelContext)applicationContext.getBean("camelContext");
        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}

