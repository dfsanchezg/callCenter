package com.almundo.callcenter.model;

/**
 * Represents the different employee types
 *
 * @Author Diego Sánchez
 */
public enum EmployeeType {

    /**Operator type*/
    OPERATOR(1),
    /**Supervisor type*/
    SUPERVISOR(2),
    /**Director Type*/
    DIRECTOR(3);

    /** the priority level in the call center operation*/
    int priority;

    /**
     * The EmployeeType constructor
     *
     * @param priority the priority
     */
    EmployeeType(int priority){
        this.priority = priority;
    }

    /**
     * Gets the priority
     *
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }
}
