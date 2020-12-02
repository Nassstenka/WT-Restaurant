package model.beans;

import java.util.Objects;

public class Payment {
    private long clientID;
    private long adminID;
    private double cost;
    private boolean isPaid;

    public Payment() {
    }

    public Payment(long clientID, long adminID, double cost, boolean isPaid) {
        this.clientID = clientID;
        this.adminID = adminID;
        this.cost = cost;
        this.isPaid = isPaid;
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getAdminID() {
        return adminID;
    }

    public void setAdminID(long adminID) {
        this.adminID = adminID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return clientID == payment.clientID &&
                adminID == payment.adminID &&
                Double.compare(payment.cost, cost) == 0 &&
                isPaid == payment.isPaid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, adminID, cost, isPaid);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "clientID=" + clientID +
                ", adminID=" + adminID +
                ", cost=" + cost +
                ", isPaid=" + isPaid +
                '}';
    }
}
