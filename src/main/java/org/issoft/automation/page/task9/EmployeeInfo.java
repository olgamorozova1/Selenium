package org.issoft.automation.page.task9;

public class EmployeeInfo {
    private String name;
    private String position;
    private String office;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public EmployeeInfo(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    public EmployeeInfo() {
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInfo that = (EmployeeInfo) o;
        return name.equals(that.name) &&
                position.equals(that.position) &&
                office.equals(that.office);
    }
}
