public class GenericBase {
    int data;
    void addData(int data) {
        this.data=data;
    }
    int getdata(){
        return data;

    }
    public static void main(String[] args){
        GenericBase g = new GenericBase();
        g.addData(87);
        GenericBase g2 = new GenericBase();
        g2.addData(13);
        GenericBase g3 = new GenericBase();
        g3.addData(67);
        System.out.println(g.getdata());
        System.out.println(g2.getdata());
        System.out.println(g3.getdata());
    }

    
    
}
