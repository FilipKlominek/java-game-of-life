package com.company;

public class Game {
    private final int[][] field;

    private int round = 0;

    public Game(int[][] field) {
        this.field = field;
    }

    public void advance() {
        this.round++;

        int[][] newField = new int[field.length][field[0].length];
        for (int y = 0; y < field.length; y++) {
            System.arraycopy(field[y], 0, newField[y], 0, field[y].length);
        }

        int neighbours;

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                neighbours = 0;

                if (y > 0 && x > 0) if (field[y - 1][x - 1] == 1) neighbours++; //↖
                if (y > 0 && x < field[y].length - 1) if (field[y - 1][x + 1] == 1) neighbours++; //↗
                if (y < field.length - 1 && x > 0) if (field[y + 1][x - 1] == 1) neighbours++; //↙
                if (y < field.length - 1 && x < field[y].length - 1) if (field[y + 1][x + 1] == 1) neighbours++; //↘

                if (y > 0) if (field[y - 1][x] == 1) neighbours++; //↑
                if (y < field.length - 1) if (field[y + 1][x] == 1) neighbours++; //↓
                if (x > 0) if (field[y][x - 1] == 1) neighbours++; //←
                if (x < field[y].length - 1) if (field[y][x + 1] == 1) neighbours++; //→


                if (field[y][x] == 0) if (neighbours == 3) newField[y][x] = 1;

                if (neighbours <= 1 || neighbours >= 4) newField[y][x] = 0;
            }
        }

        for (int y = 0; y < newField.length; y++) {
            System.arraycopy(newField[y], 0, field[y], 0, newField[y].length);
        }
    }

    public void print() {
        System.out.println("Round " + round + ":");
        for (int[] ints : field) {
            for (int anInt : ints) {
                if (anInt == 1) System.out.print("■ ");
                else System.out.print("□ ");
            }
            System.out.println();
        }
    }
}
