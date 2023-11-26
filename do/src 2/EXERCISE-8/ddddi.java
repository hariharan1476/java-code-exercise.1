public class ddddi {

    public String name;
    public int age;

    
    public ddddi() {
        this.name = "Unknown";
        this.age = 80;
    }


    public ddddi(String name,int age) {
        this.name = name;
        this.age = age;
    }


    public int add(int a, int b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public void dd() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        ddddi e1 = new ddddi();
        ddddi e2 = new ddddi("John",78);
  
        e1.dd();
        e2.dd();

        System.out.println("Sum of two integers: " + e1.add(3, 5));
        System.out.println("Sum of three integers: " + e1.add("a","b"));

    }
}
