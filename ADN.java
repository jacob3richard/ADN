import com.sun.javafx.css.Size;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Jacob Richard
 */


public class ADN {

    public static final int POPULATIONSIZE = 200;
    public static final int SIZEOFCHILDREN = 50;
    public static final int SIZEOFMUTANTS = 50;
    // minimum that I have found is 8
    // if on student machine do 9 :)
    // colors are 1 - numOfColors inclusive
    public static int numOfColors = 9;

    private int[][] adjacencyMatrix;
    private ADNobject[] ADNList;
    //private ADNMember[] population;
    private ADNMember[] populationArray;

    private PriorityQueue populationPQ = new PriorityQueue<ADNMember>(POPULATIONSIZE + SIZEOFCHILDREN,
            new Comparator<ADNMember>() {
                public int compare(ADNMember a, ADNMember b) {
                    return b.getWeight() - a.getWeight();
                }
            });

    private int colors;


    public static void main(String[] args) {
        //future parameters
        int[][] zM = new int[][]{{0, 1, 0, 0, 0, 0, 0},
                                 {1, 0, 1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 0, 0, 1},
                                 {0, 1, 0, 0, 1, 0, 1},
                                 {0, 0, 0, 1, 0, 1, 0},
                                 {0, 0, 0, 0, 1, 0, 1},
                                 {0, 0, 1, 1, 0, 1, 0}
        };
        //building a matrix generator next
        int[][] aM = new int[][]{{0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                                 {1, 0, 1, 1, 0, 0, 0, 0, 1, 0},
                                 {0, 1, 0, 0, 0, 0, 1, 1, 0, 1},
                                 {0, 1, 0, 0, 1, 0, 1, 1, 1, 0},
                                 {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                                 {0, 0, 0, 0, 1, 0, 1, 1, 1, 0},
                                 {0, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                                 {1, 0, 1, 1, 0, 1, 1, 0, 0, 1},
                                 {0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 0, 0, 1, 1, 0, 0}
        };

        ADN adn = new ADN();

        //populating the ADN list of ADNObjects
        adn.populateFromAdjacencyMatrix(aM);

        //make initial population
        ADNPopulation adnPopulation = new ADNPopulation();
        adn.populationArray = new ADNMember[POPULATIONSIZE];

        // initial population and sort.
        for (int i = 0; i < POPULATIONSIZE; i++) {
            ADNMember adnMember = new ADNMember();
            adnMember.makeMember(aM);
            adnPopulation.addMember(adnMember);
        }
        adnPopulation.sort();

        int tries = 0;
        while (!adnPopulation.validResult()) {

            Random r = new Random();
            int mutationProbability = r.nextInt((50) + 1);
            if (mutationProbability == 42) {
                for (int i = 0; i < SIZEOFMUTANTS; i++) {
                    ADNMember mutant = new ADNMember();
                    mutant.makeMember(aM);
                    adnPopulation.addMember(mutant);

                }
                System.out.println("Woah! Mutants.");
                tries ++;
            }
            else {

                System.out.println("result has not been found, adding children");
                for (int i = 0; i < SIZEOFCHILDREN; i++) {

                    ADNMember child = new ADNMember();
                    Random rand = new Random();
                    //rand.nextInt(149 - 10) + 1) + 10;

                    Random ra = new Random();
                    int mom = ra.nextInt((150 - 10) + 1) + 10;
                    child.makeChild(adnPopulation.population.get(i % 10), adnPopulation.population.get(mom));

                    adnPopulation.addMember(child);

                    tries++;
                }
                adnPopulation.sort();
                adnPopulation.removeBottom();
            }
        }
        System.out.println("result has been found after " + tries + " tries!");
        adnPopulation.printResult();

    }


    private void populateFromAdjacencyMatrix(int[][] arr) {

        //populating the list in ADN
        ADNList = new ADNobject[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ADNobject adNobject = new ADNobject();
            int weight = 0;
            adNobject.setId((char) i);
            for (int j = 0; j < arr[i].length; j++) {
                weight += arr[i][j];
            }
            adNobject.setWeight(weight);
            ADNList[i] = adNobject;
        }
    }

}


