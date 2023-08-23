package com.capstone.rideitout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "score")
    private int score;

    @Column(name = "car_id")
    private long carId;

//    @Column(name = "user_id")
//    private long userId;

    @Column(name = "time_stamp")
    private String timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Rating() {
    }

    public Rating(long id, String content, int score, long carId, long userId, String timeStamp) {
        this.id = id;
        this.content = content;
        this.score = score;
        this.carId = carId;
//        this.userId = userId;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ratings{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", carId=" + carId +
//                ", userId=" + userId +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
