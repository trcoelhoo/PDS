public class Jeep implements Product {
    private String code;
    private String description;
    private double points;
    private OldJeep oldJeep;

    public Jeep(OldJeep oldJeep) {
        this.oldJeep = oldJeep;
        String data= oldJeep.getData();
        String[] dataSplit = data.split(";");
        this.code = dataSplit[0];
        this.description = dataSplit[1];
        this.points = Double.parseDouble(dataSplit[2]);
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public double points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Jeep [code=" + code + ", description=" + description + ", points=" + points + "]";
    }

    
}
