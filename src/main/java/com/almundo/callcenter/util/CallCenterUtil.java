package com.almundo.callcenter.util;

import com.almundo.callcenter.comparator.EmployeeComparator;
import com.almundo.callcenter.model.Call;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.EmployeeType;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * The call center util interface
 *
 * @Author Diego Sánchez
 */
public interface CallCenterUtil {

    /**
     * Builds a list of calls
     *
     * @param numberCall the number of calls to create
     * @return the list of calls
     */
    static List<Call> buildCalls(int numberCall){

        return Stream.generate(Call::new).limit(numberCall).collect(toList());
    }

    /**
     * Builds the list of employees
     *
     * @return the list of employees
     */
    static PriorityBlockingQueue<Employee> buildsEmployees(){

        Comparator<Employee> queueComparator = new EmployeeComparator();
        PriorityBlockingQueue<Employee> priorityQueue = new PriorityBlockingQueue(10,
                queueComparator);
        priorityQueue.addAll(Stream.generate(() -> new Employee(EmployeeType.OPERATOR))
                .limit(6).collect(toList()));
        priorityQueue.addAll(Stream.generate(() -> new Employee(EmployeeType.SUPERVISOR))
                .limit(3).collect(toList()));
        priorityQueue.add(new Employee(EmployeeType.DIRECTOR));
        return priorityQueue;
    }
}
