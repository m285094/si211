public class RecogPDF extends RecogASCII {
    
    //make new target hex values that are for chars %PDF 
    private static int[] header = {0x25, 0x50, 0x44, 0x46};
    private int i = 0;

    public String getName() { return "PDF"; } // needs its own getName method

    public void feed(int nextByte) { // override for feed 
        if (getState() == 2) { // 2 : unkown
            if (header[i] >= 0 && nextByte != header[i])
            setState(0); // 0 : not match
        }
        i++;
        if (i > 3 && getState() != 0) // has value 3 instead of 10 bc header is 4 bytes long
            setState(1); // 1 : match
    }

    boolean decision() { return getState() == 1; } // and override for decision
}