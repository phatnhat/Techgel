package com.techgel.admin.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueSlugValidator.class})
public @interface UniqueSlug {
    String message() default "Giá trị đã tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String idField() default "id";
    String langField();
}