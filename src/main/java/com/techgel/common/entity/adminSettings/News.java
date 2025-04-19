package com.techgel.common.entity.adminSettings;

import com.techgel.common.entity.BasedEntity;
import com.techgel.common.entity.enums.NewsType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News extends BasedEntity {
    private String title_vi;
    private String title_en;
    @Enumerated(EnumType.STRING)
    private NewsType type;
    private String summary_vi;
    private String summary_en;
    @Lob
    private String content_vi;
    @Lob
    private String content_en;
    private String image_url;


    public News(Long id, String title_vi, String title_en, NewsType type, String summary_vi, String summary_en, String content_vi, String content_en, String image_url) {
        super(id);
        this.title_vi = title_vi;
        this.title_en = title_en;
        this.type = type;
        this.summary_vi = summary_vi;
        this.summary_en = summary_en;
        this.content_vi = content_vi;
        this.content_en = content_en;
        this.image_url = image_url;
    }
}
