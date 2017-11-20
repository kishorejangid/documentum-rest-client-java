/*
 * Copyright (c) 2018. OPEN TEXT Corporation. All Rights Reserved.
 */
package com.emc.documentum.rest.client.sample.model.xml.jaxb;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

import com.emc.documentum.rest.client.sample.client.util.Equals;
import com.emc.documentum.rest.client.sample.model.Author;
import com.emc.documentum.rest.client.sample.model.Entry;
import com.emc.documentum.rest.client.sample.model.FeedBase;
import com.emc.documentum.rest.client.sample.model.Linkable;
import com.emc.documentum.rest.client.sample.model.xml.XMLNamespace;

public abstract class JaxbFeedBase<T extends Linkable, E extends Entry<T>> extends JaxbAtomLinkableBase implements FeedBase<T, E> {
    private String id;
    private String title;
    private String updated;
    private String summary;
    private Integer page;
    private Integer itemsPerPage;
    private Integer total;
    private List<Author> authors;
    
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    } 

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    @XmlElement(name="author", type=JaxbAuthor.class)
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    @XmlElement(namespace=XMLNamespace.DM_NAMESPACE)
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    @XmlElement(name="items-per-page")
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @Override
    @XmlElement(namespace=XMLNamespace.DM_NAMESPACE)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        JaxbFeedBase that = (JaxbFeedBase)obj;
        return Equals.equal(id, that.id) 
            && Equals.equal(title, that.title)
            && Equals.equal(updated, that.updated)
            && Equals.equal(summary, that.summary)
            && Equals.equal(page, that.page)
            && Equals.equal(itemsPerPage, that.itemsPerPage)
            && Equals.equal(total, that.total)
            && Equals.equal(authors, that.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, updated, summary, page, itemsPerPage, total);
    }
}
