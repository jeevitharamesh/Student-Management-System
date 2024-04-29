package com.skiply.skiply.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name="receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="Student_id",nullable = false)
    private Student student;


    @NotEmpty(message = "Card number cannot be null or empty")
    @Column(name="card_no")
    private String cardNo;

    @NotEmpty(message =  "Card type cannot be null or empty")
    @Column(name="card_type")
    private String cardType;

    @Positive(message = "Amount must be greater than 0")
    @Column(name="amount")
    private Double amount;


    public Receipt(){

    }
    public Receipt(Integer id, LocalDateTime dateTime, Student student, String cardNo, String cardType,Double amount) {
        this.id = id;
        this.dateTime = dateTime;
        this.student = student;
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
