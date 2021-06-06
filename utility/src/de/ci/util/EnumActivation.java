package de.ci.util;

public enum EnumActivation
{
    FERMI,RELU,TANH,SOFTPLUS,GAUSS,NONE;


    public static double activation(EnumActivation type, double data){
        return switch (type) {
            case FERMI -> fermi(data);
            case RELU -> relu(data);
            case TANH -> tanh(data);
            case SOFTPLUS -> softplus(data);
            case GAUSS -> gauss(data);
            case NONE -> data;
        };
    }

    public static double activationDeriv(EnumActivation type, double data){
        return switch (type) {
            case FERMI -> fermi_deriv(data);
            case RELU -> relu_deriv(data);
            case TANH -> tanh_deriv(data);
            case SOFTPLUS -> softplus_deriv(data);
            case GAUSS -> gauss_deriv(data);
            case NONE -> 1;
        };
    }

    private static double fermi(double data) {
        return 1D / (1D + Math.exp(-data));
    }

    private static double tanh(double data) {
        return Math.tanh(data);
    }

    private static double relu(double data) {
        return Math.max(0,data);
    }

    private static double softplus(double data) {
        return  Math.log(1D +Math.exp(data));
    }

    private static double gauss(double data) {
        return  Math.exp(data);
    }

    private static double fermi_deriv(double data) {
        return fermi(data) * (1 - fermi(data));
    }

    private static double tanh_deriv(double data) {
        return data != 0 ? Math.cosh(data)/Math.sinh(data): 1;
    }

    private static double relu_deriv(double data) {
        return data > 0 ? data : 0;
    }

    private static double softplus_deriv(double data) {
        return Math.exp(data)/(1D+Math.exp(data));
    }

    private static double gauss_deriv(double data) {
        return fermi(data) * (1 - fermi(data)); // TODO: Implement
    }
}
