package com.techgel.admin.validator;

import com.techgel.common.entity.adminSettings.SEO;
import com.techgel.common.service.SEOService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UniqueSlugValidator implements ConstraintValidator<UniqueSlug, String> {
    @Autowired
    private SEOService seoService;

    private String idField;
    private String langField;

    public UniqueSlugValidator() {}

    @Override
    public void initialize(UniqueSlug unique){
        idField = unique.idField();
        langField = unique.langField();
    }

    @Override
    public boolean isValid(String slug, ConstraintValidatorContext context) {
        if (slug == null || slug.equals("")) return true;

        try{
            if(seoService != null){
                SEO seo;
                ServletRequestAttributes attributes = (ServletRequestAttributes)
                        RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                String currentId = request.getParameter("seo.id");
                if(langField.equals("vi")){
                    seo = seoService.getBySeoSlugVi(slug);
                    if(seo == null) return true;
                    return !seoService.checkSeoSlugViUnique(seo.getSeo_slug_vi().trim(), Long.valueOf(currentId));
                }else{
                    seo = seoService.getBySeoSlugEn(slug);
                    if(seo == null) return true;
                    return !seoService.checkSeoSlugEnUnique(seo.getSeo_slug_en().trim(), Long.valueOf(currentId));
                }
            }
        }catch(Exception e){
            return true;
        }

        return true;
    }
}
