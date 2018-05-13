package com.almundo.callcenter.model;

/**
 * The employee class
 *
 * @Author Diego Sánchez
 */
public class Employee {

    /**
     * The employee type
     */
    private EmployeeType type;

    /**
     * Constructs a employee
     *
     * @param type the employee type
     */
    public Employee(EmployeeType type) {

        this.type = type;
    }

    /**
     * Gets the type
     * @return the employee type
     */
    public EmployeeType getType() {
        return type;
    }

    /**
     * Sets the employee
     * @param type the type
     */
    public void setType(EmployeeType type) {
        this.type = type;
    }

}
