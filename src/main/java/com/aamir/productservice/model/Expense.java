package com.aamir.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;


@Document("product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    private String id;
    @Field(value = "name")
    @Indexed(unique = true)
    private String expenseName;
    @Field(value = "category")
    private ExpenseCategory expenseCategory;
    @Field(value = "amount")
    private BigDecimal expenseAmount;

}
