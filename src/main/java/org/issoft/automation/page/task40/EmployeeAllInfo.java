package org.issoft.automation.page.task40;

public class EmployeeAllInfo extends EmployeeInfo {
    private int age;
    private String startDate;
    private int salary;

    public int getAge() {
        return age;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSalary(int salary) {
        salary = salary;
    }

    public EmployeeAllInfo(String name, String position, String office, int age, String startDate, int salary) {
        super(name, position, office);
        this.age = age;
        this.startDate = startDate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeAllInfo{ Name=" + getName() + ", position=" + getPosition() + ", office=" + getOffice() +
                ", age=" + age +
                ", startDate=" + startDate +
                ", Salary=" + salary +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EmployeeAllInfo that = (EmployeeAllInfo) o;

        if (age != that.age) return false;
        if (salary != that.salary) return false;
        return startDate != null ? startDate.equals(that.startDate) : that.startDate == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }
}
