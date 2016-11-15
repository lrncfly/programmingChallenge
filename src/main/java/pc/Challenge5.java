package pc;

import java.util.LinkedList;
import java.util.List;

import pc.Command.CommandType;

public class Challenge5 {

    public static void main(String[] args) {
        Challenge5 c = new Challenge5();
        List<Command> commands = new LinkedList<>();
        Command i = new Command(CommandType.I);
        i.setM(6);
        i.setN(5);
        commands.add(i);
        i = new Command(CommandType.L);
        i.setX(3 - 1);
        i.setY(2 - 1);
        i.setColour('A');
        commands.add(i);
        i = new Command(CommandType.S);
        i.setFile("one.bmp");
        commands.add(i);
        i = new Command(CommandType.V);
        i.setX(2 - 1);
        i.setY1(3 - 1);
        i.setY2(4 - 1);
        i.setColour('W');
        commands.add(i);
        i = new Command(CommandType.H);
        i.setX1(3 - 1);
        i.setX2(4 - 1);
        i.setY(2 - 1);
        i.setColour('Z');
        commands.add(i);
        i = new Command(CommandType.F);
        i.setX(3 - 1);
        i.setY(3 - 1);
        i.setColour('J');
        commands.add(i);
        i = new Command(CommandType.S);
        i.setFile("two.bmp");
        commands.add(i);
        for (Command inst : commands)
            switch (inst.getType()) {
            case I:
                c.initialiseCommand(inst.getM(), inst.getN());
                break;
            case C:
                c.clearCommand();
                break;
            case L:
                c.colorCommand(inst.getX(), inst.getY(), inst.getColour());
                break;
            case V:
                c.verticalCommand(inst.getX(), inst.getY1(), inst.getY2(), inst.getColour());
                break;
            case H:
                c.horizontalCommand(inst.getX1(), inst.getX2(), inst.getY(), inst.getColour());
                break;
            case K:
                c.rectangleCommand(inst.getX1(), inst.getY1(), inst.getX2(), inst.getY2(), inst.getColour());
                break;
            case F:
                c.fillCommand(inst.getX(), inst.getY(), inst.getColour());
                break;
            case S:
                c.saveCommand(inst.getFile());
                break;
            default:
                break;
            }
    }

    private int m;
    private int n;
    private char[][] canvas;

    boolean initialiseCommand(int m, int n) {
        this.m = m;
        this.n = n;
        this.canvas = new char[m][n];
        return clearCommand();
    }

    boolean clearCommand() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                colorCommand(i, j, '0');
            }
        }
        
        return true;
    }

    boolean colorCommand(int x, int y, char c) {
        canvas[x][y] = c;
        return true;
    }

    boolean verticalCommand(int x, int y1, int y2, char c) {
        for (int j = y1; j <= y2; j++) {
            colorCommand(x, j, c);
        }
        return true;
    }

    boolean horizontalCommand(int x1, int x2, int y, char c) {
        for (int i = x1; i <= x2; i++) {
            colorCommand(i, y, c);
        }
        return true;
    }

    boolean rectangleCommand(int x1, int y1, int x2, int y2, char c) {
        horizontalCommand(x1, x2, y1, c);
        horizontalCommand(x1, x2, y2, c);
        verticalCommand(x1, y1, y2, c);
        verticalCommand(x2, y1, y2, c);
        return true;
    }

    boolean fillCommand(int x, int y, char c) {
        char cToReplace = canvas[x][y];
        if (c != cToReplace) {
            canvas[x][y] = c;
            replaceSurrounding(x + 1, y + 1, cToReplace, c);
            replaceSurrounding(x + 1, y, cToReplace, c);
            replaceSurrounding(x + 1, y - 1, cToReplace, c);
            replaceSurrounding(x, y + 1, cToReplace, c);
            replaceSurrounding(x, y - 1, cToReplace, c);
            replaceSurrounding(x - 1, y + 1, cToReplace, c);
            replaceSurrounding(x - 1, y, cToReplace, c);
            replaceSurrounding(x - 1, y - 1, cToReplace, c);
        }
        return true;
    }

    private void replaceSurrounding(int i, int j, char cToReplace, char c) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (this.canvas[i][j] == cToReplace)
                fillCommand(i, j, c);
        }
    }

    boolean saveCommand(String file) {
        System.out.println(file);
        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[i].length; j++) {
                System.out.print(this.canvas[i][j]);
            }
            System.out.println();
        }
        return true;
    }
}

class Command {
    enum CommandType {
        I, C, L, V, H, K, F, S, X
    }

    private CommandType type;
    private int m;
    private int n;
    private int[] x = new int[2];
    private int[] y = new int[2];
    private char colour;
    private String file;

    Command(CommandType type) {
        this.type = type;
    }

    public CommandType getType() {
        return this.type;
    }

    public String getFile() {
        return this.file;
    }

    public int getY2() {
        return this.y[this.y.length - 1];
    }

    public int getX2() {
        return this.x[this.x.length - 1];
    }

    public int getX1() {
        return this.getX();
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setX(int x) {
        this.x[0] = x;
    }

    public void setY(int y) {
        this.y[0] = y;
    }

    public void setX1(int x) {
        this.x[0] = x;
    }

    public void setY1(int y) {
        this.y[0] = y;
    }

    public void setX2(int x) {
        this.x[this.x.length - 1] = x;
    }

    public void setY2(int y) {
        this.y[this.y.length - 1] = y;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getY1() {
        return this.getY();
    }

    public char getColour() {
        return this.colour;
    }

    public int getY() {
        return this.y[0];
    }

    public int getX() {
        return this.x[0];
    }

    public int getN() {
        return this.n;
    }

    public int getM() {
        return this.m;
    }
}
