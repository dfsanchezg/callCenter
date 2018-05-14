import com.almundo.callcenter.Dispatcher;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.EmployeeType;
import com.almundo.callcenter.util.CallCenterUtil;
import org.junit.Test;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * The dispatcher test class
 *
 * @Author Diego Sánchez
 */
public class DispatcherTest {

    /**
     * The test for the employee priority
     */
    @Test
    public void PriorityQueueEmployeeTest(){

        PriorityBlockingQueue<Employee> employeesQueue = CallCenterUtil.buildsEmployees();
        Employee operator1 = employeesQueue.poll();
        assertTrue(operator1.getType() == EmployeeType.OPERATOR);
        Employee operator2 = employeesQueue.poll();
        assertTrue(operator2.getType() == EmployeeType.OPERATOR);
        Employee operator3 = employeesQueue.poll();
        assertTrue(operator3.getType() == EmployeeType.OPERATOR);
        Employee operator4 = employeesQueue.poll();
        assertTrue(operator4.getType() == EmployeeType.OPERATOR);
        Employee operator5 = employeesQueue.poll();
        assertTrue(operator5.getType() == EmployeeType.OPERATOR);
        Employee operator6 = employeesQueue.poll();
        assertTrue(operator6.getType() == EmployeeType.OPERATOR);
        Employee supervisor1 = employeesQueue.poll();
        assertTrue(supervisor1.getType() == EmployeeType.SUPERVISOR);
        Employee supervisor2 = employeesQueue.poll();
        assertTrue(supervisor2.getType() == EmployeeType.SUPERVISOR);
        Employee supervisor3 = employeesQueue.poll();
        assertTrue(supervisor3.getType() == EmployeeType.SUPERVISOR);
        Employee director = employeesQueue.poll();
        assertTrue(director.getType() == EmployeeType.DIRECTOR);
        employeesQueue.add(director);
        employeesQueue.add(supervisor1);
        employeesQueue.add(operator1);
        assertTrue(operator1.getType() == employeesQueue.poll().getType());
    }

    /**
     * The test for process 10 calls
     *
     * @throws InterruptedException
     */
    @Test
    public void DispatchTenCallsTest() throws InterruptedException{

        int numberOfCalls = 10;
        Dispatcher dispatcher =  new Dispatcher(numberOfCalls);
        dispatcher.attendCalls();
        dispatcher.getExecutorService().awaitTermination(10, TimeUnit.SECONDS);
        assertTrue(dispatcher.getNumberAttendedCalls() == numberOfCalls);
    }

    /**
     * The test to process 20 calls
     *
     * @throws InterruptedException
     */
    @Test
    public void DispatchTwentyCallsTest() throws InterruptedException{

        int numberOfCalls = 20;
        Dispatcher dispatcher =  new Dispatcher(numberOfCalls);
        dispatcher.attendCalls();
        dispatcher.getExecutorService().awaitTermination(10*2, TimeUnit.SECONDS);
        assertTrue(dispatcher.getNumberAttendedCalls() == numberOfCalls);
    }
}
