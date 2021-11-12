package com.example.so69898042;

import java.util.UUID;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@NamedNativeQuery(name = "CustomerEntity.findOnlyNameAndPhoneFromCustomer",
    query = "select customer_name, customer_email from customer",
    resultSetMapping = "nativeMapping")

@SqlResultSetMappings(value = {
    @SqlResultSetMapping(name = "nativeMapping",
        classes = @ConstructorResult(
            columns = { @ColumnResult(name = "customer_name"), @ColumnResult(name = "customer_email") },
            targetClass = CustomerEntity.class)) })
@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity {
    public CustomerEntity() {
    }

    public CustomerEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //getter and setter fields
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "address")
    private String adddress;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    @Column(columnDefinition = "VARCHAR(36)", name = "customer_guid")
    @Type(type = "uuid-char")
    private UUID guid;
    //    @Embedded
    //    private AuditFields audit;
}
