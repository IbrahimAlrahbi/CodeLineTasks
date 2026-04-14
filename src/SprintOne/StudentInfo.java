package SprintOne;

public class StudentInfo {
    public static void main(String[] args) {
        System.out.println("Name\tAge\tGrade");
//        System.out.println("Ibrahim\t12\t7");
//        System.out.println("Ahmed\t13\t8");


        String Name[]={"Ibrahim","Ahmed"};
        int Age[]={12,13};
        int Grade[]={7,8};

        for(int i = 0; true; i++){

            System.out.println(Name[i] +"\t"+ Age[i] +"\t"+ Grade[i]);

        }

    }
}