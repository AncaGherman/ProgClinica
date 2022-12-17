package obiectesiclase;

//import org.w3c.dom.ls.LSOutput;

public class ProgClinica {
    public static void main(String[] args) {
        Patient p = new Patient("2681111120712","Anca",167,68f);
        //setH(168);
        Patient p2= new Patient("2681111120772","Anca",167,68);

        //Patient p3 = p2; // nu e copie, nu e clona, e doar o alta referinta spre acelasi obicet

        Patient p3 = p2.clone();

        System.out.println(p3.toString());

        if (p.equals(p2))
            System.out.println("Sunt egale");
        else
            System.out.println("Sunt diferite");

        float val = p.calcBMI();
        System.out.println("Yo have BMI = "+val);
        String health = Patient.evaluateBMI(val);
        System.out.println("You have "+health+" !!!");
    }
}
