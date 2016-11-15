package pc;

class Challenge6 {

    private int[] registers = new int[10];
    private int[] ram = new int[1000];
    private int steps = 0;
    private int pointer;

    Challenge6(int[] instructions) {
        for (int i = 0; i < instructions.length; i++) {
            ram[i] = instructions[i];
        }
    }

    int processInstructions() {
        this.steps = 0;
        this.pointer = 0;
        boolean rc = true;
        while (rc) {
            rc = processInstruction(ram[this.pointer]);
            steps++;
        }
        return this.steps;
    }

    boolean processInstruction(int value) {
        int digit2 = value % 10;
        int digit1 = (value / 10) % 10;
        int digit0 = (value / 100) % 10;
        switch (digit0) {
        case 1:
            if (digit1 == 0 && digit2 == 0)
                return false;
            return true;
        case 2:
            this.registers[digit1] = (digit2) % 1000;
            break;
        case 3:
            this.registers[digit1] = (this.registers[digit1] + digit2) % 1000;
            break;
        case 4:
            this.registers[digit1] = (this.registers[digit1] * digit2) % 1000;
            break;
        case 5:
            this.registers[digit1] = (this.registers[digit2]) % 1000;
            break;
        case 6:
            this.registers[digit1] = (this.registers[digit1] + this.registers[digit2]) % 1000;
            break;
        case 7:
            this.registers[digit1] = (this.registers[digit1] * this.registers[digit2]) % 1000;
            break;
        case 8:
            this.registers[digit1] = (this.ram[digit2]) % 1000;
            break;
        case 9:
            this.ram[digit2] = (this.registers[digit1]) % 1000;
            break;
        case 0:
            if (this.registers[digit2] != 0) {
                this.pointer = this.registers[digit1];
                return true;
            } else
                break;
        default:
            break;
        }
        this.pointer++;
        return true;
    }

    public int getRamValue(int location) {
        return this.ram[location];
    }

    public int getRegisterValue(int location) {
        return this.registers[location];
    }

    public static void main(String[] args) {
        Challenge6 c = new Challenge6(
                new int[] { 299, 492, 495, 399, 492, 495, 399, 283, 279, 689, 78, 100, 000, 000, 000 });
        System.out.println(c.processInstructions());
    }
}
