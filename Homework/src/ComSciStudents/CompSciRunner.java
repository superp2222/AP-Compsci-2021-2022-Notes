package ComSciStudents;

public class CompSciRunner {
    public static void main(String[] args) {
        APCompSciClass edward = new APCompSciClass("Edward", true);
        APCompSciClass student = new APCompSciClass();
        System.out.println(edward.getMark());
        edward.badStudent();
        edward.forgiveStudent();
        edward.setMark(100);
        edward.forgiveStudent();
        System.out.println(edward.getMark());
        System.out.println(edward.getName());
        edward.getPlaysGamesinClass();
        edward.setPlaysGamesinClass(false);
        edward.badStudent();
        System.out.println(edward.randomFail(1));
        System.out.println(edward.randomFail(22));
        edward.setMark(22);
        edward.passStudent();
        System.out.println(edward.getMark());
        System.out.println(edward);
        System.out.println(student.getName());
        student.setName("Giorgio");
        System.out.println(student.getName());
        student.badStudent();
    }
}
