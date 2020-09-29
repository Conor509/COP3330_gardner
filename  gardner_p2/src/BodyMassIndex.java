public class BodyMassIndex {
    public double weight, height, bmi;

    public BodyMassIndex(double height, double weight) {
        this.weight = weight;
        this.height = height;
        this.bmi = 0;
    }


    public double calculateBMI() {
        if(height == 0) throw new IllegalStateException("Height can not be zero.");
        return (weight * 703) / (height * height);
    }

    public String printBMIResult() {
        bmi = calculateBMI();

        String category;
        if(bmi <= 18.5) {
            category = "Underweight";
        } else if(bmi < 25) {
            category = "Normal weight";
        } else if(bmi < 30) {
            category = "Overweight";
        } else if (bmi >= 30){
            category = "Obese";
        }else category = "Undefined";

        System.out.printf("Your BMI is %.1f (%s)\n", bmi, category);

        return category;
    }

    public double getInfo() {
        return this.bmi;
    }

}
