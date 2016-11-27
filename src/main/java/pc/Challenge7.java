package pc;

import java.util.HashMap;
import java.util.Map;

class Challenge7 {

    private char[][] board = new char[8][8];
    private int kX;
    private int kY;
    private int KX;
    private int KY;

    Challenge7() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                board[i][j] = '.';
        }
    }

    void initBoard(char[][] board) {
        this.board = board;
    }

    String checkForCheck(int num) {
        findBlackKing();
        findWhiteKing();
        String king = "Game #%d: %s king is in check";
        boolean bCheck = false;
        boolean wCheck = false;
        for (Pieces p : Pieces.values()) {
            if (!bCheck)
                bCheck = heuristicSearch(p, true, this.kX, this.kY);
            if (!wCheck)
                wCheck = heuristicSearch(p, false, this.KX, this.KY);
        }
        String kings = "";
        if (bCheck)
            kings = kings + String.format(king, num, "black");
        if (wCheck && bCheck)
            kings = kings + System.lineSeparator() + String.format(king, num, "white");
        else if (wCheck)
            kings = kings + String.format(king, num, "white");
        else
            kings = kings + String.format(king, num, "no");

        return kings;
    }

    public boolean heuristicSearch(Pieces p, boolean b, int x, int y) {
        boolean xyUpperCase = Character.isUpperCase(board[x][y]);
        switch (p) {
        case PAWN:
            if (y > 0 && x < board.length
                    && Pieces.findByKey(board[x + 1][y - 1]) == Pieces.PAWN
                    && (Character.isUpperCase(board[x + 1][y - 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 1, y - 1);
            if (y < board.length - 1 && x < board.length
                    && Pieces.findByKey(board[x + 1][y + 1]) == Pieces.PAWN
                    && (Character.isUpperCase(board[x + 1][y + 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 1, y + 1);
            if (y > 0 && x > 0
                    && Pieces.findByKey(board[x - 1][y - 1]) == Pieces.PAWN
                    && (Character.isUpperCase(board[x - 1][y - 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 1, y - 1);
            if (y < board.length - 1 && x > 0
                    && Pieces.findByKey(board[x - 1][y + 1]) == Pieces.PAWN
                    && (Character.isUpperCase(board[x - 1][y + 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 1, y + 1);
            break;
        case KNIGHT:
            if (y > 0 && x < board.length - 2
                    && Pieces.findByKey(board[x + 2][y - 1]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x + 2][y - 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 2, y - 1);
            if (y < board.length - 1 && x < board.length - 2
                    && Pieces.findByKey(board[x + 2][y + 1]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x + 2][y + 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 2, y + 1);
            if (y > 1 && x < board.length - 1
                    && Pieces.findByKey(board[x + 1][y - 2]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x + 1][y - 2]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 1, y - 2);
            if (y < board.length - 2 && x < board.length - 1
                    && Pieces.findByKey(board[x + 1][y + 2]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x + 1][y + 2]) ^ xyUpperCase))
                return this.markCheckPosition(p, x + 1, y + 2);
            if (y > 0 && x > 1
                    && Pieces.findByKey(board[x - 2][y - 1]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x - 2][y - 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 2, y - 1);
            if (y < board.length - 1 && x > 1
                    && Pieces.findByKey(board[x - 2][y + 1]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x - 2][y + 1]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 2, y + 1);
            if (y > 1 && x > 0
                    && Pieces.findByKey(board[x - 1][y - 2]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x - 1][y - 2]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 1, y - 2);
            if (y < board.length - 2 && x > 0
                    && Pieces.findByKey(board[x - 1][y + 2]) == Pieces.KNIGHT
                    && (Character.isUpperCase(board[x - 1][y + 2]) ^ xyUpperCase))
                return this.markCheckPosition(p, x - 1, y + 2);
            break;
        case ROOK:
            boolean bFound = false;
            int tmpx = x;
            while (!bFound && tmpx < board.length) {
                if ((Pieces.findByKey(board[tmpx][y]) == Pieces.ROOK
                        || Pieces.findByKey(board[tmpx][y]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][y]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][y]), tmpx, y);
                else if (Pieces.findByKey(board[tmpx][y]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][y]) != Pieces.KING)
                    bFound = true;
                else
                    tmpx++;
            }
            tmpx = x;
            while (!bFound && tmpx >= 0) {
                if ((Pieces.findByKey(board[tmpx][y]) == Pieces.ROOK
                        || Pieces.findByKey(board[tmpx][y]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][y]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][y]), tmpx, y);
                else if (Pieces.findByKey(board[tmpx][y]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][y]) != Pieces.KING)
                    bFound = true;
                else
                    tmpx--;
            }
            int tmpy = y;
            while (!bFound && tmpy < board.length) {
                if ((Pieces.findByKey(board[x][tmpy]) == Pieces.ROOK
                        || Pieces.findByKey(board[x][tmpy]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[x][tmpy]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[x][tmpy]), x, tmpy);
                else if (Pieces.findByKey(board[x][tmpy]) != Pieces.NONE
                        && Pieces.findByKey(board[x][tmpy]) != Pieces.KING)
                    bFound = true;
                else
                    tmpy++;
            }
            tmpy = y;
            while (!bFound && tmpy >= 0) {
                if ((Pieces.findByKey(board[x][tmpy]) == Pieces.ROOK
                        || Pieces.findByKey(board[x][tmpy]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[x][tmpy]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[x][tmpy]), x, tmpy);
                else if (Pieces.findByKey(board[x][tmpy]) != Pieces.NONE
                        && Pieces.findByKey(board[x][tmpy]) != Pieces.KING)
                    bFound = true;
                else
                    tmpy--;
            }
            break;
        case BISHOP:
            tmpx = x + 1;
            int tmpy1 = y - 1;
            int tmpy2 = y + 1;
            while (tmpx < board.length) {
                if (tmpy1 >= 0
                        && (Pieces.findByKey(board[tmpx][tmpy1]) == Pieces.BISHOP
                                || Pieces.findByKey(board[tmpx][tmpy1]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][tmpy1]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][tmpy1]), tmpx, tmpy1);
                else if (tmpy2 < board.length
                        && (Pieces.findByKey(board[tmpx][tmpy2]) == Pieces.BISHOP
                                || Pieces.findByKey(board[tmpx][tmpy2]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][tmpy2]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][tmpy2]), tmpx, tmpy2);
                else if (tmpy1 >= 0 && Pieces.findByKey(board[tmpx][tmpy1]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][tmpy1]) != Pieces.KING)
                    tmpy1 = -1;
                else if (tmpy2 < board.length && Pieces.findByKey(board[tmpx][tmpy2]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][tmpy2]) != Pieces.KING)
                    tmpy2 = board.length;
                else {
                    tmpx++;
                    tmpy1--;
                    tmpy2++;
                }
            }
            tmpx = x - 1;
            tmpy1 = y - 1;
            tmpy2 = y + 1;
            while (tmpx >= 0) {
                if (tmpy1 >= 0
                        && (Pieces.findByKey(board[tmpx][tmpy1]) == Pieces.BISHOP
                                || Pieces.findByKey(board[tmpx][tmpy1]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][tmpy1]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][tmpy1]), tmpx, tmpy1);
                else if (tmpy2 < board.length
                        && (Pieces.findByKey(board[tmpx][tmpy2]) == Pieces.BISHOP
                                || Pieces.findByKey(board[tmpx][tmpy2]) == Pieces.QUEEN)
                        && (Character.isUpperCase(board[tmpx][tmpy2]) ^ xyUpperCase))
                    return this.markCheckPosition(Pieces.findByKey(board[tmpx][tmpy2]), tmpx, tmpy2);
                else if (tmpy1 >= 0 && Pieces.findByKey(board[tmpx][tmpy1]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][tmpy1]) != Pieces.KING)
                    tmpy1 = -1;
                else if (tmpy2 < board.length && Pieces.findByKey(board[tmpx][tmpy2]) != Pieces.NONE
                        && Pieces.findByKey(board[tmpx][tmpy2]) != Pieces.KING)
                    tmpy2 = board.length;
                else if (tmpx < board.length) {
                    tmpx--;
                    tmpy1--;
                    tmpy2++;
                }
            }
            break;
        default:
            break;
        }
        return false;
    }

    private boolean markCheckPosition(Pieces p, int i, int j) {
        System.out.println(String.format("King in check from %s at %d,%d", p, i, j));
        return true;
    }

    void findBlackKing() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'k') {
                    kX = i;
                    kY = j;
                    break;
                }
            }
        }
    }

    void findWhiteKing() {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'K') {
                    KX = i;
                    KY = j;
                    break;
                }
            }
        }
    }

    enum Pieces {
        PAWN('p'), ROOK('r'), BISHOP('b'), KNIGHT('n'), QUEEN('q'), KING('k'), NONE('.');
        private Character identifier;

        Pieces(char c) {
            this.identifier = c;
        }

        private static final Map<Character, Pieces> map;
        static {
            map = new HashMap<Character, Pieces>();
            for (Pieces v : Pieces.values()) {
                map.put(v.identifier, v);
            }
        }

        public static Pieces findByKey(char i) {
            return map.get(Character.toLowerCase(i));
        }
    };

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { 'q', '.', 'k', '.', '.', '.', '.', '.' },
                { 'P', 'p', 'p', '.', 'p', 'p', 'p', 'p' },
                { '.', '.', 'R', '.', '.', '.', '.', '.' },
                { '.', 'R', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
                { 'K', '.', '.', '.', '.', '.', '.', '.' } };
        Challenge7 c = new Challenge7();
        c.initBoard(board);
        System.out.println(c.checkForCheck(1));
    }
}
