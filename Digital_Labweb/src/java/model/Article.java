/*
* Article.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Article.<br>
 *
 * <pre>
 * Class describe object Article
 * In this class, we will perform the following processing
 *
 * . GetId.
 * . SetId.
 * . GetTitle.
 * . SetTile.
 * . GetImages.
 * . SetImages.
 * . GetContent.
 * . SetContent.
 * . GetDate.
 * . SetDate.
 * . GetAuthor.
 * . SetAuthor.
 * . GetDescription.
 * . SetDescription.
 * . ToString.
 *
 * </pre>
 *
 * @author Hoang Viet
 * @version 1.0
 */
public class Article {

    /**
     * Store id.<br>
     */
    private int id;
    /**
     * Store title.<br>
     */
    private String title;
    /**
     * Store images.<br>
     */
    private String images;
    /**
     * Store content.<br>
     */
    private String content;
    /**
     * Store date.<br>
     */
    private Date date;
    /**
     * Store author.<br>
     */
    private String author;
    /**
     * Store description.<br>
     */
    private String description;

    /**
     * Constructor.<br>
     */
    public Article() {
    }

    /**
     * Constructor full parameter<br>
     *
     * @param id
     * @param title
     * @param images
     * @param content
     * @param date
     * @param author
     */
    public Article(int id, String title, String images, String content, Date date, String author) {
        this.id = id;
        this.title = title;
        this.images = images;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    /**
     * Get id.<br>
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.<br>
     *
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get title.<br>
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title.<br>
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get image.<br>
     *
     * @return image
     */
    public String getImages() {
        return images;
    }

    /**
     * Set image.<br>
     *
     * @param images
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * Get image.<br>
     *
     * @return image
     */
    public String getContent() {
        return content;
    }

    /**
     * Set image.<br>
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get date and format date.<br>
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set date.<br>
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get author.<br>
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author.<br>
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get description.<br>
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.<br>
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get dateFormat.<br>
     *
     * @return ateFormat
     */
    public String getDateFormat() {
        return new SimpleDateFormat("MMMM dd yyy '-' HH:mmaaa").format(this.date).toLowerCase();
    }

    /**
     * Get SynopsisContent.<br>
     *
     * @return SynopsisContent
     */
    public String getSynopsisContent() {
        return content.substring(0, 200) + "...";
    }
}
