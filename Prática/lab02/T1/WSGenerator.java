package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WSGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        //Tamanho máximo da sopa de letras
        int MAX_SIZE = 40;

        //Criação de um array que contenha as palavras
        ArrayList<String> words = new ArrayList<>();

        String filename = "";
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-i")){
                filename = args[i+1];
                break;
            }
        }
        if(filename == ""){
            System.out.println("Introduza um ficheiro com as palavras válido");
            return;
        }

        File file = new File(filename);
        // File file = new File("lab01/words.txt"); //ISto serviu para nos testes não estar sempre a colocar o local onde estava armazenado o ficheiro com as palavras
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] wordscache = line.split("[; ]");
            for(int i = 0; i < wordscache.length; i++){
                words.add(wordscache[i].toUpperCase());
            }
        }
        scanner.close();

        String output = "";
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-o")){
                output = args[i+1];
                break;
            }
        }
        if(output == ""){
            System.out.println("Introduza um ficheiro de saída válido");
            return;
        }



        ///////////////////////
/////////////////////////////////////
        System.out.println("Quais palavras pretendo colocar?");
        for(int i = 0; i < words.size(); i++){
            System.out.print(words.get(i) + " ");
        }
        System.out.println();
        ////////////////////////////////////////////////////////////


        //Encontrar o tamanho mínimo da sopa de letras
        int MIN_SIZE = 0;
        for(String i : words){
            if(MIN_SIZE < i.length()) MIN_SIZE = i.length();
        }


        //Encontrar um valor para o tamanho da sopa de letras e criação da matriz quadrada cheia de pontos
        int size = 0;
        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-s")){
                size = Integer.parseInt(args[i+1]);
                break;
            }
        }

        if(size < MIN_SIZE | size > MAX_SIZE){
            System.out.println("Introduza um tamanho válido para a sopa de letras");
            return;
        }

        char[][] soup = new char[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                soup[i][j] = '.';
            }
        }


        //Após ter as matrizes começo a inserir as palavras
        nextword: for(String word : words){

            ArrayList<int[]> positions = createPositionArray(size);

            while (positions.size() > 0){
                int x = (int)(Math.random() * (positions.size()));
                int[] xy = positions.get(x);
                positions.remove(x);
                
                ArrayList<String> directions = createDirectionArray();

                //Se já tiver procurado em todas as direçoes uma forma de colocar a palavra saio
                directionsearch: while(directions.size() > 0){
                    int intchoice = (int)(Math.random() * (directions.size()));
                    String direction = directions.get(intchoice);
                    directions.remove(intchoice);
                    int[] xy2;

                    //Agora vou obter a string dessa linha
                    String line = "";

                    switch(direction){
                        case "right":
                            //Vou verificar se a palavra cabe
                            if(word.length() + xy[1] > size) continue;

                            //Vou buscar a linha completa
                            for(int i = 0; i < size; i++){
                                line += soup[xy[0]][i];
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começar antes da palavra já colocada e acabar depois não posso colocar a palavra alí
                                    if(xy[1]+word.length() > line.indexOf(word2) && xy[1] < line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if(xy[1] >= line.indexOf(word2) && xy[1] < (line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]][xy[1]+i] != '.' && soup[xy[0]][xy[1]+i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]][xy[1]+i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "left":
                            //Vou verificar se a palavra cabe
                            if(xy[1] + 1 < word.length()) continue;

                            //Vou buscar a linha completa
                            for(int i = size - 1; i >= 0; i--){
                                line += soup[xy[0]][i];
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começar antes da palavra já colocada e acabar depois não posso colocar a palavra alí
                                    if(size - 1 - xy[1] < line.indexOf(word2) && size - 1 - xy[1]+word.length() > line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if( size - 1 - xy[1] >= line.indexOf(word2) && size - 1 - xy[1] < (line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]][xy[1]-i] != '.' && soup[xy[0]][xy[1]-i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]][xy[1]-i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "down":
                            //Vou verificar se a palavra cabe
                            if(word.length() + xy[0] > size) continue;

                            //Vou buscar a linha completa
                            for(int i = 0; i < size; i++){
                                line += soup[i][xy[1]];
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começar antes da palavra já colocada e acabar depois não posso colocar a palavra alí
                                    if(xy[0] < line.indexOf(word2) && xy[0]+word.length() > line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if(xy[0] >= line.indexOf(word2) && xy[0] < (line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]+i][xy[1]] != '.' && soup[xy[0]+i][xy[1]] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]+i][xy[1]] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "up":
                            //Vou verificar se a palavra cabe
                            if(xy[0] + 1 < word.length()) continue;

                            //Vou buscar a linha completa
                            for(int i = size - 1; i >= 0; i--){
                                line += soup[i][xy[1]];
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começar antes da palavra já colocada e acabar depois não posso colocar a palavra alí
                                    if(size - 1 - xy[0] < line.indexOf(word2) && size - 1 - xy[0]+word.length() > line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if(size - 1 - xy[0] >= line.indexOf(word2) && size - 1 - xy[0] < (line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]-i][xy[1]] != '.' && soup[xy[0]-i][xy[1]] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]-i][xy[1]] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "downright":
                            //Vou verificar se a palavra cabe
                            if(word.length() + xy[1] > size || word.length() + xy[0] > size) continue;

                            //Vou buscar a linha completa, verificando primeiro qual é o índice mais próximo de uma das fronteiras
                            xy2 = xy.clone();
                            while(xy2[0] != 0 && xy2[1] != 0){
                                xy2[0]--;
                                xy2[1]--;
                            }
                            while(xy2[0] != size && xy2[1] != size){
                                line += soup[xy2[0]][xy2[1]];
                                xy2[0]++;
                                xy2[1]++;
                            }

                            //Voltar a colocar um dos índices colado à fronteira
                            while(xy2[0] != 0 && xy2[1] != 0){
                                xy2[0]--;
                                xy2[1]--;
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começa antes da palavra lá colocada tenho de verificar se também acaba antes
                                    if(xy[0] >= xy2[0] + line.indexOf(word2) && xy[1] >= xy2[1] + line.indexOf(word2)  && ((xy[0] + word.length()) > (xy2[0] + line.indexOf(word2))) && ((xy[1] + word.length()) > (xy2[1] + line.indexOf(word2)))) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if((xy[0] >=  (xy2[0] + line.indexOf(word2))) && (xy[0] < xy2[0] + line.indexOf(word2) + word2.length())) continue directionsearch;
                                    if((xy[1] >=  (xy2[1] + line.indexOf(word2))) && (xy[1] < xy2[1] + line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]+i][xy[1]+i] != '.' && soup[xy[0]+i][xy[1]+i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]+i][xy[1]+i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "downleft":
                            //Vou verificar se a palavra cabe
                            if(xy[1] + 1 < word.length() || word.length() + xy[0] > size) continue;

                            //Vou buscar a linha completa, verificando primeiro qual é o índice mais próximo de uma das fronteiras
                            xy2 = xy.clone();
                            while(xy2[0] != 0 && xy2[1] != (size-1)){
                                xy2[0]--;
                                xy2[1]++;
                            }
                            while(xy2[0] != size && xy2[1] != 0){
                                line += soup[xy2[0]][xy2[1]];
                                xy2[0]++;
                                xy2[1]--;
                            }

                            //Voltar a colocar um dos índices colado à fronteira
                            while(xy2[0] != 0 && xy2[1] != (size-1)){
                                xy2[0]--;
                                xy2[1]++;
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começa antes da palavra lá colocada tenho de verificar se também acaba antes
                                    if( xy[0] < xy2[0] + line.indexOf(word2) && xy[1] > xy[1] - line.indexOf(word2) && ((xy[0] + word.length()) > (xy2[0] + line.indexOf(word2))) && xy[1] - word.length() < xy2[1] - line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if((xy[0] >=  (xy2[0] + line.indexOf(word2))) && (xy[0] < xy2[0] + line.indexOf(word2) + word2.length())) continue directionsearch;
                                    if(xy[1] <= xy2[1] - line.indexOf(word2) && xy[1] > xy2[1] - line.indexOf(word2) - word2.length()) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]+i][xy[1]-i] != '.' && soup[xy[0]+i][xy[1]-i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]+i][xy[1]-i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "upright":
                            //Vou verificar se a palavra cabe
                            if(xy[0] + 1 < word.length() || word.length() + xy[1] > size) continue;

                            //Vou buscar a linha completa, verificando primeiro qual é o índice mais próximo de uma das fronteiras
                            xy2 = xy.clone();
                            while(xy2[0] != (size-1) && xy2[1] != 0){
                                xy2[0]++;
                                xy2[1]--;
                            }
                            while(xy2[0] != 0 && xy2[1] != size){
                                line += soup[xy2[0]][xy2[1]];
                                xy2[0]--;
                                xy2[1]++;
                            }

                            //Voltar a colocar um dos índices colado à fronteira
                            while(xy2[0] != (size-1) && xy2[1] != 0){
                                xy2[0]++;
                                xy2[1]--;
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começa antes da palavra lá colocada tenho de verificar se também acaba antes
                                    if(xy[0] > xy2[0] - line.indexOf(word2) && xy[1] < xy2[1] + line.indexOf(word2) && (xy[0] - word.length() < xy2[0] - line.indexOf(word2)) && xy[1] + word.length() > xy2[1] + line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if((xy[0] <=  (xy2[0] - line.indexOf(word2))) && (xy[0] > xy2[0] - line.indexOf(word2) - word2.length())) continue directionsearch;
                                    if((xy[1] >=  (xy2[1] + line.indexOf(word2))) && (xy[1] < xy2[1] + line.indexOf(word2) + word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]-i][xy[1]+i] != '.' && soup[xy[0]-i][xy[1]+i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]-i][xy[1]+i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        case "upleft":
                            //Vou verificar se a palavra cabe
                            if(xy[0] + 1 < word.length() || xy[1] + 1 < word.length()) continue;

                            //Vou buscar a linha completa, verificando primeiro qual é o índice mais próximo de uma das fronteiras
                            xy2 = xy.clone();
                            while(xy2[0] != (size-1) && xy2[1] != (size-1)){
                                xy2[0]++;
                                xy2[1]++;
                            }
                            while(xy2[0] != 0 && xy2[1] != 0){
                                line += soup[xy2[0]][xy2[1]];
                                xy2[0]--;
                                xy2[1]--;
                            }

                            //Voltar a colocar um dos índices colado à fronteira
                            while(xy2[0] != (size-1) && xy2[1] != (size-1)){
                                xy2[0]++;
                                xy2[1]++;
                            }

                            //vou verificar se a minha palavra não é uma continuação ou subpalavra de outra
                            for(String word2 : words){
                                if(line.contains(word2)){
                                    //se a minha palavra começa antes da palavra lá colocada tenho de verificar se também acaba antes
                                    if(xy[0] > xy2[0] - line.indexOf(word2) && xy[1] > xy[1] - line.indexOf(word2) && xy[0] - word.length() < xy2[0] - line.indexOf(word2) && xy[1] - word.length() < xy2[1] - line.indexOf(word2)) continue directionsearch;
                                    //se a minha palavra começar entre o inicio e o fim da palavra já la colocada alí
                                    if((xy[0] <=  (xy2[0] - line.indexOf(word2))) && (xy[0] > xy2[0] - line.indexOf(word2) - word2.length())) continue directionsearch;
                                    if((xy[1] <=  (xy2[1] - line.indexOf(word2))) && (xy[1] > xy2[1] - line.indexOf(word2) - word2.length())) continue directionsearch;
                                }
                            }
                            //Ao chegar até aqui apenas preciso de verificar se todas as letras que eu vou alterar, ou se tratam de pontos ou se são iguais à letra que pretendo colocar
                            for(int i = 0; i<word.length(); i++){
                                if(soup[xy[0]-i][xy[1]-i] != '.' && soup[xy[0]-i][xy[1]-i] != word.charAt(i)) continue directionsearch;
                            }

                            //Aqui sei que tudo correu bem, portanto é só substituir
                            for(int i = 0; i< word.length(); i++){
                                soup[xy[0]-i][xy[1]-i] = word.charAt(i);
                            }
                            printMatrix(soup, size);
                        continue nextword;
                        
                    }
                }
            }

            System.out.println("Não foi possível introduzir a palavra " + word + " pode tentar correr de novo o programa para uma nova tentativa.");

        }


        //Colocar letras aleatórias para concluir a sopa de letras
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(soup[i][j] == '.'){
                    soup[i][j] = (char) (rnd.nextInt(26) + 'A');
                }
            }
        }

        printMatrix(soup, size);

        PrintWriter writer = new PrintWriter(output);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                writer.printf("%c",soup[i][j]);
            }
            writer.println();
        }
        Scanner scanner2 = new Scanner(file);
        while(scanner2.hasNextLine()){
            writer.println(scanner2.nextLine());
        }

        writer.close();
        scanner2.close();
    }
    
    public static void printMatrix(char[][] soup, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%c ",soup[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<String> createDirectionArray(){
        ArrayList<String> direction = new ArrayList<>();
        direction.add("right");
        direction.add("left");
        direction.add("down");
        direction.add("up");
        direction.add("downright");
        direction.add("downleft");
        direction.add("upright");
        direction.add("upleft");
        return direction;
    }

    public static ArrayList<int[]> createPositionArray(int size){
        ArrayList<int[]> position = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int[] pos = new int[2];
                pos[0] = i;
                pos[1] = j;
                position.add(pos);
            }
        }
        return position;
    }
}
