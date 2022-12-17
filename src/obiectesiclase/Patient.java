package obiectesiclase;

import java.util.Objects;

public class Patient {
    String cnp;
    String name;
    int h;
    float w;

    Patient(String cnp, String name, int h, float w) {
        this.cnp = cnp;
        this.name = name;
        this.h = h;
        this.w = w;
    }

    public Patient() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public float calcBMI() {
        float bmi = (100 * 100 * w) / (h * h);
        return bmi;
    }

    static String evaluateBMI(float bmi) {
        String result;
        if (bmi < 18.5)
            result = "underweight";
        else if (bmi < 25)
            result = "healthy weight";
        else if (bmi < 30)
            result = "overweight";
        else result = "obese";
        return result;
    }

    @Override   //adnotare
    public String toString() {
        return "Patient{" +
                "cnp='" + cnp + '\'' +
                "name='" + name + '\'' +
                ", h=" + h +
                ", w=" + w +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return cnp.equals(patient.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    //shalow clone:
//    //public Patient clone() throws CloneNotSupportedException {
//        return (Patient)super.clone();
//    }

    public Patient clone() {
        Patient p = new Patient();
        p.setCnp(this.cnp);
        p.setName(this.name);
        p.setH(this.h);
        p.setW(this.w);
        return p;
    }
}

