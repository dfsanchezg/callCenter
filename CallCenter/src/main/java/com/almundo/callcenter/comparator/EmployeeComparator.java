package com.almundo.callcenter.comparator;

import com.almundo.callcenter.model.Employee;

import java.util.Comparator;

/**
 * The employee comparator class
 *
 * @Author Diego Sánchez
 */
public class EmployeeComparator implements Comparator<Employee> {

    /**
     * Employee comparator
     *
     * @param emp1 the employee 1
     * @param emp2 the employee 2
     * @return
     */
    @Override
    public int compare(Employee emp1, Employee emp2) {

        return emp1.getType().getPriority() - emp2.getType().getPriority();
    }
}
