package SprintOne;

public class SectionSeparator {
    public static void main(String[] args) {
//        System.out.println(" Section 1: Name\n ------------------ ");
//        System.out.println(" Section 2: ID\n ------------------ ");
//        System.out.println(" Section 3: Date\n ------------------ ");

//          System.out.println(" Section 1: Name\n-----------------\n Section 2: ID\n-----------------\n Section 3: Date\n-----------------  ");

        String Section1[]={"Section 1","Section 2","Section 3"};
        String Section2[]={"Name","ID","Date"};
        int i=0;
        while(i<3){
            System.out.print("\n" + Section1[i] +"\t"+ Section2[i] + "\n-------------------");
            i++;
        }


    }

}