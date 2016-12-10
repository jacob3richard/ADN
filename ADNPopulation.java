import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by richardje1
 */
public class ADNPopulation {

    //make private
    public ArrayList<ADNMember> population;

    public ADNPopulation(){
        population = new ArrayList<ADNMember>();
    }

    public void addMember(ADNMember a){
        population.add(a);
    }

    public void sort(){
        Collections.sort(population, new Comparator<ADNMember>() {
            @Override
            public int compare(ADNMember p1, ADNMember p2) {

                return p2.weight - p1.weight; // Ascending

            }
        });
    }
    public void printResult(){
        for(int i = 0; i < population.get(0).member.size(); i++) {
            System.out.print("id: " + population.get(0).member.get(i).getId() + " ");
            System.out.print("color: " + population.get(0).member.get(i).getColor());
            for(int j = 0; j < population.get(0).member.get(i).getNeighborColors().size(); j++){
                System.out.print(population.get(0).member.get(i).getNeighborColors().get(j));
            }
            System.out.println("");
        }
        for(int i = 0; i < population.size(); i++) {

            //System.out.print("valid: " + population.get(i).getValid() + " ");
            //System.out.println("weight: " + population.get(i).weight);



        }

    }
    public boolean validResult(){
        return (population.get(0).getValid() == 1);
    }

    public void removeBottom(){

        for(int i = population.size() - 1; i >= 200; i-- ){
            population.remove(i);
        }

    }
}



