package com.capstone.rideitout.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "time_stamp")
    private String timeStamp;

//    @Column(name = "sender_id")
//    private long senderID;

//    @Column(name = "receiver_id")
//    private String receiverId;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Users receiver;

    public Message() {
    }

    public Message(String content, String timeStamp, long senderID, String receiverId) {
        this.content = content;
        this.timeStamp = timeStamp;
//        this.senderID = senderID;
//        this.receiverId = receiverId;
    }

//    public String getReceiverId() {
//        return receiverId;
//    }
//
//    public void setReceiverId(String receiverId) {
//        this.receiverId = receiverId;
//    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
//                ", senderID=" + senderID +
//                ", receiverId='" + receiverId + '\'' +
                '}';
    }
}
