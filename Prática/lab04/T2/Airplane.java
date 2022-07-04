package lab03;



public class Airplane {
    int linesTourist;
    int rowsTourist;

    int linesExec;
    int rowsExec;

    int totalSeats;


    public Airplane(int linesExec, int rowsExec, int linesTourist, int rowsTourist){ //in case the airplane has executive class
        this.linesExec=linesExec;
        this.rowsExec=rowsExec;
        this.linesTourist=linesTourist;
        this.rowsTourist=rowsTourist;
    }

    public Airplane(int linesTourist, int rowsTourist) { //in case the airplane doesn't have executive class
        this.linesTourist = linesTourist;
        this.rowsTourist=rowsTourist;
        this.linesExec = 0;
        this.rowsExec = 0;
    }

    public int getLinesTourist() {
        return this.linesTourist;
    }

    public int getRowsTourist() {
        return this.rowsTourist;
    }

    public int getLinesExec() {
        return this.linesExec;
    }

    public int getRowsExec() {
        return this.rowsExec;
    }

    public int getTotalSeats() {
        return (linesExec*rowsExec+linesTourist*rowsTourist); //calculate the number of seats

    }

}
