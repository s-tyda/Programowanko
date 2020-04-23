package org.example;

public class Ecosystem {
    private Animal[] animals;
    public Ecosystem(Animal[] animals ){
        this.animals=animals;
    }


    public void addAge(){
        for(int i=0;i<animals.length;i++){
            if(animals[i]!=null)
                if(animals[i].addAge()==false)
                    animals[i]=null;
        }
    }
    public void print(){
        System.out.println("\nEcosystem:");
        int count=0;
        for(int i=0;i<animals.length;i++){
            if(animals[i]!=null) {
                System.out.println(animals[i].getName() + " " + animals[i].getAge()+ " " + animals[i].getMaxAge()+ " " + animals[i].getSexSymbol());
                count++;
            }
        }
        if(count==0) System.out.println("i nie było już nikogo");
    }
    public void birth(){
        int[][] isPair=new int[Species.elements()][2];

        for(int i=0;i<animals.length;i++){
            if(animals[i]!=null) {
                if(animals[i].getSex()==true && animals[i].getAge()>=1) {
                    isPair[animals[i].getName().getID()][0]++;
                }
                else if(animals[i].getSex()==false && animals[i].getAge()>=1 ) {
                    isPair[animals[i].getName().getID()][1]++;
                }
            }
        }
        for(int i=0; i<Species.elements(); i++){
            int min=Math.min(isPair[i][0],isPair[i][1]);
            if(min!=0){
                int count=0;
                for(int j=0;j<animals.length;j++)
                    if(animals[j]==null && count!=min) {
                        animals[j] = new Animal(i);
                        count++;

                    }

            }
        }



    }
}
