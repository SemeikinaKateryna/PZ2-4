package pz4;

public class TypesOfRouters {
    int typeOfRouterID;
    String description;
    public TypesOfRouters(int typeOfRouterID, String description) {
        this.typeOfRouterID = typeOfRouterID;
        this.description = description;
    }
    @Override
    public String toString() {
        return "TypesOfRouters{" +
                "typeOfRouterID=" + typeOfRouterID +
                ", description='" + description + '\'' +
                '}';
    }
}
