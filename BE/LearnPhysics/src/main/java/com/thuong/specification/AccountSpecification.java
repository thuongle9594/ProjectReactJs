package com.thuong.specification;

import com.thuong.entity.Account;
import com.thuong.form.account.AccountFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {
    private static final String SEARCH_USERNAME = "username";
    private static final String SEARCH_COURSE_NAME = "courseName";
    public  static Specification<Account> buildWhere(AccountFilterForm form){
        if(form==null){
            return null;
        }
        SpecificationImpl whereUsername = new SpecificationImpl(SEARCH_USERNAME,form.getSearch());
        SpecificationImpl whereCourseName = new SpecificationImpl(SEARCH_COURSE_NAME,form.getSearch());
        return Specification.where(whereUsername.or(whereCourseName));

    }

    @AllArgsConstructor
    public  static class SpecificationImpl implements Specification<Account>{
        //tạo IN Class là SpecificationImpl để dùng luôn ở trên đây, k cần tạo ở ngoài
        private String key; //key giúp phân biệt minId maxId hay search
        private Object value;// để dạng Object để đáp ứng mọi loại kiểu dữ liệu truyền vào dạng waperclass

        @Override
        public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(value ==null){
                return null;//tránh null pointter exception ở value.toString() nếu value = null
            }
            switch (key){
                case SEARCH_USERNAME:
                    //WHERE username LIKE '%value%'
                    return criteriaBuilder.like(root.get("username"),"%"+value.toString()+"%");
                case SEARCH_COURSE_NAME:
                    //course.name LIKE '%value%'
                    return criteriaBuilder.like(root.get("course").get("name"),"%"+value.toString()+"%" );

                default:
                    return null;
            }
        }
    }
}
