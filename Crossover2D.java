package GeneticAlgorithm;

import java.util.Random;

public class Crossover2D {

    // Copies a chromosome from population to a separate byte[] array
    public static int[] copy(int[][] toCopy, int row){
        int columns = toCopy[0].length;
        int[] copied = new int[columns];
        for(int k=0; k<columns; k++)
            copied[k] = toCopy[row][k];
        return copied;
    }

    // Cross every chromosome in the population
    // Chance of crossover for current chromosome is crossProbability (60%)
    // Cannot cross with itself
    public static int[][] mixPopulation(int[][] population){
        int rows = population.length;
        int columns = population[0].length;
        float crossProbability = 0;
        int[][] newPopulation = new int[rows][columns];
        int[] newChromosome;
        int crossWith = 0;
        Random random = new Random();
        for(int i = 0; i< rows; i++){
            crossProbability = (float) Math.random();
            crossWith = random.nextInt(rows);
            while(crossWith == i) crossWith = random.nextInt(rows);
            if(crossProbability <= 0.6) {
                //System.out.println("i " + i + "with " + crossWith);
                newChromosome = crossover(population, i, crossWith);
                while(!checkChromosome(newChromosome)) newChromosome = crossover(population, i, crossWith);
                for (int j = 0; j < columns; j++) {
                    newPopulation[i][j] = newChromosome[j];
                }
            }
            else{
                newChromosome = copy(population, i);
                for(int j = 0; j < columns; j++){
                    newPopulation[i][j] = newChromosome[j];
                }
            }
        }
        return newPopulation;
    }

    // Generate two random points in the chromosome for the crossover to occur
    public static int[] crossover(int[][] population, int row, int crossWith){
        int columns = population[0].length;
        //System.out.println(columns);
        int crossP1 = (int) Math.round(Math.random() * columns);
        int crossP2 = (int) Math.round(Math.random() * columns);
        int lower;
        int upper;
        if(crossP1 > crossP2){
            lower = crossP2;
            upper = crossP1;
        }
        else{
            lower = crossP1;
            upper = crossP2;
        }
        int[] newChromosome = new int[columns];
        for(int i = 0; i < columns - 1; i++){
            if(i < lower){
                newChromosome[i] = population[row][i];
            }
            else if (i > lower && i < upper){
                newChromosome[i] = population[crossWith][i];
            }
            else if(i > upper){
                newChromosome[i] = population[row][i];
            }
        }
        return newChromosome;
    }

    // Check if the new chromosome and its genotypes are within bounds
    public static boolean checkChromosome(int[] chromosome){
        boolean correct = true;
        int len = chromosome.length;
        int genotypes = len /  19;
        String[] positionsBin = new String[genotypes];
        String positionOne = "";
        int[] positionDec = new int[genotypes];
        int j = 0;
        for(int i = 0; i < len; i++){
            positionOne += chromosome[i];
            if((i+1) % 19 == 0){
                positionsBin[j] = positionOne;
                j++;
                positionOne = "";
            }
        }
        for(int i = 0; i < genotypes; i++){
            positionDec[i] = Integer.parseInt(positionsBin[i], 2);
            if(positionDec[i] > 400001) correct = false;
        }
        return correct;
    }

}
