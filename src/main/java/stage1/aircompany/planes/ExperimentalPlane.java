package stage1.aircompany.planes;

import stage1.aircompany.models.ClassificationLevel;
import stage1.aircompany.models.ExperimentalTypes;

public class ExperimentalPlane extends AbstractPlane {

    private ExperimentalTypes type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(
        String model,
        int maxSpeed,
        int maxFlightDistance,
        int maxLoadCapacity,
        ExperimentalTypes type,
        ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" + "model='" + model + '\'' + '}';
    }
}
