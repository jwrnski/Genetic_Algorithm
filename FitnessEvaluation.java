package GeneticAlgorithm;

import java.util.Arrays;

public class FitnessEvaluation {

    public static float[] getAns(int[][] population){
        int len = population.length;
        float[] ans = new float[len];
        for(int i = 0; i < len; i++){
            ans[i] = calc(population, i);
        }
        return ans;
    }

    public static float getMin(float[] fitness){
        float minValue = fitness[0];
        for(int i = 1; i < fitness.length; i++)
            if(fitness[i] < minValue) minValue = fitness[i];
        return minValue;
    }

    public static float getMax(float[] fitness){
        float maxValue = fitness[0];
        for(int i = 1; i < fitness.length; i++)
            if(fitness[i] > maxValue) maxValue = fitness[i];
        return maxValue;
    }

    public static float avg(float[] fit){
        float sum = 0;
        int len = fit.length;
        for(float i : fit)
            sum += i;
        return sum/len;
    }

    public static float calc(int[][]population, int row){
        float ans = 0;
        int[] chromosome = Crossover2D.copy(population, row);
        int len = chromosome.length;
        int genotypes = len / 19;
        float[] variables = new float[genotypes];
        String[] positionsBin = new String[genotypes];
        String positionOne = "";
        int[] positionDec = new int[genotypes];
        int j = 0;
        //System.out.println(Arrays.toString(chromosome));
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
            variables[i] = GeneticOperator.decode(positionDec[i]);
        }
        //System.out.println(Arrays.toString(positionsBin));
        //System.out.println(Arrays.toString(positionDec));
        //System.out.println(Arrays.toString(variables));
        ans = Functions.rosenbrock(variables);
        return ans;
    }
}
