package com.ykhamiakou.beans;

import java.io.Serializable;

/**
 * Some user's message
 */
public class Message implements Serializable {
    /**
     * Constants
     */
    private static final int NO_ID = -1;
    /**
     * Serial version
     */
    private static final long serialVersionUID = 1L;

    /**
     * Fields
     */
    private int id;
    private User owner;
    private String text;

    /**
     * Constructor with args
     *
     * @param id    - message id
     * @param owner - message owner
     * @param text  - message text
     */
    public Message(int id, User owner, String text) {
        this.id = id;
        this.owner = owner;
        this.text = text;
    }

    /**
     * Constructor without id
     *
     * @param owner - message owner
     * @param text  - message text
     */
    public Message(User owner, String text) {
        this.id = Message.NO_ID;
        this.owner = owner;
        this.text = text;
    }

    /**
     * @return message id to return
     */
    public int getId() {
        return id;
    }

    /**
     * @param id - message id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return owner to return
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner - message owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * @return message text to return
     */
    public String getText() {
        return text;
    }

    /**
     * @param text - message text to set
     */
    public void setText(String text) {
        this.text = text;
    }
}
