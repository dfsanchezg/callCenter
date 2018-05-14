package com.almundo.callcenter;

import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.util.CallCenterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * the class in charge of handle the calls
 * @Author Diego Sánchez
 */
public class Dispatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Dispatcher.class);

    /** Max number of threads*/
    private static final int MAX_THREADS = 10;

    /** Employees Queue */
    private PriorityBlockingQueue<Employee> employeesQueue;

    /** The list of calls to attend */
    private List<Call> callsToAttend;

    /**Attended calls */
    private List<Call> attendedCalls;

    /** The executor services */
    private ExecutorService executorService;

    /**
     * Constructs the dispatcher class
     *
     * @param numberCalls the number of calls to attend
     */
    public Dispatcher(int numberCalls) {

        this.executorService = Executors.newFixedThreadPool(MAX_THREADS);
        employeesQueue = CallCenterUtil.buildsEmployees();
        callsToAttend = CallCenterUtil.buildCalls(numberCalls);
        attendedCalls = new ArrayList<>();
    }

    /**
     * Attends the calls
     */
    public void attendCalls(){

        LOGGER.info("Start to process " + callsToAttend.size() + " calls");
        callsToAttend.forEach(call -> executorService.execute(() -> dispatchCall(call)));
        stop();
    }

    /**
     * Gets the number of attended calls
     *
     * @return the number of attended calls
     */
    public int getNumberAttendedCalls(){

        return attendedCalls.size();
    }

    /**
     *
     * @return
     */
    public ExecutorService getExecutorService(){

        return executorService;
    }

    /**
     * Stops the employee threads and the dispatcher run method immediately
     */
    public synchronized void stop() {

        this.executorService.shutdown();
    }

    /**
     * Handles the call
     *
     * @param call the call to be attend
     */
    private void dispatchCall(Call call) {

        try {

            Employee employee = employeesQueue.poll();
            System.out.println("Attending call for  " + call.getDuration() + " " +
                    Thread.currentThread() + " " + employee.getType().name());
            Thread.sleep(call.getDuration());
            employeesQueue.add(employee);
            attendedCalls.add(call);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
