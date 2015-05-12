import org.apache.camel.BeanInject;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.apache.camel.test.spring.MockEndpointsAndSkip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("/application-context-test.xml")
@RunWith(CamelSpringJUnit4ClassRunner.class)
@BootstrapWith(CamelTestContextBootstrapper.class)
@MockEndpointsAndSkip
public class CamelMainTest {

    @Autowired
    public CamelContext camelContext;

    @EndpointInject(uri = "mock:stream:out")
    protected MockEndpoint streamEndPoint;

    @EndpointInject(uri = "mock:bean:step2")
    protected MockEndpoint stepEndPoint;

    @EndpointInject(uri = "mock:http:www.ilegra.com.br" )
    protected MockEndpoint httpEndPoint;

    @Test
    public void endPointsReceiveAMessageTest() throws Exception {
        streamEndPoint.expectedMessageCount(1);
        stepEndPoint.expectedMessageCount(1);
        httpEndPoint.expectedMessageCount(1);

        MockEndpoint.assertIsSatisfied(camelContext);
    }

}
