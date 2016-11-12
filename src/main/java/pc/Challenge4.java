package pc;

public class Challenge4 {

    public static void main(String[] args) {
        Challenge4 c = new Challenge4();
        for (int i = 0; i < 10; i++)
            printchars(c.render(i, 2));
        for (int i = 0; i < 10; i++)
            printchars(c.render(i, 4));
    }

    private static void printchars(char[][] render) {
        for (int i = 0; i < render.length; i++) {
            for (int j = 0; j < render[i].length; j++) {
                System.out.print(render[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public char[][] render(int value, int size) {
        // populate horizontals
        boolean[] hsegments = getSegmentsFor(value, SegmentType.HORIZONTAL);
        // populate left
        boolean[] lsegments = getSegmentsFor(value, SegmentType.LEFT);
        // populate right
        boolean[] rsegments = getSegmentsFor(value, SegmentType.RIGHT);
        char[][] digit = new char[(2 * size) + 3][size + 2];
        // iterate over each of the (2 * size) + 3 rows
        for (int i = 0; i < (2 * size) + 3; i++) {
            for (int j = 0; j <= digit[i].length - 1; j++) {
                digit[i][j] = ' ';
            }
            // row is horizontal at 0, (1 * size) + 2 and (2 * size) + 3
            if ((i == 0 && hsegments[0]) || (i == size + 1 && hsegments[1]) || (i == (2 * size) + 2 && hsegments[2])) {
                for (int j = 1; j <= size; j++) {
                    digit[i][j] = '-';
                }
            }
            // top half segments not accounted for in horizontal
            else if (i < size + 1 && i != 0) {
                if (lsegments[0])
                    digit[i][0] = '|';
                else
                    digit[i][0] = ' ';
                if (rsegments[0])
                    digit[i][digit[i].length - 1] = '|';
                else
                    digit[i][digit[i].length - 1] = ' ';
                for (int j = 1; j < digit[i].length - 1; j++) {
                    digit[i][j] = ' ';
                }
            } else if (i >= size + 2 && i != (2 * size) + 2) {
                if (lsegments[1])
                    digit[i][0] = '|';
                else
                    digit[i][0] = ' ';
                if (rsegments[1])
                    digit[i][digit[i].length - 1] = '|';
                else
                    digit[i][digit[i].length - 1] = ' ';
                for (int j = 1; j < digit[i].length - 1; j++) {
                    digit[i][j] = ' ';
                }
            }
        }
        return digit;
    }

    private boolean[] getSegmentsFor(int i, SegmentType type) {
        switch (i) {
        case 0:
            return Digit.ZERO.getSegments(type);
        case 1:
            return Digit.ONE.getSegments(type);
        case 2:
            return Digit.TWO.getSegments(type);
        case 3:
            return Digit.THREE.getSegments(type);
        case 4:
            return Digit.FOUR.getSegments(type);
        case 5:
            return Digit.FIVE.getSegments(type);
        case 6:
            return Digit.SIX.getSegments(type);
        case 7:
            return Digit.SEVEN.getSegments(type);
        case 8:
            return Digit.EIGHT.getSegments(type);
        case 9:
            return Digit.NINE.getSegments(type);
        default:
            return null;
        }
    }

    enum Digit {
        // {top, middle, bottom}, {top right, bottom right}, {bottom left, top left}
        ZERO(new boolean[] { true, false, true },
            new boolean[] { true, true },
            new boolean[] { true, true }),
        ONE(new boolean[] { false, false, false },
            new boolean[] { false, false },
            new boolean[] { true, true }),
        TWO(new boolean[] { true, true, true },
            new boolean[] { false, true },
            new boolean[] { true, false }),
        THREE(new boolean[] { true, true, true },
            new boolean[] { false, false },
            new boolean[] { true, true }),
        FOUR(new boolean[] { false, true, false },
            new boolean[] { true, false },
            new boolean[] { true, true }),
        FIVE(new boolean[] { true, true, true },
            new boolean[] { true, false },
            new boolean[] { false, true }),
        SIX(new boolean[] { true, true, true },
            new boolean[] { true, true },
            new boolean[] { false, true }),
        SEVEN(new boolean[] { true, false, false },
            new boolean[] { false, false },
            new boolean[] { true, true }),
        EIGHT(new boolean[] { true, true, true },
            new boolean[] { true, true },
            new boolean[] { true, true }),
        NINE(new boolean[] { true, true, true },
            new boolean[] { true, false },
            new boolean[] { true, true });
        private boolean[] iSegments;
        private boolean[] jLSegments;
        private boolean[] jRSegments;

        Digit(boolean[] iSegments, boolean[] jLSegments, boolean[] jRSegments) {
            this.iSegments = iSegments;
            this.jLSegments = jLSegments;
            this.jRSegments = jRSegments;
        }

        boolean[] getSegments(SegmentType type) {
            switch (type) {
            case HORIZONTAL:
                return iSegments;
            case LEFT:
                return jLSegments;
            case RIGHT:
                return jRSegments;
            }
            return null;
        }
    }

    enum SegmentType {
        HORIZONTAL, LEFT, RIGHT
    };
}
