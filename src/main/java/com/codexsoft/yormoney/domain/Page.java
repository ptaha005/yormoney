package com.codexsoft.yormoney.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "page")
public class Page extends DomainObject {

	/** Serial Version UID. */
	private static final long serialVersionUID = -558999685L;

    transient public static final String[] colsPosition = {"id", "description"};

    @Column
    private String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
	private List<Banner> banners;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    private List<Manual> manuals;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "page")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    private List<Video> videos;

    @Column( length = 60  )
	private String description;

    @URL
    @Column( length = 60  )
	private String url;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Manual> getManuals() {
        return manuals;
    }

    public void setManuals(List<Manual> manuals) {
        this.manuals = manuals;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
