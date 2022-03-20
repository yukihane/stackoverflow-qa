class Student{
    String name = "satou";

    public void calculateAvg(int math,int english){
        System.out.println((math + english)/2);
    }
}

class Lesson13_01{
    public static void main(String[] args){
        Student a001 = new Student();
        a001.name = "satou";

        System.out.println(a001.name);
        a001.calculateAvg(90,80);
    }
}